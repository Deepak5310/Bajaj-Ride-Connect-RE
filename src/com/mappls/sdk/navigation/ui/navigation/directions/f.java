package com.mappls.sdk.navigation.ui.navigation.directions;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ DirectionsListView a;

    public f(DirectionsListView directionsListView) {
        this.a = directionsListView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.a.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(5);
        }
    }
}
