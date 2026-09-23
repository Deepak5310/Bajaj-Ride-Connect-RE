package com.google.android.libraries.navigation.internal.on;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements d {
    private final int a;
    private final int b;

    public a(int i, int i2) {
        this.a = i2;
        this.b = e.a(i, 1.0f);
    }

    @Override // com.google.android.libraries.navigation.internal.on.d
    public final int a(int i) {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.on.d
    public final void b(ByteBuffer byteBuffer, int i) {
        for (int i2 = 0; i2 < this.a * i; i2++) {
            byteBuffer.putInt(this.b);
        }
    }
}
