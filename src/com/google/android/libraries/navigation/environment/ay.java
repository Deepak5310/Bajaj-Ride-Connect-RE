package com.google.android.libraries.navigation.environment;

import android.app.Application;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.google.android.libraries.navigation.internal.zr.ds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ay implements com.google.android.libraries.navigation.internal.ru.d {
    public final Application a;

    public ay(Application application) {
        this.a = application;
    }

    public static com.google.android.libraries.navigation.internal.zt.i a(am amVar, boolean z) {
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
        int i3 = com.google.android.libraries.navigation.internal.zt.m.g;
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
        if (amVar.ar().G() != null) {
            com.google.android.libraries.navigation.internal.ael.bq bqVar = amVar.ar().G().h;
            if (!iVar.b.H()) {
                iVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.q qVar3 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
            com.google.android.libraries.navigation.internal.ael.bq bqVar2 = qVar3.h;
            if (!bqVar2.c()) {
                qVar3.h = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar2);
            }
            com.google.android.libraries.navigation.internal.ael.b.m(bqVar, qVar3.h);
            com.google.android.libraries.navigation.internal.zr.u uVar = amVar.ar().G().f309n;
            if (uVar == null) {
                uVar = com.google.android.libraries.navigation.internal.zr.u.a;
            }
            if (!iVar.b.H()) {
                iVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.q qVar4 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
            uVar.getClass();
            qVar4.f = uVar;
            qVar4.c |= 2097152;
        }
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.q.b((com.google.android.libraries.navigation.internal.zt.q) iVar.b);
        m mVar = (m) amVar;
        String packageName = mVar.a.getPackageName();
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.q qVar5 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
        packageName.getClass();
        qVar5.d |= 4096;
        qVar5.f681n = packageName;
        com.google.android.libraries.navigation.internal.in.b bVar = (com.google.android.libraries.navigation.internal.in.b) mVar.u.a();
        if (bVar != null) {
            ds dsVar = z ? bVar.b : bVar.a;
            if (dsVar != null && !dsVar.b.isEmpty()) {
                if (!iVar.b.H()) {
                    iVar.v();
                }
                com.google.android.libraries.navigation.internal.zt.q qVar6 = (com.google.android.libraries.navigation.internal.zt.q) iVar.b;
                qVar6.k = dsVar;
                qVar6.c |= PropertyOptions.DELETE_EXISTING;
            }
        }
        return iVar;
    }
}
