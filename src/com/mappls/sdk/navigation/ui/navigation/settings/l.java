package com.mappls.sdk.navigation.ui.navigation.settings;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ SettingView a;

    public l(SettingView settingView) {
        this.a = settingView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        s sVar = this.a.settingsCallback;
        if (sVar != null) {
            com.mappls.sdk.navigation.ui.utils.b bVar = com.mappls.sdk.navigation.ui.utils.b.c;
            ((com.mappls.sdk.navigation.ui.navigation.p) sVar).a(bVar);
            this.a.setMapLayer(bVar);
        }
    }
}
