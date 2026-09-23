package com.mappls.sdk.maps.rctmgl.events;

import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes4.dex */
public interface IEvent {
    boolean canCoalesce();

    boolean equals(IEvent iEvent);

    int getID();

    String getKey();

    WritableMap getPayload();

    long getTimestamp();

    String getType();

    WritableMap toJSON();
}
