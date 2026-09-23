package com.mappls.sdk.navigation.ui.navigation.infobar;

import android.view.View;
import com.mappls.sdk.navigation.MapplsNavigationHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ InfobarBottomSheetView a;

    public i(InfobarBottomSheetView infobarBottomSheetView) {
        this.a = infobarBottomSheetView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m mVar = this.a.onInfobarCallback;
        if (mVar != null) {
            ((com.mappls.sdk.navigation.ui.navigation.l) mVar).getClass();
            MapplsNavigationHelper.getInstance().stopNavigation();
        }
    }
}
