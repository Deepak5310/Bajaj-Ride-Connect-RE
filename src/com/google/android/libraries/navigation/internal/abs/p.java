package com.google.android.libraries.navigation.internal.abs;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Visibility;
import com.google.android.libraries.navigation.internal.abf.ae;
import com.google.android.libraries.navigation.internal.abf.ah;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.kc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements com.google.android.libraries.navigation.internal.abt.l {
    public static final String a = "p";
    public static final ThreadLocal b = com.google.android.libraries.navigation.internal.abw.k.p();
    public static final ThreadLocal c;
    public static final ThreadLocal d;
    public final com.google.android.libraries.navigation.internal.abt.c e;
    public final com.google.android.libraries.navigation.internal.abt.e f;
    public final com.google.android.libraries.navigation.internal.abw.j g;
    public final com.google.android.libraries.navigation.internal.abt.m h;
    public final com.google.android.libraries.navigation.internal.abw.h i;
    public final int j;
    public final c k;
    public final e l;
    final h[] m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final h[] f150n;
    final ConcurrentLinkedQueue o;
    public boolean p;
    private final String q;
    private final Executor r;
    private final b s;
    private final o t;

    static {
        ExecutorService executorService = ah.a;
        c = new ae();
        d = new ae();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(com.google.android.libraries.navigation.internal.abt.c cVar, com.google.android.libraries.navigation.internal.abt.m mVar, com.google.android.libraries.navigation.internal.abw.h hVar, int i) {
        c cVar2 = new c(16);
        ExecutorService executorServiceC = ah.c("sv-mesh", 4);
        b bVar = b.a;
        e eVar = e.a;
        o oVar = o.a;
        com.google.android.libraries.navigation.internal.abf.s.k(cVar, "pano");
        this.e = cVar;
        int i2 = 1;
        com.google.android.libraries.navigation.internal.abf.s.a(!cVar.i(), "NULL_TARGET");
        this.q = cVar.b;
        com.google.android.libraries.navigation.internal.abf.s.d(!cVar.i(), "NULL_TARGET");
        this.f = cVar.c;
        com.google.android.libraries.navigation.internal.abf.s.d(!cVar.i(), "NULL_TARGET");
        com.google.android.libraries.navigation.internal.abw.j jVar = new com.google.android.libraries.navigation.internal.abw.j();
        int i3 = 0;
        jVar.b(0, 0, 0, cVar.c);
        int i4 = 1;
        while (i4 < cVar.j.size()) {
            com.google.android.libraries.navigation.internal.abf.q qVar = (com.google.android.libraries.navigation.internal.abf.q) cVar.j.get(i4);
            int iIntValue = ((Integer) qVar.a).intValue();
            int iIntValue2 = ((Integer) qVar.b).intValue();
            int i5 = i2 << i4;
            Integer num = cVar.h;
            int iIntValue3 = iIntValue / num.intValue();
            int iMin = Math.min(iIntValue % num.intValue() != 0 ? iIntValue3 + 1 : iIntValue3, i5);
            Integer num2 = cVar.i;
            int iIntValue4 = iIntValue2 / num2.intValue();
            int iMin2 = Math.min(iIntValue2 % num2.intValue() != 0 ? iIntValue4 + 1 : iIntValue4, i5);
            int i6 = i3;
            while (i6 < iMin) {
                int i7 = i6 + 1;
                int i8 = i3;
                while (i8 < iMin2) {
                    Integer num3 = cVar.h;
                    int i9 = iMin2;
                    int iIntValue5 = (num3.intValue() * i7) - iIntValue;
                    int i10 = i8 + 1;
                    int i11 = i6;
                    Integer num4 = cVar.i;
                    jVar.b(i4, i11, i8, new com.google.android.libraries.navigation.internal.abt.e(cVar.b, i11, i8, i4, num3.intValue() - Math.max(0, iIntValue5), num4.intValue() - Math.max(0, (num4.intValue() * i10) - iIntValue2)));
                    iMin = iMin;
                    i6 = i11;
                    iMin2 = i9;
                    i8 = i10;
                    oVar = oVar;
                    i3 = 0;
                }
                i6 = i7;
            }
            i4++;
            i2 = 1;
            i3 = 0;
        }
        this.g = jVar;
        com.google.android.libraries.navigation.internal.abf.s.b(true, "Invalid maxNumCachedTextures: %s", 16);
        this.j = 16;
        com.google.android.libraries.navigation.internal.abf.s.k(mVar, "tileProvider");
        this.h = mVar;
        com.google.android.libraries.navigation.internal.abf.s.k(hVar, "frameRequestor");
        this.i = hVar;
        this.k = cVar2;
        com.google.android.libraries.navigation.internal.abf.s.k(executorServiceC, "backgroundThreadPool");
        this.r = executorServiceC;
        this.s = bVar;
        com.google.android.libraries.navigation.internal.abf.s.k(eVar, "glUtils2");
        this.l = eVar;
        this.t = oVar;
        this.m = new h[cVar.b() + 1];
        this.f150n = new h[cVar.b() + 1];
        this.o = new ConcurrentLinkedQueue();
        this.p = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void h(h[] hVarArr) {
        for (int i = 0; i < hVarArr.length; i++) {
            h hVar = hVarArr[i];
            if (hVar != null) {
                try {
                    if (hVar.h != null) {
                        com.google.android.libraries.navigation.internal.abf.p.f(h.a, 3);
                        ev evVar = hVar.c;
                        int size = evVar.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            g gVar = (g) hVar.h.get((com.google.android.libraries.navigation.internal.abt.e) evVar.get(i2));
                            if (gVar.g) {
                                gVar.f.h(gVar.h);
                                gVar.f.h(gVar.i);
                                gVar.f.h(gVar.j);
                                gVar.h = null;
                                gVar.i = null;
                                gVar.j = null;
                                gVar.g = false;
                            } else {
                                com.google.android.libraries.navigation.internal.abf.p.f(g.a, 6);
                            }
                        }
                        hVar.h = null;
                        hVar.i = null;
                    }
                } catch (Error | RuntimeException unused) {
                    com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
                }
                hVarArr[i] = null;
            }
        }
    }

    public final void a() {
        if (this.p) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
            return;
        }
        this.p = true;
        com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
        try {
            c cVar = this.k;
            if (cVar.g) {
                cVar.f.clear();
                cVar.e.clear();
                cVar.b.d(16, cVar.d);
                Arrays.fill(cVar.d, 0);
                cVar.g = false;
            } else {
                com.google.android.libraries.navigation.internal.abf.p.f(c.a, 6);
            }
        } catch (Error | RuntimeException unused) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
        }
        h(this.m);
        h(this.f150n);
        this.o.clear();
        this.g.a.clear();
    }

    final void b(int i, final boolean z) {
        com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
        h[] hVarArr = z ? this.f150n : this.m;
        if (hVarArr[i] != null) {
            return;
        }
        com.google.android.libraries.navigation.internal.abw.j jVar = this.g;
        com.google.android.libraries.navigation.internal.abf.s.b(i >= 0, "illegal zoomLevel: %s", Integer.valueOf(i));
        ArrayList arrayList = new ArrayList();
        int i2 = 2 << i;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                com.google.android.libraries.navigation.internal.abt.e eVar = (com.google.android.libraries.navigation.internal.abt.e) jVar.a(i, i3, i4);
                if (eVar != null) {
                    arrayList.add(eVar);
                }
            }
        }
        final h hVar = new h(i, ev.o(arrayList), d.a, b.a);
        hVarArr[i] = hVar;
        this.r.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abs.n
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r14v0 */
            /* JADX WARN: Type inference failed for: r14v1, types: [int] */
            /* JADX WARN: Type inference failed for: r14v11 */
            /* JADX WARN: Type inference failed for: r5v8, types: [int] */
            @Override // java.lang.Runnable
            public final void run() {
                int i5;
                float fD;
                int i6;
                float fC;
                n nVar = this;
                p pVar = nVar.a;
                com.google.android.libraries.navigation.internal.abt.c cVar = pVar.e;
                com.google.android.libraries.navigation.internal.abf.s.k(cVar, "pano");
                boolean z2 = true;
                com.google.android.libraries.navigation.internal.abf.s.a(!cVar.i(), "NULL_TARGET");
                com.google.android.libraries.navigation.internal.abf.p.f(h.a, 3);
                com.google.android.libraries.navigation.internal.abf.s.d(!cVar.i(), "NULL_TARGET");
                int size = cVar.j.size();
                h hVar2 = hVar;
                int i7 = hVar2.b;
                com.google.android.libraries.navigation.internal.abf.s.b(i7 < size, "Illegal zoom level [%s] >= [%s]", Integer.valueOf(i7), Integer.valueOf(cVar.j.size()));
                com.google.android.libraries.navigation.internal.abf.q qVar = (com.google.android.libraries.navigation.internal.abf.q) cVar.j.get(i7);
                HashMap map = new HashMap(kc.a(hVar2.c.size()));
                float[] fArr = new float[hVar2.c.size() * 4];
                int i8 = 0;
                while (i8 < hVar2.c.size()) {
                    boolean z3 = z;
                    ?? r14 = z2 != z3 ? z2 : 2;
                    com.google.android.libraries.navigation.internal.abt.e eVar2 = (com.google.android.libraries.navigation.internal.abt.e) hVar2.c.get(i8);
                    int iCeil = (int) Math.ceil((eVar2.e / cVar.d()) * 32.0f * (eVar2.e / ((Integer) qVar.a).intValue()));
                    int iCeil2 = (int) Math.ceil((eVar2.f / cVar.c()) * 32.0f * (eVar2.f / ((Integer) qVar.b).intValue()));
                    com.google.android.libraries.navigation.internal.abf.s.k(cVar, "pano");
                    com.google.android.libraries.navigation.internal.abf.s.a(!cVar.i(), "NULL_TARGET");
                    com.google.android.libraries.navigation.internal.abf.s.k(eVar2, "coord");
                    com.google.android.libraries.navigation.internal.abf.s.b(eVar2.d <= cVar.b(), "Coord OOB: %s vs %s", eVar2, cVar);
                    ?? r5 = iCeil * r14;
                    com.google.android.libraries.navigation.internal.abf.s.b(r5 > 0, "gridMeshQuadWidth:%s", Integer.valueOf((int) r5));
                    int i9 = r14 * iCeil2;
                    com.google.android.libraries.navigation.internal.abf.s.b(i9 > 0, "gridMeshQuadHeight:%s", Integer.valueOf(i9));
                    com.google.android.libraries.navigation.internal.abf.s.i(200.0f, "defaultRadiusM");
                    g gVar = new g(String.format("Tile#Z%s@[X%s,Y%s]", Integer.valueOf(eVar2.d), Integer.valueOf(eVar2.b), Integer.valueOf(eVar2.c)), r5, i9);
                    int iB = cVar.b() - eVar2.d;
                    com.google.android.libraries.navigation.internal.abf.s.d(!cVar.i(), "NULL_TARGET");
                    int iIntValue = cVar.g.intValue() >> iB;
                    int iA = cVar.a() >> iB;
                    int iD = eVar2.b * cVar.d();
                    int iC = eVar2.c * cVar.c();
                    int iD2 = (eVar2.b + 1) * cVar.d();
                    int iC2 = (eVar2.c + 1) * cVar.c();
                    int iD3 = cVar.d();
                    int iC3 = cVar.c();
                    if (iD2 > iIntValue) {
                        int i10 = iIntValue - iD;
                        fD = i10 / cVar.d();
                        i5 = i10;
                        iD2 = iIntValue;
                    } else {
                        i5 = iD3;
                        fD = 1.0f;
                    }
                    if (iC2 > iA) {
                        int i11 = iA - iC;
                        fC = i11 / cVar.c();
                        i6 = i11;
                        iC2 = iA;
                    } else {
                        i6 = iC3;
                        fC = 1.0f;
                    }
                    com.google.android.libraries.navigation.internal.abf.s.e(iD < iD2 && iC < iC2, "Illegal Tile %s for %s", eVar2, cVar);
                    com.google.android.libraries.navigation.internal.abt.n nVarF = cVar.f();
                    com.google.android.libraries.navigation.internal.abu.a aVarG = z3 ? cVar.g() : null;
                    float[] fArr2 = {0.0f, 0.0f, 0.0f, 1.0f};
                    com.google.android.libraries.navigation.internal.abt.c cVar2 = cVar;
                    int i12 = 0;
                    while (i12 <= gVar.b) {
                        int i13 = i8;
                        int i14 = 0;
                        while (true) {
                            int i15 = gVar.c;
                            if (i14 <= i15) {
                                float f = fC;
                                float f2 = i12;
                                int i16 = i12;
                                int i17 = gVar.b;
                                g gVar2 = gVar;
                                float f3 = iD;
                                int i18 = iD;
                                float f4 = i5;
                                int i19 = i5;
                                float f5 = iIntValue;
                                int i20 = iIntValue;
                                float f6 = iC;
                                int i21 = iC;
                                float f7 = i6;
                                int i22 = i6;
                                float f8 = iA;
                                int i23 = iA;
                                float f9 = f2 / i17;
                                float f10 = i14 / i15;
                                float f11 = ((f3 + (f4 * f9)) / f5) * 360.0f;
                                float f12 = 90.0f - (((f6 + (f7 * f10)) / f8) * 180.0f);
                                float f13 = f11 - 180.0f;
                                com.google.android.libraries.navigation.internal.abt.i.c(f12, f13, fArr2);
                                float fAbs = aVarG != null ? Math.abs(aVarG.a(nVarF, f12, f13 + nVarF.b, 200.0f)) : 200.0f;
                                float f14 = fArr2[0] * fAbs;
                                fArr2[0] = f14;
                                float f15 = fArr2[1] * fAbs;
                                fArr2[1] = f15;
                                float f16 = fArr2[2] * fAbs;
                                fArr2[2] = f16;
                                gVar2.e(i16, i14, f14, f15, f16, f9 * fD, f10 * f);
                                i14++;
                                fC = f;
                                i12 = i16;
                                gVar = gVar2;
                                iD = i18;
                                i5 = i19;
                                iIntValue = i20;
                                iC = i21;
                                i6 = i22;
                                iA = i23;
                            }
                        }
                        i12++;
                        i8 = i13;
                        gVar = gVar;
                        iIntValue = iIntValue;
                        i6 = i6;
                    }
                    g gVar3 = gVar;
                    int i24 = i8;
                    float[] fArr3 = fArr;
                    Visibility.computeBoundingSphere(gVar3.k, 0, gVar3.d * gVar3.e, fArr3, i24 * 4);
                    HashMap map2 = map;
                    map2.put(eVar2, gVar3);
                    i8 = i24 + 1;
                    nVar = this;
                    fArr = fArr3;
                    z2 = true;
                    qVar = qVar;
                    cVar = cVar2;
                    map = map2;
                    pVar = pVar;
                }
                p pVar2 = pVar;
                float[] fArr4 = fArr;
                HashMap map3 = map;
                synchronized (hVar2) {
                    hVar2.j = map3;
                    hVar2.k = fArr4;
                }
                com.google.android.libraries.navigation.internal.abf.p.f(h.a, 3);
                pVar2.o.add(hVar2);
                pVar2.i.b();
            }
        });
    }

    public final void c(com.google.android.libraries.navigation.internal.abt.d dVar, Bitmap bitmap) {
        int iIntValue;
        String str = a;
        com.google.android.libraries.navigation.internal.abf.p.f(str, 4);
        com.google.android.libraries.navigation.internal.abf.s.k(dVar, "key");
        if (this.p) {
            com.google.android.libraries.navigation.internal.abf.p.f(str, 5);
            return;
        }
        if (bitmap == null) {
            return;
        }
        this.k.a(this.f);
        try {
            c cVar = this.k;
            com.google.android.libraries.navigation.internal.abf.s.k(dVar, "key");
            if (cVar.g) {
                Integer num = (Integer) cVar.f.get(dVar);
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    cVar.f.put(dVar, 0);
                    com.google.android.libraries.navigation.internal.abf.s.d(!cVar.e.isEmpty(), String.format("Failed to gc handles: %s", cVar));
                    iIntValue = ((Integer) cVar.e.pop()).intValue();
                }
                cVar.c.i(iIntValue, bitmap);
                cVar.f.put(dVar, Integer.valueOf(iIntValue));
                com.google.android.libraries.navigation.internal.abf.p.f(c.a, 3);
            } else {
                com.google.android.libraries.navigation.internal.abf.p.f(c.a, 6);
            }
        } catch (Error | RuntimeException unused) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
        }
        this.i.b();
    }

    final void d(int i, int i2, com.google.android.libraries.navigation.internal.abt.e eVar, boolean z) {
        g gVarA = (z ? this.f150n : this.m)[eVar.d].a(eVar);
        Integer numA = this.k.a(eVar);
        if (gVarA == null || numA == null) {
            eVar.a();
            return;
        }
        this.s.a();
        this.s.b(numA.intValue());
        this.s.i(i2);
        gVarA.c(i);
        gVarA.d();
    }

    final void e(float[] fArr, int i, float f, boolean z, List list) throws IllegalStateException {
        com.google.android.libraries.navigation.internal.abf.t.b(i != 0, "glShaderProgramHandle");
        GLES20.glUseProgram(i);
        this.s.j(GLES20.glGetUniformLocation(i, "uMVPMatrix"), fArr);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i, "alpha"), f);
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(i, "u_Texture");
        GLES20.glDisable(2929);
        this.s.e();
        if (z) {
            try {
                d(i, iGlGetUniformLocation, this.f, false);
            } catch (Error | RuntimeException unused) {
                com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            try {
                d(i, iGlGetUniformLocation, (com.google.android.libraries.navigation.internal.abt.e) it2.next(), z);
            } catch (Error | RuntimeException unused2) {
                com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
            }
        }
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            return com.google.android.libraries.navigation.internal.abf.r.a(this.q, ((p) obj).q);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void f() {
        com.google.android.libraries.navigation.internal.abf.p.f(a, 2);
        h hVar = (h) this.o.poll();
        while (hVar != null) {
            try {
                if (hVar.h == null) {
                    synchronized (hVar) {
                        try {
                            Map map = hVar.j;
                            if (map != null) {
                                hVar.h = map;
                                hVar.j = null;
                                hVar.i = hVar.k;
                                hVar.k = null;
                                ev evVar = hVar.c;
                                int size = evVar.size();
                                for (int i = 0; i < size; i++) {
                                    ((g) hVar.h.get((com.google.android.libraries.navigation.internal.abt.e) evVar.get(i))).b();
                                }
                                com.google.android.libraries.navigation.internal.abf.p.f(h.a, 3);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Error | RuntimeException unused) {
                com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
            }
            hVar = (h) this.o.poll();
        }
    }

    public final boolean g() {
        return (this.p || this.k.a(this.f) == null || this.m[0].a(this.f) == null || this.f150n[0].a(this.f) == null) ? false : true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.q});
    }

    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("panoId", this.q);
        return ajVarF.c("originalImageMaxTileZoom", this.e.b()).toString();
    }
}
