package com.google.android.libraries.navigation.internal.us;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afl.hv;
import com.google.android.libraries.navigation.internal.sv.bk;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ac extends y<com.google.android.libraries.navigation.internal.tj.y> {
    private final bk x;
    private final com.google.android.libraries.navigation.internal.tj.ae y;

    public ac(Context context, com.google.android.libraries.navigation.internal.tj.y yVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.sl.d dVar2, com.google.android.libraries.navigation.internal.sn.h hVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, com.google.android.libraries.navigation.internal.ch.b bVar, bk bkVar, com.google.android.libraries.navigation.internal.tj.ae aeVar) {
        super(yVar, context, eVar, dVar, dVar2, hVar, context.getResources(), aVar, afVar, tVar, bnVar, executor, mVar, bVar);
        this.x = bkVar;
        this.y = aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    protected final com.google.android.libraries.navigation.internal.vn.d a() {
        return this.y.a(((com.google.android.libraries.navigation.internal.tj.y) this.a).a);
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public void b() {
        super.b();
        com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
        com.google.android.libraries.navigation.internal.tt.d dVar = ((com.google.android.libraries.navigation.internal.tj.y) this.a).a;
        xVar.b = dVar.r();
        com.google.android.libraries.navigation.internal.jy.x xVarA = xVar.a(dVar.B());
        xVarA.d = hv.DIRECTIONS;
        xVarA.i = com.google.android.libraries.navigation.internal.afe.i.d;
        this.q = xVarA.b();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    public void d() {
        this.x.a(((com.google.android.libraries.navigation.internal.tj.y) this.a).a).a();
    }
}
