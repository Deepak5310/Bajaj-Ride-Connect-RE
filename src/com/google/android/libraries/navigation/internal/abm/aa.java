package com.google.android.libraries.navigation.internal.abm;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.po.fk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa implements com.google.android.libraries.geo.mapcore.renderer.cb {
    private final com.google.android.libraries.navigation.internal.abh.ec a;
    private com.google.android.libraries.navigation.internal.oa.k b;
    private com.google.android.libraries.navigation.internal.abn.z c;
    private com.google.android.libraries.navigation.internal.abn.bl d;
    private com.google.android.libraries.navigation.internal.abh.bv e;
    private com.google.android.libraries.navigation.internal.ly.bt f;

    public aa(com.google.android.libraries.navigation.internal.abh.ec ecVar) {
        this.a = ecVar;
        synchronized (this) {
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00bb  */
    @Override // com.google.android.libraries.geo.mapcore.renderer.cb
    public final synchronized void a() {
        boolean z;
        com.google.android.libraries.navigation.internal.ly.bt btVar;
        com.google.android.libraries.navigation.internal.oa.k kVar;
        char c;
        com.google.android.libraries.navigation.internal.abh.bv bvVar = this.e;
        boolean z2 = true;
        if (bvVar == null || (!(bvVar.b() || this.e.d.f) || (kVar = this.b) == null)) {
            com.google.android.libraries.navigation.internal.afu.d.a.a().E();
            com.google.android.libraries.navigation.internal.oa.k kVar2 = this.b;
            if (kVar2 != null) {
                com.google.android.libraries.navigation.internal.oa.e eVarB = kVar2.b();
                if (((fk) eVarB).V && !((fk) eVarB).l.g() && ((fk) eVarB).U.v() && !((fk) eVarB).B.y() && ((fk) eVarB).m.w()) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            com.google.android.libraries.navigation.internal.abn.z zVar = this.c;
            boolean z3 = zVar != null && zVar.e();
            if (!z || !z3) {
                z2 = false;
            }
        } else {
            com.google.android.libraries.navigation.internal.oa.e eVarB2 = kVar.b();
            if (!((fk) eVarB2).V) {
                c = 2;
            } else if (((fk) eVarB2).l.g()) {
                c = 3;
            } else if (!((fk) eVarB2).U.v()) {
                c = 4;
            } else if (((fk) eVarB2).m.w()) {
                c = ((fk) eVarB2).B.y() ? (char) 6 : (char) 1;
            } else {
                c = 5;
            }
            if (c != 1 && c != 6 && c != 5) {
                z2 = false;
            }
        }
        this.a.b(z2);
        synchronized (this) {
            btVar = this.f;
        }
        if (btVar != null) {
            try {
                btVar.a();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.cb
    public final void b() {
        synchronized (this) {
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.cb
    public final void c() {
        this.a.b(false);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.cb
    public final void d() {
        final com.google.android.libraries.navigation.internal.abn.bl blVar;
        synchronized (this) {
            blVar = this.d;
        }
        if (blVar != null) {
            blVar.g.b();
            if (!com.google.android.libraries.navigation.internal.afu.d.j()) {
                blVar.d.s();
            }
            blVar.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abn.bg
                @Override // java.lang.Runnable
                public final void run() {
                    bl blVar2 = blVar;
                    blVar2.g.a();
                    View viewA = blVar2.a.a();
                    if (com.google.android.libraries.navigation.internal.afu.d.j()) {
                        blVar2.e.w(viewA.getWidth(), viewA.getHeight());
                        blVar2.e.s();
                    } else {
                        blVar2.c.w(viewA.getWidth(), viewA.getHeight());
                        blVar2.c.s();
                    }
                }
            });
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.cb
    public final void e() {
    }

    public final synchronized void f(com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.abn.z zVar, com.google.android.libraries.navigation.internal.abn.bl blVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(kVar, "mapContainer");
        this.b = kVar;
        this.c = zVar;
        this.d = blVar;
    }

    public final synchronized void g(com.google.android.libraries.navigation.internal.abh.bv bvVar) {
        this.e = bvVar;
    }

    public final synchronized void h(com.google.android.libraries.navigation.internal.ly.bt btVar) {
        this.f = btVar;
    }
}
