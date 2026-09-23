package com.mappls.sdk.plugins.places.placepicker.plugin;

import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.layers.RasterLayer;
import com.mappls.sdk.maps.style.sources.RasterSource;
import com.mappls.sdk.maps.style.sources.TileSet;

/* JADX INFO: loaded from: classes4.dex */
final class b implements Style.OnStyleLoaded {
    final /* synthetic */ c a;

    b(c cVar) {
        this.a = cVar;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        if (style.getSource("com.mappls.sdk.plugins.places.placepicker.plugin.BuildingFootprintPlugin.SOURCE_ID") == null) {
            style.addSource(new RasterSource("com.mappls.sdk.plugins.places.placepicker.plugin.BuildingFootprintPlugin.SOURCE_ID", new TileSet("tileset", c.a(this.a))));
            style.addLayer(new RasterLayer("com.mappls.sdk.plugins.places.placepicker.plugin.BuildingFootprintPlugin.LAYER_ID", "com.mappls.sdk.plugins.places.placepicker.plugin.BuildingFootprintPlugin.SOURCE_ID"));
        }
    }
}
