package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag {
    public static final x a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final s e;
    public static final r f;
    public static final x g;
    public static final s h;
    public static final s i;
    public static final s j;
    public static final s k;

    static {
        w wVar = w.NAVIGATION_SESSION_LOGGING;
        a = new x("NavLogTravelMode", wVar, 4, 2025);
        b = new s("NavLogTemporarySessions", wVar, 4, 2025);
        c = new s("NavLog3pSessions", wVar, 4, 2025);
        d = new s("NavLogGuidedSessions", wVar, 4, 2025);
        e = new s("NavLogFreeSessions", wVar, 4, 2025);
        f = new r("NavLogSendEventsToGws", wVar, 4, 2025);
        g = new x("NavLogSendEventsToGwsErrorCode", wVar, 4, 2025);
        h = new s("NavLogSendEventsToGwsTooManyOutstanding", wVar, 4, 2025);
        i = new s("NavLogSendEventsToGwsDiscardedStale", wVar, 4, 2025);
        j = new s("NavLogSendEventsToGwsDiscardedMemoryLimit", wVar, 4, 2025);
        k = new s("NavLogSendEventsToGwsDiscardedEnded", wVar, 4, 2025);
    }
}
