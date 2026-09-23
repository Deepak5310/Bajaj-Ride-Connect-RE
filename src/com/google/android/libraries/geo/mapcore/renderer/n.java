package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import androidx.tracing.Trace;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.google.android.libraries.geo.mapcore.renderer.jni.RendererJni;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final /* synthetic */ int m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float[] f85n = {0.0f, 0.0f, 1.0f};
    private static final float[] o = {1.0f, 0.0f, 0.0f};
    private static final float[] p = {0.0f, 1.0f, 0.0f};
    public bv a;
    public final q b = new q();
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public static void b(int[] iArr, int i, int i2, int i3, int i4, boolean z, com.google.android.libraries.navigation.internal.agg.de deVar, com.google.android.libraries.navigation.internal.agj.o oVar) {
        int i5 = i * 3;
        float f = iArr[i5];
        float f2 = iArr[i5 + 1];
        float f3 = iArr[i5 + 2];
        int i6 = i2 * 3;
        float f4 = iArr[i6];
        float f5 = iArr[i6 + 1];
        float f6 = iArr[i6 + 2];
        int i7 = i3 * 3;
        float f7 = iArr[i7];
        float f8 = iArr[i7 + 1];
        float f9 = iArr[i7 + 2];
        float f10 = f7 - f4;
        float f11 = f8 - f5;
        float f12 = f9 - f6;
        float f13 = f2 - f5;
        float f14 = f - f4;
        float f15 = (f10 * f13) - (f11 * f14);
        float f16 = f3 - f6;
        float f17 = (f14 * f12) - (f10 * f16);
        float f18 = (f11 * f16) - (f12 * f13);
        float fSqrt = (float) Math.sqrt((f18 * f18) + (f17 * f17) + (f15 * f15));
        float[] fArr = f85n;
        float[] fArr2 = o;
        float[] fArr3 = p;
        float f19 = f18 / fSqrt;
        float f20 = f17 / fSqrt;
        float f21 = f15 / fSqrt;
        int iMin = i4 | (((int) (Math.min((((Math.abs(((fArr[0] * f19) + (fArr[1] * f20)) + (fArr[2] * f21)) + (Math.abs(((fArr2[0] * f19) + (fArr2[1] * f20)) + (fArr2[2] * f21)) * 0.8f)) + (Math.abs(((fArr3[0] * f19) + (fArr3[1] * f20)) + (fArr3[2] * f21)) * 0.5f)) * 0.65f) + 0.35f, 1.0f) * 255.0f)) << 8);
        int i8 = deVar.b / (true != z ? 3 : 4);
        if (z) {
            deVar.c(Float.floatToIntBits(f));
            deVar.c(Float.floatToIntBits(f2));
            deVar.c(Float.floatToIntBits(f3));
            deVar.c(iMin);
            deVar.c(Float.floatToIntBits(f4));
            deVar.c(Float.floatToIntBits(f5));
            deVar.c(Float.floatToIntBits(f6));
            deVar.c(iMin);
            deVar.c(Float.floatToIntBits(f7));
            deVar.c(Float.floatToIntBits(f8));
            deVar.c(Float.floatToIntBits(f9));
            deVar.c(iMin);
        } else {
            deVar.c((((int) f2) << 16) | ((char) f));
            deVar.c((char) f3);
            deVar.c(iMin);
            deVar.c((((int) f5) << 16) | ((char) f4));
            deVar.c((char) f6);
            deVar.c(iMin);
            deVar.c((((int) f8) << 16) | ((char) f7));
            deVar.c((char) f9);
            deVar.c(iMin);
        }
        oVar.i((short) i8);
        oVar.i((short) (i8 + 1));
        oVar.i((short) (i8 + 2));
    }

    private final void c(ArrayList arrayList, u uVar) {
        int i;
        float f;
        n nVar = this;
        bv bvVar = nVar.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
        AtomicReference atomicReference = uVar.e;
        int iP = uVar.p();
        int iQ = uVar.q();
        int i2 = ((v) atomicReference.get()).j;
        float fO = uVar.o();
        float fL = uVar.l();
        int i3 = nVar.e;
        int i4 = nVar.f;
        int i5 = nVar.h;
        int i6 = nVar.g;
        int i7 = nVar.i;
        int i8 = 2884;
        GLES20.glEnable(2884);
        bv.O();
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            m mVar = (m) ((aj) arrayList.get(i9));
            if (mVar.l) {
                int i10 = mVar.c % 2;
                i = size;
                float f2 = i10 + i10 + (mVar.b % 2);
                bvVar.v(f2, f2);
                r rVar = mVar.i;
                if (rVar.g && (rVar.h || rVar.i)) {
                    GLES20.glUniform1f(nVar.k, rVar.e);
                    GLES20.glUniform1f(nVar.l, rVar.f);
                    i2 = i2;
                    fL = fL;
                    GLES20.glUniform4f(i3, ((((mVar.f - iP) + PropertyOptions.DELETE_EXISTING) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK) - 536870912) * fL, (mVar.g - iQ) * fL, (-i2) * fL, mVar.e * fL * 2.4414062E-4f * mVar.h);
                    float f3 = rVar.l;
                    float f4 = 1.0f;
                    if (mVar.j) {
                        float f5 = (19.0f - fO) / 2.0f;
                        if (f5 < 0.1f) {
                            f5 = 0.1f;
                        }
                        f4 = f5 <= 1.0f ? f5 : 1.0f;
                        f = 0.001f;
                    } else {
                        f = 0.0f;
                    }
                    GLES20.glUniform1f(i4, f4);
                    GLES20.glUniform1f(i5, f);
                    GLES20.glUniform1f(i6, f3);
                    if (mVar.j) {
                        RendererJni.a(i7, rVar.d, rVar.c);
                    } else {
                        RendererJni.a(i7, rVar.b, rVar.a);
                    }
                    for (int i11 = 0; i11 < mVar.o.size(); i11++) {
                        bw bwVar = (bw) mVar.o.get(i11);
                        bw bwVar2 = (bw) mVar.p.get(i11);
                        int iN = mVar.q.n(i11);
                        if (bwVar.g && bwVar2.g) {
                            GLES20.glBindBuffer(34962, bwVar.d);
                            if (mVar.k) {
                                GLES20.glVertexAttribPointer(0, 3, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 16, 0);
                                GLES20.glVertexAttribPointer(1, 4, FujifilmMakernoteDirectory.TAG_FILM_MODE, false, 16, 12);
                            } else {
                                GLES20.glVertexAttribPointer(0, 3, FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE_SETTING, false, 12, 0);
                                GLES20.glVertexAttribPointer(1, 4, FujifilmMakernoteDirectory.TAG_FILM_MODE, false, 12, 8);
                            }
                            GLES20.glBindBuffer(34963, bwVar2.d);
                            bvVar.Q(4, iN, 0);
                        }
                    }
                }
                i9++;
                nVar = this;
                size = i;
                i2 = i2;
                fL = fL;
                i8 = 2884;
            } else {
                i = size;
            }
            i9++;
            nVar = this;
            size = i;
            i2 = i2;
            fL = fL;
            i8 = 2884;
        }
        GLES20.glDisable(i8);
    }

    public final void a(eh ehVar, u uVar) {
        bv bvVar = this.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
        bvVar.w(false, 0, 0, 0);
        bvVar.j(this.c);
        bvVar.U(this.d, uVar.G());
        GLES20.glUniform1f(this.j, uVar.o());
        bvVar.o(0);
        bvVar.o(1);
        int i = bt.a().f;
        for (int i2 = 2; i2 < i; i2++) {
            bvVar.n(i2);
        }
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("depthPass");
        try {
            bvVar.r(0, 1);
            bvVar.t(513);
            ArrayList arrayList = ehVar.a;
            c(arrayList, uVar);
            if (dVarB != null) {
                Trace.endSection();
            }
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("colorPass");
            try {
                com.google.android.libraries.navigation.internal.yx.ar.k(bvVar.i);
                if (bvVar.c != 770 || bvVar.d != 771) {
                    GLES20.glEnable(3042);
                    GLES20.glBlendFuncSeparate(770, 771, 1, 771);
                    bvVar.c = 770;
                    bvVar.d = 771;
                }
                bvVar.t(515);
                c(arrayList, uVar);
                if (dVarB2 != null) {
                    Trace.endSection();
                }
                com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("cleanUpGL");
                try {
                    bvVar.z();
                    bvVar.y();
                    for (int i3 = 0; i3 < i; i3++) {
                        bvVar.n(i3);
                    }
                    if (dVarB3 != null) {
                    }
                } catch (Throwable th) {
                    if (dVarB3 != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } finally {
                if (dVarB2 != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
            }
        } catch (Throwable th4) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
            }
            throw th4;
        }
    }
}
