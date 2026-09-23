package com.google.android.libraries.navigation.internal.xe;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fk implements com.google.android.libraries.navigation.internal.abh.fk {
    private final WeakReference b;
    private final WeakReference c;

    public fk(bp bpVar, com.google.android.libraries.navigation.internal.xd.a aVar) {
        this.b = new WeakReference(bpVar);
        this.c = new WeakReference(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fk
    public final void a(int i, int i2, int i3, int i4) {
        if (this.b.get() == null || this.c.get() == null) {
            return;
        }
        ((bp) this.b.get()).l.Q(i, i2, i3, i4);
        ((com.google.android.libraries.navigation.internal.xd.a) this.c.get()).a(com.google.android.libraries.navigation.internal.zp.n.Df);
    }
}
