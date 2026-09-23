package com.bajajconnect.enums.music;

/* JADX INFO: loaded from: classes3.dex */
public enum PlaylistType {
    FAVORITE("55"),
    RECENT("AA"),
    POADCAST("BB");

    private final String value;

    PlaylistType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
