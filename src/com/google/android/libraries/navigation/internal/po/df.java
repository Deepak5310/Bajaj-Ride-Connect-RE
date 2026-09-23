package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.ku;
import com.google.android.libraries.navigation.internal.yz.mh;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class df implements com.google.android.libraries.navigation.internal.px.bb {
    public final mh a = new com.google.android.libraries.navigation.internal.yz.ee();
    public final Set b = new HashSet();
    public final Map c = new HashMap();
    public final ku d = com.google.android.libraries.navigation.internal.yz.eg.n();

    final synchronized void a(com.google.android.libraries.navigation.internal.ol.u uVar) {
        this.b.add(uVar);
        com.google.android.libraries.navigation.internal.px.ba baVar = (com.google.android.libraries.navigation.internal.px.ba) this.c.remove(uVar);
        this.d.h(uVar);
        if (baVar != null) {
            ku kuVar = this.d;
            com.google.android.libraries.navigation.internal.ol.u uVar2 = baVar.c;
            com.google.android.libraries.navigation.internal.yx.ar.q(uVar2);
            kuVar.remove(uVar2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bb
    public final synchronized boolean b(com.google.android.libraries.navigation.internal.ol.u uVar, com.google.android.libraries.navigation.internal.px.ba baVar) {
        com.google.android.libraries.navigation.internal.px.ba baVar2 = (com.google.android.libraries.navigation.internal.px.ba) this.c.get(uVar);
        if (baVar2 == null || !this.d.contains(baVar2.c)) {
            return false;
        }
        baVar.a = baVar2.a;
        baVar.b = baVar2.b;
        baVar.c = baVar2.c;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.px.bb
    public final synchronized boolean c(com.google.android.libraries.navigation.internal.ol.u uVar) {
        return this.d.contains(uVar);
    }
}
