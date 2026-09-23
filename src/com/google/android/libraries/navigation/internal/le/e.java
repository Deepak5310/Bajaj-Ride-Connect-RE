package com.google.android.libraries.navigation.internal.le;

import android.os.DeadObjectException;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends a {
    private final bj a;
    private final com.google.android.libraries.navigation.internal.me.aa b;
    private final h d;

    public e(int i, bj bjVar, com.google.android.libraries.navigation.internal.me.aa aaVar, h hVar) {
        super(i);
        this.b = aaVar;
        this.a = bjVar;
        this.d = hVar;
        if (i == 2 && bjVar.c) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.le.a
    public final boolean a(ae aeVar) {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.le.a
    public final com.google.android.libraries.navigation.internal.lc.d[] b(ae aeVar) {
        return this.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void d(com.google.android.libraries.navigation.internal.ld.ab abVar) {
        this.b.c(com.google.android.libraries.navigation.internal.lh.a.a(abVar));
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void e(Exception exc) {
        this.b.c(exc);
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void f(ae aeVar) throws DeadObjectException {
        try {
            bj bjVar = this.a;
            ((bh) bjVar).a.a.a(aeVar.b, this.b);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            d(g.h(e2));
        } catch (RuntimeException e3) {
            e(e3);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void g(u uVar, boolean z) {
        Map map = uVar.b;
        com.google.android.libraries.navigation.internal.me.aa aaVar = this.b;
        map.put(aaVar, Boolean.valueOf(z));
        aaVar.a.g(com.google.android.libraries.navigation.internal.me.ad.a, new t(uVar, aaVar));
    }
}
