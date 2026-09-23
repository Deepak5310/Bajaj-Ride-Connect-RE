package com.google.android.libraries.navigation.internal.lh;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ab extends k implements com.google.android.libraries.navigation.internal.ld.i {
    private static volatile Executor t;
    public final Set s;
    private final Account u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected ab(Context context, Looper looper, int i, p pVar, com.google.android.libraries.navigation.internal.le.r rVar, com.google.android.libraries.navigation.internal.le.au auVar) {
        super(context, looper, ad.d, com.google.android.libraries.navigation.internal.lc.h.a, i, new z(rVar), new aa(auVar), pVar.e);
        synchronized (ad.b) {
            if (ad.d == null) {
                ad.d = new ag(context.getApplicationContext(), context.getMainLooper());
            }
        }
        this.u = pVar.a;
        Set set = pVar.c;
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (!set.contains((com.google.android.libraries.navigation.internal.ld.z) it2.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.s = set;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final com.google.android.libraries.navigation.internal.lc.d[] C() {
        return new com.google.android.libraries.navigation.internal.lc.d[0];
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final void E() {
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final Account I() {
        return this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k, com.google.android.libraries.navigation.internal.ld.i
    public int a() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ld.i
    public final Set g() {
        return n() ? this.s : Collections.emptySet();
    }
}
