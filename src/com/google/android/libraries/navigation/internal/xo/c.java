package com.google.android.libraries.navigation.internal.xo;

import android.database.ContentObserver;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends ContentObserver {
    final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(null);
        this.a = dVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        d dVar = this.a;
        synchronized (dVar.e) {
            dVar.f = null;
            ah.e();
        }
        synchronized (dVar) {
            Iterator it2 = dVar.g.iterator();
            while (it2.hasNext()) {
                ((e) it2.next()).a();
            }
        }
    }
}
