package com.mappls.sdk.maps.rctmgl.components.annotation;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLPointAnnotationManager extends AbstractEventEmitter<RCTMGLPointAnnotation> {
    public static final int METHOD_REFRESH = 2;
    public static final String REACT_CLASS = "RCTMGLPointAnnotation";

    public RCTMGLPointAnnotationManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter
    public Map<String, String> customEvents() {
        return MapBuilder.builder().put(EventKeys.POINT_ANNOTATION_SELECTED, "onMapboxPointAnnotationSelected").put(EventKeys.POINT_ANNOTATION_DESELECTED, "onMapboxPointAnnotationDeselected").put(EventKeys.POINT_ANNOTATION_DRAG_START, "onMapboxPointAnnotationDragStart").put(EventKeys.POINT_ANNOTATION_DRAG, "onMapboxPointAnnotationDrag").put(EventKeys.POINT_ANNOTATION_DRAG_END, "onMapboxPointAnnotationDragEnd").build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.builder().put("refresh", 2).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLPointAnnotation createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLPointAnnotation(themedReactContext, this);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLPointAnnotation rCTMGLPointAnnotation, String str) {
        rCTMGLPointAnnotation.setID(str);
    }

    @ReactProp(name = "coordinate")
    public void setCoordinate(RCTMGLPointAnnotation rCTMGLPointAnnotation, String str) {
        rCTMGLPointAnnotation.setCoordinate(GeoJSONUtils.toPointGeometry(str));
    }

    @ReactProp(name = "mapplsPin")
    public void setMapplsPin(RCTMGLPointAnnotation rCTMGLPointAnnotation, String str) {
        rCTMGLPointAnnotation.setMapplsPin(str);
    }

    @ReactProp(name = "anchor")
    public void setAnchor(RCTMGLPointAnnotation rCTMGLPointAnnotation, ReadableMap readableMap) {
        rCTMGLPointAnnotation.setAnchor((float) readableMap.getDouble("x"), (float) readableMap.getDouble("y"));
    }

    @ReactProp(name = "draggable")
    public void setDraggable(RCTMGLPointAnnotation rCTMGLPointAnnotation, Boolean bool) {
        rCTMGLPointAnnotation.setDraggable(bool);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(RCTMGLPointAnnotation rCTMGLPointAnnotation, int i, ReadableArray readableArray) {
        if (i != 2) {
            return;
        }
        rCTMGLPointAnnotation.refresh();
    }
}
