package com.google.android.libraries.navigation.internal.mf;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.le.aq;
import com.google.android.libraries.navigation.internal.le.ar;
import com.google.android.libraries.navigation.internal.le.bb;
import com.google.android.libraries.navigation.internal.le.bd;
import com.google.android.libraries.navigation.internal.le.bi;
import com.google.android.libraries.navigation.internal.me.aa;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends com.google.android.libraries.navigation.internal.ld.o implements w {
    public n(Context context, t tVar) {
        super(context, u.a, tVar, com.google.android.libraries.navigation.internal.ld.n.a);
    }

    @Override // com.google.android.libraries.navigation.internal.mf.w
    public final com.google.android.libraries.navigation.internal.me.w a() {
        bi biVar = new bi();
        biVar.a = new bd() { // from class: com.google.android.libraries.navigation.internal.mf.j
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.libraries.navigation.internal.mg.f) ((com.google.android.libraries.navigation.internal.mg.m) obj).u()).e(new k((aa) obj2));
            }
        };
        biVar.c = 4501;
        return g(biVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.mf.w
    public final void b(v vVar) {
        final aq aqVarB = ar.b(vVar, this.h, "v");
        final com.google.android.libraries.navigation.internal.mg.l lVar = ((t) this.f).b;
        bd bdVar = new bd() { // from class: com.google.android.libraries.navigation.internal.mf.h
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                com.google.android.libraries.navigation.internal.mg.l lVar2 = new com.google.android.libraries.navigation.internal.mg.l(aqVarB);
                ((com.google.android.libraries.navigation.internal.mg.m) obj).G(lVar, lVar2, new l(this.a, (aa) obj2, lVar2));
            }
        };
        bd bdVar2 = new bd() { // from class: com.google.android.libraries.navigation.internal.mf.i
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                n nVar = this.a;
                ((com.google.android.libraries.navigation.internal.mg.m) obj).G(((t) nVar.f).b, null, new m(nVar, (aa) obj2));
            }
        };
        bb bbVar = new bb();
        bbVar.a = bdVar;
        bbVar.b = bdVar2;
        bbVar.c = aqVarB;
        bbVar.d = new com.google.android.libraries.navigation.internal.lc.d[]{g.a};
        bbVar.f = 4507;
        h(bbVar.a());
    }
}
