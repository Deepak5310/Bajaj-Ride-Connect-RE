package com.google.android.libraries.navigation.internal.ck;

import android.content.Context;
import android.content.res.Resources;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final com.google.android.libraries.navigation.internal.yx.br b;
    public final Map c = new HashMap();
    public final Map d = new HashMap();
    private final Resources e;
    private final cw f;
    private final com.google.android.libraries.navigation.internal.yx.br g;

    public ac(com.google.android.libraries.navigation.internal.afo.a aVar, final com.google.android.libraries.navigation.internal.oa.k kVar, Context context) {
        this.a = aVar;
        this.e = context.getResources();
        this.b = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.w
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return kVar.b().a();
            }
        });
        this.f = new cw(context.getResources());
        this.g = com.google.android.libraries.navigation.internal.yx.bw.a(new x(aVar));
    }

    public final com.google.android.libraries.navigation.internal.ol.j a(com.google.android.libraries.navigation.internal.oe.r rVar, int i, int i2, int i3) {
        int i4;
        com.google.android.libraries.navigation.internal.yx.br brVarA;
        z zVar = new z(i, i2);
        aa aaVar = (aa) this.d.get(zVar);
        if (aaVar == null) {
            com.google.android.libraries.geo.mapcore.renderer.k kVar = new com.google.android.libraries.geo.mapcore.renderer.k(this.e, i);
            if (kVar.a() != null) {
                brVarA = com.google.android.libraries.navigation.internal.yx.bw.a(new y(this, kVar, i2));
                i4 = ((com.google.android.libraries.geo.mapcore.renderer.g) kVar.b()).a;
                this.d.put(zVar, new aa(brVarA, i4));
            } else {
                brVarA = this.g;
                i4 = 0;
            }
        } else {
            i4 = aaVar.b;
            brVarA = aaVar.a;
        }
        return ((com.google.android.libraries.navigation.internal.on.h) this.b.a()).b(rVar.a, rVar.b, 4, i4, true, (com.google.android.libraries.navigation.internal.ol.aq) brVarA.a(), false, 2);
    }
}
