package com.google.android.libraries.navigation.internal.vd;

import com.google.android.libraries.navigation.internal.aac.bl;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afl.fp;
import com.google.android.libraries.navigation.internal.afl.fs;
import j$.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public final fp f;
    public final k g;
    public final bn h;
    public final com.google.android.libraries.navigation.internal.rw.f i;
    public final com.google.android.libraries.navigation.internal.pi.s j;
    public final l k;
    public bl l;
    public bl m;
    private final g o;
    public boolean a = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f636n = 0;
    public boolean b = false;
    public boolean c = false;
    public Instant d = Instant.EPOCH;
    int e = 0;

    public m(com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.hn.r rVar, bn bnVar, g gVar) {
        fp fpVar = ((fs) rVar.b()).aX;
        this.f = fpVar == null ? fp.a : fpVar;
        this.h = bnVar;
        this.k = new l(this);
        this.g = new k();
        this.i = fVar;
        this.j = sVar;
        this.o = gVar;
    }

    public final bl a() {
        int i = this.f.b;
        if ((i & 8) == 0 || (i & 4) == 0 || this.a || this.o.b() || this.c) {
            return null;
        }
        fp fpVar = this.f;
        int i2 = fpVar.j;
        if (i2 != -1 && this.f636n >= i2) {
            return null;
        }
        this.f636n++;
        int i3 = fpVar.e;
        if (i3 > 0) {
            this.a = true;
            return this.h.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vd.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c();
                }
            }, i3, TimeUnit.SECONDS);
        }
        if (i3 != -1) {
            return null;
        }
        this.a = true;
        return null;
    }

    public final void b() {
        bl blVar = this.l;
        if (blVar != null) {
            blVar.cancel(false);
            this.l = null;
        }
    }

    public final void c() {
        this.a = false;
        this.b = false;
        b();
        d(this.f.h);
    }

    public final void d(int i) {
        bl blVar;
        if (this.c && (blVar = this.m) != null && !blVar.isDone()) {
            if (this.m.getDelay(TimeUnit.SECONDS) >= i) {
                return;
            }
            this.m.cancel(false);
            this.m = null;
        }
        if (i > 0) {
            this.c = true;
            this.m = this.h.schedule(new Callable() { // from class: com.google.android.libraries.navigation.internal.vd.i
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    this.a.c = false;
                    return false;
                }
            }, i, TimeUnit.SECONDS);
        }
    }
}
