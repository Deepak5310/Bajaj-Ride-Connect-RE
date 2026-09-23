package com.google.android.libraries.navigation.internal.agd;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class x implements Serializable, z {
    public final /* synthetic */ z a;
    public final /* synthetic */ z b;

    public /* synthetic */ x(z zVar, z zVar2) {
        this.a = zVar;
        this.b = zVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final int a(byte b, byte b2) {
        int iA = this.a.a(b, b2);
        return iA == 0 ? this.b.a(b, b2) : iA;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final /* synthetic */ int b(Byte b, Byte b2) {
        return y.a(this, b, b2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final /* synthetic */ z c() {
        return ae.a(this);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return b((Byte) obj, (Byte) obj2);
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
