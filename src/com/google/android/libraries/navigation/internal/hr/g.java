package com.google.android.libraries.navigation.internal.hr;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.km.al;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements n {
    final /* synthetic */ o a;
    private com.google.android.libraries.navigation.internal.nt.t b = null;

    public g(o oVar) {
        this.a = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.hr.n
    public final synchronized void b() {
        this.b = new com.google.android.libraries.navigation.internal.nt.t() { // from class: com.google.android.libraries.navigation.internal.hr.f
            @Override // com.google.android.libraries.navigation.internal.nt.t
            public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
                g gVar = this.a;
                Locale localeC = ((com.google.android.libraries.navigation.internal.no.a) gVar.a.d.a()).c();
                synchronized (gVar.a.i) {
                    if (gVar.a.m.getLanguage().equals(localeC.getLanguage()) && gVar.a.m.getCountry().equals(localeC.getCountry())) {
                        return;
                    }
                    o oVar = gVar.a;
                    oVar.m = localeC;
                    ((com.google.android.libraries.navigation.internal.kk.j) ((com.google.android.libraries.navigation.internal.kl.a) oVar.b.a()).a(al.a)).a();
                    gVar.a.c(0L, com.google.android.libraries.navigation.internal.ir.a.LOCALE_CHANGE);
                }
            }
        };
        com.google.android.libraries.navigation.internal.nt.m mVarA = ((com.google.android.libraries.navigation.internal.no.a) this.a.d.a()).a();
        com.google.android.libraries.navigation.internal.nt.t tVar = this.b;
        ar.q(tVar);
        mVarA.g(tVar, ac.INSTANCE);
    }

    @Override // com.google.android.libraries.navigation.internal.hr.n
    public final synchronized void c() {
        if (this.b != null) {
            com.google.android.libraries.navigation.internal.nt.m mVarA = ((com.google.android.libraries.navigation.internal.no.a) this.a.d.a()).a();
            com.google.android.libraries.navigation.internal.nt.t tVar = this.b;
            ar.q(tVar);
            mVarA.h(tVar);
            this.b = null;
        }
    }
}
