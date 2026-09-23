package com.google.android.libraries.geo.mapcore.renderer;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bo implements bi {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.renderer.bo");
    public boolean b;
    public boolean c;
    public int d;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final ArrayList f = new ArrayList();
    public final bh g;
    public final bj h;
    public final bm i;
    public final bn j;
    public final bk k;
    private boolean l;
    private Thread m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f76n;

    public bo(bh bhVar, String str) {
        bj bjVar = new bj();
        this.h = bjVar;
        bm bmVar = new bm();
        this.i = bmVar;
        this.j = new bn();
        this.k = new bk();
        this.f76n = str;
        bjVar.c = 0;
        bjVar.d = 0;
        bmVar.c = true;
        this.g = bhVar;
        this.d = 0;
        bmVar.a = 0;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void a() {
        this.i.f = true;
        e();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void b() {
        if (!j() && this.l) {
            this.i.d = true;
            notifyAll();
            while (this.l && !this.b) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            this.g.f();
            this.m = null;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void c() {
        try {
            if (!this.l) {
                bl blVar = new bl(this, this.f76n);
                this.m = blVar;
                this.l = true;
                blVar.start();
            }
            bm bmVar = this.i;
            bmVar.b = false;
            bmVar.c = true;
            this.j.c = false;
            notifyAll();
            while (this.l && !this.b && this.c && !this.j.c) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void d() {
        this.i.b = true;
        notifyAll();
        while (this.l && !this.b && !this.c) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void e() {
        this.i.c = true;
        notifyAll();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void f() {
        notifyAll();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void g(Object obj) {
        bj bjVar = this.h;
        bjVar.b = obj;
        bjVar.a = true;
        this.j.b = false;
        notifyAll();
        while (this.l) {
            bn bnVar = this.j;
            if (!bnVar.a || bnVar.b || this.b) {
                break;
            }
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void h() {
        bj bjVar = this.h;
        bjVar.b = null;
        bjVar.a = false;
        notifyAll();
        while (this.l && !this.j.a && !this.b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void i(int i, int i2) {
        try {
            bj bjVar = this.h;
            bjVar.c = i;
            bjVar.d = i2;
            bm bmVar = this.i;
            bmVar.e = true;
            bmVar.c = true;
            this.j.c = false;
            notifyAll();
            while (this.l && !this.b && !this.c && !this.j.c) {
                bk bkVar = this.k;
                if (!bkVar.b || !bkVar.c || !p()) {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized boolean j() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final boolean k() {
        return !this.e.get();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bi
    public final synchronized void l() {
        this.i.a = -1;
    }

    public final void m() {
        bk bkVar = this.k;
        if (bkVar.b) {
            ag agVar = bkVar.a;
            du duVar = bkVar.e;
            dt dtVar = bkVar.g;
            if (agVar != null && duVar != null && dtVar != null) {
                if (!agVar.h(duVar, dtVar)) {
                    throw new RuntimeException("eglDestroyContext failed: " + agVar.a());
                }
                bkVar.g = null;
                agVar.o(duVar);
                bkVar.e = null;
            }
            this.k.b = false;
        }
    }

    public final void n() {
        bk bkVar = this.k;
        if (bkVar.c) {
            bkVar.c = false;
            bkVar.a();
        }
    }

    public final synchronized boolean o() {
        if (this.g.k() && this.h.a) {
            bk bkVar = this.k;
            if (bkVar.b && bkVar.c) {
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean p() {
        if (!this.c) {
            bj bjVar = this.h;
            if (bjVar.a && !this.k.d && bjVar.c > 0 && bjVar.d > 0 && this.i.c) {
                return true;
            }
        }
        return false;
    }
}
