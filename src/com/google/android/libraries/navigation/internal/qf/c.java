package com.google.android.libraries.navigation.internal.qf;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.fq.i;
import com.google.android.libraries.navigation.internal.fq.j;
import com.google.android.libraries.navigation.internal.fq.k;
import com.google.android.libraries.navigation.internal.nw.e;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends k {
    public long c;
    public int d;
    final /* synthetic */ d e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, int i) {
        super(Integer.MAX_VALUE);
        this.e = dVar;
        this.c = 0L;
        this.d = i;
    }

    @Override // com.google.android.libraries.navigation.internal.fq.k
    protected final /* bridge */ /* synthetic */ void n(Object obj, Object obj2) {
        b bVar = (b) obj2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = e.b("onEject");
        try {
            d dVar = this.e;
            dVar.a -= bVar.b;
            dVar.b -= bVar.c;
            com.google.android.libraries.navigation.internal.qi.e eVar = bVar.a;
            if (eVar != null) {
                dVar.c--;
                eVar.s();
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fq.k
    protected final /* bridge */ /* synthetic */ void o(Object obj, Object obj2) {
        com.google.android.libraries.navigation.internal.qi.e eVar;
        b bVar = (b) obj2;
        if (bVar == null || (eVar = bVar.a) == null) {
            return;
        }
        eVar.p();
    }

    @Override // com.google.android.libraries.navigation.internal.fq.k
    protected final /* bridge */ /* synthetic */ void p(Object obj, Object obj2) {
        com.google.android.libraries.navigation.internal.qi.e eVar = ((b) obj2).a;
        if (eVar != null) {
            eVar.p();
        }
    }

    public final j s() {
        i iVar = new i(this.a);
        if (iVar.hasNext()) {
            return iVar.next();
        }
        return null;
    }
}
