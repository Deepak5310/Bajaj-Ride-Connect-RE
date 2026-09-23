package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class go implements Serializable, gk {
    private static final long serialVersionUID = 1;

    protected go() {
    }

    private Object readResolve() {
        return gp.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    public final int a(long j, long j2) {
        return -Long.compare(j, j2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int compare(Long l, Long l2) {
        return gj.a(this, l, l2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    public final gk c() {
        return gp.a;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return compare((Long) obj, (Long) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gk
    public final /* synthetic */ gk d(gk gkVar) {
        return new gi(this, gkVar);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator reversed() {
        return gp.a;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return gj.d(this, comparator);
    }
}
