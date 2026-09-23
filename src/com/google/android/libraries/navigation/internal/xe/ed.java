package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.Navigator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ed implements Runnable {
    final /* synthetic */ NavigationApi.NavigatorListener a;
    final /* synthetic */ Navigator b;

    public ed(NavigationApi.NavigatorListener navigatorListener, Navigator navigator) {
        this.a = navigatorListener;
        this.b = navigator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onNavigatorReady(this.b);
    }
}
