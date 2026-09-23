package com.google.android.libraries.navigation.internal.hq;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.afl.dx;
import com.google.android.libraries.navigation.internal.afl.dz;
import com.google.android.libraries.navigation.internal.afl.ea;
import com.google.android.libraries.navigation.internal.zr.u;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class c implements Function {
    public static final com.google.android.libraries.navigation.internal.nk.p a(ea eaVar) {
        com.google.android.libraries.navigation.internal.nk.k kVar = (com.google.android.libraries.navigation.internal.nk.k) com.google.android.libraries.navigation.internal.nk.p.a.q();
        bq bqVar = eaVar.h;
        if (!kVar.b.H()) {
            kVar.v();
        }
        com.google.android.libraries.navigation.internal.nk.p pVar = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
        bq bqVar2 = pVar.c;
        if (!bqVar2.c()) {
            pVar.c = bi.w(bqVar2);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(bqVar, pVar.c);
        if ((eaVar.c & 4194304) != 0) {
            int i = eaVar.m;
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar2 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar2.b |= 1;
            pVar2.d = i;
        }
        bq bqVar3 = eaVar.j;
        if (!kVar.b.H()) {
            kVar.v();
        }
        com.google.android.libraries.navigation.internal.nk.p pVar3 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
        bq bqVar4 = pVar3.e;
        if (!bqVar4.c()) {
            pVar3.e = bi.w(bqVar4);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(bqVar3, pVar3.e);
        if ((eaVar.c & Integer.MIN_VALUE) != 0) {
            u uVar = eaVar.f309n;
            if (uVar == null) {
                uVar = u.a;
            }
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar4 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            uVar.getClass();
            pVar4.f = uVar;
            pVar4.b |= 2;
        }
        if ((eaVar.e & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0) {
            boolean z = eaVar.v;
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar5 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar5.b |= 4;
            pVar5.g = z;
        }
        if ((eaVar.e & 16384) != 0) {
            boolean z2 = eaVar.t;
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar6 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar6.b |= 8;
            pVar6.h = z2;
        }
        if ((eaVar.e & 32768) != 0) {
            Function function = l.a;
            dx dxVarB = dx.b(eaVar.u);
            if (dxVarB == null) {
                dxVarB = dx.UNKNOWN_UE3_REPORTER_FLUSH_STRATEGY;
            }
            com.google.android.libraries.navigation.internal.nk.m mVar = (com.google.android.libraries.navigation.internal.nk.m) function.apply(dxVarB);
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar7 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar7.i = mVar.e;
            pVar7.b |= 16;
        }
        if ((eaVar.d & 2) != 0) {
            boolean z3 = eaVar.o;
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar8 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar8.b |= 32;
            pVar8.j = z3;
        }
        if ((eaVar.d & 256) != 0) {
            boolean z4 = eaVar.p;
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar9 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar9.b |= 64;
            pVar9.k = z4;
        }
        if ((eaVar.b & 262144) != 0) {
            Function function2 = l.b;
            dz dzVarB = dz.b(eaVar.i);
            if (dzVarB == null) {
                dzVarB = dz.GMM_SERVER_ONLY;
            }
            com.google.android.libraries.navigation.internal.nk.o oVar = (com.google.android.libraries.navigation.internal.nk.o) function2.apply(dzVarB);
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar10 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar10.l = oVar.f;
            pVar10.b |= 128;
        }
        if ((eaVar.b & 8) != 0) {
            int i2 = eaVar.g;
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar11 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar11.b |= 256;
            pVar11.m = i2;
        }
        if ((eaVar.b & 4) != 0) {
            int i3 = eaVar.f;
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar12 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar12.b |= 512;
            pVar12.f490n = i3;
        }
        if ((eaVar.c & 32768) != 0) {
            int i4 = eaVar.k;
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.p pVar13 = (com.google.android.libraries.navigation.internal.nk.p) kVar.b;
            pVar13.b |= 1024;
            pVar13.o = i4;
        }
        return (com.google.android.libraries.navigation.internal.nk.p) kVar.t();
    }

    @Override // java.util.function.Function
    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        throw null;
    }
}
