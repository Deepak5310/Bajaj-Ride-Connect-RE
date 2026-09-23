package com.bajajconnect.wifi.tftEnums;

/* JADX INFO: loaded from: classes3.dex */
public enum TouchType {
    TOUCH_DOWN(0),
    TOUCH_UP(1),
    TOUCH_MOVE(3);

    private final int value;

    TouchType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
