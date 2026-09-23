package com.google.android.libraries.navigation.internal.yj;

import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.afr.g;
import com.google.android.libraries.navigation.internal.afr.p;
import com.google.android.libraries.navigation.internal.yh.au;
import com.google.android.libraries.navigation.internal.yh.q;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;

    public c(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Executor executor = (Executor) this.a.a();
        com.google.android.libraries.navigation.internal.xy.f fVar = (com.google.android.libraries.navigation.internal.xy.f) this.b.a();
        Object obj = ((g) this.d).a;
        Set setA = ((p) this.c).a();
        an anVar = (an) obj;
        an anVar2 = (an) ((g) this.e).a;
        q qVar = new q();
        qVar.a = executor;
        qVar.b = fVar;
        if (anVar.g()) {
            com.google.android.libraries.navigation.internal.yl.a aVar = (com.google.android.libraries.navigation.internal.yl.a) anVar.c();
            com.google.android.libraries.navigation.internal.yn.a aVar2 = (com.google.android.libraries.navigation.internal.yn.a) anVar2.f();
            qVar.d = aVar;
            qVar.c = aVar2;
        }
        ev evVarO = ev.o(setA);
        int size = evVarO.size();
        for (int i = 0; i < size; i++) {
            qVar.b((au) evVarO.get(i));
        }
        return qVar.a();
    }
}
