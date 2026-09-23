package com.google.android.libraries.navigation.internal.sl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum m {
    UNMUTED(0, 2),
    MINIMAL(1, 1),
    MUTED(2, 0);

    public final int d;
    public final int e;

    m(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public static m a(int i) {
        for (m mVar : values()) {
            if (mVar.d == i) {
                return mVar;
            }
        }
        return null;
    }
}
