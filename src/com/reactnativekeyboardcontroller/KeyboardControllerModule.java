package com.reactnativekeyboardcontroller;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.henninghall.date_picker.props.ModeProp;
import com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardControllerModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0007J\u0017\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\bH\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\nH\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0013H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardControllerModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "mReactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "module", "Lcom/reactnativekeyboardcontroller/modules/KeyboardControllerModuleImpl;", "addListener", "", "eventName", "", "dismiss", "keepFocus", "", "animated", "getName", "preload", "removeListeners", "count", "", "(Ljava/lang/Integer;)V", "setDefaultMode", "setFocusTo", "direction", "setInputMode", ModeProp.name, "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KeyboardControllerModule extends ReactContextBaseJavaModule {
    private final KeyboardControllerModuleImpl module;

    @ReactMethod
    public final void addListener(String eventName) {
    }

    @ReactMethod
    public final void removeListeners(Integer count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardControllerModule(ReactApplicationContext mReactContext) {
        super(mReactContext);
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.module = new KeyboardControllerModuleImpl(mReactContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardControllerModuleImpl.NAME;
    }

    @ReactMethod
    public final void setInputMode(int mode) {
        this.module.setInputMode(mode);
    }

    @ReactMethod
    public final void setDefaultMode() {
        this.module.setDefaultMode();
    }

    @ReactMethod
    public final void preload() {
        this.module.preload();
    }

    @ReactMethod
    public final void dismiss(boolean keepFocus, boolean animated) {
        this.module.dismiss(keepFocus, animated);
    }

    @ReactMethod
    public final void setFocusTo(String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.module.setFocusTo(direction);
    }
}
