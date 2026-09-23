package com.google.android.libraries.navigation.internal.agh;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class q extends t implements RandomAccess {
    private static final long serialVersionUID = -107070782945191929L;

    public q(gy gyVar, int i, int i2) {
        super(gyVar, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.t, com.google.android.libraries.navigation.internal.agh.u
    /* JADX INFO: renamed from: l */
    public final gy subList(int i, int i2) {
        E(i);
        E(i2);
        if (i <= i2) {
            return new q(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agh.t, com.google.android.libraries.navigation.internal.agh.u, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
