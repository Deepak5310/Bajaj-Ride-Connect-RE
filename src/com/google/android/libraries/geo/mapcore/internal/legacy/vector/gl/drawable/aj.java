package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import android.graphics.Bitmap;
import com.google.android.libraries.geo.mapcore.internal.model.bt;
import com.google.android.libraries.geo.mapcore.internal.model.bv;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.renderer.ep;
import com.google.android.libraries.geo.mapcore.renderer.er;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class aj {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final bt f55n;
    private static final bt o;
    public final com.google.android.libraries.navigation.internal.qh.c a;
    public final String b;
    public final ai c;
    public final ai d;
    public final ai e;
    public final ai f;
    public final List g;
    public final List h;
    public final List i;
    public final List j;
    public final List k;
    public final Map l;
    public boolean m;

    static {
        com.google.android.libraries.geo.mapcore.internal.model.ah ahVarF = com.google.android.libraries.geo.mapcore.internal.model.ai.c.f();
        ahVarF.a = false;
        ahVarF.g = 1862270976;
        f55n = bt.i(new com.google.android.libraries.geo.mapcore.internal.model.ai(ahVarF));
        com.google.android.libraries.geo.mapcore.internal.model.ah ahVarF2 = com.google.android.libraries.geo.mapcore.internal.model.ai.c.f();
        ahVarF2.a = false;
        ahVarF2.g = -872415232;
        o = bt.i(new com.google.android.libraries.geo.mapcore.internal.model.ai(ahVarF2));
    }

    public aj() {
        this.a = new com.google.android.libraries.navigation.internal.qh.c();
        this.c = new ai(64);
        this.d = new ai(16);
        this.e = new ai(16);
        this.f = new ai(4);
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new HashMap();
        this.m = false;
        this.b = "client injected geometry";
    }

    public static bt b(com.google.android.libraries.navigation.internal.pt.d dVar) {
        int i = dVar.c;
        if (i > 0) {
            return f55n;
        }
        return i < 0 ? o : bt.a;
    }

    static boolean d(com.google.android.libraries.navigation.internal.qh.d dVar, com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, boolean z) {
        int iE = 0;
        if (z) {
            if (!aiVar.i && aiVar.t()) {
                iE = aiVar.e();
            }
            dVar.a = iE;
            dVar.b = null;
            return true;
        }
        boolean z2 = aiVar.h;
        int i = true != z2 ? -1 : 0;
        float[] fArr = aiVar.G;
        dVar.a = i;
        dVar.b = fArr;
        int i2 = aiVar.H;
        if (z2 || i2 == dVar.c) {
            return true;
        }
        dVar.c = i2;
        return false;
    }

    public final byte a(ae aeVar) {
        return this.c.a(aeVar);
    }

    public final void c(com.google.android.libraries.geo.mapcore.renderer.ax axVar) {
        this.m = true;
        axVar.o();
    }

    public final boolean e(List list, ai aiVar, float f) {
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarF;
        for (ag agVar : aiVar.b()) {
            byte bA = aiVar.a(agVar);
            com.google.android.libraries.geo.mapcore.internal.model.ba baVar = agVar.b;
            float f2 = baVar.e() ? f : agVar.c;
            com.google.android.libraries.navigation.internal.qh.c cVar = this.a;
            if (baVar.f()) {
                aiVarF = com.google.android.libraries.geo.mapcore.internal.model.ai.c;
            } else if (baVar.e()) {
                bv bvVar = cVar.b;
                if (bvVar == null) {
                    aiVarF = com.google.android.libraries.geo.mapcore.internal.model.ai.c;
                } else {
                    int i = baVar.e;
                    if (i != 0) {
                        aiVarF = bvVar.b(i).f(f2);
                    } else {
                        long j = baVar.c;
                        if (j != -1) {
                            aiVarF = bvVar.c(j).f(f2);
                        } else {
                            int i2 = baVar.d;
                            aiVarF = i2 != -1 ? bvVar.c(i2).f(f2) : com.google.android.libraries.geo.mapcore.internal.model.ai.c;
                        }
                    }
                }
            } else {
                bt btVarC = baVar.c(cVar.a);
                com.google.android.libraries.geo.mapcore.internal.model.aq aqVar = cVar.d;
                bt btVarK = aqVar != null ? btVarC.k(aqVar.E) : null;
                aiVarF = btVarK != null ? btVarK.f(f2) : btVarC.f(f2);
            }
            if (!((com.google.android.libraries.geo.mapcore.renderer.s) list.get(bA)).b.g()) {
                ((com.google.android.libraries.geo.mapcore.renderer.s) list.get(bA)).a(aiVarF.H);
            }
            com.google.android.libraries.geo.mapcore.renderer.s sVar = (com.google.android.libraries.geo.mapcore.renderer.s) list.get(bA);
            int i3 = aiVarF.m;
            int i4 = aiVarF.Q;
            boolean z = aiVarF.g || !aiVarF.s();
            int i5 = aiVarF.H;
            if (!z && i5 != ((Integer) sVar.b.e(0)).intValue()) {
                sVar.a(i5);
                return false;
            }
            if (true == z) {
                i3 = 0;
            }
            sVar.a = i3;
            if (aiVarF.m()) {
                aiVarF.d();
            }
            if (aiVarF.k()) {
                aiVarF.b();
            }
            if (aiVarF.l()) {
                aiVarF.c();
            }
            if (aiVarF.j()) {
                aiVarF.a();
            }
        }
        return true;
    }

    public final int f(ae aeVar) {
        int iC = this.c.c(aeVar);
        if (iC == 1) {
            this.g.add(new com.google.android.libraries.navigation.internal.qh.b());
        } else if (iC == 3) {
            com.google.android.libraries.navigation.internal.zb.j.a aVar = com.google.android.libraries.navigation.internal.zb.j.b;
            new ah(this, "area", 64);
            ((com.google.android.libraries.navigation.internal.zb.h) aVar.F(1063)).s("Failure adding AreaStyleKey: %s", aeVar);
        }
        return iC;
    }

    public final er g(String str, com.google.android.libraries.navigation.internal.qy.h hVar, final com.google.android.libraries.geo.mapcore.renderer.ax axVar) {
        ep epVar = axVar.o;
        int iHashCode = str.hashCode();
        if (epVar != null) {
            er erVarG = epVar.g(iHashCode);
            if (erVarG != null) {
                return erVarG;
            }
            com.google.android.libraries.navigation.internal.qz.k kVarB = hVar.b(str, "GLVectorTileStyler#getResourceBitmap()", null);
            if (kVarB.p()) {
                Bitmap bitmapC = kVarB.c();
                if (bitmapC != null) {
                    return epVar.f(bitmapC, iHashCode, -1, 0, 0, 1.0f);
                }
            } else {
                kVarB.h(new com.google.android.libraries.navigation.internal.qz.g() { // from class: com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ad
                    @Override // com.google.android.libraries.navigation.internal.qz.g
                    public final void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
                        this.a.c(axVar);
                    }
                });
                if (kVarB.p()) {
                    c(axVar);
                }
            }
        }
        return null;
    }

    public final void h(int i, com.google.android.libraries.navigation.internal.qy.h hVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar) {
        er erVarG;
        er erVarG2;
        for (ae aeVar : this.c.b()) {
            byte bA = this.c.a(aeVar);
            com.google.android.libraries.geo.mapcore.internal.model.ba baVar = aeVar.b;
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarA = this.a.a(baVar, baVar.e() ? i : aeVar.c);
            if (((com.google.android.libraries.navigation.internal.qh.b) this.g.get(bA)).o == null) {
                ((com.google.android.libraries.navigation.internal.qh.b) this.g.get(bA)).o = Integer.valueOf(aiVarA.H);
            }
            com.google.android.libraries.navigation.internal.qh.b bVar = (com.google.android.libraries.navigation.internal.qh.b) this.g.get(bA);
            com.google.android.libraries.navigation.internal.pt.d dVar = aeVar.a;
            List list = this.h;
            boolean z = !d.e(aiVarA, m.AREA_STROKE) || d.f(aiVarA, m.AREA_STROKE);
            if (dVar != null) {
                int i2 = dVar.c;
                bVar.b(i2 > 0 ? 1862270976 : i2 < 0 ? -872415232 : 0, 0);
            } else {
                bVar.b(aiVarA.d ? 0 : aiVarA.j, z ? 0 : aiVarA.f58n[0].b);
            }
            bVar.c = false;
            bVar.d = false;
            bVar.e = 0;
            bVar.f = 0;
            bVar.g = 0;
            bVar.h = 0;
            bVar.i = 0;
            bVar.j = 0;
            bVar.k = 0;
            bVar.l = 0;
            bVar.m = 0;
            bVar.f555n = 0;
            if (axVar.o != null && aiVarA.h()) {
                if (aiVarA.M != -1 && (erVarG2 = g(((com.google.android.libraries.geo.mapcore.internal.vector.gl.a) aiVarA.N).a, hVar, axVar)) != null) {
                    int iC = com.google.android.libraries.navigation.internal.qh.b.c(aiVarA.S, aiVarA.T, aiVarA.U);
                    bVar.j = erVarG2.b;
                    bVar.k = erVarG2.c;
                    bVar.l = erVarG2.d;
                    bVar.m = erVarG2.e;
                    bVar.f555n = iC;
                    bVar.d = true;
                    list.add(erVarG2);
                }
                if (aiVarA.O != -1 && (erVarG = g(((com.google.android.libraries.geo.mapcore.internal.vector.gl.a) aiVarA.P).a, hVar, axVar)) != null) {
                    int iC2 = com.google.android.libraries.navigation.internal.qh.b.c(aiVarA.V, aiVarA.W, aiVarA.X);
                    bVar.e = erVarG.b;
                    bVar.f = erVarG.c;
                    bVar.g = erVarG.d;
                    bVar.h = erVarG.e;
                    bVar.i = iC2;
                    bVar.c = true;
                    list.add(erVarG);
                }
            }
            int i3 = aiVarA.H;
            if (!z || !aiVarA.d) {
                Integer num = bVar.o;
            }
        }
        this.m = false;
    }

    public final void i(float f) {
        e(this.i, this.d, f);
    }

    public final void j(float f) {
        e(this.j, this.e, f);
    }

    public aj(cd cdVar, com.google.android.libraries.navigation.internal.adi.an anVar) {
        this.a = new com.google.android.libraries.navigation.internal.qh.c();
        this.c = new ai(64);
        this.d = new ai(16);
        this.e = new ai(16);
        this.f = new ai(4);
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new HashMap();
        this.m = false;
        this.b = "tile at " + cdVar.toString() + ", tileType " + anVar.name();
    }
}
