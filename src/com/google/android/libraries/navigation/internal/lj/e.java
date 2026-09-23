package com.google.android.libraries.navigation.internal.lj;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.ld.j;
import com.google.android.libraries.navigation.internal.ld.k;
import com.google.android.libraries.navigation.internal.ld.n;
import com.google.android.libraries.navigation.internal.ld.o;
import com.google.android.libraries.navigation.internal.le.bd;
import com.google.android.libraries.navigation.internal.le.bi;
import com.google.android.libraries.navigation.internal.lh.bn;
import com.google.android.libraries.navigation.internal.lh.bp;
import com.google.android.libraries.navigation.internal.lh.bq;
import com.google.android.libraries.navigation.internal.me.aa;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends o implements bp {
    private static final j a;
    private static final com.google.android.libraries.navigation.internal.ld.a l;
    private static final k m;

    static {
        j jVar = new j();
        a = jVar;
        d dVar = new d();
        l = dVar;
        m = new k("ClientTelemetry.API", dVar, jVar);
    }

    public e(Context context, bq bqVar) {
        super(context, m, bqVar, n.a);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.bp
    public final void a(final bn bnVar) {
        bi biVar = new bi();
        biVar.b = new com.google.android.libraries.navigation.internal.lc.d[]{com.google.android.libraries.navigation.internal.lb.a.a};
        biVar.b();
        biVar.a = new bd() { // from class: com.google.android.libraries.navigation.internal.lj.c
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                ((b) ((f) obj).u()).e(bnVar);
                ((aa) obj2).b(null);
            }
        };
        f(biVar.a());
    }
}
