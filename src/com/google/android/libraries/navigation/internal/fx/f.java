package com.google.android.libraries.navigation.internal.fx;

import com.google.android.libraries.navigation.internal.xe.dy;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f {
    final /* synthetic */ i a;

    public f(i iVar) {
        this.a = iVar;
    }

    public final void a(short s) {
        synchronized (this.a) {
            Future future = this.a.i;
            if (future != null) {
                future.cancel(true);
            }
            i iVar = this.a;
            iVar.o = s;
            dy dyVar = iVar.q;
            if (dyVar != null) {
                dyVar.a();
            }
        }
    }

    public final void b() {
        i iVar = this.a;
        iVar.d(Math.min(i.d, (long) ((i.c * Math.pow(1.6d, iVar.k)) + (iVar.j.nextDouble() * i.e))));
        iVar.k++;
    }

    public final void c(String str, long j) {
        i iVar = this.a;
        iVar.l = -1L;
        long epochMilli = iVar.h.f().plusMillis(j).toEpochMilli();
        this.a.e(str, epochMilli, j);
        i iVar2 = this.a;
        iVar2.m.c(iVar2.g, str, epochMilli);
    }
}
