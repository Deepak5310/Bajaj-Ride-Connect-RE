package com.mappls.sdk.maps.rctmgl.utils;

import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter;
import com.mappls.sdk.maps.rctmgl.events.IEvent;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleEventCallback implements MapplsMap.CancelableCallback {
    private IEvent mEvent;
    private AbstractEventEmitter mEventEmitter;

    public SimpleEventCallback(AbstractEventEmitter abstractEventEmitter, IEvent iEvent) {
        this.mEventEmitter = abstractEventEmitter;
        this.mEvent = iEvent;
    }

    @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
    public void onCancel() {
        this.mEventEmitter.handleEvent(this.mEvent);
    }

    @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
    public void onFinish() {
        this.mEventEmitter.handleEvent(this.mEvent);
    }
}
