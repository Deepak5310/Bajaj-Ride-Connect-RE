package com.mappls.sdk.maps.rctmgl.events;

import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;

/* JADX INFO: loaded from: classes4.dex */
public class MapChangeEvent extends AbstractEvent {
    private WritableMap mPayload;

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public boolean canCoalesce() {
        return false;
    }

    public MapChangeEvent(View view, String str) {
        this(view, str, Arguments.createMap());
    }

    public MapChangeEvent(View view, String str, WritableMap writableMap) {
        super(view, str);
        this.mPayload = writableMap;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        return EventKeys.MAP_ONCHANGE;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.merge(this.mPayload);
        return writableMapCreateMap;
    }
}
