package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.hg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cq {
    public final g a = new g();
    public final List b = new ArrayList();
    public final List c = new ArrayList();
    public final List d = new ArrayList();
    public final com.google.android.libraries.navigation.internal.agg.bj e = new com.google.android.libraries.navigation.internal.agg.bz();
    public final List f = new ArrayList();

    public final void a(int i, com.google.android.libraries.navigation.internal.yz.ek ekVar) {
        Iterator<E> it2 = ekVar.iterator();
        while (it2.hasNext()) {
            g gVar = this.a;
            gVar.a.a((hg) it2.next(), i);
        }
    }
}
