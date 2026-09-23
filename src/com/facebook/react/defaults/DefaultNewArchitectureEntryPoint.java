package com.facebook.react.defaults;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: DefaultNewArchitectureEntryPoint.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J&\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/facebook/react/defaults/DefaultNewArchitectureEntryPoint;", "", "()V", "bridgelessEnabled", "", "getBridgelessEnabled$annotations", "getBridgelessEnabled", "()Z", "concurrentReactEnabled", "getConcurrentReactEnabled$annotations", "getConcurrentReactEnabled", "fabricEnabled", "getFabricEnabled$annotations", "getFabricEnabled", "fuseboxEnabled", "loaded", "privateBridgelessEnabled", "privateConcurrentReactEnabled", "privateFabricEnabled", "privateTurboModulesEnabled", "turboModulesEnabled", "getTurboModulesEnabled$annotations", "getTurboModulesEnabled", "isConfigurationValid", "Lkotlin/Pair;", "", "load", "", "unstable_loadFusebox", "isNewArchEnabled", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DefaultNewArchitectureEntryPoint {
    public static final DefaultNewArchitectureEntryPoint INSTANCE = new DefaultNewArchitectureEntryPoint();
    private static boolean fuseboxEnabled;
    private static boolean loaded;
    private static boolean privateBridgelessEnabled;
    private static boolean privateConcurrentReactEnabled;
    private static boolean privateFabricEnabled;
    private static boolean privateTurboModulesEnabled;

    @JvmStatic
    public static /* synthetic */ void getBridgelessEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getConcurrentReactEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getFabricEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getTurboModulesEnabled$annotations() {
    }

    @JvmStatic
    public static final void load() {
        load$default(false, false, false, 7, null);
    }

    @JvmStatic
    public static final void load(boolean z) {
        load$default(z, false, false, 6, null);
    }

    @JvmStatic
    public static final void load(boolean z, boolean z2) {
        load$default(z, z2, false, 4, null);
    }

    private DefaultNewArchitectureEntryPoint() {
    }

    public static /* synthetic */ void load$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        load(z, z2, z3);
    }

    @JvmStatic
    public static final void load(boolean turboModulesEnabled, boolean fabricEnabled, boolean bridgelessEnabled) {
        Pair<Boolean, String> pairIsConfigurationValid = INSTANCE.isConfigurationValid(turboModulesEnabled, fabricEnabled, bridgelessEnabled);
        boolean zBooleanValue = pairIsConfigurationValid.component1().booleanValue();
        String strComponent2 = pairIsConfigurationValid.component2();
        if (!zBooleanValue) {
            throw new IllegalStateException(strComponent2.toString());
        }
        ReactFeatureFlags.useTurboModules = turboModulesEnabled;
        ReactFeatureFlags.enableFabricRenderer = fabricEnabled;
        ReactFeatureFlags.unstable_useFabricInterop = fabricEnabled;
        ReactFeatureFlags.enableBridgelessArchitecture = bridgelessEnabled;
        ReactFeatureFlags.unstable_useTurboModuleInterop = bridgelessEnabled;
        final boolean z = fuseboxEnabled;
        if (bridgelessEnabled) {
            ReactNativeFeatureFlags.override(new ReactNativeFeatureFlagsDefaults() { // from class: com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load.1
                @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
                public boolean batchRenderingUpdatesInEventLoop() {
                    return true;
                }

                @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
                public boolean enableMicrotasks() {
                    return true;
                }

                @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
                public boolean useModernRuntimeScheduler() {
                    return true;
                }

                @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
                public boolean useNativeViewConfigsInBridgelessMode() {
                    return true;
                }

                @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
                /* JADX INFO: renamed from: fuseboxEnabledDebug, reason: from getter */
                public boolean get$fuseboxEnabledDebug() {
                    return z;
                }
            });
        }
        privateFabricEnabled = fabricEnabled;
        privateTurboModulesEnabled = turboModulesEnabled;
        privateConcurrentReactEnabled = fabricEnabled;
        privateBridgelessEnabled = bridgelessEnabled;
        DefaultSoLoader.INSTANCE.maybeLoadSoLibrary();
        loaded = true;
    }

    public static final boolean getFabricEnabled() {
        return privateFabricEnabled;
    }

    public static final boolean getTurboModulesEnabled() {
        return privateTurboModulesEnabled;
    }

    public static final boolean getConcurrentReactEnabled() {
        return privateConcurrentReactEnabled;
    }

    public static final boolean getBridgelessEnabled() {
        return privateBridgelessEnabled;
    }

    @VisibleForTesting
    public final Pair<Boolean, String> isConfigurationValid(boolean turboModulesEnabled, boolean fabricEnabled, boolean bridgelessEnabled) {
        if (fabricEnabled && !turboModulesEnabled) {
            return TuplesKt.to(false, "fabricEnabled=true requires turboModulesEnabled=true (is now false) - Please update your DefaultNewArchitectureEntryPoint.load() parameters.");
        }
        if (bridgelessEnabled && (!turboModulesEnabled || !fabricEnabled)) {
            return TuplesKt.to(false, "bridgelessEnabled=true requires (turboModulesEnabled=true AND fabricEnabled=true) - Please update your DefaultNewArchitectureEntryPoint.load() parameters.");
        }
        return TuplesKt.to(true, "");
    }

    @JvmStatic
    public static final void unstable_loadFusebox(boolean isNewArchEnabled) {
        fuseboxEnabled = true;
        if (!isNewArchEnabled) {
            ReactNativeFeatureFlags.override(new ReactNativeFeatureFlagsDefaults() { // from class: com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.unstable_loadFusebox.1
                @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
                /* JADX INFO: renamed from: fuseboxEnabledDebug */
                public boolean get$fuseboxEnabledDebug() {
                    return true;
                }
            });
        } else {
            Assertions.assertCondition(!loaded, "unstable_loadFusebox() must be called before load()");
        }
    }
}
