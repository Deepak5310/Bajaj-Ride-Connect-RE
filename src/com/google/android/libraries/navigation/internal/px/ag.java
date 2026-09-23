package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag {
    public ah a;
    public boolean c;
    public com.google.android.libraries.navigation.internal.ol.l e;
    public final Object b = new Object();
    public final com.google.android.libraries.navigation.internal.ol.m d = new com.google.android.libraries.navigation.internal.ol.m();

    public final void a() {
        synchronized (this.b) {
            ah ahVar = this.a;
            if (ahVar != null) {
                ahVar.D(64);
                this.a = null;
            }
        }
    }

    public final void b(ah ahVar) {
        synchronized (this.b) {
            if (ahVar != null) {
                this.a = ahVar;
                ahVar.C(64);
                this.a.l(this.e);
            }
        }
    }
}
