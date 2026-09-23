package com.google.android.libraries.navigation.internal.th;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yz.dt;
import com.google.android.libraries.navigation.internal.yz.kc;
import com.google.android.libraries.navigation.internal.yz.nb;
import com.google.android.libraries.navigation.internal.yz.nd;
import com.google.android.libraries.navigation.internal.zr.cj;
import com.google.android.libraries.navigation.internal.zr.cy;
import com.google.android.libraries.navigation.internal.zr.da;
import com.google.android.libraries.navigation.internal.zr.db;
import com.google.android.libraries.navigation.internal.zr.de;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private String d;
    private final String e;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f591n;
    private boolean a = true;
    private boolean b = true;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private List o = new ArrayList();
    private nd p = dt.g();
    private int q = 0;
    private int r = 0;

    public c(String str, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.e = str;
        this.c = aVar;
    }

    private final synchronized void s(String str, da daVar) {
        int i;
        Map map;
        Long l = (Long) this.p.a(str, daVar);
        if (l != null) {
            long jA = this.c.a() - l.longValue();
            nd ndVar = this.p;
            i = (int) jA;
            if (str != null && daVar != null && (map = (Map) kc.e(((nb) ndVar).a, str)) != null) {
                map.remove(daVar);
                if (map.isEmpty()) {
                    ((nb) ndVar).a.remove(str);
                }
            }
        } else {
            i = 0;
        }
        if (i > 0) {
            cy cyVar = (cy) db.a.q();
            if (!cyVar.b.H()) {
                cyVar.v();
            }
            db dbVar = (db) cyVar.b;
            dbVar.c = daVar.d;
            dbVar.b |= 1;
            if (!cyVar.b.H()) {
                cyVar.v();
            }
            db dbVar2 = (db) cyVar.b;
            dbVar2.b |= 4;
            dbVar2.e = i;
            if (daVar == da.LOCAL) {
                boolean z = this.a;
                if (!cyVar.b.H()) {
                    cyVar.v();
                }
                db dbVar3 = (db) cyVar.b;
                dbVar3.b |= 2;
                dbVar3.d = z;
                this.a = false;
            } else if (daVar == da.NETWORK) {
                boolean z2 = this.b;
                if (!cyVar.b.H()) {
                    cyVar.v();
                }
                db dbVar4 = (db) cyVar.b;
                dbVar4.b |= 2;
                dbVar4.d = z2;
                this.b = false;
            }
            this.o.add((db) cyVar.t());
        }
    }

    public final synchronized void a(cj cjVar) {
        if (this.f == 0 && this.g == 0 && this.h == 0 && this.k == 0 && this.l == 0 && this.m == 0 && this.o.isEmpty() && this.q == 0 && this.r == 0 && this.j == 0 && this.i == 0) {
            return;
        }
        String str = this.d;
        if (str != null) {
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar = (de) cjVar.b;
            de deVar2 = de.a;
            deVar.c |= 65536;
            deVar.R = str;
        }
        String str2 = this.f591n;
        if (str2 != null) {
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar3 = (de) cjVar.b;
            de deVar4 = de.a;
            deVar3.d |= 2;
            deVar3.ab = str2;
        }
        String strValueOf = String.valueOf(this.e);
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar5 = (de) cjVar.b;
        de deVar6 = de.a;
        strValueOf.getClass();
        deVar5.c |= 131072;
        deVar5.S = strValueOf;
        int i = this.f;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar7 = (de) cjVar.b;
        deVar7.c |= 524288;
        deVar7.T = i;
        int i2 = this.g;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar8 = (de) cjVar.b;
        deVar8.c |= 1048576;
        deVar8.U = i2;
        int i3 = this.h;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar9 = (de) cjVar.b;
        deVar9.c |= 2097152;
        deVar9.V = i3;
        int i4 = this.k;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar10 = (de) cjVar.b;
        deVar10.c |= 8388608;
        deVar10.W = i4;
        int i5 = this.l;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar11 = (de) cjVar.b;
        deVar11.c |= 16777216;
        deVar11.X = i5;
        int i6 = this.m;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar12 = (de) cjVar.b;
        deVar12.c |= 33554432;
        deVar12.Y = i6;
        List list = this.o;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar13 = (de) cjVar.b;
        bz bzVar = deVar13.ae;
        if (!bzVar.c()) {
            deVar13.ae = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(list, deVar13.ae);
        int i7 = this.q;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar14 = (de) cjVar.b;
        deVar14.d |= 4;
        deVar14.ac = i7;
        int i8 = this.r;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar15 = (de) cjVar.b;
        deVar15.d |= 8;
        deVar15.ad = i8;
        int i9 = this.j;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar16 = (de) cjVar.b;
        deVar16.c |= 134217728;
        deVar16.aa = i9;
        int i10 = this.i;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar17 = (de) cjVar.b;
        deVar17.c |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        deVar17.Z = i10;
    }

    public final synchronized void b() {
        this.k++;
    }

    public final synchronized void c() {
        this.i++;
    }

    public final synchronized void d() {
        this.j++;
    }

    public final synchronized void e() {
        this.l++;
    }

    public final synchronized void f() {
        this.m++;
    }

    public final synchronized void g() {
        this.g++;
    }

    public final synchronized void h() {
        this.f++;
    }

    public final synchronized void i() {
        this.h++;
    }

    public final synchronized void j() {
        this.r++;
    }

    public final synchronized void k() {
        this.q++;
    }

    public final synchronized void l(String str) {
        s(str, da.LOCAL);
    }

    public final synchronized void m(String str) {
        if (this.p.f(str, da.LOCAL)) {
            return;
        }
        this.p.b(str, da.LOCAL, Long.valueOf(this.c.a()));
    }

    public final synchronized void n(String str) {
        s(str, da.NETWORK);
    }

    public final synchronized void o(String str) {
        if (this.p.f(str, da.NETWORK)) {
            return;
        }
        this.p.b(str, da.NETWORK, Long.valueOf(this.c.a()));
    }

    public final synchronized void p() {
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.o = new ArrayList();
        this.p = dt.g();
        this.q = 0;
        this.r = 0;
        this.j = 0;
        this.i = 0;
    }

    public final synchronized void q(String str) {
        this.d = str;
    }

    public final synchronized void r(String str) {
        this.f591n = str;
    }

    public final synchronized String toString() {
        ak akVarC;
        ak akVarB = al.b(this);
        akVarB.g("TTS_ENGINE", this.d);
        akVarB.g("TTS_LOCALE", this.e);
        ak akVarC2 = akVarB.c("SYNTHESIS_COUNT", this.f).c("NETWORK_SYNTHESIS_COUNT", this.g).c("SYNTHESIS_TIMEOUTS", this.h).c("VOICE_ALERTS_COUNT", this.k).c("LOCAL_ALERTS_PLAYED", this.l).c("NETWORK_ALERTS_PLAYED", this.m).c("TTS_CACHE_REQUEST_COUNT", this.q).c("TTS_CACHE_HIT_COUNT", this.r);
        akVarC2.g("VOICE_NAME", this.f591n);
        akVarC = akVarC2.c("CHIMES_COUNT", this.j).c("CANNED_MESSAGES_COUNT", this.i);
        for (db dbVar : this.o) {
            Locale locale = Locale.US;
            da daVarB = da.b(dbVar.c);
            if (daVarB == null) {
                daVarB = da.UNKNOWN_SYNTHESIS_TYPE;
            }
            akVarC.g("SYNTHESIS_EVENT", String.format(locale, "TYPE:%s;IS_INITIAL:%s;DURATION:%d", daVarB, Boolean.valueOf(dbVar.d), Integer.valueOf(dbVar.e)));
        }
        akVarC.h();
        return akVarC.toString();
    }
}
