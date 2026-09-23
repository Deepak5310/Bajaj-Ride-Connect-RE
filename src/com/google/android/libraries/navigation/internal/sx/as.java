package com.google.android.libraries.navigation.internal.sx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adr.la;
import com.google.android.libraries.navigation.internal.adr.lh;
import com.google.android.libraries.navigation.internal.adr.lp;
import com.google.android.libraries.navigation.internal.adr.ls;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.lj;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.cg;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zr.cu;
import j$.time.Instant;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class as {
    private static final com.google.android.libraries.navigation.internal.zb.j e = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sx.as");
    public final com.google.android.libraries.navigation.internal.adr.at a;
    public final bh b;
    public final com.google.android.libraries.navigation.internal.bp.af c;
    public final cu d;

    public as(ar arVar) {
        com.google.android.libraries.navigation.internal.adr.at atVar = arVar.a;
        com.google.android.libraries.navigation.internal.yx.ar.r(atVar, NotificationCompat.CATEGORY_STATUS);
        this.a = atVar;
        bh bhVar = arVar.b;
        com.google.android.libraries.navigation.internal.yx.ar.r(bhVar, "routes");
        this.b = bhVar;
        this.c = arVar.c;
        this.d = arVar.d;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x000f  */
    public static ev a(lz lzVar, Context context) {
        com.google.android.libraries.navigation.internal.oe.r rVar;
        com.google.android.libraries.navigation.internal.aes.h hVar = lzVar.f;
        if (hVar == null) {
            hVar = com.google.android.libraries.navigation.internal.aes.h.a;
        }
        com.google.android.libraries.navigation.internal.aes.d dVar = hVar.f;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.aes.d.a;
        }
        if (dVar == null) {
            rVar = null;
        } else {
            int i = dVar.b;
            if ((i & 1) == 0 || (i & 2) == 0) {
                rVar = null;
            } else {
                rVar = new com.google.android.libraries.navigation.internal.oe.r(((double) dVar.c) * 1.0E-7d, ((double) dVar.d) * 1.0E-7d);
            }
        }
        lj ljVar = lzVar.c;
        if (ljVar == null) {
            ljVar = lj.a;
        }
        int i2 = ev.d;
        eq eqVar = new eq();
        for (ls lsVar : ljVar.c) {
            com.google.android.libraries.navigation.internal.adr.lj ljVarB = com.google.android.libraries.navigation.internal.adr.lj.b(lsVar.k);
            if (ljVarB == null) {
                ljVarB = com.google.android.libraries.navigation.internal.adr.lj.ENTITY_TYPE_DEFAULT;
            }
            if (ljVarB == com.google.android.libraries.navigation.internal.adr.lj.ENTITY_TYPE_MY_LOCATION && (lsVar.b & 8) == 0) {
                lh lhVar = (lh) ls.a.r(lsVar);
                int i3 = lp.d;
                if (!lhVar.b.H()) {
                    lhVar.v();
                }
                ls lsVar2 = (ls) lhVar.b;
                int i4 = i3 - 1;
                if (i3 == 0) {
                    throw null;
                }
                lsVar2.c = i4;
                lsVar2.b |= 1;
                if (rVar != null) {
                    com.google.android.libraries.navigation.internal.adq.z zVarB = rVar.b();
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar3 = (ls) lhVar.b;
                    zVarB.getClass();
                    lsVar3.f = zVarB;
                    lsVar3.b |= 8;
                }
                lsVar = (ls) lhVar.t();
            }
            eqVar.h(ck.O(lsVar, context));
        }
        return eqVar.g();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031  */
    /* JADX WARN: Code duplicated, block: B:12:0x003d  */
    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    /* JADX WARN: Code duplicated, block: B:18:0x0053  */
    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0078  */
    /* JADX WARN: Code duplicated, block: B:27:0x008c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0091 A[LOOP:1: B:28:0x008d->B:30:0x0091, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x00be  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00da  */
    /* JADX WARN: Code duplicated, block: B:40:0x00de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:52:0x005f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static as c(lz lzVar, final long j, final com.google.android.libraries.navigation.internal.bp.af afVar, final Context context, final boolean z, final int i) {
        ev evVarA;
        lv lvVar;
        lj ljVar;
        bz bzVar;
        final cg[] cgVarArr;
        int i2;
        lj ljVar2;
        final lj ljVar3;
        final eq eqVar;
        com.google.android.libraries.navigation.internal.yx.aa aaVar;
        int iB;
        int iC;
        ArrayList arrayList;
        int i3;
        Object objAk;
        int i4;
        com.google.android.libraries.navigation.internal.adq.z zVar;
        ar arVar = new ar();
        if (afVar == null) {
            arVar.a = com.google.android.libraries.navigation.internal.adr.at.NO_ROUTES_FOUND;
        } else {
            arVar.c = afVar;
            if ((afVar.b.b & 8) != 0) {
                arVar.a = afVar.g();
                if (afVar.m()) {
                    evVarA = a(lzVar, context);
                    lvVar = (lv) evVarA;
                    if (lvVar.c >= 2) {
                        ljVar = lzVar.c;
                        if (ljVar == null) {
                            ljVar = lj.a;
                        }
                        bzVar = ljVar.i;
                        cgVarArr = new cg[bzVar.size()];
                        for (i2 = 0; i2 < bzVar.size(); i2++) {
                            zVar = ((la) bzVar.get(i2)).d;
                            if (zVar == null) {
                                zVar = com.google.android.libraries.navigation.internal.adq.z.a;
                            }
                            cgVarArr[i2] = cg.d(com.google.android.libraries.navigation.internal.oe.r.a(zVar), ((la) bzVar.get(i2)).c);
                        }
                        ljVar2 = lzVar.c;
                        if (ljVar2 == null) {
                            ljVar2 = lj.a;
                        }
                        ljVar3 = ljVar2;
                        eqVar = new eq();
                        if (afVar.d() == ljVar3.c.size()) {
                            for (i4 = 0; i4 < lvVar.c; i4++) {
                                eqVar.h(com.google.android.libraries.navigation.internal.bt.k.a(afVar.k(), context, (ck) evVarA.get(i4), afVar.h(i4)));
                            }
                        }
                        aaVar = new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.sx.aq
                            @Override // com.google.android.libraries.navigation.internal.yx.aa
                            public final Object ak(Object obj) {
                                Instant instantOfEpochMilli = Instant.ofEpochMilli(j);
                                Instant instant = bg.b;
                                int iIntValue = ((Integer) obj).intValue();
                                Context context2 = context;
                                int i5 = i;
                                com.google.android.libraries.navigation.internal.bp.af afVar2 = afVar;
                                cg[] cgVarArr2 = cgVarArr;
                                ev evVarG = eqVar.g();
                                ev evVarP = ev.p(cgVarArr2);
                                boolean z2 = z;
                                lr lrVar = ljVar3.g;
                                if (lrVar == null) {
                                    lrVar = lr.a;
                                }
                                lr lrVar2 = lrVar;
                                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("RouteDescription.fromDirections()");
                                try {
                                    com.google.android.libraries.navigation.internal.bp.bd bdVarAd = bg.ad(afVar2, instantOfEpochMilli, instant, iIntValue, context2, i5, evVarG, evVarP, z2, lrVar2);
                                    bg bgVar = bdVarAd == null ? null : new bg(bdVarAd);
                                    if (dVarB != null) {
                                        Trace.endSection();
                                    }
                                    return bgVar;
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
                        };
                        if (afVar.l()) {
                            iB = afVar.b();
                        } else {
                            iB = -1;
                        }
                        iC = afVar.c();
                        arrayList = new ArrayList();
                        for (i3 = 0; i3 < iC; i3++) {
                            objAk = aaVar.ak(Integer.valueOf(i3));
                            if (objAk != null) {
                                arrayList.add(objAk);
                            } else if (i3 < iB) {
                                iB--;
                            } else if (i3 == iB) {
                                ((com.google.android.libraries.navigation.internal.zb.h) e.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1685)).p("Selected trip returned from the server is not renderable");
                            }
                        }
                        if (iB < 0) {
                            iB = 0;
                        }
                        arVar.b = bh.i(iB, (bg[]) arrayList.toArray(new bg[0]));
                    }
                } else {
                    afVar.g().name();
                }
            } else {
                evVarA = a(lzVar, context);
                lvVar = (lv) evVarA;
                if (lvVar.c >= 2) {
                    ljVar = lzVar.c;
                    if (ljVar == null) {
                        ljVar = lj.a;
                    }
                    bzVar = ljVar.i;
                    cgVarArr = new cg[bzVar.size()];
                    while (i2 < bzVar.size()) {
                        zVar = ((la) bzVar.get(i2)).d;
                        if (zVar == null) {
                            zVar = com.google.android.libraries.navigation.internal.adq.z.a;
                        }
                        cgVarArr[i2] = cg.d(com.google.android.libraries.navigation.internal.oe.r.a(zVar), ((la) bzVar.get(i2)).c);
                    }
                    ljVar2 = lzVar.c;
                    if (ljVar2 == null) {
                        ljVar2 = lj.a;
                    }
                    ljVar3 = ljVar2;
                    eqVar = new eq();
                    if (afVar.d() == ljVar3.c.size()) {
                        while (i4 < lvVar.c) {
                            eqVar.h(com.google.android.libraries.navigation.internal.bt.k.a(afVar.k(), context, (ck) evVarA.get(i4), afVar.h(i4)));
                        }
                    }
                    aaVar = new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.sx.aq
                        @Override // com.google.android.libraries.navigation.internal.yx.aa
                        public final Object ak(Object obj) {
                            Instant instantOfEpochMilli = Instant.ofEpochMilli(j);
                            Instant instant = bg.b;
                            int iIntValue = ((Integer) obj).intValue();
                            Context context2 = context;
                            int i5 = i;
                            com.google.android.libraries.navigation.internal.bp.af afVar2 = afVar;
                            cg[] cgVarArr2 = cgVarArr;
                            ev evVarG = eqVar.g();
                            ev evVarP = ev.p(cgVarArr2);
                            boolean z2 = z;
                            lr lrVar = ljVar3.g;
                            if (lrVar == null) {
                                lrVar = lr.a;
                            }
                            lr lrVar2 = lrVar;
                            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("RouteDescription.fromDirections()");
                            try {
                                com.google.android.libraries.navigation.internal.bp.bd bdVarAd = bg.ad(afVar2, instantOfEpochMilli, instant, iIntValue, context2, i5, evVarG, evVarP, z2, lrVar2);
                                bg bgVar = bdVarAd == null ? null : new bg(bdVarAd);
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                                return bgVar;
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
                    };
                    if (afVar.l()) {
                        iB = afVar.b();
                    } else {
                        iB = -1;
                    }
                    iC = afVar.c();
                    arrayList = new ArrayList();
                    while (i3 < iC) {
                        objAk = aaVar.ak(Integer.valueOf(i3));
                        if (objAk != null) {
                            arrayList.add(objAk);
                        } else if (i3 < iB) {
                            iB--;
                        } else if (i3 == iB) {
                            ((com.google.android.libraries.navigation.internal.zb.h) e.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1685)).p("Selected trip returned from the server is not renderable");
                        }
                    }
                    if (iB < 0) {
                        iB = 0;
                    }
                    arVar.b = bh.i(iB, (bg[]) arrayList.toArray(new bg[0]));
                }
            }
        }
        return new as(arVar);
    }

    public final boolean b() {
        return this.a == com.google.android.libraries.navigation.internal.adr.at.SUCCESS;
    }
}
