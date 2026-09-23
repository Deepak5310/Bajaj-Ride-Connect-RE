package com.google.android.libraries.navigation.internal.tc;

import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements com.google.android.libraries.navigation.internal.nt.t {
    final j a;
    final i b;

    public h(j jVar, i iVar) {
        this.a = jVar;
        this.b = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        ap.NAVIGATION_INTERNAL.f();
        Boolean bool = (Boolean) mVar.c();
        ar.q(bool);
        if (!bool.booleanValue()) {
            this.a.g(true);
            this.a.e();
        } else {
            j jVar = this.a;
            if (jVar.d == null) {
                jVar.f(this.b);
            }
            this.a.a(this.b);
        }
    }
}
