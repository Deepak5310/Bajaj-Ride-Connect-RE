package com.bajajconnect.tbt;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.util.Log;

import java.util.UUID;

/**
 * Ultra-lightweight BLE GATT Connection & Dispatcher for Bajaj Pulsar NS400Z.
 * Handles automatic reconnection and raw 48-byte packet writing without React Native or Map SDKs.
 */
public class TbtBleDispatcher {

    private static final String TAG = "TbtBleDispatcher";
    private static final UUID SERVICE_UUID = UUID.fromString("0010676e-6972-6565-6e69-676e4543544f");
    private static final UUID TBT_CHAR_UUID = UUID.fromString("0110676e-6972-6565-6e69-676e4543544f");

    private static TbtBleDispatcher instance;
    private final Context context;
    private BluetoothGatt bluetoothGatt;
    private BluetoothGattCharacteristic tbtCharacteristic;
    private boolean isConnected = false;

    private TbtBleDispatcher(Context context) {
        this.context = context.getApplicationContext();
    }

    public static synchronized TbtBleDispatcher getInstance(Context context) {
        if (instance == null) {
            instance = new TbtBleDispatcher(context);
        }
        return instance;
    }

    @SuppressLint("MissingPermission")
    public void connect(String deviceAddress) {
        BluetoothManager manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        if (manager == null || manager.getAdapter() == null) {
            Log.e(TAG, "Bluetooth not supported on this device.");
            return;
        }

        BluetoothDevice device = manager.getAdapter().getRemoteDevice(deviceAddress);
        Log.i(TAG, "Connecting to NS400Z at " + deviceAddress);
        this.bluetoothGatt = device.connectGatt(context, true, gattCallback);
    }

    @SuppressLint("MissingPermission")
    public boolean sendTbtFrame(byte[] frame) {
        if (!isConnected || bluetoothGatt == null || tbtCharacteristic == null) {
            Log.w(TAG, "Cannot send TBT frame: Cluster not connected.");
            return false;
        }

        tbtCharacteristic.setValue(frame);
        tbtCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        return bluetoothGatt.writeCharacteristic(tbtCharacteristic);
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
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                BluetoothGattService service = gatt.getService(SERVICE_UUID);
                if (service != null) {
                    tbtCharacteristic = service.getCharacteristic(TBT_CHAR_UUID);
                    Log.i(TAG, "Discovered NS400Z TBT Characteristic -> " + (tbtCharacteristic != null ? "READY" : "MISSING"));
                }
            }
        }
    };
}
