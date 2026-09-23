package com.mappls.sdk.maps.rctmgl.components.styles;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RCTMGLStyleFunctionParser<T, V> {
    private RCTMGLStyleValue mStyleValue;

    protected abstract T getRawStopValue(RCTMGLStyleValue rCTMGLStyleValue);

    protected abstract PropertyValue<V> getStopValue(T t);

    public RCTMGLStyleFunctionParser(RCTMGLStyleValue rCTMGLStyleValue) {
        this.mStyleValue = rCTMGLStyleValue;
    }

    public List<RCTMGLStyleFunctionParser<T, V>.StopConfig> getRawStops() {
        Object objAsString;
        StopConfig stopConfig;
        ReadableArray array = this.mStyleValue.getArray("stops");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            ReadableArray array2 = array.getArray(i);
            ReadableMap map = array2.getMap(0);
            RCTMGLStyleValue rCTMGLStyleValue = new RCTMGLStyleValue(array2.getMap(1));
            try {
                Dynamic dynamic = rCTMGLStyleValue.getDynamic("propertyValue");
                ReadableType type = dynamic.getType();
                if (type.equals(ReadableType.Number)) {
                    objAsString = Double.valueOf(dynamic.asDouble());
                } else if (type.equals(ReadableType.Boolean)) {
                    objAsString = Boolean.valueOf(dynamic.asBoolean());
                } else {
                    objAsString = dynamic.asString();
                }
            } catch (NoSuchKeyException unused) {
                objAsString = null;
            }
            if (objAsString != null) {
                stopConfig = new StopConfig(getStopKey(map), getRawStopValue(rCTMGLStyleValue), objAsString);
            } else {
                stopConfig = new StopConfig(this, getStopKey(map), getRawStopValue(rCTMGLStyleValue));
            }
            arrayList.add(stopConfig);
        }
        return arrayList;
    }

    private Object getStopKey(ReadableMap readableMap) {
        String string = readableMap.getString("type");
        string.hashCode();
        if (string.equals("number")) {
            return Double.valueOf(readableMap.getDouble("value"));
        }
        if (string.equals(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.valueOf(readableMap.getBoolean("value"));
        }
        return readableMap.getString("value");
    }

    private class StopConfig {
        Object key;
        Object propertyValue;
        T value;

        StopConfig(RCTMGLStyleFunctionParser rCTMGLStyleFunctionParser, Object obj, T t) {
            this(obj, t, null);
        }

        StopConfig(Object obj, T t, Object obj2) {
            this.key = obj;
            this.value = t;
            this.propertyValue = obj2;
        }
    }
}
