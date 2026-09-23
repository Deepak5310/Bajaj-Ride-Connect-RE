package com.google.android.libraries.navigation.internal.abh;

import android.view.View;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cg extends com.google.android.libraries.navigation.internal.ly.bs {
    final /* synthetic */ ez a;
    final /* synthetic */ ed b;

    public cg(ez ezVar, ed edVar) {
        this.a = ezVar;
        this.b = edVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.bt
    public final void a() {
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        final ez ezVar = this.a;
        final ed edVar = this.b;
        executorA.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.cf
            @Override // java.lang.Runnable
            public final void run() {
                List listD = edVar.f().d();
                Map map = ezVar.d;
                for (es esVar : map.keySet()) {
                    if (listD.contains(esVar)) {
                        ((View) map.get(esVar)).setVisibility(0);
                    } else {
                        ((View) map.get(esVar)).setVisibility(4);
                    }
                }
            }
        });
    }
}
