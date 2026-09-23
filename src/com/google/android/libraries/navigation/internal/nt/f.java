package com.google.android.libraries.navigation.internal.nt;

import com.google.android.libraries.navigation.internal.aac.al;
import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.yx.am;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private final Executor b;
    private final al c = new al();
    public final d a = new d(null);

    public f(Executor executor) {
        this.b = executor;
    }

    public final synchronized void a(final Object obj) {
        this.c.a(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.nt.e
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final bj a() {
                f fVar = this.a;
                d dVar = fVar.a;
                Object obj2 = obj;
                return !am.a(dVar.f(obj2), obj2) ? fVar.a.e() : be.a;
            }
        }, this.b);
    }
}
