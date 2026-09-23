package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import androidx.collection.ArrayMap;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.renderer.y");
    final ArrayDeque a;
    af b;
    private final ax d;
    private final String e;
    private int f;
    private final int g;
    private final com.google.android.libraries.navigation.internal.yx.aa h;
    private final bv i;
    private final ee j;
    private int k = 0;
    private int l = 0;
    private bw m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private bw f87n;
    private final Map o;
    private ep p;
    private float[] q;
    private int r;

    public y(int i, int i2, com.google.android.libraries.navigation.internal.yx.aa aaVar, bv bvVar, ee eeVar, ax axVar, String str) {
        bw bwVar = bw.a;
        this.m = bwVar;
        this.f87n = bwVar;
        this.a = new ArrayDeque();
        this.p = null;
        this.b = null;
        this.r = 1;
        this.o = new ArrayMap();
        this.f = i;
        this.g = i2;
        this.h = aaVar;
        this.i = bvVar;
        this.j = eeVar;
        this.d = axVar;
        this.e = str;
        this.q = new float[i * i2];
    }

    static final boolean g() {
        int iGlGetError;
        boolean z = false;
        if (bt.a().g) {
            do {
                iGlGetError = GLES20.glGetError();
                if (iGlGetError != 0) {
                    if (iGlGetError != 1285) {
                        switch (iGlGetError) {
                        }
                    }
                    z = true;
                }
            } while (iGlGetError != 0);
        }
        return z;
    }

    private final void h() {
        for (z zVar : this.o.values()) {
            if (zVar != null) {
                zVar.s();
            }
        }
    }

    private final void i() {
        if (this.k == this.l) {
            return;
        }
        af afVar = this.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(afVar);
        Map map = this.o;
        Integer numValueOf = Integer.valueOf(afVar.b());
        z zVar = (z) map.get(numValueOf);
        if (zVar == null) {
            zVar = (z) this.h.ak(afVar);
            zVar.C(true);
            this.d.c(zVar);
            this.o.put(numValueOf, zVar);
        }
        int i = this.k;
        int i2 = this.g;
        int i3 = (i / i2) / 4;
        int i4 = ((this.l - i) / i2) / 4;
        x xVar = this.a.isEmpty() ? new x() : (x) this.a.pop();
        xVar.a = this.p;
        xVar.b = i4 * 6;
        xVar.c = i3 * 12;
        zVar.q().add(xVar);
        this.k = this.l;
    }

    public final w a(ep epVar, af afVar) {
        return b(epVar, afVar, 1);
    }

    public final w b(ep epVar, af afVar, int i) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.r == 1);
        int i2 = this.f;
        int i3 = this.g;
        int i4 = this.l;
        if ((i2 * i3) - i4 < i3 * 4 * i) {
            int i5 = (i4 / i3) + (i * 4);
            if (i5 > 65536) {
                ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1334)).p("Too many labels, can't make label buffer any larger!");
                return null;
            }
            int iMin = Math.min(Math.max(i2 + i2, i5), 65536);
            float[] fArrCopyOf = Arrays.copyOf(this.q, i3 * iMin);
            this.f = iMin;
            this.q = fArrCopyOf;
            if (this.m.b()) {
                this.i.l(this.m);
                this.m = bw.a;
            }
            if (this.f87n.b()) {
                this.i.l(this.f87n);
                this.f87n = bw.a;
            }
        }
        this.r = 2;
        if (this.p != epVar || this.b != afVar) {
            i();
        }
        this.p = epVar;
        this.b = afVar;
        return new w(this.q, this.l);
    }

    public final void c() {
        for (z zVar : this.o.values()) {
            if (zVar != null) {
                this.a.addAll(zVar.q());
                zVar.q().clear();
            }
        }
        this.p = null;
        this.b = null;
        this.k = 0;
        this.l = 0;
    }

    public final void d() {
        int iGlGetError;
        int iGlGetError2;
        i();
        if (bt.a().g) {
            boolean z = false;
            do {
                iGlGetError2 = GLES20.glGetError();
                if (iGlGetError2 != 0) {
                    z = true;
                }
            } while (iGlGetError2 != 0);
            if (z) {
                h();
                return;
            }
        }
        if (!this.m.b()) {
            com.google.android.libraries.navigation.internal.yx.ar.k(!this.m.b());
            com.google.android.libraries.navigation.internal.yx.ar.k(!this.f87n.b());
            int i = this.f / 4;
            int i2 = i * 6;
            short[] sArr = new short[i2];
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * 6;
                int i5 = i3 * 4;
                sArr[i4] = (short) i5;
                short s = (short) (i5 + 3);
                sArr[i4 + 1] = s;
                short s2 = (short) (i5 + 1);
                sArr[i4 + 2] = s2;
                sArr[i4 + 3] = s2;
                sArr[i4 + 4] = s;
                sArr[i4 + 5] = (short) (i5 + 2);
            }
            bw bwVarD = this.i.d(this.e);
            this.f87n = bwVarD;
            this.i.i(bwVarD);
            this.i.M(sArr, i2, 35048);
            boolean zG = g();
            int i6 = this.f * this.g * 4;
            bw bwVarF = this.i.f(this.e);
            this.m = bwVarF;
            this.i.k(bwVarF);
            this.i.s(34962, i6, null, 35048);
            if (zG | g()) {
                h();
                return;
            }
        }
        this.i.k(this.m);
        if (bt.a().g) {
            boolean z2 = false;
            do {
                iGlGetError = GLES20.glGetError();
                if (iGlGetError != 0) {
                    if (iGlGetError != 1285) {
                        switch (iGlGetError) {
                        }
                    }
                    z2 = true;
                }
            } while (iGlGetError != 0);
            if (z2) {
                h();
                return;
            }
        }
        this.i.N(34962, 0, this.q, this.l);
        for (z zVar : this.o.values()) {
            if (zVar != null) {
                zVar.r(this.m, this.f87n, this.j);
            }
        }
    }

    public final void e() {
        for (aj ajVar : this.o.values()) {
            if (ajVar != null) {
                this.d.m(ajVar);
            }
        }
    }

    public final void f(w wVar) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.r == 2);
        this.r = 1;
        com.google.android.libraries.navigation.internal.yx.ar.b(wVar.b >= this.l, "Attempted to move ChunkBufferManager cursor backwards");
        com.google.android.libraries.navigation.internal.yx.ar.b(wVar.b <= this.q.length, "Attempted to move ChunkBufferManager cursor out of bounds");
        this.l = wVar.b;
    }
}
