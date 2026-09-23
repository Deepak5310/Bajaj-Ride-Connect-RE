package com.google.android.libraries.geo.navcore.service.base;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yz.fz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class NavigationService extends Service {
    public com.google.android.libraries.navigation.internal.tk.l a;
    public com.google.android.libraries.navigation.internal.so.c b;
    public com.google.android.libraries.navigation.internal.kl.b c;
    public com.google.android.libraries.navigation.internal.tl.a d;
    public com.google.android.libraries.navigation.internal.afo.a e;
    public com.google.android.libraries.navigation.internal.so.g f;
    public q g;
    private boolean h = false;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        if (this.h) {
            com.google.android.libraries.navigation.internal.tk.l lVar = this.a;
            if (lVar.i) {
                lVar.m.a().h(lVar.j);
            }
            lVar.a.e(lVar.k);
            lVar.b.d(lVar.f);
            lVar.f599n.d(lVar.l);
            lVar.c.a();
            com.google.android.libraries.navigation.internal.tk.c cVar = lVar.d;
            cVar.a.removeCallbacks(cVar.k);
            cVar.a.removeCallbacks(cVar.j);
            com.google.android.libraries.navigation.internal.tp.f fVar = cVar.h;
            if (fVar != null) {
                fVar.a();
            }
            ((com.google.android.libraries.navigation.internal.wa.g) cVar.c.a()).a();
            cVar.i = 0L;
            cVar.d = null;
            lVar.o.e(lVar.g);
            this.f.c();
            this.c.i();
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        if (this.h && intent != null) {
            if (intent.hasExtra("abortcurrentsession")) {
                this.b.b(true);
                return 2;
            }
            if (!this.d.a(intent) && Build.VERSION.SDK_INT >= 31) {
                com.google.android.libraries.navigation.internal.tk.c cVar = this.a.d;
                com.google.android.libraries.navigation.internal.to.b bVar = (com.google.android.libraries.navigation.internal.to.b) cVar.b.a();
                PendingIntent pendingIntentA = cVar.a();
                bVar.a.f();
                bVar.c = ((com.google.android.libraries.navigation.internal.to.d) bVar.b).a();
                bVar.c.a(pendingIntentA);
                cVar.e(bVar);
                cVar.g = true;
                com.google.android.libraries.navigation.internal.kk.e eVar = cVar.l;
            }
            this.f.d();
        }
        return 2;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        com.google.android.libraries.navigation.internal.aq.l lVarA;
        if (!this.h || this.g.b() || com.google.android.libraries.navigation.internal.aq.l.CONNECTED == (lVarA = ((com.google.android.libraries.navigation.internal.aq.m) this.e.a()).a()) || com.google.android.libraries.navigation.internal.aq.l.CONNECTED_AND_DISPLAY_ACTIVE == lVarA) {
            return;
        }
        this.b.b(true);
    }

    @Override // android.app.Service
    public final void onCreate() {
        com.google.android.libraries.navigation.environment.c cVar = com.google.android.libraries.navigation.internal.ii.b.a;
        u uVar = (u) (cVar == null ? null : (com.google.android.libraries.navigation.internal.ii.f) u.class.cast(new com.google.android.libraries.navigation.environment.s(new com.google.android.libraries.navigation.environment.r(((com.google.android.libraries.navigation.environment.m) cVar.b).b).a, this)));
        if (uVar == null) {
            stopSelf();
            return;
        }
        uVar.a(this);
        com.google.android.libraries.navigation.internal.tk.l lVar = this.a;
        lVar.m.a().g(lVar.j, lVar.e);
        lVar.i = true;
        lVar.b.c(lVar.f, lVar.e);
        com.google.android.libraries.navigation.internal.ia.e eVar = lVar.a;
        com.google.android.libraries.navigation.internal.tk.k kVar = lVar.k;
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.sd.b.class, new com.google.android.libraries.navigation.internal.tk.m(0, com.google.android.libraries.navigation.internal.sd.b.class, kVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.tl.b.class, new com.google.android.libraries.navigation.internal.tk.m(1, com.google.android.libraries.navigation.internal.tl.b.class, kVar, ap.UI_THREAD));
        eVar.c(kVar, fzVar.a());
        lVar.f599n.c(lVar.l, lVar.e);
        lVar.o.c(lVar.g, lVar.e);
        this.c.h();
        this.h = true;
    }
}
