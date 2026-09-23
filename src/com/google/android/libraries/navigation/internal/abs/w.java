package com.google.android.libraries.navigation.internal.abs;

import android.opengl.Matrix;
import android.opengl.Visibility;
import com.google.android.libraries.navigation.internal.abf.ae;
import com.google.android.libraries.navigation.internal.abf.ah;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w implements com.google.android.libraries.navigation.internal.abt.l {
    public static final String a = "w";
    public static final ThreadLocal b;
    private static final ThreadLocal f = com.google.android.libraries.navigation.internal.abw.k.q();
    private static final ThreadLocal g = com.google.android.libraries.navigation.internal.abw.k.p();
    private static final ThreadLocal h = com.google.android.libraries.navigation.internal.abw.k.p();
    public final e c;
    public int d;
    public final Map e;
    private final com.google.android.libraries.navigation.internal.abt.m i;
    private final com.google.android.libraries.navigation.internal.abw.h j;
    private final v k;

    static {
        ExecutorService executorService = ah.a;
        b = new ae();
    }

    public w(com.google.android.libraries.navigation.internal.abt.m mVar, com.google.android.libraries.navigation.internal.abw.h hVar, double d) {
        e eVar = e.a;
        v vVar = v.a;
        com.google.android.libraries.navigation.internal.abf.s.k(mVar, "tileProvider");
        this.i = mVar;
        com.google.android.libraries.navigation.internal.abf.s.b(true, "tileMemoryCacheSize[%s] < %s", 17, 2);
        com.google.android.libraries.navigation.internal.abf.s.k(hVar, "frameRequestor");
        this.j = hVar;
        com.google.android.libraries.navigation.internal.abf.s.h(d, "displayDensityRatio cannot be NaN");
        com.google.android.libraries.navigation.internal.abf.s.b(d > 0.0d, "displayDensityRatio[%s] <= 0", Double.valueOf(d));
        com.google.android.libraries.navigation.internal.abf.s.k(eVar, "glUtils2");
        this.c = eVar;
        this.k = vVar;
        this.d = 0;
        this.e = new HashMap();
    }

    public final p a(com.google.android.libraries.navigation.internal.abt.c cVar) {
        if (cVar.i()) {
            return null;
        }
        p pVar = (p) this.e.get(cVar.b);
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(cVar, this.i, this.j, 16);
        c cVar2 = pVar2.k;
        if (cVar2.g) {
            com.google.android.libraries.navigation.internal.abf.p.f(c.a, 6);
        } else {
            Arrays.fill(cVar2.d, 0);
            cVar2.b.g(16, cVar2.d);
            int[] iArr = cVar2.d;
            for (int i = 0; i < 16; i++) {
                int i2 = iArr[i];
                if (i2 != 0) {
                    cVar2.e.push(Integer.valueOf(i2));
                }
            }
            cVar2.e.size();
            com.google.android.libraries.navigation.internal.abf.s.d(!cVar2.e.isEmpty(), "Failed to allocate GL texture pool.");
            cVar2.g = true;
            if (com.google.android.libraries.navigation.internal.abf.p.f(c.a, 3)) {
                Arrays.toString(cVar2.d);
            }
        }
        pVar2.b(0, false);
        pVar2.b(0, true);
        pVar2.h.a(pVar2.f);
        this.e.put(cVar.b, pVar2);
        return pVar2;
    }

    public final void b() {
        String str = a;
        com.google.android.libraries.navigation.internal.abf.p.f(str, 4);
        this.c.j(String.format("%s.delete()::start", str));
        Iterator it2 = this.e.values().iterator();
        while (it2.hasNext()) {
            ((p) it2.next()).a();
        }
        this.e.clear();
        this.c.j(String.format("%s.delete()::end", a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c(p pVar, double d, double d2, float[] fArr, com.google.android.libraries.navigation.internal.abt.i iVar, boolean z) {
        int length;
        float[] fArrG;
        int i;
        int i2;
        int i3;
        int i4 = 1;
        if (pVar == null) {
            return true;
        }
        int i5 = 0;
        if (fArr == null) {
            fArrG = iVar.g();
        } else {
            float[] fArr2 = (float[]) f.get();
            System.arraycopy(fArr, 0, fArr2, 0, 4);
            int i6 = 0;
            while (true) {
                length = fArr2.length;
                if (i6 >= length) {
                    break;
                }
                fArr2[i6] = fArr2[i6] * ((float) d2);
                i6++;
            }
            float[] fArr3 = (float[]) g.get();
            com.google.android.libraries.navigation.internal.abf.s.k(fArr2, "eyePos");
            com.google.android.libraries.navigation.internal.abf.s.b(length >= 3, "illegal length %s < %s", Integer.valueOf(length), 3);
            com.google.android.libraries.navigation.internal.abf.s.k(fArr3, "outputMatrix");
            int length2 = fArr3.length;
            com.google.android.libraries.navigation.internal.abf.s.b(length2 == 16, "illegal length %s != %s", Integer.valueOf(length2), 16);
            float[] fArr4 = (float[]) com.google.android.libraries.navigation.internal.abt.i.c.get();
            com.google.android.libraries.navigation.internal.abt.i.c(com.google.android.libraries.navigation.internal.abw.k.i(iVar.e, -89.9f, 89.9f), iVar.f, fArr4);
            float f2 = fArr4[0] + fArr2[0];
            fArr4[0] = f2;
            float f3 = fArr4[1] + fArr2[1];
            fArr4[1] = f3;
            float f4 = fArr4[2] + fArr2[2];
            fArr4[2] = f4;
            float f5 = fArr2[0];
            float f6 = fArr2[1];
            float f7 = fArr2[2];
            float[] fArr5 = com.google.android.libraries.navigation.internal.abt.i.d;
            Matrix.setLookAtM(fArr3, 0, f5, f6, f7, f2, f3, f4, fArr5[0], fArr5[1], fArr5[2]);
            fArrG = (float[]) h.get();
            Matrix.multiplyMM(fArrG, 0, iVar.h(), 0, fArr3, 0);
        }
        int i7 = this.d;
        float f8 = (float) d;
        boolean z2 = fArr != null;
        com.google.android.libraries.navigation.internal.abf.s.k(iVar, "rendererRaycaster");
        com.google.android.libraries.navigation.internal.abf.s.k(fArrG, "customLookAtAndProjMatrix");
        com.google.android.libraries.navigation.internal.abf.t.a(i7 != 0, "glShaderProgramHandle");
        double d3 = f8;
        com.google.android.libraries.navigation.internal.abf.t.a(d3 >= 0.0d && d3 <= 1.0d, String.format("Invalid opacity %s", Float.valueOf(f8)));
        if (pVar.p) {
            com.google.android.libraries.navigation.internal.abf.p.f(p.a, 5);
        } else {
            com.google.android.libraries.navigation.internal.abf.p.f(p.a, 2);
            pVar.l.j(String.format("%s.onDrawFrame()::START", p.a));
            float[] fArr6 = pVar.e.f().g;
            float[] fArr7 = (float[]) p.b.get();
            Matrix.multiplyMM(fArr7, 0, fArrG, 0, fArr6, 0);
            List<com.google.android.libraries.navigation.internal.abt.e> list = (List) p.c.get();
            List list2 = (List) p.d.get();
            list.clear();
            list2.clear();
            float f9 = iVar.k;
            float fExp = (float) Math.exp(((double) (-iVar.g)) * com.google.android.libraries.navigation.internal.abw.k.a);
            int iFloor = (int) Math.floor(com.google.android.libraries.navigation.internal.abw.k.k(((fExp * 0.25f) * pVar.e.a()) / iVar.i) + (f9 > 1.0f ? 1.0f : 2.0f));
            int i8 = -1;
            int iMin = Math.min(pVar.e.b(), Math.max(0, (int) com.google.android.libraries.navigation.internal.abw.k.i((pVar.e.b() - 1) - iFloor, 1.0f, iVar.g + 3.0f)));
            pVar.f();
            h[] hVarArr = z2 ? pVar.f150n : pVar.m;
            if (hVarArr[iMin] == null && z) {
                pVar.b(iMin, false);
                pVar.b(iMin, true);
            }
            while (true) {
                if (iMin < 0) {
                    list.add(pVar.f);
                    break;
                }
                h hVar = hVarArr[iMin];
                if (hVar != null && hVar.b()) {
                    h hVar2 = hVarArr[iMin];
                    com.google.android.libraries.navigation.internal.abf.s.k(fArr7, "mvpMatrix");
                    com.google.android.libraries.navigation.internal.abf.s.k(list, "output");
                    if (hVar2.c.size() == i4) {
                        list.add((com.google.android.libraries.navigation.internal.abt.e) hVar2.c.get(i5));
                        i = i8;
                    } else {
                        com.google.android.libraries.navigation.internal.abf.s.e(hVar2.b(), "getVisibleTiles(%s)", Integer.valueOf(hVar2.b));
                        Arrays.fill(hVar2.e, i8);
                        b bVar = hVar2.g;
                        float[] fArr8 = hVar2.i;
                        int size = hVar2.c.size();
                        int[] iArr = hVar2.e;
                        i = i8;
                        int iFrustumCullSpheres = Visibility.frustumCullSpheres(fArr7, 0, fArr8, 0, size, iArr, 0, iArr.length);
                        if (iFrustumCullSpheres != 0) {
                            int iMin2 = Math.min(Math.max(i5, iFrustumCullSpheres), hVar2.e.length);
                            int i9 = i5;
                            while (i9 < iMin2) {
                                int i10 = hVar2.e[i9];
                                if (i10 < 0 || i10 >= hVar2.c.size()) {
                                    i2 = iMin2;
                                    i3 = i9;
                                    if (com.google.android.libraries.navigation.internal.abf.p.f(h.a, 6)) {
                                        Arrays.toString(fArr7);
                                        Arrays.toString(hVar2.e);
                                    }
                                } else {
                                    com.google.android.libraries.navigation.internal.abt.e eVar = (com.google.android.libraries.navigation.internal.abt.e) hVar2.c.get(i10);
                                    g gVar = (g) hVar2.h.get(eVar);
                                    b bVar2 = hVar2.g;
                                    float[] fArr9 = gVar.k;
                                    char[] cArr = gVar.l;
                                    i2 = iMin2;
                                    i3 = i9;
                                    if (Visibility.visibilityTest(fArr7, 0, fArr9, 0, cArr, 0, cArr.length) > 0) {
                                        list.add(eVar);
                                    }
                                }
                                i9 = i3 + 1;
                                iMin2 = i2;
                            }
                        }
                    }
                    if (!list.isEmpty()) {
                        if (list.size() < 15) {
                            break;
                        }
                        list.clear();
                    } else {
                        continue;
                    }
                } else {
                    i = i8;
                }
                iMin--;
                i8 = i;
                i4 = 1;
                i5 = 0;
            }
            for (com.google.android.libraries.navigation.internal.abt.e eVar2 : list) {
                boolean z3 = pVar.k.a(eVar2) != null;
                if (!z3 && z) {
                    pVar.h.a(eVar2);
                }
                while (true) {
                    if (z3) {
                        list2.add(eVar2);
                        break;
                    }
                    if (eVar2.a()) {
                        break;
                    }
                    eVar2 = (com.google.android.libraries.navigation.internal.abt.e) pVar.g.a(eVar2.d - 1, eVar2.b / 2, eVar2.c / 2);
                    if (eVar2 == null) {
                        eVar2 = pVar.f;
                    }
                    z3 = pVar.k.a(eVar2) != null;
                }
            }
            Collections.sort(list2);
            pVar.e(fArr7, i7, f8, z2, list2);
            pVar.l.j(String.format("%s.onDrawFrame()::END", p.a));
            if (com.google.android.libraries.navigation.internal.abf.p.f(p.a, 3)) {
                list.size();
                list2.size();
            }
        }
        return pVar.g();
    }
}
