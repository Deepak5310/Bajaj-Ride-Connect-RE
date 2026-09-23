package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zs.es;
import com.google.android.libraries.navigation.internal.zs.eu;
import com.google.android.libraries.navigation.internal.zs.fb;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad {
    public final fb a;
    public final long b;
    public final String c;
    public final int d;
    public final int e;
    public final boolean f;
    public final long g;
    public final long h;
    public boolean i = true;
    private final long j;
    private final String k;
    private final String l;
    private final String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f593n;
    private final int o;
    private final boolean p;
    private ev q;
    private final int r;

    public ad(fb fbVar, long j, long j2, String str, int i, int i2, String str2, String str3, String str4, String str5, boolean z, long j3, long j4, boolean z2, int i3, int i4) {
        int i5 = ev.d;
        this.q = lv.a;
        this.a = fbVar;
        this.j = j;
        this.b = j2;
        this.c = str;
        this.d = i;
        this.e = i2;
        this.k = str2;
        this.l = str3;
        this.m = str4;
        this.f593n = str5;
        this.f = true;
        this.g = j3;
        this.h = j4;
        this.p = z2;
        this.r = i3;
        this.o = i4;
    }

    public final long a() {
        if (this.i) {
            return this.j;
        }
        return 0L;
    }

    public final com.google.android.libraries.navigation.internal.zs.ev b() {
        boolean z = this.i;
        es esVar = (es) com.google.android.libraries.navigation.internal.zs.ev.a.q();
        if (!esVar.b.H()) {
            esVar.v();
        }
        String str = this.f593n;
        com.google.android.libraries.navigation.internal.zs.ev evVar = (com.google.android.libraries.navigation.internal.zs.ev) esVar.b;
        str.getClass();
        evVar.b |= 512;
        evVar.e = str;
        boolean z2 = this.p;
        if (!esVar.b.H()) {
            esVar.v();
        }
        com.google.android.libraries.navigation.internal.zs.ev evVar2 = (com.google.android.libraries.navigation.internal.zs.ev) esVar.b;
        evVar2.b |= 4096;
        evVar2.g = z2;
        int i = this.r;
        if (i != 0) {
            eu euVarB = eu.b(i - 1);
            ar.q(euVarB);
            if (!esVar.b.H()) {
                esVar.v();
            }
            com.google.android.libraries.navigation.internal.zs.ev evVar3 = (com.google.android.libraries.navigation.internal.zs.ev) esVar.b;
            evVar3.h = euVarB.e;
            evVar3.b |= 8192;
        }
        int i2 = this.o;
        if (!esVar.b.H()) {
            esVar.v();
        }
        com.google.android.libraries.navigation.internal.zs.ev evVar4 = (com.google.android.libraries.navigation.internal.zs.ev) esVar.b;
        evVar4.b |= 16384;
        evVar4.i = i2;
        if (z) {
            long j = this.j;
            if (!esVar.b.H()) {
                esVar.v();
            }
            com.google.android.libraries.navigation.internal.zs.ev evVar5 = (com.google.android.libraries.navigation.internal.zs.ev) esVar.b;
            evVar5.b |= 1;
            evVar5.c = j;
        }
        String str2 = this.c;
        if (str2 != null && z) {
            if (!esVar.b.H()) {
                esVar.v();
            }
            com.google.android.libraries.navigation.internal.zs.ev evVar6 = (com.google.android.libraries.navigation.internal.zs.ev) esVar.b;
            evVar6.b |= 2;
            evVar6.d = str2;
        }
        synchronized (this) {
            ev evVar7 = this.q;
            if (evVar7 != null && !evVar7.isEmpty()) {
                ev evVar8 = this.q;
                if (!esVar.b.H()) {
                    esVar.v();
                }
                com.google.android.libraries.navigation.internal.zs.ev evVar9 = (com.google.android.libraries.navigation.internal.zs.ev) esVar.b;
                bz bzVar = evVar9.f;
                if (!bzVar.c()) {
                    evVar9.f = bi.A(bzVar);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(evVar8, evVar9.f);
            }
        }
        return (com.google.android.libraries.navigation.internal.zs.ev) esVar.t();
    }

    public final synchronized void c(List list) {
        this.q = ev.o(list);
    }

    public final String toString() {
        return String.format(Locale.US, "sessionId: 0x%016x, sessionNonce: 0x%016x, extendedSessionId: %s, startScrubbingDistanceM: %d, endScrubbingDistanceM: %d, softwareVersion: %s, platformId: %s, applicationName: %s, referrerName: %s, isThirdParty: %b, userShownRtNavdataDisclosure: %b, deviceTier: %s, googleTermsOfServiceVersion: %d", Long.valueOf(this.j), Long.valueOf(this.b), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e), this.k, this.l, this.m, this.f593n, true, Boolean.valueOf(this.p), com.google.android.libraries.navigation.internal.fr.n.a(this.r), Integer.valueOf(this.o));
    }
}
