package com.google.android.libraries.navigation.internal.fq;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.libraries.navigation.internal.agh.bu;
import com.google.android.libraries.navigation.internal.agh.dn;
import com.google.android.libraries.navigation.internal.agh.dq;
import com.google.android.libraries.navigation.internal.agh.dr;
import com.google.android.libraries.navigation.internal.agh.du;
import com.google.android.libraries.navigation.internal.agi.gw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class m implements p {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fq.m");
    private final f c;
    private int f;
    private final com.google.android.libraries.navigation.internal.xn.a g;
    private du d = new du();
    private bu e = new bu();
    protected final int a = 96;

    public m(l lVar, f fVar) {
        this.c = fVar;
        com.google.android.libraries.navigation.internal.xn.a aVarE = com.google.android.libraries.navigation.internal.xn.a.e(lVar);
        this.g = aVarE;
        if (fVar != null) {
            fVar.c(this, aVarE);
        }
    }

    private final synchronized Object j(long j) {
        Object objB;
        objB = this.d.b(j);
        if (objB != null) {
            this.f -= this.e.b(j);
            g(objB);
        }
        return objB;
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final String a() {
        return "numItems: " + c() + " measuredSize: " + b();
    }

    public final synchronized int b() {
        return this.f;
    }

    public final synchronized int c() {
        return this.d.k;
    }

    public final synchronized Object d(long j) {
        long j2;
        du duVar = this.d;
        Object obj = null;
        if (j != 0) {
            long[] jArr = duVar.a;
            int iG = duVar.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
            long j3 = jArr[iG];
            if (j3 != 0) {
                if (j == j3) {
                    duVar.z(iG);
                    obj = duVar.b[iG];
                } else {
                    do {
                        iG = (iG + 1) & duVar.c;
                        j2 = jArr[iG];
                        if (j2 == 0) {
                        }
                    } while (j != j2);
                    duVar.z(iG);
                    obj = duVar.b[iG];
                }
            }
        } else if (duVar.d) {
            duVar.z(duVar.h);
            return duVar.b[duVar.h];
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005f A[Catch: all -> 0x00b6, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x000e, B:28:0x0099, B:30:0x00a6, B:32:0x00af, B:31:0x00aa, B:8:0x001b, B:20:0x0053, B:22:0x005f, B:24:0x0086, B:26:0x008f, B:23:0x006a, B:9:0x0020, B:13:0x0034, B:14:0x003c, B:18:0x004a), top: B:38:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x006a A[Catch: all -> 0x00b6, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x000e, B:28:0x0099, B:30:0x00a6, B:32:0x00af, B:31:0x00aa, B:8:0x001b, B:20:0x0053, B:22:0x005f, B:24:0x0086, B:26:0x008f, B:23:0x006a, B:9:0x0020, B:13:0x0034, B:14:0x003c, B:18:0x004a), top: B:38:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x008f A[Catch: all -> 0x00b6, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x000e, B:28:0x0099, B:30:0x00a6, B:32:0x00af, B:31:0x00aa, B:8:0x001b, B:20:0x0053, B:22:0x005f, B:24:0x0086, B:26:0x008f, B:23:0x006a, B:9:0x0020, B:13:0x0034, B:14:0x003c, B:18:0x004a), top: B:38:0x0001 }] */
    public final synchronized void e(long j, Object obj) {
        int i;
        Object objW;
        int i2;
        int i3;
        du duVar = this.d;
        if (j != 0) {
            long[] jArr = duVar.a;
            int iG = duVar.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
            long j2 = jArr[iG];
            if (j2 != 0) {
                if (j2 == j) {
                    duVar.z(iG);
                    objW = duVar.w(iG, obj);
                } else {
                    while (true) {
                        iG = (iG + 1) & duVar.c;
                        long j3 = jArr[iG];
                        if (j3 != 0) {
                            if (j3 == j) {
                                duVar.z(iG);
                                objW = duVar.w(iG, obj);
                            }
                        }
                    }
                }
            }
            i = iG;
            duVar.a[i] = j;
            duVar.b[i] = obj;
            i2 = duVar.k;
            if (i2 == 0) {
                duVar.f = i;
                duVar.e = i;
                duVar.g[i] = -1;
            } else {
                long[] jArr2 = duVar.g;
                int i4 = duVar.f;
                long j4 = jArr2[i4];
                jArr2[i4] = j4 ^ (((((long) i) & 4294967295L) ^ j4) & 4294967295L);
                jArr2[i] = ((((long) i4) & 4294967295L) << 32) | 4294967295L;
                duVar.f = i;
            }
            i3 = i2 + 1;
            duVar.k = i3;
            if (i2 >= duVar.i) {
                duVar.A(com.google.android.libraries.navigation.internal.agc.e.a(i3, 0.75f));
            }
            objW = null;
        } else if (duVar.d) {
            duVar.z(duVar.h);
            objW = duVar.w(duVar.h, obj);
        } else {
            duVar.d = true;
            i = duVar.h;
            duVar.a[i] = j;
            duVar.b[i] = obj;
            i2 = duVar.k;
            if (i2 == 0) {
                duVar.f = i;
                duVar.e = i;
                duVar.g[i] = -1;
            } else {
                long[] jArr3 = duVar.g;
                int i5 = duVar.f;
                long j5 = jArr3[i5];
                jArr3[i5] = j5 ^ (((((long) i) & 4294967295L) ^ j5) & 4294967295L);
                jArr3[i] = ((((long) i5) & 4294967295L) << 32) | 4294967295L;
                duVar.f = i;
            }
            i3 = i2 + 1;
            duVar.k = i3;
            if (i2 >= duVar.i) {
                duVar.A(com.google.android.libraries.navigation.internal.agc.e.a(i3, 0.75f));
            }
            objW = null;
        }
        this.f -= this.e.a(j, 1);
        if (objW != null) {
            g(objW);
        } else {
            f(95);
        }
        this.f++;
    }

    public final synchronized void f(int i) {
        try {
            if (i != 0) {
                while (!this.d.isEmpty() && this.f > i) {
                    i(this.d.p());
                }
                return;
            }
            this.e = new bu();
            if (!this.d.isEmpty()) {
                gw gwVarAR = ((dr) this.d.l()).aR();
                while (gwVarAR.hasNext()) {
                    dq next = ((dn) gwVarAR).next();
                    next.getKey();
                    g(next.getValue());
                    next.getKey();
                    next.getValue();
                }
            }
            this.d = new du();
            this.f = 0;
        } catch (Throwable th) {
            throw th;
        }
    }

    protected void g(Object obj) {
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final synchronized void h(float f) {
        float f2 = 0.5f;
        if (f < 0.0f) {
            try {
                ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F(TypedValues.PositionType.TYPE_DRAWPATH)).s("fraction %f < 0", Float.valueOf(f));
                f = 0.5f;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (f > 1.0f) {
            ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F(TypedValues.PositionType.TYPE_TRANSITION_EASING)).s("fraction %f > 1", Float.valueOf(f));
        } else {
            f2 = f;
        }
        f((int) (b() * f2));
        du duVar = this.d;
        duVar.E(duVar.k);
        bu buVar = this.e;
        buVar.z(buVar.h);
    }

    public final synchronized void i(long j) {
        j(j);
    }
}
