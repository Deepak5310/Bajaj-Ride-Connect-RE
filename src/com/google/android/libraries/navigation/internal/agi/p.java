package com.google.android.libraries.navigation.internal.agi;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class p extends s implements RandomAccess {
    private static final long serialVersionUID = -107070782945191929L;

    public p(gu guVar, int i, int i2) {
        super(guVar, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.s, com.google.android.libraries.navigation.internal.agi.t
    /* JADX INFO: renamed from: a */
    public final gu subList(int i, int i2) {
        k(i);
        k(i2);
        if (i <= i2) {
            return new p(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.s, com.google.android.libraries.navigation.internal.agi.t, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
