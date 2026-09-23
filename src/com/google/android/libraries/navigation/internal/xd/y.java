package com.google.android.libraries.navigation.internal.xd;

import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements com.google.android.libraries.navigation.internal.hk.a, com.google.android.libraries.navigation.internal.wx.c {
    private final com.google.android.libraries.navigation.internal.hk.a a;
    private final com.google.android.libraries.navigation.internal.wx.b b;
    private final com.google.android.libraries.navigation.internal.wx.a c = new com.google.android.libraries.navigation.internal.wx.a();
    private final Executor d;

    public y(com.google.android.libraries.navigation.internal.hk.a aVar, com.google.android.libraries.navigation.internal.wx.b bVar, Executor executor) {
        this.a = aVar;
        this.b = bVar;
        this.d = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.wx.c
    public final bj a() {
        return com.google.android.libraries.navigation.internal.afw.a.c() ? com.google.android.libraries.navigation.internal.aac.j.h(this.b.a(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.xd.x
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                String str = (String) obj;
                if (!str.isEmpty()) {
                    return str;
                }
                com.google.android.libraries.navigation.internal.aeq.b bVar = this.a.c().c;
                if (bVar == null) {
                    bVar = com.google.android.libraries.navigation.internal.aeq.b.a;
                }
                return bVar.d;
            }
        }, this.d) : this.c.a();
    }

    @Override // com.google.android.libraries.navigation.internal.wx.c
    public final void b(String str) {
        if (com.google.android.libraries.navigation.internal.afw.a.c()) {
            this.b.b(str);
        } else {
            this.c.b(str);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hk.a
    public final com.google.android.libraries.navigation.internal.aeq.d c() {
        com.google.android.libraries.navigation.internal.aeq.d dVarC = this.a.c();
        if (!com.google.android.libraries.navigation.internal.afw.a.c()) {
            return dVarC;
        }
        try {
            String str = (String) ((be) this.b.a()).b;
            if (str.isEmpty()) {
                return dVarC;
            }
            bb bbVar = (bb) dVarC.aH(5, null);
            bbVar.x(dVarC);
            com.google.android.libraries.navigation.internal.aeq.c cVar = (com.google.android.libraries.navigation.internal.aeq.c) bbVar;
            com.google.android.libraries.navigation.internal.aeq.b bVar = dVarC.c;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.aeq.b.a;
            }
            bb bbVar2 = (bb) bVar.aH(5, null);
            bbVar2.x(bVar);
            com.google.android.libraries.navigation.internal.aeq.a aVar = (com.google.android.libraries.navigation.internal.aeq.a) bbVar2;
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.aeq.b bVar2 = (com.google.android.libraries.navigation.internal.aeq.b) aVar.b;
            str.getClass();
            bVar2.b |= 2;
            bVar2.d = str;
            if (!cVar.b.H()) {
                cVar.v();
            }
            com.google.android.libraries.navigation.internal.aeq.d dVar = (com.google.android.libraries.navigation.internal.aeq.d) cVar.b;
            com.google.android.libraries.navigation.internal.aeq.b bVar3 = (com.google.android.libraries.navigation.internal.aeq.b) aVar.t();
            bVar3.getClass();
            dVar.c = bVar3;
            dVar.b |= 1;
            return (com.google.android.libraries.navigation.internal.aeq.d) cVar.t();
        } catch (InterruptedException | ExecutionException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1981)).p("Wasn't able to retrieve zb cookie");
            return dVarC;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hk.a
    public final boolean d(an anVar, com.google.android.libraries.navigation.internal.aeq.d dVar) {
        if (com.google.android.libraries.navigation.internal.afw.a.c()) {
            com.google.android.libraries.navigation.internal.aeq.b bVar = dVar.c;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.aeq.b.a;
            }
            String str = bVar.d;
            if (!str.isEmpty()) {
                b(str);
            }
        }
        return this.a.d(anVar, dVar);
    }
}
