package com.bajajconnect.enums;

/* JADX INFO: loaded from: classes3.dex */
public enum Alert {
    SMS(1),
    WAPP(2);

    private final int value;

    Alert(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
