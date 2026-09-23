package com.mappls.sdk.navigation.ui.navigation.infobar;

import androidx.lifecycle.Observer;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements Observer {
    public final /* synthetic */ InfobarBottomSheetView a;

    public j(InfobarBottomSheetView infobarBottomSheetView) {
        this.a = infobarBottomSheetView;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        ELocation eLocation = (ELocation) obj;
        if (eLocation == null) {
            Timber.e("Please pass Destination using MapplsNavigationViewHelper", new Object[0]);
            this.a.binding.destinationText.setText("");
        } else {
            this.a.binding.destinationText.setText("Destination: " + eLocation.placeName);
        }
    }
}
