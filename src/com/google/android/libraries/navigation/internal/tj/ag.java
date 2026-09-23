package com.google.android.libraries.navigation.internal.tj;

import com.google.android.libraries.navigation.internal.adr.iw;
import com.google.android.libraries.navigation.internal.adr.iz;
import com.google.android.libraries.navigation.internal.adr.jb;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ag extends a implements m {
    public final jg a;
    public final long b;
    private final long c;
    private final bh d;

    public ag(jg jgVar, bh bhVar, long j) {
        this.a = jgVar;
        this.d = bhVar;
        this.b = j;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        jb jbVar = jgVar.k;
        this.c = j + timeUnit.toMillis((jbVar == null ? jb.a : jbVar).c);
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final long a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final boolean e() {
        int iA = iw.a(this.a.l);
        if (iA == 0) {
            iA = iw.a;
        }
        return iA == iw.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final bg g() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final bg h() {
        if (this.d.k()) {
            return this.d.f();
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final bh i() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final t j() {
        return t.TRAFFIC_REPORT;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final iz k() {
        iz izVar = this.a.j;
        return izVar == null ? iz.a : izVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final boolean l() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean m() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean n() {
        return false;
    }
}
