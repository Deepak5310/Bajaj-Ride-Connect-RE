package com.google.android.libraries.navigation.internal.agd;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa implements z {
    final /* synthetic */ Comparator a;

    public aa(Comparator comparator) {
        this.a = comparator;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final int a(byte b, byte b2) {
        return this.a.compare(Byte.valueOf(b), Byte.valueOf(b2));
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compare(Byte b, Byte b2) {
        return this.a.compare(b, b2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final /* synthetic */ z c() {
        return ae.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final /* synthetic */ z d(z zVar) {
        return new x(this, zVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ Comparator reversed() {
        return c();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return y.d(this, comparator);
    }
}
