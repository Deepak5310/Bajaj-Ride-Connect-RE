package com.google.android.libraries.navigation.internal.ky;

import android.content.Context;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends e {
    public static final List o = new CopyOnWriteArrayList();
    public final List p;
    public final i q;

    public o(Context context, String str, aw awVar, p pVar, br brVar, i iVar, r rVar) {
        super(context, str, awVar, pVar, brVar, rVar);
        this.p = new CopyOnWriteArrayList();
        this.q = null;
    }

    public static l e(Context context, String str) {
        return (l) new l(context, str).b(aw.c);
    }

    public static void h(m mVar) {
        o.add(0, mVar);
    }

    @Deprecated
    public final n f(cy cyVar) {
        be.j(cyVar);
        return new n(this, cyVar);
    }

    public final void g(m mVar) {
        this.p.add(0, mVar);
    }
}
