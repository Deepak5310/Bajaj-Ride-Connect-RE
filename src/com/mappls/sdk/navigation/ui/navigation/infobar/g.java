package com.mappls.sdk.navigation.ui.navigation.infobar;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ InfobarBottomSheetView a;

    public g(InfobarBottomSheetView infobarBottomSheetView) {
        this.a = infobarBottomSheetView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.a.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            if (bottomSheetBehavior.getState() == 4) {
                this.a.mBottomSheetBehavior.setState(3);
            } else if (this.a.mBottomSheetBehavior.getState() == 3) {
                this.a.mBottomSheetBehavior.setState(4);
            }
        }
    }
}
