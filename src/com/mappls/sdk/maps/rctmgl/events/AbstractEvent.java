package com.mappls.sdk.maps.rctmgl.events;

import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractEvent implements IEvent {
    private String mEventType;
    private int mTagID;
    private long mTimestamp;

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public boolean canCoalesce() {
        return true;
    }

    public AbstractEvent(String str) {
        this(null, str);
    }

    public AbstractEvent(View view, String str) {
        this.mEventType = str;
        if (view != null) {
            this.mTagID = view.getId();
        }
        this.mTimestamp = System.currentTimeMillis();
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public int getID() {
        return this.mTagID;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getType() {
        return this.mEventType;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public boolean equals(IEvent iEvent) {
        return getKey().equals(iEvent.getKey()) && this.mEventType.equals(iEvent.getType());
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        return Arguments.createMap();
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public long getTimestamp() {
        return this.mTimestamp;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap toJSON() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", getType());
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.merge(getPayload());
        writableMapCreateMap.putMap("payload", writableMapCreateMap2);
        return writableMapCreateMap;
    }
}
