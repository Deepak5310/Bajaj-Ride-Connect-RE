package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.cs;
import com.google.android.libraries.navigation.internal.adr.le;
import com.google.android.libraries.navigation.internal.adr.lj;
import com.google.android.libraries.navigation.internal.adr.lz;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class cj {
    public int m;

    public final cj A(lz lzVar) {
        return j(com.google.android.libraries.navigation.internal.hc.a.a(lzVar));
    }

    public final ck B() {
        return k();
    }

    public final void C(com.google.android.libraries.navigation.internal.adr.b bVar) {
        a(com.google.android.libraries.navigation.internal.hc.a.a(bVar));
    }

    public final void D(com.google.android.libraries.navigation.internal.adq.t tVar) {
        c(com.google.android.libraries.navigation.internal.hc.a.a(tVar));
    }

    public final void E(cs csVar) {
        d(com.google.android.libraries.navigation.internal.hc.a.a(csVar));
    }

    public final void F(com.google.android.libraries.navigation.internal.ady.ab abVar) {
        f(com.google.android.libraries.navigation.internal.hc.a.a(abVar));
    }

    public abstract cj a(com.google.android.libraries.navigation.internal.hc.a aVar);

    public abstract cj b(com.google.android.libraries.navigation.internal.hc.a aVar);

    public abstract cj c(com.google.android.libraries.navigation.internal.hc.a aVar);

    public abstract cj d(com.google.android.libraries.navigation.internal.hc.a aVar);

    public abstract cj e(ev evVar);

    public abstract cj f(com.google.android.libraries.navigation.internal.hc.a aVar);

    public abstract cj g(ev evVar);

    public abstract cj h(byte[] bArr);

    public abstract cj i(byte[] bArr);

    public abstract cj j(com.google.android.libraries.navigation.internal.hc.a aVar);

    public abstract ck k();

    public abstract void l(boolean z);

    public abstract void m(lj ljVar);

    public abstract void n(com.google.android.libraries.navigation.internal.hc.a aVar);

    public abstract void o(int i);

    public abstract void p(boolean z);

    public abstract void q(com.google.android.libraries.navigation.internal.hc.a aVar);

    @Deprecated
    public abstract void r(com.google.android.libraries.navigation.internal.adq.ar arVar);

    public abstract void s(boolean z);

    public abstract void t(int i);

    public abstract void u();

    public abstract void v(boolean z);

    public abstract void w(com.google.android.libraries.navigation.internal.hc.a aVar);

    public final cj x(le leVar) {
        return b(com.google.android.libraries.navigation.internal.hc.a.a(leVar));
    }

    public final cj y(List list) {
        return e(de.d(list).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.bp.ci
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return new com.google.android.libraries.navigation.internal.hc.a((le) obj);
            }
        }).f());
    }

    public final cj z(com.google.android.libraries.navigation.internal.ael.x xVar) {
        return i(xVar.B());
    }
}
