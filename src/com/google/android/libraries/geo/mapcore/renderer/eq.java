package com.google.android.libraries.geo.mapcore.renderer;

import androidx.tracing.Trace;
import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class eq {
    public final c a;
    public final int b;
    public final int c;
    public int d;
    private final int e;

    public eq(int i, int i2, int i3, int i4) {
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        this.a = new c((int) Math.floor(((double) i) / ((double) i3)), (int) Math.floor(((double) i2) / ((double) i4)));
        this.b = i3;
        this.c = i4;
        this.e = i;
        this.d = 2048;
    }

    public final int a(int i, int i2) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TextureAtlas2Impl.allocateBlock");
        int i3 = -1;
        if (i > 0) {
            try {
                if (i <= this.e && i2 > 0) {
                    int iCeil = (int) Math.ceil(((double) i) / ((double) this.b));
                    int iCeil2 = (int) Math.ceil(((double) i2) / ((double) this.c));
                    int iA = this.a.a(iCeil, iCeil2);
                    if (iA != -1) {
                        i3 = iA;
                    } else {
                        int iF = f() + 256;
                        if (iF <= this.d) {
                            int iFloor = (int) Math.floor(((double) iF) / ((double) this.c));
                            c cVar = this.a;
                            int i4 = iFloor - cVar.b;
                            com.google.android.libraries.navigation.internal.yx.ar.k(i4 > 0);
                            int i5 = cVar.b;
                            int i6 = i4 + i5;
                            BitSet bitSet = new BitSet(i6);
                            bitSet.or(cVar.c);
                            cVar.c = bitSet;
                            BitSet bitSet2 = new BitSet(cVar.a * i6);
                            bitSet2.or(cVar.d);
                            cVar.d = bitSet2;
                            cVar.j = Arrays.copyOf(cVar.j, i6);
                            Arrays.fill(cVar.j, i5, i6, -1);
                            cVar.b = i6;
                            int iA2 = this.a.a(iCeil, iCeil2);
                            if (iA2 != -1) {
                                i3 = iA2;
                            }
                        }
                    }
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
        if (dVarB != null) {
            Trace.endSection();
        }
        return i3;
    }

    public final int b() {
        return this.a.m;
    }

    public final int c() {
        return this.a.b * this.c;
    }

    public final int d(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.k(i >= 0);
        return this.a.e(i) * this.b;
    }

    public final int e(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.k(i >= 0);
        return this.a.f(i) * this.c;
    }

    public final int f() {
        return ((int) Math.ceil(((double) c()) / 256.0d)) * 256;
    }
}
