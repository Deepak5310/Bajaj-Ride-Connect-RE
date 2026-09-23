package com.google.android.libraries.navigation.internal.za;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d extends a {
    protected d() {
    }

    public static char[] d(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    @Override // com.google.android.libraries.navigation.internal.za.a
    public String a(String str) {
        throw null;
    }

    protected int b(CharSequence charSequence, int i, int i2) {
        throw null;
    }

    protected abstract char[] c(int i);
}
