package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends l implements Serializable {
    private static final long serialVersionUID = 0;
    final byte[] a;

    public i(byte[] bArr) {
        ar.q(bArr);
        this.a = bArr;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final int a() {
        int length = this.a.length;
        ar.m(length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", length);
        byte[] bArr = this.a;
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final int b() {
        return this.a.length * 8;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final long c() {
        int length = this.a.length;
        int i = 1;
        ar.m(length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", length);
        long j = this.a[0] & 255;
        while (true) {
            byte[] bArr = this.a;
            if (i >= Math.min(bArr.length, 8)) {
                return j;
            }
            j |= (((long) bArr[i]) & 255) << (i * 8);
            i++;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final boolean d(l lVar) {
        if (this.a.length != lVar.f().length) {
            return false;
        }
        boolean z = true;
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i >= bArr.length) {
                return z;
            }
            z &= bArr[i] == lVar.f()[i];
            i++;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final byte[] e() {
        return (byte[]) this.a.clone();
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final byte[] f() {
        return this.a;
    }
}
