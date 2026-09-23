package com.google.android.libraries.navigation.internal.pu;

import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bl implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public bl(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        final com.google.android.libraries.navigation.internal.agl.a aVar = this.a;
        Objects.requireNonNull(aVar);
        return new com.google.android.libraries.navigation.internal.pg.g(new br() { // from class: com.google.android.libraries.navigation.internal.pu.ba
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return (ct) aVar.a();
            }
        });
    }
}
