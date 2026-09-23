package com.google.android.libraries.navigation.internal.rq;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    private byte[] a;
    private int b;
    private boolean c = true;

    public e() {
        ar.b(true, "Invalid length");
        byte[] bArr = new byte[0];
        this.a = bArr;
        b(bArr.length);
    }

    public final synchronized int a() {
        return this.b;
    }

    public final synchronized void b(int i) {
        ar.b(true, "Invalid length");
        ar.l(this.c, "GrowableByteArray has not been released");
        this.c = false;
        this.b = i;
        if (i > this.a.length) {
            this.a = new byte[i];
        }
    }

    public final synchronized void c() {
        this.c = true;
    }

    public final synchronized void d(int i) {
        ar.b(i >= 0, "Invalid length");
        byte[] bArr = this.a;
        if (bArr.length >= i) {
            this.b = i;
            return;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(this.b, i));
        this.b = i;
        this.a = bArr2;
    }

    public final synchronized byte[] e() {
        ar.l(!this.c, "GrowableByteArray has been released");
        return this.a;
    }
}
