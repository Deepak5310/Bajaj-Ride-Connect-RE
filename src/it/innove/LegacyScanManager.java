package it.innove;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes4.dex */
public class LegacyScanManager extends ScanManager {
    private BluetoothAdapter.LeScanCallback mLeScanCallback;

    @Override // it.innove.ScanManager
    public boolean isScanning() {
        return false;
    }

    public LegacyScanManager(ReactApplicationContext reactApplicationContext, BleManager bleManager) {
        super(reactApplicationContext, bleManager);
        this.mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: it.innove.LegacyScanManager.1
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: it.innove.LegacyScanManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.i(BleManager.LOG_TAG, "DiscoverPeripheral: " + bluetoothDevice.getName());
                        Peripheral peripheral = LegacyScanManager.this.bleManager.getPeripheral(bluetoothDevice);
                        if (peripheral == null) {
                            peripheral = new Peripheral(bluetoothDevice, i, bArr, LegacyScanManager.this.bleManager.getReactContext());
                        } else {
                            peripheral.updateData(bArr);
                            peripheral.updateRssi(i);
                        }
                        LegacyScanManager.this.bleManager.savePeripheral(peripheral);
                        LegacyScanManager.this.bleManager.sendEvent("BleManagerDiscoverPeripheral", peripheral.asWritableMap());
                    }
                });
            }
        };
    }

    @Override // it.innove.ScanManager
    public void stopScan(Callback callback) {
        this.scanSessionId.incrementAndGet();
        getBluetoothAdapter().stopLeScan(this.mLeScanCallback);
        callback.invoke(new Object[0]);
    }

    @Override // it.innove.ScanManager
    public void scan(ReadableArray readableArray, final int i, ReadableMap readableMap, Callback callback) {
        if (readableArray.size() > 0) {
            Log.d(BleManager.LOG_TAG, "Filter is not working in pre-lollipop devices");
        }
        getBluetoothAdapter().startLeScan(this.mLeScanCallback);
        if (i > 0) {
            new Thread() { // from class: it.innove.LegacyScanManager.2
                private int currentScanSession;

                {
                    this.currentScanSession = LegacyScanManager.this.scanSessionId.incrementAndGet();
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(i * 1000);
                    } catch (InterruptedException unused) {
                    }
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: it.innove.LegacyScanManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BluetoothAdapter bluetoothAdapter = LegacyScanManager.this.getBluetoothAdapter();
                            if (LegacyScanManager.this.scanSessionId.intValue() == AnonymousClass2.this.currentScanSession) {
                                if (bluetoothAdapter.getState() == 12) {
                                    bluetoothAdapter.stopLeScan(LegacyScanManager.this.mLeScanCallback);
                                }
                                WritableMap writableMapCreateMap = Arguments.createMap();
                                writableMapCreateMap.putInt(NotificationCompat.CATEGORY_STATUS, 0);
                                LegacyScanManager.this.bleManager.sendEvent("BleManagerStopScan", writableMapCreateMap);
                            }
                        }
                    });
                }
            }.start();
        }
        callback.invoke(new Object[0]);
    }
}
