package com.google.android.libraries.navigation.environment;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ca implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public ca(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Runnable a() {
        final com.google.android.libraries.navigation.internal.hs.d dVar = (com.google.android.libraries.navigation.internal.hs.d) this.a.a();
        Objects.requireNonNull(dVar);
        return new Runnable() { // from class: com.google.android.libraries.navigation.environment.bc
            @Override // java.lang.Runnable
            public final void run() {
                dVar.a();
            }
        };
    }
}
