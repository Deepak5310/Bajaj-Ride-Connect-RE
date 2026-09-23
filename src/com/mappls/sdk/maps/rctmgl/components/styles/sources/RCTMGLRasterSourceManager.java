package com.mappls.sdk.maps.rctmgl.components.styles.sources;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLRasterSourceManager extends RCTMGLTileSourceManager<RCTMGLRasterSource> {
    public static final String REACT_CLASS = "RCTMGLRasterSource";

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter
    public Map<String, String> customEvents() {
        return null;
    }

    public RCTMGLRasterSourceManager(ReactApplicationContext reactApplicationContext) {
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
    public RCTMGLRasterSource createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        return new RCTMGLRasterSource(themedReactContext);
    }

    @ReactProp(name = "tileSize")
    public void setTileSize(RCTMGLRasterSource rCTMGLRasterSource, int i) {
        rCTMGLRasterSource.setTileSize(i);
    }
}
