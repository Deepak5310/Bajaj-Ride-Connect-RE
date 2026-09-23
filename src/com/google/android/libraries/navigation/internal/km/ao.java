package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao {
    public static final s a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final s e;
    public static final s f;
    public static final s g;
    public static final y h;
    public static final y i;
    public static final y j;
    public static final y k;
    public static final y l;
    public static final y m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y f468n;
    public static final y o;
    public static final y p;
    public static final y q;
    public static final y r;
    public static final y s;
    public static final y t;
    public static final y u;

    static {
        w wVar = w.PLATFORM_INFRASTRUCTURE;
        a = new s("ServerResetSignalReceivedCount", wVar, 10, 2025);
        b = new s("NetworkSentGmmAllBytes", wVar, 10, 2025);
        c = new s("NetworkSentGmmAllMessages", wVar, 10, 2025);
        d = new s("NetworkSentGmmCompressedBytes", wVar, 10, 2025);
        e = new s("NetworkSentGmmCompressedMessages", wVar, 10, 2025);
        f = new s("NetworkSentGmmVersionHeaderBytes", wVar, 10, 2025);
        g = new s("NetworkSentGmmVersionHeaderMessages", wVar, 10, 2025);
        h = new y("NetworkLatency", wVar, 10, 2025);
        i = new y("NetworkSentHttpBytes", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        j = new y("NetworkReceivedHttpBytes", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        k = new y("NetworkSentProtoBytes", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        l = new y("NetworkReceivedProtoBytes", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        m = new y("NetworkReceivedBytesPerSecond", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        f468n = new y("NetworkReceivedBytesPerSession", w.PLATFORM_INFRASTRUCTURE, com.google.android.libraries.navigation.internal.ky.ap.a);
        w wVar2 = w.PLATFORM_INFRASTRUCTURE;
        com.google.android.libraries.navigation.internal.ky.ab abVar = com.google.android.libraries.navigation.internal.ky.ap.a;
        o = new y("NetworkSentBytesPerSession", wVar2, abVar);
        p = new y("NetworkProtosPerSession", wVar2, abVar);
        q = new y("NetworkHttpPerSession", wVar2, abVar);
        r = new y("NetworkSentBytesPerSecondDuringSession", wVar2, abVar);
        s = new y("NetworkReceivedBytesPerSecondDuringSession", wVar2, abVar);
        new y("NetworkGrpcMetadataBytes", wVar2, 10, 2025);
        t = new y("TotalRequestSizeBytesCompressed", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        u = new y("TotalResponseSizeBytesCompressed", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        new y("GmsComplianceFailureDuration", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        new y("GmsComplianceSuccessDuration", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        new y("EomTransitionMinutes", w.PLATFORM_INFRASTRUCTURE, 5, 2027);
    }
}
