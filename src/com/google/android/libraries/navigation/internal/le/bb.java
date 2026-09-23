package com.google.android.libraries.navigation.internal.le;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb {
    public bd a;
    public bd b;
    public aq c;
    public com.google.android.libraries.navigation.internal.lc.d[] d;
    public int f;
    private Runnable g = new Runnable() { // from class: com.google.android.libraries.navigation.internal.le.ay
        @Override // java.lang.Runnable
        public final void run() {
        }
    };
    public boolean e = true;

    public final bc a() {
        com.google.android.libraries.navigation.internal.lh.be.b(this.a != null, "Must set register function");
        com.google.android.libraries.navigation.internal.lh.be.b(this.b != null, "Must set unregister function");
        com.google.android.libraries.navigation.internal.lh.be.b(this.c != null, "Must set holder");
        ao aoVar = this.c.b;
        com.google.android.libraries.navigation.internal.lh.be.k(aoVar, "Key must not be null");
        return new bc(new az(this, this.c, this.d, this.e, this.f), new ba(this, aoVar), this.g);
    }
}
