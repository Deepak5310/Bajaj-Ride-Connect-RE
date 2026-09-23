package com.mappls.sdk.navigation.ui.navigation;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ NavigationView a;

    public m(NavigationView navigationView) {
        this.a = navigationView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NavigationViewCallback navigationViewCallback = this.a.navigationViewCallback;
        if (navigationViewCallback != null) {
            navigationViewCallback.searchAlongRoute();
        }
    }
}
