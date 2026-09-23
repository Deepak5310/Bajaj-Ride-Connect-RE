package com.bajajconnect.enums;

/* JADX INFO: loaded from: classes3.dex */
public enum CallState {
    INCOMING_CALL(1),
    ACTIVE_CALL(3),
    OUTGOING_CALL(2),
    NO_CALL(0),
    END_CALL(4);

    private final int value;

    CallState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
