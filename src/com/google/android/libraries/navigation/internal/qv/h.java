package com.google.android.libraries.navigation.internal.qv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum h {
    OK(1, 1),
    OK_PENDING(1, 2),
    IO_ERROR(2, 1),
    NOT_EXIST(3, 1),
    NOT_EXIST_PENDING(3, 2),
    NOT_FOUND_LOCALLY(4, 1),
    NOT_FOUND_LOCALLY_PENDING(4, 2),
    NOT_OFFLINEABLE(5, 1),
    NETWORK_ERROR(6, 1);

    public final int j;
    public final int k;

    h(int i, int i2) {
        this.j = i;
        this.k = i2;
    }

    public static h a(h hVar, boolean z) {
        int i = hVar.j;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            return z ? OK_PENDING : OK;
        }
        if (i2 == 2) {
            return z ? NOT_EXIST_PENDING : NOT_EXIST;
        }
        if (i2 != 3) {
            return hVar;
        }
        return z ? NOT_FOUND_LOCALLY_PENDING : NOT_FOUND_LOCALLY;
    }
}
