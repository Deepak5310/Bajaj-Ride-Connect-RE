package com.mappls.sdk.navigation.ui.navigation.settings;

import android.widget.CompoundButton;
import com.mappls.sdk.navigation.MapplsNavigationHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SettingView a;

    public i(SettingView settingView) {
        this.a = settingView;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MapplsNavigationHelper.getInstance().setNavigationEventAudioPromptEnabled(z);
        this.a.setNavigationEventAudio(z);
    }
}
