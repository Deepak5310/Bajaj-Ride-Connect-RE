package com.bajajconnect.enums;

/* JADX INFO: loaded from: classes3.dex */
public enum VehicleType {
    PULSAR,
    UNKNOWN;

    public static VehicleType fromDeviceName(String str) {
        if (str == null || str.isEmpty()) {
            return UNKNOWN;
        }
        return PULSAR;
    }
}
