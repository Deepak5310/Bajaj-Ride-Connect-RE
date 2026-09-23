package com.mappls.sdk.maps.rctmgl.events;

import android.view.View;
import com.facebook.react.bridge.WritableMap;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;

/* JADX INFO: loaded from: classes4.dex */
public class AndroidCallbackEvent extends AbstractEvent {
    private final WritableMap mPayload;

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public boolean canCoalesce() {
        return false;
    }

    public AndroidCallbackEvent(View view, String str, WritableMap writableMap) {
        super(view, str);
        this.mPayload = writableMap;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        return EventKeys.MAP_ANDROID_CALLBACK;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        return this.mPayload;
    }
}
