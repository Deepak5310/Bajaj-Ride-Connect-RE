package com.google.android.libraries.navigation.internal.kd;

import com.google.android.libraries.navigation.internal.zp.ce;
import com.google.android.libraries.navigation.internal.zr.cg;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends k {
    public cg a;
    private ce b;

    @Override // com.google.android.libraries.navigation.internal.kd.k
    public final l a() {
        ce ceVar = this.b;
        if (ceVar != null) {
            return new e(ceVar, this.a);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.kd.k
    public final void b(ce ceVar) {
        Objects.requireNonNull(ceVar);
        this.b = ceVar;
    }
}
