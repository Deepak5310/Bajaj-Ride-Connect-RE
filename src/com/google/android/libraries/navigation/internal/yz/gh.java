package com.google.android.libraries.navigation.internal.yz;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gh extends fc {
    private static final long serialVersionUID = 0;
    private final Comparator a;

    public gh(gi giVar) {
        super(giVar);
        this.a = giVar.comparator();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fc
    public final /* bridge */ /* synthetic */ ez a(int i) {
        return new gg(this.a);
    }
}
