package com.mappls.sdk.maps.rctmgl.modules;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.offline.OfflineManager;
import com.mappls.sdk.maps.offline.OfflineRegion;
import com.mappls.sdk.maps.offline.OfflineRegionDefinition;
import com.mappls.sdk.maps.offline.OfflineRegionError;
import com.mappls.sdk.maps.offline.OfflineRegionStatus;
import com.mappls.sdk.maps.offline.OfflineTilePyramidRegionDefinition;
import com.mappls.sdk.maps.rctmgl.events.IEvent;
import com.mappls.sdk.maps.rctmgl.events.OfflineEvent;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.mappls.sdk.maps.rctmgl.utils.ConvertUtils;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import com.mappls.sdk.maps.storage.FileSource;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "RCTMGLOfflineModule")
public class RCTMGLOfflineModule extends ReactContextBaseJavaModule {
    public static final int ACTIVE_REGION_DOWNLOAD_STATE = 1;
    public static final int COMPLETE_REGION_DOWNLOAD_STATE = 2;
    public static final int INACTIVE_REGION_DOWNLOAD_STATE = 0;
    public static final String OFFLINE_ERROR = "MapboxOfflineRegionError";
    public static final String OFFLINE_PROGRESS = "MapboxOfflineRegionProgress";
    public static final String REACT_CLASS = "RCTMGLOfflineModule";
    private Double mProgressEventThrottle;
    private ReactApplicationContext mReactContext;
    public static final Double DEFAULT_MIN_ZOOM_LEVEL = Double.valueOf(10.0d);
    public static final Double DEFAULT_MAX_ZOOM_LEVEL = Double.valueOf(20.0d);

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RCTMGLOfflineModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mProgressEventThrottle = Double.valueOf(300.0d);
        this.mReactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTMGLOfflineModule";
    }

    @ReactMethod
    public void createPack(ReadableMap readableMap, final Promise promise) {
        final String string = ConvertUtils.getString("name", readableMap, "");
        OfflineManager.getInstance(this.mReactContext).createOfflineRegion(makeDefinition(getBoundsFromOptions(readableMap), readableMap), getMetadataBytes(ConvertUtils.getString("metadata", readableMap, "")), new OfflineManager.CreateOfflineRegionCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.1
            @Override // com.mappls.sdk.maps.offline.OfflineManager.CreateOfflineRegionCallback
            public void onCreate(OfflineRegion offlineRegion) {
                promise.resolve(RCTMGLOfflineModule.this.fromOfflineRegion(offlineRegion));
                RCTMGLOfflineModule.this.setOfflineRegionObserver(string, offlineRegion);
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.CreateOfflineRegionCallback
            public void onError(String str) {
                RCTMGLOfflineModule rCTMGLOfflineModule = RCTMGLOfflineModule.this;
                rCTMGLOfflineModule.sendEvent(rCTMGLOfflineModule.makeErrorEvent(string, EventTypes.OFFLINE_ERROR, str));
            }
        });
    }

    @ReactMethod
    public void getPacks(final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).listOfflineRegions(new OfflineManager.ListOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.2
            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(OfflineRegion[] offlineRegionArr) {
                WritableArray writableArrayCreateArray = Arguments.createArray();
                for (OfflineRegion offlineRegion : offlineRegionArr) {
                    writableArrayCreateArray.pushMap(RCTMGLOfflineModule.this.fromOfflineRegion(offlineRegion));
                }
                promise.resolve(writableArrayCreateArray);
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(String str) {
                promise.reject("getRegions", str);
            }
        });
    }

    @ReactMethod
    public void invalidateAmbientCache(final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).invalidateAmbientCache(new OfflineManager.FileSourceCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.3
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                promise.resolve(null);
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(String str) {
                promise.reject("invalidateAmbientCache", str);
            }
        });
    }

    @ReactMethod
    public void clearAmbientCache(final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).clearAmbientCache(new OfflineManager.FileSourceCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.4
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                promise.resolve(null);
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(String str) {
                promise.reject("clearAmbientCache", str);
            }
        });
    }

    @ReactMethod
    public void setMaximumAmbientCacheSize(int i, final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).setMaximumAmbientCacheSize(i, new OfflineManager.FileSourceCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.5
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                promise.resolve(null);
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(String str) {
                promise.reject("setMaximumAmbientCacheSize", str);
            }
        });
    }

    @ReactMethod
    public void resetDatabase(final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).resetDatabase(new OfflineManager.FileSourceCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.6
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                promise.resolve(null);
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(String str) {
                promise.reject("resetDatabase", str);
            }
        });
    }

    @ReactMethod
    public void getPackStatus(final String str, final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).listOfflineRegions(new OfflineManager.ListOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.7
            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(OfflineRegion[] offlineRegionArr) {
                OfflineRegion regionByName = RCTMGLOfflineModule.this.getRegionByName(str, offlineRegionArr);
                if (regionByName == null) {
                    promise.resolve(null);
                    Log.w("RCTMGLOfflineModule", "getPackStatus - Unknown offline region");
                } else {
                    regionByName.getStatus(new OfflineRegion.OfflineRegionStatusCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.7.1
                        @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionStatusCallback
                        public void onStatus(OfflineRegionStatus offlineRegionStatus) {
                            promise.resolve(RCTMGLOfflineModule.this.makeRegionStatus(str, offlineRegionStatus));
                        }

                        @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionStatusCallback
                        public void onError(String str2) {
                            promise.reject("getPackStatus", str2);
                        }
                    });
                }
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(String str2) {
                promise.reject("getPackStatus", str2);
            }
        });
    }

    @ReactMethod
    public void setPackObserver(final String str, final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).listOfflineRegions(new OfflineManager.ListOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.8
            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(OfflineRegion[] offlineRegionArr) {
                OfflineRegion regionByName = RCTMGLOfflineModule.this.getRegionByName(str, offlineRegionArr);
                boolean z = regionByName != null;
                if (z) {
                    RCTMGLOfflineModule.this.setOfflineRegionObserver(str, regionByName);
                }
                promise.resolve(Boolean.valueOf(z));
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(String str2) {
                promise.reject("setPackObserver", str2);
            }
        });
    }

    @ReactMethod
    public void invalidatePack(final String str, final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).listOfflineRegions(new OfflineManager.ListOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.9
            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(OfflineRegion[] offlineRegionArr) {
                OfflineRegion regionByName = RCTMGLOfflineModule.this.getRegionByName(str, offlineRegionArr);
                if (regionByName == null) {
                    promise.resolve(null);
                    Log.w("RCTMGLOfflineModule", "invalidateRegion - Unknown offline region");
                } else {
                    regionByName.invalidate(new OfflineRegion.OfflineRegionInvalidateCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.9.1
                        @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionInvalidateCallback
                        public void onInvalidate() {
                            promise.resolve(null);
                        }

                        @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionInvalidateCallback
                        public void onError(String str2) {
                            promise.reject("invalidateRegion", str2);
                        }
                    });
                }
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(String str2) {
                promise.reject("invalidateRegion", str2);
            }
        });
    }

    @ReactMethod
    public void deletePack(final String str, final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).listOfflineRegions(new OfflineManager.ListOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.10
            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(OfflineRegion[] offlineRegionArr) {
                OfflineRegion regionByName = RCTMGLOfflineModule.this.getRegionByName(str, offlineRegionArr);
                if (regionByName == null) {
                    promise.resolve(null);
                    Log.w("RCTMGLOfflineModule", "deleteRegion - Unknown offline region");
                } else {
                    regionByName.setDownloadState(0);
                    regionByName.delete(new OfflineRegion.OfflineRegionDeleteCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.10.1
                        @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionDeleteCallback
                        public void onDelete() {
                            promise.resolve(null);
                        }

                        @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionDeleteCallback
                        public void onError(String str2) {
                            promise.reject("deleteRegion", str2);
                        }
                    });
                }
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(String str2) {
                promise.reject("deleteRegion", str2);
            }
        });
    }

    @ReactMethod
    public void pausePackDownload(final String str, final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).listOfflineRegions(new OfflineManager.ListOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.11
            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(OfflineRegion[] offlineRegionArr) {
                final OfflineRegion regionByName = RCTMGLOfflineModule.this.getRegionByName(str, offlineRegionArr);
                if (regionByName == null) {
                    promise.reject("pauseRegionDownload", "Unknown offline region");
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            regionByName.setDownloadState(0);
                            promise.resolve(null);
                        }
                    });
                }
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(String str2) {
                promise.reject("pauseRegionDownload", str2);
            }
        });
    }

    @ReactMethod
    public void resumePackDownload(final String str, final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).listOfflineRegions(new OfflineManager.ListOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.12
            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(OfflineRegion[] offlineRegionArr) {
                OfflineRegion regionByName = RCTMGLOfflineModule.this.getRegionByName(str, offlineRegionArr);
                if (regionByName == null) {
                    promise.reject("resumeRegionDownload", "Unknown offline region");
                } else {
                    regionByName.setDownloadState(1);
                    promise.resolve(null);
                }
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(String str2) {
                promise.reject("resumeRegionDownload", str2);
            }
        });
    }

    @ReactMethod
    public void mergeOfflineRegions(String str, final Promise promise) {
        activateFileSource();
        OfflineManager.getInstance(this.mReactContext).mergeOfflineRegions(str, new OfflineManager.MergeOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.13
            @Override // com.mappls.sdk.maps.offline.OfflineManager.MergeOfflineRegionsCallback
            public void onMerge(OfflineRegion[] offlineRegionArr) {
                promise.resolve(null);
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.MergeOfflineRegionsCallback
            public void onError(String str2) {
                promise.reject("mergeOfflineRegions", str2);
            }
        });
    }

    @ReactMethod
    public void setTileCountLimit(int i) {
        OfflineManager.getInstance(this.mReactContext).setOfflineMapplsTileCountLimit(i);
    }

    @ReactMethod
    public void setProgressEventThrottle(double d) {
        this.mProgressEventThrottle = Double.valueOf(d);
    }

    private OfflineRegionDefinition makeDefinition(LatLngBounds latLngBounds, ReadableMap readableMap) {
        return new OfflineTilePyramidRegionDefinition(ConvertUtils.getString("styleURL", readableMap, null), latLngBounds, ConvertUtils.getDouble("minZoom", readableMap, DEFAULT_MIN_ZOOM_LEVEL.doubleValue()), ConvertUtils.getDouble("maxZoom", readableMap, DEFAULT_MAX_ZOOM_LEVEL.doubleValue()), this.mReactContext.getResources().getDisplayMetrics().density);
    }

    private byte[] getMetadataBytes(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            Log.w("RCTMGLOfflineModule", e.getLocalizedMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOfflineRegionObserver(final String str, OfflineRegion offlineRegion) {
        offlineRegion.setObserver(new OfflineRegion.OfflineRegionObserver() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule.14
            OfflineRegionStatus prevStatus = null;
            long timestamp = System.currentTimeMillis();

            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionObserver
            public void onStatusChanged(OfflineRegionStatus offlineRegionStatus) {
                if (shouldSendUpdate(System.currentTimeMillis(), offlineRegionStatus)) {
                    RCTMGLOfflineModule rCTMGLOfflineModule = RCTMGLOfflineModule.this;
                    rCTMGLOfflineModule.sendEvent(rCTMGLOfflineModule.makeStatusEvent(str, offlineRegionStatus));
                    this.timestamp = System.currentTimeMillis();
                }
                this.prevStatus = offlineRegionStatus;
            }

            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionObserver
            public void onError(OfflineRegionError offlineRegionError) {
                RCTMGLOfflineModule rCTMGLOfflineModule = RCTMGLOfflineModule.this;
                rCTMGLOfflineModule.sendEvent(rCTMGLOfflineModule.makeErrorEvent(str, EventTypes.OFFLINE_ERROR, offlineRegionError.getMessage()));
            }

            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionObserver
            public void mapplsTileCountLimitExceeded(long j) {
                String str2 = String.format(Locale.getDefault(), "Mappls tile limit exceeded %d", Long.valueOf(j));
                RCTMGLOfflineModule rCTMGLOfflineModule = RCTMGLOfflineModule.this;
                rCTMGLOfflineModule.sendEvent(rCTMGLOfflineModule.makeErrorEvent(str, EventTypes.OFFLINE_TILE_LIMIT, str2));
            }

            private boolean shouldSendUpdate(long j, OfflineRegionStatus offlineRegionStatus) {
                OfflineRegionStatus offlineRegionStatus2 = this.prevStatus;
                if (offlineRegionStatus2 == null) {
                    return false;
                }
                return offlineRegionStatus2.getDownloadState() != offlineRegionStatus.getDownloadState() || ((double) (j - this.timestamp)) > RCTMGLOfflineModule.this.mProgressEventThrottle.doubleValue();
            }
        });
        offlineRegion.setDownloadState(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(IEvent iEvent) {
        getEventEmitter().emit(iEvent.getKey(), iEvent.toJSON());
    }

    private RCTNativeAppEventEmitter getEventEmitter() {
        return (RCTNativeAppEventEmitter) this.mReactContext.getJSModule(RCTNativeAppEventEmitter.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OfflineEvent makeErrorEvent(String str, String str2, String str3) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(StackTraceHelper.MESSAGE_KEY, str3);
        writableNativeMap.putString("name", str);
        return new OfflineEvent(OFFLINE_ERROR, str2, writableNativeMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OfflineEvent makeStatusEvent(String str, OfflineRegionStatus offlineRegionStatus) {
        return new OfflineEvent(OFFLINE_PROGRESS, EventTypes.OFFLINE_STATUS, makeRegionStatus(str, offlineRegionStatus));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WritableMap makeRegionStatus(String str, OfflineRegionStatus offlineRegionStatus) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        int downloadState = offlineRegionStatus.getDownloadState();
        double completedResourceCount = 100.0d;
        if (offlineRegionStatus.isComplete()) {
            downloadState = 2;
        } else {
            completedResourceCount = offlineRegionStatus.getRequiredResourceCount() >= 0 ? (offlineRegionStatus.getCompletedResourceCount() * 100.0d) / offlineRegionStatus.getRequiredResourceCount() : 0.0d;
        }
        writableMapCreateMap.putString("name", str);
        writableMapCreateMap.putInt("state", downloadState);
        writableMapCreateMap.putDouble("percentage", completedResourceCount);
        writableMapCreateMap.putInt("completedResourceCount", (int) offlineRegionStatus.getCompletedResourceCount());
        writableMapCreateMap.putInt("completedResourceSize", (int) offlineRegionStatus.getCompletedResourceSize());
        writableMapCreateMap.putInt("completedTileSize", (int) offlineRegionStatus.getCompletedTileSize());
        writableMapCreateMap.putInt("completedTileCount", (int) offlineRegionStatus.getCompletedTileCount());
        writableMapCreateMap.putInt("requiredResourceCount", (int) offlineRegionStatus.getRequiredResourceCount());
        return writableMapCreateMap;
    }

    private LatLngBounds getBoundsFromOptions(ReadableMap readableMap) {
        return GeoJSONUtils.toLatLngBounds(FeatureCollection.fromJson(ConvertUtils.getString("bounds", readableMap, "{}")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WritableMap fromOfflineRegion(OfflineRegion offlineRegion) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putArray("bounds", GeoJSONUtils.fromLatLngBounds(offlineRegion.getDefinition().getBounds()));
        writableMapCreateMap.putString("metadata", new String(offlineRegion.getMetadata()));
        return writableMapCreateMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OfflineRegion getRegionByName(String str, OfflineRegion[] offlineRegionArr) {
        boolean zEquals;
        if (str != null && !str.isEmpty()) {
            for (OfflineRegion offlineRegion : offlineRegionArr) {
                try {
                    byte[] metadata = offlineRegion.getMetadata();
                    zEquals = metadata != null ? str.equals(new JSONObject(new String(metadata)).getString("name")) : false;
                } catch (JSONException e) {
                    Log.w("RCTMGLOfflineModule", e.getLocalizedMessage());
                }
                if (zEquals) {
                    return offlineRegion;
                }
            }
        }
        return null;
    }

    private void activateFileSource() {
        FileSource.getInstance(this.mReactContext).activate();
    }
}
