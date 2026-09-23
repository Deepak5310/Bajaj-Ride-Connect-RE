package com.bajajconnect.wifi.interfaces;

import com.bajajconnect.enums.VehicleFaults;

/* JADX INFO: loaded from: classes3.dex */
public interface RNEmiiterCallback {
    void onBluetoothStatusChanged(boolean z);

    void onFaultDetected(VehicleFaults vehicleFaults);

    void onWifiStatusChanged(boolean z);
}
