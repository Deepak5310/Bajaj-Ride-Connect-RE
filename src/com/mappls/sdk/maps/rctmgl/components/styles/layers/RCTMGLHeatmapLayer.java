package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import android.content.Context;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyle;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.HeatmapLayer;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLHeatmapLayer extends RCTLayer<HeatmapLayer> {
    private String mSourceLayerID;

    public RCTMGLHeatmapLayer(Context context) {
        super(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    protected void updateFilter(Expression expression) {
        ((HeatmapLayer) this.mLayer).setFilter(expression);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer, com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        super.addToMap(rCTMGLMapView);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public HeatmapLayer makeLayer() {
        HeatmapLayer heatmapLayer = new HeatmapLayer(this.mID, this.mSourceID);
        String str = this.mSourceLayerID;
        if (str != null) {
            heatmapLayer.setSourceLayer(str);
        }
        return heatmapLayer;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer
    public void addStyles() {
        RCTMGLStyleFactory.setHeatmapLayerStyle((HeatmapLayer) this.mLayer, new RCTMGLStyle(getContext(), this.mReactStyle, this.mMap));
    }

    public void setSourceLayerID(String str) {
        this.mSourceLayerID = str;
        if (this.mLayer != 0) {
            ((HeatmapLayer) this.mLayer).setSourceLayer(str);
        }
    }
}
