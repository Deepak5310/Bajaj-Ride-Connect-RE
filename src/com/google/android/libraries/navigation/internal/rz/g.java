package com.google.android.libraries.navigation.internal.rz;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends y {
    private z a;
    private aa b;
    private boolean c;
    private byte d;

    @Override // com.google.android.libraries.navigation.internal.rz.y
    public final ab a() {
        z zVar;
        aa aaVar;
        if (this.d != 1 || (zVar = this.a) == null || (aaVar = this.b) == null) {
            throw new IllegalStateException();
        }
        return new h(zVar, aaVar, this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.rz.y
    public final void b(boolean z) {
        this.c = z;
        this.d = (byte) 1;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.y
    public final void c(z zVar) {
        Objects.requireNonNull(zVar);
        this.a = zVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.y
    public final void d(aa aaVar) {
        Objects.requireNonNull(aaVar);
        this.b = aaVar;
    }
}
