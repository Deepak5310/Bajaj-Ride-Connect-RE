package com.reactnativekeyboardcontroller.views;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.reactnativekeyboardcontroller.extensions.ReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ViewGroupKt;
import com.reactnativekeyboardcontroller.extensions.ViewKt;
import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback;
import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallbackConfig;
import com.reactnativekeyboardcontroller.log.Logger;
import com.reactnativekeyboardcontroller.modal.ModalAttachedWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgeToEdgeReactViewGroup.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0006J\n\u0010$\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010%\u001a\u00020\u001fH\u0014J\u0012\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u001fH\u0014J\b\u0010*\u001a\u00020\u001fH\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\u0006\u0010,\u001a\u00020\u001fJ\u000e\u0010-\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0006J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0002R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/EdgeToEdgeReactViewGroup;", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "value", "", "active", "getActive", "()Z", "setActive", "(Z)V", "callback", "Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallback;", "getCallback$react_native_keyboard_controller_release", "()Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallback;", "setCallback$react_native_keyboard_controller_release", "(Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallback;)V", "config", "Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallbackConfig;", "eventView", "isEdgeToEdge", "isNavigationBarTranslucent", "isPreservingEdgeToEdge", "isStatusBarTranslucent", "modalAttachedWatcher", "Lcom/reactnativekeyboardcontroller/modal/ModalAttachedWatcher;", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "wasMounted", RemoteConfigComponent.ACTIVATE_FILE_NAME, "", "deactivate", "disable", "enable", "forceStatusBarTranslucent", "getKeyboardCallback", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "reApplyWindowInsets", "removeKeyboardCallbacks", "setEdgeToEdge", "setNavigationBarTranslucent", "setPreserveEdgeToEdge", "setStatusBarTranslucent", "setupKeyboardCallbacks", "setupWindowInsets", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EdgeToEdgeReactViewGroup extends ReactViewGroup {
    private boolean active;
    private KeyboardAnimationCallback callback;
    private final KeyboardAnimationCallbackConfig config;
    private ReactViewGroup eventView;
    private boolean isEdgeToEdge;
    private boolean isNavigationBarTranslucent;
    private boolean isPreservingEdgeToEdge;
    private boolean isStatusBarTranslucent;
    private final ModalAttachedWatcher modalAttachedWatcher;
    private final ThemedReactContext reactContext;
    private boolean wasMounted;

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EdgeToEdgeReactViewGroup(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        KeyboardAnimationCallbackConfig keyboardAnimationCallbackConfig = new KeyboardAnimationCallbackConfig(WindowInsetsCompat.Type.systemBars(), WindowInsetsCompat.Type.ime(), 1, this.isNavigationBarTranslucent);
        this.config = keyboardAnimationCallbackConfig;
        this.modalAttachedWatcher = new ModalAttachedWatcher(this, reactContext, keyboardAnimationCallbackConfig, new EdgeToEdgeReactViewGroup$modalAttachedWatcher$1(this));
        EdgeToEdgeViewRegistry.INSTANCE.register(this);
    }

    public final boolean getActive() {
        return this.active;
    }

    public final void setActive(boolean z) {
        this.active = z;
        if (z) {
            enable();
        } else {
            disable();
        }
    }

    public final KeyboardAnimationCallback getCallback$react_native_keyboard_controller_release() {
        return this.callback;
    }

    public final void setCallback$react_native_keyboard_controller_release(KeyboardAnimationCallback keyboardAnimationCallback) {
        this.callback = keyboardAnimationCallback;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.wasMounted) {
            this.wasMounted = true;
        } else {
            activate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        deactivate();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        reApplyWindowInsets();
    }

    private final void setupWindowInsets() {
        View rootView = ReactContextKt.getRootView(this.reactContext);
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView, new OnApplyWindowInsetsListener() { // from class: com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup$$ExternalSyntheticLambda0
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return EdgeToEdgeReactViewGroup.setupWindowInsets$lambda$0(this.f$0, view, windowInsetsCompat);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setupWindowInsets$lambda$0(EdgeToEdgeReactViewGroup this$0, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        ViewGroup content = ReactContextKt.getContent(this$0.reactContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        boolean z = this$0.active;
        boolean z2 = true;
        boolean z3 = !z || this$0.isStatusBarTranslucent;
        if (z && !this$0.isNavigationBarTranslucent) {
            z2 = false;
        }
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
        layoutParams.setMargins(insets2.left, z3 ? 0 : insets3.top, insets2.right, z2 ? 0 : insets2.bottom);
        if (content != null) {
            content.setLayoutParams(layoutParams);
        }
        return ViewKt.replaceStatusBarInsets(v, insets, this$0.isStatusBarTranslucent, this$0.active);
    }

    public final void setEdgeToEdge() {
        Window window;
        boolean z = this.active || this.isPreservingEdgeToEdge;
        if (this.isEdgeToEdge != z) {
            this.isEdgeToEdge = z;
            Activity currentActivity = this.reactContext.getCurrentActivity();
            if (currentActivity != null) {
                WindowCompat.setDecorFitsSystemWindows(currentActivity.getWindow(), true ^ this.isEdgeToEdge);
            }
            Activity currentActivity2 = this.reactContext.getCurrentActivity();
            if (currentActivity2 == null || (window = currentActivity2.getWindow()) == null) {
                return;
            }
            window.clearFlags(1024);
        }
    }

    private final void setupKeyboardCallbacks() {
        if (this.reactContext.getCurrentActivity() == null) {
            Logger.w$default(Logger.INSTANCE, EdgeToEdgeReactViewGroupKt.TAG, "Can not setup keyboard animation listener, since `currentActivity` is null", null, 4, null);
            return;
        }
        this.eventView = new ReactViewGroup(getContext());
        ViewGroup content = ReactContextKt.getContent(this.reactContext);
        if (content != null) {
            content.addView(this.eventView);
        }
        KeyboardAnimationCallback keyboardAnimationCallback = new KeyboardAnimationCallback(this, this, this.reactContext, this.config);
        this.callback = keyboardAnimationCallback;
        ReactViewGroup reactViewGroup = this.eventView;
        if (reactViewGroup != null) {
            ReactViewGroup reactViewGroup2 = reactViewGroup;
            ViewCompat.setWindowInsetsAnimationCallback(reactViewGroup2, keyboardAnimationCallback);
            ViewCompat.setOnApplyWindowInsetsListener(reactViewGroup2, this.callback);
            ViewKt.requestApplyInsetsWhenAttached(reactViewGroup2);
        }
    }

    private final void removeKeyboardCallbacks() {
        KeyboardAnimationCallback keyboardAnimationCallback = this.callback;
        if (keyboardAnimationCallback != null) {
            keyboardAnimationCallback.destroy();
        }
        final ReactViewGroup reactViewGroup = this.eventView;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                EdgeToEdgeReactViewGroup.removeKeyboardCallbacks$lambda$3(reactViewGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeKeyboardCallbacks$lambda$3(ReactViewGroup reactViewGroup) {
        ViewGroupKt.removeSelf(reactViewGroup);
    }

    private final void reApplyWindowInsets() {
        setupWindowInsets();
        ViewKt.requestApplyInsetsWhenAttached(this);
    }

    private final void enable() {
        setupWindowInsets();
        activate();
    }

    private final void disable() {
        setupWindowInsets();
        deactivate();
    }

    private final void activate() {
        setupKeyboardCallbacks();
        this.modalAttachedWatcher.enable();
    }

    private final void deactivate() {
        removeKeyboardCallbacks();
        this.modalAttachedWatcher.disable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getKeyboardCallback, reason: from getter */
    public final KeyboardAnimationCallback getCallback() {
        return this.callback;
    }

    public final void setStatusBarTranslucent(boolean isStatusBarTranslucent) {
        this.isStatusBarTranslucent = isStatusBarTranslucent;
    }

    public final void setNavigationBarTranslucent(boolean isNavigationBarTranslucent) {
        this.isNavigationBarTranslucent = isNavigationBarTranslucent;
        this.config.setHasTranslucentNavigationBar(isNavigationBarTranslucent);
    }

    public final void setPreserveEdgeToEdge(boolean isPreservingEdgeToEdge) {
        this.isPreservingEdgeToEdge = isPreservingEdgeToEdge;
    }

    public final void forceStatusBarTranslucent(boolean isStatusBarTranslucent) {
        if (!this.active || this.isStatusBarTranslucent == isStatusBarTranslucent) {
            return;
        }
        this.isStatusBarTranslucent = isStatusBarTranslucent;
        reApplyWindowInsets();
    }
}
