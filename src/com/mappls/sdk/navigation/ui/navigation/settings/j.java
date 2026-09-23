package com.mappls.sdk.navigation.ui.navigation.settings;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ SettingView a;

    public j(SettingView settingView) {
        this.a = settingView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.a.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(5);
        }
    }
}
