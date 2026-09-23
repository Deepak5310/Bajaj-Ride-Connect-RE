package com.google.android.libraries.navigation.internal.abh;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class en extends com.google.android.libraries.navigation.internal.ly.r {
    private static final em e = new em();
    private cs a;
    private final GoogleMapOptions b;
    private final be c;
    private final m d;
    private final em f;

    public en(GoogleMapOptions googleMapOptions, be beVar, m mVar) {
        em emVar = e;
        this.b = googleMapOptions == null ? new GoogleMapOptions() : googleMapOptions;
        this.c = beVar;
        com.google.android.libraries.navigation.internal.abf.s.k(mVar, "environment");
        this.d = mVar;
        com.google.android.libraries.navigation.internal.abf.s.k(emVar, "googleMapFactory");
        this.f = emVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final com.google.android.libraries.navigation.internal.lo.l a() {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(this.a.av());
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

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final void b(com.google.android.libraries.navigation.internal.ly.bb bbVar) {
        try {
            cs csVar = this.a;
            if (csVar != null) {
                try {
                    csVar.x(bbVar);
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
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

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final void c(Bundle bundle) {
        try {
            com.google.android.libraries.navigation.internal.afu.d.a.a().D();
            cs csVarA = em.a(this.b, this.c.p(), this.c, this.d);
            this.a = csVarA;
            csVarA.aG(bundle);
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

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final void d() {
        try {
            this.a.aH();
            this.a = null;
            this.c.o();
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

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final void e() {
        try {
            cs csVar = this.a;
            if (csVar == null) {
                com.google.android.libraries.navigation.internal.abf.p.f("MapView", 4);
            } else {
                csVar.aI();
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

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final void f() {
        try {
            this.a.aJ();
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

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final void g() {
        try {
            this.a.aK();
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

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final void h(Bundle bundle) {
        try {
            this.a.aL(bundle);
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

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final void i() {
        try {
            this.a.aM();
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

    @Override // com.google.android.libraries.navigation.internal.ly.s
    public final void j() {
        try {
            this.a.aN();
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
}
