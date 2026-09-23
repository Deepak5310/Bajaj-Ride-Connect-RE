package com.mappls.sdk.maps.rctmgl.events;

import android.view.View;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;

/* JADX INFO: loaded from: classes4.dex */
public class IndoorControlHideEvent extends AbstractEvent {
    public IndoorControlHideEvent(View view) {
        super(view, EventTypes.HIDE_INDOOR_CONTROL);
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        return EventKeys.HIDE_INDOOR_CONTROL;
    }
}
