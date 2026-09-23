package com.mappls.sdk.maps.rctmgl;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.mappls.sdk.maps.rctmgl.components.annotation.RCTMGLCalloutManager;
import com.mappls.sdk.maps.rctmgl.components.annotation.RCTMGLMarkerViewManager;
import com.mappls.sdk.maps.rctmgl.components.annotation.RCTMGLPointAnnotationManager;
import com.mappls.sdk.maps.rctmgl.components.camera.RCTMGLCameraManager;
import com.mappls.sdk.maps.rctmgl.components.geoAnalytics.RCTMGLGeoAnalyticsManager;
import com.mappls.sdk.maps.rctmgl.components.images.RCTMGLImagesManager;
import com.mappls.sdk.maps.rctmgl.components.location.RCTMGLNativeUserLocationManager;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLAndroidTextureMapViewManager;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapViewManager;
import com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTMGLBackgroundLayerManager;
import com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTMGLCircleLayerManager;
import com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTMGLFillExtrusionLayerManager;
import com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTMGLFillLayerManager;
import com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTMGLHeatmapLayerManager;
import com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTMGLLineLayerManager;
import com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTMGLRasterLayerManager;
import com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTMGLSymbolLayerManager;
import com.mappls.sdk.maps.rctmgl.components.styles.light.RCTMGLLightManager;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLImageSourceManager;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLRasterSourceManager;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLShapeSourceManager;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLVectorSourceManager;
import com.mappls.sdk.maps.rctmgl.modules.RCTMGLLocationModule;
import com.mappls.sdk.maps.rctmgl.modules.RCTMGLLogging;
import com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule;
import com.mappls.sdk.maps.rctmgl.modules.RCTMGLOfflineModule;
import com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule;
import com.mappls.sdk.maps.rctmgl.modules.RCTMGLSnapshotModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RCTMGLModule(reactApplicationContext));
        arrayList.add(new RCTMGLOfflineModule(reactApplicationContext));
        arrayList.add(new RCTMGLSnapshotModule(reactApplicationContext));
        arrayList.add(new RCTMGLLocationModule(reactApplicationContext));
        arrayList.add(new RCTMGLLogging(reactApplicationContext));
        arrayList.add(new RCTMGLRestApiModule(reactApplicationContext));
        return arrayList;
    }

    @Deprecated
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RCTMGLCameraManager(reactApplicationContext));
        arrayList.add(new RCTMGLMapViewManager(reactApplicationContext));
        arrayList.add(new RCTMGLMarkerViewManager(reactApplicationContext));
        arrayList.add(new RCTMGLAndroidTextureMapViewManager(reactApplicationContext));
        arrayList.add(new RCTMGLLightManager());
        arrayList.add(new RCTMGLPointAnnotationManager(reactApplicationContext));
        arrayList.add(new RCTMGLCalloutManager());
        arrayList.add(new RCTMGLNativeUserLocationManager());
        arrayList.add(new RCTMGLVectorSourceManager(reactApplicationContext));
        arrayList.add(new RCTMGLShapeSourceManager(reactApplicationContext));
        arrayList.add(new RCTMGLRasterSourceManager(reactApplicationContext));
        arrayList.add(new RCTMGLImageSourceManager());
        arrayList.add(new RCTMGLImagesManager(reactApplicationContext));
        arrayList.add(new RCTMGLFillLayerManager());
        arrayList.add(new RCTMGLFillExtrusionLayerManager());
        arrayList.add(new RCTMGLHeatmapLayerManager());
        arrayList.add(new RCTMGLLineLayerManager());
        arrayList.add(new RCTMGLCircleLayerManager());
        arrayList.add(new RCTMGLSymbolLayerManager());
        arrayList.add(new RCTMGLRasterLayerManager());
        arrayList.add(new RCTMGLBackgroundLayerManager());
        arrayList.add(new RCTMGLGeoAnalyticsManager(reactApplicationContext));
        return arrayList;
    }
}
