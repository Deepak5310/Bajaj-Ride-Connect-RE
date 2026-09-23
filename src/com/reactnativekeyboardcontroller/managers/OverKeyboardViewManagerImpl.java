package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.overlay.OverKeyboardHostView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverKeyboardViewManagerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/reactnativekeyboardcontroller/managers/OverKeyboardViewManagerImpl;", "", "()V", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/overlay/OverKeyboardHostView;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setVisible", "", "view", "value", "", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OverKeyboardViewManagerImpl {
    public static final String NAME = "OverKeyboardView";

    public final OverKeyboardHostView createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new OverKeyboardHostView(reactContext);
    }

    public final void setVisible(OverKeyboardHostView view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value) {
            view.show();
        } else {
            view.hide();
        }
    }
}
