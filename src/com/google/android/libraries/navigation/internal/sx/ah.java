package com.google.android.libraries.navigation.internal.sx;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.b a;
    final /* synthetic */ ai b;

    public ah(ai aiVar, com.google.android.libraries.navigation.internal.gg.b bVar) {
        this.a = bVar;
        this.b = aiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        if ((th instanceof CancellationException) || (th instanceof InterruptedException)) {
            ai aiVar = this.b;
            aiVar.g.a(e.a(q.f, s.CANCELED));
            this.a.a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
    }
}
