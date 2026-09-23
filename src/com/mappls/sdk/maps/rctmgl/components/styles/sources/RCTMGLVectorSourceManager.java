package com.mappls.sdk.maps.rctmgl.components.styles.sources;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.utils.ConvertUtils;
import com.mappls.sdk.maps.rctmgl.utils.ExpressionParser;
import java.util.Map;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLVectorSourceManager extends RCTMGLTileSourceManager<RCTMGLVectorSource> {
    public static final int METHOD_FEATURES = 102;
    public static final String REACT_CLASS = "RCTMGLVectorSource";

    public RCTMGLVectorSourceManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @Nonnull
    public RCTMGLVectorSource createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        return new RCTMGLVectorSource(themedReactContext, this);
    }

    @ReactProp(name = "hasPressListener")
    public void setHasPressListener(RCTMGLVectorSource rCTMGLVectorSource, boolean z) {
        rCTMGLVectorSource.setHasPressListener(z);
    }

    @ReactProp(name = "hitbox")
    public void setHitbox(RCTMGLVectorSource rCTMGLVectorSource, ReadableMap readableMap) {
        rCTMGLVectorSource.setHitbox(readableMap);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter
    public Map<String, String> customEvents() {
        return MapBuilder.builder().put(EventKeys.VECTOR_SOURCE_LAYER_CLICK, "onMapboxVectorSourcePress").put(EventKeys.MAP_ANDROID_CALLBACK, "onAndroidCallback").build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.builder().put("features", 102).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(RCTMGLVectorSource rCTMGLVectorSource, int i, ReadableArray readableArray) {
        if (i != 102) {
            return;
        }
        rCTMGLVectorSource.querySourceFeatures(readableArray.getString(0), ConvertUtils.toStringList(readableArray.getArray(1)), ExpressionParser.from(readableArray.getArray(2)));
    }
}
