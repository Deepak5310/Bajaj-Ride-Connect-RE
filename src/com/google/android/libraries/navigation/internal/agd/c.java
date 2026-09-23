package com.google.android.libraries.navigation.internal.agd;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c extends f implements RandomAccess {
    private static final long serialVersionUID = -107070782945191929L;

    public c(ao aoVar, int i, int i2) {
        super(aoVar, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.f, com.google.android.libraries.navigation.internal.agd.h
    /* JADX INFO: renamed from: k */
    public final ao subList(int i, int i2) {
        D(i);
        D(i2);
        if (i <= i2) {
            return new c(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.f, com.google.android.libraries.navigation.internal.agd.h, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
