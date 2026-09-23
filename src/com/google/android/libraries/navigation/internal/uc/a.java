package com.google.android.libraries.navigation.internal.uc;

import com.google.android.libraries.navigation.internal.afl.fd;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends h {
    private fd a;
    private boolean b;
    private boolean c;
    private byte d;

    @Override // com.google.android.libraries.navigation.internal.uc.h
    public final i a() {
        fd fdVar;
        if (this.d != 3 || (fdVar = this.a) == null) {
            throw new IllegalStateException();
        }
        return new b(fdVar, this.b, this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.uc.h
    public final void b(fd fdVar) {
        Objects.requireNonNull(fdVar);
        this.a = fdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.h
    public final void c(boolean z) {
        this.b = z;
        this.d = (byte) (this.d | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.uc.h
    public final void d(boolean z) {
        this.c = z;
        this.d = (byte) (this.d | 2);
    }
}
