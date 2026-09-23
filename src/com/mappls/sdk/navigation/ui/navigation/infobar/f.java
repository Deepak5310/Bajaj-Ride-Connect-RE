package com.mappls.sdk.navigation.ui.navigation.infobar;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ InfobarBottomSheetView a;

    public f(InfobarBottomSheetView infobarBottomSheetView) {
        this.a = infobarBottomSheetView;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View view, float f) {
        this.a.binding.ivBottomSheetArrow.setRotation(f * 180.0f);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View view, int i) {
    }
}
