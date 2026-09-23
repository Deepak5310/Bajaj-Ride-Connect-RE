package com.bajajconnect.ble.protocol;

import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.features.VehicleFeature;

/* JADX INFO: loaded from: classes3.dex */
public final class NewBtProtocolSelector {
    private NewBtProtocolSelector() {
    }

    public static boolean useNewGeneralProtocol() {
        return VehicleFeature.BLE_GENERAL_PACKET_V2.isEnabledFor(BleFeatures.getInstance().modelCode);
    }

    public static boolean useNewAlertsProtocol() {
        return useNewGeneralProtocol();
    }

    public static boolean useNewMissedCallProtocol() {
        return useNewGeneralProtocol();
    }
}
