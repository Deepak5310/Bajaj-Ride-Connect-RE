package com.google.android.libraries.navigation.internal.tr;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.bn.d;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.br.l;
import com.google.android.libraries.navigation.internal.rw.aa;
import com.google.android.libraries.navigation.internal.rw.q;
import com.google.android.libraries.navigation.internal.sp.c;
import com.google.android.libraries.navigation.internal.tj.o;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.sp.b, aa {
    private final q a;
    private final d b;
    private final Executor c;

    public a(q qVar, d dVar, Executor executor) {
        this.a = qVar;
        this.b = dVar;
        this.c = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(c cVar) {
        this.a.a(this, this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.rw.aa
    public final void av(o oVar, int i, boolean z) {
        Iterator it2 = oVar.a.iterator();
        while (it2.hasNext()) {
            jg jgVar = ((bg) it2.next()).E;
            if (jgVar != null) {
                d dVar = this.b;
                el elVar = jgVar.i;
                if (elVar == null) {
                    elVar = el.a;
                }
                dVar.h(new HashSet(l.g(elVar)));
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        this.a.b(this);
    }
}
