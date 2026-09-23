package com.mappls.sdk.maps.rctmgl.events;

import android.view.View;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.devsupport.StackTraceHelper;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.spotify.sdk.android.auth.AccountsQueryParameters;

/* JADX INFO: loaded from: classes4.dex */
public class MapErrorEvent extends AbstractEvent {
    private int code;
    private String message;

    public MapErrorEvent(View view, int i, String str) {
        super(view, EventTypes.DID_FAIL_LOADING_MAP);
        this.code = i;
        this.message = str;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        return EventKeys.MAP_ERROR;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt(AccountsQueryParameters.CODE, this.code);
        writableNativeMap.putString(StackTraceHelper.MESSAGE_KEY, this.message);
        return writableNativeMap;
    }
}
