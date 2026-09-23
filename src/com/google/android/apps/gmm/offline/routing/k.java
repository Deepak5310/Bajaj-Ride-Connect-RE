package com.google.android.apps.gmm.offline.routing;

import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public k(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final br a() {
        final br brVar = (br) this.a.a();
        Objects.requireNonNull(brVar);
        return new br() { // from class: com.google.android.apps.gmm.offline.routing.j
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return (m) brVar.a();
            }
        };
    }
}
