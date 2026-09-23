package com.google.android.libraries.navigation;

import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class h implements NavigationApi.NavigatorListener {
    final /* synthetic */ Intent a;

    public h(Intent intent) {
        this.a = intent;
    }

    @Override // com.google.android.libraries.navigation.NavigationApi.NavigatorListener
    public final void onError(int i) {
    }

    @Override // com.google.android.libraries.navigation.NavigationApi.NavigatorListener
    public final void onNavigatorReady(Navigator navigator) {
        navigator.a(this.a);
    }
}
