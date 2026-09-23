package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum en implements com.google.android.libraries.navigation.internal.ael.bm {
    SUBTITLE_ANNOTATE_UNKNOWN(0),
    SUBTITLE_ANNOTATE_AFTER_LAST_ELEMENT(1);

    private final int d;

    en(int i) {
        this.d = i;
    }

    public static en b(int i) {
        if (i == 0) {
            return SUBTITLE_ANNOTATE_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return SUBTITLE_ANNOTATE_AFTER_LAST_ELEMENT;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.d;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.d);
    }
}
