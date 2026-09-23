package com.reactnativekeyboardcontroller.views.overlay;

import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.bajajconnect.wifi.navv2.NavigationDirectionsHelper$$ExternalSyntheticBackport0;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSPointerDispatcherCompat.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/overlay/JSPointerDispatcherCompat;", "Lcom/facebook/react/uimanager/JSPointerDispatcher;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "handleMotionEventMethod", "Ljava/lang/reflect/Method;", "getHandleMotionEventMethod", "()Ljava/lang/reflect/Method;", "handleMotionEventMethod$delegate", "Lkotlin/Lazy;", "handleMotionEventCompat", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "isCapture", "", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class JSPointerDispatcherCompat extends JSPointerDispatcher {
    private static final String HANDLE_MOTION_EVENT = "handleMotionEvent";
    private static final int RN_72_PARAMS_COUNT = 3;

    /* JADX INFO: renamed from: handleMotionEventMethod$delegate, reason: from kotlin metadata */
    private final Lazy handleMotionEventMethod;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSPointerDispatcherCompat(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.handleMotionEventMethod = LazyKt.lazy(new Function0<Method>() { // from class: com.reactnativekeyboardcontroller.views.overlay.JSPointerDispatcherCompat$handleMotionEventMethod$2
            @Override // kotlin.jvm.functions.Function0
            public final Method invoke() {
                try {
                    try {
                        return JSPointerDispatcher.class.getMethod("handleMotionEvent", MotionEvent.class, EventDispatcher.class, Boolean.TYPE);
                    } catch (NoSuchMethodException unused) {
                        return JSPointerDispatcher.class.getMethod("handleMotionEvent", MotionEvent.class, EventDispatcher.class);
                    }
                } catch (NoSuchMethodException unused2) {
                    return null;
                }
            }
        });
    }

    private final Method getHandleMotionEventMethod() {
        return (Method) this.handleMotionEventMethod.getValue();
    }

    public final void handleMotionEventCompat(MotionEvent event, EventDispatcher eventDispatcher, boolean isCapture) {
        Method handleMotionEventMethod = getHandleMotionEventMethod();
        if (handleMotionEventMethod != null) {
            if (NavigationDirectionsHelper$$ExternalSyntheticBackport0.m(handleMotionEventMethod) == 3) {
                handleMotionEventMethod.invoke(this, event, eventDispatcher, Boolean.valueOf(isCapture));
            } else {
                handleMotionEventMethod.invoke(this, event, eventDispatcher);
            }
        }
    }
}
