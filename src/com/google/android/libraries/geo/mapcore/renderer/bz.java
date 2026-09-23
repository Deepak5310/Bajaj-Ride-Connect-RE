package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import android.os.Process;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bz implements bq {
    private static final int[] c = bp.values$ar$edu$a124e666_0();
    private bv b = null;
    private final by[] a = new by[c.length];

    public bz() {
        int i = 0;
        while (true) {
            int[] iArr = c;
            if (i >= iArr.length) {
                return;
            }
            this.a[i] = new by(iArr[i]);
            i++;
        }
    }

    public static bw h(int i, bv bvVar, String str, int i2) {
        if (i == 0) {
            throw null;
        }
        switch (i) {
            case 34962:
                bw bwVarF = bvVar.f(str);
                bvVar.k(bwVarF);
                if (i == 0) {
                    throw null;
                }
                bvVar.s(i, i2, null, 35044);
                return bwVarF;
            case 34963:
                bw bwVarD = bvVar.d(str);
                bvVar.i(bwVarD);
                if (i == 0) {
                    throw null;
                }
                bvVar.s(i, i2, null, 35044);
                return bwVarD;
            default:
                throw new IllegalArgumentException("Unexpected type ".concat(String.valueOf(bp.a(i))));
        }
    }

    private final bw i(int i, bv bvVar, String str, int i2) {
        bw bwVar;
        j(bvVar);
        if (i == -2 || i == -3) {
            return h(l(i), bvVar, str, i2);
        }
        synchronized (this) {
            by byVar = this.a[k(i)];
            if (byVar.c == 0) {
                byVar.b = h(byVar.d, bvVar, "arena", byVar.a);
            }
            byVar.c++;
            bw bwVar2 = byVar.b;
            int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            com.google.android.libraries.navigation.internal.yx.ar.a(i2 > 0);
            com.google.android.libraries.navigation.internal.yx.ar.a(i2 + i3 <= bwVar2.e);
            bwVar = new bw(bwVar2.d);
            bwVar.e = i2;
            bwVar.f = i3;
            bwVar.h = true;
            bwVar.a(bwVar2, bwVar2.c);
            int i4 = byVar.d;
            if (i4 == 0) {
                throw null;
            }
            switch (i4) {
                case 34962:
                    bvVar.k(bwVar);
                    break;
                case 34963:
                    bvVar.i(bwVar);
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected type ".concat(String.valueOf(bp.a(i4))));
            }
        }
        return bwVar;
    }

    private final void j(bv bvVar) {
        if (this.b == null) {
            this.b = bvVar;
        }
        com.google.android.libraries.navigation.internal.yx.ar.k(this.b == bvVar);
        com.google.android.libraries.navigation.internal.yx.ar.k(Process.myTid() == bvVar.b);
    }

    private static final int k(int i) {
        return i >> 30;
    }

    private final int l(int i) {
        if (i == -3) {
            return bp.b;
        }
        if (i == -2) {
            return bp.a;
        }
        return c[k(i)];
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bq
    public final void a(bv bvVar, bw bwVar) {
        j(bvVar);
        if (!bwVar.h) {
            bvVar.l(bwVar);
            return;
        }
        synchronized (this) {
            for (by byVar : this.a) {
                if (byVar.b.d == bwVar.d) {
                    com.google.android.libraries.navigation.internal.yx.ar.k(byVar.c > 0);
                    int i = byVar.c - 1;
                    byVar.c = i;
                    if (i == 0) {
                        bvVar.l(byVar.b);
                        byVar.b = bw.a;
                    }
                    bvVar.x(bwVar);
                    return;
                }
            }
            throw new IllegalArgumentException("Tried to release a handle from the wrong arena");
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bq
    public final synchronized void b() {
        this.b = null;
        int i = 0;
        while (true) {
            by[] byVarArr = this.a;
            if (i < byVarArr.length) {
                by byVar = byVarArr[i];
                byVar.c = 0;
                byVar.b = bw.a;
                i++;
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bq
    public final bw c(int i, bv bvVar, String str, byte[] bArr, int i2) {
        bw bwVarI = i(i, bvVar, str, i2);
        int iL = l(i);
        if (iL == 0) {
            throw null;
        }
        GLES20.glBufferSubData(iL, bwVarI.f, i2, bvVar.F(bArr, i2));
        return bwVarI;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bq
    public final bw d(int i, bv bvVar, String str, float[] fArr, int i2) {
        bw bwVarI = i(i, bvVar, str, i2 * 4);
        int iL = l(i);
        if (iL == 0) {
            throw null;
        }
        bvVar.N(iL, bwVarI.f, fArr, i2);
        return bwVarI;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bq
    public final bw e(int i, bv bvVar, String str, int[] iArr, int i2) {
        int i3 = i2 * 4;
        bw bwVarI = i(i, bvVar, str, i3);
        int iL = l(i);
        if (iL == 0) {
            throw null;
        }
        GLES20.glBufferSubData(iL, bwVarI.f, i3, bvVar.G(iArr, i2));
        return bwVarI;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bq
    public final bw f(int i, bv bvVar, String str, short[] sArr, int i2) {
        int i3 = i2 + i2;
        bw bwVarI = i(i, bvVar, str, i3);
        int iL = l(i);
        if (iL == 0) {
            throw null;
        }
        GLES20.glBufferSubData(iL, bwVarI.f, i3, bvVar.H(sArr, i2));
        return bwVarI;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bq
    public final synchronized int g(int i, int i2) {
        int i3;
        int i4 = 0;
        while (true) {
            int[] iArr = c;
            if (i4 >= iArr.length) {
                throw new IllegalArgumentException("Unexpected type ".concat(String.valueOf(bp.a(i))));
            }
            if (iArr[i4] == i) {
                by byVar = this.a[i4];
                if (byVar.b != bw.a) {
                    throw new IllegalStateException("Tried to reserve more arena space after the arena was already made live");
                }
                if (i2 > 2097152) {
                    i3 = -1;
                } else {
                    int i5 = byVar.a;
                    byVar.a = ((i2 + 3) & (-4)) + i5;
                    i3 = i5;
                }
                if (i3 >= 0) {
                    return (1073741823 & i3) | (i4 << 30);
                }
                if (i == 0) {
                    throw null;
                }
                switch (i) {
                    case 34962:
                        return -2;
                    case 34963:
                        return -3;
                    default:
                        throw new IllegalArgumentException("Unexpected type ".concat(String.valueOf(bp.a(i))));
                }
            }
            i4++;
        }
    }
}
