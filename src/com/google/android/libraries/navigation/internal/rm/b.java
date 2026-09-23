package com.google.android.libraries.navigation.internal.rm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final float[] a = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    public final void a(int i, int i2, float f) {
        this.a[(i * 3) + i2] = f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i += 3) {
            float[] fArr = this.a;
            sb.append(fArr[i] + ", " + fArr[i + 1] + ", " + fArr[i + 2] + "\n");
        }
        return sb.toString();
    }
}
