package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import android.content.Context;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyle;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.LineLayer;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLLineLayer extends RCTLayer<LineLayer> {
    private String mSourceLayerID;

    public RCTMGLLineLayer(Context context) {
        super(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    protected void updateFilter(Expression expression) {
        ((LineLayer) this.mLayer).setFilter(expression);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer, com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        super.addToMap(rCTMGLMapView);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public LineLayer makeLayer() {
        LineLayer lineLayer = new LineLayer(this.mID, this.mSourceID);
        String str = this.mSourceLayerID;
        if (str != null) {
            lineLayer.setSourceLayer(str);
        }
        return lineLayer;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public void addStyles() {
        RCTMGLStyleFactory.setLineLayerStyle((LineLayer) this.mLayer, new RCTMGLStyle(getContext(), this.mReactStyle, this.mMap));
    }

    public void setSourceLayerID(String str) {
        this.mSourceLayerID = str;
        if (this.mLayer != 0) {
            ((LineLayer) this.mLayer).setSourceLayer(this.mSourceLayerID);
        }
    }
}
