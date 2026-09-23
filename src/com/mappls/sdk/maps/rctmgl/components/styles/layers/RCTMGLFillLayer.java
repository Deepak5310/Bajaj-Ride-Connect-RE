package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import android.content.Context;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyle;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.FillLayer;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLFillLayer extends RCTLayer<FillLayer> {
    private String mSourceLayerID;

    public RCTMGLFillLayer(Context context) {
        super(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    protected void updateFilter(Expression expression) {
        ((FillLayer) this.mLayer).setFilter(expression);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer, com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        super.addToMap(rCTMGLMapView);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public FillLayer makeLayer() {
        FillLayer fillLayer = new FillLayer(this.mID, this.mSourceID);
        String str = this.mSourceLayerID;
        if (str != null) {
            fillLayer.setSourceLayer(str);
        }
        return fillLayer;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public void addStyles() {
        RCTMGLStyleFactory.setFillLayerStyle((FillLayer) this.mLayer, new RCTMGLStyle(getContext(), this.mReactStyle, this.mMap));
    }

    public void setSourceLayerID(String str) {
        this.mSourceLayerID = str;
        if (this.mLayer != 0) {
            ((FillLayer) this.mLayer).setSourceLayer(this.mSourceLayerID);
        }
    }
}
