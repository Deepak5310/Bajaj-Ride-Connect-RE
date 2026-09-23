package com.google.android.libraries.navigation.internal.agj;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class v implements Serializable, x {
    public final /* synthetic */ x a;
    public final /* synthetic */ x b;

    public /* synthetic */ v(x xVar, x xVar2) {
        this.a = xVar;
        this.b = xVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final /* synthetic */ int a(Short sh, Short sh2) {
        return w.b(this, sh, sh2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final int b(short s, short s2) {
        int iB = this.a.b(s, s2);
        return iB == 0 ? this.b.b(s, s2) : iB;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final /* synthetic */ x c() {
        return ac.a(this);
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
    public final /* bridge */ /* synthetic */ Comparator reversed() {
        return c();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return w.d(this, comparator);
    }
}
