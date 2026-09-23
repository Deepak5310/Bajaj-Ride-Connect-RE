package com.mappls.sdk.maps.rctmgl.events;

import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsDetail;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GeoAnalyticsClickEvent extends AbstractEvent {
    private List<MapplsGeoAnalyticsDetail> list;

    public GeoAnalyticsClickEvent(View view, List<MapplsGeoAnalyticsDetail> list) {
        super(view, EventTypes.GEO_ANALYTICS_LAYER_PRESS);
        this.list = list;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        if (getType().equals(EventTypes.GEO_ANALYTICS_LAYER_PRESS)) {
            return EventKeys.GEO_ANALYTICS_LAYER_PRESS;
        }
        return EventKeys.GEO_ANALYTICS_LAYER_PRESS;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (MapplsGeoAnalyticsDetail mapplsGeoAnalyticsDetail : this.list) {
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putString("type", mapplsGeoAnalyticsDetail.getType());
            WritableMap writableMapCreateMap = Arguments.createMap();
            for (String str : mapplsGeoAnalyticsDetail.getProperties().keySet()) {
                writableMapCreateMap.putString(str, mapplsGeoAnalyticsDetail.getProperties().get(str).toString());
            }
            writableNativeMap2.putMap("properties", writableMapCreateMap);
            writableArrayCreateArray.pushMap(writableNativeMap2);
        }
        writableNativeMap.putArray("results", writableArrayCreateArray);
        return writableNativeMap;
    }
}
