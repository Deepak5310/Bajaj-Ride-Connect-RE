package com.mappls.sdk.maps.rctmgl.events;

import android.graphics.PointF;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.rctmgl.components.annotation.RCTMGLPointAnnotation;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;

/* JADX INFO: loaded from: classes4.dex */
public class PointAnnotationDragEvent extends MapClickEvent {
    private PointF mScreenPoint;
    private LatLng mTouchedLatLng;
    RCTMGLPointAnnotation mView;

    public PointAnnotationDragEvent(RCTMGLPointAnnotation rCTMGLPointAnnotation, LatLng latLng, PointF pointF, String str) {
        super(rCTMGLPointAnnotation, latLng, pointF, str);
        this.mView = rCTMGLPointAnnotation;
        this.mTouchedLatLng = latLng;
        this.mScreenPoint = pointF;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.MapClickEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        String type = getType();
        if (type.equals(EventTypes.ANNOTATION_DRAG_START)) {
            return EventKeys.POINT_ANNOTATION_DRAG_START;
        }
        if (type.equals(EventTypes.ANNOTATION_DRAG_END)) {
            return EventKeys.POINT_ANNOTATION_DRAG_END;
        }
        return EventKeys.POINT_ANNOTATION_DRAG;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.MapClickEvent, com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("id", this.mView.getID());
        writableNativeMap.putDouble("screenPointX", this.mScreenPoint.x);
        writableNativeMap.putDouble("screenPointY", this.mScreenPoint.y);
        LatLng latLng = this.mTouchedLatLng;
        return latLng != null ? GeoJSONUtils.toPointFeature(latLng, writableNativeMap) : writableNativeMap;
    }
}
