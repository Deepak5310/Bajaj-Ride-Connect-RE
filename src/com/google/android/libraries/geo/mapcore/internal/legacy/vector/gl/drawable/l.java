package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.renderer.cs;
import com.google.android.libraries.geo.mapcore.renderer.ey;
import com.google.android.libraries.navigation.internal.agi.bs;
import com.google.android.libraries.navigation.internal.agi.cj;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class l extends k {
    private final bs b;
    private final int c;

    private l(ey eyVar, bs bsVar, int i) {
        super(eyVar);
        this.b = bsVar;
        this.c = i;
    }

    static l e(List list) {
        float fA = j.a(list);
        cj cjVar = new cj();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            j jVar = (j) it2.next();
            if (!cjVar.containsKey(jVar.b)) {
                cjVar.a(jVar.b, cjVar.h);
            }
        }
        return g(cjVar, fA);
    }

    static l g(bs bsVar, float f) {
        ey eyVarF = f(bsVar, f, ((cj) bsVar).h, true);
        cs csVar = eyVarF.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(csVar);
        return new l(eyVarF, bsVar, csVar.g);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.k
    public final float a(int i) {
        return 0.0f;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.k
    public final float b(int i) {
        return 1.0f;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.k
    public final float c() {
        return 0.0f;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.k
    public final float d(n nVar) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.b.containsKey(nVar));
        int iO = this.b.o(nVar);
        return ((iO + iO) + 1.0f) / this.c;
    }
}
