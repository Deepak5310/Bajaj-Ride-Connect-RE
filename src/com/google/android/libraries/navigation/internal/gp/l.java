package com.google.android.libraries.navigation.internal.gp;

import org.chromium.net.CronetException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements Runnable {
    final /* synthetic */ CronetException a;
    final /* synthetic */ n b;

    public l(n nVar, CronetException cronetException) {
        this.a = cronetException;
        this.b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.ap(com.google.android.libraries.navigation.internal.gt.b.a(this.a));
        this.b.b.b();
    }
}
