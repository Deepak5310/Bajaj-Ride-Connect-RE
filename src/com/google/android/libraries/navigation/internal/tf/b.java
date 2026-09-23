package com.google.android.libraries.navigation.internal.tf;

import com.google.android.libraries.navigation.internal.ady.ad;
import com.google.android.libraries.navigation.internal.bp.bg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.google.android.libraries.navigation.internal.ic.a {
    public final bg a;
    public final ad b;
    public final long c;
    private final double d;
    private final double e;

    public b(bg bgVar, double d, double d2, ad adVar, long j) {
        this.a = bgVar;
        this.d = d;
        this.e = d2;
        this.b = adVar;
        this.c = j;
    }

    @Override // com.google.android.libraries.navigation.internal.ic.a
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ic.a
    public final /* synthetic */ boolean aj() {
        return false;
    }

    public final double c() {
        return this.d - this.e;
    }
}
