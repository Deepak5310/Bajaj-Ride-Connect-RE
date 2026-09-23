package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements dl {
    public final ac a;
    public int b;
    public int c = 0;
    private int d;

    private ad(ac acVar) {
        Charset charset = ca.a;
        this.a = acVar;
        acVar.f = this;
    }

    private final void Q(Object obj, dr drVar, ar arVar) throws IOException {
        int i = this.d;
        this.d = eu.c(eu.a(this.b), 4);
        try {
            drVar.h(obj, this, arVar);
            if (this.b != this.d) {
                throw new cc("Failed to parse the message.");
            }
            this.d = i;
        } catch (Throwable th) {
            this.d = i;
            throw th;
        }
    }

    private final void R(Object obj, dr drVar, ar arVar) throws IOException {
        ac acVar = this.a;
        int iN = acVar.n();
        acVar.N();
        int iE = this.a.e(iN);
        this.a.b++;
        drVar.h(obj, this, arVar);
        this.a.z(0);
        ac acVar2 = this.a;
        acVar2.b--;
        acVar2.A(iE);
    }

    private final void S(int i) throws IOException {
        if (this.a.d() != i) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static final void T(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new cc("Failed to parse the message.");
        }
    }

    private static final void U(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new cc("Failed to parse the message.");
        }
    }

    public static ad p(ac acVar) {
        ad adVar = acVar.f;
        return adVar != null ? adVar : new ad(acVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void A(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            int iB = eu.b(this.b);
            if (iB != 0) {
                if (iB != 2) {
                    throw new cb();
                }
                ac acVar = this.a;
                int iD = acVar.d() + acVar.n();
                do {
                    bjVar.i(this.a.f());
                } while (this.a.d() < iD);
                S(iD);
                return;
            }
            do {
                bjVar.i(this.a.f());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw new cb();
                }
                ac acVar2 = this.a;
                int iD2 = acVar2.d() + acVar2.n();
                do {
                    list.add(Integer.valueOf(this.a.f()));
                } while (this.a.d() < iD2);
                S(iD2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.a.f()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void B(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            int iB = eu.b(this.b);
            if (iB == 2) {
                int iN = this.a.n();
                T(iN);
                int iD = this.a.d() + iN;
                do {
                    bjVar.i(this.a.g());
                } while (this.a.d() < iD);
                return;
            }
            if (iB != 5) {
                throw new cb();
            }
            do {
                bjVar.i(this.a.g());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 == 2) {
                int iN2 = this.a.n();
                T(iN2);
                int iD2 = this.a.d() + iN2;
                do {
                    list.add(Integer.valueOf(this.a.g()));
                } while (this.a.d() < iD2);
                return;
            }
            if (iB2 != 5) {
                throw new cb();
            }
            do {
                list.add(Integer.valueOf(this.a.g()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void C(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof cm) {
            cm cmVar = (cm) list;
            int iB = eu.b(this.b);
            if (iB != 1) {
                if (iB != 2) {
                    throw new cb();
                }
                int iN = this.a.n();
                U(iN);
                int iD = this.a.d() + iN;
                do {
                    cmVar.f(this.a.o());
                } while (this.a.d() < iD);
                return;
            }
            do {
                cmVar.f(this.a.o());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 1) {
                if (iB2 != 2) {
                    throw new cb();
                }
                int iN2 = this.a.n();
                U(iN2);
                int iD2 = this.a.d() + iN2;
                do {
                    list.add(Long.valueOf(this.a.o()));
                } while (this.a.d() < iD2);
                return;
            }
            do {
                list.add(Long.valueOf(this.a.o()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void D(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof ay) {
            ay ayVar = (ay) list;
            int iB = eu.b(this.b);
            if (iB == 2) {
                int iN = this.a.n();
                T(iN);
                int iD = this.a.d() + iN;
                do {
                    ayVar.h(this.a.c());
                } while (this.a.d() < iD);
                return;
            }
            if (iB != 5) {
                throw new cb();
            }
            do {
                ayVar.h(this.a.c());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 == 2) {
                int iN2 = this.a.n();
                T(iN2);
                int iD2 = this.a.d() + iN2;
                do {
                    list.add(Float.valueOf(this.a.c()));
                } while (this.a.d() < iD2);
                return;
            }
            if (iB2 != 5) {
                throw new cb();
            }
            do {
                list.add(Float.valueOf(this.a.c()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void E(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            int iB = eu.b(this.b);
            if (iB != 0) {
                if (iB != 2) {
                    throw new cb();
                }
                ac acVar = this.a;
                int iD = acVar.d() + acVar.n();
                do {
                    bjVar.i(this.a.h());
                } while (this.a.d() < iD);
                S(iD);
                return;
            }
            do {
                bjVar.i(this.a.h());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw new cb();
                }
                ac acVar2 = this.a;
                int iD2 = acVar2.d() + acVar2.n();
                do {
                    list.add(Integer.valueOf(this.a.h()));
                } while (this.a.d() < iD2);
                S(iD2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.a.h()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void F(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof cm) {
            cm cmVar = (cm) list;
            int iB = eu.b(this.b);
            if (iB != 0) {
                if (iB != 2) {
                    throw new cb();
                }
                ac acVar = this.a;
                int iD = acVar.d() + acVar.n();
                do {
                    cmVar.f(this.a.p());
                } while (this.a.d() < iD);
                S(iD);
                return;
            }
            do {
                cmVar.f(this.a.p());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw new cb();
                }
                ac acVar2 = this.a;
                int iD2 = acVar2.d() + acVar2.n();
                do {
                    list.add(Long.valueOf(this.a.p()));
                } while (this.a.d() < iD2);
                S(iD2);
                return;
            }
            do {
                list.add(Long.valueOf(this.a.p()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void G(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            int iB = eu.b(this.b);
            if (iB == 2) {
                int iN = this.a.n();
                T(iN);
                int iD = this.a.d() + iN;
                do {
                    bjVar.i(this.a.k());
                } while (this.a.d() < iD);
                return;
            }
            if (iB != 5) {
                throw new cb();
            }
            do {
                bjVar.i(this.a.k());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 == 2) {
                int iN2 = this.a.n();
                T(iN2);
                int iD2 = this.a.d() + iN2;
                do {
                    list.add(Integer.valueOf(this.a.k()));
                } while (this.a.d() < iD2);
                return;
            }
            if (iB2 != 5) {
                throw new cb();
            }
            do {
                list.add(Integer.valueOf(this.a.k()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void H(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof cm) {
            cm cmVar = (cm) list;
            int iB = eu.b(this.b);
            if (iB != 1) {
                if (iB != 2) {
                    throw new cb();
                }
                int iN = this.a.n();
                U(iN);
                int iD = this.a.d() + iN;
                do {
                    cmVar.f(this.a.t());
                } while (this.a.d() < iD);
                return;
            }
            do {
                cmVar.f(this.a.t());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 1) {
                if (iB2 != 2) {
                    throw new cb();
                }
                int iN2 = this.a.n();
                U(iN2);
                int iD2 = this.a.d() + iN2;
                do {
                    list.add(Long.valueOf(this.a.t()));
                } while (this.a.d() < iD2);
                return;
            }
            do {
                list.add(Long.valueOf(this.a.t()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void I(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            int iB = eu.b(this.b);
            if (iB != 0) {
                if (iB != 2) {
                    throw new cb();
                }
                ac acVar = this.a;
                int iD = acVar.d() + acVar.n();
                do {
                    bjVar.i(this.a.l());
                } while (this.a.d() < iD);
                S(iD);
                return;
            }
            do {
                bjVar.i(this.a.l());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw new cb();
                }
                ac acVar2 = this.a;
                int iD2 = acVar2.d() + acVar2.n();
                do {
                    list.add(Integer.valueOf(this.a.l()));
                } while (this.a.d() < iD2);
                S(iD2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.a.l()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void J(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof cm) {
            cm cmVar = (cm) list;
            int iB = eu.b(this.b);
            if (iB != 0) {
                if (iB != 2) {
                    throw new cb();
                }
                ac acVar = this.a;
                int iD = acVar.d() + acVar.n();
                do {
                    cmVar.f(this.a.u());
                } while (this.a.d() < iD);
                S(iD);
                return;
            }
            do {
                cmVar.f(this.a.u());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw new cb();
                }
                ac acVar2 = this.a;
                int iD2 = acVar2.d() + acVar2.n();
                do {
                    list.add(Long.valueOf(this.a.u()));
                } while (this.a.d() < iD2);
                S(iD2);
                return;
            }
            do {
                list.add(Long.valueOf(this.a.u()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    public final void K(List list, boolean z) throws IOException {
        int iM;
        int iM2;
        if (eu.b(this.b) != 2) {
            throw new cb();
        }
        if ((list instanceof cj) && !z) {
            cj cjVar = (cj) list;
            do {
                o();
                cjVar.b();
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            do {
                list.add(z ? v() : u());
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void L(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            int iB = eu.b(this.b);
            if (iB != 0) {
                if (iB != 2) {
                    throw new cb();
                }
                ac acVar = this.a;
                int iD = acVar.d() + acVar.n();
                do {
                    bjVar.i(this.a.n());
                } while (this.a.d() < iD);
                S(iD);
                return;
            }
            do {
                bjVar.i(this.a.n());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw new cb();
                }
                ac acVar2 = this.a;
                int iD2 = acVar2.d() + acVar2.n();
                do {
                    list.add(Integer.valueOf(this.a.n()));
                } while (this.a.d() < iD2);
                S(iD2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.a.n()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void M(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof cm) {
            cm cmVar = (cm) list;
            int iB = eu.b(this.b);
            if (iB != 0) {
                if (iB != 2) {
                    throw new cb();
                }
                ac acVar = this.a;
                int iD = acVar.d() + acVar.n();
                do {
                    cmVar.f(this.a.v());
                } while (this.a.d() < iD);
                S(iD);
                return;
            }
            do {
                cmVar.f(this.a.v());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw new cb();
                }
                ac acVar2 = this.a;
                int iD2 = acVar2.d() + acVar2.n();
                do {
                    list.add(Long.valueOf(this.a.v()));
                } while (this.a.d() < iD2);
                S(iD2);
                return;
            }
            do {
                list.add(Long.valueOf(this.a.v()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    public final void N(int i) throws IOException {
        if (eu.b(this.b) != i) {
            throw new cb();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final boolean O() throws IOException {
        N(0);
        return this.a.D();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final boolean P() throws IOException {
        int i;
        if (this.a.C() || (i = this.b) == this.d) {
            return false;
        }
        return this.a.E(i);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final double a() throws IOException {
        N(1);
        return this.a.b();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final float b() throws IOException {
        N(5);
        return this.a.c();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final int c() throws IOException {
        int iM = this.c;
        if (iM != 0) {
            this.b = iM;
            this.c = 0;
        } else {
            iM = this.a.m();
            this.b = iM;
        }
        if (iM == 0 || iM == this.d) {
            return Integer.MAX_VALUE;
        }
        return eu.a(iM);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final int d() throws IOException {
        N(0);
        return this.a.f();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final int e() throws IOException {
        N(5);
        return this.a.g();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final int f() throws IOException {
        N(0);
        return this.a.h();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final int g() throws IOException {
        N(5);
        return this.a.k();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final int h() throws IOException {
        N(0);
        return this.a.l();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final int i() throws IOException {
        N(0);
        return this.a.n();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final long j() throws IOException {
        N(1);
        return this.a.o();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final long k() throws IOException {
        N(0);
        return this.a.p();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final long l() throws IOException {
        N(1);
        return this.a.t();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final long m() throws IOException {
        N(0);
        return this.a.u();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final long n() throws IOException {
        N(0);
        return this.a.v();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final x o() throws IOException {
        N(2);
        return this.a.w();
    }

    public final Object q(es esVar, Class cls, ar arVar) throws IOException {
        es esVar2 = es.DOUBLE;
        switch (esVar) {
            case DOUBLE:
                return Double.valueOf(a());
            case FLOAT:
                return Float.valueOf(b());
            case INT64:
                return Long.valueOf(k());
            case UINT64:
                return Long.valueOf(n());
            case INT32:
                return Integer.valueOf(f());
            case FIXED64:
                return Long.valueOf(j());
            case FIXED32:
                return Integer.valueOf(e());
            case BOOL:
                return Boolean.valueOf(O());
            case STRING:
                return v();
            case GROUP:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case MESSAGE:
                return t(cls, arVar);
            case BYTES:
                return o();
            case UINT32:
                return Integer.valueOf(i());
            case ENUM:
                return Integer.valueOf(d());
            case SFIXED32:
                return Integer.valueOf(g());
            case SFIXED64:
                return Long.valueOf(l());
            case SINT32:
                return Integer.valueOf(h());
            case SINT64:
                return Long.valueOf(m());
        }
    }

    public final Object r(dr drVar, ar arVar) throws IOException {
        Object objE = drVar.e();
        Q(objE, drVar, arVar);
        drVar.f(objE);
        return objE;
    }

    public final Object s(dr drVar, ar arVar) throws IOException {
        Object objE = drVar.e();
        R(objE, drVar, arVar);
        drVar.f(objE);
        return objE;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final Object t(Class cls, ar arVar) throws IOException {
        N(2);
        return s(di.a.a(cls), arVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final String u() throws IOException {
        N(2);
        return this.a.x();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final String v() throws IOException {
        N(2);
        return this.a.y();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void w(Object obj, dr drVar, ar arVar) throws IOException {
        N(3);
        Q(obj, drVar, arVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void x(Object obj, dr drVar, ar arVar) throws IOException {
        N(2);
        R(obj, drVar, arVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void y(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof m) {
            m mVar = (m) list;
            int iB = eu.b(this.b);
            if (iB != 0) {
                if (iB != 2) {
                    throw new cb();
                }
                ac acVar = this.a;
                int iD = acVar.d() + acVar.n();
                do {
                    mVar.f(this.a.D());
                } while (this.a.d() < iD);
                S(iD);
                return;
            }
            do {
                mVar.f(this.a.D());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw new cb();
                }
                ac acVar2 = this.a;
                int iD2 = acVar2.d() + acVar2.n();
                do {
                    list.add(Boolean.valueOf(this.a.D()));
                } while (this.a.d() < iD2);
                S(iD2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.a.D()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dl
    public final void z(List list) throws IOException {
        int iM;
        int iM2;
        if (list instanceof ak) {
            ak akVar = (ak) list;
            int iB = eu.b(this.b);
            if (iB != 1) {
                if (iB != 2) {
                    throw new cb();
                }
                int iN = this.a.n();
                U(iN);
                int iD = this.a.d() + iN;
                do {
                    akVar.h(this.a.b());
                } while (this.a.d() < iD);
                return;
            }
            do {
                akVar.h(this.a.b());
                if (this.a.C()) {
                    return;
                } else {
                    iM2 = this.a.m();
                }
            } while (iM2 == this.b);
        } else {
            int iB2 = eu.b(this.b);
            if (iB2 != 1) {
                if (iB2 != 2) {
                    throw new cb();
                }
                int iN2 = this.a.n();
                U(iN2);
                int iD2 = this.a.d() + iN2;
                do {
                    list.add(Double.valueOf(this.a.b()));
                } while (this.a.d() < iD2);
                return;
            }
            do {
                list.add(Double.valueOf(this.a.b()));
                if (this.a.C()) {
                    return;
                } else {
                    iM = this.a.m();
                }
            } while (iM == this.b);
            iM2 = iM;
        }
        this.c = iM2;
    }
}
