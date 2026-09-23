package com.google.android.libraries.navigation.internal.uc;

import com.google.android.libraries.navigation.internal.afl.ff;
import com.google.android.libraries.navigation.internal.zs.aq;
import com.google.android.libraries.navigation.internal.zs.ar;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends m {
    private ff a;
    private ar b;
    private aq c;
    private com.google.android.libraries.navigation.internal.pd.i d;

    @Override // com.google.android.libraries.navigation.internal.uc.m
    public final n a() {
        if (this.a == null || this.b == null || this.c == null || this.d == null) {
            throw new IllegalStateException();
        }
        return new d(this.a, this.b, this.c, this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.uc.m
    public final void b(ar arVar) {
        Objects.requireNonNull(arVar);
        this.b = arVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.m
    public final void c(ff ffVar) {
        Objects.requireNonNull(ffVar);
        this.a = ffVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.m
    public final void d(aq aqVar) {
        Objects.requireNonNull(aqVar);
        this.c = aqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.m
    public final void e(com.google.android.libraries.navigation.internal.pd.i iVar) {
        Objects.requireNonNull(iVar);
        this.d = iVar;
    }
}
