package com.google.android.libraries.navigation.internal.lo;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements h {
    final /* synthetic */ Activity a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ Bundle c;
    final /* synthetic */ i d;

    public b(i iVar, Activity activity, Bundle bundle, Bundle bundle2) {
        this.a = activity;
        this.b = bundle;
        this.c = bundle2;
        this.d = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lo.h
    public final int a() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.lo.h
    public final void b() {
        this.d.a.e(this.a, this.b, this.c);
    }
}
