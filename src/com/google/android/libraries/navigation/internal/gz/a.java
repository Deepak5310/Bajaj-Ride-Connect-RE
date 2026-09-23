package com.google.android.libraries.navigation.internal.gz;

import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.mj.a {
    public final long a;
    private final long b;
    private final long c;
    private final Duration d;
    private final long e;
    private final Duration f;

    public a(com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.b = aVar.f().toEpochMilli();
        this.c = aVar.c();
        this.d = aVar.d();
        this.a = aVar.a();
        this.e = aVar.b();
        this.f = aVar.e();
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final long a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final long b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final long c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final Duration d() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final Duration e() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final Instant f() {
        return Instant.ofEpochMilli(this.b);
    }
}
