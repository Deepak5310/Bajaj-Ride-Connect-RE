package com.bajajconnect.wifi.tftEnums;

/* JADX INFO: loaded from: classes3.dex */
public enum GroupCode {
    GROUP_DASH_EVENTS(0),
    GROUP_DASH_STATUS(1),
    GROUP_DASH_REQUESTS(2);

    private final int value;

    GroupCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
