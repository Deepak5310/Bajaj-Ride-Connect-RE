package com.google.android.libraries.navigation.internal.agj;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d extends g implements RandomAccess {
    private static final long serialVersionUID = -107070782945191929L;

    public d(am amVar, int i, int i2) {
        super(amVar, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.g, com.google.android.libraries.navigation.internal.agj.h
    /* JADX INFO: renamed from: j */
    public final am subList(int i, int i2) {
        C(i);
        C(i2);
        if (i <= i2) {
            return new d(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.g, com.google.android.libraries.navigation.internal.agj.h, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
