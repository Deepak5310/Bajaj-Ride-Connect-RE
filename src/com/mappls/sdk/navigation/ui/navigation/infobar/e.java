package com.mappls.sdk.navigation.ui.navigation.infobar;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public final /* synthetic */ InfobarBottomSheetView a;

    public e(InfobarBottomSheetView infobarBottomSheetView) {
        this.a = infobarBottomSheetView;
    }

    public final void a(String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "mappls_navigation_ui_direction_list":
                m mVar = this.a.onInfobarCallback;
                if (mVar != null) {
                    ((com.mappls.sdk.navigation.ui.navigation.l) mVar).d();
                }
                BottomSheetBehavior bottomSheetBehavior = this.a.mBottomSheetBehavior;
                if (bottomSheetBehavior != null) {
                    bottomSheetBehavior.setState(4);
                    break;
                }
                break;
            case "mappls_navigation_ui_day_night_mode":
                m mVar2 = this.a.onInfobarCallback;
                if (mVar2 != null) {
                    ((com.mappls.sdk.navigation.ui.navigation.l) mVar2).a();
                }
                BottomSheetBehavior bottomSheetBehavior2 = this.a.mBottomSheetBehavior;
                if (bottomSheetBehavior2 != null) {
                    bottomSheetBehavior2.setState(4);
                    break;
                }
                break;
            case "mappls_navigation_ui_setting":
                m mVar3 = this.a.onInfobarCallback;
                if (mVar3 != null) {
                    ((com.mappls.sdk.navigation.ui.navigation.l) mVar3).c();
                }
                BottomSheetBehavior bottomSheetBehavior3 = this.a.mBottomSheetBehavior;
                if (bottomSheetBehavior3 != null) {
                    bottomSheetBehavior3.setState(4);
                    break;
                }
                break;
            case "mappls_navigation_ui_trafffic":
                m mVar4 = this.a.onInfobarCallback;
                if (mVar4 != null) {
                    ((com.mappls.sdk.navigation.ui.navigation.l) mVar4).e();
                }
                BottomSheetBehavior bottomSheetBehavior4 = this.a.mBottomSheetBehavior;
                if (bottomSheetBehavior4 != null) {
                    bottomSheetBehavior4.setState(4);
                    break;
                }
                break;
            default:
                m mVar5 = this.a.onInfobarCallback;
                if (mVar5 != null) {
                    ((com.mappls.sdk.navigation.ui.navigation.l) mVar5).a(str);
                }
                BottomSheetBehavior bottomSheetBehavior5 = this.a.mBottomSheetBehavior;
                if (bottomSheetBehavior5 != null) {
                    bottomSheetBehavior5.setState(4);
                    break;
                }
                break;
        }
    }
}
