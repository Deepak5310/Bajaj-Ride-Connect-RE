package com.google.android.libraries.navigation.internal.rz;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends ac {
    private ad a;

    @Override // com.google.android.libraries.navigation.internal.rz.ac
    public final ae a() {
        ad adVar = this.a;
        if (adVar != null) {
            return new j(adVar);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ac
    public final void b(ad adVar) {
        Objects.requireNonNull(adVar);
        this.a = adVar;
    }
}
