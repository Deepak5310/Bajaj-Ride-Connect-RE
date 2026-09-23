package com.google.android.libraries.navigation.internal.zl;

import androidx.collection.ScatterMapKt;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa extends b implements Serializable {
    public static final m a = new aa(0, true);
    private static final long serialVersionUID = 0;
    public final int b = 0;
    public final boolean c = true;

    public aa(int i, boolean z) {
    }

    public static int f(byte[] bArr, int i) {
        return com.google.android.libraries.navigation.internal.zy.i.b(bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
    }

    public static int g(int i, int i2) {
        return (Integer.rotateLeft(i ^ i2, 13) * 5) - 430675100;
    }

    public static int h(int i) {
        return Integer.rotateLeft(i * ScatterMapKt.MurmurHashC1, 15) * 461845907;
    }

    public static long i(char c) {
        int i = ((c >>> 6) & 63) | 128;
        return ((long) (c >>> '\f')) | 224 | ((long) (i << 8)) | ((long) (((c & '?') | 128) << 16));
    }

    public static long j(char c) {
        return ((long) (c >>> 6)) | 192 | ((long) (((c & '?') | 128) << 8));
    }

    public static long k(int i) {
        return ((((long) (i & 63)) | 128) << 24) | ((((long) ((i >>> 12) & 63)) | 128) << 8) | ((long) (i >>> 18)) | 240 | ((((long) ((i >>> 6) & 63)) | 128) << 16);
    }

    public static l l(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * (-2048144789);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477387);
        return new j(i5 ^ (i5 >>> 16));
    }

    @Override // com.google.android.libraries.navigation.internal.zl.b
    public final l d(byte[] bArr, int i) {
        int iA = 0;
        ar.j(0, i, bArr.length);
        int i2 = 0;
        int iG = 0;
        while (true) {
            int i3 = i2 + 4;
            if (i3 > i) {
                break;
            }
            iG = g(iG, h(f(bArr, i2)));
            i2 = i3;
        }
        int i4 = 0;
        while (i2 < i) {
            iA ^= com.google.android.libraries.navigation.internal.zy.m.a(bArr[i2]) << i4;
            i2++;
            i4 += 8;
        }
        return l(h(iA) ^ iG, i);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.m
    public final n e() {
        return new z(0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aa)) {
            return false;
        }
        aa aaVar = (aa) obj;
        int i = aaVar.b;
        boolean z = aaVar.c;
        return true;
    }

    public final int hashCode() {
        return getClass().hashCode();
    }

    public final String toString() {
        return "Hashing.murmur3_32(0)";
    }
}
