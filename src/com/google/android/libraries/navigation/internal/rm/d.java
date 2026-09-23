package com.google.android.libraries.navigation.internal.rm;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final float[] a;

    public d() {
        this.a = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public d(d dVar) {
        this.a = new float[]{fArr[0], fArr[1], fArr[2], 0.0f};
        float[] fArr = dVar.a;
    }

    public d(byte[] bArr) {
        this.a = new float[]{0.0f, 0.0f, 1.0f, 0.0f};
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return Arrays.equals(((d) obj).a, this.a);
        }
        return false;
    }

    public final String toString() {
        float[] fArr = this.a;
        return "[" + fArr[0] + ", " + fArr[1] + ", " + fArr[2] + "]";
    }
}
