package com.bajajconnect.enums;

/* JADX INFO: loaded from: classes3.dex */
public enum GpsStatus {
    NOT_ACTIVE(0),
    ACTIVE(1),
    SEARCHING(2);

    private final int value;

    GpsStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
