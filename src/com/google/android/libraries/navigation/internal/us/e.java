package com.google.android.libraries.navigation.internal.us;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.tj.u;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e<T extends com.google.android.libraries.navigation.internal.tj.u> extends y<T> implements com.google.android.libraries.navigation.internal.ut.a {
    private com.google.android.libraries.navigation.internal.ut.d.b x;

    protected e(com.google.android.libraries.navigation.internal.tj.u uVar, Context context, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.sl.d dVar2, com.google.android.libraries.navigation.internal.sn.h hVar, Resources resources, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, com.google.android.libraries.navigation.internal.ch.b bVar) {
        super(uVar, context, eVar, dVar, dVar2, hVar, resources, aVar, afVar, tVar, bnVar, executor, mVar, bVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.a
    public com.google.android.libraries.navigation.internal.ut.d.b e() {
        return this.x;
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.ut.d.c f() {
        return com.google.android.libraries.navigation.internal.ut.d.c.PROMPT_WITH_CHOICE;
    }

    protected final void g(com.google.android.libraries.navigation.internal.ut.d.b bVar) {
        J(bVar);
        this.x = bVar;
    }
}
