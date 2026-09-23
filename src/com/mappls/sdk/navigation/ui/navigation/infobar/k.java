package com.mappls.sdk.navigation.ui.navigation.infobar;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements Observer {
    public final /* synthetic */ InfobarBottomSheetView a;

    public k(InfobarBottomSheetView infobarBottomSheetView) {
        this.a = infobarBottomSheetView;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        l lVar = (l) obj;
        if (lVar != null) {
            this.a.setData(lVar);
        }
    }
}
