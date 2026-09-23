package com.google.android.libraries.navigation.internal.st;

import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.ia.k;
import com.google.android.libraries.navigation.internal.sr.i;
import com.google.android.libraries.navigation.internal.sr.p;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends k {
    private final int f;

    public d(int i, Class cls, b bVar, ap apVar, Executor executor) {
        super(cls, bVar, apVar, executor);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        int i = this.f;
        if (i == 0) {
            b bVar = (b) this.c;
            bVar.a.d = ((com.google.android.libraries.navigation.internal.cw.d) aVar).c;
            bVar.f();
            return;
        }
        if (i != 1) {
            ((b) this.c).b.c(((i) aVar).a);
            return;
        }
        b bVar2 = (b) this.c;
        p pVar = (p) aVar;
        if (bVar2.c.a().a()) {
            return;
        }
        bVar2.d.a(bVar2.b, pVar).f();
    }
}
