package com.google.android.apps.gmm.location.navigation;

import android.os.Build;
import com.google.android.libraries.navigation.internal.yz.fy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final fy c = fy.u("SM-S921B", "SM-S921N", "SM-S926B", "SM-S926N", "SM-A556B", "SM-A556S", "SM-A556E", "SM-A5560", "SM-A556D", "SM-A556J");
    final float a;
    protected final com.google.android.libraries.navigation.internal.kl.a b;
    private final float d;
    private final float e;
    private final com.google.android.libraries.navigation.internal.mj.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f38n;
    private boolean o;
    private com.google.android.libraries.navigation.internal.db.r q;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private int i = 0;
    private int j = -1;
    private int k = 0;
    private long l = 0;
    private boolean p = false;

    public a(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.kl.a aVar2, l lVar) {
        this.m = aVar;
        this.b = aVar2;
        this.a = (float) lVar.a("base_location_hardware_fixup_step_gps_accuracy", 2.0d, 1.0d);
        this.d = (float) lVar.a("base_location_hardware_fixup_step_gps_speed_accuracy", 0.5d, 0.10000000149011612d);
        this.e = (float) lVar.a("base_location_hardware_fixup_step_gps_bearing_accuracy", 1.0d, 0.05000000074505806d);
        a();
    }

    private final boolean e() {
        return this.m.a() - this.l > 4000;
    }

    protected final void a() {
        this.j = -1;
        this.k = 0;
        this.f = false;
        this.g = false;
        this.h = false;
        this.l = -1L;
        this.o = false;
        this.f38n = false;
        this.q = null;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d4  */
    protected final boolean b(com.google.android.libraries.navigation.internal.db.q qVar) {
        if (qVar.m()) {
            float f = qVar.i;
            if (f > 510.0f || f < 0.0f) {
                ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(5);
                return false;
            }
        }
        if (qVar.h() && qVar.d > 1000.0f) {
            ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(6);
            return false;
        }
        double d = qVar.e;
        if (!Double.isNaN(d) && (d < -10000.0d || d > 18000.0d)) {
            ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(7);
            return false;
        }
        double d2 = qVar.b;
        if (Math.abs(d2) <= 90.0d) {
            double d3 = qVar.c;
            if (Math.abs(d3) <= 180.0d) {
                if (d2 == 0.0d && d3 == 0.0d) {
                    ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(9);
                    return false;
                }
                if (this.o) {
                    if (qVar.h() && qVar.d == 0.0f) {
                        if (c.contains(Build.MODEL)) {
                            qVar.d = 1.0f;
                            return true;
                        }
                        ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(10);
                        return false;
                    }
                } else if (qVar.h() && qVar.d > 0.0f) {
                    this.o = true;
                    if (qVar.h()) {
                        if (c.contains(Build.MODEL)) {
                            qVar.d = 1.0f;
                            return true;
                        }
                        ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(10);
                        return false;
                    }
                }
                return true;
            }
        }
        ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(8);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0170  */
    /* JADX WARN: Code duplicated, block: B:143:0x021f  */
    /* JADX WARN: Code duplicated, block: B:90:0x012e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0159  */
    public boolean c(com.google.android.libraries.navigation.internal.db.q qVar) {
        boolean z;
        com.google.android.libraries.navigation.internal.db.r rVar;
        com.google.android.libraries.navigation.internal.db.r rVar2;
        int i;
        float f;
        int i2;
        this.k++;
        if (!b(qVar)) {
            return true;
        }
        qVar.b().c = this.p;
        if (!qVar.c().a()) {
            if (qVar.w) {
                i2 = qVar.x;
                this.i = Math.max(this.i, i2);
                this.h = true;
            } else {
                i2 = -1;
            }
            int iMax = (!e() || i2 < 0) ? Math.max(i2, this.j) : i2;
            if (iMax >= 0) {
                qVar.u(iMax);
            } else if (!this.h) {
                qVar.u(-2);
            }
            if (qVar.c().c > 0 || qVar.c().d ? !((!this.f || !e() || i2 != -1) && (qVar.c().c >= 3 || qVar.c().d || !this.g)) : this.f) {
                ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(4);
                return true;
            }
        }
        com.google.android.libraries.navigation.internal.db.r rVar3 = this.q;
        if (rVar3 != null && "Car-GPS".equals(qVar.a) && !qVar.u && !this.f && this.i == 0) {
            if (rVar3.b == qVar.b && rVar3.c == qVar.c && qVar.i == 0.0f && qVar.g == 0.0f) {
                qVar.a();
                return true;
            }
        }
        if (!this.o && qVar.c().a() && !qVar.c().d && (i = qVar.c().c - 3) >= 0) {
            if (i == 0) {
                f = 1.0f;
            } else if (i == 1) {
                f = 0.75f;
            } else if (i == 2) {
                f = 0.5f;
            } else if (i != 3) {
                f = i != 4 ? 0.0f : 0.125f;
            } else {
                f = 0.25f;
            }
            qVar.d = (int) ((f * 88.0f) + 8.0f);
        }
        if (qVar.h()) {
            float f2 = qVar.d;
            if (f2 != 0.0f) {
                qVar.d = Math.max(this.a, f2);
            } else {
                qVar.d = 48.12345f;
                ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(11);
            }
        } else {
            qVar.d = 48.12345f;
            ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(11);
        }
        if (qVar.n()) {
            float f3 = qVar.j;
            if (f3 != 0.0f) {
                qVar.j = Math.max(this.d, f3);
            } else {
                qVar.j = Float.NaN;
            }
        } else {
            qVar.j = Float.NaN;
        }
        if (qVar.j()) {
            float f4 = qVar.h;
            if (f4 != 0.0f) {
                qVar.h = Math.max(this.e, f4);
            } else {
                qVar.h = Float.NaN;
            }
        } else {
            qVar.h = Float.NaN;
        }
        if (this.g && qVar.c().a() && qVar.c().c < 5 && qVar.d < 96.0f && !qVar.c().d) {
            qVar.d = 96.0f;
        }
        if (qVar.m() && qVar.i > 100.0f) {
            qVar.p();
            ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(12);
        }
        if (!this.f38n) {
            if (!qVar.i() || qVar.g == 0.0f) {
                qVar.o();
                ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(13);
            } else {
                this.f38n = true;
            }
        }
        if (!qVar.m() && qVar.i()) {
            qVar.o();
            ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(14);
        }
        if (qVar.m() && (rVar2 = this.q) != null && rVar2.x()) {
            float f5 = qVar.i;
            if (f5 == 0.0f || f5 != this.q.f) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        boolean z2 = qVar.i() && (rVar = this.q) != null && rVar.t() && qVar.g == this.q.f();
        if (z && z2) {
            qVar.p();
            qVar.o();
            ((com.google.android.libraries.navigation.internal.kk.k) this.b.a(com.google.android.libraries.navigation.internal.km.af.o)).a(15);
        }
        if (qVar.i()) {
            float f6 = qVar.g;
            if (f6 < 0.0f || f6 >= 360.0f) {
                double d = f6 / 360.0f;
                qVar.g = ((float) (d - Math.floor(d))) * 360.0f;
            }
        }
        this.q = qVar.a();
        return false;
    }

    protected final void d(int i, boolean z) {
        this.j = i;
        this.f = (i > 0) | this.f;
        this.g |= i >= 3;
        this.h = true;
        this.p = z;
        this.l = this.m.a();
    }
}
