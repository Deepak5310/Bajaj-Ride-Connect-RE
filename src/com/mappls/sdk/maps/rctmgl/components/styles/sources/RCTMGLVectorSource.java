package com.mappls.sdk.maps.rctmgl.components.styles.sources;

import android.content.Context;
import com.facebook.react.bridge.WritableNativeMap;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.rctmgl.events.AndroidCallbackEvent;
import com.mappls.sdk.maps.rctmgl.events.FeatureClickEvent;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.sources.VectorSource;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLVectorSource extends RCTMGLTileSource<VectorSource> {
    private RCTMGLVectorSourceManager mManager;

    public RCTMGLVectorSource(Context context, RCTMGLVectorSourceManager rCTMGLVectorSourceManager) {
        super(context);
        this.mManager = rCTMGLVectorSourceManager;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTSource
    public void onPress(RCTSource.OnPressEvent onPressEvent) {
        this.mManager.handleEvent(FeatureClickEvent.makeVectorSourceEvent(this, onPressEvent));
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTSource
    public VectorSource makeSource() {
        if (isDefaultSource(this.mID)) {
            return (VectorSource) this.mMap.getStyle().getSource(RCTSource.DEFAULT_ID);
        }
        if (getURL() != null) {
            return new VectorSource(this.mID, getURL());
        }
        return new VectorSource(this.mID, buildTileset());
    }

    public void querySourceFeatures(String str, List<String> list, Expression expression) {
        if (this.mSource == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("error", "source is not yet loaded");
            this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
            return;
        }
        List<Feature> listQuerySourceFeatures = ((VectorSource) this.mSource).querySourceFeatures((String[]) list.toArray(new String[list.size()]), expression);
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putString("data", FeatureCollection.fromFeatures(listQuerySourceFeatures).toJson());
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap2));
    }
}
