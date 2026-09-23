package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ci implements com.google.android.libraries.navigation.internal.yx.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.oe.x a;

    public ci(com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.a = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        com.google.android.libraries.navigation.internal.px.ek ekVar = (com.google.android.libraries.navigation.internal.px.ek) obj;
        if (ekVar == null || com.google.android.libraries.navigation.internal.oe.j.g(ekVar.e()) || ekVar.ak()) {
            return false;
        }
        com.google.android.libraries.navigation.internal.oe.x xVar = cm.a;
        xVar.a = 0;
        xVar.b = 0;
        xVar.c = 0;
        com.google.android.libraries.navigation.internal.px.cg cgVarH = ekVar.h();
        if (cgVarH.h()) {
            xVar.W(((com.google.android.libraries.navigation.internal.px.m) cgVarH).a.a);
        }
        return cm.a.equals(this.a);
    }
}
