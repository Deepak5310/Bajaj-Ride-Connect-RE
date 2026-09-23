package com.reactnativekeyboardcontroller;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativekeyboardcontroller.managers.KeyboardControllerViewManagerImpl;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardControllerViewManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0014J\"\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001aH\u0007J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001aH\u0007J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardControllerViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "()V", "manager", "Lcom/reactnativekeyboardcontroller/managers/KeyboardControllerViewManagerImpl;", "createViewInstance", "Lcom/facebook/react/views/view/ReactViewGroup;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "invalidate", "", "onAfterUpdateTransaction", "view", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "setEnabled", "Lcom/reactnativekeyboardcontroller/views/EdgeToEdgeReactViewGroup;", ViewProps.ENABLED, "", "setNavigationBarTranslucent", "isNavigationBarTranslucent", "setPreserveEdgeToEdge", "isPreservingEdgeToEdge", "setStatusBarTranslucent", "isStatusBarTranslucent", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KeyboardControllerViewManager extends ReactViewManager {
    private final KeyboardControllerViewManagerImpl manager = new KeyboardControllerViewManagerImpl();

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.manager.createViewInstance(context);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        this.manager.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        this.manager.setEdgeToEdge((EdgeToEdgeReactViewGroup) view);
    }

    @ReactProp(name = ViewProps.ENABLED)
    public final void setEnabled(EdgeToEdgeReactViewGroup view, boolean enabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setEnabled(view, enabled);
    }

    @ReactProp(name = "statusBarTranslucent")
    public final void setStatusBarTranslucent(EdgeToEdgeReactViewGroup view, boolean isStatusBarTranslucent) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setStatusBarTranslucent(view, isStatusBarTranslucent);
    }

    @ReactProp(name = "navigationBarTranslucent")
    public final void setNavigationBarTranslucent(EdgeToEdgeReactViewGroup view, boolean isNavigationBarTranslucent) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setNavigationBarTranslucent(view, isNavigationBarTranslucent);
    }

    @ReactProp(name = "preserveEdgeToEdge")
    public final void setPreserveEdgeToEdge(EdgeToEdgeReactViewGroup view, boolean isPreservingEdgeToEdge) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setPreserveEdgeToEdge(view, isPreservingEdgeToEdge);
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactViewGroup root, String commandId, ReadableArray args) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        if (Intrinsics.areEqual(commandId, "synchronizeFocusedInputLayout")) {
            this.manager.synchronizeFocusedInputLayout((EdgeToEdgeReactViewGroup) root);
        } else {
            super.receiveCommand(root, commandId, args);
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return this.manager.getExportedCustomDirectEventTypeConstants();
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardControllerViewManagerImpl.NAME;
    }
}
