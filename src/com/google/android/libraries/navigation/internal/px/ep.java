package com.google.android.libraries.navigation.internal.px;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.libraries.navigation.internal.adg.fp;
import com.google.android.libraries.navigation.internal.adg.fq;
import com.google.android.libraries.navigation.internal.adg.fr;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ep implements ek {
    public static ep as(com.google.android.libraries.navigation.internal.adg.ef efVar, com.google.android.libraries.geo.mapcore.internal.model.v vVar, int i, com.google.android.libraries.navigation.internal.or.c cVar, cg cgVar) {
        return at(efVar, null, vVar, i, cVar, cgVar, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02da  */
    /* JADX WARN: Code duplicated, block: B:103:0x02dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x02de  */
    /* JADX WARN: Code duplicated, block: B:105:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:107:0x02e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:110:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:112:0x0304  */
    /* JADX WARN: Code duplicated, block: B:114:0x0317  */
    /* JADX WARN: Code duplicated, block: B:115:0x031a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0324  */
    /* JADX WARN: Code duplicated, block: B:122:0x032f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0334  */
    /* JADX WARN: Code duplicated, block: B:127:0x0373 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:130:0x0378  */
    /* JADX WARN: Code duplicated, block: B:133:0x039a  */
    /* JADX WARN: Code duplicated, block: B:134:0x039d  */
    /* JADX WARN: Code duplicated, block: B:137:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:138:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:141:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:143:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:144:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:146:0x0408  */
    /* JADX WARN: Code duplicated, block: B:41:0x014c  */
    /* JADX WARN: Code duplicated, block: B:72:0x023b  */
    /* JADX WARN: Code duplicated, block: B:73:0x023d  */
    /* JADX WARN: Code duplicated, block: B:76:0x025b  */
    /* JADX WARN: Code duplicated, block: B:78:0x026e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0271  */
    /* JADX WARN: Code duplicated, block: B:82:0x027d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0281  */
    /* JADX WARN: Code duplicated, block: B:85:0x0284  */
    /* JADX WARN: Code duplicated, block: B:89:0x029a  */
    /* JADX WARN: Code duplicated, block: B:91:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:92:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:94:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:96:0x02be  */
    /* JADX WARN: Code duplicated, block: B:99:0x02c4  */
    public static ep at(com.google.android.libraries.navigation.internal.adg.ef efVar, com.google.android.libraries.geo.mapcore.internal.model.av avVar, com.google.android.libraries.geo.mapcore.internal.model.v vVar, int i, com.google.android.libraries.navigation.internal.or.c cVar, cg cgVar, com.google.android.libraries.navigation.internal.adg.ef efVar2, ej ejVar) {
        long j;
        boolean z;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS;
        com.google.android.libraries.navigation.internal.ado.j jVar;
        com.google.android.libraries.navigation.internal.adq.ah ahVar;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS2;
        boolean z2;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS3;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS4;
        Object objK;
        Object objC;
        fp fpVar;
        long j2;
        boolean z3;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS5;
        Object objK2;
        Object objC2;
        int i2;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS6;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS7;
        Object objK3;
        Object objC3;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS8;
        Object objK4;
        Object objC4;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS9;
        Object objK5;
        Object objC5;
        boolean z4;
        long jA = com.google.android.libraries.navigation.internal.rb.a.a(efVar);
        String strG = com.google.android.libraries.navigation.internal.rb.a.g(efVar);
        a aVar = new a();
        Objects.requireNonNull(efVar);
        aVar.a = efVar;
        aVar.c = i;
        int i3 = aVar.C;
        aVar.d = jA;
        aVar.C = i3 | 3;
        Objects.requireNonNull(strG);
        aVar.e = strG;
        aVar.B = cVar;
        Objects.requireNonNull(cgVar);
        aVar.i = cgVar;
        aVar.b = efVar2;
        aVar.f = ejVar;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS10 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
        efVar.h(bhVarS10);
        if (efVar.w.n(bhVarS10.d)) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS11 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
            efVar.h(bhVarS11);
            Object objK6 = efVar.w.k(bhVarS11.d);
            com.google.android.libraries.navigation.internal.adl.x xVar = (com.google.android.libraries.navigation.internal.adl.x) (objK6 == null ? bhVarS11.b : bhVarS11.c(objK6));
            aVar.b(com.google.android.libraries.navigation.internal.adl.w.a(xVar.c));
            aVar.m((xVar.c == 2 ? (com.google.android.libraries.navigation.internal.adl.al) xVar.d : com.google.android.libraries.navigation.internal.adl.al.a).c);
            aVar.n(xVar.g);
            aVar.j(xVar.o);
            aVar.f(xVar.l);
            aVar.p(xVar.m);
            aVar.h(xVar.f);
            aVar.q(xVar.k);
            aVar.i(xVar.j);
        } else {
            aVar.b(com.google.android.libraries.navigation.internal.adl.w.FEATURE_NOT_SET);
            aVar.m(false);
            aVar.n(false);
            aVar.j(false);
            aVar.f(false);
            aVar.p(false);
            aVar.h(false);
            aVar.q(false);
            aVar.i(false);
        }
        int i4 = -1;
        if (avVar != null) {
            com.google.android.libraries.navigation.internal.adi.an anVarB = com.google.android.libraries.navigation.internal.adi.an.b(avVar.f);
            if (anVarB == null) {
                anVarB = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
            }
            if (anVarB.equals(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE)) {
                i4 = avVar.e;
            }
        }
        aVar.s = i4;
        aVar.C |= 524288;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS12 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.V);
        efVar.h(bhVarS12);
        if (efVar.w.n(bhVarS12.d)) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS13 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.V);
            efVar.h(bhVarS13);
            Object objK7 = efVar.w.k(bhVarS13.d);
            com.google.android.libraries.navigation.internal.adg.cx cxVar = (com.google.android.libraries.navigation.internal.adg.cx) (objK7 == null ? bhVarS13.b : bhVarS13.c(objK7));
            aVar.e(true);
            aVar.o(cxVar.m);
            aVar.c(new com.google.android.libraries.navigation.internal.oe.j(cxVar.f, cxVar.g));
            int i5 = cxVar.b;
            aVar.g(((i5 & 1) == 0 || (i5 & 2) == 0) ? false : true);
            if ((cxVar.b & 65536) != 0) {
                if (ejVar != null) {
                    z4 = ((z) ejVar).a == cxVar.o;
                }
            }
            aVar.l(z4);
        } else {
            aVar.e(false);
            aVar.o(false);
            com.google.android.libraries.navigation.internal.ael.bh bhVarS14 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.F);
            efVar.h(bhVarS14);
            Object objK8 = efVar.w.k(bhVarS14.d);
            com.google.android.libraries.navigation.internal.adq.r rVar = ((com.google.android.libraries.navigation.internal.ado.f) (objK8 == null ? bhVarS14.b : bhVarS14.c(objK8))).b;
            if (rVar == null) {
                rVar = com.google.android.libraries.navigation.internal.adq.r.a;
            }
            aVar.c((rVar.b & 2) != 0 ? com.google.android.libraries.navigation.internal.oe.j.d(rVar.d) : com.google.android.libraries.navigation.internal.oe.j.a);
            aVar.g(false);
            aVar.l(true);
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS15 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.K);
        efVar.h(bhVarS15);
        aVar.x = efVar.w.n(bhVarS15.d);
        aVar.C |= 16777216;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS16 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.O);
        efVar.h(bhVarS16);
        boolean zN = efVar.w.n(bhVarS16.d);
        aVar.v = zN;
        aVar.C |= 4194304;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS17 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.E);
        efVar.h(bhVarS17);
        Object objK9 = efVar.w.k(bhVarS17.d);
        boolean zEquals = ((com.google.android.libraries.navigation.internal.adp.b) (objK9 == null ? bhVarS17.b : bhVarS17.c(objK9))).equals(com.google.android.libraries.navigation.internal.adp.b.a);
        aVar.u = !zEquals;
        aVar.C |= 2097152;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS18 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.J);
        efVar.h(bhVarS18);
        if (efVar.w.n(bhVarS18.d)) {
            aVar.d(true);
            com.google.android.libraries.navigation.internal.ael.bh bhVarS19 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.J);
            efVar.h(bhVarS19);
            Object objK10 = efVar.w.k(bhVarS19.d);
            com.google.android.libraries.navigation.internal.aff.b bVar = (com.google.android.libraries.navigation.internal.aff.b) (objK10 == null ? bhVarS19.b : bhVarS19.c(objK10));
            if ((bVar.b & 1) != 0) {
                j = bVar.c;
            }
            if (j != 0) {
                z = true;
            } else {
                z = false;
            }
            aVar.y = z;
            aVar.C |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.M);
            efVar.h(bhVarS);
            if (efVar.w.n(bhVarS.d)) {
                bhVarS9 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.M);
                efVar.h(bhVarS9);
                objK5 = efVar.w.k(bhVarS9.d);
                if (objK5 == null) {
                    objC5 = bhVarS9.b;
                } else {
                    objC5 = bhVarS9.c(objK5);
                }
                jVar = (com.google.android.libraries.navigation.internal.ado.j) objC5;
                if ((jVar.b & 1) != 0) {
                    ahVar = jVar.c;
                    if (ahVar == null) {
                        ahVar = com.google.android.libraries.navigation.internal.adq.ah.a;
                    }
                }
                bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.e);
                efVar.h(bhVarS2);
                if (efVar.w.n(bhVarS2.d)) {
                    bhVarS8 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.e);
                    efVar.h(bhVarS8);
                    objK4 = efVar.w.k(bhVarS8.d);
                    if (objK4 == null) {
                        objC4 = bhVarS8.b;
                    } else {
                        objC4 = bhVarS8.c(objK4);
                    }
                    aVar.z = (com.google.android.libraries.navigation.internal.adl.as) objC4;
                } else {
                    aVar.z = null;
                }
                if (ahVar == null && ahVar.e) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                aVar.o = z2;
                aVar.C |= 131072;
                aVar.q = ahVar;
                aVar.w = jVar;
                if (cgVar.h()) {
                    strG = "";
                } else if (z) {
                    strG = Long.toHexString(j);
                } else if (jA != 0) {
                    bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
                    efVar.h(bhVarS3);
                    if (efVar.w.n(bhVarS3.d)) {
                        bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
                        efVar.h(bhVarS4);
                        objK = efVar.w.k(bhVarS4.d);
                        if (objK == null) {
                            objC = bhVarS4.b;
                        } else {
                            objC = bhVarS4.c(objK);
                        }
                        fpVar = ((fq) objC).b;
                        if (fpVar == null) {
                            fpVar = fp.a;
                        }
                        j2 = fpVar.b;
                        if (j2 == 0) {
                            strG = "";
                        } else {
                            strG = Long.toHexString(j2);
                        }
                    } else if (strG.isEmpty()) {
                        strG = "";
                    }
                } else if (z2) {
                    strG = "";
                } else {
                    strG = Long.toHexString(jA);
                }
                Objects.requireNonNull(strG);
                aVar.h = strG;
                com.google.android.libraries.navigation.internal.ael.bh bhVarS20 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
                efVar.h(bhVarS20);
                aVar.p = efVar.w.n(bhVarS20.d);
                aVar.C |= 262144;
                aVar.m = com.google.android.libraries.navigation.internal.rb.a.i(efVar);
                aVar.C |= 32768;
                aVar.l = com.google.android.libraries.navigation.internal.rb.a.c(efVar).l;
                int i6 = aVar.C;
                if (zEquals || zN) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                aVar.f536n = z3;
                aVar.C = 66560 | i6;
                aVar.A = avVar;
                aVar.r = vVar;
                bhVarS5 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.c);
                efVar.h(bhVarS5);
                objK2 = efVar.w.k(bhVarS5.d);
                if (objK2 == null) {
                    objC2 = bhVarS5.b;
                } else {
                    objC2 = bhVarS5.c(objK2);
                }
                com.google.android.libraries.navigation.internal.adg.es esVar = (com.google.android.libraries.navigation.internal.adg.es) objC2;
                Objects.requireNonNull(esVar);
                aVar.t = esVar;
                if (avVar == null) {
                    i2 = 0;
                } else {
                    i2 = avVar.e;
                }
                aVar.j = com.google.android.libraries.geo.mapcore.internal.model.ay.d(i2, efVar.j);
                int i7 = aVar.C;
                aVar.C = i7 | 8;
                aVar.k = com.google.android.libraries.geo.mapcore.internal.model.ay.b(i2, efVar.k);
                aVar.C = i7 | 24;
                ev evVarAu = au(efVar, avVar, vVar, i, cVar, cgVar);
                Objects.requireNonNull(evVarAu);
                aVar.g = evVarAu;
                bhVarS6 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.f);
                efVar.h(bhVarS6);
                if (efVar.w.n(bhVarS6.d)) {
                    bhVarS7 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.f);
                    efVar.h(bhVarS7);
                    objK3 = efVar.w.k(bhVarS7.d);
                    if (objK3 == null) {
                        objC3 = bhVarS7.b;
                    } else {
                        objC3 = bhVarS7.c(objK3);
                    }
                    aVar.k(((Boolean) objC3).booleanValue());
                } else {
                    aVar.k(false);
                }
                return aVar.a();
            }
            jVar = null;
            ahVar = null;
            bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.e);
            efVar.h(bhVarS2);
            if (efVar.w.n(bhVarS2.d)) {
                bhVarS8 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.e);
                efVar.h(bhVarS8);
                objK4 = efVar.w.k(bhVarS8.d);
                if (objK4 == null) {
                    objC4 = bhVarS8.b;
                } else {
                    objC4 = bhVarS8.c(objK4);
                }
                aVar.z = (com.google.android.libraries.navigation.internal.adl.as) objC4;
            } else {
                aVar.z = null;
            }
            if (ahVar == null) {
                z2 = false;
            } else {
                z2 = false;
            }
            aVar.o = z2;
            aVar.C |= 131072;
            aVar.q = ahVar;
            aVar.w = jVar;
            if (cgVar.h()) {
                strG = "";
            } else if (z) {
                strG = Long.toHexString(j);
            } else if (jA != 0) {
                bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
                efVar.h(bhVarS3);
                if (efVar.w.n(bhVarS3.d)) {
                    bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
                    efVar.h(bhVarS4);
                    objK = efVar.w.k(bhVarS4.d);
                    if (objK == null) {
                        objC = bhVarS4.b;
                    } else {
                        objC = bhVarS4.c(objK);
                    }
                    fpVar = ((fq) objC).b;
                    if (fpVar == null) {
                        fpVar = fp.a;
                    }
                    j2 = fpVar.b;
                    if (j2 == 0) {
                        strG = "";
                    } else {
                        strG = Long.toHexString(j2);
                    }
                } else if (strG.isEmpty()) {
                    strG = "";
                }
            } else if (z2) {
                strG = "";
            } else {
                strG = Long.toHexString(jA);
            }
            Objects.requireNonNull(strG);
            aVar.h = strG;
            com.google.android.libraries.navigation.internal.ael.bh bhVarS21 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
            efVar.h(bhVarS21);
            aVar.p = efVar.w.n(bhVarS21.d);
            aVar.C |= 262144;
            aVar.m = com.google.android.libraries.navigation.internal.rb.a.i(efVar);
            aVar.C |= 32768;
            aVar.l = com.google.android.libraries.navigation.internal.rb.a.c(efVar).l;
            int i8 = aVar.C;
            if (zEquals) {
                z3 = true;
            } else {
                z3 = true;
            }
            aVar.f536n = z3;
            aVar.C = 66560 | i8;
            aVar.A = avVar;
            aVar.r = vVar;
            bhVarS5 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.c);
            efVar.h(bhVarS5);
            objK2 = efVar.w.k(bhVarS5.d);
            if (objK2 == null) {
                objC2 = bhVarS5.b;
            } else {
                objC2 = bhVarS5.c(objK2);
            }
            com.google.android.libraries.navigation.internal.adg.es esVar2 = (com.google.android.libraries.navigation.internal.adg.es) objC2;
            Objects.requireNonNull(esVar2);
            aVar.t = esVar2;
            if (avVar == null) {
                i2 = 0;
            } else {
                i2 = avVar.e;
            }
            aVar.j = com.google.android.libraries.geo.mapcore.internal.model.ay.d(i2, efVar.j);
            int i9 = aVar.C;
            aVar.C = i9 | 8;
            aVar.k = com.google.android.libraries.geo.mapcore.internal.model.ay.b(i2, efVar.k);
            aVar.C = i9 | 24;
            ev evVarAu2 = au(efVar, avVar, vVar, i, cVar, cgVar);
            Objects.requireNonNull(evVarAu2);
            aVar.g = evVarAu2;
            bhVarS6 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.f);
            efVar.h(bhVarS6);
            if (efVar.w.n(bhVarS6.d)) {
                bhVarS7 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.f);
                efVar.h(bhVarS7);
                objK3 = efVar.w.k(bhVarS7.d);
                if (objK3 == null) {
                    objC3 = bhVarS7.b;
                } else {
                    objC3 = bhVarS7.c(objK3);
                }
                aVar.k(((Boolean) objC3).booleanValue());
            } else {
                aVar.k(false);
            }
            return aVar.a();
        }
        aVar.d(false);
        j = 0;
        if (j != 0) {
            z = true;
        } else {
            z = false;
        }
        aVar.y = z;
        aVar.C |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.M);
        efVar.h(bhVarS);
        if (efVar.w.n(bhVarS.d)) {
            bhVarS9 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.M);
            efVar.h(bhVarS9);
            objK5 = efVar.w.k(bhVarS9.d);
            if (objK5 == null) {
                objC5 = bhVarS9.b;
            } else {
                objC5 = bhVarS9.c(objK5);
            }
            jVar = (com.google.android.libraries.navigation.internal.ado.j) objC5;
            if ((jVar.b & 1) != 0) {
                ahVar = jVar.c;
                if (ahVar == null) {
                    ahVar = com.google.android.libraries.navigation.internal.adq.ah.a;
                }
            }
            bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.e);
            efVar.h(bhVarS2);
            if (efVar.w.n(bhVarS2.d)) {
                bhVarS8 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.e);
                efVar.h(bhVarS8);
                objK4 = efVar.w.k(bhVarS8.d);
                if (objK4 == null) {
                    objC4 = bhVarS8.b;
                } else {
                    objC4 = bhVarS8.c(objK4);
                }
                aVar.z = (com.google.android.libraries.navigation.internal.adl.as) objC4;
            } else {
                aVar.z = null;
            }
            if (ahVar == null) {
                z2 = false;
            } else {
                z2 = false;
            }
            aVar.o = z2;
            aVar.C |= 131072;
            aVar.q = ahVar;
            aVar.w = jVar;
            if (cgVar.h()) {
                strG = "";
            } else if (z) {
                strG = Long.toHexString(j);
            } else if (jA != 0) {
                bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
                efVar.h(bhVarS3);
                if (efVar.w.n(bhVarS3.d)) {
                    bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
                    efVar.h(bhVarS4);
                    objK = efVar.w.k(bhVarS4.d);
                    if (objK == null) {
                        objC = bhVarS4.b;
                    } else {
                        objC = bhVarS4.c(objK);
                    }
                    fpVar = ((fq) objC).b;
                    if (fpVar == null) {
                        fpVar = fp.a;
                    }
                    j2 = fpVar.b;
                    if (j2 == 0) {
                        strG = "";
                    } else {
                        strG = Long.toHexString(j2);
                    }
                } else if (strG.isEmpty()) {
                    strG = "";
                }
            } else if (z2) {
                strG = "";
            } else {
                strG = Long.toHexString(jA);
            }
            Objects.requireNonNull(strG);
            aVar.h = strG;
            com.google.android.libraries.navigation.internal.ael.bh bhVarS22 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
            efVar.h(bhVarS22);
            aVar.p = efVar.w.n(bhVarS22.d);
            aVar.C |= 262144;
            aVar.m = com.google.android.libraries.navigation.internal.rb.a.i(efVar);
            aVar.C |= 32768;
            aVar.l = com.google.android.libraries.navigation.internal.rb.a.c(efVar).l;
            int i10 = aVar.C;
            if (zEquals) {
                z3 = true;
            } else {
                z3 = true;
            }
            aVar.f536n = z3;
            aVar.C = 66560 | i10;
            aVar.A = avVar;
            aVar.r = vVar;
            bhVarS5 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.c);
            efVar.h(bhVarS5);
            objK2 = efVar.w.k(bhVarS5.d);
            if (objK2 == null) {
                objC2 = bhVarS5.b;
            } else {
                objC2 = bhVarS5.c(objK2);
            }
            com.google.android.libraries.navigation.internal.adg.es esVar3 = (com.google.android.libraries.navigation.internal.adg.es) objC2;
            Objects.requireNonNull(esVar3);
            aVar.t = esVar3;
            if (avVar == null) {
                i2 = 0;
            } else {
                i2 = avVar.e;
            }
            aVar.j = com.google.android.libraries.geo.mapcore.internal.model.ay.d(i2, efVar.j);
            int i11 = aVar.C;
            aVar.C = i11 | 8;
            aVar.k = com.google.android.libraries.geo.mapcore.internal.model.ay.b(i2, efVar.k);
            aVar.C = i11 | 24;
            ev evVarAu3 = au(efVar, avVar, vVar, i, cVar, cgVar);
            Objects.requireNonNull(evVarAu3);
            aVar.g = evVarAu3;
            bhVarS6 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.f);
            efVar.h(bhVarS6);
            if (efVar.w.n(bhVarS6.d)) {
                bhVarS7 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.f);
                efVar.h(bhVarS7);
                objK3 = efVar.w.k(bhVarS7.d);
                if (objK3 == null) {
                    objC3 = bhVarS7.b;
                } else {
                    objC3 = bhVarS7.c(objK3);
                }
                aVar.k(((Boolean) objC3).booleanValue());
            } else {
                aVar.k(false);
            }
            return aVar.a();
        }
        jVar = null;
        ahVar = null;
        bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.e);
        efVar.h(bhVarS2);
        if (efVar.w.n(bhVarS2.d)) {
            bhVarS8 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.e);
            efVar.h(bhVarS8);
            objK4 = efVar.w.k(bhVarS8.d);
            if (objK4 == null) {
                objC4 = bhVarS8.b;
            } else {
                objC4 = bhVarS8.c(objK4);
            }
            aVar.z = (com.google.android.libraries.navigation.internal.adl.as) objC4;
        } else {
            aVar.z = null;
        }
        if (ahVar == null) {
            z2 = false;
        } else {
            z2 = false;
        }
        aVar.o = z2;
        aVar.C |= 131072;
        aVar.q = ahVar;
        aVar.w = jVar;
        if (cgVar.h()) {
            strG = "";
        } else if (z) {
            strG = Long.toHexString(j);
        } else if (jA != 0) {
            bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
            efVar.h(bhVarS3);
            if (efVar.w.n(bhVarS3.d)) {
                bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
                efVar.h(bhVarS4);
                objK = efVar.w.k(bhVarS4.d);
                if (objK == null) {
                    objC = bhVarS4.b;
                } else {
                    objC = bhVarS4.c(objK);
                }
                fpVar = ((fq) objC).b;
                if (fpVar == null) {
                    fpVar = fp.a;
                }
                j2 = fpVar.b;
                if (j2 == 0) {
                    strG = "";
                } else {
                    strG = Long.toHexString(j2);
                }
            } else if (strG.isEmpty()) {
                strG = "";
            }
        } else if (z2) {
            strG = "";
        } else {
            strG = Long.toHexString(jA);
        }
        Objects.requireNonNull(strG);
        aVar.h = strG;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS23 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.Q);
        efVar.h(bhVarS23);
        aVar.p = efVar.w.n(bhVarS23.d);
        aVar.C |= 262144;
        aVar.m = com.google.android.libraries.navigation.internal.rb.a.i(efVar);
        aVar.C |= 32768;
        aVar.l = com.google.android.libraries.navigation.internal.rb.a.c(efVar).l;
        int i12 = aVar.C;
        if (zEquals) {
            z3 = true;
        } else {
            z3 = true;
        }
        aVar.f536n = z3;
        aVar.C = 66560 | i12;
        aVar.A = avVar;
        aVar.r = vVar;
        bhVarS5 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.c);
        efVar.h(bhVarS5);
        objK2 = efVar.w.k(bhVarS5.d);
        if (objK2 == null) {
            objC2 = bhVarS5.b;
        } else {
            objC2 = bhVarS5.c(objK2);
        }
        com.google.android.libraries.navigation.internal.adg.es esVar4 = (com.google.android.libraries.navigation.internal.adg.es) objC2;
        Objects.requireNonNull(esVar4);
        aVar.t = esVar4;
        if (avVar == null) {
            i2 = 0;
        } else {
            i2 = avVar.e;
        }
        aVar.j = com.google.android.libraries.geo.mapcore.internal.model.ay.d(i2, efVar.j);
        int i13 = aVar.C;
        aVar.C = i13 | 8;
        aVar.k = com.google.android.libraries.geo.mapcore.internal.model.ay.b(i2, efVar.k);
        aVar.C = i13 | 24;
        ev evVarAu4 = au(efVar, avVar, vVar, i, cVar, cgVar);
        Objects.requireNonNull(evVarAu4);
        aVar.g = evVarAu4;
        bhVarS6 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.f);
        efVar.h(bhVarS6);
        if (efVar.w.n(bhVarS6.d)) {
            bhVarS7 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.f);
            efVar.h(bhVarS7);
            objK3 = efVar.w.k(bhVarS7.d);
            if (objK3 == null) {
                objC3 = bhVarS7.b;
            } else {
                objC3 = bhVarS7.c(objK3);
            }
            aVar.k(((Boolean) objC3).booleanValue());
        } else {
            aVar.k(false);
        }
        return aVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:77:0x022c  */
    private static ev au(com.google.android.libraries.navigation.internal.adg.ef efVar, com.google.android.libraries.geo.mapcore.internal.model.av avVar, com.google.android.libraries.geo.mapcore.internal.model.v vVar, int i, com.google.android.libraries.navigation.internal.or.c cVar, cg cgVar) {
        boolean z;
        String strF;
        com.google.android.libraries.navigation.internal.adg.cw cwVar;
        com.google.android.libraries.navigation.internal.adg.dy dyVarD;
        eo eoVar;
        boolean z2;
        boolean z3;
        if (efVar.s.isEmpty()) {
            int i2 = ev.d;
            return lv.a;
        }
        HashMap map = new HashMap();
        Iterator it2 = efVar.r.iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            com.google.android.libraries.navigation.internal.adg.ea eaVar = (com.google.android.libraries.navigation.internal.adg.ea) it2.next();
            if ((eaVar.b & 1) != 0) {
                int i3 = eaVar.c;
                Integer numValueOf = Integer.valueOf(i3);
                if (map.containsKey(numValueOf)) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(951)).q("ignoring alternate representation for tag %s because it has multiple occurrences - only the first one will be used", i3);
                } else {
                    map.put(numValueOf, eaVar);
                }
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(952)).p("ignoring alternate representation that does not contain the required tag value");
            }
        }
        HashMap map2 = new HashMap();
        for (com.google.android.libraries.navigation.internal.adg.ec ecVar : efVar.s) {
            if ((ecVar.b & 1) != 0) {
                int i4 = ecVar.c;
                Integer numValueOf2 = Integer.valueOf(i4);
                if (map2.containsKey(numValueOf2)) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(949)).q("ignoring representation zoom data for tag %s because it has multiple occurrences - only the first one will be used", i4);
                } else {
                    map2.put(numValueOf2, ecVar);
                }
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(950)).p("ignoring representation zoom data that does not contain the required tag value");
            }
        }
        eo eoVar2 = new eo(map, map2);
        com.google.android.libraries.navigation.internal.agg.bz bzVar = new com.google.android.libraries.navigation.internal.agg.bz(eoVar2.b.size());
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.V);
        efVar.h(bhVarS);
        Object objK = efVar.w.k(bhVarS.d);
        com.google.android.libraries.navigation.internal.adg.cx cxVar = (com.google.android.libraries.navigation.internal.adg.cx) (objK == null ? bhVarS.b : bhVarS.c(objK));
        com.google.android.libraries.navigation.internal.yx.an anVarJ = (cxVar.b & 262144) != 0 ? com.google.android.libraries.navigation.internal.yx.an.j(Integer.valueOf(cxVar.p)) : com.google.android.libraries.navigation.internal.yx.a.a;
        Iterator it3 = eoVar2.b.entrySet().iterator();
        while (true) {
            com.google.android.libraries.navigation.internal.adg.dy dyVar = null;
            if (!it3.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it3.next();
            Integer num = (Integer) entry.getKey();
            int iIntValue = num.intValue();
            boolean z4 = iIntValue == 0 ? z : false;
            com.google.android.libraries.navigation.internal.adg.ec ecVar2 = (com.google.android.libraries.navigation.internal.adg.ec) entry.getValue();
            com.google.android.libraries.navigation.internal.adg.ea eaVar2 = z4 ? null : (com.google.android.libraries.navigation.internal.adg.ea) eoVar2.a.get(num);
            if (eaVar2 != null || z4) {
                com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) efVar.aH(5, null);
                bbVar.x(efVar);
                com.google.android.libraries.navigation.internal.adg.dy dyVar2 = (com.google.android.libraries.navigation.internal.adg.dy) bbVar;
                if (!dyVar2.b.H()) {
                    dyVar2.v();
                }
                ((com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b).r = com.google.android.libraries.navigation.internal.ael.dj.b;
                if (!dyVar2.b.H()) {
                    dyVar2.v();
                }
                ((com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b).s = com.google.android.libraries.navigation.internal.ael.dj.b;
                if (eaVar2 == null) {
                    eoVar = eoVar2;
                    z2 = z;
                } else {
                    if ((eaVar2.b & 128) != 0) {
                        if (!dyVar2.b.H()) {
                            dyVar2.v();
                        }
                        com.google.android.libraries.navigation.internal.adg.ef efVar2 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                        efVar2.b &= -8193;
                        eoVar = eoVar2;
                        efVar2.m = -1L;
                        if (!dyVar2.b.H()) {
                            dyVar2.v();
                        }
                        com.google.android.libraries.navigation.internal.adg.ef efVar3 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                        efVar3.b &= -4097;
                        efVar3.l = -1;
                        dyVar2.B(com.google.android.libraries.navigation.internal.adg.et.c);
                        if ((eaVar2.b & 64) == 0) {
                            z3 = false;
                        } else {
                            com.google.android.libraries.navigation.internal.adg.ef efVar4 = eaVar2.i;
                            if (efVar4 == null) {
                                efVar4 = com.google.android.libraries.navigation.internal.adg.ef.a;
                            }
                            com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) efVar4.aH(5, null);
                            bbVar2.x(efVar4);
                            com.google.android.libraries.navigation.internal.adg.dy dyVar3 = (com.google.android.libraries.navigation.internal.adg.dy) bbVar2;
                            dyVar3.B(com.google.android.libraries.navigation.internal.adg.bj.V);
                            com.google.android.libraries.navigation.internal.adg.ef efVar5 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar3.t();
                            dyVar2.x(efVar5);
                            com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.c);
                            efVar5.h(bhVarS2);
                            if (efVar5.w.n(bhVarS2.d)) {
                                com.google.android.libraries.navigation.internal.ael.bh bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.c);
                                efVar5.h(bhVarS3);
                                Object objK2 = efVar5.w.k(bhVarS3.d);
                                if ((((com.google.android.libraries.navigation.internal.adg.es) (objK2 == null ? bhVarS3.b : bhVarS3.c(objK2))).b & 1) != 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } else {
                                z3 = false;
                            }
                        }
                        int i5 = eaVar2.b;
                        if (!(z3 ^ ((i5 & 8) != 0))) {
                            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(954)).q("ignoring label representation because there is not exactly one of multi_zoom_style_id and extensions_holder.[legend_named_style_for_label].named_style_id set - tag=%s", eaVar2.c);
                            dyVar2 = null;
                            z2 = true;
                        } else if ((i5 & 2) != 0) {
                            if ((i5 & 128) != 0) {
                                int i6 = eaVar2.j;
                                if (!dyVar2.b.H()) {
                                    dyVar2.v();
                                }
                                com.google.android.libraries.navigation.internal.adg.ef efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                                efVar6.b |= 128;
                                efVar6.i = i6;
                            }
                            if ((eaVar2.b & 32) != 0) {
                                int i7 = eaVar2.g;
                                if (!dyVar2.b.H()) {
                                    dyVar2.v();
                                }
                                com.google.android.libraries.navigation.internal.adg.ef efVar7 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                                efVar7.b |= 64;
                                efVar7.h = i7;
                            }
                            if ((eaVar2.b & 8) != 0) {
                                long j = eaVar2.f;
                                if (!dyVar2.b.H()) {
                                    dyVar2.v();
                                }
                                com.google.android.libraries.navigation.internal.adg.ef efVar8 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                                efVar8.b |= 8192;
                                efVar8.m = j;
                                dyVar2.B(com.google.android.libraries.navigation.internal.adg.et.c);
                            }
                            com.google.android.libraries.navigation.internal.adg.dt dtVar = eaVar2.d;
                            if (dtVar == null) {
                                dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
                            }
                            if (!dyVar2.b.H()) {
                                dyVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.adg.ef efVar9 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                            dtVar.getClass();
                            efVar9.c = dtVar;
                            z2 = true;
                            efVar9.b |= 1;
                            if ((eaVar2.b & 4) != 0) {
                                com.google.android.libraries.navigation.internal.adg.dt dtVar2 = eaVar2.e;
                                if (dtVar2 == null) {
                                    dtVar2 = com.google.android.libraries.navigation.internal.adg.dt.a;
                                }
                                if (!dyVar2.b.H()) {
                                    dyVar2.v();
                                }
                                com.google.android.libraries.navigation.internal.adg.ef efVar10 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                                dtVar2.getClass();
                                efVar10.d = dtVar2;
                                efVar10.b |= 2;
                            } else {
                                if (!dyVar2.b.H()) {
                                    dyVar2.v();
                                }
                                com.google.android.libraries.navigation.internal.adg.ef efVar11 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                                efVar11.d = null;
                                efVar11.b &= -3;
                            }
                            if (!dyVar2.b.H()) {
                                dyVar2.v();
                            }
                            ((com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b).q = com.google.android.libraries.navigation.internal.ael.dj.b;
                            com.google.android.libraries.navigation.internal.ael.bz bzVar2 = eaVar2.h;
                            if (!dyVar2.b.H()) {
                                dyVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.adg.ef efVar12 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                            com.google.android.libraries.navigation.internal.ael.bz bzVar3 = efVar12.q;
                            if (!bzVar3.c()) {
                                efVar12.q = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar3);
                            }
                            com.google.android.libraries.navigation.internal.ael.b.m(bzVar2, efVar12.q);
                        } else {
                            z2 = true;
                            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(953)).q("ignoring label representation for tag %s because it does not have the required primary label group.", eaVar2.c);
                        }
                    } else {
                        eoVar = eoVar2;
                        z2 = z;
                        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(955)).q("ignoring label representation because it has no rank - tag=%s", eaVar2.c);
                    }
                    dyVar2 = null;
                }
                if (dyVar2 != null) {
                    int i8 = ecVar2.b;
                    if ((i8 & 2) != 0 && (i8 & 8) != 0) {
                        final int i9 = (avVar == null ? 0 : avVar.e) * 8;
                        int iMax = Math.max(ecVar2.d - i9, ((Integer) ((efVar.b & 256) != 0 ? com.google.android.libraries.navigation.internal.yx.an.j(Integer.valueOf(efVar.j)) : com.google.android.libraries.navigation.internal.yx.a.a).e(Integer.MIN_VALUE)).intValue());
                        if (!dyVar2.b.H()) {
                            dyVar2.v();
                        }
                        com.google.android.libraries.navigation.internal.adg.ef efVar13 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                        efVar13.b |= 256;
                        efVar13.j = iMax;
                        com.google.android.libraries.navigation.internal.yx.an anVarJ2 = (ecVar2.b & 4) != 0 ? com.google.android.libraries.navigation.internal.yx.an.j(Integer.valueOf(ecVar2.e)) : com.google.android.libraries.navigation.internal.yx.a.a;
                        com.google.android.libraries.navigation.internal.yx.an anVarJ3 = (efVar.b & 512) != 0 ? com.google.android.libraries.navigation.internal.yx.an.j(Integer.valueOf(efVar.k)) : com.google.android.libraries.navigation.internal.yx.a.a;
                        if (anVarJ2.g() || anVarJ3.g()) {
                            int iMin = Math.min(((Integer) anVarJ2.b(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.el
                                @Override // com.google.android.libraries.navigation.internal.yx.aa
                                public final Object ak(Object obj) {
                                    return Integer.valueOf(((Integer) obj).intValue() - i9);
                                }
                            }).e(Integer.MAX_VALUE)).intValue(), ((Integer) anVarJ3.e(Integer.MAX_VALUE)).intValue());
                            if (!dyVar2.b.H()) {
                                dyVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.adg.ef efVar14 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar2.b;
                            efVar14.b |= 512;
                            efVar14.k = iMin;
                        }
                        dyVar = dyVar2;
                    }
                }
                boolean z5 = (anVarJ.g() && ((Integer) anVarJ.c()).equals(num)) ? z2 : false;
                if (dyVar != null) {
                    bzVar.a(iIntValue, new y(dyVar, iIntValue, ecVar2.f, z5 ? com.google.android.libraries.navigation.internal.yx.a.a : anVarJ));
                } else {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(956)).q("failed to create multi-representation instance for tag %s", iIntValue);
                }
                z = z2;
                eoVar2 = eoVar;
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(957)).q("ignoring zoom information for non-existent alternate representation for tag %s", iIntValue);
            }
        }
        eo eoVar3 = eoVar2;
        boolean z6 = z;
        com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
        gi giVarListIterator = bzVar.values().listIterator();
        while (giVarListIterator.hasNext()) {
            en enVar = (en) giVarListIterator.next();
            if (enVar.c().g()) {
                en enVar2 = (en) bzVar.p(((Integer) enVar.c().c()).intValue());
                if (enVar2 == null) {
                    dyVarD = enVar.d();
                } else {
                    com.google.android.libraries.navigation.internal.adg.dy dyVarD2 = enVar.d();
                    com.google.android.libraries.navigation.internal.adg.dy dyVarD3 = enVar2.d();
                    com.google.android.libraries.navigation.internal.adg.cx cxVarC = com.google.android.libraries.navigation.internal.rb.a.c(dyVarD3);
                    if (cxVarC.equals(com.google.android.libraries.navigation.internal.adg.bj.V.b) || (cxVarC.b & 512) == 0) {
                        com.google.android.libraries.navigation.internal.adg.dt dtVarC = dyVarD3.c();
                        strF = dtVarC.c.size() > 0 ? com.google.android.libraries.navigation.internal.rb.a.f(dtVarC) : "";
                        if (dyVarD3.e()) {
                            com.google.android.libraries.navigation.internal.adg.dt dtVarD = dyVarD3.d();
                            if (dtVarD.c.size() > 0) {
                                String strF2 = com.google.android.libraries.navigation.internal.rb.a.f(dtVarD);
                                if (strF.length() > 0 && strF2.length() > 0) {
                                    strF = String.valueOf(strF).concat("\n");
                                }
                                strF = String.valueOf(strF).concat(String.valueOf(strF2));
                            }
                        }
                    } else {
                        strF = cxVarC.i;
                    }
                    boolean z7 = (!dyVarD3.z(com.google.android.libraries.navigation.internal.adg.bj.V) || (((com.google.android.libraries.navigation.internal.adg.cx) dyVarD3.y(com.google.android.libraries.navigation.internal.adg.bj.V)).b & 1024) == 0) ? false : z6;
                    if (dyVarD2.z(com.google.android.libraries.navigation.internal.adg.bj.V)) {
                        com.google.android.libraries.navigation.internal.adg.cx cxVar2 = (com.google.android.libraries.navigation.internal.adg.cx) dyVarD2.y(com.google.android.libraries.navigation.internal.adg.bj.V);
                        com.google.android.libraries.navigation.internal.ael.bb bbVar3 = (com.google.android.libraries.navigation.internal.ael.bb) cxVar2.aH(5, null);
                        bbVar3.x(cxVar2);
                        cwVar = (com.google.android.libraries.navigation.internal.adg.cw) bbVar3;
                    } else {
                        cwVar = (com.google.android.libraries.navigation.internal.adg.cw) com.google.android.libraries.navigation.internal.adg.cx.a.q();
                    }
                    if (z7) {
                        String str = ((com.google.android.libraries.navigation.internal.adg.cx) dyVarD3.y(com.google.android.libraries.navigation.internal.adg.bj.V)).j;
                        if (!cwVar.b.H()) {
                            cwVar.v();
                        }
                        com.google.android.libraries.navigation.internal.adg.cx cxVar3 = (com.google.android.libraries.navigation.internal.adg.cx) cwVar.b;
                        str.getClass();
                        cxVar3.b |= 1024;
                        cxVar3.j = str;
                    } else {
                        if (!cwVar.b.H()) {
                            cwVar.v();
                        }
                        com.google.android.libraries.navigation.internal.adg.cx cxVar4 = (com.google.android.libraries.navigation.internal.adg.cx) cwVar.b;
                        cxVar4.b &= -1025;
                        cxVar4.j = com.google.android.libraries.navigation.internal.adg.cx.a.j;
                    }
                    if (!cwVar.b.H()) {
                        cwVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adg.cx cxVar5 = (com.google.android.libraries.navigation.internal.adg.cx) cwVar.b;
                    strF.getClass();
                    cxVar5.b |= 512;
                    cxVar5.i = strF;
                    dyVarD2.C(com.google.android.libraries.navigation.internal.adg.bj.V, (com.google.android.libraries.navigation.internal.adg.cx) cwVar.t());
                    dyVarD = dyVarD2;
                }
            } else {
                dyVarD = enVar.d();
            }
            eqVar.h(at((com.google.android.libraries.navigation.internal.adg.ef) dyVarD.t(), avVar, vVar, i, cVar, cgVar, efVar, new z(enVar.b(), enVar.a())));
        }
        ev evVarG = eqVar.g();
        return (evVarG.isEmpty() && ((!eoVar3.a.isEmpty() || !eoVar3.b.isEmpty()) ? z6 : false)) ? lv.a : evVarG;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public int T() {
        com.google.android.libraries.navigation.internal.zl.n nVarC = com.google.android.libraries.navigation.internal.zl.h.a.c((o().q.size() * 8) + 12);
        for (com.google.android.libraries.navigation.internal.adg.w wVar : o().q) {
            nVarC.c(wVar.b);
            nVarC.c(wVar.c);
        }
        if ((o().b & 8192) != 0) {
            nVarC.i(o().m);
            nVarC.c(X());
        } else if ((o().b & 4096) == 0) {
            nVarC.i(p().c);
        }
        return nVarC.o().a();
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public int U() {
        com.google.android.libraries.navigation.internal.zl.n nVarE = com.google.android.libraries.navigation.internal.zl.h.a.e();
        com.google.android.libraries.navigation.internal.adg.dt dtVar = o().c;
        if (dtVar == null) {
            dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        for (com.google.android.libraries.navigation.internal.adg.dp dpVar : dtVar.c) {
            nVarE.b(dpVar.c.getBytes());
            nVarE.i(dpVar.e);
        }
        if ((o().b & 2) != 0) {
            com.google.android.libraries.navigation.internal.adg.dt dtVar2 = o().d;
            if (dtVar2 == null) {
                dtVar2 = com.google.android.libraries.navigation.internal.adg.dt.a;
            }
            for (com.google.android.libraries.navigation.internal.adg.dp dpVar2 : dtVar2.c) {
                nVarE.b(dpVar2.c.getBytes());
                nVarE.i(dpVar2.e);
            }
        }
        if ((o().b & 8192) != 0) {
            nVarE.i(o().m);
            nVarE.c(X());
        }
        return nVarE.o().a();
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public fs V() {
        cg cgVarH = h();
        com.google.android.libraries.navigation.internal.adg.ef efVarO = o();
        com.google.android.libraries.navigation.internal.oe.x xVar = cgVarH.h() ? ((m) cgVarH).a.a : null;
        com.google.android.libraries.navigation.internal.or.c cVarG = g();
        fs fsVar = efVarO.u;
        if (fsVar == null) {
            fsVar = fs.a;
        }
        com.google.android.libraries.navigation.internal.pm.g gVar = new com.google.android.libraries.navigation.internal.pm.g(efVarO, fsVar);
        com.google.android.libraries.navigation.internal.pm.g.b(gVar);
        if (xVar != null) {
            com.google.android.libraries.navigation.internal.adk.h hVar = (com.google.android.libraries.navigation.internal.adk.h) gVar.a().y(com.google.android.libraries.navigation.internal.adk.i.a);
            com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) hVar.aH(5, null);
            bbVar.x(hVar);
            com.google.android.libraries.navigation.internal.adk.g gVar2 = (com.google.android.libraries.navigation.internal.adk.g) bbVar;
            com.google.android.libraries.navigation.internal.adk.l lVar = (com.google.android.libraries.navigation.internal.adk.l) com.google.android.libraries.navigation.internal.adk.m.a.q();
            double dB = xVar.b();
            if (!lVar.b.H()) {
                lVar.v();
            }
            com.google.android.libraries.navigation.internal.adk.m mVar = (com.google.android.libraries.navigation.internal.adk.m) lVar.b;
            mVar.b |= 1;
            mVar.c = dB;
            double d = xVar.d();
            if (!lVar.b.H()) {
                lVar.v();
            }
            com.google.android.libraries.navigation.internal.adk.m mVar2 = (com.google.android.libraries.navigation.internal.adk.m) lVar.b;
            mVar2.b |= 2;
            mVar2.d = d;
            if (!gVar2.b.H()) {
                gVar2.v();
            }
            com.google.android.libraries.navigation.internal.adk.h hVar2 = (com.google.android.libraries.navigation.internal.adk.h) gVar2.b;
            com.google.android.libraries.navigation.internal.adk.m mVar3 = (com.google.android.libraries.navigation.internal.adk.m) lVar.t();
            com.google.android.libraries.navigation.internal.adk.h hVar3 = com.google.android.libraries.navigation.internal.adk.h.a;
            mVar3.getClass();
            hVar2.c = mVar3;
            hVar2.b |= 128;
            gVar.a().C(com.google.android.libraries.navigation.internal.adk.i.a, (com.google.android.libraries.navigation.internal.adk.h) gVar2.t());
        }
        if (cVarG != null) {
            com.google.android.libraries.navigation.internal.adk.b bVar = (com.google.android.libraries.navigation.internal.adk.b) gVar.a().y(com.google.android.libraries.navigation.internal.adk.c.a);
            com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) bVar.aH(5, null);
            bbVar2.x(bVar);
            com.google.android.libraries.navigation.internal.adk.a aVar = (com.google.android.libraries.navigation.internal.adk.a) bbVar2;
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.adk.b bVar2 = (com.google.android.libraries.navigation.internal.adk.b) aVar.b;
            com.google.android.libraries.navigation.internal.adk.b bVar3 = com.google.android.libraries.navigation.internal.adk.b.a;
            bVar2.b |= 1;
            bVar2.c = ((com.google.android.libraries.navigation.internal.or.a) cVarG).a;
            gVar.a().C(com.google.android.libraries.navigation.internal.adk.c.a, (com.google.android.libraries.navigation.internal.adk.b) aVar.t());
        }
        fr frVar = gVar.b;
        return frVar == null ? gVar.a : (fs) frVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final int W() {
        return o().h;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final int X() {
        com.google.android.libraries.geo.mapcore.internal.model.av avVarL = l();
        if (avVarL == null || (avVarL.b & 16) == 0) {
            return -1;
        }
        return avVarL.g;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final int Y() {
        com.google.android.libraries.geo.mapcore.internal.model.av avVarL = l();
        if (avVarL == null) {
            return 0;
        }
        return avVarL.e;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final ek Z(com.google.android.libraries.navigation.internal.adg.ef efVar, int i, cg cgVar) {
        return at(efVar, l(), k(), i, g(), cgVar, null, i());
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final ek aa(com.google.android.libraries.navigation.internal.adg.ef efVar) {
        com.google.android.libraries.navigation.internal.adg.ef efVarN = n();
        com.google.android.libraries.geo.mapcore.internal.model.av avVarL = l();
        com.google.android.libraries.geo.mapcore.internal.model.v vVarK = k();
        int iC = c();
        com.google.android.libraries.navigation.internal.or.c cVarG = g();
        cg cgVarH = h();
        if (efVarN == null) {
            efVarN = o();
        }
        return at(efVar, avVarL, vVarK, iC, cVarG, cgVarH, efVarN, i());
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final ek ab() {
        em emVarJ = j();
        ((a) emVarJ).r = null;
        return emVarJ.a();
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final com.google.android.libraries.navigation.internal.adi.an ac() {
        com.google.android.libraries.geo.mapcore.internal.model.av avVarL = l();
        if (avVarL == null) {
            return null;
        }
        com.google.android.libraries.navigation.internal.adi.an anVarB = com.google.android.libraries.navigation.internal.adi.an.b(avVarL.f);
        return anVarB == null ? com.google.android.libraries.navigation.internal.adi.an.UNKNOWN : anVarB;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean ad(float f) {
        return f >= b() && f < a();
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean ae() {
        return com.google.android.libraries.navigation.internal.rb.a.h(W(), 8);
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean af() {
        return q() == com.google.android.libraries.navigation.internal.adl.w.IS_BIKESHARING_VEHICLE;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean ag() {
        return q() == com.google.android.libraries.navigation.internal.adl.w.IS_BLUE_DOT_CALLOUT;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean ah() {
        return ai() || y() || F() || Q() || x() || w() || aj() || q() == com.google.android.libraries.navigation.internal.adl.w.IS_DESTINATION_REFINEMENT || q() == com.google.android.libraries.navigation.internal.adl.w.FRIEND_LABEL_METADATA || G() || A();
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean ai() {
        return l() == null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean aj() {
        return q() == com.google.android.libraries.navigation.internal.adl.w.PERSONAL_PLACE_METADATA;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean ak() {
        return q() == com.google.android.libraries.navigation.internal.adl.w.PLACEMARK_METADATA;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean al() {
        return an() && !com.google.android.libraries.navigation.internal.rb.a.h(W(), 16);
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean am() {
        return (an() && com.google.android.libraries.navigation.internal.rb.a.h(W(), 2)) ? false : true;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean an() {
        return com.google.android.libraries.navigation.internal.rb.a.h(W(), 1);
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean ao() {
        return an() && !com.google.android.libraries.navigation.internal.rb.a.h(W(), 2);
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean ap() {
        return com.google.android.libraries.navigation.internal.rb.a.h(W(), 16);
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean aq() {
        return q() == com.google.android.libraries.navigation.internal.adl.w.IS_TRANSIT_VEHICLE;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ek
    public final boolean ar() {
        return q() == com.google.android.libraries.navigation.internal.adl.w.IS_VISUAL_EXPLORE_CLUSTER;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ek)) {
            return false;
        }
        ek ekVar = (ek) obj;
        return e() == ekVar.e() && o().equals(ekVar.o());
    }

    public abstract com.google.android.libraries.navigation.internal.or.c g();

    public final int hashCode() {
        int iN;
        long jE = e() ^ (e() >>> 32);
        com.google.android.libraries.navigation.internal.adg.ef efVarO = o();
        if (efVarO.H()) {
            iN = efVarO.n();
        } else {
            int iN2 = efVarO.ak;
            if (iN2 == 0) {
                iN2 = efVarO.n();
                efVarO.ak = iN2;
            }
            iN = iN2;
        }
        return (((int) jE) * 31) + iN;
    }

    public abstract em j();

    public abstract com.google.android.libraries.geo.mapcore.internal.model.av l();
}
