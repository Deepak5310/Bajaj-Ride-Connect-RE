package com.facebook.react.internal.featureflags;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeFeatureFlagsLocalAccessor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\b\u0010*\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020\u0007H\u0016J\b\u00101\u001a\u00020\u0007H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\u0010\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\rH\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u00020\u0007H\u0016J\b\u00108\u001a\u00020\u0007H\u0016J\b\u00109\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010 \u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010!\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006>"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsLocalAccessor;", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsAccessor;", "()V", "accessedFeatureFlags", "", "", "allowCollapsableChildrenCache", "", "Ljava/lang/Boolean;", "allowRecursiveCommitsWithSynchronousMountOnAndroidCache", "batchRenderingUpdatesInEventLoopCache", "commonTestFlagCache", "currentProvider", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsProvider;", "destroyFabricSurfacesInReactInstanceManagerCache", "enableBackgroundExecutorCache", "enableCleanTextInputYogaNodeCache", "enableGranularShadowTreeStateReconciliationCache", "enableMicrotasksCache", "enableSynchronousStateUpdatesCache", "enableUIConsistencyCache", "fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeakCache", "forceBatchingMountItemsOnAndroidCache", "fuseboxEnabledDebugCache", "fuseboxEnabledReleaseCache", "lazyAnimationCallbacksCache", "preventDoubleTextMeasureCache", "setAndroidLayoutDirectionCache", "useImmediateExecutorInAndroidBridgelessCache", "useModernRuntimeSchedulerCache", "useNativeViewConfigsInBridgelessModeCache", "useRuntimeShadowNodeReferenceUpdateCache", "useRuntimeShadowNodeReferenceUpdateOnLayoutCache", "useStateAlignmentMechanismCache", "allowCollapsableChildren", "allowRecursiveCommitsWithSynchronousMountOnAndroid", "batchRenderingUpdatesInEventLoop", "commonTestFlag", "dangerouslyReset", "", "destroyFabricSurfacesInReactInstanceManager", "enableBackgroundExecutor", "enableCleanTextInputYogaNode", "enableGranularShadowTreeStateReconciliation", "enableMicrotasks", "enableSynchronousStateUpdates", "enableUIConsistency", "fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeak", "forceBatchingMountItemsOnAndroid", "fuseboxEnabledDebug", "fuseboxEnabledRelease", "lazyAnimationCallbacks", "override", "provider", "preventDoubleTextMeasure", "setAndroidLayoutDirection", "useImmediateExecutorInAndroidBridgeless", "useModernRuntimeScheduler", "useNativeViewConfigsInBridgelessMode", "useRuntimeShadowNodeReferenceUpdate", "useRuntimeShadowNodeReferenceUpdateOnLayout", "useStateAlignmentMechanism", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ReactNativeFeatureFlagsLocalAccessor implements ReactNativeFeatureFlagsAccessor {
    private Boolean allowCollapsableChildrenCache;
    private Boolean allowRecursiveCommitsWithSynchronousMountOnAndroidCache;
    private Boolean batchRenderingUpdatesInEventLoopCache;
    private Boolean commonTestFlagCache;
    private Boolean destroyFabricSurfacesInReactInstanceManagerCache;
    private Boolean enableBackgroundExecutorCache;
    private Boolean enableCleanTextInputYogaNodeCache;
    private Boolean enableGranularShadowTreeStateReconciliationCache;
    private Boolean enableMicrotasksCache;
    private Boolean enableSynchronousStateUpdatesCache;
    private Boolean enableUIConsistencyCache;
    private Boolean fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeakCache;
    private Boolean forceBatchingMountItemsOnAndroidCache;
    private Boolean fuseboxEnabledDebugCache;
    private Boolean fuseboxEnabledReleaseCache;
    private Boolean lazyAnimationCallbacksCache;
    private Boolean preventDoubleTextMeasureCache;
    private Boolean setAndroidLayoutDirectionCache;
    private Boolean useImmediateExecutorInAndroidBridgelessCache;
    private Boolean useModernRuntimeSchedulerCache;
    private Boolean useNativeViewConfigsInBridgelessModeCache;
    private Boolean useRuntimeShadowNodeReferenceUpdateCache;
    private Boolean useRuntimeShadowNodeReferenceUpdateOnLayoutCache;
    private Boolean useStateAlignmentMechanismCache;
    private ReactNativeFeatureFlagsProvider currentProvider = new ReactNativeFeatureFlagsDefaults();
    private final Set<String> accessedFeatureFlags = new LinkedHashSet();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor
    public void dangerouslyReset() {
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean commonTestFlag() {
        Boolean boolValueOf = this.commonTestFlagCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.commonTestFlag());
            this.accessedFeatureFlags.add("commonTestFlag");
            this.commonTestFlagCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean allowCollapsableChildren() {
        Boolean boolValueOf = this.allowCollapsableChildrenCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.allowCollapsableChildren());
            this.accessedFeatureFlags.add("allowCollapsableChildren");
            this.allowCollapsableChildrenCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean allowRecursiveCommitsWithSynchronousMountOnAndroid() {
        Boolean boolValueOf = this.allowRecursiveCommitsWithSynchronousMountOnAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.allowRecursiveCommitsWithSynchronousMountOnAndroid());
            this.accessedFeatureFlags.add("allowRecursiveCommitsWithSynchronousMountOnAndroid");
            this.allowRecursiveCommitsWithSynchronousMountOnAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean batchRenderingUpdatesInEventLoop() {
        Boolean boolValueOf = this.batchRenderingUpdatesInEventLoopCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.batchRenderingUpdatesInEventLoop());
            this.accessedFeatureFlags.add("batchRenderingUpdatesInEventLoop");
            this.batchRenderingUpdatesInEventLoopCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean destroyFabricSurfacesInReactInstanceManager() {
        Boolean boolValueOf = this.destroyFabricSurfacesInReactInstanceManagerCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.destroyFabricSurfacesInReactInstanceManager());
            this.accessedFeatureFlags.add("destroyFabricSurfacesInReactInstanceManager");
            this.destroyFabricSurfacesInReactInstanceManagerCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableBackgroundExecutor() {
        Boolean boolValueOf = this.enableBackgroundExecutorCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableBackgroundExecutor());
            this.accessedFeatureFlags.add("enableBackgroundExecutor");
            this.enableBackgroundExecutorCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableCleanTextInputYogaNode() {
        Boolean boolValueOf = this.enableCleanTextInputYogaNodeCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableCleanTextInputYogaNode());
            this.accessedFeatureFlags.add("enableCleanTextInputYogaNode");
            this.enableCleanTextInputYogaNodeCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableGranularShadowTreeStateReconciliation() {
        Boolean boolValueOf = this.enableGranularShadowTreeStateReconciliationCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableGranularShadowTreeStateReconciliation());
            this.accessedFeatureFlags.add("enableGranularShadowTreeStateReconciliation");
            this.enableGranularShadowTreeStateReconciliationCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableMicrotasks() {
        Boolean boolValueOf = this.enableMicrotasksCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableMicrotasks());
            this.accessedFeatureFlags.add("enableMicrotasks");
            this.enableMicrotasksCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableSynchronousStateUpdates() {
        Boolean boolValueOf = this.enableSynchronousStateUpdatesCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableSynchronousStateUpdates());
            this.accessedFeatureFlags.add("enableSynchronousStateUpdates");
            this.enableSynchronousStateUpdatesCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableUIConsistency() {
        Boolean boolValueOf = this.enableUIConsistencyCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableUIConsistency());
            this.accessedFeatureFlags.add("enableUIConsistency");
            this.enableUIConsistencyCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeak() {
        Boolean boolValueOf = this.fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeakCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeak());
            this.accessedFeatureFlags.add("fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeak");
            this.fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeakCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean forceBatchingMountItemsOnAndroid() {
        Boolean boolValueOf = this.forceBatchingMountItemsOnAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.forceBatchingMountItemsOnAndroid());
            this.accessedFeatureFlags.add("forceBatchingMountItemsOnAndroid");
            this.forceBatchingMountItemsOnAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxEnabledDebug() {
        Boolean boolValueOf = this.fuseboxEnabledDebugCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.fuseboxEnabledDebug());
            this.accessedFeatureFlags.add("fuseboxEnabledDebug");
            this.fuseboxEnabledDebugCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxEnabledRelease() {
        Boolean boolValueOf = this.fuseboxEnabledReleaseCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.fuseboxEnabledRelease());
            this.accessedFeatureFlags.add("fuseboxEnabledRelease");
            this.fuseboxEnabledReleaseCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean lazyAnimationCallbacks() {
        Boolean boolValueOf = this.lazyAnimationCallbacksCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.lazyAnimationCallbacks());
            this.accessedFeatureFlags.add("lazyAnimationCallbacks");
            this.lazyAnimationCallbacksCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean preventDoubleTextMeasure() {
        Boolean boolValueOf = this.preventDoubleTextMeasureCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.preventDoubleTextMeasure());
            this.accessedFeatureFlags.add("preventDoubleTextMeasure");
            this.preventDoubleTextMeasureCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean setAndroidLayoutDirection() {
        Boolean boolValueOf = this.setAndroidLayoutDirectionCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.setAndroidLayoutDirection());
            this.accessedFeatureFlags.add("setAndroidLayoutDirection");
            this.setAndroidLayoutDirectionCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useImmediateExecutorInAndroidBridgeless() {
        Boolean boolValueOf = this.useImmediateExecutorInAndroidBridgelessCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useImmediateExecutorInAndroidBridgeless());
            this.accessedFeatureFlags.add("useImmediateExecutorInAndroidBridgeless");
            this.useImmediateExecutorInAndroidBridgelessCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useModernRuntimeScheduler() {
        Boolean boolValueOf = this.useModernRuntimeSchedulerCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useModernRuntimeScheduler());
            this.accessedFeatureFlags.add("useModernRuntimeScheduler");
            this.useModernRuntimeSchedulerCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeViewConfigsInBridgelessMode() {
        Boolean boolValueOf = this.useNativeViewConfigsInBridgelessModeCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useNativeViewConfigsInBridgelessMode());
            this.accessedFeatureFlags.add("useNativeViewConfigsInBridgelessMode");
            this.useNativeViewConfigsInBridgelessModeCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useRuntimeShadowNodeReferenceUpdate() {
        Boolean boolValueOf = this.useRuntimeShadowNodeReferenceUpdateCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useRuntimeShadowNodeReferenceUpdate());
            this.accessedFeatureFlags.add("useRuntimeShadowNodeReferenceUpdate");
            this.useRuntimeShadowNodeReferenceUpdateCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useRuntimeShadowNodeReferenceUpdateOnLayout() {
        Boolean boolValueOf = this.useRuntimeShadowNodeReferenceUpdateOnLayoutCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useRuntimeShadowNodeReferenceUpdateOnLayout());
            this.accessedFeatureFlags.add("useRuntimeShadowNodeReferenceUpdateOnLayout");
            this.useRuntimeShadowNodeReferenceUpdateOnLayoutCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useStateAlignmentMechanism() {
        Boolean boolValueOf = this.useStateAlignmentMechanismCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useStateAlignmentMechanism());
            this.accessedFeatureFlags.add("useStateAlignmentMechanism");
            this.useStateAlignmentMechanismCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor
    public void override(ReactNativeFeatureFlagsProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (!this.accessedFeatureFlags.isEmpty()) {
            throw new IllegalStateException("Feature flags were accessed before being overridden: " + CollectionsKt.joinToString$default(this.accessedFeatureFlags, ", ", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsLocalAccessor$override$accessedFeatureFlagsStr$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(String it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    return it2;
                }
            }, 30, null));
        }
        this.currentProvider = provider;
    }
}
