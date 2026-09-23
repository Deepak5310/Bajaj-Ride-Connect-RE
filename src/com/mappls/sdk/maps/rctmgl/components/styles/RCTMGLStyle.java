package com.mappls.sdk.maps.rctmgl.components.styles;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.rctmgl.utils.DownloadMapImageTask;
import com.mappls.sdk.maps.rctmgl.utils.ImageEntry;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLStyle {
    private Context mContext;
    private MapplsMap mMap;
    private ReadableMap mReactStyle;

    public RCTMGLStyle(Context context, ReadableMap readableMap, MapplsMap mapplsMap) {
        this.mContext = context;
        this.mReactStyle = readableMap;
        this.mMap = mapplsMap;
    }

    public List<String> getAllStyleKeys() {
        ReadableMap readableMap = this.mReactStyle;
        if (readableMap == null) {
            return new ArrayList();
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        ArrayList arrayList = new ArrayList();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            if (!strNextKey.equals("__MAPBOX_STYLESHEET__")) {
                arrayList.add(strNextKey);
            }
        }
        return arrayList;
    }

    public RCTMGLStyleValue getStyleValueForKey(String str) {
        ReadableMap map = this.mReactStyle.getMap(str);
        if (map == null) {
            return null;
        }
        return new RCTMGLStyleValue(map);
    }

    public void addImage(RCTMGLStyleValue rCTMGLStyleValue) {
        addImage(rCTMGLStyleValue, null);
    }

    public ImageEntry imageEntry(RCTMGLStyleValue rCTMGLStyleValue) {
        return new ImageEntry(rCTMGLStyleValue.getImageURI(), Double.valueOf(rCTMGLStyleValue.getImageScale()));
    }

    public void addImage(RCTMGLStyleValue rCTMGLStyleValue, DownloadMapImageTask.OnAllImagesLoaded onAllImagesLoaded) {
        if (rCTMGLStyleValue.shouldAddImage()) {
            new DownloadMapImageTask(this.mContext, this.mMap, onAllImagesLoaded).execute(new AbstractMap.SimpleEntry(rCTMGLStyleValue.getImageURI(), imageEntry(rCTMGLStyleValue)));
        } else if (onAllImagesLoaded != null) {
            onAllImagesLoaded.onAllImagesLoaded();
        }
    }
}
