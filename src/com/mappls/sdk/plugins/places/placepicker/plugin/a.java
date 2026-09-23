package com.mappls.sdk.plugins.places.placepicker.plugin;

import com.mappls.sdk.maps.Style;

/* JADX INFO: loaded from: classes4.dex */
final class a implements Style.OnStyleLoaded {
    a() {
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        style.removeLayer("com.mappls.sdk.plugins.places.placepicker.plugin.BuildingFootprintPlugin.LAYER_ID");
        style.removeSource("com.mappls.sdk.plugins.places.placepicker.plugin.BuildingFootprintPlugin.SOURCE_ID");
    }
}
