package com.bajajconnect.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class BLEFrame {
    BleCommandType bleCommandType;
    BluetoothGattCharacteristic characteristic;

    @Nullable
    byte[] data;
    long id;
    boolean shouldWaitForResponse;

    public BLEFrame(long j, BluetoothGattCharacteristic bluetoothGattCharacteristic, BleCommandType bleCommandType, @Nullable byte[] bArr, @Nullable boolean z) {
        this.characteristic = bluetoothGattCharacteristic;
        this.bleCommandType = bleCommandType;
        this.data = bArr;
        this.id = j;
        this.shouldWaitForResponse = z;
    }

    public BleCommandType getBleCommandType() {
        return this.bleCommandType;
    }

    public void setBleCommandType(BleCommandType bleCommandType) {
        this.bleCommandType = bleCommandType;
    }

    public BluetoothGattCharacteristic getCharacteristic() {
        return this.characteristic;
    }

    public void setCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.characteristic = bluetoothGattCharacteristic;
    }
}
