package com.google.android.libraries.navigation.internal.hm;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@com.google.android.libraries.navigation.internal.ib.a
@Deprecated
public final class o implements com.google.android.libraries.navigation.internal.ic.a {
    public final f a;

    public o(f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ic.a
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ic.a
    public final /* synthetic */ boolean aj() {
        return false;
    }

    @Deprecated
    public final com.google.android.libraries.navigation.internal.agl.a c() {
        final f fVar = this.a;
        Objects.requireNonNull(fVar);
        return new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.hm.n
            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.libraries.navigation.internal.fz.d, com.google.android.libraries.navigation.internal.hm.f] */
            @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
            public final Object a() {
                return com.google.android.libraries.navigation.internal.fz.b.b(fVar);
            }
        };
    }
}
