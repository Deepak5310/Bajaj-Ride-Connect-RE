package com.mappls.sdk.maps.rctmgl.components.images;

import android.graphics.drawable.BitmapDrawable;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.utils.ImageEntry;
import com.mappls.sdk.maps.rctmgl.utils.ResourceUtils;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLImagesManager extends AbstractEventEmitter<RCTMGLImages> {
    public static final String REACT_CLASS = "RCTMGLImages";
    private ReactApplicationContext mContext;

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    public RCTMGLImagesManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLImages createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLImages(themedReactContext, this);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLImages rCTMGLImages, String str) {
        rCTMGLImages.setID(str);
    }

    @ReactProp(name = "images")
    public void setImages(RCTMGLImages rCTMGLImages, ReadableMap readableMap) {
        ImageEntry imageEntry;
        ArrayList arrayList = new ArrayList();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            if (readableMap.getType(strNextKey) == ReadableType.Map) {
                ReadableMap map = readableMap.getMap(strNextKey);
                imageEntry = new ImageEntry(map.getString(ReactNativeBlobUtilConst.DATA_ENCODE_URI), Double.valueOf((map.hasKey("scale") && map.getType("scale") == ReadableType.Number) ? map.getDouble("scale") : 0.0d));
            } else {
                imageEntry = new ImageEntry(readableMap.getString(strNextKey));
            }
            arrayList.add(new AbstractMap.SimpleEntry(strNextKey, imageEntry));
        }
        rCTMGLImages.setImages(arrayList);
    }

    @ReactProp(name = "hasOnImageMissing")
    public void setHasOnImageMissing(RCTMGLImages rCTMGLImages, Boolean bool) {
        rCTMGLImages.setHasOnImageMissing(bool.booleanValue());
    }

    @ReactProp(name = "nativeImages")
    public void setNativeImages(RCTMGLImages rCTMGLImages, ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ResourceUtils.getDrawableByName(this.mContext, string);
            if (bitmapDrawable != null) {
                arrayList.add(new AbstractMap.SimpleEntry(string, bitmapDrawable));
            }
        }
        rCTMGLImages.setNativeImages(arrayList);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter
    public Map<String, String> customEvents() {
        return MapBuilder.builder().put(EventKeys.IMAGES_MISSING, "onImageMissing").build();
    }
}
