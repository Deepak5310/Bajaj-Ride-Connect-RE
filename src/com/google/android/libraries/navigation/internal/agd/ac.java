package com.google.android.libraries.navigation.internal.agd;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac implements Serializable, z {
    private static final long serialVersionUID = 1;
    final z a;

    protected ac(z zVar) {
        this.a = zVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final int a(byte b, byte b2) {
        return this.a.a(b2, b);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final /* synthetic */ int b(Byte b, Byte b2) {
        return y.a(this, b, b2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final z c() {
        return this.a;
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
    public final /* synthetic */ Comparator reversed() {
        return this.a;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return y.d(this, comparator);
    }
}
