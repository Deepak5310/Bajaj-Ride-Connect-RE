package com.mappls.sdk.maps.rctmgl.components.mapview;

import com.mappls.sdk.maps.style.layers.CircleLayer;
import com.mappls.sdk.maps.style.layers.FillExtrusionLayer;
import com.mappls.sdk.maps.style.layers.FillLayer;
import com.mappls.sdk.maps.style.layers.HeatmapLayer;
import com.mappls.sdk.maps.style.layers.HillshadeLayer;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.RasterLayer;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class LayerSourceInfo {
    final String sourceId;

    @Nullable
    final String sourceLayerId;

    LayerSourceInfo(Layer layer) {
        if (layer instanceof CircleLayer) {
            CircleLayer circleLayer = (CircleLayer) layer;
            this.sourceId = circleLayer.getSourceId();
            this.sourceLayerId = circleLayer.getSourceLayer();
            return;
        }
        if (layer instanceof FillExtrusionLayer) {
            FillExtrusionLayer fillExtrusionLayer = (FillExtrusionLayer) layer;
            this.sourceId = fillExtrusionLayer.getSourceId();
            this.sourceLayerId = fillExtrusionLayer.getSourceLayer();
            return;
        }
        if (layer instanceof FillLayer) {
            FillLayer fillLayer = (FillLayer) layer;
            this.sourceId = fillLayer.getSourceId();
            this.sourceLayerId = fillLayer.getSourceLayer();
            return;
        }
        if (layer instanceof HeatmapLayer) {
            HeatmapLayer heatmapLayer = (HeatmapLayer) layer;
            this.sourceId = heatmapLayer.getSourceId();
            this.sourceLayerId = heatmapLayer.getSourceLayer();
            return;
        }
        if (layer instanceof HillshadeLayer) {
            this.sourceId = ((HillshadeLayer) layer).getSourceId();
            this.sourceLayerId = null;
            return;
        }
        if (layer instanceof LineLayer) {
            LineLayer lineLayer = (LineLayer) layer;
            this.sourceId = lineLayer.getSourceId();
            this.sourceLayerId = lineLayer.getSourceLayer();
        } else if (layer instanceof RasterLayer) {
            this.sourceId = ((RasterLayer) layer).getSourceId();
            this.sourceLayerId = null;
        } else if (layer instanceof SymbolLayer) {
            SymbolLayer symbolLayer = (SymbolLayer) layer;
            this.sourceId = symbolLayer.getSourceId();
            this.sourceLayerId = symbolLayer.getSourceLayer();
        } else {
            this.sourceId = "";
            this.sourceLayerId = null;
        }
    }
}
