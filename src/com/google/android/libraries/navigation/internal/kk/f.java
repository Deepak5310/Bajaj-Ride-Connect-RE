package com.google.android.libraries.navigation.internal.kk;

import com.google.android.libraries.navigation.internal.km.r;
import com.google.android.libraries.navigation.internal.km.s;
import com.google.android.libraries.navigation.internal.km.w;
import com.google.android.libraries.navigation.internal.km.x;
import com.google.android.libraries.navigation.internal.km.y;
import com.google.android.libraries.navigation.internal.km.z;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.kc;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.kl.b {
    private final Map a = kc.g(w.class);

    public f() {
        for (w wVar : w.values()) {
            this.a.put(wVar, new o());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.kl.a
    public final synchronized Object a(z zVar) {
        o oVar;
        oVar = (o) this.a.get(zVar.c);
        ar.q(oVar);
        return zVar.a(oVar);
    }

    @Override // com.google.android.libraries.navigation.internal.kl.a
    public final /* synthetic */ void b(r rVar, boolean z) {
        ((i) a(rVar)).a(z);
    }

    @Override // com.google.android.libraries.navigation.internal.kl.b
    public final e c() {
        return new e();
    }

    @Override // com.google.android.libraries.navigation.internal.kl.a
    public final /* synthetic */ void d(s sVar) {
        ((j) a(sVar)).b(1L);
    }

    @Override // com.google.android.libraries.navigation.internal.kl.a
    public final /* synthetic */ void e(x xVar, int i) {
        ((k) a(xVar)).b(i, 1L);
    }

    @Override // com.google.android.libraries.navigation.internal.kl.a
    public final /* synthetic */ void f(y yVar, long j) {
        ((l) a(yVar)).b(j, 1L);
    }

    @Override // com.google.android.libraries.navigation.internal.kl.a
    public final /* synthetic */ void g() {
    }

    @Override // com.google.android.libraries.navigation.internal.kl.a
    public final void h() {
    }

    @Override // com.google.android.libraries.navigation.internal.kl.a
    public final void i() {
    }

    @Override // com.google.android.libraries.navigation.internal.kl.c
    public final void j() {
    }

    @Override // com.google.android.libraries.navigation.internal.kl.b
    public final void k() {
    }

    @Override // com.google.android.libraries.navigation.internal.kl.a
    public final void l() {
    }
}
