package com.google.android.libraries.geo.mapcore.internal.model;

import androidx.core.math.MathUtils;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.google.android.libraries.navigation.internal.yz.lg;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cd implements Comparable {
    public final int a;
    public final int b;
    public final int c;
    public final com.google.android.libraries.navigation.internal.pt.d d;
    public final int e;
    public final int f;
    public final int g;
    private com.google.android.libraries.navigation.internal.oe.ai h;
    private com.google.android.libraries.navigation.internal.oe.x i;
    private com.google.android.libraries.navigation.internal.oe.x j;

    public cd(int i, int i2, int i3) {
        this(i, i2, i3, null);
    }

    public cd(int i, int i2, int i3, com.google.android.libraries.navigation.internal.pt.d dVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = dVar;
        this.g = 18 - i;
        int i4 = 1073741824 >> i;
        this.e = (i2 * i4) - 536870912;
        this.f = -((i4 * (i3 + 1)) - 536870912);
        this.h = null;
        this.j = null;
        this.i = null;
    }

    public static cd f(int i, int i2, int i3) {
        int i4 = 0;
        if (i <= 0) {
            return new cd(0, 0, 0);
        }
        if (i > 30) {
            i = 30;
        }
        int i5 = 30 - i;
        int i6 = -MathUtils.clamp(i3, -536870912, PropertyOptions.DELETE_EXISTING);
        int i7 = (i2 + PropertyOptions.DELETE_EXISTING) >> i5;
        int i8 = 1 << i;
        if (i7 < 0) {
            i7 += i8;
        } else if (i7 >= i8) {
            i7 -= i8;
        }
        int i9 = (i6 + PropertyOptions.DELETE_EXISTING) >> i5;
        if (i9 >= 0) {
            i4 = i9 >= i8 ? i8 - 1 : i9;
        }
        return new cd(i, i7, i4);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a6 A[LOOP:7: B:42:0x00a4->B:43:0x00a6, LOOP_END] */
    public static boolean j(com.google.android.libraries.navigation.internal.oe.bd bdVar, int i, List list, com.google.android.libraries.navigation.internal.oe.bd bdVar2) {
        int i2;
        int i3;
        if (i < 0) {
            return true;
        }
        int iClamp = MathUtils.clamp(bdVar.b.b, -536870912, PropertyOptions.DELETE_EXISTING);
        cd cdVarF = f(i, bdVar.b.a, bdVar.c.b);
        int i4 = cdVarF.b;
        int i5 = cdVarF.c;
        cd cdVarF2 = f(i, bdVar.c.a - 1, iClamp + 1);
        int i6 = cdVarF2.b;
        int i7 = cdVarF2.c;
        int i8 = 1 << i;
        int i9 = ((i4 > i6 ? (i8 - i4) + i6 : i6 - i4) + 1) * ((i7 - i5) + 1);
        if (i9 < 0) {
            return true;
        }
        int i10 = 0;
        if (i9 > 100000) {
            return false;
        }
        if (i9 == 0) {
            list.add(cdVarF);
        } else if (i4 > i6) {
            for (int i11 = i4; i11 < i8; i11++) {
                for (int i12 = i5; i12 <= i7; i12++) {
                    list.add(new cd(i, i11, i12));
                }
            }
            while (i10 <= i6) {
                for (int i13 = i5; i13 <= i7; i13++) {
                    list.add(new cd(i, i10, i13));
                }
                i10++;
            }
        } else if (i4 != i6) {
            while (i2 <= i6) {
                while (i3 <= i7) {
                    list.add(new cd(i, i2, i3));
                }
            }
        } else if (bdVar.c.b - bdVar.b.b > 536870912 || bdVar.a.e() > 536870912) {
            while (i10 < i8) {
                for (int i14 = i5; i14 <= i7; i14++) {
                    list.add(new cd(i, i10, i14));
                }
                i10++;
            }
        } else {
            for (i2 = i4; i2 <= i6; i2++) {
                for (i3 = i5; i3 <= i7; i3++) {
                    list.add(new cd(i, i2, i3));
                }
            }
        }
        if (bdVar2 != null) {
            int i15 = 30 - i;
            int i16 = 1073741824 >> i;
            bdVar2.a.o((i4 << i15) - 536870912, ((-(i7 << i15)) + PropertyOptions.DELETE_EXISTING) - i16, ((i6 << i15) - 536870912) + i16, (-(i5 << i15)) + PropertyOptions.DELETE_EXISTING);
            bdVar2.b(bdVar2.a);
        }
        return true;
    }

    public final int a() {
        return 1073741824 >> this.a;
    }

    public final synchronized com.google.android.libraries.navigation.internal.oe.x b() {
        com.google.android.libraries.navigation.internal.oe.x xVar = this.i;
        if (xVar != null) {
            return xVar;
        }
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x();
        int i = this.a;
        int i2 = (1073741824 >> i) >> 1;
        xVar2.J(this.e + i2, this.f + i2);
        this.i = xVar2;
        return xVar2;
    }

    public final synchronized com.google.android.libraries.navigation.internal.oe.x c() {
        com.google.android.libraries.navigation.internal.oe.x xVar = this.j;
        if (xVar != null) {
            return xVar;
        }
        com.google.android.libraries.navigation.internal.oe.x xVarC = e().a.C(b());
        this.j = xVarC;
        return xVarC;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        cd cdVar = (cd) obj;
        return com.google.android.libraries.navigation.internal.yz.ck.b.c(this.a, cdVar.a).c(this.b, cdVar.b).c(this.c, cdVar.c).f(this.d, cdVar.d, lg.a.aw()).a();
    }

    public final com.google.android.libraries.navigation.internal.oe.ai d() {
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x(this.e, this.f);
        int i = this.f;
        int i2 = 1073741824 >> this.a;
        return new com.google.android.libraries.navigation.internal.oe.ai(xVar, new com.google.android.libraries.navigation.internal.oe.x(this.e + i2, i + i2));
    }

    public final synchronized com.google.android.libraries.navigation.internal.oe.ai e() {
        com.google.android.libraries.navigation.internal.oe.ai aiVar = this.h;
        if (aiVar != null) {
            return aiVar;
        }
        com.google.android.libraries.navigation.internal.oe.ai aiVarD = d();
        this.h = aiVarD;
        return aiVarD;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cd)) {
            return false;
        }
        cd cdVar = (cd) obj;
        if (this.b == cdVar.b && this.c == cdVar.c && this.a == cdVar.a) {
            return com.google.android.libraries.navigation.internal.yx.am.a(this.d, cdVar.d);
        }
        return false;
    }

    public final cd g(com.google.android.libraries.navigation.internal.pt.d dVar) {
        return new cd(this.a, this.b, this.c, dVar);
    }

    public final cd h(int i) {
        int i2 = this.a - i;
        if (i2 <= 0) {
            return this;
        }
        int i3 = this.b;
        return new cd(i, i3 >> i2, this.c >> i2, this.d);
    }

    public final int hashCode() {
        int i = this.a;
        com.google.android.libraries.navigation.internal.pt.d dVar = this.d;
        int i2 = (((i * 31) + this.b) * 31) + this.c;
        return dVar != null ? (i2 * 31) + dVar.hashCode() : i2;
    }

    public final void i(com.google.android.libraries.navigation.internal.oe.ai aiVar) {
        int i = this.e;
        int i2 = this.f;
        int i3 = 1073741824 >> this.a;
        aiVar.o(i, i2, i + i3, i3 + i2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.a);
        sb.append(",");
        sb.append(this.b);
        sb.append(",");
        sb.append(this.c);
        sb.append(",");
        Object obj = this.d;
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append("]");
        return sb.toString();
    }
}
