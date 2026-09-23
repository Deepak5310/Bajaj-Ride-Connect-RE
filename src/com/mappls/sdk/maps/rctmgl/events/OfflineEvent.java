package com.mappls.sdk.maps.rctmgl.events;

import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes4.dex */
public class OfflineEvent extends AbstractEvent {
    private String mEventKey;
    private WritableMap mPayload;

    public OfflineEvent(String str, String str2, WritableMap writableMap) {
        super(str2);
        this.mEventKey = str;
        this.mPayload = writableMap;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        return this.mEventKey;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        return this.mPayload;
    }
}
