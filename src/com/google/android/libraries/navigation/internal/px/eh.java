package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.agi.ey;
import com.google.android.libraries.navigation.internal.agi.ge;
import com.google.android.libraries.navigation.internal.agi.kk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eh {
    public com.google.android.libraries.navigation.internal.agg.bj a = new com.google.android.libraries.navigation.internal.agg.be();
    public com.google.android.libraries.navigation.internal.agh.ea b = new com.google.android.libraries.navigation.internal.agh.du();
    public ey c = new com.google.android.libraries.navigation.internal.agi.et();
    public com.google.android.libraries.navigation.internal.agg.bj d = new com.google.android.libraries.navigation.internal.agg.be();
    public com.google.android.libraries.navigation.internal.agh.ea e = new com.google.android.libraries.navigation.internal.agh.du();
    public ey f = new com.google.android.libraries.navigation.internal.agi.et();
    public final kk g = new kk();

    public static com.google.android.libraries.navigation.internal.yx.an a(int i, long j, String str, com.google.android.libraries.navigation.internal.agg.bj bjVar, com.google.android.libraries.navigation.internal.agh.ea eaVar, ey eyVar) {
        eb ebVar;
        eb ebVar2 = (eb) bjVar.p(i);
        if (ebVar2 != null) {
            return com.google.android.libraries.navigation.internal.yx.an.j(ebVar2);
        }
        if (j != 0) {
            eb ebVar3 = (eb) eaVar.aO(j);
            if (ebVar3 != null) {
                return com.google.android.libraries.navigation.internal.yx.an.j(ebVar3);
            }
        } else if (!str.isEmpty() && (ebVar = (eb) eyVar.get(str)) != null) {
            return com.google.android.libraries.navigation.internal.yx.an.j(ebVar);
        }
        return com.google.android.libraries.navigation.internal.yx.a.a;
    }

    final com.google.android.libraries.navigation.internal.yx.an b(int i, long j, String str) {
        return a(i, j, str, this.d, this.e, this.f);
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    final void c() {
        ge geVarListIterator = ((com.google.android.libraries.navigation.internal.agg.bb) ((com.google.android.libraries.navigation.internal.agg.be) this.a).l()).listIterator();
        while (geVarListIterator.hasNext()) {
            com.google.android.libraries.navigation.internal.agg.bh bhVar = (com.google.android.libraries.navigation.internal.agg.bh) geVarListIterator.next();
            if (!this.d.c(bhVar.a())) {
                ((eb) bhVar.getValue()).d().c().D(2);
            }
        }
        this.a.clear();
        this.b.clear();
        this.c.clear();
        ge geVarListIterator2 = ((com.google.android.libraries.navigation.internal.agg.bb) ((com.google.android.libraries.navigation.internal.agg.be) this.d).l()).listIterator();
        while (geVarListIterator2.hasNext()) {
            ((eb) ((com.google.android.libraries.navigation.internal.agg.bh) geVarListIterator2.next()).getValue()).d().c().D(2);
        }
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
    }
}
