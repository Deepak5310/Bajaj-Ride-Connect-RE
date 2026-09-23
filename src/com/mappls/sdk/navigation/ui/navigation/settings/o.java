package com.mappls.sdk.navigation.ui.navigation.settings;

import android.view.View;
import com.mappls.sdk.navigation.MapplsNavigationHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ SettingView a;

    public o(SettingView settingView) {
        this.a = settingView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MapplsNavigationHelper.getInstance().setMetricSystemToKM(true);
        this.a.updateUnitView();
    }
}
