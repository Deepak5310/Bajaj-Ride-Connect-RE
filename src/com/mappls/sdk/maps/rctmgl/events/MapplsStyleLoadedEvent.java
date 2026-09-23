package com.mappls.sdk.maps.rctmgl.events;

import android.view.View;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.mappls.sdk.maps.style.model.MapplsStyle;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsStyleLoadedEvent extends AbstractEvent {
    List<MapplsStyle> mapplsStyles;

    public MapplsStyleLoadedEvent(View view, List<MapplsStyle> list) {
        super(view, EventTypes.DID_LOADED_MAPPLS_MAP_STYLES);
        this.mapplsStyles = list;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.IEvent
    public String getKey() {
        return EventKeys.MAP_STYLE_LOADED;
    }

    @Override // com.mappls.sdk.maps.rctmgl.events.AbstractEvent, com.mappls.sdk.maps.rctmgl.events.IEvent
    public WritableMap getPayload() {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        List<MapplsStyle> list = this.mapplsStyles;
        if (list != null) {
            for (MapplsStyle mapplsStyle : list) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("name", mapplsStyle.getName());
                writableNativeMap.putString("imageUrl", mapplsStyle.getImageUrl());
                writableNativeMap.putString("displayName", mapplsStyle.getDisplayName());
                writableNativeMap.putString(SavingTrackHelper.POINT_COL_DESCRIPTION, mapplsStyle.getDescription());
                writableNativeArray.pushMap(writableNativeMap);
            }
        }
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putArray("mappls_styles", writableNativeArray);
        return writableNativeMap2;
    }
}
