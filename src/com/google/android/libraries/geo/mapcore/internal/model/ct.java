package com.google.android.libraries.geo.mapcore.internal.model;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.kc;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ct {
    public final List a = new ArrayList();
    public boolean b = false;
    private fd c;
    private fd d;
    private final com.google.android.libraries.navigation.internal.ox.f e;

    public ct(com.google.android.libraries.navigation.internal.ox.f fVar) {
        fd fdVar = ma.b;
        this.c = fdVar;
        this.d = fdVar;
        this.e = fVar;
    }

    private final synchronized void e(fd fdVar, fd fdVar2) {
        this.c = fdVar;
        this.d = fdVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized cr a(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adi.an anVar) {
        ev evVar = (ev) this.d.get(anVar);
        cr crVar = null;
        if (evVar != null) {
            loop0: for (int i = 0; i < evVar.size(); i++) {
                cs csVar = (cs) evVar.get(i);
                for (int i2 = 0; i2 < csVar.a.size(); i2++) {
                    if (((cd) csVar.a.get(i2)).e().k(xVar)) {
                        crVar = csVar.b;
                        break loop0;
                    }
                }
            }
        }
        if (crVar == null) {
            crVar = (cr) this.c.get(anVar);
        }
        if (crVar != null) {
            return crVar;
        }
        return cr.b;
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("init ZoomTableManager");
        try {
            c();
            if (dVarB != null) {
                Trace.endSection();
            }
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

    public final void c() {
        fd fdVarB;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ZoomTableManager.onParametersChanged");
        try {
            synchronized (this) {
                com.google.android.libraries.navigation.internal.adi.ar arVar = this.e.a().c;
                if (arVar == null) {
                    arVar = com.google.android.libraries.navigation.internal.adi.ar.a;
                }
                com.google.android.libraries.navigation.internal.ael.bz<com.google.android.libraries.navigation.internal.adi.al> bzVar = arVar.c;
                int i = com.google.android.libraries.navigation.internal.gz.h.a;
                HashMap map = new HashMap(bzVar.size(), 1.0f);
                int i2 = 0;
                for (com.google.android.libraries.navigation.internal.adi.al alVar : bzVar) {
                    if (alVar.f.size() > 0) {
                        i2++;
                        int[] iArr = new int[alVar.f.size()];
                        for (int i3 = 0; i3 < alVar.f.size(); i3++) {
                            iArr[i3] = alVar.f.d(i3);
                        }
                        cr crVar = new cr(iArr);
                        com.google.android.libraries.navigation.internal.adi.an anVarB = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
                        if (anVarB == null) {
                            anVarB = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                        }
                        if (anVarB != com.google.android.libraries.navigation.internal.adi.an.UNKNOWN) {
                            if (map.containsKey(anVarB)) {
                                anVarB.name();
                            } else {
                                map.put(anVarB, crVar);
                            }
                        }
                    } else {
                        com.google.android.libraries.navigation.internal.adi.an anVarB2 = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
                        if (anVarB2 == null) {
                            anVarB2 = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                        }
                        if (anVarB2 != com.google.android.libraries.navigation.internal.adi.an.GMM_LABELS_ONLY) {
                            com.google.android.libraries.navigation.internal.adi.an anVarB3 = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
                            if (anVarB3 == null) {
                                anVarB3 = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                            }
                            if (anVarB3 != com.google.android.libraries.navigation.internal.adi.an.GMM_ROAD_GRAPH) {
                                com.google.android.libraries.navigation.internal.adi.an anVarB4 = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
                                if (anVarB4 == null) {
                                    anVarB4 = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                                }
                                if (anVarB4 != com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIGHT_PERSONALIZED_SMARTMAPS_PER_TILE) {
                                    com.google.android.libraries.navigation.internal.adi.an anVarB5 = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
                                    if (anVarB5 == null) {
                                        anVarB5 = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                                    }
                                    anVarB5.name();
                                }
                            }
                        }
                    }
                }
                if (i2 == 0) {
                    fdVarB = ma.b;
                } else {
                    map.put(com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY, cr.a);
                    fdVarB = kc.b(map);
                }
                HashMap map2 = new HashMap(bzVar.size(), 1.0f);
                for (com.google.android.libraries.navigation.internal.adi.al alVar2 : bzVar) {
                    if (alVar2.f.size() > 0) {
                        com.google.android.libraries.navigation.internal.adi.an anVarB6 = com.google.android.libraries.navigation.internal.adi.an.b(alVar2.c);
                        if (anVarB6 == null) {
                            anVarB6 = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                        }
                        if (anVarB6 != com.google.android.libraries.navigation.internal.adi.an.UNKNOWN && !map2.containsKey(anVarB6)) {
                            eq eqVar = new eq();
                            for (com.google.android.libraries.navigation.internal.adi.bz bzVar2 : alVar2.g) {
                                int[] iArr2 = new int[bzVar2.b.size()];
                                for (int i4 = 0; i4 < bzVar2.b.size(); i4++) {
                                    iArr2[i4] = bzVar2.b.d(i4);
                                }
                                eqVar.h(new cs(new cr(iArr2), bzVar2.c));
                            }
                            map2.put(anVarB6, eqVar.g());
                        }
                    }
                }
                e(fdVarB, kc.b(map2));
            }
            synchronized (this.a) {
                this.b = true;
                while (this.a.size() > 0) {
                    ((com.google.android.libraries.navigation.internal.qq.ah) this.a.get(0)).a();
                    this.a.remove(0);
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
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

    public final synchronized boolean d() {
        return !this.c.isEmpty();
    }
}
