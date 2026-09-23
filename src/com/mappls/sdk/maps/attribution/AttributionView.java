package com.mappls.sdk.maps.attribution;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;

/* JADX INFO: loaded from: classes4.dex */
public class AttributionView extends ImageView implements MapplsMap.OnCameraIdleListener, MapView.OnDidFinishRenderingMapListener {
    static final LatLngBounds INDIA_BOUNDS = new LatLngBounds.Builder().include(new LatLng(37.238124d, 64.805223d)).include(new LatLng(5.100697d, 98.574512d)).build();
    private MapplsMap map;

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishRenderingMapListener
    public void onDidFinishRenderingMap(boolean z) {
    }

    public AttributionView(Context context) {
        super(context);
    }

    public AttributionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AttributionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMap(MapplsMap mapplsMap) {
        this.map = mapplsMap;
        mapplsMap.addOnCameraIdleListener(this);
    }

    public MapplsMap getMap() {
        return this.map;
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraIdleListener
    public void onCameraIdle() {
        if (this.map.getCameraPosition().zoom > 8.0d && !INDIA_BOUNDS.contains(this.map.getCameraPosition().target)) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
