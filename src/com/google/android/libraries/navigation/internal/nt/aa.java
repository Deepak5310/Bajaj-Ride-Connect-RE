package com.google.android.libraries.navigation.internal.nt;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa {
    public final Executor a;
    public final u b;
    public final ab c;
    public volatile boolean d = false;

    public aa(u uVar, Executor executor, ab abVar) {
        this.b = uVar;
        this.a = executor;
        this.c = abVar;
    }

    final void a() {
        this.d = true;
    }

    final void b(final s sVar) {
        this.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.nt.v
            @Override // java.lang.Runnable
            public final void run() {
                aa aaVar = this.a;
                if (aaVar.d) {
                    return;
                }
                s sVar2 = sVar;
                sVar2.q(true);
                try {
                    aaVar.c.b(aaVar.b, sVar2);
                } finally {
                    sVar2.q(false);
                }
            }
        });
    }
}
