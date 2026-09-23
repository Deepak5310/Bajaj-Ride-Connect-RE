package com.mappls.sdk.navigation.ui.navigation.infobar;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ InfobarBottomSheetView a;

    public h(InfobarBottomSheetView infobarBottomSheetView) {
        this.a = infobarBottomSheetView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.showRouteOverview(false);
        m mVar = this.a.onInfobarCallback;
        if (mVar != null) {
            ((com.mappls.sdk.navigation.ui.navigation.l) mVar).b();
        }
        BottomSheetBehavior bottomSheetBehavior = this.a.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(4);
        }
    }
}
