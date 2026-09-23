package com.bajajconnect.enums.music;

/* JADX INFO: loaded from: classes3.dex */
public enum PlayStatus {
    NONE(0),
    PLAY(2),
    PAUSED(1);

    private final int value;

    PlayStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
