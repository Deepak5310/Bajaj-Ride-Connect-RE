package com.reactnativekeyboardcontroller.extensions;

import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import com.reactnativekeyboardcontroller.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThemedReactContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n\u001a\u001c\u0010\u000b\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u000e\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b\"\u0017\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000f"}, d2 = {"appearance", "", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getAppearance", "(Lcom/facebook/react/uimanager/ThemedReactContext;)Ljava/lang/String;", "dispatchEvent", "", "viewId", "", NotificationCompat.CATEGORY_EVENT, "Lcom/facebook/react/uimanager/events/Event;", "emitEvent", "params", "Lcom/facebook/react/bridge/WritableMap;", "keepShadowNodesInSync", "react-native-keyboard-controller_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ThemedReactContextKt {
    public static final void dispatchEvent(ThemedReactContext themedReactContext, int i, Event<?> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNull(themedReactContext, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, i);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(event);
        }
    }

    public static final void emitEvent(ThemedReactContext themedReactContext, String event, WritableMap params) {
        ReactApplicationContext reactApplicationContext;
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        if (themedReactContext != null && (reactApplicationContext = themedReactContext.getReactApplicationContext()) != null && (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) != null) {
            rCTDeviceEventEmitter.emit(event, params);
        }
        Logger.i$default(Logger.INSTANCE, "ThemedReactContext", event, null, 4, null);
    }

    public static final void keepShadowNodesInSync(ThemedReactContext themedReactContext, int i) {
        ReactApplicationContext reactApplicationContext;
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(new int[]{i}[0]);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putArray("tags", writableArrayCreateArray);
        if (themedReactContext == null || (reactApplicationContext = themedReactContext.getReactApplicationContext()) == null) {
            return;
        }
        reactApplicationContext.emitDeviceEvent("onUserDrivenAnimationEnded", writableMapCreateMap);
    }

    public static final String getAppearance(ThemedReactContext themedReactContext) {
        return (themedReactContext != null && ContextKt.isSystemDarkMode(themedReactContext)) ? WeatherCriteria.THEME_DARK : WeatherCriteria.THEME_LIGHT;
    }
}
