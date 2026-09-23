package com.google.android.libraries.navigation.internal.adh;

import com.google.android.libraries.navigation.internal.adg.ev;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.dg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends k {
    public final ar a;
    public final d b = new d(3);
    public final f c = new f();
    public final f d = new f();
    public final f e = new f();
    public final f f = new f();
    private final f u = new f();
    public final f g = new f();
    public final f h = new f();
    public final f i = new f();
    private final f v = new f();
    private final f w = new f();
    private final f x = new f();
    private final f y = new f();
    private final f z = new f();
    private final f A = new f();
    private final f B = new f();
    private final f C = new f();
    private final f D = new f();
    public final f j = new f();
    public final f k = new f();
    private final f E = new f();
    private final f F = new f();
    public final f l = new f();
    public j m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f206n = null;
    public String o = null;
    private final f G = new f();
    public e p = null;
    public final f q = new f();
    private final h H = new h();

    public b(ar arVar) {
        this.a = arVar;
    }

    public final int a() {
        return this.c.b;
    }

    @Override // com.google.android.libraries.navigation.internal.adh.k
    public final void b() {
        super.b();
        this.b.c();
        this.c.c();
        this.d.c();
        this.e.c();
        this.f.c();
        this.u.c();
        this.g.c();
        this.h.c();
        this.i.c();
        this.v.c();
        this.w.c();
        this.x.c();
        this.y.c();
        this.z.c();
        this.A.c();
        this.B.c();
        this.C.c();
        this.D.c();
        this.j.c();
        this.k.c();
        this.E.c();
        this.F.c();
        this.l.c();
        synchronized (this.l) {
            this.m = null;
        }
        this.f206n = null;
        this.o = null;
        this.G.c();
        e eVar = this.p;
        if (eVar != null) {
            eVar.a();
        }
        this.q.c();
    }

    @Override // com.google.android.libraries.navigation.internal.adh.k
    protected final void c(int i, int i2, int i3) {
        switch (i) {
            case 1:
                this.c.f(i2, i3);
                break;
            case 2:
                this.d.f(i2, i3);
                break;
            case 3:
                this.e.f(i2, i3);
                break;
            case 4:
                this.f.f(i2, i3);
                break;
            case 5:
                this.u.f(i2, i3);
                break;
            case 6:
                this.g.f(i2, i3);
                break;
            case 7:
                this.h.f(i2, i3);
                break;
            case 8:
                this.D.f(i2, i3);
                break;
            case 9:
                this.j.f(i2, i3);
                break;
            case 10:
                this.l.f(i2, i3);
                break;
            case 11:
                this.b.d(0, i2, i3);
                break;
            case 12:
                this.b.d(1, i2, i3);
                break;
            case 13:
                this.G.f(i2, i3);
                break;
            case 15:
                this.b.d(2, i2, i3);
                break;
            case 16:
                this.k.f(i2, i3);
                break;
            case 17:
                this.i.f(i2, i3);
                break;
            case 18:
                this.q.f(i2, i3);
                break;
            case 19:
                this.E.f(i2, i3);
                break;
            case 20:
                this.v.f(i2, i3);
                break;
            case 21:
                this.w.f(i2, i3);
                break;
            case 22:
                this.x.f(i2, i3);
                break;
            case 23:
                this.F.f(i2, i3);
                break;
            case 24:
                this.y.f(i2, i3);
                break;
            case 27:
                this.z.f(i2, i3);
                break;
            case 28:
                this.A.f(i2, i3);
                break;
            case 29:
                this.B.f(i2, i3);
                break;
            case 30:
                this.C.f(i2, i3);
                break;
        }
    }

    public final int d() {
        return this.G.b;
    }

    public final long e(int i) {
        return p(this.c.b(i), this.c.a(i));
    }

    public final ev f(int i) throws cc {
        return (ev) ((dg) ev.a.aH(7, null)).j(this.t, this.G.b(i), this.G.a(i), this.a);
    }

    public final id g(int i) throws cc {
        return (id) ((dg) id.a.aH(7, null)).j(this.t, this.D.b(i), this.D.a(i), this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.adh.k
    protected final boolean h(int i) {
        return i == 26;
    }

    @Override // com.google.android.libraries.navigation.internal.adh.k
    protected final boolean i(int i) {
        return i == 26;
    }
}
