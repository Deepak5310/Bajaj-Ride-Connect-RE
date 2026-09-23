package com.google.android.libraries.navigation.internal.tj;

import com.google.android.libraries.navigation.internal.adr.iz;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.adr.kp;
import com.google.android.libraries.navigation.internal.adr.kq;
import com.google.android.libraries.navigation.internal.afl.fs;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b extends a implements m {
    static final Duration a = Duration.ofSeconds(6);
    public final kq b;
    public final bg c;
    public final iz d;
    private final com.google.android.libraries.navigation.internal.hn.r e;
    private final bh f;
    private final Instant g;

    public b(com.google.android.libraries.navigation.internal.hn.r rVar, kq kqVar, bh bhVar, bg bgVar, Instant instant) {
        this.e = rVar;
        this.b = kqVar;
        this.f = bhVar;
        this.c = bgVar;
        this.g = instant;
        jg jgVar = kqVar.e;
        iz izVar = (jgVar == null ? jg.a : jgVar).j;
        this.d = izVar == null ? iz.a : izVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final long a() {
        return this.g.toEpochMilli();
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final Duration b() {
        int iA = kp.a(this.b.d);
        if (iA == 0) {
            iA = kp.a;
        }
        return iA == kp.c ? a : Duration.ofSeconds(((fs) this.e.b()).G);
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final bg g() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final bg h() {
        return this.f.f();
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final bh i() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final t j() {
        return t.BETTER_ROUTE;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final iz k() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.m
    public final boolean l() {
        return true;
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
