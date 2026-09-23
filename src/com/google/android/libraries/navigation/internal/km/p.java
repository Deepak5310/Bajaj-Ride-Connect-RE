package com.google.android.libraries.navigation.internal.km;

import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public static final x A;
    public static final x B;
    public static final x C;
    public static final x D;
    public static final x E;
    public static final x F;
    public static final x G;
    public static final x H;
    public static final x I;
    public static final x J;
    public static final x K;
    public static final x L;
    public static final x M;
    public static final x N;
    public static final x O;
    public static final x P;
    public static final y Q;
    public static final x R;
    public static final y S;
    public static final x T;
    public static final y U;
    public static final x V;
    public static final y W;
    public static final x X;
    public static final y Y;
    public static final x Z;
    public static final ad a;
    public static final x aA;
    private static final fd aB;
    public static final y aa;
    public static final x ab;
    public static final x ac;
    public static final x ad;
    public static final x ae;
    public static final x af;
    public static final x ag;
    public static final x ah;
    public static final x ai;
    public static final x aj;
    public static final x ak;
    public static final x al;
    public static final x am;
    public static final x an;
    public static final s ao;
    public static final s ap;
    public static final x aq;
    public static final x ar;
    public static final y as;
    public static final y at;
    public static final y au;
    public static final y av;
    public static final x aw;
    public static final y ax;
    public static final x ay;
    public static final r az;
    public static final ad b;
    public static final y c;
    public static final ad d;
    public static final y e;
    public static final u f;
    public static final u g;
    public static final ad h;
    public static final s i;
    public static final s j;
    public static final ad k;
    public static final ad l;
    public static final ad m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y f471n;
    public static final x o;
    public static final y p;
    public static final s q;
    public static final ad r;
    public static final ad s;
    public static final ac t;
    public static final ad u;
    public static final x v;
    public static final x w;
    public static final x x;
    public static final x y;
    public static final x z;

    static {
        ez ezVar = new ez();
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE, "Base");
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_MY_MAPS, "MyMapsTileOverlay");
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIGHT_PERSONALIZED_SMARTMAPS, "PersonalizedSmartmaps");
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIGHT_PERSONALIZED_SMARTMAPS_PER_TILE, "PersonalizedSmartmapsPertile");
        aB = ezVar.d();
        a = new ad("FrameTime", w.MAP, 4, 2025);
        w wVar = w.MAP;
        b = new ad("UserPerceivedFrameTimeTarget30Fps", wVar, 4, 2025);
        c = new y("FrameRateRegulatorLag", wVar, 4, 2025);
        w wVar2 = w.MAP;
        d = new ad("LabelingTimeToComplete", wVar2, 4, 2025);
        e = new y("LabelingPassTime", wVar2, 4, 2025);
        f = new u("LabelsFrameTime", w.MAP);
        g = new u("BuildingsFrameTime", w.MAP);
        w wVar3 = w.MAP;
        h = new ad("NetworkTileFetchingDisabledTime", wVar3, 4, 2025);
        i = new s("StyleTableEpochUrlsNotAvailable", wVar3, 4, 2025);
        j = new s("StyleTablesFetchedFromNetwork", wVar3, 4, 2025);
        k = new ad("InitialMapLoadExplicitGlobalStyleFetchResponseTime", wVar3, 4, 2025);
        l = new ad("AfterMapLoadExplicitGlobalStyleFetchResponseTime", wVar3, 4, 2025);
        m = new ad("InitialMapLoadCommonStyleFetchResponseTime", wVar3, 4, 2025);
        f471n = new y("ExplicitStyleTableFetchIncompleteTime", wVar3, 4, 2025);
        w wVar4 = w.MAP;
        o = new x("StyleTableFetchStatus", wVar4, 4, 2025);
        p = new y("StyleTableNumStyleEntriesUsed", wVar4, 4, 2025);
        new y("TextureAtlasTotalBytes", w.MAP, 4, 2025);
        w wVar5 = w.MAP;
        q = new s("TileParseFailureCount", wVar5, 4, 2025);
        r = new ad("TilePrepTime", wVar5, 4, 2025);
        s = new ad("TilePrepTimeBaseMap", wVar5, 4, 2025);
        com.google.android.libraries.navigation.internal.ky.ab abVar = b.a;
        t = new ac("ViewportMixedEpochsTime", w.MAP, 12, 2300, b.b);
        w wVar6 = w.MAP;
        u = new ad("TileUnpackTime", wVar6, 4, 2025);
        v = new x("TilesNotFoundInMemoryCache", wVar6, 4, 2025);
        w = new x("TilesFoundInMemoryCache", wVar6, 4, 2025);
        x = new x("TilesFetchedFromMemoryCacheNoUpdateRequired", wVar6, 4, 2025);
        y = new x("TilesPrefetchedPerTileExpired", wVar6, 4, 2025);
        z = new x("TilesNotFoundInDiskCache", wVar6, 4, 2025);
        A = new x("TilesFetchedEmptyTilesFromCache", wVar6, 4, 2025);
        B = new x("TilesFetchedFromDiskCacheNoUpdateRequired", wVar6, 4, 2025);
        C = new x("BaseTilesFetchedFromDiskCacheNoUpdateRequired", wVar6, 4, 2026);
        D = new x("TilesPrefetchedNotFoundInDiskCache", wVar6, 4, 2025);
        E = new x("TilesFetchedFromMemoryCache", wVar6, 4, 2025);
        F = new x("TilesPrefetchedFromMemoryCache", wVar6, 4, 2025);
        G = new x("TilesExpiredFromMemoryCache", wVar6, 4, 2025);
        H = new x("TilesFetchedFromDiskCache", wVar6, 4, 2025);
        I = new x("TilesPrefetchedFromDiskCache", wVar6, 4, 2025);
        J = new x("TilesFetchedFromCacheNeedUpdatePertile", wVar6, 4, 2025);
        K = new x("TilesFetchedFromCacheNeedUpdateDataVersion", wVar6, 4, 2025);
        L = new x("TilesFetchedFromCacheNeedUpdateExperimentIds", wVar6, 4, 2025);
        M = new x("TilesFetchedFromServerCacheMiss", wVar6, 4, 2025);
        N = new x("TilesFetchedFromServerAsUpdate", wVar6, 4, 2025);
        O = new x("TilesFetchedFromPaint", wVar6, 4, 2025);
        P = new x("BaseTilesFetchedFromPaint", wVar6, 4, 2026);
        new y("TilesFetchedFromGmmServerSize", wVar6, 4, 2025);
        Q = new y("TilesFetchedFromPaintSize", w.MAP, 4, 2025);
        w wVar7 = w.MAP;
        R = new x("TilesFetchedFromPaintUnchanged", wVar7, 4, 2025);
        new y("TilesFetchedFromGmmServerUnchangedSize", wVar7, 4, 2025);
        S = new y("TilesFetchedFromPaintUnchangedSize", w.MAP, 4, 2025);
        T = new x("TilesFetchedFromPaintUnchangedEpochMatch", w.MAP, 4, 2025);
        com.google.android.libraries.navigation.internal.ky.ab abVar2 = com.google.android.libraries.navigation.internal.ky.ap.a;
        w wVar8 = w.MAP;
        com.google.android.libraries.navigation.internal.ky.ab abVar3 = com.google.android.libraries.navigation.internal.ky.ap.a;
        U = new y("TilesFetchedFromPaintUnchangedEpochMatchSize", wVar8, abVar3);
        V = new x("TilesFetchedFromPaintUnchangedSameDataHash", wVar8, 4, 2025);
        W = new y("TilesFetchedFromPaintUnchangedSameDataHashSize", wVar8, abVar3);
        X = new x("TilesFetchedFromPaintUnchangedSameDataHashEpochBypassed", wVar8, 4, 2025);
        Y = new y("TilesFetchedFromPaintUnchangedSameDataHashEpochBypassedSize", wVar8, abVar3);
        Z = new x("TilesFetchedFromPaintUnchangedFromOffroad", wVar8, 4, 2025);
        aa = new y("TilesFetchedFromPaintUnchangedFromOffroadSize", wVar8, abVar3);
        ab = new x("TilesFetchedFromPaintUpgradedVersion", wVar8, 4, 2025);
        ac = new x("TilesFetchedFromPaintStatusOkEmpty", wVar8, 4, 2025);
        ad = new x("TilesFetchedFromPaintStatusNotFound", wVar8, 4, 2025);
        ae = new x("TilesFetchedFromPaintStatusBadRequest", wVar8, 4, 2025);
        af = new x("TilesFetchedFromPaintStatusServerError", wVar8, 4, 2025);
        ag = new x("TilesPrefetched", wVar8, 4, 2025);
        ah = new x("BaseTilesPrefetched", wVar8, 4, 2026);
        ai = new x("TileNotInDiskCache", wVar8, 4, 2025);
        aj = new x("TileUnpackingFailedIoError", wVar8, 4, 2025);
        ak = new x("TileUnpackingFailedMissingStyleTables", wVar8, 4, 2025);
        al = new x("TileUnpackingFailedParseFailure", wVar8, 4, 2025);
        am = new x("TileUnpackingFailedUnsupportedFormat", wVar8, 4, 2025);
        an = new x("TileUnpackingStyleTableMismatch", wVar8, 4, 2025);
        ao = new s("ClientAreasTextureNotAvailable", wVar8, 4, 2025);
        ap = new s("MapsViewportEmptyAtExit", wVar8, 4, 2025);
        aq = new x("PaintRequestNotBatchedSource", wVar8, 5, 2026);
        ar = new x("TileStoreBaseTileSource", wVar8, 4, 2025);
        as = new y("MapUserInteractionDuration", wVar8);
        at = new y("MapAnimationDurationSecondarySurface", w.MAP);
        au = new y("RenderedFrames", w.MAP);
        av = new y("RenderedFramesSecondarySurface", w.MAP);
        w wVar9 = w.MAP;
        aw = new x("MaxTypedTextureFootprintBytes", wVar9, 4, 2025);
        ax = new y("DirectHttpResourceUrlFetchLatency", wVar9, 4, 2025);
        w wVar10 = w.MAP;
        ay = new x("DirectHttpResourceUrlFetchStatus", wVar10, 4, 2025);
        az = new r("AccessibilityStartupState", wVar10, 4, 2025);
        aA = new x("PendingLabelingLoggingOpsCount", wVar10, 7, 2025);
    }

    public static x a(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return new x("NetworkStatus".concat(String.valueOf(b(anVar))), w.MAP);
    }

    public static String b(com.google.android.libraries.navigation.internal.adi.an anVar) {
        fd fdVar = aB;
        if (fdVar.containsKey(anVar)) {
            return (String) fdVar.get(anVar);
        }
        String strName = anVar.name();
        if (strName.startsWith("GMM_")) {
            strName = strName.substring(4);
        }
        com.google.android.libraries.navigation.internal.yx.g gVar = com.google.android.libraries.navigation.internal.yx.g.e;
        com.google.android.libraries.navigation.internal.yx.g gVar2 = com.google.android.libraries.navigation.internal.yx.g.d;
        com.google.android.libraries.navigation.internal.yx.ar.q(gVar2);
        com.google.android.libraries.navigation.internal.yx.ar.q(strName);
        return gVar2 == gVar ? strName : gVar.a(gVar2, strName);
    }
}
