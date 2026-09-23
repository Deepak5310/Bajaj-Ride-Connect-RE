package com.google.android.libraries.navigation.internal.kf;

import com.google.android.libraries.navigation.internal.afl.qr;
import com.google.android.libraries.navigation.internal.afl.qs;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zp.cb;
import j$.time.Duration;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public final com.google.android.libraries.navigation.internal.jy.aa a;
    public final long b;
    public final int c;
    public final com.google.android.libraries.navigation.internal.jy.m d;
    private final long e;

    public i(com.google.android.libraries.navigation.internal.jy.aa aaVar, long j, long j2, int i, com.google.android.libraries.navigation.internal.jy.m mVar) {
        this.a = aaVar;
        this.b = j;
        this.e = j2;
        this.c = i;
        this.d = mVar;
        ar.k(i != 0);
    }

    public final qr a() {
        cb cbVar = (cb) com.google.android.libraries.navigation.internal.jw.i.a(this.a, Duration.ofMillis(this.b - this.e), this.c).t();
        qr qrVar = (qr) qs.a.q();
        if (!qrVar.b.H()) {
            qrVar.v();
        }
        qs qsVar = (qs) qrVar.b;
        cbVar.getClass();
        qsVar.c = cbVar;
        qsVar.b |= 1;
        return qrVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        com.google.android.libraries.navigation.internal.jy.aa aaVar = this.a;
        if (am.a(aaVar.d, iVar.a.d)) {
            com.google.android.libraries.navigation.internal.jy.aa aaVar2 = this.a;
            if (am.a(aaVar2.f, iVar.a.f)) {
                com.google.android.libraries.navigation.internal.jy.aa aaVar3 = this.a;
                if (am.a(aaVar3.g, iVar.a.g)) {
                    com.google.android.libraries.navigation.internal.jy.aa aaVar4 = this.a;
                    if (am.a(aaVar4.k, iVar.a.k)) {
                        com.google.android.libraries.navigation.internal.jy.aa aaVar5 = this.a;
                        if (am.a(aaVar5.j, iVar.a.j)) {
                            com.google.android.libraries.navigation.internal.jy.m mVar = iVar.d;
                            if (am.a(this.d.b(), mVar.b()) && am.a(this.d.a(), mVar.a())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        com.google.android.libraries.navigation.internal.jy.aa aaVar = this.a;
        return Arrays.hashCode(new Object[]{aaVar.d, aaVar.f, aaVar.k, aaVar.g, aaVar.j, Integer.valueOf(Arrays.hashCode(new Object[]{this.d.b(), this.d.a()}))});
    }
}
