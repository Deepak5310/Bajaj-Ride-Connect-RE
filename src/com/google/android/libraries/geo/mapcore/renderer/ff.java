package com.google.android.libraries.geo.mapcore.renderer;

import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ff {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    public final String a;
    public bv b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int k;
    final int l;
    public bw m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public bw f83n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    private bq w;
    private int x;
    private fe y;
    private short[] z;

    public ff(String str, fe feVar, int i, int i2, short[] sArr, int i3, bq bqVar) {
        int i4 = 0;
        this.x = 0;
        bw bwVar = bw.a;
        this.A = -1;
        this.B = -1;
        this.C = false;
        this.D = false;
        this.a = str;
        this.y = feVar;
        int i5 = feVar.b;
        this.j = i5;
        this.l = i;
        this.k = i2;
        int i6 = feVar.c;
        this.o = i6;
        this.m = bwVar;
        this.z = sArr;
        this.c = i3;
        this.f83n = bwVar;
        int i7 = i3 + i3;
        this.p = (i5 * i6) + i7;
        boolean z = (i & 2) != 0;
        this.e = z;
        int i8 = i & 1;
        this.d = 1 == i8;
        boolean z2 = (i & 8) != 0;
        this.g = z2;
        boolean z3 = (i & 32) != 0;
        this.h = z3;
        boolean z4 = (i & 16) != 0;
        this.f = z4;
        int i9 = i & 64;
        this.i = i9 != 0;
        if (i8 != 0) {
            i4 = (i9 == 0 ? 3 : 2) * 4;
        } else if (z) {
            int i10 = i9 != 0 ? 2 : 4;
            i4 = i10 + i10;
        }
        if (z2) {
            this.r = i4;
            i4 += 16;
        } else if (z3) {
            this.r = i4;
            i4 += 4;
        } else {
            this.r = -1;
        }
        if (z4) {
            this.q = i4;
            i4 += 8;
        } else {
            this.q = -1;
        }
        if ((i & 2176) != 0) {
            this.s = i4;
            i4 += 4;
        } else {
            this.s = -1;
        }
        if ((i & FujifilmMakernoteDirectory.TAG_AUTO_BRACKETING) != 0) {
            this.t = i4;
            i4 += 4;
        } else {
            this.t = -1;
        }
        if ((i & 8704) != 0) {
            this.u = i4;
            i4 += 4;
        } else {
            this.u = -1;
        }
        if ((i & 17408) != 0) {
            this.v = i4;
            i4 += 4;
        } else {
            this.v = -1;
        }
        if (i4 != i6) {
            throw new IllegalArgumentException("Mismatched vertex format and vertex size bytes");
        }
        if (bqVar != null) {
            this.w = bqVar;
            this.A = bqVar.g(bp.a, i6 * i5);
            if (sArr != null) {
                this.B = bqVar.g(bp.b, i7);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:5:0x000c  */
    private static int d(int i) {
        int i2;
        int i3 = i & 64;
        if ((i & 1) != 0) {
            if (i3 != 0) {
                i2 = 8;
            } else {
                i2 = 12;
            }
        } else if ((i & 2) == 0) {
            i2 = 0;
        } else if (i3 != 0) {
            i2 = 4;
        } else {
            i2 = 8;
        }
        int i4 = (i & 8) != 0 ? 16 : 0;
        int i5 = (i & 32) != 0 ? 4 : 0;
        int i6 = (i & 16) == 0 ? 0 : 8;
        int i7 = (i & 2176) != 0 ? 4 : 0;
        return i2 + i4 + i5 + i6 + i7 + ((i & FujifilmMakernoteDirectory.TAG_AUTO_BRACKETING) != 0 ? 4 : 0) + ((i & 8704) != 0 ? 4 : 0) + ((i & 17408) == 0 ? 0 : 4);
    }

    public final void a(bv bvVar) {
        int i = this.x + 1;
        this.x = i;
        if (i == 1) {
            this.b = bvVar;
            if (this.D && this.C) {
                return;
            }
            this.D = true;
            bq bqVar = this.w;
            if (bqVar == null) {
                fe feVar = this.y;
                short[] sArr = this.z;
                if (feVar != null) {
                    this.m = feVar.a(bvVar, this.a);
                }
                if (sArr != null) {
                    bw bwVarD = bvVar.d(this.a);
                    this.f83n = bwVarD;
                    bvVar.i(bwVarD);
                    bvVar.M(sArr, sArr.length, 35044);
                }
            } else {
                fe feVar2 = this.y;
                short[] sArr2 = this.z;
                if (feVar2 != null) {
                    this.m = feVar2.b(bvVar, this.a, bqVar, this.A);
                }
                if (sArr2 != null) {
                    this.f83n = bqVar.f(this.B, bvVar, this.a, sArr2, sArr2.length);
                }
            }
            if (this.C) {
                this.y = null;
                this.z = null;
            }
        }
    }

    public final void b(boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.x > 0);
        int i = this.x - 1;
        this.x = i;
        if (i == 0) {
            bq bqVar = this.w;
            if (bqVar == null) {
                if (!z) {
                    bv bvVar = this.b;
                    com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
                    if (this.m.b()) {
                        bvVar.l(this.m);
                    }
                    if (this.f83n.b()) {
                        bvVar.l(this.f83n);
                    }
                }
            } else if (z) {
                bqVar.b();
            } else {
                bv bvVar2 = this.b;
                com.google.android.libraries.navigation.internal.yx.ar.q(bvVar2);
                if (this.m.b()) {
                    bqVar.a(bvVar2, this.m);
                }
                if (this.f83n.b()) {
                    bqVar.a(bvVar2, this.f83n);
                }
            }
            bw bwVar = bw.a;
            this.m = bwVar;
            this.f83n = bwVar;
            this.b = null;
        }
    }

    public final void c(boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.k(!this.D);
        this.C = z;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ff)) {
            return false;
        }
        ff ffVar = (ff) obj;
        return this.m == ffVar.m && this.f83n == ffVar.f83n;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.m, this.f83n});
    }

    public ff(String str, float[] fArr, int i, int i2, bq bqVar) {
        this(str, new fc(fArr, (fArr.length * 4) / d(i), d(i)), i, 5, (short[]) null, 0, bqVar);
    }

    public ff(String str, int[] iArr, int i, int i2, int i3, int i4, bq bqVar) {
        this(str, new fd(iArr, i, i4), i2, i3, (short[]) null, 0, bqVar);
    }
}
