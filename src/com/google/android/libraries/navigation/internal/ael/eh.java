package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eh extends ef {
    static final eg t(Object obj) {
        return ((bi) obj).an;
    }

    static final void u(Object obj, eg egVar) {
        ((bi) obj).an = egVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* synthetic */ int a(Object obj) {
        return ((eg) obj).a();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* synthetic */ int b(Object obj) {
        eg egVar = (eg) obj;
        int i = egVar.e;
        if (i != -1) {
            return i;
        }
        int iV = 0;
        for (int i2 = 0; i2 < egVar.b; i2++) {
            int iA = eu.a(egVar.c[i2]);
            x xVar = (x) egVar.d[i2];
            int iU = ai.U(1);
            iV += iU + iU + ai.V(2, iA) + ai.B(3, xVar);
        }
        egVar.e = iV;
        return iV;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* bridge */ /* synthetic */ Object c(Object obj) {
        eg egVarT = t(obj);
        if (egVarT != eg.a) {
            return egVarT;
        }
        eg egVar = new eg();
        u(obj, egVar);
        return egVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* bridge */ /* synthetic */ Object d(Object obj) {
        return t(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        if (eg.a.equals(obj2)) {
            return obj;
        }
        if (eg.a.equals(obj)) {
            eg egVar = (eg) obj;
            eg egVar2 = (eg) obj2;
            int i = egVar.b + egVar2.b;
            int[] iArrCopyOf = Arrays.copyOf(egVar.c, i);
            System.arraycopy(egVar2.c, 0, iArrCopyOf, egVar.b, egVar2.b);
            Object[] objArrCopyOf = Arrays.copyOf(egVar.d, i);
            System.arraycopy(egVar2.d, 0, objArrCopyOf, egVar.b, egVar2.b);
            return new eg(i, iArrCopyOf, objArrCopyOf, true);
        }
        eg egVar3 = (eg) obj2;
        if (egVar3.equals(eg.a)) {
            return obj;
        }
        eg egVar4 = (eg) obj;
        egVar4.b();
        int i2 = egVar4.b + egVar3.b;
        egVar4.c(i2);
        System.arraycopy(egVar3.c, 0, egVar4.c, egVar4.b, egVar3.b);
        System.arraycopy(egVar3.d, 0, egVar4.d, egVar4.b, egVar3.b);
        egVar4.b = i2;
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* synthetic */ Object f() {
        return new eg();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* synthetic */ Object g(Object obj) {
        ((eg) obj).d();
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* bridge */ /* synthetic */ void h(Object obj, int i, int i2) {
        ((eg) obj).e(eu.c(i, 5), Integer.valueOf(i2));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* bridge */ /* synthetic */ void i(Object obj, int i, long j) {
        ((eg) obj).e(eu.c(i, 1), Long.valueOf(j));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* bridge */ /* synthetic */ void j(Object obj, int i, Object obj2) {
        ((eg) obj).e(eu.c(i, 3), obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* bridge */ /* synthetic */ void k(Object obj, int i, x xVar) {
        ((eg) obj).e(eu.c(i, 2), xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* bridge */ /* synthetic */ void l(Object obj, int i, long j) {
        ((eg) obj).e(eu.c(i, 0), Long.valueOf(j));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final void m(Object obj) {
        t(obj).d();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* synthetic */ void n(Object obj, Object obj2) {
        u(obj, (eg) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* bridge */ /* synthetic */ void o(Object obj, Object obj2) {
        u(obj, (eg) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* synthetic */ void p(Object obj, ev evVar) throws IOException {
        int i = 0;
        while (true) {
            eg egVar = (eg) obj;
            if (i >= egVar.b) {
                return;
            }
            evVar.m(eu.a(egVar.c[i]), egVar.d[i]);
            i++;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final /* synthetic */ void q(Object obj, ev evVar) throws IOException {
        ((eg) obj).f(evVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ef
    public final void s() {
    }
}
