package com.mappls.sdk.navigation.camera;

import kotlin.Metadata;

/* JADX INFO: compiled from: NavigationConstants.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mappls/sdk/navigation/camera/NavigationConstants;", "", "()V", "DEFAULT_VANISHING_POINT_MIN_UPDATE_INTERVAL_NANO", "", "NAVIGATION_HIGH_ALERT_DURATION", "", "NAVIGATION_LOW_ALERT_DURATION", "NAVIGATION_MAX_CAMERA_ADJUSTMENT_ANIMATION_DURATION", "NAVIGATION_MEDIUM_ALERT_DURATION", "NAVIGATION_MIN_CAMERA_TILT_ADJUSTMENT_ANIMATION_DURATION", "NAVIGATION_MIN_CAMERA_ZOOM_ADJUSTMENT_ANIMATION_DURATION", "navigation-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigationConstants {
    public static final long DEFAULT_VANISHING_POINT_MIN_UPDATE_INTERVAL_NANO = 62500000;
    public static final NavigationConstants INSTANCE = new NavigationConstants();
    public static final int NAVIGATION_HIGH_ALERT_DURATION = 15;
    public static final int NAVIGATION_LOW_ALERT_DURATION = 125;
    public static final long NAVIGATION_MAX_CAMERA_ADJUSTMENT_ANIMATION_DURATION = 1000;
    public static final int NAVIGATION_MEDIUM_ALERT_DURATION = 70;
    public static final long NAVIGATION_MIN_CAMERA_TILT_ADJUSTMENT_ANIMATION_DURATION = 750;
    public static final long NAVIGATION_MIN_CAMERA_ZOOM_ADJUSTMENT_ANIMATION_DURATION = 300;

    private NavigationConstants() {
    }
}
