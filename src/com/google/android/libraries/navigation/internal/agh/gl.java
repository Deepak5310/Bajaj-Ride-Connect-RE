package com.google.android.libraries.navigation.internal.agh;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gl implements gk {
    final /* synthetic */ Comparator a;

    public gl(Comparator comparator) {
        this.a = comparator;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    public final int a(long j, long j2) {
        return this.a.compare(Long.valueOf(j), Long.valueOf(j2));
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compare(Long l, Long l2) {
        return this.a.compare(l, l2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    public final /* synthetic */ gk c() {
        return gp.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    public final /* synthetic */ gk d(gk gkVar) {
        return new gi(this, gkVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ Comparator reversed() {
        return c();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return gj.d(this, comparator);
    }
}
