package com.google.android.libraries.navigation.internal.abh;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dy extends com.google.android.libraries.navigation.internal.ly.p {
    private cs a;
    private GoogleMapOptions b;
    private final List c = new ArrayList();
    private final be d;
    private final dx e;

    public dy(dx dxVar, be beVar) {
        this.e = dxVar;
        this.d = beVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void a(com.google.android.libraries.navigation.internal.ly.bb bbVar) {
        try {
            cs csVar = this.a;
            if (csVar == null) {
                this.c.add(bbVar);
                return;
            }
            try {
                csVar.x(bbVar);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void b() {
        try {
            cs csVar = this.a;
            if (csVar != null) {
                csVar.aF();
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void c(Bundle bundle) {
        try {
            if (this.b == null) {
                this.b = (GoogleMapOptions) com.google.android.libraries.navigation.internal.ly.cq.c(bundle, "MapOptions");
            }
            if (this.b == null) {
                this.b = new GoogleMapOptions();
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void d() {
        try {
            cs csVar = this.a;
            if (csVar != null) {
                csVar.aH();
                this.a = null;
            }
            this.b = null;
            this.d.o();
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void e() {
        try {
            if (this.a.bc()) {
                this.a.aH();
                this.a = null;
                this.d.o();
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void f() {
        try {
            if (com.google.android.libraries.navigation.internal.afu.d.k()) {
                com.google.android.libraries.navigation.internal.abf.t.b(this.a != null, "Map is not ready to invoke map.onPause()");
            }
            this.a.aI();
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void g() {
        try {
            if (com.google.android.libraries.navigation.internal.afu.d.k()) {
                com.google.android.libraries.navigation.internal.abf.t.b(this.a != null, "Map is not ready to invoke map.onPause()");
            }
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void h() {
        try {
            if (com.google.android.libraries.navigation.internal.afu.d.k()) {
                com.google.android.libraries.navigation.internal.abf.t.b(this.a != null, "Map is not ready to invoke map.onResume()");
            }
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void i(Bundle bundle) {
        try {
            GoogleMapOptions googleMapOptions = this.b;
            if (googleMapOptions != null) {
                com.google.android.libraries.navigation.internal.ly.cq.f(bundle, "MapOptions", googleMapOptions);
            }
            cs csVar = this.a;
            if (csVar != null) {
                csVar.aL(bundle);
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void j() {
        try {
            if (com.google.android.libraries.navigation.internal.afu.d.k()) {
                com.google.android.libraries.navigation.internal.abf.t.b(this.a != null, "Map is not ready to invoke map.onStart()");
            }
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void k() {
        try {
            if (com.google.android.libraries.navigation.internal.afu.d.k()) {
                com.google.android.libraries.navigation.internal.abf.t.b(this.a != null, "Map is not ready to invoke map.onStop()");
            }
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final void m(GoogleMapOptions googleMapOptions) {
        try {
            this.b = googleMapOptions;
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

    @Override // com.google.android.libraries.navigation.internal.ly.q
    public final com.google.android.libraries.navigation.internal.lo.l l(com.google.android.libraries.navigation.internal.lo.l lVar, Bundle bundle) {
        View viewAv;
        try {
            cs csVar = this.a;
            if (csVar == null) {
                cs csVarA = this.e.a(this.b);
                this.a = csVarA;
                csVarA.aG(bundle);
                viewAv = this.a.av();
                Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    try {
                        this.a.x((com.google.android.libraries.navigation.internal.ly.bb) it2.next());
                    } catch (RemoteException e) {
                        throw new RuntimeRemoteException(e);
                    }
                }
                this.c.clear();
            } else {
                viewAv = csVar.av();
                ViewGroup viewGroup = (ViewGroup) viewAv.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(viewAv);
                }
            }
            return new com.google.android.libraries.navigation.internal.lo.n(viewAv);
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
