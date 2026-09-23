package com.bajajconnect.wifi.tftEnums;

/* JADX INFO: loaded from: classes3.dex */
public enum PacketType {
    REQUEST(0),
    RESPONSE(1);

    private final int value;

    PacketType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
