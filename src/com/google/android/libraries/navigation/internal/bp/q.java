package com.google.android.libraries.navigation.internal.bp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends by {
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public com.google.android.libraries.navigation.internal.yx.br e;
    public byte f;

    @Override // com.google.android.libraries.navigation.internal.bp.by
    public final void a(int i) {
        this.a = i;
        this.f = (byte) (this.f | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.by
    public final void b(int i) {
        this.b = i;
        this.f = (byte) (this.f | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.by
    public final void c(boolean z) {
        this.c = z;
        this.f = (byte) (this.f | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.by
    public final void d(boolean z) {
        this.d = z;
        this.f = (byte) (this.f | 8);
    }
}
