package com.google.android.libraries.navigation.internal.aga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class du extends com.google.android.libraries.navigation.internal.afx.az {
    public final com.google.android.libraries.navigation.internal.afx.ar f;
    public com.google.android.libraries.navigation.internal.afx.r g = com.google.android.libraries.navigation.internal.afx.r.IDLE;
    private com.google.android.libraries.navigation.internal.afx.aw h;

    public du(com.google.android.libraries.navigation.internal.afx.ar arVar) {
        this.f = arVar;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final com.google.android.libraries.navigation.internal.afx.cl a(com.google.android.libraries.navigation.internal.afx.av avVar) {
        dr drVar;
        Boolean bool;
        List list = avVar.a;
        if (list.isEmpty()) {
            List list2 = avVar.a;
            com.google.android.libraries.navigation.internal.afx.cl clVarB = com.google.android.libraries.navigation.internal.afx.cl.f.b("NameResolver returned no usable address. addrs=" + String.valueOf(list2) + ", attrs=" + String.valueOf(avVar.b));
            b(clVarB);
            return clVarB;
        }
        Object obj = avVar.c;
        if ((obj instanceof dr) && (bool = (drVar = (dr) obj).a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(list);
            Long l = drVar.b;
            Collections.shuffle(arrayList, new Random());
            list = arrayList;
        }
        com.google.android.libraries.navigation.internal.afx.aw awVar = this.h;
        if (awVar == null) {
            com.google.android.libraries.navigation.internal.afx.ar arVar = this.f;
            com.google.android.libraries.navigation.internal.afx.am amVar = new com.google.android.libraries.navigation.internal.afx.am();
            amVar.c(list);
            com.google.android.libraries.navigation.internal.afx.aw awVarB = arVar.b(amVar.a());
            awVarB.d(new dq(this, awVarB));
            this.h = awVarB;
            f(com.google.android.libraries.navigation.internal.afx.r.CONNECTING, new ds(com.google.android.libraries.navigation.internal.afx.as.c(awVarB)));
            awVarB.b();
        } else {
            awVar.e(list);
        }
        return com.google.android.libraries.navigation.internal.afx.cl.b;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final void b(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        com.google.android.libraries.navigation.internal.afx.aw awVar = this.h;
        if (awVar != null) {
            awVar.c();
            this.h = null;
        }
        f(com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE, new ds(com.google.android.libraries.navigation.internal.afx.as.b(clVar)));
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final void d() {
        com.google.android.libraries.navigation.internal.afx.aw awVar = this.h;
        if (awVar != null) {
            awVar.b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final void e() {
        com.google.android.libraries.navigation.internal.afx.aw awVar = this.h;
        if (awVar != null) {
            awVar.c();
        }
    }

    public final void f(com.google.android.libraries.navigation.internal.afx.r rVar, com.google.android.libraries.navigation.internal.afx.ax axVar) {
        this.g = rVar;
        this.f.f(rVar, axVar);
    }
}
