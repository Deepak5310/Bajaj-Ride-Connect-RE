package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class gi implements Serializable, gk {
    public final /* synthetic */ gk a;
    public final /* synthetic */ gk b;

    public /* synthetic */ gi(gk gkVar, gk gkVar2) {
        this.a = gkVar;
        this.b = gkVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    public final int a(long j, long j2) {
        int iA = this.a.a(j, j2);
        return iA == 0 ? this.b.a(j, j2) : iA;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    public final /* synthetic */ int b(Long l, Long l2) {
        return gj.a(this, l, l2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    public final /* synthetic */ gk c() {
        return gp.a(this);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return b((Long) obj, (Long) obj2);
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
