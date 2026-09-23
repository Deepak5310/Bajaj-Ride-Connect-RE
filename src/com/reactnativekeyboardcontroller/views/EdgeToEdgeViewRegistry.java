package com.reactnativekeyboardcontroller.views;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgeToEdgeReactViewGroup.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/EdgeToEdgeViewRegistry;", "", "()V", "lastCreatedView", "Ljava/lang/ref/WeakReference;", "Lcom/reactnativekeyboardcontroller/views/EdgeToEdgeReactViewGroup;", "get", "register", "", "view", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EdgeToEdgeViewRegistry {
    public static final EdgeToEdgeViewRegistry INSTANCE = new EdgeToEdgeViewRegistry();
    private static WeakReference<EdgeToEdgeReactViewGroup> lastCreatedView;

    private EdgeToEdgeViewRegistry() {
    }

    public final void register(EdgeToEdgeReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        lastCreatedView = new WeakReference<>(view);
    }

    public final EdgeToEdgeReactViewGroup get() {
        WeakReference<EdgeToEdgeReactViewGroup> weakReference = lastCreatedView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
