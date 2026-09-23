package com.mappls.sdk.navigation.ui.navigation.settings;

import android.widget.CompoundButton;
import com.mappls.sdk.navigation.MapplsNavigationHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements CompoundButton.OnCheckedChangeListener {
    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MapplsNavigationHelper.getInstance().showRoadConditionsEvents(z);
    }
}
