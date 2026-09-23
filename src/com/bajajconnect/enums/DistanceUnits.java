package com.bajajconnect.enums;

/* JADX INFO: loaded from: classes3.dex */
public enum DistanceUnits {
    KM(0),
    MILES(2),
    METER(1),
    YARD(4),
    FOOT(5);

    private final int value;

    DistanceUnits(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
