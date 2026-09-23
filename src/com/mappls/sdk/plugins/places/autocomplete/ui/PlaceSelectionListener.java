package com.mappls.sdk.plugins.places.autocomplete.ui;

import com.mappls.sdk.plugins.places.autocomplete.model.MapplsFavoritePlace;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;

/* JADX INFO: loaded from: classes4.dex */
public interface PlaceSelectionListener {
    void onCancel();

    void onFavoritePlaceSelected(MapplsFavoritePlace mapplsFavoritePlace);

    void onPlaceSelected(ELocation eLocation);

    void requestForCurrentLocation();
}
