package com.google.android.libraries.navigation.internal.abn;

import android.os.RemoteException;
import android.view.animation.AnimationUtils;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abh.bs;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    public static final String a = "z";
    public final com.google.android.libraries.navigation.internal.abf.z b;
    public final com.google.android.libraries.navigation.internal.abh.af c;
    public v d;
    public int e;
    private final Executor f;
    private final c g;
    private final y h;

    public z(com.google.android.libraries.navigation.internal.abh.af afVar, c cVar) {
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        com.google.android.libraries.navigation.internal.abf.z zVar = com.google.android.libraries.navigation.internal.abf.z.a;
        y yVar = y.a;
        this.c = afVar;
        this.g = cVar;
        this.f = executorA;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "UI ThreadChecker cannot be null.");
        this.b = zVar;
        this.h = yVar;
        synchronized (this) {
            this.d = null;
            this.e = 0;
        }
    }

    public final synchronized com.google.android.libraries.navigation.internal.pd.j a() {
        v vVar = this.d;
        com.google.android.libraries.navigation.internal.abf.q qVarF = vVar == null ? null : vVar.f();
        if (qVarF == null) {
            return null;
        }
        return new com.google.android.libraries.navigation.internal.pd.j(com.google.android.libraries.navigation.internal.abm.f.f((CameraPosition) qVarF.a), ((Long) qVarF.b).longValue());
    }

    public final void b(v vVar, Object obj) {
        v vVar2;
        int i;
        this.b.a();
        com.google.android.libraries.navigation.internal.abf.t.c(obj, "worldModelState");
        int i2 = 0;
        if (vVar != null) {
            com.google.android.libraries.navigation.internal.abh.af afVar = this.c;
            int iA = vVar.a();
            afVar.c.a();
            synchronized (afVar) {
                afVar.g++;
            }
            boolean z = afVar.f != iA || iA == 4;
            boolean z2 = z && afVar.f();
            boolean z3 = z && iA != -4;
            afVar.f = iA;
            afVar.d = true;
            if (iA == 1) {
                afVar.e = true;
            }
            com.google.android.libraries.navigation.internal.ly.z zVar = afVar.h;
            if (zVar != null && z2) {
                try {
                    ((com.google.android.gms.maps.v) zVar).a.onCameraMoveCanceled();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            if (z3) {
                Iterator it2 = afVar.k.iterator();
                while (it2.hasNext()) {
                    ((bs) it2.next()).a(iA);
                }
                com.google.android.libraries.navigation.internal.ly.ad adVar = afVar.j;
                if (adVar != null) {
                    if (iA != 1) {
                        i = 2;
                        if (iA != 2) {
                            if (iA == 3) {
                                i = 3;
                            } else if (iA != 4) {
                                throw new IllegalStateException("Unknown camera state");
                            }
                        }
                    } else {
                        i = 1;
                    }
                    try {
                        ((com.google.android.gms.maps.t) adVar).a.onCameraMoveStarted(i);
                    } catch (RemoteException e2) {
                        throw new RuntimeRemoteException(e2);
                    }
                }
            }
            CameraPosition cameraPositionD = vVar.d();
            if (cameraPositionD != null) {
                if (obj instanceof be) {
                    ((be) obj).t(cameraPositionD);
                } else {
                    aw awVar = (aw) obj;
                    awVar.j();
                    awVar.a.t(cameraPositionD);
                }
            }
        }
        synchronized (this) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
            vVar2 = this.d;
            this.d = vVar;
            if (vVar != null) {
                i2 = 1;
            }
            this.e = i2;
        }
        if (vVar2 != null) {
            vVar2.h(true);
            com.google.android.libraries.navigation.internal.afu.d.a.a().O();
        }
    }

    public final synchronized void c() {
        final int i;
        this.b.b();
        if (this.d != null) {
            int i2 = this.e;
            com.google.android.libraries.navigation.internal.afu.d.a.a().K();
            if (i2 == 1) {
                final com.google.android.libraries.navigation.internal.abh.af afVar = this.c;
                afVar.c.b();
                afVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.ae
                    @Override // java.lang.Runnable
                    public final void run() {
                        af afVar2 = afVar;
                        afVar2.c.a();
                        if (!afVar2.d || afVar2.f == -4) {
                            return;
                        }
                        com.google.android.libraries.navigation.internal.afu.d.a.a().Q();
                        com.google.android.libraries.navigation.internal.ly.ab abVar = afVar2.i;
                        if (abVar != null) {
                            try {
                                ((com.google.android.gms.maps.u) abVar).a.onCameraMove();
                            } catch (RemoteException e) {
                                throw new RuntimeRemoteException(e);
                            }
                        }
                    }
                });
            }
            if (this.e == 2) {
                this.e = 3;
                final v vVar = this.d;
                this.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abn.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        z zVar = this.a;
                        zVar.b.a();
                        synchronized (zVar) {
                            com.google.android.libraries.navigation.internal.abf.p.f(z.a, 3);
                            v vVar2 = zVar.d;
                            v vVar3 = vVar;
                            if (vVar2 == vVar3 && zVar.e == 3) {
                                zVar.d = null;
                                zVar.e = 0;
                                vVar3.h(false);
                            }
                        }
                    }
                });
                final com.google.android.libraries.navigation.internal.abh.af afVar2 = this.c;
                afVar2.c.b();
                synchronized (afVar2) {
                    i = afVar2.g;
                }
                afVar2.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        af afVar3 = afVar2;
                        afVar3.c.a();
                        synchronized (afVar3) {
                            if (i < afVar3.g) {
                                return;
                            }
                            if (!afVar3.d) {
                                com.google.android.libraries.navigation.internal.abf.p.f(af.a, 3);
                            } else {
                                afVar3.d = false;
                                afVar3.a();
                            }
                        }
                    }
                });
            }
        }
    }

    public final synchronized void d(ad adVar, be beVar) {
        this.b.b();
        v vVar = this.d;
        if (vVar != null && this.e == 1) {
            adVar.a = true;
            adVar.b = vVar.j();
            CameraPosition cameraPositionC = this.d.c(beVar, AnimationUtils.currentAnimationTimeMillis());
            if (cameraPositionC != null) {
                CameraPosition cameraPositionC2 = this.g.c(cameraPositionC, beVar);
                boolean z = cameraPositionC2 != cameraPositionC;
                adVar.f = z;
                if (!z || this.d.k(cameraPositionC2, beVar)) {
                    cameraPositionC = cameraPositionC2;
                } else {
                    adVar.g = true;
                    cameraPositionC = null;
                }
            }
            if (this.d.i()) {
                adVar.h = true;
                this.e = 2;
            }
            if (cameraPositionC != null) {
                adVar.d = cameraPositionC;
                adVar.e = this.d.e();
                return;
            } else {
                adVar.d = beVar.f();
                adVar.e = beVar.i();
                return;
            }
        }
        adVar.d = beVar.f();
        adVar.e = beVar.i();
    }

    public final synchronized boolean e() {
        return this.e == 0;
    }
}
