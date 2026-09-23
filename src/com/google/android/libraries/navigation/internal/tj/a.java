package com.google.android.libraries.navigation.internal.tj;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements u {
    private static final Duration a = Duration.ofSeconds(20);
    private boolean b;

    protected a() {
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public long a() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public Duration b() {
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final void c() {
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public boolean e() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final void f() {
        this.b = true;
    }
}
