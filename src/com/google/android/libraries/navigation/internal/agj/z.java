package com.google.android.libraries.navigation.internal.agj;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z implements Serializable, x {
    private static final long serialVersionUID = 1;

    protected z() {
    }

    private Object readResolve() {
        return ac.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int compare(Short sh, Short sh2) {
        return w.b(this, sh, sh2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final int b(short s, short s2) {
        return Short.compare(s, s2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final x c() {
        return ac.b;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return compare((Short) obj, (Short) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final /* synthetic */ x d(x xVar) {
        return new v(this, xVar);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator reversed() {
        return ac.b;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return w.d(this, comparator);
    }
}
