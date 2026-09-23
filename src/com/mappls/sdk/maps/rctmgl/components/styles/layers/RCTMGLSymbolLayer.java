package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import android.content.Context;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyle;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.SymbolLayer;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLSymbolLayer extends RCTLayer<SymbolLayer> {
    private String mSourceLayerID;

    public RCTMGLSymbolLayer(Context context) {
        super(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    protected void updateFilter(Expression expression) {
        ((SymbolLayer) this.mLayer).setFilter(expression);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer, com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        super.addToMap(rCTMGLMapView);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public SymbolLayer makeLayer() {
        SymbolLayer symbolLayer = new SymbolLayer(this.mID, this.mSourceID);
        String str = this.mSourceLayerID;
        if (str != null) {
            symbolLayer.setSourceLayer(str);
        }
        return symbolLayer;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public void addStyles() {
        RCTMGLStyleFactory.setSymbolLayerStyle((SymbolLayer) this.mLayer, new RCTMGLStyle(getContext(), this.mReactStyle, this.mMap));
    }

    public void setSourceLayerID(String str) {
        this.mSourceLayerID = str;
        if (this.mLayer != 0) {
            ((SymbolLayer) this.mLayer).setSourceLayer(str);
        }
    }
}
