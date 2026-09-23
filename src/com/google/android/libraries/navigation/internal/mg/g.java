package com.google.android.libraries.navigation.internal.mg;

import com.google.android.libraries.navigation.internal.ld.ab;
import com.google.android.libraries.navigation.internal.ld.y;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.mf.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements y {
    public final x a;
    private final ab b;

    public g(ab abVar, x xVar) {
        this.b = abVar;
        this.a = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ld.y
    public final ab a() {
        throw null;
    }

    public final String toString() {
        be.j(this.a);
        return String.format("OptInOptionsResultImpl[%s]", Boolean.valueOf(this.a.a == 1));
    }
}
