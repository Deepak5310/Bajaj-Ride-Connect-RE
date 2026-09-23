package com.google.android.libraries.navigation.internal.hw;

import com.google.android.libraries.navigation.internal.km.ad;
import com.google.android.libraries.navigation.internal.km.b;
import com.google.android.libraries.navigation.internal.km.r;
import com.google.android.libraries.navigation.internal.km.s;
import com.google.android.libraries.navigation.internal.km.w;
import com.google.android.libraries.navigation.internal.km.x;
import com.google.android.libraries.navigation.internal.km.y;
import com.google.android.libraries.navigation.internal.ky.ab;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final y a = new y("ClientParametersAgeBeforeUpdateMinutes", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
    public static final ad b;
    public static final s c;
    public static final x d;
    public static final x e;
    public static final y f;
    public static final y g;
    public static final x h;
    public static final x i;
    public static final x j;
    public static final y k;
    public static final y l;
    public static final y m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y f448n;
    public static final y o;
    public static final r p;
    public static final x q;
    public static final x r;
    public static final r s;

    static {
        w wVar = w.PLATFORM_INFRASTRUCTURE;
        b = new ad("ClientParametersFetchTime", wVar, 10, 2025);
        c = new s("ServerResetSignalTriggeredCpRefetchCount", wVar, 10, 2025);
        d = new x("ClientParametersInitialLoadCount", wVar, 10, 2025);
        e = new x("ClientParametersForegroundInitialLoadCount", wVar);
        f = new y("ClientParametersLoadsFromDiskTimeMillis", wVar, 10, 2025);
        g = new y("UiThreadBlockedForClientParametersTimeMillis", w.PLATFORM_INFRASTRUCTURE, 10, 2025);
        w wVar2 = w.PLATFORM_INFRASTRUCTURE;
        h = new x("ClientParametersUpdateSourceChanged", wVar2);
        i = new x("ClientParametersLoadsFromDisk", wVar2, 10, 2025);
        j = new x("ClientParametersForegroundLoadsFromDisk", wVar2, 10, 2025);
        k = new y("ClientParametersCacheAgeMinutes", wVar2, 10, 2025);
        l = new y("ClientParametersForegroundLoadAvailableDiskSpaceMb", w.PLATFORM_INFRASTRUCTURE, 8, 2023, b.b);
        w wVar3 = w.PLATFORM_INFRASTRUCTURE;
        ab abVar = b.b;
        m = new y("ClientParametersForegroundLoadTotalDiskSpaceMb", wVar3, 8, 2023, abVar);
        f448n = new y("ClientParametersForegroundLoadNoFileAvailableDiskSpaceMb", wVar3, 8, 2023, abVar);
        o = new y("ClientParametersForegroundLoadNoFileTotalDiskSpaceMb", wVar3, 8, 2023, abVar);
        p = new r("PhenotypeHeterodyneGwsHeterodyneTokensPresent", wVar3);
        q = new x("GwsClientParametersUpdateReason", wVar3);
        r = new x("ClientParametersUpdateSource", wVar3);
        s = new r("ServerResetSignalClientParametersIsOutdated", wVar3, 10, 2025);
    }
}
