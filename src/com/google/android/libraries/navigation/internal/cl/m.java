package com.google.android.libraries.navigation.internal.cl;

import com.google.android.libraries.navigation.internal.adr.cf;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends bf {
    public com.google.android.libraries.navigation.internal.ol.aq a;
    public com.google.android.libraries.navigation.internal.oo.f b;
    private cf c;

    @Override // com.google.android.libraries.navigation.internal.cl.bf
    public final bg a() {
        cf cfVar = this.c;
        if (cfVar != null) {
            return new n(cfVar, this.a, this.b);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.cl.bf
    public final void b(cf cfVar) {
        Objects.requireNonNull(cfVar);
        this.c = cfVar;
    }
}
