package com.google.android.libraries.navigation.internal.abh;

import com.adobe.internal.xmp.options.PropertyOptions;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bx {
    static com.google.android.libraries.navigation.internal.zt.q a(gu guVar, String str) {
        return b(guVar, null, str);
    }

    static com.google.android.libraries.navigation.internal.zt.q b(gu guVar, com.google.android.libraries.navigation.internal.zr.ds dsVar, String str) {
        return (com.google.android.libraries.navigation.internal.zt.q) c(guVar, dsVar, str).t();
    }

    static com.google.android.libraries.navigation.internal.zt.i c(gu guVar, com.google.android.libraries.navigation.internal.zr.ds dsVar, String str) {
        com.google.android.libraries.navigation.internal.zt.i iVar = (com.google.android.libraries.navigation.internal.zt.i) com.google.android.libraries.navigation.internal.zt.q.a.q();
        int i = com.google.android.libraries.navigation.internal.zt.k.b;
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.q qVar = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        qVar.e = i2;
        qVar.b |= 32;
        int i3 = com.google.android.libraries.navigation.internal.zt.m.k;
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.q qVar2 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        qVar2.g = i4;
        qVar2.c |= 8388608;
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.q.c((com.google.android.libraries.navigation.internal.zt.q) iVar.b);
        if (guVar.k != null) {
            com.google.android.libraries.navigation.internal.zr.u uVar = guVar.k.f309n;
            if (uVar == null) {
                uVar = com.google.android.libraries.navigation.internal.zr.u.a;
            }
            if (!iVar.b.H()) {
                iVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.q qVar3 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
            uVar.getClass();
            qVar3.f = uVar;
            qVar3.c |= 2097152;
        }
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.q.b((com.google.android.libraries.navigation.internal.zt.q) iVar.b);
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.q qVar4 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
        qVar4.d |= 8;
        qVar4.l = true;
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.q qVar5 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
        qVar5.d |= 32;
        qVar5.m = 0;
        if (dsVar != null && !dsVar.b.isEmpty()) {
            com.google.android.libraries.navigation.internal.abf.p.f("DataRequestDispatcher", 3);
            if (!iVar.b.H()) {
                iVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.q qVar6 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
            qVar6.k = dsVar;
            qVar6.c |= PropertyOptions.DELETE_EXISTING;
        }
        if (com.google.android.libraries.navigation.internal.afu.d.a.a().g()) {
            if (!iVar.b.H()) {
                iVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.q qVar7 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
            str.getClass();
            qVar7.d |= 4096;
            qVar7.f681n = str;
        }
        return iVar;
    }
}
