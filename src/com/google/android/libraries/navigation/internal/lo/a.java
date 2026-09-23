package com.google.android.libraries.navigation.internal.lo;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    final /* synthetic */ i a;

    public a(i iVar) {
        this.a = iVar;
    }

    public final void a(m mVar) {
        i iVar = this.a;
        iVar.a = mVar;
        Iterator it2 = iVar.c.iterator();
        while (it2.hasNext()) {
            ((h) it2.next()).b();
        }
        this.a.c.clear();
        this.a.b = null;
    }
}
