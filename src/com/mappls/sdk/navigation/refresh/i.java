package com.mappls.sdk.navigation.refresh;

import com.mappls.sdk.navigation.NavigationContext;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    private f b = new f();
    private h c = new h();
    private c a = new c();
    private a d = new a();
    private b e = new b();

    public final void a() {
        if (NavigationContext.getNavigationContext().h().q()) {
            this.b.a();
        }
    }

    public final void a(long j, long j2) {
        this.d.c();
    }

    public final void a(boolean z) {
        this.a.a(z);
    }

    public final void b() {
        if (NavigationContext.getNavigationContext().h().q()) {
            this.b.b();
            this.c.a();
            this.a.getClass();
            this.d.getClass();
            a.a();
            this.e.getClass();
        }
    }

    public final void b(boolean z) {
        this.c.a(Boolean.valueOf(z));
    }

    public final void c() {
        this.a.b();
    }

    public final void d() {
        if (NavigationContext.getNavigationContext().h().q()) {
            this.b.c();
            this.c.b();
            this.a.c();
            this.d.d();
            this.e.getClass();
            b.b();
        }
    }

    public final void e() {
        if (NavigationContext.getNavigationContext().h().q()) {
            this.b.e();
            if (NavigationContext.getNavigationContext().h().k().getEvents().size() <= 0) {
                this.c.c();
            }
            if (NavigationContext.getNavigationContext().h().k().getJunctionViews().size() <= 0) {
                this.a.d();
            }
            this.d.e();
            this.e.getClass();
            b.c();
        }
    }
}
