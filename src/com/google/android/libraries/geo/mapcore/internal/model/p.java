package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.afm.dh;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class p extends b {
    private volatile transient int t;
    private volatile transient boolean u;

    public p(com.google.android.libraries.navigation.internal.aai.f fVar, com.google.android.libraries.navigation.internal.acy.b bVar, ev evVar, ev evVar2, com.google.android.libraries.navigation.internal.aas.b bVar2, Boolean bool, ev evVar3, com.google.android.libraries.navigation.internal.aaj.b bVar3, dh dhVar, ev evVar4, com.google.android.libraries.navigation.internal.adi.aj ajVar, String str, String str2, String str3, String str4, com.google.android.libraries.navigation.internal.aec.b bVar4, fy fyVar, com.google.android.libraries.navigation.internal.aep.c cVar) {
        super(fVar, bVar, evVar, evVar2, bVar2, bool, evVar3, bVar3, dhVar, evVar4, ajVar, null, str2, str3, str4, bVar4, fyVar, cVar);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p) || hashCode() != obj.hashCode()) {
            return false;
        }
        if (this != obj) {
            if (!(obj instanceof cg)) {
                return false;
            }
            cg cgVar = (cg) obj;
            com.google.android.libraries.navigation.internal.aai.f fVar = this.a;
            if (fVar == null) {
                if (cgVar.g() != null) {
                    return false;
                }
            } else if (!fVar.equals(cgVar.g())) {
                return false;
            }
            com.google.android.libraries.navigation.internal.acy.b bVar = this.b;
            if (bVar == null) {
                if (cgVar.j() != null) {
                    return false;
                }
            } else if (!bVar.equals(cgVar.j())) {
                return false;
            }
            ev evVar = this.c;
            if (evVar == null) {
                if (cgVar.c() != null) {
                    return false;
                }
            } else if (!hx.i(evVar, cgVar.c())) {
                return false;
            }
            ev evVar2 = this.d;
            if (evVar2 == null) {
                if (cgVar.b() != null) {
                    return false;
                }
            } else if (!hx.i(evVar2, cgVar.b())) {
                return false;
            }
            cgVar.v();
            com.google.android.libraries.navigation.internal.aas.b bVar2 = this.e;
            if (bVar2 == null) {
                if (cgVar.i() != null) {
                    return false;
                }
            } else if (!bVar2.equals(cgVar.i())) {
                return false;
            }
            Boolean bool = this.f;
            if (bool == null) {
                if (cgVar.o() != null) {
                    return false;
                }
            } else if (!bool.equals(cgVar.o())) {
                return false;
            }
            ev evVar3 = this.g;
            if (evVar3 == null) {
                if (cgVar.e() != null) {
                    return false;
                }
            } else if (!hx.i(evVar3, cgVar.e())) {
                return false;
            }
            com.google.android.libraries.navigation.internal.aaj.b bVar3 = this.h;
            if (bVar3 == null) {
                if (cgVar.h() != null) {
                    return false;
                }
            } else if (!bVar3.equals(cgVar.h())) {
                return false;
            }
            dh dhVar = this.i;
            if (dhVar == null) {
                if (cgVar.n() != null) {
                    return false;
                }
            } else if (!dhVar.equals(cgVar.n())) {
                return false;
            }
            cgVar.u();
            cgVar.t();
            cgVar.w();
            if (!hx.i(this.j, cgVar.d())) {
                return false;
            }
            com.google.android.libraries.navigation.internal.adi.aj ajVar = this.k;
            if (ajVar == null) {
                if (cgVar.k() != null) {
                    return false;
                }
            } else if (!ajVar.equals(cgVar.k())) {
                return false;
            }
            cgVar.s();
            String str = this.m;
            if (str == null) {
                if (cgVar.p() != null) {
                    return false;
                }
            } else if (!str.equals(cgVar.p())) {
                return false;
            }
            String str2 = this.f61n;
            if (str2 == null) {
                if (cgVar.r() != null) {
                    return false;
                }
            } else if (!str2.equals(cgVar.r())) {
                return false;
            }
            String str3 = this.o;
            if (str3 == null) {
                if (cgVar.q() != null) {
                    return false;
                }
            } else if (!str3.equals(cgVar.q())) {
                return false;
            }
            com.google.android.libraries.navigation.internal.aec.b bVar4 = this.p;
            if (bVar4 == null) {
                if (cgVar.l() != null) {
                    return false;
                }
            } else if (!bVar4.equals(cgVar.l())) {
                return false;
            }
            if (!this.q.equals(cgVar.f())) {
                return false;
            }
            com.google.android.libraries.navigation.internal.aep.c cVar = this.r;
            if (cVar == null) {
                if (cgVar.m() != null) {
                    return false;
                }
            } else if (!cVar.equals(cgVar.m())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.b, com.google.android.libraries.geo.mapcore.internal.model.cg
    public final int hashCode() {
        int iN;
        int iN2;
        int iN3;
        int iN4;
        int iN5;
        int iN6;
        int iN7;
        if (!this.u) {
            synchronized (this) {
                if (!this.u) {
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
                    this.t = iHashCode9 ^ iN8;
                    this.u = true;
                }
            }
        }
        return this.t;
    }
}
