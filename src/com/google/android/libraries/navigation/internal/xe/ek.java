package com.google.android.libraries.navigation.internal.xe;

import android.app.Activity;
import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.TermsAndConditionsCheckOption;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ek {
    private static final com.google.android.libraries.navigation.internal.ih.a c = com.google.android.libraries.navigation.internal.ih.a.b(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.xe.eb
        @Override // com.google.android.libraries.navigation.internal.yx.br
        public final Object a() {
            return new ek(fi.b, fv.f, com.google.android.libraries.navigation.internal.vq.c.a, Executors.newSingleThreadExecutor());
        }
    });
    public final Executor a;
    private final ei e;
    private Navigator f;
    private com.google.android.libraries.navigation.environment.am g;
    private final Executor j;
    private final fq k;
    private final Object d = new Object();
    private final ArrayList h = new ArrayList();
    private final ArrayList i = new ArrayList();
    boolean b = false;

    public ek(ei eiVar, fq fqVar, Executor executor, Executor executor2) {
        this.e = eiVar;
        this.k = fqVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(executor);
        this.j = executor;
        com.google.android.libraries.navigation.internal.yx.ar.q(executor2);
        this.a = executor2;
    }

    public static ek a() {
        return (ek) c.a();
    }

    public final void b(com.google.android.libraries.navigation.environment.am amVar, dv dvVar, NavigationApi.NavigatorListener navigatorListener, TermsAndConditionsCheckOption termsAndConditionsCheckOption) {
        synchronized (this.d) {
            this.b = true;
            Navigator navigator = this.f;
            if (navigator != null) {
                this.j.execute(new ed(navigatorListener, navigator));
                return;
            }
            this.h.add(navigatorListener);
            if (this.h.size() == 1) {
                ef efVar = new ef(this, amVar);
                if (((ea) dvVar).b.x().e()) {
                    ((ea) dvVar).b(efVar);
                } else {
                    Activity activity = ((ea) dvVar).a;
                    if (activity == null) {
                        efVar.a(2);
                    } else {
                        ((ea) dvVar).c.a(activity, ((ea) dvVar).b.bw(), ((ea) dvVar).b.x(), ((ea) dvVar).b.bz(), null, null, null, new dx((ea) dvVar, efVar), termsAndConditionsCheckOption);
                    }
                }
            }
        }
    }

    public final void c(com.google.android.libraries.navigation.environment.am amVar, int i) {
        Navigator navigatorA;
        if (i == 0) {
            fl flVarA = this.k.a(amVar.bE(), this.a, Executors.newSingleThreadScheduledExecutor(), amVar.ba(), amVar.bA());
            com.google.android.libraries.navigation.internal.afm.b bVar = (com.google.android.libraries.navigation.internal.afm.b) com.google.android.libraries.navigation.internal.afm.e.a.q();
            com.google.android.libraries.navigation.internal.afm.d dVar = com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_INIT;
            if (!bVar.b.H()) {
                bVar.v();
            }
            com.google.android.libraries.navigation.internal.afm.e eVar = (com.google.android.libraries.navigation.internal.afm.e) bVar.b;
            eVar.c = dVar.k;
            eVar.b |= 1;
            ((fv) flVarA).g(bVar, 0);
            navigatorA = this.e.a(amVar, flVarA);
        } else {
            navigatorA = null;
        }
        synchronized (this.d) {
            this.f = navigatorA;
            this.g = amVar;
            if (navigatorA != null) {
                ArrayList arrayList = new ArrayList(this.i);
                this.i.clear();
                this.j.execute(new eg(arrayList, navigatorA, amVar));
            }
            ArrayList arrayList2 = new ArrayList(this.h);
            this.h.clear();
            this.j.execute(new eh(arrayList2, navigatorA, i));
        }
    }

    public final void d(ej ejVar) {
        synchronized (this.d) {
            Navigator navigator = this.f;
            com.google.android.libraries.navigation.environment.am amVar = this.g;
            if (navigator == null) {
                this.i.add(ejVar);
            } else {
                this.j.execute(new ec(ejVar, navigator, amVar));
            }
        }
    }

    public final void e(ej ejVar) {
        synchronized (this.d) {
            this.i.remove(ejVar);
        }
    }

    public final boolean f() {
        boolean z;
        synchronized (this.d) {
            z = this.b;
        }
        return z;
    }

    public final boolean g() {
        boolean z;
        synchronized (this.d) {
            z = this.f != null;
        }
        return z;
    }
}
