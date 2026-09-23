package com.google.android.libraries.navigation.internal.us;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.jd;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak {
    public static final /* synthetic */ int a = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.us.ak");
    private static final fd c;

    static {
        ez ezVar = new ez();
        ezVar.f(jd.DEFAULT_NONE, -1);
        ezVar.f(jd.DING_DAH, Integer.valueOf(com.google.android.libraries.navigation.internal.dw.g.g));
        ezVar.f(jd.DING_DEE, Integer.valueOf(com.google.android.libraries.navigation.internal.dw.g.h));
        ezVar.f(jd.DING_DONG, Integer.valueOf(com.google.android.libraries.navigation.internal.dw.g.i));
        ezVar.f(jd.DRING_DRING, Integer.valueOf(com.google.android.libraries.navigation.internal.dw.g.j));
        ezVar.f(jd.TAH_LAH_LAH, Integer.valueOf(com.google.android.libraries.navigation.internal.dw.g.k));
        ezVar.f(jd.TOO_LOO, Integer.valueOf(com.google.android.libraries.navigation.internal.dw.g.l));
        c = ezVar.d();
    }

    static int a(jd jdVar) {
        Integer num = (Integer) c.get(jdVar);
        return num != null ? num.intValue() : com.google.android.libraries.navigation.internal.dw.g.i;
    }

    public static com.google.android.libraries.navigation.internal.vn.d b(jg jgVar, int i, String str, com.google.android.libraries.navigation.internal.sn.h hVar) {
        if (jgVar.f.size() <= 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1916)).p("Unexpected TrafficReportPrompt without spoken text.");
            return new com.google.android.libraries.navigation.internal.vn.d(com.google.android.libraries.navigation.internal.vn.c.OTHER, null, "", null, null, -1);
        }
        jd jdVarB = jd.b(jgVar.e);
        if (jdVarB == null) {
            jdVarB = jd.DEFAULT_NONE;
        }
        return hVar.c(a(jdVarB), jgVar.f, i, str);
    }

    public static void c(jg jgVar, com.google.android.libraries.navigation.internal.bn.d dVar, y yVar) {
        if ((jgVar.b & 32) != 0) {
            el elVar = jgVar.i;
            if (elVar == null) {
                elVar = el.a;
            }
            com.google.android.libraries.navigation.internal.adr.ah ahVar = elVar.w;
            if (ahVar == null) {
                ahVar = com.google.android.libraries.navigation.internal.adr.ah.a;
            }
            com.google.android.libraries.navigation.internal.br.d dVar2 = (com.google.android.libraries.navigation.internal.br.d) com.google.android.libraries.navigation.internal.br.l.a(ahVar);
            yVar.N(com.google.android.libraries.navigation.internal.ca.d.a(dVar2.a, dVar2.b, dVar, new aj(yVar)));
        }
    }
}
