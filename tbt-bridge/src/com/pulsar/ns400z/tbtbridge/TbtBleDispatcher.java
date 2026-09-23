package com.pulsar.ns400z.tbtbridge;

import android.content.Context;

/**
 * Backwards compatibility wrapper forwarding to PulsarBleManager.
 */
public class TbtBleDispatcher {

    public interface BleStateCallback {
        void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress);
        void onPacketSent(byte[] frame, boolean success);
    }

    private static TbtBleDispatcher instance;
    private final PulsarBleManager bleManager;
    private BleStateCallback callback;

    private TbtBleDispatcher(Context context) {
        this.bleManager = PulsarBleManager.getInstance(context);
        this.bleManager.setListener(new PulsarBleManager.BleListener() {
            @Override
            public void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress) {
                if (callback != null) {
                    callback.onConnectionStateChanged(connected, deviceName, deviceAddress);
                }
            }

            @Override
            public void onPacketSent(String charUuid, byte[] frame, boolean success) {
                if (callback != null && PulsarProtocol.CHAR_TBT_UUID.equalsIgnoreCase(charUuid)) {
                    callback.onPacketSent(frame, success);
                }
            }

            @Override
            public void onHandlebarEvent(PulsarProtocol.HandlebarEvent event) {
                // Handled in PulsarForegroundService / MediaStateListener
            }
        });
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
            callback.onConnectionStateChanged(bleManager.isConnected(), bleManager.getConnectedDeviceName(), bleManager.getConnectedDeviceAddress());
        }
    }

    public boolean isConnected() {
        return bleManager.isConnected();
    }

    public String getConnectedDeviceName() {
        return bleManager.getConnectedDeviceName();
    }

    public void startScanOrConnect() {
        bleManager.startScanOrConnect();
    }

    public void stopScan() {
        bleManager.stopScan();
    }

    public void connect(String deviceAddress) {
        bleManager.connect(deviceAddress);
    }

    public boolean sendTbtFrame(byte[] frame) {
        return bleManager.sendTbtFrame(frame);
    }
}
