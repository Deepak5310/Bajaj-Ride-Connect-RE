package com.mappls.sdk.maps.rctmgl.events;

import android.graphics.PointF;
import android.view.View;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;

/* JADX INFO: loaded from: classes4.dex */
public class MapClickEvent extends AbstractEvent {
    private PointF mScreenPoint;
    private LatLng mTouchedLatLng;

    public MapClickEvent(View view, LatLng latLng, PointF pointF) {
        this(view, latLng, pointF, EventTypes.MAP_CLICK);
    }

    public MapClickEvent(View view, LatLng latLng, PointF pointF, String str) {
        super(view, str);
        this.mTouchedLatLng = latLng;
        this.mScreenPoint = pointF;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        if (getType().equals(EventTypes.MAP_LONG_CLICK)) {
            return EventKeys.MAP_LONG_CLICK;
        }
        return EventKeys.MAP_CLICK;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("screenPointX", this.mScreenPoint.x);
        writableNativeMap.putDouble("screenPointY", this.mScreenPoint.y);
        return GeoJSONUtils.toPointFeature(this.mTouchedLatLng, writableNativeMap);
    }
}
