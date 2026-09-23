package com.google.android.libraries.navigation.internal.dp;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ v a;

    public o(v vVar) {
        this.a = vVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        if (mVar != null) {
            mVar.c();
        }
        v vVar = this.a;
        Boolean bool = (Boolean) mVar.c();
        ar.q(bool);
        boolean zBooleanValue = bool.booleanValue();
        k kVar = vVar.f407n;
        if (kVar.q == com.google.android.libraries.navigation.internal.dt.c.NAVIGATION && kVar.r != zBooleanValue) {
            kVar.r = zBooleanValue;
            if (kVar.o == null) {
                kVar.o = kVar.b();
            } else {
                kVar.o.f(kVar.a());
            }
        }
    }
}
