package com.google.android.libraries.navigation.internal.xe;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.libraries.navigation.NavigationView;
import com.google.android.libraries.navigation.OnNavigationUiChangedListener;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalStateException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dn {
    public final com.google.android.libraries.navigation.internal.nn.b a = new com.google.android.libraries.navigation.internal.nn.b();
    public boolean b;
    public boolean c;
    public Boolean d;
    public volatile boolean e;
    private final dm f;

    public dn(dm dmVar) {
        this.f = dmVar;
    }

    public final void b(final boolean z, boolean z2) {
        com.google.android.libraries.navigation.internal.ms.cq cqVar;
        com.google.android.libraries.navigation.internal.ms.cq cqVar2;
        if (z != this.e || z2) {
            this.e = z;
            NavigationView navigationView = (NavigationView) ((com.google.android.libraries.navigation.as) this.f).a.get();
            if (navigationView != null) {
                if (z) {
                    v vVar = navigationView.b;
                    if (vVar != null) {
                        if (com.google.android.libraries.navigation.internal.afw.g.c()) {
                            if (vVar.c.getParent() == vVar.a) {
                                vVar.c.setVisibility(8);
                            }
                            if (vVar.b.getParent() == vVar.a) {
                                vVar.b.setVisibility(8);
                            }
                        } else {
                            vVar.a.removeView(vVar.c);
                            vVar.a.removeView(vVar.b);
                        }
                    }
                    bp bpVar = navigationView.a;
                    if (bpVar != null && (cqVar2 = bpVar.o) != null) {
                        View viewA = cqVar2.a();
                        if (viewA.getParent() == null) {
                            ds dsVar = bpVar.l;
                            if (dsVar != null) {
                                bpVar.f(dsVar);
                            }
                            bpVar.c.addView(viewA);
                        }
                        viewA.setVisibility(0);
                    }
                } else {
                    bp bpVar2 = navigationView.a;
                    if (bpVar2 != null && (cqVar = bpVar2.o) != null && cqVar.a().getParent() != null) {
                        View viewA2 = bpVar2.o.a();
                        viewA2.setVisibility(8);
                        if (!com.google.android.libraries.navigation.internal.afw.g.a.a().b()) {
                            bpVar2.o.e();
                            bpVar2.c.removeView(viewA2);
                        }
                    }
                    v vVar2 = navigationView.b;
                    if (vVar2 != null) {
                        if (vVar2.c.getParent() != vVar2.a) {
                            if (vVar2.c.getParent() != null) {
                                ((ViewGroup) vVar2.c.getParent()).removeView(vVar2.c);
                            }
                            vVar2.a.addView(vVar2.c);
                        } else if (com.google.android.libraries.navigation.internal.afw.g.c()) {
                            vVar2.c.setVisibility(0);
                        }
                        if (vVar2.b.getParent() != vVar2.a) {
                            if (vVar2.b.getParent() != null) {
                                ((ViewGroup) vVar2.b.getParent()).removeView(vVar2.b);
                            }
                            vVar2.a.addView(vVar2.b);
                        }
                        if (com.google.android.libraries.navigation.internal.afw.g.c()) {
                            vVar2.b.setVisibility(0);
                        }
                    }
                }
                if (navigationView.j != null) {
                    com.google.android.libraries.navigation.internal.ec.c cVarAq = navigationView.c.aq();
                    cVarAq.h = z;
                    cVarAq.b();
                }
                com.google.android.libraries.navigation.internal.vu.r rVar = navigationView.f;
                if (rVar != null) {
                    com.google.android.libraries.navigation.internal.oi.a aVar = rVar.j;
                    com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
                    aVar.v(z);
                }
                ak akVar = navigationView.h;
                if (akVar != null && akVar.c.h()) {
                    if (z) {
                        com.google.android.libraries.navigation.internal.abh.fe feVar = akVar.d;
                        if (!feVar.j()) {
                            throw new ApiIllegalStateException("Custom location source is not allowed during follow mode. Please call setLocationSource(null) to unset it.");
                        }
                        feVar.e(true);
                        com.google.android.libraries.navigation.internal.afl.fd fdVar = akVar.a;
                        if (fdVar != null) {
                            akVar.c.f(fdVar, akVar.b);
                            akVar.a = null;
                            akVar.b = null;
                        } else {
                            akVar.c.e();
                        }
                    } else {
                        akVar.d.e(false);
                        akVar.c.a();
                    }
                }
                w wVar = navigationView.e;
                if (wVar != null) {
                    wVar.a(z);
                }
            }
            this.a.d(new com.google.android.libraries.navigation.internal.yx.ax() { // from class: com.google.android.libraries.navigation.internal.xe.dl
                @Override // com.google.android.libraries.navigation.internal.yx.ax
                public final void a(Object obj) {
                    ((OnNavigationUiChangedListener) obj).onNavigationUiChanged(z);
                }
            });
        }
    }

    public final void a(boolean z) {
        if (!this.b || (z && !this.c)) {
            this.d = Boolean.valueOf(z);
        } else {
            this.d = null;
            b(z, false);
        }
    }
}
