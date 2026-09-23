package com.google.android.libraries.navigation.internal.on;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements d {
    @Override // com.google.android.libraries.navigation.internal.on.d
    public final int a(int i) {
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.on.d
    public final void b(ByteBuffer byteBuffer, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            float f = i;
            float f2 = i2;
            for (int i3 = 0; i3 < i; i3++) {
                float f3 = f / 2.0f;
                float f4 = (f2 + 0.5f) - f3;
                float f5 = (i3 + 0.5f) - f3;
                float f6 = (-0.25f) + f3;
                float f7 = f6 * f6;
                float f8 = f3 + 0.25f;
                byteBuffer.putInt(e.a(-1, Math.max(0.0f, Math.min(1.0f, (f7 - ((f4 * f4) + (f5 * f5))) * (1.0f / ((f8 * f8) - f7))))));
            }
        }
    }
}
