package com.google.android.libraries.navigation.internal.jw;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.zp.bh;
import com.google.android.libraries.navigation.internal.zp.bi;
import com.google.android.libraries.navigation.internal.zp.bv;
import com.google.android.libraries.navigation.internal.zp.bx;
import com.google.android.libraries.navigation.internal.zp.by;
import com.google.android.libraries.navigation.internal.zp.ca;
import com.google.android.libraries.navigation.internal.zp.cb;
import com.google.android.libraries.navigation.internal.zp.cf;
import com.google.android.libraries.navigation.internal.zp.r;
import com.google.android.libraries.navigation.internal.zp.u;
import com.google.android.libraries.navigation.internal.zp.v;
import com.google.android.libraries.navigation.internal.zt.ag;
import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    /* JADX WARN: Code duplicated, block: B:26:0x008a  */
    /* JADX WARN: Code duplicated, block: B:28:0x009a  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:43:0x0100  */
    /* JADX WARN: Code duplicated, block: B:47:0x0115  */
    /* JADX WARN: Code duplicated, block: B:50:0x0124  */
    /* JADX WARN: Code duplicated, block: B:53:0x0133  */
    /* JADX WARN: Code duplicated, block: B:58:0x0148  */
    /* JADX WARN: Code duplicated, block: B:60:0x014e  */
    /* JADX WARN: Code duplicated, block: B:61:0x015e  */
    /* JADX WARN: Code duplicated, block: B:64:0x016d  */
    /* JADX WARN: Code duplicated, block: B:66:0x017c  */
    public static by a(aa aaVar, Duration duration, int i) {
        v vVar;
        bh bhVar;
        com.google.android.libraries.navigation.internal.zp.g gVar;
        by byVar = (by) cb.a.q();
        byVar.A(bx.b, Integer.valueOf(i));
        com.google.android.libraries.navigation.internal.afd.a aVar = aaVar.k;
        if (aVar != null) {
            int iA = aVar.a();
            if (!byVar.b.H()) {
                byVar.v();
            }
            cb cbVar = (cb) byVar.b;
            cbVar.b |= 1;
            cbVar.c = iA;
        }
        u uVar = (u) v.a.q();
        String str = aaVar.f;
        boolean z = false;
        if (!aq.c(str) && !aaVar.e) {
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar2 = (v) uVar.b;
            str.getClass();
            vVar2.b = 4;
            vVar2.c = str;
            z = true;
        }
        String str2 = aaVar.d;
        if (aq.c(str2)) {
            if (!z) {
                vVar = null;
            }
            if (vVar != null) {
                gVar = (com.google.android.libraries.navigation.internal.zp.g) com.google.android.libraries.navigation.internal.zp.h.a.q();
                if (!gVar.b.H()) {
                    gVar.v();
                }
                com.google.android.libraries.navigation.internal.zp.h hVar = (com.google.android.libraries.navigation.internal.zp.h) gVar.b;
                hVar.c = vVar;
                hVar.b |= 1;
                if (!byVar.b.H()) {
                    byVar.v();
                }
                cb cbVar2 = (cb) byVar.b;
                com.google.android.libraries.navigation.internal.zp.h hVar2 = (com.google.android.libraries.navigation.internal.zp.h) gVar.t();
                hVar2.getClass();
                cbVar2.g = hVar2;
                cbVar2.b |= 512;
            }
            if (aaVar.g() != ca.VISIBILITY_VISIBLE) {
                ca caVarG = aaVar.g();
                if (!byVar.b.H()) {
                    byVar.v();
                }
                cb cbVar3 = (cb) byVar.b;
                cbVar3.f = caVarG.f;
                cbVar3.b |= 32;
            }
            if (aaVar.a() != -1) {
                int iA2 = aaVar.a();
                if (!byVar.b.H()) {
                    byVar.v();
                }
                cb cbVar4 = (cb) byVar.b;
                cbVar4.b |= 2;
                cbVar4.d = iA2;
            }
            if (aaVar.c() != null) {
                byVar.C(r.b, aaVar.c());
            }
            if (aaVar.h() != null) {
                byVar.C(ag.b, aaVar.h());
            }
            if (aaVar.f() != null) {
                byVar.C(bv.b, aaVar.f());
            }
            if (aaVar.d() == null || !duration.isZero()) {
                if (aaVar.d() != null) {
                    bi biVarD = aaVar.d();
                    bb bbVar = (bb) biVarD.aH(5, null);
                    bbVar.x(biVarD);
                    bhVar = (bh) bbVar;
                } else {
                    bhVar = (bh) bi.a.q();
                }
                if (!duration.isZero()) {
                    long millis = duration.toMillis() * 1000;
                    if (!bhVar.b.H()) {
                        bhVar.v();
                    }
                    bi biVar = (bi) bhVar.b;
                    bi biVar2 = bi.a;
                    biVar.c |= 8192;
                    biVar.f = millis;
                }
                byVar.C(bi.b, (bi) bhVar.t());
            }
            return byVar;
        }
        if (!uVar.b.H()) {
            uVar.v();
        }
        v vVar3 = (v) uVar.b;
        str2.getClass();
        vVar3.d = 5;
        vVar3.e = str2;
        vVar = (v) uVar.t();
        if (vVar != null) {
            gVar = (com.google.android.libraries.navigation.internal.zp.g) com.google.android.libraries.navigation.internal.zp.h.a.q();
            if (!gVar.b.H()) {
                gVar.v();
            }
            com.google.android.libraries.navigation.internal.zp.h hVar3 = (com.google.android.libraries.navigation.internal.zp.h) gVar.b;
            hVar3.c = vVar;
            hVar3.b |= 1;
            if (!byVar.b.H()) {
                byVar.v();
            }
            cb cbVar5 = (cb) byVar.b;
            com.google.android.libraries.navigation.internal.zp.h hVar4 = (com.google.android.libraries.navigation.internal.zp.h) gVar.t();
            hVar4.getClass();
            cbVar5.g = hVar4;
            cbVar5.b |= 512;
        }
        if (aaVar.g() != ca.VISIBILITY_VISIBLE) {
            ca caVarG2 = aaVar.g();
            if (!byVar.b.H()) {
                byVar.v();
            }
            cb cbVar6 = (cb) byVar.b;
            cbVar6.f = caVarG2.f;
            cbVar6.b |= 32;
        }
        if (aaVar.a() != -1) {
            int iA3 = aaVar.a();
            if (!byVar.b.H()) {
                byVar.v();
            }
            cb cbVar7 = (cb) byVar.b;
            cbVar7.b |= 2;
            cbVar7.d = iA3;
        }
        if (aaVar.c() != null) {
            byVar.C(r.b, aaVar.c());
        }
        if (aaVar.h() != null) {
            byVar.C(ag.b, aaVar.h());
        }
        if (aaVar.f() != null) {
            byVar.C(bv.b, aaVar.f());
        }
        if (aaVar.d() == null) {
            if (aaVar.d() != null) {
                bi biVarD2 = aaVar.d();
                bb bbVar2 = (bb) biVarD2.aH(5, null);
                bbVar2.x(biVarD2);
                bhVar = (bh) bbVar2;
            } else {
                bhVar = (bh) bi.a.q();
            }
            if (!duration.isZero()) {
                long millis2 = duration.toMillis() * 1000;
                if (!bhVar.b.H()) {
                    bhVar.v();
                }
                bi biVar3 = (bi) bhVar.b;
                bi biVar4 = bi.a;
                biVar3.c |= 8192;
                biVar3.f = millis2;
            }
            byVar.C(bi.b, (bi) bhVar.t());
        } else {
            if (aaVar.d() != null) {
                bi biVarD3 = aaVar.d();
                bb bbVar3 = (bb) biVarD3.aH(5, null);
                bbVar3.x(biVarD3);
                bhVar = (bh) bbVar3;
            } else {
                bhVar = (bh) bi.a.q();
            }
            if (!duration.isZero()) {
                long millis3 = duration.toMillis() * 1000;
                if (!bhVar.b.H()) {
                    bhVar.v();
                }
                bi biVar5 = (bi) bhVar.b;
                bi biVar6 = bi.a;
                biVar5.c |= 8192;
                biVar5.f = millis3;
            }
            byVar.C(bi.b, (bi) bhVar.t());
        }
        return byVar;
    }

    public static cb b(cf cfVar) {
        by byVar = (by) cb.a.q();
        int iA = cfVar.a();
        if (!byVar.b.H()) {
            byVar.v();
        }
        cb cbVar = (cb) byVar.b;
        cbVar.b |= 1;
        cbVar.c = iA;
        return (cb) byVar.t();
    }
}
