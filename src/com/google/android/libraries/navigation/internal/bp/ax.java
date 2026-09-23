package com.google.android.libraries.navigation.internal.bp;

import android.content.res.Resources;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.fy;
import com.google.android.libraries.navigation.internal.adr.gm;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.adr.hv;
import com.google.android.libraries.navigation.internal.adr.jk;
import com.google.android.libraries.navigation.internal.adr.jo;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;
import j$.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ax {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bp.ax");

    static com.google.android.libraries.navigation.internal.yx.ao b(com.google.android.libraries.navigation.internal.oe.ad adVar, int i) {
        float fB;
        float fB2;
        if (adVar.e() >= 2) {
            int iMin = Math.min(Math.max(0, i), adVar.e() - 1);
            fB = iMin > 0 ? adVar.b(iMin - 1) : adVar.b(iMin);
            fB2 = iMin < adVar.e() + (-1) ? adVar.b(iMin) : adVar.b(iMin - 1);
        } else {
            fB = 0.0f;
            fB2 = 0.0f;
        }
        return new com.google.android.libraries.navigation.internal.yx.ao(Float.valueOf(fB), Float.valueOf(fB2));
    }

    public static String c(Iterable iterable) {
        String str;
        com.google.android.libraries.navigation.internal.yx.an anVarJ;
        int i = gm.g;
        Iterator it2 = iterable.iterator();
        while (true) {
            if (!it2.hasNext()) {
                str = null;
                break;
            }
            gn gnVar = (gn) it2.next();
            int iA = gm.a(gnVar.c);
            if (iA == 0) {
                iA = gm.a;
            }
            if (iA == i && (gnVar.b & 2) != 0) {
                com.google.android.libraries.navigation.internal.adr.aj ajVar = gnVar.d;
                if (ajVar == null) {
                    ajVar = com.google.android.libraries.navigation.internal.adr.aj.a;
                }
                if (!ajVar.c.isEmpty()) {
                    com.google.android.libraries.navigation.internal.adr.aj ajVar2 = gnVar.d;
                    if (ajVar2 == null) {
                        ajVar2 = com.google.android.libraries.navigation.internal.adr.aj.a;
                    }
                    str = ajVar2.c;
                    break;
                }
            }
        }
        List listAsList = Arrays.asList(str, com.google.android.libraries.navigation.internal.br.s.d(iterable));
        com.google.android.libraries.navigation.internal.yx.av avVar = com.google.android.libraries.navigation.internal.yx.av.NOT_NULL;
        Iterator it3 = listAsList.iterator();
        com.google.android.libraries.navigation.internal.yx.ar.q(it3);
        while (true) {
            if (!it3.hasNext()) {
                anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                break;
            }
            Object next = it3.next();
            if (avVar.a(next)) {
                anVarJ = com.google.android.libraries.navigation.internal.yx.an.j(next);
                break;
            }
        }
        String str2 = (String) anVarJ.f();
        return str2 != null ? str2 : com.google.android.libraries.navigation.internal.br.s.d(iterable);
    }

    public static void d(bp bpVar, Cif cif) {
        Duration durationA = Duration.ZERO;
        int i = 0;
        if (cif != null) {
            com.google.android.libraries.navigation.internal.adr.bm bmVar = cif.e;
            if (bmVar == null) {
                bmVar = com.google.android.libraries.navigation.internal.adr.bm.a;
            }
            if ((bmVar.b & 1) != 0) {
                com.google.android.libraries.navigation.internal.adr.bm bmVar2 = cif.e;
                if (bmVar2 == null) {
                    bmVar2 = com.google.android.libraries.navigation.internal.adr.bm.a;
                }
                i = bmVar2.c;
            }
            com.google.android.libraries.navigation.internal.aap.d dVar = cif.f;
            if (dVar == null) {
                dVar = com.google.android.libraries.navigation.internal.aap.d.a;
            }
            if ((dVar.b & 1) != 0) {
                com.google.android.libraries.navigation.internal.aap.d dVar2 = cif.f;
                if (dVar2 == null) {
                    dVar2 = com.google.android.libraries.navigation.internal.aap.d.a;
                }
                durationA = com.google.android.libraries.navigation.internal.bw.a.a(dVar2);
            }
        }
        bpVar.l = i;
        bpVar.f354n = durationA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static bq[] e(av[] avVarArr, com.google.android.libraries.navigation.internal.oe.ad adVar, ev evVar, fy fyVar) {
        bq[] bqVarArrD;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PathUtil.extractSteps()");
        try {
            for (av avVar : avVarArr) {
                com.google.android.libraries.navigation.internal.yx.ar.q(avVar);
            }
            no it2 = evVar.iterator();
            while (it2.hasNext()) {
                com.google.android.libraries.navigation.internal.yx.ar.q((ck) it2.next());
            }
            com.google.android.libraries.navigation.internal.yx.ar.a(avVarArr.length == evVar.size() + (-1));
            if (adVar.e() > 0) {
                aw awVarA = aw.a();
                int i = 0;
                loop2: while (true) {
                    if (i >= avVarArr.length) {
                        bqVarArrD = awVarA.d();
                        break;
                    }
                    av avVar2 = avVarArr[i];
                    i++;
                    ck ckVar = (ck) evVar.get(i);
                    awVarA.c();
                    for (int i2 = 0; i2 < avVar2.a(); i2++) {
                        if (!f(avVar2.b(i2), awVarA, adVar, ckVar, fyVar)) {
                            bqVarArrD = new bq[0];
                            break loop2;
                        }
                    }
                }
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(58)).p("polyline should have at least one vertex.");
                bqVarArrD = new bq[0];
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return bqVarArrD;
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static boolean f(bt btVar, aw awVar, com.google.android.libraries.navigation.internal.oe.ad adVar, ck ckVar, fy fyVar) {
        int i;
        int iA = btVar.a();
        int size = awVar.c;
        for (int i2 = 0; i2 < iA; i2++) {
            hv hvVarE = btVar.e(i2);
            int i3 = (hvVarE.b & 8192) != 0 ? hvVarE.s : -1;
            if (i3 < 0 || i3 >= adVar.e()) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(57)).t("compact_polyline_vertex_offset %d out of range [0..%d)", i3, adVar.e());
                return false;
            }
            com.google.android.libraries.navigation.internal.yx.ao aoVarB = b(adVar, i3);
            bp bpVarA = ca.a(hvVarE, size, adVar.l(i3), ckVar);
            bpVarA.g = awVar.a.size();
            bpVarA.h = i3;
            bpVarA.m = awVar.b;
            bpVarA.o = ((Float) aoVarB.a).floatValue();
            bpVarA.p = ((Float) aoVarB.b).floatValue();
            bpVarA.x = btVar;
            d(bpVarA, awVar.d);
            if (fyVar != null && fyVar.equals(fy.TURN_BY_TURN_STEPS) && i2 == iA - 1) {
                Cif cif = hvVarE.d;
                if (cif == null) {
                    cif = Cif.a;
                }
                com.google.android.libraries.navigation.internal.adr.bm bmVar = cif.e;
                if (bmVar == null) {
                    bmVar = com.google.android.libraries.navigation.internal.adr.bm.a;
                }
                if (bmVar.c == 0) {
                    bpVarA.a = com.google.android.libraries.navigation.internal.aap.l.DESTINATION;
                }
            }
            bq bqVar = new bq(bpVarA);
            size += bqVar.A.size();
            awVar.a.add(bqVar);
            Cif cif2 = bpVarA.w;
            awVar.d = cif2;
            if (cif2 == null) {
                i = 0;
            } else {
                com.google.android.libraries.navigation.internal.adr.bm bmVar2 = cif2.e;
                if (bmVar2 == null) {
                    bmVar2 = com.google.android.libraries.navigation.internal.adr.bm.a;
                }
                i = bmVar2.c;
            }
            awVar.b += i;
        }
        awVar.c = size;
        return true;
    }

    public static bq a(int i, bq bqVar, jo joVar, bq bqVar2, com.google.android.libraries.navigation.internal.oe.ad adVar, Resources resources) {
        int iE = bqVar2 != null ? bqVar2.k : adVar.e() - 1;
        com.google.android.libraries.navigation.internal.yx.ao aoVarB = b(adVar, iE);
        bp bpVarA = bqVar.a();
        bpVarA.g = i;
        jk jkVar = joVar.d;
        if (jkVar == null) {
            jkVar = jk.a;
        }
        bpVarA.i = resources.getString(com.google.android.libraries.navigation.internal.qr.e.t, jkVar.c);
        bpVarA.f = adVar.l(iE);
        bpVarA.h = iE;
        bpVarA.o = ((Float) aoVarB.a).floatValue();
        bpVarA.p = ((Float) aoVarB.b).floatValue();
        bpVarA.a = com.google.android.libraries.navigation.internal.aap.l.DESTINATION;
        bt btVar = bpVarA.x;
        com.google.android.libraries.navigation.internal.yx.ar.q(btVar);
        com.google.android.libraries.navigation.internal.aap.d dVar = btVar.g().f;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        bpVarA.f354n = com.google.android.libraries.navigation.internal.bw.a.a(dVar);
        return new bq(bpVarA);
    }
}
