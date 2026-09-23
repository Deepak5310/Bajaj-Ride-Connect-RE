package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.afm.dh;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class b extends cg {
    public final com.google.android.libraries.navigation.internal.aai.f a;
    public final com.google.android.libraries.navigation.internal.acy.b b;
    public final ev c;
    public final ev d;
    public final com.google.android.libraries.navigation.internal.aas.b e;
    public final Boolean f;
    public final ev g;
    public final com.google.android.libraries.navigation.internal.aaj.b h;
    public final dh i;
    public final ev j;
    public final com.google.android.libraries.navigation.internal.adi.aj k;
    public final String l;
    public final String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f61n;
    public final String o;
    public final com.google.android.libraries.navigation.internal.aec.b p;
    public final fy q;
    public final com.google.android.libraries.navigation.internal.aep.c r;

    public b(com.google.android.libraries.navigation.internal.aai.f fVar, com.google.android.libraries.navigation.internal.acy.b bVar, ev evVar, ev evVar2, com.google.android.libraries.navigation.internal.aas.b bVar2, Boolean bool, ev evVar3, com.google.android.libraries.navigation.internal.aaj.b bVar3, dh dhVar, ev evVar4, com.google.android.libraries.navigation.internal.adi.aj ajVar, String str, String str2, String str3, String str4, com.google.android.libraries.navigation.internal.aec.b bVar4, fy fyVar, com.google.android.libraries.navigation.internal.aep.c cVar) {
        this.a = fVar;
        this.b = bVar;
        this.c = evVar;
        this.d = evVar2;
        this.e = bVar2;
        this.f = bool;
        this.g = evVar3;
        this.h = bVar3;
        this.i = dhVar;
        Objects.requireNonNull(evVar4);
        this.j = evVar4;
        this.k = ajVar;
        this.l = null;
        this.m = str2;
        this.f61n = str3;
        this.o = str4;
        this.p = bVar4;
        Objects.requireNonNull(fyVar);
        this.q = fyVar;
        this.r = cVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final cf a() {
        return new a(this);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final ev b() {
        return this.d;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final ev c() {
        return this.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final ev d() {
        return this.j;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final ev e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.adi.aj ajVar;
        com.google.android.libraries.navigation.internal.aep.c cVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof cg) {
            cg cgVar = (cg) obj;
            com.google.android.libraries.navigation.internal.aai.f fVar = this.a;
            if (fVar != null ? fVar.equals(cgVar.g()) : cgVar.g() == null) {
                com.google.android.libraries.navigation.internal.acy.b bVar = this.b;
                if (bVar != null ? bVar.equals(cgVar.j()) : cgVar.j() == null) {
                    ev evVar = this.c;
                    if (evVar != null ? hx.i(evVar, cgVar.c()) : cgVar.c() == null) {
                        ev evVar2 = this.d;
                        if (evVar2 != null ? hx.i(evVar2, cgVar.b()) : cgVar.b() == null) {
                            cgVar.v();
                            com.google.android.libraries.navigation.internal.aas.b bVar2 = this.e;
                            if (bVar2 != null ? bVar2.equals(cgVar.i()) : cgVar.i() == null) {
                                Boolean bool = this.f;
                                if (bool != null ? bool.equals(cgVar.o()) : cgVar.o() == null) {
                                    ev evVar3 = this.g;
                                    if (evVar3 != null ? hx.i(evVar3, cgVar.e()) : cgVar.e() == null) {
                                        com.google.android.libraries.navigation.internal.aaj.b bVar3 = this.h;
                                        if (bVar3 != null ? bVar3.equals(cgVar.h()) : cgVar.h() == null) {
                                            dh dhVar = this.i;
                                            if (dhVar != null ? dhVar.equals(cgVar.n()) : cgVar.n() == null) {
                                                cgVar.u();
                                                cgVar.t();
                                                cgVar.w();
                                                if (hx.i(this.j, cgVar.d()) && ((ajVar = this.k) != null ? ajVar.equals(cgVar.k()) : cgVar.k() == null)) {
                                                    cgVar.s();
                                                    String str = this.m;
                                                    if (str != null ? str.equals(cgVar.p()) : cgVar.p() == null) {
                                                        String str2 = this.f61n;
                                                        if (str2 != null ? str2.equals(cgVar.r()) : cgVar.r() == null) {
                                                            String str3 = this.o;
                                                            if (str3 != null ? str3.equals(cgVar.q()) : cgVar.q() == null) {
                                                                com.google.android.libraries.navigation.internal.aec.b bVar4 = this.p;
                                                                if (bVar4 != null ? bVar4.equals(cgVar.l()) : cgVar.l() == null) {
                                                                    if (this.q.equals(cgVar.f()) && ((cVar = this.r) != null ? cVar.equals(cgVar.m()) : cgVar.m() == null)) {
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
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final fy f() {
        return this.q;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final com.google.android.libraries.navigation.internal.aai.f g() {
        return this.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final com.google.android.libraries.navigation.internal.aaj.b h() {
        return this.h;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final com.google.android.libraries.navigation.internal.aas.b i() {
        return this.e;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final com.google.android.libraries.navigation.internal.acy.b j() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final com.google.android.libraries.navigation.internal.adi.aj k() {
        return this.k;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final com.google.android.libraries.navigation.internal.aec.b l() {
        return this.p;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final com.google.android.libraries.navigation.internal.aep.c m() {
        return this.r;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final dh n() {
        return this.i;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final Boolean o() {
        return this.f;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final String p() {
        return this.m;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final String q() {
        return this.o;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final String r() {
        return this.f61n;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final String s() {
        return null;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final void t() {
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final void u() {
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final void v() {
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public final void w() {
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cg
    public int hashCode() {
        int iN;
        int iN2;
        int iN3;
        int iN4;
        int iN5;
        int iN6;
        int iN7;
        com.google.android.libraries.navigation.internal.aai.f fVar = this.a;
        int iN8 = 0;
        if (fVar == null) {
            iN = 0;
        } else if (fVar.H()) {
            iN = fVar.n();
        } else {
            int iN9 = fVar.ak;
            if (iN9 == 0) {
                iN9 = fVar.n();
                fVar.ak = iN9;
            }
            iN = iN9;
        }
        com.google.android.libraries.navigation.internal.acy.b bVar = this.b;
        if (bVar == null) {
            iN2 = 0;
        } else if (bVar.H()) {
            iN2 = bVar.n();
        } else {
            int iN10 = bVar.ak;
            if (iN10 == 0) {
                iN10 = bVar.n();
                bVar.ak = iN10;
            }
            iN2 = iN10;
        }
        int i = (((iN ^ 1000003) * 1000003) ^ iN2) * 1000003;
        ev evVar = this.c;
        int iHashCode = (i ^ (evVar == null ? 0 : evVar.hashCode())) * 1000003;
        ev evVar2 = this.d;
        int iHashCode2 = iHashCode ^ (evVar2 == null ? 0 : evVar2.hashCode());
        com.google.android.libraries.navigation.internal.aas.b bVar2 = this.e;
        if (bVar2 == null) {
            iN3 = 0;
        } else if (bVar2.H()) {
            iN3 = bVar2.n();
        } else {
            int iN11 = bVar2.ak;
            if (iN11 == 0) {
                iN11 = bVar2.n();
                bVar2.ak = iN11;
            }
            iN3 = iN11;
        }
        int i2 = ((iHashCode2 * (-721379959)) ^ iN3) * 1000003;
        Boolean bool = this.f;
        int iHashCode3 = (i2 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        ev evVar3 = this.g;
        int iHashCode4 = (iHashCode3 ^ (evVar3 == null ? 0 : evVar3.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.aaj.b bVar3 = this.h;
        if (bVar3 == null) {
            iN4 = 0;
        } else if (bVar3.H()) {
            iN4 = bVar3.n();
        } else {
            int iN12 = bVar3.ak;
            if (iN12 == 0) {
                iN12 = bVar3.n();
                bVar3.ak = iN12;
            }
            iN4 = iN12;
        }
        int i3 = (iHashCode4 ^ iN4) * 1000003;
        dh dhVar = this.i;
        if (dhVar == null) {
            iN5 = 0;
        } else if (dhVar.H()) {
            iN5 = dhVar.n();
        } else {
            int iN13 = dhVar.ak;
            if (iN13 == 0) {
                iN13 = dhVar.n();
                dhVar.ak = iN13;
            }
            iN5 = iN13;
        }
        int iHashCode5 = (((i3 ^ iN5) * 1525764945) ^ this.j.hashCode()) * 1000003;
        com.google.android.libraries.navigation.internal.adi.aj ajVar = this.k;
        if (ajVar == null) {
            iN6 = 0;
        } else if (ajVar.H()) {
            iN6 = ajVar.n();
        } else {
            int iN14 = ajVar.ak;
            if (iN14 == 0) {
                iN14 = ajVar.n();
                ajVar.ak = iN14;
            }
            iN6 = iN14;
        }
        int i4 = (iHashCode5 ^ iN6) * (-721379959);
        String str = this.m;
        int iHashCode6 = (i4 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f61n;
        int iHashCode7 = (iHashCode6 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.o;
        int iHashCode8 = (iHashCode7 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.aec.b bVar4 = this.p;
        if (bVar4 == null) {
            iN7 = 0;
        } else if (bVar4.H()) {
            iN7 = bVar4.n();
        } else {
            int iN15 = bVar4.ak;
            if (iN15 == 0) {
                iN15 = bVar4.n();
                bVar4.ak = iN15;
            }
            iN7 = iN15;
        }
        int iHashCode9 = (((iHashCode8 ^ iN7) * 1000003) ^ this.q.hashCode()) * 1000003;
        com.google.android.libraries.navigation.internal.aep.c cVar = this.r;
        if (cVar != null) {
            if (cVar.H()) {
                iN8 = cVar.n();
            } else {
                iN8 = cVar.ak;
                if (iN8 == 0) {
                    iN8 = cVar.n();
                    cVar.ak = iN8;
                }
            }
        }
        return iHashCode9 ^ iN8;
    }
}
