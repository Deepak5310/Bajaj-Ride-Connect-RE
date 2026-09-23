package com.google.android.libraries.navigation.internal.ot;

import com.google.android.libraries.navigation.internal.adg.jr;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends f {
    private jr a;

    @Override // com.google.android.libraries.navigation.internal.ot.f
    public final g a() {
        if (this.a != null) {
            return new b(this.a);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.ot.f
    public final void b(jr jrVar) {
        Objects.requireNonNull(jrVar);
        this.a = jrVar;
    }
}
