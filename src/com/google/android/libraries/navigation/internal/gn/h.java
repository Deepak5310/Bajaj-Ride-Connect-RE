package com.google.android.libraries.navigation.internal.gn;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h {
    final ByteBuffer a;
    final ByteArrayOutputStream b;

    public h() {
        this.a = null;
        this.b = new ByteArrayOutputStream(32768);
    }

    public h(int i) {
        this.a = ByteBuffer.allocate(i);
        this.b = null;
    }
}
