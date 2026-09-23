package com.google.android.libraries.navigation.internal.agd;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements Serializable, z {
    private static final long serialVersionUID = 1;

    protected ad() {
    }

    private Object readResolve() {
        return ae.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final int a(byte b, byte b2) {
        return -Byte.compare(b, b2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int compare(Byte b, Byte b2) {
        return y.a(this, b, b2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final z c() {
        return ae.a;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return compare((Byte) obj, (Byte) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.z
    public final /* synthetic */ z d(z zVar) {
        return new x(this, zVar);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator reversed() {
        return ae.a;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return y.d(this, comparator);
    }
}
