package com.google.android.libraries.navigation.internal.le;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi {
    public bd a;
    public com.google.android.libraries.navigation.internal.lc.d[] b;
    private boolean d = true;
    public int c = 0;

    public final bj a() {
        com.google.android.libraries.navigation.internal.lh.be.b(this.a != null, "execute parameter required");
        return new bh(this, this.b, this.d, this.c);
    }

    public final void b() {
        this.d = false;
    }
}
