package com.bajajconnect.features;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class SkuFeatureGate {
    private SkuFeatureGate() {
    }

    public static String normalizeSku(String str) {
        return SkuFeatureRegistry.normalizeSku(str);
    }

    public static boolean isEnabled(String str) {
        return SkuFeatureRegistry.isAnyFeatureEnabled(str);
    }
}
