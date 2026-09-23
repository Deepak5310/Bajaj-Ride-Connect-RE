package com.google.android.libraries.navigation.internal.tz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends s {
    private int a;
    private int b;
    private int c;
    private int d;
    private byte e;

    @Override // com.google.android.libraries.navigation.internal.tz.s
    public final t a() {
        if (this.e == 15) {
            return new j(this.a, this.b, this.c, this.d);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.tz.s
    public final void b(int i) {
        this.c = i;
        this.e = (byte) (this.e | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.s
    public final void c(int i) {
        this.d = i;
        this.e = (byte) (this.e | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.s
    public final void d(int i) {
        this.b = i;
        this.e = (byte) (this.e | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.s
    public final void e(int i) {
        this.a = i;
        this.e = (byte) (this.e | 1);
    }
}
