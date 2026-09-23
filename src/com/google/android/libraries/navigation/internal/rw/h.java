package com.google.android.libraries.navigation.internal.rw;

import com.google.android.libraries.navigation.internal.add.ag;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends a {
    public com.google.android.libraries.navigation.internal.tj.j a;
    public com.google.android.libraries.navigation.internal.tj.h b;
    private ag c;
    private u d;
    private p e;

    @Override // com.google.android.libraries.navigation.internal.rw.a
    public final b a() {
        u uVar;
        p pVar;
        ag agVar = this.c;
        if (agVar == null || (uVar = this.d) == null || (pVar = this.e) == null) {
            throw new IllegalStateException();
        }
        return new i(agVar, uVar, pVar, this.a, this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.rw.a
    public final void b(p pVar) {
        Objects.requireNonNull(pVar);
        this.e = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.a
    public final void c(ag agVar) {
        Objects.requireNonNull(agVar);
        this.c = agVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.a
    public final void d(u uVar) {
        Objects.requireNonNull(uVar);
        this.d = uVar;
    }
}
