package com.reactnativekeyboardcontroller.modal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.views.modal.ReactModalHostView;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.extensions.ViewGroupKt;
import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback;
import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallbackConfig;
import com.reactnativekeyboardcontroller.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalAttachedWatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0014\u0010\u0015\u001a\u00020\u00132\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/reactnativekeyboardcontroller/modal/ModalAttachedWatcher;", "Lcom/facebook/react/uimanager/events/EventDispatcherListener;", "view", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "config", "Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallbackConfig;", "callback", "Lkotlin/Function0;", "Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallback;", "(Lcom/facebook/react/views/view/ReactViewGroup;Lcom/facebook/react/uimanager/ThemedReactContext;Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallbackConfig;Lkotlin/jvm/functions/Function0;)V", "archType", "", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "uiManager", "Lcom/facebook/react/bridge/UIManager;", "disable", "", "enable", "onEventDispatch", NotificationCompat.CATEGORY_EVENT, "Lcom/facebook/react/uimanager/events/Event;", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ModalAttachedWatcher implements EventDispatcherListener {
    private static final String MODAL_SHOW_EVENT = "topShow";
    private final int archType;
    private Function0<KeyboardAnimationCallback> callback;
    private final KeyboardAnimationCallbackConfig config;
    private final EventDispatcher eventDispatcher;
    private final ThemedReactContext reactContext;
    private final UIManager uiManager;
    private final ReactViewGroup view;

    public ModalAttachedWatcher(ReactViewGroup view, ThemedReactContext reactContext, KeyboardAnimationCallbackConfig config, Function0<KeyboardAnimationCallback> callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.view = view;
        this.reactContext = reactContext;
        this.config = config;
        this.callback = callback;
        this.archType = 1;
        this.uiManager = UIManagerHelper.getUIManager(reactContext.getReactApplicationContext(), 1);
        this.eventDispatcher = UIManagerHelper.getEventDispatcher(reactContext.getReactApplicationContext(), 1);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public void onEventDispatch(Event<?> event) {
        ReactModalHostView reactModalHostView;
        View decorView;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getEventName(), "topShow")) {
            View rootView = null;
            try {
                UIManager uIManager = this.uiManager;
                View viewResolveView = uIManager != null ? uIManager.resolveView(event.getViewTag()) : null;
                reactModalHostView = viewResolveView instanceof ReactModalHostView ? (ReactModalHostView) viewResolveView : null;
            } catch (Exception e) {
                Logger.INSTANCE.w(ModalAttachedWatcherKt.TAG, "Can not resolve view for Modal#" + event.getViewTag(), e);
            }
            if (reactModalHostView == null) {
                return;
            }
            Dialog dialog = reactModalHostView.getDialog();
            Window window = dialog != null ? dialog.getWindow() : null;
            if (window != null && (decorView = window.getDecorView()) != null) {
                rootView = decorView.getRootView();
            }
            ViewGroup viewGroup = (ViewGroup) rootView;
            if (viewGroup != null) {
                final ReactViewGroup reactViewGroup = new ReactViewGroup(this.reactContext);
                reactViewGroup.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                ViewGroup viewGroup2 = viewGroup;
                final KeyboardAnimationCallback keyboardAnimationCallback = new KeyboardAnimationCallback(this.view, viewGroup2, this.reactContext, this.config);
                ReactViewGroup reactViewGroup2 = reactViewGroup;
                viewGroup.addView(reactViewGroup2);
                if (ModalAttachedWatcherKt.areEventsComingFromOwnWindow) {
                    KeyboardAnimationCallback keyboardAnimationCallbackInvoke = this.callback.invoke();
                    if (keyboardAnimationCallbackInvoke != null) {
                        keyboardAnimationCallbackInvoke.suspend(true);
                    }
                    ViewCompat.setWindowInsetsAnimationCallback(viewGroup2, keyboardAnimationCallback);
                    ViewCompat.setOnApplyWindowInsetsListener(reactViewGroup2, keyboardAnimationCallback);
                    keyboardAnimationCallback.syncKeyboardPosition(Double.valueOf(0.0d), false);
                }
                if (dialog != null) {
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.reactnativekeyboardcontroller.modal.ModalAttachedWatcher$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            ModalAttachedWatcher.onEventDispatch$lambda$1(keyboardAnimationCallback, reactViewGroup, this, dialogInterface);
                        }
                    });
                }
                if (window != null) {
                    window.setSoftInputMode(48);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEventDispatch$lambda$1(KeyboardAnimationCallback callback, ReactViewGroup eventView, ModalAttachedWatcher this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(eventView, "$eventView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        KeyboardAnimationCallback.syncKeyboardPosition$default(callback, null, null, 3, null);
        callback.destroy();
        ViewGroupKt.removeSelf(eventView);
        KeyboardAnimationCallback keyboardAnimationCallbackInvoke = this$0.callback.invoke();
        if (keyboardAnimationCallbackInvoke != null) {
            keyboardAnimationCallbackInvoke.suspend(false);
        }
    }

    public final void enable() {
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.addListener(this);
        }
    }

    public final void disable() {
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.removeListener(this);
        }
    }
}
