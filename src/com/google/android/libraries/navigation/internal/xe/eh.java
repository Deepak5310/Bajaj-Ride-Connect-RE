package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.Navigator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eh implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ Navigator b;
    final /* synthetic */ int c;

    public eh(List list, Navigator navigator, int i) {
        this.a = list;
        this.b = navigator;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (NavigationApi.NavigatorListener navigatorListener : this.a) {
            Navigator navigator = this.b;
            if (navigator != null) {
                navigatorListener.onNavigatorReady(navigator);
            } else {
                navigatorListener.onError(this.c);
            }
        }
    }
}
