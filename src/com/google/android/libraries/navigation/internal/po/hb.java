package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.nn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hb implements hl {
    private final com.google.android.libraries.navigation.internal.hx.d a;

    public hb(final hi hiVar, final dq dqVar, int i) {
        com.google.android.libraries.navigation.internal.yx.ar.a(i > 0);
        this.a = new com.google.android.libraries.navigation.internal.hx.d(i, new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ha
            @Override // java.lang.Runnable
            public final void run() {
                dq dqVar2 = dqVar;
                com.google.android.libraries.navigation.internal.yz.fy fyVarI = dqVar2.i();
                hi hiVar2 = hiVar;
                synchronized (hiVar2.e) {
                    nn nnVarListIterator = fyVarI.listIterator();
                    while (nnVarListIterator.hasNext()) {
                        if (hiVar2.d.c((com.google.android.libraries.geo.mapcore.internal.vector.gl.n) nnVarListIterator.next()) == null) {
                            return;
                        }
                    }
                    dqVar2.k(true);
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.po.hl
    public final void a() {
        this.a.a();
    }
}
