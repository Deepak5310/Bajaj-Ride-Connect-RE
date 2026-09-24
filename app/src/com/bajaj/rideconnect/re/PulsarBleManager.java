package com.bajaj.rideconnect.re;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattConnectionSettings;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothStatusCodes;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Enterprise-grade BLE GATT Engine for Bajaj Pulsar NS400Z motorcycle cluster.
 * Manages reliable connection, MTU negotiation, CCCD subscriptions, and serialized GATT write queues.
 */
public class PulsarBleManager {

    private static final String TAG = "PulsarBleManager";

    public static final UUID SERVICE_UUID = UUID.fromString(PulsarProtocol.SERVICE_UUID);
    public static final UUID CHAR_TELEMETRY_UUID = UUID.fromString(PulsarProtocol.CHAR_TELEMETRY_UUID);
    public static final UUID CHAR_MEDIA_UUID = UUID.fromString(PulsarProtocol.CHAR_MEDIA_UUID);
    public static final UUID CHAR_CONTROLS_UUID = UUID.fromString(PulsarProtocol.CHAR_CONTROLS_UUID);
    public static final UUID CCCD_UUID = UUID.fromString(PulsarProtocol.CCCD_DESCRIPTOR_UUID);

    public interface BleListener {
        void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress);
        void onPacketSent(String charUuid, byte[] frame, boolean success);
        void onHandlebarEvent(PulsarProtocol.HandlebarEvent event);
    }

    private static PulsarBleManager instance;
    private final Context context;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothGatt bluetoothGatt;

    private BluetoothGattCharacteristic charTelemetry;
    private BluetoothGattCharacteristic charMedia;
    private BluetoothGattCharacteristic charControls;

    private boolean isConnected = false;
    private boolean isConnecting = false;
    private String connectedDeviceName = "";
    private String connectedDeviceAddress = "";
    private final List<BleListener> listeners = new CopyOnWriteArrayList<>();

    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private boolean isScanning = false;
    private boolean autoReconnect = true;
    private byte telemetrySeq = 0;

    // Serialized GATT Write Queue to avoid Android BLE write collisions
    private static class GattWriteTask {
        final BluetoothGattCharacteristic characteristic;
        final byte[] data;
        final int writeType;

        GattWriteTask(BluetoothGattCharacteristic characteristic, byte[] data, int writeType) {
            this.characteristic = characteristic;
            this.data = data;
            this.writeType = writeType;
        }
    }
    private final Queue<GattWriteTask> writeQueue = new LinkedList<>();
    private boolean isWriting = false;
    private GattWriteTask currentTask;

    private final Runnable reconnectRunnable = new Runnable() {
        @Override
        public void run() {
            if (!isConnected && autoReconnect) {
                Log.i(TAG, "Triggering automatic cluster reconnect...");
                startScanOrConnect();
            }
        }
    };

    private PulsarBleManager(Context context) {
        this.context = context.getApplicationContext();
        BluetoothManager manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        if (manager != null) {
            this.bluetoothAdapter = manager.getAdapter();
        }
    }

    public static synchronized PulsarBleManager getInstance(Context context) {
        if (instance == null) {
            instance = new PulsarBleManager(context);
        }
        return instance;
    }

    public void addListener(BleListener listener) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener);
            listener.onConnectionStateChanged(isConnected, connectedDeviceName, connectedDeviceAddress);
        }
    }

    public void removeListener(BleListener listener) {
        listeners.remove(listener);
    }

    private void notifyConnectionState(boolean connected, String name, String addr) {
        mainHandler.post(() -> {
            for (BleListener l : listeners) {
                l.onConnectionStateChanged(connected, name, addr);
            }
        });
    }

    private void notifyPacketSent(String charUuid, byte[] frame, boolean success) {
        mainHandler.post(() -> {
            for (BleListener l : listeners) {
                l.onPacketSent(charUuid, frame, success);
            }
        });
    }

    private void notifyHandlebarEvent(PulsarProtocol.HandlebarEvent event) {
        mainHandler.post(() -> {
            for (BleListener l : listeners) {
                l.onHandlebarEvent(event);
            }
        });
    }

    public boolean isConnected() {
        return isConnected && charTelemetry != null;
    }

    public String getConnectedDeviceName() {
        return connectedDeviceName;
    }

    public String getConnectedDeviceAddress() {
        return connectedDeviceAddress;
    }

    public void setAutoReconnect(boolean enabled) {
        this.autoReconnect = enabled;
        if (!enabled) {
            mainHandler.removeCallbacks(reconnectRunnable);
        }
    }

    private boolean isMatchingClusterName(String name) {
        if (name == null) return false;
        String upper = name.toUpperCase();
        return upper.contains("PULSAR") ||
               upper.contains("NS400") ||
               upper.contains("BAJAJ") ||
               upper.contains("OTC") ||
               upper.contains("CLUSTER") ||
               upper.contains("DOMINAR") ||
               upper.contains("CHETAK");
    }

    private BluetoothAdapter getAdapter() {
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            BluetoothManager manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
            if (manager != null) {
                this.bluetoothAdapter = manager.getAdapter();
            }
        }
        return bluetoothAdapter;
    }

    @SuppressLint("MissingPermission")
    public void startScanOrConnect() {
        BluetoothAdapter adapter = getAdapter();
        if (adapter == null || !adapter.isEnabled()) {
            Log.e(TAG, "Bluetooth not available or disabled.");
            return;
        }

        // 1. Direct connection to bonded devices
        Set<BluetoothDevice> paired = adapter.getBondedDevices();
        if (paired != null) {
            for (BluetoothDevice dev : paired) {
                String name = dev.getName();
                if (isMatchingClusterName(name)) {
                    Log.i(TAG, "Connecting to paired NS400Z cluster: " + name + " [" + dev.getAddress() + "]");
                    connect(dev.getAddress(), name);
                    return;
                }
            }
        }

        // 2. Start BLE Scanner
        BluetoothLeScanner scanner = adapter.getBluetoothLeScanner();
        if (scanner != null && !isScanning) {
            isScanning = true;
            Log.i(TAG, "Starting BLE scan for NS400Z peripheral...");
            scanner.startScan(scanCallback);
            mainHandler.postDelayed(this::stopScan, 20000);
        }
    }

    @SuppressLint("MissingPermission")
    public void stopScan() {
        BluetoothAdapter adapter = getAdapter();
        if (isScanning && adapter != null) {
            BluetoothLeScanner scanner = adapter.getBluetoothLeScanner();
            if (scanner != null) {
                scanner.stopScan(scanCallback);
            }
            isScanning = false;
        }
    }

    private final ScanCallback scanCallback = new ScanCallback() {
        @SuppressLint("MissingPermission")
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            BluetoothDevice device = result.getDevice();
            String name = device.getName();
            if ((name == null || name.isEmpty()) && result.getScanRecord() != null) {
                name = result.getScanRecord().getDeviceName();
            }
            if (isMatchingClusterName(name)) {
                Log.i(TAG, "Discovered Pulsar cluster in BLE scan: " + name + " [" + device.getAddress() + "]");
                stopScan();
                connect(device.getAddress(), name);
            }
        }
    };

    public void connect(String deviceAddress) {
        connect(deviceAddress, null);
    }

    @SuppressLint("MissingPermission")
    public void connect(String deviceAddress, String deviceName) {
        BluetoothAdapter adapter = getAdapter();
        if (adapter == null || deviceAddress == null) return;
        if (isConnected || isConnecting) {
            Log.d(TAG, "Already connected or connecting. Skipping duplicate connect request.");
            return;
        }

        try {
            isConnecting = true;
            BluetoothDevice device = adapter.getRemoteDevice(deviceAddress);
            if (deviceName != null && !deviceName.isEmpty()) {
                connectedDeviceName = deviceName;
            } else if (device.getName() != null && !device.getName().isEmpty()) {
                connectedDeviceName = device.getName();
            } else {
                connectedDeviceName = "";
            }
            connectedDeviceAddress = deviceAddress;
            Log.i(TAG, "Initiating direct GATT connection to " + deviceAddress + (connectedDeviceName.isEmpty() ? "" : " (" + connectedDeviceName + ")"));

            if (bluetoothGatt != null) {
                try {
                    bluetoothGatt.disconnect();
                    bluetoothGatt.close();
                } catch (Exception ignored) {}
                bluetoothGatt = null;
            }

            BluetoothGattConnectionSettings settings = new BluetoothGattConnectionSettings.Builder()
                    .setAutoConnectEnabled(false)
                    .setTransport(BluetoothDevice.TRANSPORT_LE)
                    .build();
            bluetoothGatt = device.connectGatt(settings, context.getMainExecutor(), gattCallback);
        } catch (Exception e) {
            isConnecting = false;
            Log.e(TAG, "Error connecting to GATT: " + e.getMessage());
        }
    }

    @SuppressLint("MissingPermission")
    public void disconnect() {
        autoReconnect = false;
        mainHandler.removeCallbacks(reconnectRunnable);
        if (isScanning) {
            stopScan();
        }
        if (bluetoothGatt != null) {
            try {
                bluetoothGatt.disconnect();
                bluetoothGatt.close();
            } catch (Exception ignored) {}
            bluetoothGatt = null;
        }
        isConnected = false;
        isConnecting = false;
        charTelemetry = null;
        charMedia = null;
        charControls = null;
        connectedDeviceName = "";
        connectedDeviceAddress = "";
        synchronized (writeQueue) {
            writeQueue.clear();
            isWriting = false;
        }
        notifyConnectionState(false, "", "");
    }

    // =========================================================================
    // GATT Frame Dispatchers
    // =========================================================================
    public boolean sendTelemetry(
            int batteryPercent,
            int signalBars,
            int callState,
            String callerNameOrNumber,
            int missedCalls,
            int unreadSms
    ) {
        if (charTelemetry == null || !isConnected) return false;
        telemetrySeq++;
        byte[] frame = PulsarProtocol.buildCompactTelemetryFrame(
                batteryPercent,
                signalBars,
                callState,
                callerNameOrNumber,
                missedCalls,
                unreadSms,
                telemetrySeq
        );
        enqueueWrite(charTelemetry, frame, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        return true;
    }

    public boolean sendMedia(String title, String artist, String album, int posSec, int durSec, int state) {
        if (charMedia == null || !isConnected) return false;
        byte[] frame = PulsarProtocol.buildMediaFrame(title, artist, album, posSec, durSec, state);
        enqueueWrite(charMedia, frame, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        return true;
    }

    @SuppressLint("MissingPermission")
    private void enqueueWrite(BluetoothGattCharacteristic characteristic, byte[] data, int writeType) {
        synchronized (writeQueue) {
            writeQueue.add(new GattWriteTask(characteristic, data, writeType));
            if (!isWriting) {
                processNextWrite();
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void processNextWrite() {
        synchronized (writeQueue) {
            if (writeQueue.isEmpty() || bluetoothGatt == null) {
                isWriting = false;
                return;
            }

            GattWriteTask task = writeQueue.poll();
            if (task == null) {
                isWriting = false;
                return;
            }

            isWriting = true;
            currentTask = task;
            int status = bluetoothGatt.writeCharacteristic(task.characteristic, task.data, task.writeType);
            boolean result = (status == BluetoothStatusCodes.SUCCESS);

            if (task.writeType == BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE || !result) {
                isWriting = false;
                currentTask = null;
                notifyPacketSent(task.characteristic.getUuid().toString(), task.data, result);
                // Continue queue on main loop
                mainHandler.post(this::processNextWrite);
            }
        }
    }

    // =========================================================================
    // BluetoothGattCallback
    // =========================================================================
    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @SuppressLint("MissingPermission")
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            Log.i(TAG, "onConnectionStateChange: status=" + status + ", newState=" + newState);
            isConnecting = false;

            if (newState == BluetoothProfile.STATE_CONNECTED && status == BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "Connected to NS400Z GATT Server. Negotiating MTU 247...");
                isConnected = true;
                mainHandler.removeCallbacks(reconnectRunnable);
                if (gatt.getDevice() != null) {
                    String gattName = gatt.getDevice().getName();
                    if (gattName != null && !gattName.isEmpty()) {
                        connectedDeviceName = gattName;
                    }
                }
                notifyConnectionState(true, connectedDeviceName, connectedDeviceAddress);

                if (!gatt.requestMtu(247)) {
                    Log.i(TAG, "MTU request declined; discovering services directly...");
                    gatt.discoverServices();
                }
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED || status != BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "Disconnected from NS400Z (status=" + status + ").");
                isConnected = false;
                charTelemetry = null;
                charMedia = null;
                charControls = null;

                if (bluetoothGatt != null) {
                    try {
                        bluetoothGatt.close();
                    } catch (Exception ignored) {}
                    bluetoothGatt = null;
                }

                connectedDeviceName = "";
                connectedDeviceAddress = "";
                notifyConnectionState(false, "", "");
                PulsarProtocol.resetHandlebarCounters();

                if (autoReconnect) {
                    mainHandler.removeCallbacks(reconnectRunnable);
                    mainHandler.postDelayed(reconnectRunnable, 3500);
                }
            }
        }

        @SuppressLint("MissingPermission")
        @Override
        public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
            Log.i(TAG, "onMtuChanged: mtu=" + mtu + ", status=" + status + " -> Discovering services...");
            gatt.discoverServices();
        }

        @SuppressLint("MissingPermission")
        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "GATT Services discovered for " + connectedDeviceName);
                BluetoothGattService service = gatt.getService(SERVICE_UUID);
                if (service != null) {
                    charTelemetry = service.getCharacteristic(CHAR_TELEMETRY_UUID);
                    charMedia = service.getCharacteristic(CHAR_MEDIA_UUID);
                    charControls = service.getCharacteristic(CHAR_CONTROLS_UUID);

                    Log.i(TAG, "GATT Characteristics bound: Telemetry=" + (charTelemetry != null) +
                            ", Media=" + (charMedia != null) +
                            ", Controls=" + (charControls != null));

                    // Subscribe to Handlebar Switch Notifications (0a10)
                    if (charControls != null) {
                        gatt.setCharacteristicNotification(charControls, true);
                        BluetoothGattDescriptor descriptor = charControls.getDescriptor(CCCD_UUID);
                        if (descriptor != null) {
                            gatt.writeDescriptor(descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            Log.i(TAG, "Subscribed to Handlebar controls CCCD notification.");
                        }
                    }

                    notifyConnectionState(isConnected && charTelemetry != null, connectedDeviceName, connectedDeviceAddress);
                } else {
                    Log.e(TAG, "Primary Service " + SERVICE_UUID + " not found!");
                }
            }
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            synchronized (writeQueue) {
                isWriting = false;
                byte[] data = currentTask != null ? currentTask.data : null;
                currentTask = null;
                notifyPacketSent(characteristic.getUuid().toString(), data, status == BluetoothGatt.GATT_SUCCESS);
                processNextWrite();
            }
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] value) {
            handleCharacteristicChanged(characteristic, value);
        }

        private void handleCharacteristicChanged(BluetoothGattCharacteristic characteristic, byte[] value) {
            if (characteristic == null || value == null) return;
            if (CHAR_CONTROLS_UUID.equals(characteristic.getUuid())) {
                PulsarProtocol.HandlebarEvent event = PulsarProtocol.parseHandlebarPacket(value);
                if (event != null) {
                    notifyHandlebarEvent(event);
                }
            }
        }
    };
}
