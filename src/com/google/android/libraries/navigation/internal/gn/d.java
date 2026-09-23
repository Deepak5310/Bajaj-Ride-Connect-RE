package com.google.android.libraries.navigation.internal.gn;

import org.chromium.net.CronetException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements Runnable {
    final /* synthetic */ CronetException a;
    final /* synthetic */ e b;

    public d(e eVar, CronetException cronetException) {
        this.a = cronetException;
        this.b = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.ap(com.google.android.libraries.navigation.internal.gt.b.a(this.a));
    }
}
