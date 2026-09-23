package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import android.content.Context;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyle;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.CircleLayer;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLCircleLayer extends RCTLayer<CircleLayer> {
    private String mSourceLayerID;

    public RCTMGLCircleLayer(Context context) {
        super(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    protected void updateFilter(Expression expression) {
        ((CircleLayer) this.mLayer).setFilter(expression);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer, com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        super.addToMap(rCTMGLMapView);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public CircleLayer makeLayer() {
        CircleLayer circleLayer = new CircleLayer(this.mID, this.mSourceID);
        String str = this.mSourceLayerID;
        if (str != null) {
            circleLayer.setSourceLayer(str);
        }
        return circleLayer;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public void addStyles() {
        RCTMGLStyleFactory.setCircleLayerStyle((CircleLayer) this.mLayer, new RCTMGLStyle(getContext(), this.mReactStyle, this.mMap));
    }

    public void setSourceLayerID(String str) {
        this.mSourceLayerID = str;
        if (this.mLayer != 0) {
            ((CircleLayer) this.mLayer).setSourceLayer(str);
        }
    }
}
