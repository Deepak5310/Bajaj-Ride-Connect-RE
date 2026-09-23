package com.google.android.libraries.geo.navcore.service.base;

import android.content.Context;
import android.net.Uri;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.add.ag;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afl.kz;
import com.google.android.libraries.navigation.internal.afl.la;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.bp.au;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.cf;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.km.af;
import com.google.android.libraries.navigation.internal.oe.ac;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.henninghall.date_picker.props.ModeProp;
import com.mappls.android.lms.MapplsLMSDbAdapter;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.google.android.libraries.navigation.internal.so.b {
    private final com.google.android.libraries.navigation.internal.rw.g a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final bn e;
    private boolean f = false;

    public g(com.google.android.libraries.navigation.internal.rw.g gVar, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, bn bnVar) {
        this.a = gVar;
        this.b = aVar;
        this.c = aVar2;
        this.d = aVar3;
        this.e = bnVar;
    }

    static /* synthetic */ void d(k kVar, boolean z) {
        ap.NAVIGATION_INTERNAL.f();
        kVar.f(!z);
    }

    @Override // com.google.android.libraries.navigation.internal.so.c
    public final synchronized void a(final com.google.android.libraries.navigation.internal.so.e eVar) {
        if (!this.f) {
            com.google.android.libraries.navigation.internal.ta.r rVar = (com.google.android.libraries.navigation.internal.ta.r) this.b.a();
            if (rVar.d) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.ta.r.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1692)).p("Out of order start call");
            } else {
                rVar.d = true;
                ev evVar = rVar.b;
                int size = evVar.size();
                for (int i = 0; i < size; i++) {
                    ((com.google.android.libraries.navigation.internal.sp.a) evVar.get(i)).a();
                }
                rVar.c.a();
                rVar.e = true;
            }
            this.f = true;
        }
        final k kVar = (k) this.c.a();
        this.e.execute(new Runnable() { // from class: com.google.android.libraries.geo.navcore.service.base.e
            /* JADX WARN: Code duplicated, block: B:161:0x034d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:178:? A[SYNTHETIC] */
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                com.google.android.libraries.navigation.internal.nw.d dVar;
                Throwable th;
                com.google.android.libraries.navigation.internal.nw.d dVar2;
                bh bhVar;
                k kVar2;
                k kVar3;
                Uri uriBuild;
                String str;
                String str2;
                String strI;
                ap.NAVIGATION_INTERNAL.f();
                com.google.android.libraries.navigation.internal.so.e eVar2 = eVar;
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationModeController.startNavigation");
                try {
                    com.google.android.libraries.navigation.internal.si.e eVar3 = com.google.android.libraries.navigation.internal.si.e.FREE_NAV;
                    int iOrdinal = eVar2.a.ordinal();
                    final k kVar4 = kVar;
                    try {
                        if (iOrdinal == 0) {
                            dVar2 = dVarB;
                            kVar4.d(eVar2.a().a());
                        } else if (iOrdinal != 1) {
                            dVar2 = dVarB;
                        } else {
                            Context context = kVar4.a;
                            bh bhVarB = eVar2.b();
                            int i2 = ((com.google.android.libraries.navigation.internal.bp.m) bhVarB).a;
                            int i3 = 0;
                            while (i3 < bhVarB.d()) {
                                try {
                                    final bg bgVarE = bhVarB.e(i3);
                                    if (bgVarE.j == al.DRIVE) {
                                        final boolean z = i3 == i2;
                                        kVar4.h.execute(new Runnable() { // from class: com.google.android.libraries.geo.navcore.service.base.i
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                bg bgVar = bgVarE;
                                                long j = bgVar.Y;
                                                cf cfVar = bgVar.g;
                                                final kz kzVar = (kz) la.a.q();
                                                bgVar.m.s(new ac() { // from class: com.google.android.libraries.navigation.internal.oe.aa
                                                    @Override // com.google.android.libraries.navigation.internal.oe.ac
                                                    public final void a(int i4, int i5) {
                                                        kz kzVar2 = kzVar;
                                                        kzVar2.c(i4);
                                                        kzVar2.d(i5);
                                                    }
                                                });
                                                ll llVar = bgVar.d.c;
                                                if (llVar == null) {
                                                    llVar = ll.a;
                                                }
                                                lh lhVar = llVar.c;
                                                if (lhVar == null) {
                                                    lhVar = lh.a;
                                                }
                                                bz bzVar = lhVar.c;
                                            }
                                        });
                                    }
                                    i3++;
                                } catch (Throwable th2) {
                                    th = th2;
                                    dVar = dVarB;
                                    if (dVar != null) {
                                        throw th;
                                    }
                                    try {
                                        Trace.endSection();
                                        throw th;
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                        throw th;
                                    }
                                }
                            }
                            if (kVar4.i == com.google.android.libraries.navigation.internal.si.e.FREE_NAV && bhVarB.k()) {
                                bg bgVarF = bhVarB.f();
                                if (bgVarF.m() <= 2) {
                                    com.google.android.libraries.navigation.internal.st.a aVar = (com.google.android.libraries.navigation.internal.st.a) kVar4.e.a();
                                    bgVarF.v(1);
                                    au auVarE = aVar.e();
                                    if (auVarE.isEmpty()) {
                                        ((com.google.android.libraries.navigation.internal.kk.k) kVar4.g.a(af.f465n)).a(j.a(1));
                                    } else {
                                        com.google.android.libraries.navigation.internal.sc.f fVar = (com.google.android.libraries.navigation.internal.sc.f) auVarE.a();
                                        if (fVar == null) {
                                            fVar = (com.google.android.libraries.navigation.internal.sc.f) auVarE.get(0);
                                        }
                                        bg bgVarF2 = bhVarB.f();
                                        x xVar = bgVarF2.U;
                                        x xVar2 = fVar.e.U;
                                        if (xVar == null || xVar2 == null || !xVar.equals(xVar2)) {
                                            ((com.google.android.libraries.navigation.internal.kk.k) kVar4.g.a(af.f465n)).a(j.a(2));
                                        } else {
                                            com.google.android.libraries.navigation.internal.db.r rVar2 = fVar.a;
                                            com.google.android.libraries.navigation.internal.oe.r rVarM = rVar2 == null ? null : rVar2.m();
                                            if (rVarM == null) {
                                                ((com.google.android.libraries.navigation.internal.kk.k) kVar4.g.a(af.f465n)).a(j.a(3));
                                            } else {
                                                com.google.android.libraries.navigation.internal.bw.b bVar = kVar4.f;
                                                if (com.google.android.libraries.navigation.internal.bw.b.b(bgVarF2, fVar.e, com.google.android.libraries.navigation.internal.oe.x.z(rVarM))) {
                                                    kVar4.e(fVar, auVarE, null, eVar2);
                                                    dVar2 = dVarB;
                                                } else {
                                                    ((com.google.android.libraries.navigation.internal.kk.k) kVar4.g.a(af.f465n)).a(j.a(4));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            al alVar = bhVarB.f().j;
                            boolean z2 = ((com.google.android.libraries.navigation.internal.bp.m) bhVarB).a != 0;
                            if (kVar4.b.e()) {
                                bg bgVarF3 = bhVarB.f();
                                al alVar2 = bgVarF3.j;
                                ck ckVarT = bgVarF3.t();
                                ev evVarA = bgVarF3.A();
                                int i4 = com.google.android.libraries.navigation.internal.cg.a.c;
                                ck[] ckVarArr = (ck[]) evVarA.toArray(new ck[0]);
                                ar.q(ckVarArr);
                                int length = ckVarArr.length;
                                ar.a(length > 0);
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        Uri.Builder builderPath = new Uri.Builder().scheme("google.navigation").path(RemoteSettings.FORWARD_SLASH_STRING);
                                        if (i4 == com.google.android.libraries.navigation.internal.cg.a.b) {
                                            builderPath.appendQueryParameter("target", "d");
                                        } else if (i4 == com.google.android.libraries.navigation.internal.cg.a.c) {
                                            builderPath.appendQueryParameter("target", "n");
                                        } else if (i4 == com.google.android.libraries.navigation.internal.cg.a.a) {
                                            builderPath.appendQueryParameter("target", "c");
                                        }
                                        String strA = com.google.android.libraries.navigation.internal.cf.a.a(alVar2);
                                        if (strA == null) {
                                            strA = com.google.android.libraries.navigation.internal.cf.a.a(al.DRIVE);
                                        }
                                        builderPath.appendQueryParameter(ModeProp.name, strA);
                                        if (ckVarT != null) {
                                            if (ckVarT.Y()) {
                                                builderPath.appendQueryParameter("sll", ckVarT.n().a + "," + ckVarT.n().b);
                                            }
                                            if (ckVarT.x() != null) {
                                                builderPath.appendQueryParameter("s", ckVarT.x());
                                            }
                                            if (ckVarT.y() != null) {
                                                builderPath.appendQueryParameter("stitle", ckVarT.y());
                                            }
                                            if (ckVarT.X()) {
                                                builderPath.appendQueryParameter("sftid", ckVarT.m().f());
                                            }
                                            ckVarArr = ckVarArr;
                                        } else {
                                            alVar = alVar;
                                        }
                                        int length2 = ckVarArr.length;
                                        String str3 = length2 <= 1 ? null : "";
                                        int i6 = 0;
                                        while (i6 < length2) {
                                            ck ckVar = ckVarArr[i6];
                                            int i7 = length2;
                                            com.google.android.libraries.navigation.internal.oe.r rVarN = ckVar.n();
                                            if (rVarN != null) {
                                                str = str3;
                                                str2 = String.format(Locale.US, "%.6f,%.6f", Double.valueOf(rVarN.a), Double.valueOf(rVarN.b));
                                            } else {
                                                str = str3;
                                                str2 = str;
                                            }
                                            if (str2 != null) {
                                                builderPath.appendQueryParameter("ll", str2);
                                            }
                                            String strX = ckVar.x() != null ? ckVar.x() : str;
                                            if (strX != null) {
                                                builderPath.appendQueryParameter("q", strX);
                                            }
                                            String strY = ckVar.y() != null ? ckVar.y() : str;
                                            if (strY != null) {
                                                builderPath.appendQueryParameter("title", strY);
                                            }
                                            if (ckVar.m() != null) {
                                                com.google.android.libraries.navigation.internal.oe.j jVarM = ckVar.m();
                                                com.google.android.libraries.navigation.internal.aex.a aVar2 = (com.google.android.libraries.navigation.internal.aex.a) com.google.android.libraries.navigation.internal.aex.b.a.q();
                                                long j = jVarM.b;
                                                if (!aVar2.b.H()) {
                                                    aVar2.v();
                                                }
                                                com.google.android.libraries.navigation.internal.aex.b bVar2 = (com.google.android.libraries.navigation.internal.aex.b) aVar2.b;
                                                bVar2.b |= 16;
                                                bVar2.c = j;
                                                long j2 = jVarM.c;
                                                if (!aVar2.b.H()) {
                                                    aVar2.v();
                                                }
                                                com.google.android.libraries.navigation.internal.aex.b bVar3 = (com.google.android.libraries.navigation.internal.aex.b) aVar2.b;
                                                bVar3.b |= 32;
                                                bVar3.d = j2;
                                                strI = com.google.android.libraries.navigation.internal.zn.g.e.i(((com.google.android.libraries.navigation.internal.aex.b) aVar2.t()).m());
                                            } else {
                                                strI = str;
                                            }
                                            if (strI != null) {
                                                builderPath.appendQueryParameter(MapplsLMSDbAdapter.KEY_TOKEN, strI);
                                            }
                                            i6++;
                                            length2 = i7;
                                            str3 = str;
                                            ckVarArr = ckVarArr;
                                            dVarB = dVarB;
                                            bhVarB = bhVarB;
                                            kVar4 = kVar4;
                                        }
                                        dVar2 = dVarB;
                                        bhVar = bhVarB;
                                        kVar3 = kVar4;
                                        uriBuild = builderPath.build();
                                        break;
                                    }
                                    ck ckVar2 = ckVarArr[i5];
                                    if (ckVar2.x() == null && !ckVar2.Y()) {
                                        dVar2 = dVarB;
                                        bhVar = bhVarB;
                                        kVar3 = kVar4;
                                        alVar = alVar;
                                        uriBuild = null;
                                        break;
                                    }
                                    i5++;
                                }
                                ar.q(uriBuild);
                                kVar2 = kVar3;
                                kVar2.b.c(new com.google.android.libraries.navigation.internal.pw.a(uriBuild.toString()));
                            } else {
                                dVar2 = dVarB;
                                bhVar = bhVarB;
                                kVar2 = kVar4;
                                alVar = alVar;
                            }
                            kVar2.c(new com.google.android.libraries.navigation.internal.sp.c(com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV, alVar, eVar2));
                            kVar2.d.x(bhVar, null, z2);
                        }
                        if (dVar2 != null) {
                            Trace.endSection();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        if (dVar != null) {
                            throw th;
                        }
                        Trace.endSection();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    dVar = dVarB;
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.so.c
    public final synchronized void b(final boolean z) {
        final k kVar = (k) this.c.a();
        this.e.execute(new Runnable() { // from class: com.google.android.libraries.geo.navcore.service.base.f
            @Override // java.lang.Runnable
            public final void run() {
                g.d(kVar, z);
            }
        });
        if (this.f) {
            com.google.android.libraries.navigation.internal.rw.g gVar = this.a;
            com.google.android.libraries.navigation.internal.rw.a aVarA = com.google.android.libraries.navigation.internal.rw.b.a();
            aVarA.c(ag.a);
            aVarA.d(new com.google.android.libraries.navigation.internal.rw.j(null, null, null, null));
            gVar.f(aVarA.a());
            com.google.android.libraries.navigation.internal.ta.r rVar = (com.google.android.libraries.navigation.internal.ta.r) this.b.a();
            if (rVar.d) {
                rVar.d = false;
                ev evVar = rVar.b;
                int size = evVar.size();
                for (int i = 0; i < size; i++) {
                    ((com.google.android.libraries.navigation.internal.sp.a) evVar.get(i)).b();
                }
                if (rVar.e) {
                    rVar.c.b();
                    rVar.e = false;
                }
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.ta.r.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1694)).p("Out of order stop call");
            }
            this.f = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.so.c
    public final void c(String str) {
        ((com.google.android.libraries.navigation.internal.rw.n) this.d.a()).c(str);
    }
}
