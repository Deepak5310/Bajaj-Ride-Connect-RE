package com.google.android.libraries.geo.mapcore.internal.store.diskcache;

import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.internal.model.t;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.dm.s;
import com.google.android.libraries.navigation.internal.km.p;
import com.google.android.libraries.navigation.internal.oe.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.google.android.libraries.navigation.internal.qv.d {
    private final an a;
    private final com.google.android.libraries.navigation.internal.kl.b b;
    private final com.google.android.libraries.navigation.internal.ey.b c;

    public a(ap apVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.ey.b bVar2) {
        this.a = apVar.c;
        this.b = bVar;
        this.c = bVar2;
        cg cgVar = cg.s;
    }

    private final synchronized void c(cd cdVar) {
        if (this.c == null) {
            return;
        }
        try {
            int i = cdVar.b;
            int i2 = cdVar.c;
            int i3 = cdVar.a;
        } catch (com.google.android.apps.gmm.jni.util.c e) {
            e.getMessage();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final s a(cd cdVar) {
        c(cdVar);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final cc b(cd cdVar) {
        c(cdVar);
        if (!this.a.equals(an.GMM_VECTOR_BASE)) {
            return null;
        }
        ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(p.ai)).a(this.a.ah);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void e(cd cdVar, cc ccVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void f(cd cdVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void g(s sVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final boolean h(cd cdVar) {
        c(cdVar);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final boolean j(cc ccVar) {
        return ccVar instanceof t;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final /* synthetic */ boolean k() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final boolean l() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final byte[] m(cd cdVar) {
        c(cdVar);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void n(cd cdVar, String str, String str2, int i, int i2) {
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void o(s sVar, byte[] bArr, com.google.android.libraries.navigation.internal.mj.a aVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void t() {
    }
}
