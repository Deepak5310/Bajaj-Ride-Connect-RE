package com.mappls.sdk.navigation.ui.navigation.settings;

import android.widget.CompoundButton;
import com.mappls.sdk.navigation.MapplsNavigationHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SettingView a;

    public a(SettingView settingView) {
        this.a = settingView;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MapplsNavigationHelper.getInstance().setNavigationEventEnabled(z);
        this.a.setNavigationEvent(z);
    }
}
