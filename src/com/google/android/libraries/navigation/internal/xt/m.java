package com.google.android.libraries.navigation.internal.xt;

import com.google.android.libraries.navigation.internal.yz.mb;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m implements com.google.android.libraries.navigation.internal.ky.m {
    public final j a;

    public m(j jVar) {
        this.a = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.m
    public final com.google.android.libraries.navigation.internal.ky.n a(final com.google.android.libraries.navigation.internal.ky.n nVar) {
        if (nVar.a.c()) {
            return nVar;
        }
        n.a(nVar, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.xt.k
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                Set set = (Set) ((n) this.a.a).d.get(new com.google.android.libraries.navigation.internal.yx.ao(nVar.h, null));
                return set != null ? set : mb.a;
            }
        });
        com.google.android.libraries.navigation.internal.yx.br brVar = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.xt.l
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                Set set = (Set) ((n) this.a.a).e.get(nVar.h);
                return set != null ? set : mb.a;
            }
        };
        Objects.requireNonNull(this.a);
        n.a(nVar, brVar);
        return nVar;
    }
}
