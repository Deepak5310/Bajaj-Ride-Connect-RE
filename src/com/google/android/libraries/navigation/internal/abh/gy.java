package com.google.android.libraries.navigation.internal.abh;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gy extends com.google.android.libraries.navigation.internal.ly.ck {
    private static final String a = "gy";
    private hc b;
    private StreetViewPanoramaOptions c;
    private final be e;
    private final int f;
    private final gx h;
    private final List d = new ArrayList();
    private boolean g = false;

    public gy(gx gxVar, be beVar, int i) {
        this.h = gxVar;
        this.e = beVar;
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void a(com.google.android.libraries.navigation.internal.ly.cd cdVar) {
        try {
            hc hcVar = this.b;
            if (hcVar != null) {
                hcVar.x(cdVar);
            } else {
                this.d.add(cdVar);
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void b(Bundle bundle) {
        try {
            if (this.c == null) {
                this.c = (StreetViewPanoramaOptions) com.google.android.libraries.navigation.internal.ly.cq.c(bundle, "StreetViewPanoramaOptions");
            }
            if (this.c == null) {
                this.c = new StreetViewPanoramaOptions();
            }
            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void c() {
        try {
            hc hcVar = this.b;
            if (hcVar != null) {
                hcVar.A();
                this.b = null;
            }
            this.c = null;
            this.e.o();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void e() {
        try {
            if (this.g) {
                return;
            }
            this.b.B();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void f() {
        try {
            if (this.g) {
                return;
            }
            this.b.C();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void g(Bundle bundle) {
        try {
            StreetViewPanoramaOptions streetViewPanoramaOptions = this.c;
            if (streetViewPanoramaOptions != null) {
                com.google.android.libraries.navigation.internal.ly.cq.f(bundle, "StreetViewPanoramaOptions", streetViewPanoramaOptions);
            }
            hc hcVar = this.b;
            if (hcVar != null) {
                hcVar.D(bundle);
            }
            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void h() {
        try {
            if (this.f > 23) {
                this.g = true;
                this.b.C();
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void i() {
        try {
            if (this.g) {
                this.g = false;
                this.b.B();
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void k() {
        try {
            this.c = null;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final void d() {
        try {
            hc hcVar = this.b;
            try {
                if (hcVar.g) {
                    hcVar.A();
                    this.b = null;
                    this.e.o();
                }
            } catch (Throwable th) {
                bi.a(th);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof Error)) {
                    throw new RuntimeException(th);
                }
                throw ((Error) th);
            }
        } catch (Throwable th2) {
            bi.a(th2);
            if (th2 instanceof RuntimeException) {
                throw ((RuntimeException) th2);
            }
            if (!(th2 instanceof Error)) {
                throw new RuntimeException(th2);
            }
            throw ((Error) th2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cl
    public final com.google.android.libraries.navigation.internal.lo.l j(com.google.android.libraries.navigation.internal.lo.l lVar, Bundle bundle) {
        View viewW;
        try {
            hc hcVar = this.b;
            if (hcVar == null) {
                hc hcVarA = this.h.a(this.c);
                this.b = hcVarA;
                hcVarA.z(bundle);
                viewW = this.b.w();
                Iterator it2 = this.d.iterator();
                while (it2.hasNext()) {
                    this.b.x((com.google.android.libraries.navigation.internal.ly.cd) it2.next());
                }
                this.d.clear();
            } else {
                viewW = hcVar.w();
                ViewGroup viewGroup = (ViewGroup) viewW.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(viewW);
                }
            }
            return new com.google.android.libraries.navigation.internal.lo.n(viewW);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }
}
