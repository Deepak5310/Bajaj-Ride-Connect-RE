package com.reactnativekeyboardcontroller;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativekeyboardcontroller.managers.KeyboardGestureAreaViewManagerImpl;
import com.reactnativekeyboardcontroller.views.KeyboardGestureAreaReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardGestureAreaViewManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardGestureAreaViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "()V", "manager", "Lcom/reactnativekeyboardcontroller/managers/KeyboardGestureAreaViewManagerImpl;", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/KeyboardGestureAreaReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "", "setInterpolator", "", "view", TypedValues.CycleType.S_WAVE_OFFSET, "", "interpolator", "setScrollKeyboardOffScreenWhenVisible", "value", "", "setScrollKeyboardOnScreenWhenNotVisible", "setTextInputNativeID", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KeyboardGestureAreaViewManager extends ReactViewManager {
    private final KeyboardGestureAreaViewManagerImpl manager = new KeyboardGestureAreaViewManagerImpl();

    @ReactProp(name = "textInputNativeID")
    public final void setTextInputNativeID(KeyboardGestureAreaReactViewGroup view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardGestureAreaViewManagerImpl.NAME;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public KeyboardGestureAreaReactViewGroup createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return this.manager.createViewInstance(reactContext);
    }

    @ReactProp(name = TypedValues.CycleType.S_WAVE_OFFSET)
    public final void setInterpolator(KeyboardGestureAreaReactViewGroup view, double offset) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setOffset(view, offset);
    }

    @ReactProp(name = "interpolator")
    public final void setInterpolator(KeyboardGestureAreaReactViewGroup view, String interpolator) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.manager.setInterpolator(view, interpolator);
    }

    @ReactProp(name = "showOnSwipeUp")
    public final void setScrollKeyboardOnScreenWhenNotVisible(KeyboardGestureAreaReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setScrollKeyboardOnScreenWhenNotVisible(view, value);
    }

    @ReactProp(name = "enableSwipeToDismiss")
    public final void setScrollKeyboardOffScreenWhenVisible(KeyboardGestureAreaReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setScrollKeyboardOffScreenWhenVisible(view, value);
    }
}
