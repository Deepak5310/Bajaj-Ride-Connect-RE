package com.google.android.libraries.navigation.internal.lc;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class s extends q {
    private static final WeakReference a = new WeakReference(null);
    private WeakReference b;

    public s(byte[] bArr) {
        super(bArr);
        this.b = a;
    }

    protected abstract byte[] b();

    @Override // com.google.android.libraries.navigation.internal.lc.q
    public final byte[] f() {
        byte[] bArrB;
        synchronized (this) {
            bArrB = (byte[]) this.b.get();
            if (bArrB == null) {
                bArrB = b();
                this.b = new WeakReference(bArrB);
            }
        }
        return bArrB;
    }
}
