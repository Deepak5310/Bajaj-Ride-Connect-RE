package com.google.android.libraries.navigation.internal.zl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends c {
    final e a;
    final /* synthetic */ f b;

    public d(f fVar, int i) {
        this.b = fVar;
        this.a = new e(i);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n a(ByteBuffer byteBuffer) {
        this.a.b(byteBuffer);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public final void f(byte b) {
        this.a.write(b);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n g(byte[] bArr, int i) {
        this.a.write(bArr, 0, i);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public final l o() {
        e eVar = this.a;
        return this.b.d(eVar.c(), eVar.a());
    }
}
