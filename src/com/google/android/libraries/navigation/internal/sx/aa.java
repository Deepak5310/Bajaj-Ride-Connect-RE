package com.google.android.libraries.navigation.internal.sx;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ ab a;

    public aa(ab abVar) {
        this.a = abVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        com.google.android.libraries.navigation.internal.gg.b bVar;
        com.google.android.libraries.navigation.internal.gg.b bVar2;
        if ((th instanceof CancellationException) || (th instanceof InterruptedException)) {
            ab abVar = this.a;
            synchronized (abVar) {
                bVar = abVar.f;
                bVar2 = abVar.g;
            }
            if (bVar != null) {
                bVar.a();
            }
            if (bVar2 != null) {
                bVar2.a();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
    }
}
