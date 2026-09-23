package com.google.android.libraries.navigation.internal.ael;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ee extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;

    public ee() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final cc a() {
        return new cc(getMessage());
    }
}
