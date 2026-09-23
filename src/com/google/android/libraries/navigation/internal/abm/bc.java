package com.google.android.libraries.navigation.internal.abm;

import com.google.android.libraries.navigation.internal.abh.ee;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public bc(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        final com.google.android.libraries.navigation.internal.oo.a aVar = (com.google.android.libraries.navigation.internal.oo.a) this.a.a();
        Objects.requireNonNull(aVar);
        return new ee() { // from class: com.google.android.libraries.navigation.internal.abm.av
            @Override // java.lang.Runnable
            public final void run() {
                aVar.l();
            }
        };
    }
}
