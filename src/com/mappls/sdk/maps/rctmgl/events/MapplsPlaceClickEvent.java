package com.mappls.sdk.maps.rctmgl.events;

import android.view.View;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsPlaceClickEvent extends AbstractEvent {
    private String mapplsPin;

    public MapplsPlaceClickEvent(View view, String str) {
        super(view, EventTypes.MAP_CLICK);
        this.mapplsPin = str;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        return EventKeys.MAP_PLACE_CLICK;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        String str = this.mapplsPin;
        if (str != null) {
            writableNativeMap.putString("mapplsPin", str);
        }
        return writableNativeMap;
    }
}
