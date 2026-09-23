package com.mappls.sdk.maps.rctmgl.events;

import android.location.Location;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class LocationEvent implements IEvent {
    private Location location;
    private RCTMGLMapView mapView;
    private UUID uuid;

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public boolean canCoalesce() {
        return true;
    }

    public LocationEvent(Location location, RCTMGLMapView rCTMGLMapView) {
        this.mapView = rCTMGLMapView;
        this.location = location;
        this.uuid = UUID.randomUUID();
    }

    public LocationEvent(Location location) {
        this(location, null);
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public int getID() {
        RCTMGLMapView rCTMGLMapView = this.mapView;
        if (rCTMGLMapView != null) {
            return rCTMGLMapView.getId();
        }
        return -1;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        return EventKeys.USER_LOCATION_UPDATE;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getType() {
        return EventTypes.USER_LOCATION_UPDATED;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public long getTimestamp() {
        return System.currentTimeMillis();
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public boolean equals(IEvent iEvent) {
        return getUUID().equals(((LocationEvent) iEvent).getUUID());
    }

    public boolean equals(LocationEvent locationEvent) {
        return this.uuid.equals(locationEvent.getUUID());
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("longitude", this.location.getLongitude());
        writableNativeMap2.putDouble("latitude", this.location.getLatitude());
        writableNativeMap2.putDouble(SavingTrackHelper.TRACK_COL_ALTITUDE, this.location.getAltitude());
        writableNativeMap2.putDouble("accuracy", this.location.getAccuracy());
        writableNativeMap2.putDouble("heading", this.location.getBearing());
        writableNativeMap2.putDouble("course", this.location.getBearing());
        writableNativeMap2.putDouble("speed", this.location.getSpeed());
        writableNativeMap.putMap("coords", writableNativeMap2);
        writableNativeMap.putDouble("timestamp", this.location.getTime());
        return writableNativeMap;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap toJSON() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", getType());
        writableMapCreateMap.putMap("payload", getPayload());
        return writableMapCreateMap;
    }
}
