package com.google.android.libraries.navigation.internal.xp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends RuntimeException {
    public final int a;

    /* JADX WARN: Illegal instructions before constructor call */
    public m(int i, String str, Throwable th) {
        String strValueOf;
        if (str != null) {
            strValueOf = i + ": " + str;
        } else {
            strValueOf = String.valueOf(i);
        }
        super(strValueOf, th);
        this.a = i;
    }
}
