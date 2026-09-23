package com.spotify.android.appremote.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class Validate {
    private Validate() {
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("The object is expected to be not null");
    }
}
