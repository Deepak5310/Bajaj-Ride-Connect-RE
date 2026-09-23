package com.google.android.libraries.navigation.internal.cr;

import com.google.android.libraries.navigation.internal.op.g;
import com.google.android.libraries.navigation.internal.ot.q;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class e {
    static e d(com.google.android.libraries.navigation.internal.op.f fVar) {
        g gVarA = fVar.a();
        Objects.requireNonNull(gVarA);
        return new a(gVarA);
    }

    static e e(q qVar) {
        com.google.android.libraries.navigation.internal.or.c cVarA = qVar.a();
        Objects.requireNonNull(cVarA);
        return new b(cVarA);
    }

    public abstract g a();

    public abstract int b();

    public abstract com.google.android.libraries.navigation.internal.or.c c();
}
