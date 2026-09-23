package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends l {
    private int a;
    private ev b;
    private byte c;

    @Override // com.google.android.libraries.navigation.internal.cq.l
    public final m a() {
        ev evVar;
        if (this.c != 1 || (evVar = this.b) == null) {
            throw new IllegalStateException();
        }
        return new d(this.a, evVar);
    }

    @Override // com.google.android.libraries.navigation.internal.cq.l
    public final void b(ev evVar) {
        Objects.requireNonNull(evVar);
        this.b = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.l
    public final void c(int i) {
        this.a = i;
        this.c = (byte) 1;
    }
}
