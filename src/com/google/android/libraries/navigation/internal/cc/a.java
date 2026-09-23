package com.google.android.libraries.navigation.internal.cc;

import android.app.Application;
import android.text.BidiFormatter;
import android.text.format.DateUtils;
import com.google.android.libraries.navigation.internal.ace.lf;
import com.google.android.libraries.navigation.internal.adq.aj;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fn;
import com.google.android.libraries.navigation.internal.adr.fp;
import com.google.android.libraries.navigation.internal.adr.fs;
import com.google.android.libraries.navigation.internal.adr.ft;
import com.google.android.libraries.navigation.internal.adu.am;
import com.google.android.libraries.navigation.internal.adu.f;
import com.google.android.libraries.navigation.internal.adu.q;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afe.m;
import com.google.android.libraries.navigation.internal.afl.ok;
import com.google.android.libraries.navigation.internal.bn.d;
import com.google.android.libraries.navigation.internal.br.l;
import com.google.android.libraries.navigation.internal.bx.g;
import com.google.android.libraries.navigation.internal.ca.e;
import com.google.android.libraries.navigation.internal.hn.r;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.qr.c;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lo;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.Arrays;
import java.util.Formatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a implements com.google.android.libraries.navigation.internal.cb.b {
    private static final j a = j.e("com.google.android.libraries.navigation.internal.cc.a");
    private final el.a b;
    private final ah c;
    private final fp d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final boolean i;
    private final boolean j;
    private final String k;
    private final String l;
    private final com.google.android.libraries.navigation.internal.jp.a m;

    static {
        aa.k(m.A);
    }

    public a(Application application, d dVar, r rVar, r rVar2, com.google.android.libraries.navigation.internal.bz.b bVar, an anVar, at atVar, el elVar) {
        int i;
        int i2;
        com.google.android.libraries.navigation.internal.aap.r rVar3;
        com.google.android.libraries.navigation.internal.aap.r rVar4;
        BidiFormatter.getInstance();
        com.google.android.libraries.navigation.internal.jp.a aVar = (com.google.android.libraries.navigation.internal.jp.a) anVar.f();
        this.m = aVar;
        fp fpVarB = fp.b(elVar.g);
        if ((fpVarB == null ? fp.UNKNOWN : fpVarB) == fp.TRANSIT_ALERT && aVar != null) {
            aVar.a();
        }
        boolean zF = f(elVar);
        this.j = zF;
        if (zF && aVar == null) {
            ((h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('k')).p("ReportTransitDelayController is null, but this is a transit ugc notice. ReportTransitDelayController should not be null outside of embedded/projected builds. Check providers for this entry point.");
        }
        this.i = false;
        el.a aVarB = el.a.b(elVar.f);
        aVarB = aVarB == null ? el.a.INFORMATION : aVarB;
        this.b = aVarB;
        lo loVar = l.a;
        el.a aVarB2 = el.a.b(elVar.f);
        int iOrdinal = (aVarB2 == null ? el.a.INFORMATION : aVarB2).ordinal();
        if (iOrdinal != 1) {
            i = iOrdinal != 2 ? c.f559n : c.o;
        } else {
            i = c.p;
        }
        this.c = e.a(elVar, dVar, com.google.android.libraries.navigation.internal.nc.j.g(i));
        el.a aVarB3 = el.a.b(elVar.f);
        int iOrdinal2 = (aVarB3 == null ? el.a.INFORMATION : aVarB3).ordinal();
        if (iOrdinal2 != 1) {
            i2 = iOrdinal2 != 2 ? c.k : c.l;
        } else {
            i2 = c.m;
        }
        e.a(elVar, dVar, com.google.android.libraries.navigation.internal.nc.j.g(i2));
        int iOrdinal3 = aVarB.ordinal();
        if (iOrdinal3 == 1) {
            application.getString(g.G);
        } else if (iOrdinal3 != 2) {
            application.getString(g.h);
        } else {
            application.getString(g.A);
        }
        fp fpVarB2 = fp.b(elVar.g);
        this.d = fpVarB2 == null ? fp.UNKNOWN : fpVarB2;
        boolean z = ((lf) rVar2.b()).b;
        String strE = l.e(elVar);
        if (strE.isEmpty() && elVar.h.isEmpty()) {
            strE = elVar.i;
        } else {
            String str = elVar.h;
            if (!str.isEmpty()) {
                strE = str;
            }
        }
        this.e = strE;
        if (com.google.android.libraries.navigation.internal.yx.c.c(elVar.i, strE)) {
            this.g = "";
        } else {
            this.g = elVar.i;
        }
        int i3 = com.google.android.libraries.navigation.internal.bx.e.a;
        this.f = "";
        String str2 = elVar.j;
        l.f(elVar);
        if (((ok) rVar.b()).b) {
            this.h = str2;
            e(this.g, str2);
        } else {
            this.h = e(this.g, str2);
        }
        if (elVar.c == 25) {
            fn fnVar = (fn) elVar.d;
            bz bzVar = fnVar.c;
            if (!bzVar.isEmpty()) {
                new com.google.android.libraries.navigation.internal.cd.a(ev.o(bzVar), com.google.android.libraries.navigation.internal.bn.a.TRANSIT_AUTO);
            }
            this.k = fnVar.d;
            if ((fnVar.b & 8) != 0 && fnVar.f == null) {
                com.google.android.libraries.navigation.internal.aap.r rVar5 = com.google.android.libraries.navigation.internal.aap.r.a;
            }
        } else {
            this.k = null;
        }
        if ((elVar.b & 524288) != 0) {
            ft ftVar = elVar.y;
            int iA = fs.a((ftVar == null ? ft.a : ftVar).c);
            if ((iA == 0 ? fs.a : iA) == fs.c) {
                ft ftVar2 = elVar.y;
                ftVar2 = ftVar2 == null ? ft.a : ftVar2;
                String str3 = ftVar2.f;
                q qVar = ftVar2.d;
                qVar = qVar == null ? q.a : qVar;
                int i4 = qVar.b;
                if ((i4 & 1) != 0) {
                    f fVar = qVar.c;
                    String str4 = (fVar == null ? f.a : fVar).d;
                    String str5 = qVar.e;
                } else if ((i4 & 4) != 0) {
                    am amVar = qVar.d;
                    aj ajVar = (amVar == null ? am.a : amVar).b;
                    String str6 = (ajVar == null ? aj.a : ajVar).d;
                    am amVar2 = qVar.d;
                    aj ajVar2 = (amVar2 == null ? am.a : amVar2).b;
                    String str7 = (ajVar2 == null ? aj.a : ajVar2).c;
                }
                if ((ftVar2.b & 4) != 0) {
                    String str8 = ftVar2.e;
                }
            }
        }
        if (!f(elVar)) {
            int i5 = elVar.b;
            if ((i5 & 512) != 0) {
                rVar3 = elVar.l;
                if (rVar3 == null) {
                    rVar3 = com.google.android.libraries.navigation.internal.aap.r.a;
                }
            } else if ((i5 & 1024) != 0) {
                rVar3 = elVar.m;
                if (rVar3 == null) {
                    rVar3 = com.google.android.libraries.navigation.internal.aap.r.a;
                }
            }
            if ((elVar.b & 1024) != 0) {
                rVar4 = elVar.m;
                if (rVar4 == null) {
                    rVar4 = com.google.android.libraries.navigation.internal.aap.r.a;
                }
            } else {
                rVar4 = elVar.l;
                if (rVar4 == null) {
                    rVar4 = com.google.android.libraries.navigation.internal.aap.r.a;
                }
            }
            application.getString(g.B, DateUtils.formatDateRange(application, new Formatter(new StringBuilder(50)), TimeUnit.SECONDS.toMillis(rVar3.c), TimeUnit.SECONDS.toMillis(rVar4.c), 524288, rVar3.d));
        }
        aj ajVar3 = elVar.k;
        String str9 = (ajVar3 == null ? aj.a : ajVar3).e;
        aj ajVar4 = elVar.k;
        String str10 = (ajVar4 == null ? aj.a : ajVar4).d;
        if (str9.isEmpty() || str10.isEmpty()) {
            this.l = null;
        } else {
            this.l = str10;
            aj ajVar5 = elVar.k;
            String str11 = (ajVar5 == null ? aj.a : ajVar5).c;
        }
        if (f(elVar)) {
            ((at) bVar.a.a()).getClass();
            an anVar2 = (an) bVar.b.a();
            anVar2.getClass();
            new com.google.android.libraries.navigation.internal.bz.a(anVar2, elVar);
        }
    }

    public static ev<com.google.android.libraries.navigation.internal.cb.b> c(b bVar, List<el> list, cs.b<com.google.android.libraries.navigation.internal.cb.b> bVar2) {
        return d(bVar, list, null, null);
    }

    public static ev<com.google.android.libraries.navigation.internal.cb.b> d(b bVar, List<el> list, cs.b<com.google.android.libraries.navigation.internal.cb.b> bVar2, aa aaVar) {
        if (list.isEmpty()) {
            int i = ev.d;
            return lv.a;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (el elVar : list) {
            Application application = (Application) bVar.a.a();
            application.getClass();
            d dVar = (d) bVar.b.a();
            dVar.getClass();
            ((com.google.android.libraries.navigation.internal.hf.e) bVar.c.a()).getClass();
            r rVar = (r) bVar.d.a();
            rVar.getClass();
            r rVar2 = (r) bVar.e.a();
            rVar2.getClass();
            com.google.android.libraries.navigation.internal.bz.b bVar3 = (com.google.android.libraries.navigation.internal.bz.b) bVar.f.a();
            bVar3.getClass();
            an anVar = (an) bVar.g.a();
            anVar.getClass();
            at atVar = (at) bVar.h.a();
            atVar.getClass();
            elVar.getClass();
            linkedHashSet.add(new a(application, dVar, rVar, rVar2, bVar3, anVar, atVar, elVar));
        }
        return ev.o(linkedHashSet);
    }

    private static String e(String str, String str2) {
        if (str.isEmpty()) {
            return str2;
        }
        if (str2.isEmpty()) {
            return str;
        }
        return str + " · " + str2;
    }

    private static boolean f(el elVar) {
        return ((elVar.c == 25 ? (fn) elVar.d : fn.a).b & 16) != 0;
    }

    @Override // com.google.android.libraries.navigation.internal.cb.b
    public ah a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.cb.b
    public String b() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (com.google.android.libraries.navigation.internal.yx.am.a(this.b, aVar.b) && com.google.android.libraries.navigation.internal.yx.am.a(this.d, aVar.d) && com.google.android.libraries.navigation.internal.yx.am.a(this.e, aVar.e)) {
            boolean z = aVar.i;
            if (com.google.android.libraries.navigation.internal.yx.am.a(this.f, aVar.f) && com.google.android.libraries.navigation.internal.yx.am.a(this.h, aVar.h) && com.google.android.libraries.navigation.internal.yx.am.a(this.k, aVar.k) && com.google.android.libraries.navigation.internal.yx.am.a(this.l, aVar.l)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.d, this.e, false, this.f, this.h, this.k, this.l});
    }
}
