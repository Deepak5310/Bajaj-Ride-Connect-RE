package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.Navigator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eg implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ Navigator b;
    final /* synthetic */ com.google.android.libraries.navigation.environment.am c;

    public eg(List list, Navigator navigator, com.google.android.libraries.navigation.environment.am amVar) {
        this.a = list;
        this.b = navigator;
        this.c = amVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            ((ej) it2.next()).a(this.b, this.c);
        }
    }
}
