package com.mappls.sdk.maps.rctmgl.modules;

import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.rctmgl.utils.BitmapUtils;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import com.mappls.sdk.maps.snapshotter.MapSnapshot;
import com.mappls.sdk.maps.snapshotter.MapSnapshotter;
import com.mappls.sdk.maps.storage.FileSource;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "RCTMGLSnapshotModule")
public class RCTMGLSnapshotModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "RCTMGLSnapshotModule";
    private ReactApplicationContext mContext;
    private Map<String, MapSnapshotter> mSnapshotterMap;

    public RCTMGLSnapshotModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
        this.mSnapshotterMap = new HashMap();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTMGLSnapshotModule";
    }

    @ReactMethod
    public void takeSnap(final ReadableMap readableMap, final Promise promise) {
        FileSource.getInstance(this.mContext).activate();
        this.mContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLSnapshotModule.1
            @Override // java.lang.Runnable
            public void run() {
                final String string = UUID.randomUUID().toString();
                MapSnapshotter mapSnapshotter = new MapSnapshotter(RCTMGLSnapshotModule.this.mContext, RCTMGLSnapshotModule.this.getOptions(readableMap));
                RCTMGLSnapshotModule.this.mSnapshotterMap.put(string, mapSnapshotter);
                mapSnapshotter.start(new MapSnapshotter.SnapshotReadyCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLSnapshotModule.1.1
                    @Override // com.mappls.sdk.maps.snapshotter.MapSnapshotter.SnapshotReadyCallback
                    public void onSnapshotReady(MapSnapshot mapSnapshot) {
                        String strCreateBase64;
                        Bitmap bitmap = mapSnapshot.getBitmap();
                        if (readableMap.getBoolean("writeToDisk")) {
                            strCreateBase64 = BitmapUtils.createTempFile(RCTMGLSnapshotModule.this.mContext, bitmap);
                        } else {
                            strCreateBase64 = BitmapUtils.createBase64(bitmap);
                        }
                        if (strCreateBase64 == null) {
                            promise.reject("RCTMGLSnapshotModule", "Could not generate snapshot, please check Android logs for more info.");
                        } else {
                            promise.resolve(strCreateBase64);
                            RCTMGLSnapshotModule.this.mSnapshotterMap.remove(string);
                        }
                    }
                }, new MapSnapshotter.ErrorHandler() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLSnapshotModule.1.2
                    @Override // com.mappls.sdk.maps.snapshotter.MapSnapshotter.ErrorHandler
                    public void onError(String str) {
                        Log.w("RCTMGLSnapshotModule", str);
                        RCTMGLSnapshotModule.this.mSnapshotterMap.remove(string);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapSnapshotter.Options getOptions(ReadableMap readableMap) {
        MapSnapshotter.Options options = new MapSnapshotter.Options((int) readableMap.getDouble("width"), (int) readableMap.getDouble("height"));
        options.withLogo(readableMap.getBoolean("withLogo"));
        options.withMapplsStyle(readableMap.getString("styleURL"));
        options.withPixelRatio(Float.valueOf(this.mContext.getResources().getDisplayMetrics().scaledDensity).intValue());
        if (readableMap.hasKey("bounds")) {
            options.withRegion(GeoJSONUtils.toLatLngBounds(FeatureCollection.fromJson(readableMap.getString("bounds"))));
        } else {
            options.withCameraPosition(new CameraPosition.Builder().target(GeoJSONUtils.toLatLng((Point) Feature.fromJson(readableMap.getString("centerCoordinate")).geometry())).tilt(readableMap.getDouble("pitch")).bearing(readableMap.getDouble("heading")).zoom(readableMap.getDouble("zoomLevel")).build());
        }
        return options;
    }

    private void closeSnapshotOutputStream(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            Log.w("RCTMGLSnapshotModule", e.getLocalizedMessage());
        }
    }
}
