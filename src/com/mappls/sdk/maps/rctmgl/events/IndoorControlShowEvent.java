package com.mappls.sdk.maps.rctmgl.events;

import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;

/* JADX INFO: loaded from: classes4.dex */
public class IndoorControlShowEvent extends AbstractEvent {
    private int floors;
    private int initialFloor;
    private int selectedFloor;

    public IndoorControlShowEvent(View view, int i, int i2, int i3) {
        super(view, EventTypes.SHOW_INDOOR_CONTROL);
        this.initialFloor = i;
        this.selectedFloor = i2;
        this.floors = i3;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        return EventKeys.SHOW_INDOOR_CONTROL;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("initialFloor", this.initialFloor);
        writableMapCreateMap.putInt("selectedFloor", this.selectedFloor);
        writableMapCreateMap.putInt("floors", this.floors);
        return writableMapCreateMap;
    }
}
