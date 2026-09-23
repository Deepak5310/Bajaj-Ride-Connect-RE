package com.google.android.libraries.navigation.internal.abs;

import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.libraries.navigation.internal.abf.z;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements q {
    public static final String a = "m";
    public final com.google.android.libraries.navigation.internal.abw.h c;
    public final CharSequence[] d;
    public final z e;
    public boolean f;
    public com.google.android.libraries.navigation.internal.abt.c g;
    public List h;
    public int i;
    public RectF[] j;
    public com.google.android.libraries.navigation.internal.abt.i k;
    private final e m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f149n;
    private int o;
    private f p;
    private f q;
    private static final ThreadLocal l = new k();
    static final Rect b = new Rect(-2, -2, -1, -1);

    public m(com.google.android.libraries.navigation.internal.abw.h hVar, CharSequence[] charSequenceArr) {
        z zVar = z.a;
        e eVar = e.a;
        com.google.android.libraries.navigation.internal.abf.s.k(hVar, "frameRequestor");
        this.c = hVar;
        com.google.android.libraries.navigation.internal.abf.s.k(charSequenceArr, "compassDirectionFullStrings");
        this.d = charSequenceArr;
        int length = charSequenceArr.length;
        com.google.android.libraries.navigation.internal.abf.s.a(length == 8, String.format("compassDirectionFullStrings#%s != 8", Integer.valueOf(length)));
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "uiThreadChecker");
        this.e = zVar;
        com.google.android.libraries.navigation.internal.abf.s.k(eVar, "glUtils2");
        this.m = eVar;
        synchronized (this) {
            this.f149n = false;
            this.f = true;
            this.g = com.google.android.libraries.navigation.internal.abt.c.a;
            this.h = null;
            this.i = -1;
            this.j = null;
            this.k = null;
            this.o = -1;
            this.p = null;
            this.q = null;
        }
    }

    private final synchronized void e(l lVar, com.google.android.libraries.navigation.internal.abt.i iVar, float f, float f2) {
        this.e.b();
        Matrix.setIdentityM(lVar.d, 0);
        com.google.android.libraries.navigation.internal.abt.n nVarF = this.g.f();
        double radians = Math.toRadians(nVarF.c);
        Matrix.rotateM(lVar.d, 0, -nVarF.d, (float) (-Math.cos(radians)), 0.0f, (float) (-Math.sin(radians)));
        Matrix.rotateM(lVar.d, 0, 180.0f - f, 0.0f, 1.0f, 0.0f);
        float fCos = (float) Math.cos(Math.toRadians(iVar.f - f));
        Matrix.translateM(lVar.d, 0, 0.0f, 0.0f, (((((0.355f * fCos) + 0.68f) - ((((fCos + fCos) * fCos) - 1.0f) * 0.32f)) - ((fCos * (((4.0f * fCos) * fCos) - 3.0f)) * 0.215f)) * 0.25f) + 0.2f);
        Matrix.translateM(lVar.d, 0, 0.0f, f2, 0.0f);
        if (!this.g.h() || iVar.h > iVar.i) {
            Matrix.translateM(lVar.d, 0, 0.0f, 0.05f, 0.0f);
        }
        Matrix.multiplyMM(lVar.b, 0, lVar.a, 0, lVar.d, 0);
        Matrix.multiplyMM(lVar.c, 0, iVar.h(), 0, lVar.b, 0);
    }

    public final synchronized int a(float f, float f2) {
        RectF[] rectFArr;
        this.e.a();
        String str = a;
        com.google.android.libraries.navigation.internal.abf.p.f(str, 2);
        if (this.f && (rectFArr = this.j) != null) {
            for (int length = rectFArr.length - 1; length >= 0; length--) {
                if (this.j[length].contains(f, f2)) {
                    return length;
                }
            }
            return -1;
        }
        com.google.android.libraries.navigation.internal.abf.p.f(str, 2);
        return -1;
    }

    public final void b(int i) {
        this.e.a();
        synchronized (this) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 2);
            if (this.i == i) {
                return;
            }
            this.i = i;
            this.k = null;
            this.c.b();
        }
    }

    public final synchronized void c(com.google.android.libraries.navigation.internal.abt.i iVar) {
        List list;
        this.e.b();
        com.google.android.libraries.navigation.internal.abf.s.k(iVar, "raycaster");
        if (this.f149n && this.f && !this.g.i() && (list = this.h) != null && !list.isEmpty()) {
            com.google.android.libraries.navigation.internal.abf.r.a(this.k, iVar);
            if (com.google.android.libraries.navigation.internal.abf.p.f(a, 2)) {
                String str = this.g.b;
            }
            l lVar = (l) l.get();
            this.k = iVar;
            int i = 0;
            Matrix.setIdentityM(lVar.a, 0);
            Matrix.translateM(lVar.a, 0, 0.0f, 0.0f, -2.0f);
            Matrix.rotateM(lVar.a, 0, -iVar.e, 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(lVar.a, 0, iVar.f, 0.0f, 1.0f, 0.0f);
            Matrix.translateM(lVar.a, 0, 0.0f, -0.35f, 0.0f);
            GLES20.glDisable(2929);
            GLES20.glDepthMask(false);
            GLES20.glDisable(2884);
            this.j = new RectF[((lv) this.h).c];
            int i2 = 0;
            while (true) {
                List list2 = this.h;
                if (i2 >= ((lv) list2).c) {
                    return;
                }
                float f = i2 == this.i ? 0.0f : -0.1f;
                float f2 = ((com.google.android.libraries.navigation.internal.abt.b) list2.get(i2)).bearing;
                e(lVar, iVar, f2, (-0.04f) + f);
                this.q.a(lVar.c, "shadow#" + i2 + "@" + f2);
                e(lVar, iVar, f2, f);
                this.p.a(lVar.c, "solid#" + i2 + "@" + f2);
                RectF[] rectFArr = this.j;
                float[] fArr = lVar.c;
                float[] fArr2 = lVar.e;
                int i3 = iVar.h;
                int i4 = iVar.i;
                float f3 = Float.MAX_VALUE;
                int i5 = i;
                float fMax = -3.4028235E38f;
                float fMax2 = -3.4028235E38f;
                float f4 = Float.MAX_VALUE;
                while (i5 < 4) {
                    float f5 = f4;
                    float f6 = f3;
                    float f7 = fMax;
                    float f8 = fMax2;
                    int i6 = i4;
                    int i7 = i3;
                    Matrix.multiplyMV(fArr2, 0, fArr, 0, i.e[i5], 0);
                    com.google.android.libraries.navigation.internal.abf.s.a(true, com.google.android.libraries.navigation.internal.b.b.b(4, "vector4.length == "));
                    float f9 = fArr2[3];
                    if (f9 == 0.0f) {
                        throw new IllegalArgumentException("vector4[3] cannot be zero");
                    }
                    com.google.android.libraries.navigation.internal.abf.s.i(f9, "vector4[3] cannot be NaN");
                    float f10 = fArr2[0];
                    float f11 = fArr2[3];
                    float f12 = f10 / f11;
                    fArr2[0] = f12;
                    fArr2[1] = fArr2[1] / f11;
                    fArr2[2] = fArr2[2] / f11;
                    fArr2[3] = 1.0f;
                    float fMin = Math.min(f6, f12);
                    fMax = Math.max(f7, f12);
                    float f13 = fArr2[1];
                    float fMin2 = Math.min(f5, f13);
                    i5++;
                    f3 = fMin;
                    i4 = i6;
                    i3 = i7;
                    fMax2 = Math.max(f8, f13);
                    f4 = fMin2;
                }
                int i8 = i3;
                float f14 = f4;
                float f15 = fMax2;
                float f16 = fMax;
                float f17 = i8;
                float f18 = i4;
                rectFArr[i2] = new RectF((f3 + 1.0f) * f17 * 0.5f, (1.0f - f15) * f18 * 0.5f, (f16 + 1.0f) * f17 * 0.5f, 0.5f * (1.0f - f14) * f18);
                i2++;
                i = 0;
            }
        }
        this.j = null;
    }

    public final void d() {
        this.e.b();
        String str = a;
        com.google.android.libraries.navigation.internal.abf.p.f(str, 4);
        synchronized (this) {
            this.f149n = false;
        }
        try {
            e eVar = e.a;
            com.google.android.libraries.navigation.internal.abf.s.k(str, "tag");
            com.google.android.libraries.navigation.internal.abf.s.k(eVar, "glUtils2");
            this.o = eVar.b(str, "uniform   mat4 uMVPMatrix; attribute vec4 vPosition; attribute vec4 vColor; varying   vec4 fColor; void main() {   gl_Position = uMVPMatrix * vPosition;   fColor = vColor; }", "precision mediump float; varying vec4 fColor; void main() {   gl_FragColor = fColor; }");
            if (this.m.d() != null) {
                com.google.android.libraries.navigation.internal.abf.p.f(str, 6);
                return;
            }
            this.p = new f(i.a, i.b, i.c, this.o);
            this.q = new f(i.a, i.b, i.d, this.o);
            if (this.m.d() != null) {
                com.google.android.libraries.navigation.internal.abf.p.f(str, 6);
                return;
            }
            com.google.android.libraries.navigation.internal.abf.p.f(str, 4);
            synchronized (this) {
                this.f149n = true;
            }
        } catch (RuntimeException unused) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abs.q
    public final void s(com.google.android.libraries.navigation.internal.abt.i iVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.abs.q
    public final void t() {
        throw null;
    }
}
