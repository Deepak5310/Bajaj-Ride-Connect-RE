package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.Navigator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ec implements Runnable {
    final /* synthetic */ ej a;
    final /* synthetic */ Navigator b;
    final /* synthetic */ com.google.android.libraries.navigation.environment.am c;

    public ec(ej ejVar, Navigator navigator, com.google.android.libraries.navigation.environment.am amVar) {
        this.a = ejVar;
        this.b = navigator;
        this.c = amVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b, this.c);
    }
}
