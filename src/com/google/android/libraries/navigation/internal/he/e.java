package com.google.android.libraries.navigation.internal.he;

import com.google.android.libraries.navigation.internal.hm.o;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.ia.k;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends k {
    public e(Class cls, c cVar, ap apVar) {
        super(cls, cVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        c cVar = (c) this.c;
        o oVar = (o) aVar;
        synchronized (cVar.a) {
            d dVar = cVar.a;
            final com.google.android.libraries.navigation.internal.hm.f fVar = oVar.a;
            Objects.requireNonNull(fVar);
            dVar.a = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.hm.m
                /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.libraries.navigation.internal.fz.d, com.google.android.libraries.navigation.internal.hm.f] */
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return com.google.android.libraries.navigation.internal.fz.b.e(fVar);
                }
            };
            d dVar2 = cVar.a;
            dVar2.b = null;
            dVar2.c = null;
        }
    }
}
