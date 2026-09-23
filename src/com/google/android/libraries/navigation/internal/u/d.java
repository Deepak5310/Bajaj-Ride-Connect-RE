package com.google.android.libraries.navigation.internal.u;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.db.s;
import com.google.android.libraries.navigation.internal.hm.o;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.hx.q;
import com.google.android.libraries.navigation.internal.hx.r;
import com.google.android.libraries.navigation.internal.oa.k;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final c b;
    public final AtomicBoolean c = new AtomicBoolean(false);
    private final k d;

    public d(com.google.android.libraries.navigation.internal.ia.e eVar, k kVar, Optional optional) {
        this.a = eVar;
        this.d = kVar;
        this.b = new c(kVar, optional);
    }

    public final void a() {
        q qVar = new q() { // from class: com.google.android.libraries.navigation.internal.u.a
            @Override // com.google.android.libraries.navigation.internal.hx.q
            public final void a(Object obj) {
                fz fzVar = new fz();
                d dVar = this.a;
                c cVar = dVar.b;
                fzVar.b(com.google.android.libraries.navigation.internal.n.a.class, new e(0, com.google.android.libraries.navigation.internal.n.a.class, cVar, ap.DANGEROUS_PUBLISHER_THREAD));
                fzVar.b(com.google.android.libraries.navigation.internal.ql.b.class, new e(1, com.google.android.libraries.navigation.internal.ql.b.class, cVar, ap.UI_THREAD));
                fzVar.b(com.google.android.libraries.navigation.internal.iz.c.class, new e(2, com.google.android.libraries.navigation.internal.iz.c.class, cVar, ap.DANGEROUS_PUBLISHER_THREAD));
                fzVar.b(o.class, new e(3, o.class, cVar, ap.DANGEROUS_PUBLISHER_THREAD));
                fzVar.b(s.class, new e(4, s.class, cVar, ap.UI_THREAD));
                dVar.a.c(cVar, fzVar.a());
                dVar.c.set(true);
            }
        };
        ac acVar = ac.INSTANCE;
        com.google.android.libraries.navigation.internal.yu.c.d(this.d.d, new r(qVar), acVar);
    }

    public final void b() {
        if (this.c.compareAndSet(true, false)) {
            this.a.e(this.b);
        }
    }
}
