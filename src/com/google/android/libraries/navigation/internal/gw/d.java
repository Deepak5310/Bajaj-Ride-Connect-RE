package com.google.android.libraries.navigation.internal.gw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends w {
    public Integer a;
    public Integer b;
    public com.google.android.libraries.navigation.internal.o.d c;
    public byte d;
    private boolean e;

    @Override // com.google.android.libraries.navigation.internal.gw.w
    public final x a() {
        if (this.d == 3) {
            return new e(this.a, this.b, this.e, this.c);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.gw.w
    public final void b(boolean z) {
        this.e = z;
        this.d = (byte) (this.d | 2);
    }
}
