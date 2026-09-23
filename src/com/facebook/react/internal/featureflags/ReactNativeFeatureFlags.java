package com.facebook.react.internal.featureflags;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeFeatureFlags.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\bH\u0007J\b\u0010\u0015\u001a\u00020\bH\u0007J\b\u0010\u0016\u001a\u00020\bH\u0007J\b\u0010\u0017\u001a\u00020\bH\u0007J\b\u0010\u0018\u001a\u00020\bH\u0007J\b\u0010\u0019\u001a\u00020\bH\u0007J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\bH\u0007J\u001b\u0010\u001e\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0000¢\u0006\u0002\b J\b\u0010!\u001a\u00020\bH\u0007J\b\u0010\"\u001a\u00020\bH\u0007J\b\u0010#\u001a\u00020\bH\u0007J\b\u0010$\u001a\u00020\bH\u0007J\b\u0010%\u001a\u00020\bH\u0007J\b\u0010&\u001a\u00020\bH\u0007J\b\u0010'\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlags;", "", "()V", "accessor", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsAccessor;", "accessorProvider", "Lkotlin/Function0;", "allowCollapsableChildren", "", "allowRecursiveCommitsWithSynchronousMountOnAndroid", "batchRenderingUpdatesInEventLoop", "commonTestFlag", "dangerouslyReset", "", "destroyFabricSurfacesInReactInstanceManager", "enableBackgroundExecutor", "enableCleanTextInputYogaNode", "enableGranularShadowTreeStateReconciliation", "enableMicrotasks", "enableSynchronousStateUpdates", "enableUIConsistency", "fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeak", "forceBatchingMountItemsOnAndroid", "fuseboxEnabledDebug", "fuseboxEnabledRelease", "lazyAnimationCallbacks", "override", "provider", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsProvider;", "preventDoubleTextMeasure", "setAccessorProvider", "newAccessorProvider", "setAccessorProvider$ReactAndroid_release", "setAndroidLayoutDirection", "useImmediateExecutorInAndroidBridgeless", "useModernRuntimeScheduler", "useNativeViewConfigsInBridgelessMode", "useRuntimeShadowNodeReferenceUpdate", "useRuntimeShadowNodeReferenceUpdateOnLayout", "useStateAlignmentMechanism", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ReactNativeFeatureFlags {
    public static final ReactNativeFeatureFlags INSTANCE = new ReactNativeFeatureFlags();
    private static ReactNativeFeatureFlagsAccessor accessor;
    private static Function0<? extends ReactNativeFeatureFlagsAccessor> accessorProvider;

    private ReactNativeFeatureFlags() {
    }

    static {
        ReactNativeFeatureFlags$accessorProvider$1 reactNativeFeatureFlags$accessorProvider$1 = new Function0<ReactNativeFeatureFlagsCxxAccessor>() { // from class: com.facebook.react.internal.featureflags.ReactNativeFeatureFlags$accessorProvider$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReactNativeFeatureFlagsCxxAccessor invoke() {
                return new ReactNativeFeatureFlagsCxxAccessor();
            }
        };
        accessorProvider = reactNativeFeatureFlags$accessorProvider$1;
        accessor = reactNativeFeatureFlags$accessorProvider$1.invoke();
    }

    @JvmStatic
    public static final boolean commonTestFlag() {
        return accessor.commonTestFlag();
    }

    @JvmStatic
    public static final boolean allowCollapsableChildren() {
        return accessor.allowCollapsableChildren();
    }

    @JvmStatic
    public static final boolean allowRecursiveCommitsWithSynchronousMountOnAndroid() {
        return accessor.allowRecursiveCommitsWithSynchronousMountOnAndroid();
    }

    @JvmStatic
    public static final boolean batchRenderingUpdatesInEventLoop() {
        return accessor.batchRenderingUpdatesInEventLoop();
    }

    @JvmStatic
    public static final boolean destroyFabricSurfacesInReactInstanceManager() {
        return accessor.destroyFabricSurfacesInReactInstanceManager();
    }

    @JvmStatic
    public static final boolean enableBackgroundExecutor() {
        return accessor.enableBackgroundExecutor();
    }

    @JvmStatic
    public static final boolean enableCleanTextInputYogaNode() {
        return accessor.enableCleanTextInputYogaNode();
    }

    @JvmStatic
    public static final boolean enableGranularShadowTreeStateReconciliation() {
        return accessor.enableGranularShadowTreeStateReconciliation();
    }

    @JvmStatic
    public static final boolean enableMicrotasks() {
        return accessor.enableMicrotasks();
    }

    @JvmStatic
    public static final boolean enableSynchronousStateUpdates() {
        return accessor.enableSynchronousStateUpdates();
    }

    @JvmStatic
    public static final boolean enableUIConsistency() {
        return accessor.enableUIConsistency();
    }

    @JvmStatic
    public static final boolean fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeak() {
        return accessor.fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeak();
    }

    @JvmStatic
    public static final boolean forceBatchingMountItemsOnAndroid() {
        return accessor.forceBatchingMountItemsOnAndroid();
    }

    @JvmStatic
    public static final boolean fuseboxEnabledDebug() {
        return accessor.fuseboxEnabledDebug();
    }

    @JvmStatic
    public static final boolean fuseboxEnabledRelease() {
        return accessor.fuseboxEnabledRelease();
    }

    @JvmStatic
    public static final boolean lazyAnimationCallbacks() {
        return accessor.lazyAnimationCallbacks();
    }

    @JvmStatic
    public static final boolean preventDoubleTextMeasure() {
        return accessor.preventDoubleTextMeasure();
    }

    @JvmStatic
    public static final boolean setAndroidLayoutDirection() {
        return accessor.setAndroidLayoutDirection();
    }

    @JvmStatic
    public static final boolean useImmediateExecutorInAndroidBridgeless() {
        return accessor.useImmediateExecutorInAndroidBridgeless();
    }

    @JvmStatic
    public static final boolean useModernRuntimeScheduler() {
        return accessor.useModernRuntimeScheduler();
    }

    @JvmStatic
    public static final boolean useNativeViewConfigsInBridgelessMode() {
        return accessor.useNativeViewConfigsInBridgelessMode();
    }

    @JvmStatic
    public static final boolean useRuntimeShadowNodeReferenceUpdate() {
        return accessor.useRuntimeShadowNodeReferenceUpdate();
    }

    @JvmStatic
    public static final boolean useRuntimeShadowNodeReferenceUpdateOnLayout() {
        return accessor.useRuntimeShadowNodeReferenceUpdateOnLayout();
    }

    @JvmStatic
    public static final boolean useStateAlignmentMechanism() {
        return accessor.useStateAlignmentMechanism();
    }

    @JvmStatic
    public static final void override(ReactNativeFeatureFlagsProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        accessor.override(provider);
    }

    @JvmStatic
    public static final void dangerouslyReset() {
        accessor.dangerouslyReset();
        accessor = accessorProvider.invoke();
    }

    public final void setAccessorProvider$ReactAndroid_release(Function0<? extends ReactNativeFeatureFlagsAccessor> newAccessorProvider) {
        Intrinsics.checkNotNullParameter(newAccessorProvider, "newAccessorProvider");
        accessorProvider = newAccessorProvider;
        accessor = newAccessorProvider.invoke();
    }
}
