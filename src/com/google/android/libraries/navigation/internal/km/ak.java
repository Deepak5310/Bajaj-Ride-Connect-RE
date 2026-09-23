package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak {
    public static final x a;
    public static final s b;
    public static final x c;
    public static final x d;
    public static final s e;
    public static final s f;
    public static final ad g;
    public static final s h;
    public static final s i;
    public static final s j;
    public static final s k;
    public static final ad l;
    public static final ad m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final s f466n;
    public static final s o;
    public static final x p;
    public static final s q;
    public static final ad r;
    public static final ac s;

    static {
        w wVar = w.NAVLOGS_JOINABLE;
        a = new x("GuidanceServicePublishAggregatedNavigationStateResult", wVar);
        b = new s("GuidanceServiceGenerateRoutesForGuidanceFailure", wVar);
        c = new x("GuidanceServiceStartActiveGuidanceFailureCause", wVar);
        d = new x("GuidanceServiceUpdateRoutesFailureCause", wVar);
        e = new s("GuidanceServiceRegenerateRoutesForGuidanceFailure", wVar);
        f = new s("GuidanceServiceRouteDescriptionToGuidanceRouteTranslationFailure", wVar);
        g = new ad("GuidanceServicePublishAggregatedNavigationStateTimeSuccess", wVar);
        h = new s("GuidanceServiceGenerateGuidanceUpdateFailureMissingParameter", wVar);
        i = new s("GuidanceServiceGenerateGuidanceUpdateFailureCacheMiss", wVar);
        j = new s("GuidanceServiceGuidanceRoutesExtractorFailureMissingSelectedRoute", wVar);
        k = new s("GuidanceServiceGuidanceRoutesExtractorFailureRoutesServiceError", wVar);
        l = new ad("GuidanceServiceGuidanceRouteExtractorTime", wVar);
        m = new ad("GuidanceServiceRouteDescriptionToGuidanceRouteTranslationTime", wVar);
        f466n = new s("GuidanceServiceGenerateActiveGuidanceStateFailureAlternateRouteMissing", wVar);
        o = new s("GuidanceServiceGenerateIdToGuidanceRouteMapFailure", wVar);
        p = new x("RoutesServiceGetRoutesForGuidanceResult", wVar);
        q = new s("RoutesServiceGetGuidanceRoutesFailureCacheMiss", wVar);
        r = new ad("RoutesServiceGetRoutesForGuidanceTimeSuccess", wVar);
        s = new ac("NavigationLocationUpdateToVoiceGuidanceLatency", wVar);
    }
}
