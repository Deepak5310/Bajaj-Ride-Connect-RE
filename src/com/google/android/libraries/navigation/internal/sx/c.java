package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.afl.gv;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lt;
import com.google.android.libraries.navigation.internal.afl.mj;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends ap {
    private final bg a;
    private final com.google.android.libraries.navigation.internal.ael.x b;
    private final com.google.android.libraries.navigation.internal.db.r c;
    private final boolean d;
    private final lt e;
    private final lr f;
    private final ev g;
    private final ev h;
    private final Double i;
    private final com.google.android.libraries.navigation.internal.ady.n j;
    private final mj k;
    private final com.google.android.libraries.navigation.internal.adu.s l = null;
    private final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.ael.x f585n;
    private final EnumMap o;
    private final Integer p;
    private final Long q;
    private final gv r;

    public c(bg bgVar, com.google.android.libraries.navigation.internal.ael.x xVar, com.google.android.libraries.navigation.internal.db.r rVar, boolean z, lt ltVar, lr lrVar, ev evVar, ev evVar2, Double d, com.google.android.libraries.navigation.internal.ady.n nVar, mj mjVar, com.google.android.libraries.navigation.internal.adu.s sVar, boolean z2, com.google.android.libraries.navigation.internal.ael.x xVar2, EnumMap enumMap, Integer num, Long l, gv gvVar) {
        this.a = bgVar;
        this.b = xVar;
        this.c = rVar;
        this.d = z;
        this.e = ltVar;
        this.f = lrVar;
        this.g = evVar;
        this.h = evVar2;
        this.i = d;
        this.j = nVar;
        this.k = mjVar;
        this.m = z2;
        this.f585n = xVar2;
        this.o = enumMap;
        this.p = num;
        this.q = l;
        this.r = gvVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final bg a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final com.google.android.libraries.navigation.internal.db.r b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final ev c() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final ev d() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final com.google.android.libraries.navigation.internal.adu.s e() {
        return null;
    }

    public final boolean equals(Object obj) {
        lt ltVar;
        lr lrVar;
        ev evVar;
        ev evVar2;
        Double d;
        com.google.android.libraries.navigation.internal.ady.n nVar;
        mj mjVar;
        com.google.android.libraries.navigation.internal.ael.x xVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof ap) {
            ap apVar = (ap) obj;
            bg bgVar = this.a;
            if (bgVar != null ? bgVar.equals(apVar.a()) : apVar.a() == null) {
                com.google.android.libraries.navigation.internal.ael.x xVar2 = this.b;
                if (xVar2 != null ? xVar2.equals(apVar.g()) : apVar.g() == null) {
                    if (this.c != null ? (apVar.b() instanceof com.google.android.libraries.navigation.internal.db.r) : apVar.b() == null) {
                        if (this.d == apVar.r() && ((ltVar = this.e) != null ? ltVar.equals(apVar.k()) : apVar.k() == null) && ((lrVar = this.f) != null ? lrVar.equals(apVar.j()) : apVar.j() == null) && ((evVar = this.g) != null ? hx.i(evVar, apVar.d()) : apVar.d() == null) && ((evVar2 = this.h) != null ? hx.i(evVar2, apVar.c()) : apVar.c() == null) && ((d = this.i) != null ? d.equals(apVar.m()) : apVar.m() == null) && ((nVar = this.j) != null ? nVar.equals(apVar.f()) : apVar.f() == null) && ((mjVar = this.k) != null ? mjVar.equals(apVar.l()) : apVar.l() == null)) {
                            apVar.e();
                            if (this.m == apVar.q() && ((xVar = this.f585n) != null ? xVar.equals(apVar.h()) : apVar.h() == null)) {
                                apVar.s();
                                EnumMap enumMap = this.o;
                                if (enumMap != null ? enumMap.equals(apVar.p()) : apVar.p() == null) {
                                    Integer num = this.p;
                                    if (num != null ? num.equals(apVar.n()) : apVar.n() == null) {
                                        Long l = this.q;
                                        if (l != null ? l.equals(apVar.o()) : apVar.o() == null) {
                                            gv gvVar = this.r;
                                            if (gvVar != null ? gvVar.equals(apVar.i()) : apVar.i() == null) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final com.google.android.libraries.navigation.internal.ady.n f() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final com.google.android.libraries.navigation.internal.ael.x g() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final com.google.android.libraries.navigation.internal.ael.x h() {
        return this.f585n;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final gv i() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final lr j() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final lt k() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final mj l() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final Double m() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final Integer n() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final Long o() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final EnumMap p() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final boolean q() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final boolean r() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ap
    public final void s() {
    }

    public final String toString() {
        gv gvVar = this.r;
        EnumMap enumMap = this.o;
        com.google.android.libraries.navigation.internal.ael.x xVar = this.f585n;
        mj mjVar = this.k;
        com.google.android.libraries.navigation.internal.ady.n nVar = this.j;
        ev evVar = this.h;
        ev evVar2 = this.g;
        lr lrVar = this.f;
        lt ltVar = this.e;
        com.google.android.libraries.navigation.internal.db.r rVar = this.c;
        com.google.android.libraries.navigation.internal.ael.x xVar2 = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(xVar2) + ", " + String.valueOf(rVar) + ", " + this.d + ", " + String.valueOf(ltVar) + ", " + String.valueOf(lrVar) + ", " + String.valueOf(evVar2) + ", " + String.valueOf(evVar) + ", " + this.i + ", " + String.valueOf(nVar) + ", " + String.valueOf(mjVar) + ", null, " + this.m + ", " + String.valueOf(xVar) + ", null, " + String.valueOf(enumMap) + ", " + this.p + ", " + this.q + ", " + String.valueOf(gvVar) + "}";
    }

    public final int hashCode() {
        int iN;
        int iN2;
        int iN3;
        int iN4;
        bg bgVar = this.a;
        int iN5 = 0;
        int iHashCode = bgVar == null ? 0 : bgVar.hashCode();
        com.google.android.libraries.navigation.internal.ael.x xVar = this.b;
        int iHashCode2 = (((((iHashCode ^ 1000003) * 1000003) ^ (xVar == null ? 0 : xVar.hashCode())) * (-721379959)) ^ (true != this.d ? 1237 : 1231)) * 1000003;
        lt ltVar = this.e;
        if (ltVar == null) {
            iN = 0;
        } else if (ltVar.H()) {
            iN = ltVar.n();
        } else {
            int iN6 = ltVar.ak;
            if (iN6 == 0) {
                iN6 = ltVar.n();
                ltVar.ak = iN6;
            }
            iN = iN6;
        }
        int i = (iHashCode2 ^ iN) * 1000003;
        lr lrVar = this.f;
        if (lrVar == null) {
            iN2 = 0;
        } else if (lrVar.H()) {
            iN2 = lrVar.n();
        } else {
            int iN7 = lrVar.ak;
            if (iN7 == 0) {
                iN7 = lrVar.n();
                lrVar.ak = iN7;
            }
            iN2 = iN7;
        }
        int i2 = (i ^ iN2) * 1000003;
        ev evVar = this.g;
        int iHashCode3 = (i2 ^ (evVar == null ? 0 : evVar.hashCode())) * 1000003;
        ev evVar2 = this.h;
        int iHashCode4 = (iHashCode3 ^ (evVar2 == null ? 0 : evVar2.hashCode())) * 1000003;
        Double d = this.i;
        int iHashCode5 = (iHashCode4 ^ (d == null ? 0 : d.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.ady.n nVar = this.j;
        if (nVar == null) {
            iN3 = 0;
        } else if (nVar.H()) {
            iN3 = nVar.n();
        } else {
            int iN8 = nVar.ak;
            if (iN8 == 0) {
                iN8 = nVar.n();
                nVar.ak = iN8;
            }
            iN3 = iN8;
        }
        int i3 = (iHashCode5 ^ iN3) * 1000003;
        mj mjVar = this.k;
        if (mjVar == null) {
            iN4 = 0;
        } else if (mjVar.H()) {
            iN4 = mjVar.n();
        } else {
            int iN9 = mjVar.ak;
            if (iN9 == 0) {
                iN9 = mjVar.n();
                mjVar.ak = iN9;
            }
            iN4 = iN9;
        }
        int i4 = (((i3 ^ iN4) * (-721379959)) ^ (true == this.m ? 1231 : 1237)) * 1000003;
        com.google.android.libraries.navigation.internal.ael.x xVar2 = this.f585n;
        int iHashCode6 = (i4 ^ (xVar2 == null ? 0 : xVar2.hashCode())) * (-721379959);
        EnumMap enumMap = this.o;
        int iHashCode7 = (iHashCode6 ^ (enumMap == null ? 0 : enumMap.hashCode())) * 1000003;
        Integer num = this.p;
        int iHashCode8 = (iHashCode7 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Long l = this.q;
        int iHashCode9 = (iHashCode8 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        gv gvVar = this.r;
        if (gvVar != null) {
            if (gvVar.H()) {
                iN5 = gvVar.n();
            } else {
                iN5 = gvVar.ak;
                if (iN5 == 0) {
                    iN5 = gvVar.n();
                    gvVar.ak = iN5;
                }
            }
        }
        return iHashCode9 ^ iN5;
    }
}
