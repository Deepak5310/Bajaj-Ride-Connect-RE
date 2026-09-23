package com.google.android.libraries.navigation.internal.tc;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothProfile;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w implements BluetoothProfile.ServiceListener {
    final /* synthetic */ y a;

    public w(y yVar) {
        this.a = yVar;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        if (i == 2) {
            int i2 = y.c;
            synchronized (this.a) {
                y yVar = this.a;
                yVar.a = (BluetoothA2dp) bluetoothProfile;
                yVar.c();
            }
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int i) {
        if (i == 2) {
            int i2 = y.c;
            synchronized (this.a) {
                y yVar = this.a;
                yVar.a = null;
                yVar.b = 0;
            }
        }
    }
}
