package com.google.android.libraries.navigation.internal.bd;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends e {
    public boolean a;
    public byte b;
    private f c;
    private boolean d;
    private boolean e;

    @Override // com.google.android.libraries.navigation.internal.bd.e
    public final g a() {
        f fVar;
        if (this.b != 15 || (fVar = this.c) == null) {
            throw new IllegalStateException();
        }
        return new b(fVar, false, false, null, null, null, false, null);
    }

    @Override // com.google.android.libraries.navigation.internal.bd.e
    public final void b(boolean z) {
        this.d = false;
        this.b = (byte) (this.b | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.bd.e
    public final void c(f fVar) {
        Objects.requireNonNull(fVar);
        this.c = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.e
    public final void d(boolean z) {
        this.e = false;
        this.b = (byte) (this.b | 4);
    }
}
