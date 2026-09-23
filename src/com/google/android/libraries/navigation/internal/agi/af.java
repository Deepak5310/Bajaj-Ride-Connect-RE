package com.google.android.libraries.navigation.internal.agi;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class af extends ai implements RandomAccess {
    private static final long serialVersionUID = -107070782945191929L;

    public af(la laVar, int i, int i2) {
        super(laVar, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ai, com.google.android.libraries.navigation.internal.agi.aj
    /* JADX INFO: renamed from: c */
    public final la subList(int i, int i2) {
        j(i);
        j(i2);
        if (i <= i2) {
            return new af(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ai, com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
