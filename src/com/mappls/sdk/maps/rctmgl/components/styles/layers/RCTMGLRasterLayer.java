package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import android.content.Context;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyle;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory;
import com.mappls.sdk.maps.style.layers.RasterLayer;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLRasterLayer extends RCTLayer<RasterLayer> {
    public RCTMGLRasterLayer(Context context) {
        super(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public RasterLayer makeLayer() {
        return new RasterLayer(this.mID, this.mSourceID);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public void addStyles() {
        RCTMGLStyleFactory.setRasterLayerStyle((RasterLayer) this.mLayer, new RCTMGLStyle(getContext(), this.mReactStyle, this.mMap));
    }
}
