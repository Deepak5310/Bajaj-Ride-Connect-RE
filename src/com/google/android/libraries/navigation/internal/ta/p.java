package com.google.android.libraries.navigation.internal.ta;

import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public p(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.wd.g a() {
        com.google.android.libraries.navigation.internal.wd.g gVar = (com.google.android.libraries.navigation.internal.wd.g) ((com.google.android.libraries.navigation.environment.n) this.a).a().d(new br() { // from class: com.google.android.libraries.navigation.internal.ta.h
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return new com.google.android.libraries.navigation.internal.wd.b();
            }
        });
        com.google.android.libraries.navigation.internal.afr.j.d(gVar);
        return gVar;
    }
}
