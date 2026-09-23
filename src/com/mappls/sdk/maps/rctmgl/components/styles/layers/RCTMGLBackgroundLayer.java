package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import android.content.Context;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyle;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory;
import com.mappls.sdk.maps.style.layers.BackgroundLayer;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLBackgroundLayer extends RCTLayer<BackgroundLayer> {
    public RCTMGLBackgroundLayer(Context context) {
        super(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public BackgroundLayer makeLayer() {
        return new BackgroundLayer(this.mID);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public void addStyles() {
        RCTMGLStyleFactory.setBackgroundLayerStyle((BackgroundLayer) this.mLayer, new RCTMGLStyle(getContext(), this.mReactStyle, this.mMap));
    }
}
