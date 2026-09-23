package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af {
    public static final x A;
    public static final s B;
    public static final x C;
    public static final y a = new y("DisruptionVisualPromptTriggerTimeMs", w.NAVIGATION, new com.google.android.libraries.navigation.internal.ky.ae(1000));
    public static final s b;
    public static final y c;
    public static final s d;
    public static final ad e;
    public static final ad f;
    public static final ad g;
    public static final ad h;
    public static final x i;
    public static final x j;
    public static final x k;
    public static final ad l;
    public static final s m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final x f465n;
    public static final x o;
    public static final x p;
    public static final x q;
    public static final y r;
    public static final y s;
    public static final y t;
    public static final y u;
    public static final x v;
    public static final x w;
    public static final x x;
    public static final s y;
    public static final x z;

    static {
        w wVar = w.NAVIGATION;
        b = new s("DisruptionVisualPromptScheduled", wVar);
        c = new y("DisruptionAudioPromptTriggerTimeMs", wVar, new com.google.android.libraries.navigation.internal.ky.ae(1000));
        w wVar2 = w.NAVIGATION;
        d = new s("DisruptionAudioPromptScheduled", wVar2);
        e = new ad("NavigationRerouteTimeOffline", wVar2, 4, 2025);
        f = new ad("NavigationRerouteTimeOnline", wVar2, 4, 2025);
        new ac("NavigationSearchAlongRouteZeroSuggestResultsLoadingTime", wVar2, 4, 2025);
        w wVar3 = w.NAVIGATION;
        g = new ad("NavigationTrafficUpdateTime", wVar3, 4, 2025);
        h = new ad("NavigationTrafficUpdateTimeOffline", wVar3, 4, 2025);
        i = new x("NavigationInertialHeadingErrorDegrees", wVar3, 4, 2025);
        j = new x("NavigationInertialHeadingCompassErrorDegrees", wVar3, 4, 2025);
        k = new x("NavigationInertialHeadingEvents", wVar3, 4, 2025);
        l = new ad("NavigationStartupInitialToGuidedNotificationDelay", wVar3, 4, 2025);
        new ac("NavigationHeadlessGuidedStartup", wVar3, 4, 2025);
        com.google.android.libraries.navigation.internal.ky.ab abVar = b.a;
        w wVar4 = w.NAVIGATION;
        m = new s("NavigationTrafficDataExpired", wVar4, 4, 2025);
        new ac("FreeNavDestinationsZeroSuggestResultsLoadingTime", wVar4, 4, 2025);
        w wVar5 = w.NAVIGATION;
        f465n = new x("NavigationDiscardExistingGuidersReason", wVar5, 4, 2025);
        o = new x("NavigationLocationPipelineFixups", wVar5, 4, 2025);
        p = new x("NavigationLocationPipelineResults", wVar5, 4, 2025);
        q = new x("NavigationLocationPipelineSensors", wVar5, 4, 2025);
        r = new y("NavigationLocationPipelineOnRouteToRerouteMs", wVar5, 4, 2025);
        s = new y("NavigationLocationPipelineRerouteToOnRouteMs", w.NAVIGATION, 4, 2025);
        w wVar6 = w.NAVIGATION;
        com.google.android.libraries.navigation.internal.ky.ab abVar2 = b.c;
        t = new y("NavigationLocationPipelineComputeTimeMs", wVar6, 4, 2025, abVar2);
        u = new y("NavigationLocationPipelineLatencyMs", wVar6, 4, 2025, abVar2);
        v = new x("NavigationLocationPipelineTilesNeededButMissingAreaRequested", wVar6, 4, 2025);
        w = new x("NavigationLocationPipelineTilesNeededButMissingEmptyDuration", wVar6, 4, 2025);
        x = new x("NavigationRouteAndLocationUpdate", wVar6, 4, 2025);
        new y("NavigationLocationPipelineHbeLocationEventDelay", wVar6, 4, 2025);
        w wVar7 = w.NAVIGATION;
        y = new s("NavigationRawGnssUploadEventSize", wVar7, 11, 2025);
        z = new x("NavigationRouteGuiderEvents", wVar7, 4, 2025);
        new y("NavigationLocationPipelineHbeSensorEventClockSkew", wVar7, 4, 2025);
        new u("NavigationOverviewActiveTime", w.NAVIGATION);
        new ac("NavigationOverviewActiveToGuidedNavTime", w.NAVIGATION, 4, 2025);
        w wVar8 = w.NAVIGATION;
        A = new x("NavigationRadioPresence", wVar8, 4, 2025);
        new y("NavigationArrivalDashboardForegroundTime", wVar8, 4, 2025);
        new y("NavigationStartupJankPermillage", w.NAVIGATION, 4, 2025);
        w wVar9 = w.NAVIGATION;
        B = new s("NavigationRerouteOnLocaleChange", wVar9, 4, 2025);
        C = new x("NavigationClickedOrganicPoiTypes", wVar9, 4, 2025);
        new y("NavigationBluetoothRecentlyCalibratedLatency", wVar9, 4, 2025);
        new y("NavigationBluetoothAlreadyCalibratedLatency", w.NAVIGATION, 4, 2025);
        new y("NavigationFeedbackEventTrackUploadStatus", w.NAVIGATION, 4, 2025);
    }
}
