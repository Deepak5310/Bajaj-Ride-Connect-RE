package com.google.android.libraries.navigation.internal.wb;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        Boolean bool = (Boolean) mVar.c();
        ar.q(bool);
        boolean zBooleanValue = bool.booleanValue();
        d dVar = this.a;
        if (zBooleanValue != dVar.h) {
            dVar.h = zBooleanValue;
            dVar.a();
        }
    }
}
