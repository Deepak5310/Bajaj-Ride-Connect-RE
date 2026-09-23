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
            callback.onConnectionStateChanged(isConnected, connectedDeviceName, connectedDeviceAddress);
        }
    }

    public boolean isConnected() {
        return isConnected && tbtCharacteristic != null;
    }

    public String getConnectedDeviceName() {
        return connectedDeviceName;
    }

    @SuppressLint("MissingPermission")
    public void startScanOrConnect() {
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            Log.e(TAG, "Bluetooth not enabled");
            return;
        }

        // 1. Check if bike is already paired
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        if (pairedDevices != null) {
            for (BluetoothDevice device : pairedDevices) {
                String name = device.getName();
                if (name != null && (name.contains("NS400") || name.contains("Pulsar") || name.contains("Bajaj") || name.contains("OTC") || name.contains("CLUSTER"))) {
                    Log.i(TAG, "Found paired NS400Z cluster: " + name + " [" + device.getAddress() + "]");
                    connect(device.getAddress());
                    return;
                }
            }
        }

        // 2. Scan for BLE advertisement
        BluetoothLeScanner scanner = bluetoothAdapter.getBluetoothLeScanner();
        if (scanner != null && !isScanning) {
            isScanning = true;
            Log.i(TAG, "Starting BLE scan for NS400Z cluster...");
            scanner.startScan(scanCallback);
            mainHandler.postDelayed(() -> stopScan(), 15000);
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
            if (name != null && (name.contains("NS400") || name.contains("Pulsar") || name.contains("Bajaj") || name.contains("OTC") || name.contains("CLUSTER"))) {
                Log.i(TAG, "Discovered NS400Z device in scan: " + name + " -> Connecting");
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
            connectedDeviceName = device.getName() != null ? device.getName() : "Pulsar NS400Z";
            connectedDeviceAddress = deviceAddress;
            Log.i(TAG, "Connecting to GATT at " + deviceAddress);
            if (bluetoothGatt != null) {
                bluetoothGatt.close();
            }
            bluetoothGatt = device.connectGatt(context, true, gattCallback);
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
        if (callback != null) {
            mainHandler.post(() -> callback.onPacketSent(frame, success));
        }
        return success;
    }

    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @SuppressLint("MissingPermission")
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                Log.i(TAG, "Connected to NS400Z GATT Server. Discovering services...");
                isConnected = true;
                gatt.discoverServices();
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                Log.i(TAG, "Disconnected from NS400Z.");
                isConnected = false;
                tbtCharacteristic = null;
                if (callback != null) {
                    mainHandler.post(() -> callback.onConnectionStateChanged(false, connectedDeviceName, connectedDeviceAddress));
                }
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                BluetoothGattService service = gatt.getService(SERVICE_UUID);
                if (service != null) {
                    tbtCharacteristic = service.getCharacteristic(TBT_CHAR_UUID);
                    Log.i(TAG, "Discovered NS400Z TBT Characteristic -> " + (tbtCharacteristic != null ? "READY" : "MISSING"));
                    if (callback != null) {
                        mainHandler.post(() -> callback.onConnectionStateChanged(isConnected && tbtCharacteristic != null, connectedDeviceName, connectedDeviceAddress));
                    }
                }
            }
        }
    };
}
