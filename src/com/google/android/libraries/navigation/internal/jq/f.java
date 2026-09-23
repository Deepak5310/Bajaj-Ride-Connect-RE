package com.google.android.libraries.navigation.internal.jq;

import com.google.android.libraries.navigation.internal.ace.la;
import com.google.android.libraries.navigation.internal.ace.lb;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.p;
import com.google.android.libraries.navigation.internal.iz.m;
import com.google.android.libraries.navigation.internal.iz.n;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements d {
    public static final p a = new p("gm3_typography_client_param_enabled", ab.d);

    public f(final com.google.android.libraries.navigation.internal.afo.a aVar, final com.google.android.libraries.navigation.internal.iv.f fVar, n nVar, Executor executor) {
        nVar.d(new Runnable() { // from class: com.google.android.libraries.navigation.internal.jq.e
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.afo.a aVar2 = aVar;
                p pVar = f.a;
                la laVar = ((lb) aVar2.a()).b;
                if (laVar == null) {
                    laVar = la.a;
                }
                fVar.n(pVar, laVar.b);
            }
        }, executor, m.ON_STARTUP_FULLY_COMPLETE);
    }

    @Override // com.google.android.libraries.navigation.internal.jq.d
    public final boolean a() {
        return false;
    }
}
