package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.bs;
import com.google.android.libraries.geo.mapcore.renderer.fg;
import com.google.android.libraries.navigation.internal.adg.bc;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public final com.google.android.libraries.navigation.internal.oe.ad[] a;
    public final n b;
    public final fg c;
    public final float d;
    public final bc e;

    public j(com.google.android.libraries.geo.mapcore.internal.model.ar arVar, com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, fg fgVar, m mVar) {
        this.a = arVar.d;
        b bVar = new b(aiVar, mVar);
        this.b = bVar;
        this.c = fgVar;
        bs[] bsVarArrE = bVar.e();
        float f = 0.0f;
        for (bs bsVar : bsVarArrE) {
            float fAbs = Math.abs(bsVar.h) + (bsVar.d / 2.0f);
            if (fAbs > f) {
                f = fAbs;
            }
        }
        this.d = f + f;
        this.e = arVar.o;
    }

    public static float a(List list) {
        Iterator it2 = list.iterator();
        float fMax = 1.0f;
        while (it2.hasNext()) {
            fMax = Math.max(fMax, ((j) it2.next()).d);
        }
        return fMax;
    }

    public final com.google.android.libraries.geo.mapcore.internal.model.ai b() {
        return ((a) this.b).a;
    }
}
