package com.google.android.libraries.navigation.internal.bp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v extends cl {
    public com.google.android.libraries.navigation.internal.oe.r a;
    public int b;
    private long c;
    private int d;
    private byte e;

    @Override // com.google.android.libraries.navigation.internal.bp.cl
    public final cm a() {
        com.google.android.libraries.navigation.internal.oe.r rVar;
        if (this.e != 3 || (rVar = this.a) == null) {
            throw new IllegalStateException();
        }
        return new w(rVar, this.c, this.d, this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cl
    public final void b(long j) {
        this.c = j;
        this.e = (byte) (this.e | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cl
    public final void c(int i) {
        this.d = i;
        this.e = (byte) (this.e | 2);
    }
}
