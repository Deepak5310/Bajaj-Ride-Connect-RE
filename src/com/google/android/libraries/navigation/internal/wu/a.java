package com.google.android.libraries.navigation.internal.wu;

import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.me.aa;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements as {
    final /* synthetic */ aa a;
    final /* synthetic */ bj b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.me.d c;

    public a(aa aaVar, bj bjVar, com.google.android.libraries.navigation.internal.me.d dVar) {
        this.a = aaVar;
        this.b = bjVar;
        this.c = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        if (this.b.isCancelled()) {
            this.c.a.a.o(null);
        } else if (th instanceof Exception) {
            this.a.a((Exception) th);
        } else {
            this.a.a(new ExecutionException(th));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void b(Object obj) {
        this.a.b(obj);
    }
}
