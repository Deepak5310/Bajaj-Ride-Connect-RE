package com.google.android.libraries.navigation.internal.abh;

import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hh extends com.google.android.libraries.navigation.internal.ly.cm {
    private static final hg g = new Object() { // from class: com.google.android.libraries.navigation.internal.abh.hg
    };
    private hc a;
    private final StreetViewPanoramaOptions b;
    private final be c;
    private final m d;
    private final int e;
    private boolean f;
    private final hg h;

    public hh(StreetViewPanoramaOptions streetViewPanoramaOptions, be beVar, m mVar) {
        hg hgVar = g;
        int i = Build.VERSION.SDK_INT;
        this.b = streetViewPanoramaOptions == null ? new StreetViewPanoramaOptions() : streetViewPanoramaOptions;
        this.c = beVar;
        this.d = mVar;
        this.h = hgVar;
        this.e = i;
        this.f = false;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cn
    public final com.google.android.libraries.navigation.internal.lo.l a() {
        return new com.google.android.libraries.navigation.internal.lo.n(this.a.w());
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cn
    public final void b(com.google.android.libraries.navigation.internal.ly.cd cdVar) {
        hc hcVar = this.a;
        if (hcVar != null) {
            hcVar.x(cdVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cn
    public final void c(Bundle bundle) {
        this.c.p();
        hc hcVarG = hc.G(this.b, this.c, this.d);
        this.a = hcVarG;
        hcVarG.z(bundle);
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cn
    public final void d() {
        this.a.A();
        this.c.o();
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cn
    public final void e() {
        if (this.f) {
            return;
        }
        this.a.B();
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cn
    public final void f() {
        if (this.f) {
            return;
        }
        this.a.C();
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cn
    public final void g(Bundle bundle) {
        this.a.D(bundle);
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cn
    public final void h() {
        if (this.e > 23) {
            this.f = true;
            this.a.C();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cn
    public final void i() {
        if (this.f) {
            this.f = false;
            this.a.B();
        }
    }
}
