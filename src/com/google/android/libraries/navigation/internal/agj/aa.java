package com.google.android.libraries.navigation.internal.agj;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa implements Serializable, x {
    private static final long serialVersionUID = 1;
    final x a;

    protected aa(x xVar) {
        this.a = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final /* synthetic */ int a(Short sh, Short sh2) {
        return w.b(this, sh, sh2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final int b(short s, short s2) {
        return this.a.b(s2, s);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final x c() {
        return this.a;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Short) obj, (Short) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final /* synthetic */ x d(x xVar) {
        return new v(this, xVar);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator reversed() {
        return this.a;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return w.d(this, comparator);
    }
}
