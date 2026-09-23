package com.google.android.libraries.navigation.internal.abh;

import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ho extends com.google.android.libraries.navigation.internal.lz.y implements fl {
    private static final TileOverlayOptions d = new TileOverlayOptions();
    private static final AtomicInteger e = new AtomicInteger(0);
    public final String a = String.format(Locale.getDefault(), "to%d", Integer.valueOf(e.getAndIncrement()));
    public hn b;
    public final TileProvider c;
    private final fm f;
    private final ht g;
    private final com.google.android.libraries.navigation.internal.abf.z h;
    private boolean i;
    private float j;
    private boolean k;
    private float l;
    private boolean m;

    public ho(TileOverlayOptions tileOverlayOptions, fm fmVar, ht htVar, com.google.android.libraries.navigation.internal.abf.z zVar) {
        this.f = fmVar;
        this.g = htVar;
        this.h = zVar;
        com.google.android.libraries.navigation.internal.abf.s.a(tileOverlayOptions.getTileProvider() != null, "TileOverlayOptions must specify a TileProvider");
        this.c = tileOverlayOptions.getTileProvider();
        this.i = tileOverlayOptions.isVisible();
        this.j = tileOverlayOptions.getZIndex();
        this.k = tileOverlayOptions.getFadeIn();
        this.l = tileOverlayOptions.getTransparency();
        this.m = false;
        boolean zIsVisible = tileOverlayOptions.isVisible();
        TileOverlayOptions tileOverlayOptions2 = d;
        if (zIsVisible != tileOverlayOptions2.isVisible()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_VISIBILITY);
        }
        if (tileOverlayOptions.getZIndex() != tileOverlayOptions2.getZIndex()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_Z_INDEX);
        }
        if (tileOverlayOptions.getFadeIn() != tileOverlayOptions2.getFadeIn()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_FADE);
        }
        if (tileOverlayOptions.getTransparency() != tileOverlayOptions2.getTransparency()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_TRANSPARENCY);
        }
    }

    private final void r(int i) {
        synchronized (this) {
            if (this.m) {
                return;
            }
            hn hnVar = this.b;
            if (hnVar != null) {
                com.google.android.libraries.navigation.internal.abm.ec ecVar = (com.google.android.libraries.navigation.internal.abm.ec) hnVar;
                ecVar.c.a();
                com.google.android.libraries.navigation.internal.po.di diVar = ecVar.f;
                if (diVar == null) {
                    return;
                }
                if (i == 0) {
                    ho hoVar = ecVar.b;
                    diVar.a.I = hoVar.p();
                } else if (i == 1) {
                    ecVar.b();
                } else if (i == 2) {
                    ecVar.a();
                } else if (ecVar.b.q()) {
                    ecVar.f.a(ecVar.b.n());
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fl
    public final void G() {
        synchronized (this) {
            if (this.m) {
                return;
            }
            this.m = true;
            hn hnVar = this.b;
            if (hnVar != null) {
                com.google.android.libraries.navigation.internal.abm.ec ecVar = (com.google.android.libraries.navigation.internal.abm.ec) hnVar;
                ecVar.c.a();
                if (ecVar.f == null) {
                    return;
                }
                com.google.android.libraries.navigation.internal.ol.aj ajVarC = ecVar.a.c();
                com.google.android.libraries.navigation.internal.po.di diVar = ecVar.f;
                if (diVar != null) {
                    ((com.google.android.libraries.navigation.internal.po.dk) ajVarC).a.n(diVar.a);
                }
                ecVar.f = null;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final synchronized float a() {
        this.h.a();
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final synchronized float b() {
        this.h.a();
        return o();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final int c() {
        return hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final String d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final void e() {
        this.h.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_CLEAR_CACHE);
        hn hnVar = this.b;
        if (hnVar != null) {
            com.google.android.libraries.navigation.internal.abm.ec ecVar = (com.google.android.libraries.navigation.internal.abm.ec) hnVar;
            ecVar.c.a();
            com.google.android.libraries.navigation.internal.po.di diVar = ecVar.f;
            if (diVar == null) {
                return;
            }
            diVar.a.v();
            diVar.b.F();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final void f() {
        this.h.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_REMOVE);
        G();
        this.f.b(this);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final void g(boolean z) {
        this.h.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_FADE);
        synchronized (this) {
            this.k = z;
        }
        r(0);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final void h(float f) {
        this.h.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_TRANSPARENCY);
        boolean z = false;
        if (f >= 0.0f && f <= 1.0f) {
            z = true;
        }
        com.google.android.libraries.navigation.internal.abf.s.a(z, "Transparency must be in the range [0..1]");
        synchronized (this) {
            this.l = f;
        }
        r(3);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final void i(boolean z) {
        this.h.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_VISIBILITY);
        synchronized (this) {
            this.i = z;
        }
        r(2);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final void j(float f) {
        this.h.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.TILE_OVERLAY_Z_INDEX);
        synchronized (this) {
            this.j = f;
        }
        r(1);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final boolean k(com.google.android.libraries.navigation.internal.lz.z zVar) {
        return equals(zVar);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final synchronized boolean l() {
        this.h.a();
        return p();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.z
    public final synchronized boolean m() {
        this.h.a();
        return q();
    }

    public final synchronized float n() {
        return 1.0f - this.l;
    }

    public final synchronized float o() {
        return this.j;
    }

    public final synchronized boolean p() {
        return this.k;
    }

    public final synchronized boolean q() {
        return this.i;
    }

    public final synchronized String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF;
        ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("id", this.a);
        return ajVarF.e("visible", this.i).b(ViewProps.Z_INDEX, this.j).e("fadeIn", this.k).toString();
    }
}
