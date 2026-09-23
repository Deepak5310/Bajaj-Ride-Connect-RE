package com.pulsar.ns400z.tbtbridge;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.Set;
import java.util.UUID;

/**
 * High-performance BLE GATT Manager for Bajaj Pulsar NS400Z digital instrument cluster.
 */
public class TbtBleDispatcher {

    private static final String TAG = "TbtBleDispatcher";
    public static final UUID SERVICE_UUID = UUID.fromString(TbtFrameBuilder.GATT_SERVICE_UUID);
    public static final UUID TBT_CHAR_UUID = UUID.fromString(TbtFrameBuilder.TBT_CHAR_UUID);

    public interface BleStateCallback {
        void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress);
        void onPacketSent(byte[] frame, boolean success);
    }

    private static TbtBleDispatcher instance;
    private final Context context;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothGatt bluetoothGatt;
    private BluetoothGattCharacteristic tbtCharacteristic;
    private boolean isConnected = false;
    private String connectedDeviceName = "";
    private String connectedDeviceAddress = "";
    private BleStateCallback callback;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private boolean isScanning = false;

    private TbtBleDispatcher(Context context) {
        this.context = context.getApplicationContext();
        BluetoothManager manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        if (manager != null) {
            this.bluetoothAdapter = manager.getAdapter();
        }
    }

    public static synchronized TbtBleDispatcher getInstance(Context context) {
        if (instance == null) {
            instance = new TbtBleDispatcher(context);
        }
        return instance;
    }

    public void setCallback(BleStateCallback callback) {
        this.callback = callback;
        if (callback != null) {
            callback.onConnectionStateChanged(isConnected && tbtCharacteristic != null, connectedDeviceName, connectedDeviceAddress);
        }
    }

    public boolean isConnected() {
        return isConnected && tbtCharacteristic != null;
    }

    public String getConnectedDeviceName() {
        return connectedDeviceName;
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

    @SuppressLint("MissingPermission")
    public void startScanOrConnect() {
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            Log.e(TAG, "Bluetooth not enabled");
            return;
        }

        // 1. Check if bike is already paired in Android Bluetooth settings
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        if (pairedDevices != null) {
            for (BluetoothDevice device : pairedDevices) {
                String name = device.getName();
                if (isMatchingClusterName(name)) {
                    Log.i(TAG, "Found paired Pulsar cluster: " + name + " [" + device.getAddress() + "]");
                    connect(device.getAddress());
                    return;
                }
            }
        }

        // 2. Scan for BLE advertisement
        BluetoothLeScanner scanner = bluetoothAdapter.getBluetoothLeScanner();
        if (scanner != null && !isScanning) {
            isScanning = true;
            Log.i(TAG, "Starting BLE scan for Pulsar cluster...");
            scanner.startScan(scanCallback);
            mainHandler.postDelayed(this::stopScan, 20000);
        }
    }

    @SuppressLint("MissingPermission")
    public void stopScan() {
        if (isScanning && bluetoothAdapter != null) {
            BluetoothLeScanner scanner = bluetoothAdapter.getBluetoothLeScanner();
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
            if (isMatchingClusterName(name)) {
                Log.i(TAG, "Discovered Pulsar device in scan: " + name + " [" + device.getAddress() + "] -> Connecting");
                stopScan();
                connect(device.getAddress());
            }
        }
    };

    @SuppressLint("MissingPermission")
    public void connect(String deviceAddress) {
        if (bluetoothAdapter == null) return;
        try {
            BluetoothDevice device = bluetoothAdapter.getRemoteDevice(deviceAddress);
            connectedDeviceName = device.getName() != null ? device.getName() : "PULSAR Cluster";
            connectedDeviceAddress = deviceAddress;
            Log.i(TAG, "Connecting directly to GATT at " + deviceAddress + " (" + connectedDeviceName + ")");
            if (bluetoothGatt != null) {
                try {
                    bluetoothGatt.disconnect();
                    bluetoothGatt.close();
                } catch (Exception ignored) {}
                bluetoothGatt = null;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                bluetoothGatt = device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE);
            } else {
                bluetoothGatt = device.connectGatt(context, false, gattCallback);
            }
        } catch (Exception e) {
            Log.e(TAG, "Connect error: " + e.getMessage());
        }
    }

    @SuppressLint("MissingPermission")
    public boolean sendTbtFrame(byte[] frame) {
        if (!isConnected || bluetoothGatt == null || tbtCharacteristic == null) {
            Log.w(TAG, "Cannot send TBT frame: Cluster not connected.");
            if (callback != null) {
                mainHandler.post(() -> callback.onPacketSent(frame, false));
            }
            return false;
        }

        tbtCharacteristic.setValue(frame);
        tbtCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        boolean success = bluetoothGatt.writeCharacteristic(tbtCharacteristic);
        Log.d(TAG, "Dispatched TBT frame (len=" + frame.length + ") -> success=" + success);
        if (callback != null) {
            mainHandler.post(() -> callback.onPacketSent(frame, success));
        }
        return success;
    }

    private boolean autoReconnect = true;
    private final Runnable reconnectRunnable = new Runnable() {
        @Override
        public void run() {
            if (!isConnected && autoReconnect) {
                Log.i(TAG, "Auto-reconnecting to NS400Z cluster...");
                startScanOrConnect();
            }
        }
    };

    public void setAutoReconnect(boolean enabled) {
        this.autoReconnect = enabled;
        if (!enabled) {
            mainHandler.removeCallbacks(reconnectRunnable);
        }
    }

    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @SuppressLint("MissingPermission")
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            Log.i(TAG, "onConnectionStateChange: status=" + status + ", newState=" + newState);
            if (newState == BluetoothProfile.STATE_CONNECTED && status == BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "Connected to NS400Z GATT Server. Requesting MTU 247...");
                isConnected = true;
                mainHandler.removeCallbacks(reconnectRunnable);
                if (callback != null) {
                    mainHandler.post(() -> callback.onConnectionStateChanged(true, connectedDeviceName, connectedDeviceAddress));
                }
                if (!gatt.requestMtu(247)) {
                    Log.i(TAG, "MTU request failed to initiate; discovering services directly...");
                    gatt.discoverServices();
                }
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED || status != BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "Disconnected from NS400Z (status=" + status + ").");
                isConnected = false;
                tbtCharacteristic = null;
                if (bluetoothGatt != null) {
                    try {
                        bluetoothGatt.close();
                    } catch (Exception ignored) {}
                    bluetoothGatt = null;
                }
                if (callback != null) {
                    mainHandler.post(() -> callback.onConnectionStateChanged(false, connectedDeviceName, connectedDeviceAddress));
                }
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

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "GATT Services discovered for " + connectedDeviceName);
                BluetoothGattService service = gatt.getService(SERVICE_UUID);
                if (service != null) {
                    tbtCharacteristic = service.getCharacteristic(TBT_CHAR_UUID);
                    Log.i(TAG, "Discovered NS400Z TBT Characteristic (" + TBT_CHAR_UUID + ") -> " + (tbtCharacteristic != null ? "READY" : "MISSING"));
                    if (callback != null) {
                        mainHandler.post(() -> callback.onConnectionStateChanged(isConnected && tbtCharacteristic != null, connectedDeviceName, connectedDeviceAddress));
                    }
                } else {
                    Log.e(TAG, "Service " + SERVICE_UUID + " not found!");
                }
            }
        }
    };
}
