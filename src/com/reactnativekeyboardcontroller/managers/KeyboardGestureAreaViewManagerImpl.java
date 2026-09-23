package com.reactnativekeyboardcontroller.managers;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.KeyboardGestureAreaReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardGestureAreaViewManagerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0014"}, d2 = {"Lcom/reactnativekeyboardcontroller/managers/KeyboardGestureAreaViewManagerImpl;", "", "()V", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/KeyboardGestureAreaReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setInterpolator", "", "view", "interpolator", "", "setOffset", TypedValues.CycleType.S_WAVE_OFFSET, "", "setScrollKeyboardOffScreenWhenVisible", "value", "", "setScrollKeyboardOnScreenWhenNotVisible", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KeyboardGestureAreaViewManagerImpl {
    public static final String NAME = "KeyboardGestureArea";

    public final KeyboardGestureAreaReactViewGroup createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new KeyboardGestureAreaReactViewGroup(reactContext);
    }

    public final void setOffset(KeyboardGestureAreaReactViewGroup view, double offset) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOffset(offset);
    }

    public final void setInterpolator(KeyboardGestureAreaReactViewGroup view, String interpolator) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        view.setInterpolator(interpolator);
    }

    public final void setScrollKeyboardOffScreenWhenVisible(KeyboardGestureAreaReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollKeyboardOffScreenWhenVisible(value);
    }

    public final void setScrollKeyboardOnScreenWhenNotVisible(KeyboardGestureAreaReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollKeyboardOnScreenWhenNotVisible(value);
    }
}
