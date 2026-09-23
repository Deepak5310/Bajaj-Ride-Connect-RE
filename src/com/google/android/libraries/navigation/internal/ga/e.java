package com.google.android.libraries.navigation.internal.ga;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.google.android.libraries.navigation.internal.gb.a {
    public final Application a;
    public final com.google.android.libraries.navigation.internal.iv.f b;
    public final com.google.android.libraries.navigation.internal.ia.e c;
    public d d = null;
    protected boolean e = false;
    public boolean f = false;

    public e(Application application, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.ia.e eVar) {
        this.a = application;
        this.b = fVar;
        this.c = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gb.a
    public final boolean a() {
        return this.f;
    }

    public final void b() {
        this.f = true;
        this.c.a(new com.google.android.libraries.navigation.internal.gc.a());
    }

    public final void c() {
        this.f = false;
        this.c.a(new com.google.android.libraries.navigation.internal.gc.a());
    }

    public final boolean d() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }
}
