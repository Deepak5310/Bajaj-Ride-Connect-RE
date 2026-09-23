package com.bajajconnect.gMaps;

/* JADX INFO: loaded from: classes3.dex */
public final class GoogleNavSdkGate {
    public static final Object LOCK = new Object();
    private static volatile boolean navigationActivityOwnsNavigator;

    private GoogleNavSdkGate() {
    }

    public static void setNavigationActivityOwnsNavigator(boolean z) {
        navigationActivityOwnsNavigator = z;
    }

    public static boolean navigationActivityOwnsNavigator() {
        return navigationActivityOwnsNavigator;
    }
}
