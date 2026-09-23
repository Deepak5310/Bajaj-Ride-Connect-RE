package com.google.android.libraries.navigation.internal.hr;

import android.content.Context;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.bn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final com.google.android.libraries.navigation.internal.agl.a i;
    private final com.google.android.libraries.navigation.internal.agl.a j;

    public t(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
        this.j = aVar10;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) this.a.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.c);
        com.google.android.libraries.navigation.internal.afo.a aVarC2 = com.google.android.libraries.navigation.internal.afr.e.c(this.d);
        com.google.android.libraries.navigation.internal.afo.a aVarC3 = com.google.android.libraries.navigation.internal.afr.e.c(this.e);
        com.google.android.libraries.navigation.internal.afo.a aVarC4 = com.google.android.libraries.navigation.internal.afr.e.c(this.f);
        com.google.android.libraries.navigation.internal.afr.e.c(this.g);
        com.google.android.libraries.navigation.internal.hm.d dVar = (com.google.android.libraries.navigation.internal.hm.d) this.h.a();
        com.google.android.libraries.navigation.internal.ip.a aVarA = ((com.google.android.libraries.navigation.internal.ip.b) this.i).a();
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.b) this.j).a();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("create ClientParametersFetcher");
        try {
            b bVar = new b(context, aVarC, aVarC2, aVarC3, aVarC4, dVar, aVarA, bnVarA);
            if (dVarB != null) {
                Trace.endSection();
            }
            return bVar;
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
}
