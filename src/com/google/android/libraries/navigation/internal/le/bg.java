package com.google.android.libraries.navigation.internal.le;

import android.content.Context;
import android.os.Handler;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bg extends com.google.android.libraries.navigation.internal.md.c implements com.google.android.libraries.navigation.internal.ld.q, com.google.android.libraries.navigation.internal.ld.r {
    private static final com.google.android.libraries.navigation.internal.ld.a h = com.google.android.libraries.navigation.internal.mc.d.c;
    public final Context a;
    public final Handler b;
    public final com.google.android.libraries.navigation.internal.ld.a c;
    public final Set d;
    public final com.google.android.libraries.navigation.internal.lh.p e;
    public com.google.android.libraries.navigation.internal.mc.e f;
    public ah g;

    public bg(Context context, Handler handler, com.google.android.libraries.navigation.internal.lh.p pVar) {
        com.google.android.libraries.navigation.internal.ld.a aVar = h;
        this.a = context;
        this.b = handler;
        this.e = pVar;
        this.d = pVar.b;
        this.c = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.le.r
    public final void a(int i) {
        ah ahVar = this.g;
        ae aeVar = (ae) ahVar.f.m.get(ahVar.b);
        if (aeVar != null) {
            if (aeVar.f) {
                aeVar.l(new com.google.android.libraries.navigation.internal.lc.a(17));
            } else {
                aeVar.a(i);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.le.r
    public final void b() {
        this.f.s(this);
    }

    @Override // com.google.android.libraries.navigation.internal.md.c, com.google.android.libraries.navigation.internal.md.e
    public final void c(com.google.android.libraries.navigation.internal.md.m mVar) {
        this.b.post(new bf(this, mVar));
    }

    @Override // com.google.android.libraries.navigation.internal.le.au
    public final void i(com.google.android.libraries.navigation.internal.lc.a aVar) {
        this.g.b(aVar);
    }
}
