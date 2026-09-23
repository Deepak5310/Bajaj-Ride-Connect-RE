package com.google.android.libraries.navigation.internal.pk;

import com.google.android.libraries.navigation.internal.km.p;
import com.google.android.libraries.navigation.internal.km.v;
import com.google.android.libraries.navigation.internal.km.y;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zt.n;
import com.google.android.libraries.navigation.internal.zt.o;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.kg.a {
    public static final long a = TimeUnit.SECONDS.toNanos(1);
    private static final long b = 1000000000;
    private final ev H;
    private final ev I;
    private final com.google.android.libraries.navigation.internal.ox.c c;
    private final com.google.android.libraries.navigation.internal.kl.b d;
    private final com.google.android.libraries.navigation.internal.mj.a e;
    private final y f;
    private final y g;
    private long h;
    private boolean i;
    private boolean j;
    private long v;
    private long w;
    private int z;
    private boolean k = false;
    private long l = 0;
    private int m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f516n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = Integer.MAX_VALUE;
    private int t = 0;
    private int u = 0;
    private long x = -1;
    private long y = 0;
    private volatile boolean A = false;
    private long B = 0;
    private long C = 0;
    private long D = 0;
    private long E = 0;
    private long F = 0;
    private long G = 0;

    public c(com.google.android.libraries.navigation.internal.ox.c cVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.mj.a aVar, String str) {
        int i = ev.d;
        this.H = lv.a;
        this.I = lv.a;
        this.c = cVar;
        this.d = bVar;
        this.e = aVar;
        if (str.equals("GL-Map-Car-Cluster")) {
            this.f = p.av;
            this.g = p.at;
        } else {
            this.f = p.au;
            this.g = p.as;
        }
    }

    private final void c(long j) {
        this.y = 0L;
        this.x = j;
    }

    private final void d() {
        ev evVar;
        long j = this.y;
        if (j <= 0) {
            return;
        }
        int iMin = (int) Math.min(j, this.h);
        this.z = iMin;
        if (this.k) {
            if (iMin < this.s) {
                this.s = iMin;
            }
            this.t += iMin;
            this.u++;
        }
        synchronized (this) {
            evVar = this.H;
        }
        int i = ((lv) evVar).c;
        for (int i2 = 0; i2 < i; i2++) {
            ((b) evVar.get(i2)).a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.kg.a
    public final void a() {
    }

    @Override // com.google.android.libraries.navigation.internal.kg.a
    public final void b() {
        ev evVar;
        com.google.android.libraries.navigation.internal.ox.c cVar = this.c;
        boolean zH = cVar.h();
        this.i = zH;
        this.k = ((com.google.android.libraries.navigation.internal.ox.a) cVar).b;
        if (!zH) {
            if (this.A) {
                d();
                c(-1L);
            }
            this.j = true;
            return;
        }
        long jB = this.e.b();
        if (this.k && this.l == 0) {
            this.l = jB;
            this.A = true;
        }
        if (this.A && this.x < 0) {
            this.x = jB;
        }
        long j = jB - this.v;
        this.c.i();
        if (((com.google.android.libraries.navigation.internal.ox.a) this.c).a != this.h) {
            this.c.i();
            long j2 = ((com.google.android.libraries.navigation.internal.ox.a) this.c).a;
            this.h = j2;
            this.w = a / j2;
            this.v = jB;
            this.j = false;
            this.B = 0L;
            this.C = 0L;
            this.D = 0L;
            this.E = 0L;
            this.F = 0L;
            this.G = 0L;
            return;
        }
        long jRound = Math.round(j / this.w);
        if (!this.j) {
            this.d.f(this.f, jRound);
            boolean z = this.k;
            if (z) {
                this.E++;
            }
            this.B++;
            if (jRound > 1) {
                this.C++;
                this.F += true != z ? 0L : 1L;
                long j3 = jRound - 1;
                this.m++;
                if (j3 >= 2) {
                    this.f516n++;
                }
                if (j3 >= 4) {
                    this.o++;
                }
                if (j3 >= 8) {
                    this.p++;
                }
                if (j3 >= 16) {
                    this.q++;
                }
                if (j3 >= 30) {
                    this.r++;
                }
                synchronized (this) {
                    evVar = this.I;
                }
                int i = ((lv) evVar).c;
                for (int i2 = 0; i2 < i; i2++) {
                    ((a) evVar.get(i2)).a();
                }
                if (jRound > this.h * 0.7d) {
                    this.D++;
                    this.G += true != this.k ? 0L : 1L;
                }
            }
        }
        if (this.A) {
            if (jB - this.x >= b) {
                d();
                c(jB);
            }
            this.y++;
        }
        if (!this.k) {
            long j4 = this.l;
            if (j4 != 0) {
                long j5 = jB - j4;
                n nVar = (n) o.a.q();
                int i3 = this.s;
                if (i3 != Integer.MAX_VALUE) {
                    if (!nVar.b.H()) {
                        nVar.v();
                    }
                    o oVar = (o) nVar.b;
                    oVar.b |= 64;
                    oVar.i = i3;
                }
                int i4 = this.u;
                if (i4 > 0) {
                    int i5 = this.t / i4;
                    if (!nVar.b.H()) {
                        nVar.v();
                    }
                    o oVar2 = (o) nVar.b;
                    oVar2.b |= 128;
                    oVar2.j = i5;
                }
                int i6 = this.m;
                if (i6 > 0) {
                    if (!nVar.b.H()) {
                        nVar.v();
                    }
                    o oVar3 = (o) nVar.b;
                    oVar3.b = 1 | oVar3.b;
                    oVar3.c = i6;
                }
                int i7 = this.f516n;
                if (i7 > 0) {
                    if (!nVar.b.H()) {
                        nVar.v();
                    }
                    o oVar4 = (o) nVar.b;
                    oVar4.b |= 2;
                    oVar4.d = i7;
                }
                int i8 = this.o;
                if (i8 > 0) {
                    if (!nVar.b.H()) {
                        nVar.v();
                    }
                    o oVar5 = (o) nVar.b;
                    oVar5.b |= 4;
                    oVar5.e = i8;
                }
                int i9 = this.p;
                if (i9 > 0) {
                    if (!nVar.b.H()) {
                        nVar.v();
                    }
                    o oVar6 = (o) nVar.b;
                    oVar6.b |= 8;
                    oVar6.f = i9;
                }
                int i10 = this.q;
                if (i10 > 0) {
                    if (!nVar.b.H()) {
                        nVar.v();
                    }
                    o oVar7 = (o) nVar.b;
                    oVar7.b |= 16;
                    oVar7.g = i10;
                }
                int i11 = this.r;
                if (i11 > 0) {
                    if (!nVar.b.H()) {
                        nVar.v();
                    }
                    o oVar8 = (o) nVar.b;
                    oVar8.b |= 32;
                    oVar8.h = i11;
                }
                com.google.android.libraries.navigation.internal.kl.b bVar = this.d;
                v vVar = v.AUTO_PAN_MODE_ENABLED;
                bVar.l();
                this.d.f(this.g, j5 / 1000000);
                this.d.l();
                this.l = 0L;
                this.m = 0;
                this.f516n = 0;
                this.o = 0;
                this.p = 0;
                this.q = 0;
                this.r = 0;
                this.u = 0;
                this.t = 0;
                this.s = Integer.MAX_VALUE;
                synchronized (this) {
                    if (this.H.isEmpty()) {
                        this.A = false;
                        this.x = -1L;
                    }
                }
            }
        }
        this.v = jB;
        this.j = false;
    }
}
