package com.spotify.protocol.client;

/* JADX INFO: loaded from: classes4.dex */
public final class Coding {
    private Coding() {
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("Null is not allowed here.");
    }
}
