package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class bx {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.model.bx");
    private final List b;
    private final com.google.android.libraries.navigation.internal.adh.a c;

    public bx(com.google.android.libraries.navigation.internal.adh.a aVar) {
        this.c = aVar;
        this.b = hx.f(aVar.a());
        for (int i = 0; i < aVar.a(); i++) {
            this.b.add(new bw((int) aVar.p(aVar.c.b(i), aVar.c.a(i)), i));
        }
    }

    public final long a(long j, ez ezVar) {
        if (ezVar.isEmpty()) {
            return j;
        }
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            bw bwVar = (bw) this.b.get(i);
            if (ezVar.f(bwVar.a)) {
                if (bwVar.c != -1) {
                    bwVar.a(this.c);
                }
                com.google.android.libraries.navigation.internal.agh.ce ceVar = bwVar.b;
                if (ceVar != null) {
                    long jT = ceVar.t(j);
                    if (jT != -1) {
                        j = jT;
                    }
                }
            }
        }
        return j;
    }
}
