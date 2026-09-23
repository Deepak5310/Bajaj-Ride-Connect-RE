package com.google.android.libraries.navigation.internal.agg;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k extends n implements RandomAccess {
    private static final long serialVersionUID = -107070782945191929L;

    public k(es esVar, int i, int i2) {
        super(esVar, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.n, com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: m */
    public final es subList(int i, int i2) {
        F(i);
        F(i2);
        if (i <= i2) {
            return new k(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agg.n, com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
