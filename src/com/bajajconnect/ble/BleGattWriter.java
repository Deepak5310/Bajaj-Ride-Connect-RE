package com.bajajconnect.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;
import com.bajajconnect.variables.GlobalVar;

/* JADX INFO: loaded from: classes3.dex */
public final class BleGattWriter {
    private BleGattWriter() {
    }

    public static void prepareCharAndWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        prepareCharAndWrite(bluetoothGattCharacteristic, bArr, true);
    }

    public static void prepareCharAndWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) {
        if (bluetoothGattCharacteristic == null || bArr == null) {
            return;
        }
        if (!GlobalVar.isMTUIncreased) {
            Log.w("BleGattWriter", "skip write (MTU not ready) uuid=" + bluetoothGattCharacteristic.getUuid());
        } else {
            if (BleService.isGattConnected()) {
                BleService.prepareCharAndWrite(bluetoothGattCharacteristic, bArr);
                return;
            }
            if (BluetoothLeService.isGattConnected()) {
                BluetoothLeService.prepareCharAndWrite(bluetoothGattCharacteristic, bArr, z);
                return;
            }
            Log.w("BleGattWriter", "skip write (no GATT) uuid=" + bluetoothGattCharacteristic.getUuid() + " len=" + bArr.length);
        }
    }
}
