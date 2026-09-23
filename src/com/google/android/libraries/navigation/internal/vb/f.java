package com.google.android.libraries.navigation.internal.vb;

import com.google.android.libraries.navigation.internal.nc.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.uk.a.b {
    public static final x a = com.google.android.libraries.navigation.internal.nc.j.f(com.google.android.libraries.navigation.internal.f.b.h);
    private final x b;
    private final x c;

    public f(e eVar) {
        this.b = eVar.a;
        this.c = eVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a.b
    public final x a(boolean z) {
        return z ? this.b : a;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a.b
    public final x b(boolean z) {
        return z ? this.c : a;
    }
}
