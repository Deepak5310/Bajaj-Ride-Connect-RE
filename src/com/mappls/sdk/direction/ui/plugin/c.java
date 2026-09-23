package com.mappls.sdk.direction.ui.plugin;

import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;

/* JADX INFO: loaded from: classes6.dex */
final class c implements Style.OnStyleLoaded {
    final /* synthetic */ boolean a;

    c(boolean z) {
        this.a = z;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        Layer layer = style.getLayer("com.mappls.sdk.directions.directions-marker-bearing-layer");
        if (layer != null) {
            PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
            propertyValueArr[0] = PropertyFactory.visibility(this.a ? "visible" : "none");
            layer.setProperties(propertyValueArr);
        }
    }
}
