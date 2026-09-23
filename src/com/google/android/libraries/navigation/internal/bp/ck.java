package com.google.android.libraries.navigation.internal.bp;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adr.co;
import com.google.android.libraries.navigation.internal.adr.cs;
import com.google.android.libraries.navigation.internal.adr.le;
import com.google.android.libraries.navigation.internal.adr.lj;
import com.google.android.libraries.navigation.internal.adr.ll;
import com.google.android.libraries.navigation.internal.adr.ln;
import com.google.android.libraries.navigation.internal.adr.lp;
import com.google.android.libraries.navigation.internal.adr.lr;
import com.google.android.libraries.navigation.internal.adr.ls;
import com.google.android.libraries.navigation.internal.adr.lz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.common.base.Ascii;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ck implements Serializable {
    public static final ck H;
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bp.ck");
    private static final long serialVersionUID = 5027661431752341498L;

    static {
        ck ckVarB = M().B();
        H = ckVarB;
        ev.r(ckVarB, ckVarB);
    }

    public static cj M() {
        t tVar = new t();
        tVar.m(lj.ENTITY_TYPE_DEFAULT);
        tVar.r(com.google.android.libraries.navigation.internal.adq.ar.UNKNOWN_PARKING_DIFFICULTY);
        int i = ev.d;
        tVar.g(lv.a);
        cj cjVarY = tVar.z(com.google.android.libraries.navigation.internal.ael.x.b).h(com.google.android.libraries.navigation.internal.ael.x.b.B()).y(lv.a);
        cjVarY.p(false);
        cjVarY.u();
        cjVarY.s(false);
        cjVarY.t(-1);
        cjVarY.v(true);
        t tVar2 = (t) cjVarY;
        tVar2.k = (byte) (tVar2.k | Ascii.DLE);
        cjVarY.o(0);
        cjVarY.m = 0;
        cjVarY.l(false);
        return cjVarY;
    }

    public static ck N(String str, com.google.android.libraries.navigation.internal.oe.r rVar) {
        return ac(null, rVar).B();
    }

    private static cj ab(Context context, com.google.android.libraries.navigation.internal.oe.r rVar) {
        if (context != null) {
            return ac(context.getString(com.google.android.libraries.navigation.internal.f.h.D), rVar);
        }
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('O')).p("Null context comes");
        return null;
    }

    private static cj ac(String str, com.google.android.libraries.navigation.internal.oe.r rVar) {
        cj cjVarM = M();
        cjVarM.m(lj.ENTITY_TYPE_MY_LOCATION);
        t tVar = (t) cjVarM;
        tVar.f = str;
        tVar.c = rVar;
        return cjVarM;
    }

    public abstract boolean A();

    public abstract boolean B();

    public abstract boolean C();

    public abstract boolean D();

    public abstract boolean E();

    public abstract byte[] F();

    public abstract byte[] G();

    public abstract void H();

    public abstract void I();

    public abstract void J();

    public abstract void K();

    public abstract int L();

    public final ev P() {
        return de.d(p()).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.bp.ch
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                ck ckVar = ck.H;
                return (le) ((com.google.android.libraries.navigation.internal.hc.a) obj).d((dg) le.a.aH(7, null), le.a);
            }
        }).f();
    }

    public final com.google.android.libraries.navigation.internal.adq.t Q() {
        return (com.google.android.libraries.navigation.internal.adq.t) com.google.android.libraries.navigation.internal.hc.a.e(g(), (dg) com.google.android.libraries.navigation.internal.adq.t.a.aH(7, null), com.google.android.libraries.navigation.internal.adq.t.a);
    }

    public final cs R() {
        return (cs) com.google.android.libraries.navigation.internal.hc.a.e(h(), (dg) cs.a.aH(7, null), cs.a);
    }

    public final le S() {
        return (le) com.google.android.libraries.navigation.internal.hc.a.e(e(), (dg) le.a.aH(7, null), le.a);
    }

    public final ln T() {
        return (ln) com.google.android.libraries.navigation.internal.hc.a.e(i(), (dg) ln.a.aH(7, null), ln.a);
    }

    public final lz U() {
        return (lz) com.google.android.libraries.navigation.internal.hc.a.e(l(), (dg) lz.a.aH(7, null), lz.a);
    }

    public final String V() {
        return aa();
    }

    public final boolean W() {
        return g() != null;
    }

    public final boolean X() {
        return com.google.android.libraries.navigation.internal.oe.j.h(m());
    }

    public final boolean Y() {
        return n() != null;
    }

    public final boolean Z() {
        return s() == lj.ENTITY_TYPE_MY_LOCATION;
    }

    public abstract int a();

    public final String aa() {
        if (!com.google.android.libraries.navigation.internal.yx.aq.c(y())) {
            return y();
        }
        if (!com.google.android.libraries.navigation.internal.yx.aq.c(x())) {
            return x();
        }
        com.google.android.libraries.navigation.internal.oe.r rVarN = n();
        if (rVarN == null) {
            return "";
        }
        return String.format(Locale.US, "%.7f,%.7f", Double.valueOf(rVarN.a), Double.valueOf(rVarN.b));
    }

    public abstract int b();

    public abstract cj c();

    public abstract com.google.android.libraries.navigation.internal.hc.a d();

    public abstract com.google.android.libraries.navigation.internal.hc.a e();

    public abstract com.google.android.libraries.navigation.internal.hc.a f();

    public abstract com.google.android.libraries.navigation.internal.hc.a g();

    public abstract com.google.android.libraries.navigation.internal.hc.a h();

    public abstract com.google.android.libraries.navigation.internal.hc.a i();

    public abstract com.google.android.libraries.navigation.internal.hc.a j();

    public abstract com.google.android.libraries.navigation.internal.hc.a k();

    public abstract com.google.android.libraries.navigation.internal.hc.a l();

    public abstract com.google.android.libraries.navigation.internal.oe.j m();

    public abstract com.google.android.libraries.navigation.internal.oe.r n();

    public abstract com.google.android.libraries.navigation.internal.pt.d o();

    public abstract ev p();

    public abstract ev q();

    @Deprecated
    public abstract com.google.android.libraries.navigation.internal.adq.ar r();

    public abstract lj s();

    public abstract Boolean t();

    public abstract String u();

    public abstract String v();

    public abstract String w();

    public abstract String x();

    public abstract String y();

    public abstract String z();

    /* JADX WARN: Code duplicated, block: B:101:0x017f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0190  */
    /* JADX WARN: Code duplicated, block: B:107:0x0194  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:113:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:115:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:118:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:119:0x01bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    /* JADX WARN: Code duplicated, block: B:24:0x006a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    /* JADX WARN: Code duplicated, block: B:29:0x0079  */
    /* JADX WARN: Code duplicated, block: B:32:0x007f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0081  */
    /* JADX WARN: Code duplicated, block: B:36:0x0091  */
    /* JADX WARN: Code duplicated, block: B:39:0x009d  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:63:0x0103  */
    /* JADX WARN: Code duplicated, block: B:65:0x010b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0111  */
    /* JADX WARN: Code duplicated, block: B:71:0x011a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0126  */
    /* JADX WARN: Code duplicated, block: B:77:0x013a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0140  */
    /* JADX WARN: Code duplicated, block: B:89:0x0160  */
    /* JADX WARN: Code duplicated, block: B:92:0x0166  */
    /* JADX WARN: Code duplicated, block: B:94:0x016e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0174  */
    /* JADX WARN: Code duplicated, block: B:99:0x017b  */
    public static ck O(ls lsVar, Context context) {
        lj ljVarB;
        boolean z;
        boolean z2;
        cj cjVarM;
        int i;
        lj ljVarB2;
        int iA;
        lj ljVarB3;
        lr lrVar;
        int iB;
        cs csVar;
        lj ljVarB4;
        lj ljVarB5;
        com.google.android.libraries.navigation.internal.adq.h hVar;
        com.google.android.libraries.navigation.internal.adq.z zVar;
        String str;
        int iA2;
        lj ljVarB6 = lj.b(lsVar.k);
        if (ljVarB6 == null) {
            ljVarB6 = lj.ENTITY_TYPE_DEFAULT;
        }
        cj cjVarAb = null;
        boolean z3 = true;
        if (ljVarB6 != lj.ENTITY_TYPE_MY_LOCATION) {
            ljVarB = lj.b(lsVar.k);
            if (ljVarB == null) {
                ljVarB = lj.ENTITY_TYPE_DEFAULT;
            }
            z = false;
            if (ljVarB != lj.ENTITY_TYPE_MY_LOCATION) {
                z2 = true;
            } else {
                iA2 = lp.a(lsVar.c);
                if (iA2 == 0) {
                    iA2 = lp.a;
                }
                if (iA2 == lp.d) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            com.google.android.libraries.navigation.internal.yx.ar.b(z2, "Waypoint is for user location.");
            cjVarM = M();
            i = lsVar.b;
            if ((i & 2) != 0) {
                ((t) cjVarM).a = lsVar.d;
                z3 = false;
            }
            if ((i & 4) != 0) {
                str = lsVar.e;
                if (!str.isEmpty()) {
                    ((t) cjVarM).b = com.google.android.libraries.navigation.internal.oe.j.d(str);
                    z3 = false;
                }
            }
            if ((lsVar.b & 8) != 0) {
                zVar = lsVar.f;
                if (zVar == null) {
                    zVar = com.google.android.libraries.navigation.internal.adq.z.a;
                }
                ((t) cjVarM).c = com.google.android.libraries.navigation.internal.oe.r.a(zVar);
                z3 = false;
            }
            if ((lsVar.b & 1024) != 0) {
                hVar = lsVar.l;
                if (hVar == null) {
                    hVar = com.google.android.libraries.navigation.internal.adq.h.a;
                }
                ((t) cjVarM).e = com.google.android.libraries.navigation.internal.pt.d.a(hVar);
                z3 = false;
            }
            if ((lsVar.b & 4096) != 0) {
                cjVarM.z(com.google.android.libraries.navigation.internal.ael.x.v(lsVar.m));
                z3 = false;
            }
            if ((lsVar.b & 256) != 0) {
                ((t) cjVarM).f = lsVar.j;
                z3 = false;
            } else {
                cjVarM.v(false);
            }
            if ((lsVar.b & 512) != 0) {
                ljVarB5 = lj.b(lsVar.k);
                if (ljVarB5 == null) {
                    ljVarB5 = lj.ENTITY_TYPE_DEFAULT;
                }
                if (ljVarB5 != lj.ENTITY_TYPE_DEFAULT) {
                    z3 = false;
                }
            }
            ljVarB2 = lj.b(lsVar.k);
            if (ljVarB2 == null) {
                ljVarB2 = lj.ENTITY_TYPE_DEFAULT;
            }
            cjVarM.m(ljVarB2);
            if ((lsVar.b & 65536) != 0) {
                ((t) cjVarM).j = Boolean.valueOf(lsVar.o);
                z3 = false;
            }
            iA = lp.a(lsVar.c);
            if (iA == 0) {
                iA = lp.a;
            }
            if (iA == lp.e) {
                if ((lsVar.b & 262144) != 0 || (coVar = lsVar.q) == null) {
                }
                cjVarM.n(com.google.android.libraries.navigation.internal.hc.a.a(coVar));
                z3 = false;
            }
            ljVarB3 = lj.b(lsVar.k);
            if (ljVarB3 == null) {
                ljVarB3 = lj.ENTITY_TYPE_DEFAULT;
            }
            if (ljVarB3 == lj.ENTITY_TYPE_HOME) {
                ljVarB4 = lj.b(lsVar.k);
                if (ljVarB4 == null) {
                    ljVarB4 = lj.ENTITY_TYPE_DEFAULT;
                }
                if (ljVarB4 == lj.ENTITY_TYPE_WORK) {
                    if ((lsVar.b & 4194304) != 0) {
                        lrVar = lsVar.u;
                        if (lrVar == null) {
                            lrVar = lr.a;
                        }
                        cjVarM.w(com.google.android.libraries.navigation.internal.hc.a.a(lrVar));
                        z3 = false;
                    }
                }
            } else if ((lsVar.b & 4194304) != 0) {
                lrVar = lsVar.u;
                if (lrVar == null) {
                    lrVar = lr.a;
                }
                cjVarM.w(com.google.android.libraries.navigation.internal.hc.a.a(lrVar));
                z3 = false;
            }
            if ((lsVar.b & 2097152) != 0) {
                csVar = lsVar.t;
                if (csVar == null) {
                    csVar = cs.a;
                }
                cjVarM.E(csVar);
                z3 = false;
            }
            if ((lsVar.b & 524288) != 0) {
                iB = ll.b(lsVar.r);
                if (iB == 0) {
                    iB = ll.a;
                }
                ((t) cjVarM).l = iB;
            } else {
                z = z3;
            }
            if ((lsVar.b & 1048576) != 0) {
                cjVarM.o(lsVar.s);
            } else if (!z) {
            }
            cjVarAb = cjVarM;
        } else {
            int iA3 = lp.a(lsVar.c);
            if (iA3 == 0) {
                iA3 = lp.a;
            }
            if (iA3 == lp.d) {
                int i2 = lsVar.b;
                if ((i2 & 16384) != 0) {
                    String str2 = lsVar.j;
                    String str3 = lsVar.f230n;
                    cj cjVarM2 = M();
                    cjVarM2.m(lj.ENTITY_TYPE_MY_LOCATION);
                    ((t) cjVarM2).f = str2;
                    cjVarM2.v(true);
                    int i3 = ev.d;
                    cjVarAb = cjVarM2.g(lv.a);
                    ((t) cjVarAb).g = str3;
                } else if ((i2 & 8) != 0) {
                    com.google.android.libraries.navigation.internal.adq.z zVar2 = lsVar.f;
                    if (zVar2 == null) {
                        zVar2 = com.google.android.libraries.navigation.internal.adq.z.a;
                    }
                    cjVarAb = ab(context, com.google.android.libraries.navigation.internal.oe.r.a(zVar2));
                } else {
                    cjVarAb = ab(context, null);
                }
            } else {
                ljVarB = lj.b(lsVar.k);
                if (ljVarB == null) {
                    ljVarB = lj.ENTITY_TYPE_DEFAULT;
                }
                z = false;
                if (ljVarB != lj.ENTITY_TYPE_MY_LOCATION) {
                    z2 = true;
                } else {
                    iA2 = lp.a(lsVar.c);
                    if (iA2 == 0) {
                        iA2 = lp.a;
                    }
                    if (iA2 == lp.d) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
                com.google.android.libraries.navigation.internal.yx.ar.b(z2, "Waypoint is for user location.");
                cjVarM = M();
                i = lsVar.b;
                if ((i & 2) != 0) {
                    ((t) cjVarM).a = lsVar.d;
                    z3 = false;
                }
                if ((i & 4) != 0) {
                    str = lsVar.e;
                    if (!str.isEmpty()) {
                        ((t) cjVarM).b = com.google.android.libraries.navigation.internal.oe.j.d(str);
                        z3 = false;
                    }
                }
                if ((lsVar.b & 8) != 0) {
                    zVar = lsVar.f;
                    if (zVar == null) {
                        zVar = com.google.android.libraries.navigation.internal.adq.z.a;
                    }
                    ((t) cjVarM).c = com.google.android.libraries.navigation.internal.oe.r.a(zVar);
                    z3 = false;
                }
                if ((lsVar.b & 1024) != 0) {
                    hVar = lsVar.l;
                    if (hVar == null) {
                        hVar = com.google.android.libraries.navigation.internal.adq.h.a;
                    }
                    ((t) cjVarM).e = com.google.android.libraries.navigation.internal.pt.d.a(hVar);
                    z3 = false;
                }
                if ((lsVar.b & 4096) != 0) {
                    cjVarM.z(com.google.android.libraries.navigation.internal.ael.x.v(lsVar.m));
                    z3 = false;
                }
                if ((lsVar.b & 256) != 0) {
                    ((t) cjVarM).f = lsVar.j;
                    z3 = false;
                } else {
                    cjVarM.v(false);
                }
                if ((lsVar.b & 512) != 0) {
                    ljVarB5 = lj.b(lsVar.k);
                    if (ljVarB5 == null) {
                        ljVarB5 = lj.ENTITY_TYPE_DEFAULT;
                    }
                    if (ljVarB5 != lj.ENTITY_TYPE_DEFAULT) {
                        z3 = false;
                    }
                }
                ljVarB2 = lj.b(lsVar.k);
                if (ljVarB2 == null) {
                    ljVarB2 = lj.ENTITY_TYPE_DEFAULT;
                }
                cjVarM.m(ljVarB2);
                if ((lsVar.b & 65536) != 0) {
                    ((t) cjVarM).j = Boolean.valueOf(lsVar.o);
                    z3 = false;
                }
                iA = lp.a(lsVar.c);
                if (iA == 0) {
                    iA = lp.a;
                }
                if (iA == lp.e) {
                    co coVar = (lsVar.b & 262144) != 0 ? co.a : co.a;
                    cjVarM.n(com.google.android.libraries.navigation.internal.hc.a.a(coVar));
                    z3 = false;
                }
                ljVarB3 = lj.b(lsVar.k);
                if (ljVarB3 == null) {
                    ljVarB3 = lj.ENTITY_TYPE_DEFAULT;
                }
                if (ljVarB3 == lj.ENTITY_TYPE_HOME) {
                    ljVarB4 = lj.b(lsVar.k);
                    if (ljVarB4 == null) {
                        ljVarB4 = lj.ENTITY_TYPE_DEFAULT;
                    }
                    if (ljVarB4 == lj.ENTITY_TYPE_WORK) {
                        if ((lsVar.b & 4194304) != 0) {
                            lrVar = lsVar.u;
                            if (lrVar == null) {
                                lrVar = lr.a;
                            }
                            cjVarM.w(com.google.android.libraries.navigation.internal.hc.a.a(lrVar));
                            z3 = false;
                        }
                    }
                } else if ((lsVar.b & 4194304) != 0) {
                    lrVar = lsVar.u;
                    if (lrVar == null) {
                        lrVar = lr.a;
                    }
                    cjVarM.w(com.google.android.libraries.navigation.internal.hc.a.a(lrVar));
                    z3 = false;
                }
                if ((lsVar.b & 2097152) != 0) {
                    csVar = lsVar.t;
                    if (csVar == null) {
                        csVar = cs.a;
                    }
                    cjVarM.E(csVar);
                    z3 = false;
                }
                if ((lsVar.b & 524288) != 0) {
                    iB = ll.b(lsVar.r);
                    if (iB == 0) {
                        iB = ll.a;
                    }
                    ((t) cjVarM).l = iB;
                } else {
                    z = z3;
                }
                if ((lsVar.b & 1048576) != 0) {
                    cjVarM.o(lsVar.s);
                } else if (!z) {
                }
                cjVarAb = cjVarM;
            }
        }
        return cjVarAb == null ? H : cjVarAb.B();
    }
}
