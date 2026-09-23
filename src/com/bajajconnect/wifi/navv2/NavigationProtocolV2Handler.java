package com.bajajconnect.wifi.navv2;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bajajconnect.NavApplication;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.features.VehicleFeature;
import com.bajajconnect.gMaps.ClusterNavigationLauncher;
import com.bajajconnect.gMaps.GoogleNavSdkGate;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.MirroringPolicy;
import com.bajajconnect.wifi.tftEnums.TftAddress;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.maps.android.BuildConfig;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public final class NavigationProtocolV2Handler {
    private static final long GPS_ORIGIN_MAX_AGE_MS = 600000;
    private static final float GPS_ORIGIN_STALE_MOVE_M = 250.0f;
    private static final NavigationProtocolV2Handler INSTANCE = new NavigationProtocolV2Handler();
    private static final String TAG = "NavV2";
    private final ExecutorService queue = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private List<NavV2Models.IndexedPlace> committedPoiResults = new ArrayList();
    private NavV2Models.IndexedPlace lastDetailedPoi = null;
    private boolean freezeCommittedPois = false;
    private int poiListGeneration = 0;
    private int poiDetailGeneration = 0;
    private int tripDetailGeneration = 0;
    private int routePreviewGeneration = 0;
    private int startNavGeneration = 0;
    private volatile boolean clusterSessionActive = false;
    private final NavV2Models.RoutePreference routePreference = new NavV2Models.RoutePreference();
    private List<NavV2Models.IndexedPlace> syncedFavourites = new ArrayList();

    public interface FrameSender {
        void send(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface IntSupplier {
        int get();
    }

    private static boolean needsCellularForCommand(int i) {
        return i == 7 || i == 8 || i == 11 || i == 12;
    }

    private NavigationProtocolV2Handler() {
    }

    public static NavigationProtocolV2Handler getInstance() {
        return INSTANCE;
    }

    public static boolean isEnabledForCurrentSku() {
        return VehicleFeature.UI_NAV_POI.isEnabledFor(BleFeatures.getInstance().modelCode);
    }

    public boolean shouldHandleNavV2() {
        if (this.clusterSessionActive) {
            return true;
        }
        return isEnabledForCurrentSku();
    }

    public void setClusterSessionActive(boolean z) {
        this.clusterSessionActive = z;
        Log.i(TAG, "clusterSessionActive=" + z + " modelCode=" + BleFeatures.getInstance().modelCode + " skuPoi=" + isEnabledForCurrentSku());
    }

    public boolean isClusterSessionActive() {
        return this.clusterSessionActive;
    }

    public void syncFavouritesFromBridge(final List<NavV2Models.IndexedPlace> list) {
        this.queue.execute(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$syncFavouritesFromBridge$0(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$syncFavouritesFromBridge$0(List list) {
        ArrayList arrayList;
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(list.subList(0, Math.min(5, list.size())));
        }
        this.syncedFavourites = arrayList;
    }

    public void handle(final int i, final byte[] bArr, final FrameSender frameSender) {
        String str = BleFeatures.getInstance().modelCode;
        if (!shouldHandleNavV2()) {
            StringBuilder sb = new StringBuilder("Nav V2 cmd=0x");
            sb.append(String.format("%02X", Integer.valueOf(i)));
            sb.append(" — blocked (no TCP session + UI_NAV_POI off) modelCode=");
            if (str == null || str.isEmpty()) {
                str = "(empty)";
            }
            sb.append(str);
            Log.w(TAG, sb.toString());
            respondDisabledSafe(i, bArr, frameSender);
            return;
        }
        if (!isEnabledForCurrentSku()) {
            StringBuilder sb2 = new StringBuilder("Nav V2 cmd=0x");
            sb2.append(String.format("%02X", Integer.valueOf(i)));
            sb2.append(" — handling despite SKU gate (sessionActive) modelCode=");
            if (str == null || str.isEmpty()) {
                str = "(empty)";
            }
            sb2.append(str);
            Log.w(TAG, sb2.toString());
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        this.queue.execute(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handle$1(i, bArr, frameSender);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handle$1(int i, byte[] bArr, FrameSender frameSender) {
        try {
            if (needsCellularForCommand(i)) {
                ensureCellularForPlaces();
            }
            NavigationProtocolV2Codec.logFrame("RX", i, bArr);
            switch (i) {
                case 7:
                    handleGetPoiList(bArr, frameSender);
                    break;
                case 8:
                    handleGetPoiDetail(bArr, frameSender);
                    break;
                case 9:
                    handleGetFavourites(frameSender);
                    break;
                case 10:
                    handleGetRecentTrips(frameSender);
                    break;
                case 11:
                    handleGetTripDetail(bArr, frameSender);
                    break;
                case 12:
                    handleGetRoutePreview(bArr, frameSender);
                    break;
                case 13:
                    handleSetRoutePreference(bArr, frameSender);
                    break;
                case 14:
                    handleGetRoutePreference(frameSender);
                    break;
                case 15:
                    handleStartNavigation(bArr, frameSender);
                    break;
                default:
                    Log.w(TAG, "Unhandled command 0x" + String.format("%02X", Integer.valueOf(i)));
                    break;
            }
        } catch (Throwable th) {
            Log.e(TAG, "Nav V2 cmd=0x" + String.format("%02X", Integer.valueOf(i)) + " failed", th);
        }
    }

    private void respondDisabledSafe(int i, byte[] bArr, FrameSender frameSender) {
        int i2 = 0;
        int i3 = (bArr == null || bArr.length <= 0) ? 0 : bArr[0] & 255;
        switch (i) {
            case 7:
            case 9:
            case 10:
                respondIndexedList(i, new ArrayList(), frameSender);
                break;
            case 8:
            case 11:
                respondEmptyDetail(i, i3, frameSender);
                break;
            case 12:
                NavV2Models.Source sourceFrom = (bArr == null || bArr.length <= 0) ? NavV2Models.Source.POI : NavV2Models.Source.from(bArr[0] & 255);
                if (bArr != null && bArr.length > 1) {
                    i2 = bArr[1] & 255;
                }
                if (sourceFrom == null) {
                    sourceFrom = NavV2Models.Source.POI;
                }
                sendResponse(i, NavigationProtocolV2Codec.encodeRoutePreview(sourceFrom, i2, this.routePreference.routeMode, "", ""), frameSender);
                break;
            case 13:
                sendResponse(i, NavigationProtocolV2Codec.encodePreferenceAck(NavV2Models.AckStatus.FAILURE), frameSender);
                break;
            case 14:
                sendResponse(i, NavigationProtocolV2Codec.encodePreference(this.routePreference), frameSender);
                break;
            case 15:
                respondNavStatus(NavV2Models.NavStatus.FAILED, "", frameSender);
                break;
        }
    }

    private static void ensureCellularForPlaces() {
        try {
            Context contextAppContext = appContext();
            if (contextAppContext != null) {
                Log.i(TAG, "ensureCellularForPlaces ok=" + MirroringPolicy.ensureCellularNetworkForRouting(contextAppContext) + " wifiConnected=" + MirroringGlobarVar.isWifiConnected);
            }
        } catch (Exception e) {
            Log.w(TAG, "ensureCellularForPlaces failed", e);
        }
    }

    private void handleGetPoiList(byte[] bArr, final FrameSender frameSender) {
        if (bArr.length < 4) {
            respondIndexedList(7, new ArrayList(), frameSender);
            return;
        }
        int i = bArr[0] & 255;
        byte b = bArr[1];
        Math.max(1, bArr[2] & 255);
        Math.min(5, Math.max(1, bArr[3] & 255));
        if (this.freezeCommittedPois) {
            Log.w(TAG, "[POI][CLUSTER] GET_POI_LIST during selection — resend committed count=" + this.committedPoiResults.size() + " (requested cat=" + i + ") and clear freeze");
            respondIndexedList(7, this.committedPoiResults, frameSender);
            this.freezeCommittedPois = false;
            return;
        }
        String strPlaceTypeForCategoryIndex = PoiChipCatalog.placeTypeForCategoryIndex(i);
        final int i2 = this.poiListGeneration + 1;
        this.poiListGeneration = i2;
        this.poiDetailGeneration++;
        this.routePreviewGeneration++;
        double[] dArrCurrentOrigin = currentOrigin();
        if (dArrCurrentOrigin[0] == 0.0d && dArrCurrentOrigin[1] == 0.0d) {
            Log.w(TAG, "[POI][CLUSTER] no location yet — returning empty list");
            if (i2 == this.poiListGeneration) {
                ArrayList arrayList = new ArrayList();
                this.committedPoiResults = arrayList;
                this.lastDetailedPoi = null;
                respondIndexedList(7, arrayList, frameSender);
                return;
            }
            return;
        }
        final int i3 = 5;
        GooglePlacesClusterService.fetchNearbyPois(appContext(), dArrCurrentOrigin[0], dArrCurrentOrigin[1], strPlaceTypeForCategoryIndex, 8000, 5, "cluster-tcp", new GooglePlacesClusterService.PlacesCallback() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda13
            @Override // com.bajajconnect.wifi.navv2.GooglePlacesClusterService.PlacesCallback
            public final void onResult(List list) {
                this.f$0.lambda$handleGetPoiList$3(i2, i3, frameSender, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleGetPoiList$3(final int i, final int i2, final FrameSender frameSender, final List list) {
        this.queue.execute(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleGetPoiList$2(i, list, i2, frameSender);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$handleGetPoiList$2(int i, List list, int i2, FrameSender frameSender) {
        if (i != this.poiListGeneration) {
            Log.w(TAG, "[POI][CLUSTER] drop stale list response gen=" + i + " current=" + this.poiListGeneration);
            return;
        }
        if (this.freezeCommittedPois) {
            Log.w(TAG, "[POI][CLUSTER] drop list response — selection freeze active");
            return;
        }
        if (list == null) {
            list = new ArrayList();
        }
        List<NavV2Models.IndexedPlace> listMapPoiToIndexed = mapPoiToIndexed(list, i2);
        this.committedPoiResults = listMapPoiToIndexed;
        this.lastDetailedPoi = null;
        Log.i(TAG, "[POI][CLUSTER] done count=" + listMapPoiToIndexed.size() + " gen=" + i);
        respondIndexedList(7, listMapPoiToIndexed, frameSender);
    }

    private List<NavV2Models.IndexedPlace> mapPoiToIndexed(List<NavV2Models.ClusterPoiItem> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        HashSet hashSet = new HashSet();
        for (NavV2Models.ClusterPoiItem clusterPoiItem : list) {
            if (arrayList.size() >= i) {
                break;
            }
            if (clusterPoiItem != null && clusterPoiItem.hasCoordinates() && hashSet.add(dedupeKey(clusterPoiItem))) {
                arrayList.add(new NavV2Models.IndexedPlace(arrayList.size(), clusterPoiItem.displayTitle(), clusterPoiItem.latitude, clusterPoiItem.longitude, clusterPoiItem.displaySubtitle(), clusterPoiItem.placeId, clusterPoiItem.distanceText, ""));
            }
        }
        return arrayList;
    }

    private static String dedupeKey(NavV2Models.ClusterPoiItem clusterPoiItem) {
        String lowerCase;
        if (clusterPoiItem.placeId != null && !clusterPoiItem.placeId.isEmpty()) {
            return "id:" + clusterPoiItem.placeId;
        }
        if (clusterPoiItem.name != null) {
            lowerCase = clusterPoiItem.name.trim().toLowerCase(Locale.US);
        } else {
            lowerCase = "";
        }
        return "geo:" + lowerCase + ":" + Math.round(clusterPoiItem.latitude * 10000.0d) + ":" + Math.round(clusterPoiItem.longitude * 10000.0d);
    }

    private void handleGetPoiDetail(byte[] bArr, FrameSender frameSender) {
        if (bArr.length < 1) {
            respondEmptyDetail(8, 0, frameSender);
            return;
        }
        int i = bArr[0] & 255;
        NavV2Models.IndexedPlace indexedPlacePlaceAtIndex = placeAtIndex(i, this.committedPoiResults);
        if (indexedPlacePlaceAtIndex == null) {
            Log.w(TAG, "[POI][CLUSTER] detail miss index=" + i + " committed=" + this.committedPoiResults.size());
            respondEmptyDetail(8, i, frameSender);
            return;
        }
        this.lastDetailedPoi = indexedPlacePlaceAtIndex;
        this.freezeCommittedPois = true;
        int i2 = this.poiDetailGeneration + 1;
        this.poiDetailGeneration = i2;
        fetchDetailForPlace(indexedPlacePlaceAtIndex, 8, i2, frameSender);
    }

    private void handleGetFavourites(FrameSender frameSender) {
        respondIndexedList(9, buildFavouritesList(), frameSender);
    }

    private List<NavV2Models.IndexedPlace> buildFavouritesList() {
        ArrayList arrayList;
        if (!this.syncedFavourites.isEmpty()) {
            List<NavV2Models.IndexedPlace> list = this.syncedFavourites;
            arrayList = new ArrayList(list.subList(0, Math.min(5, list.size())));
        } else {
            arrayList = new ArrayList();
            appendFavouriteSlot(arrayList, 0, "Home", MirroringGlobarVar.homeAddress);
            appendFavouriteSlot(arrayList, 1, "Work", MirroringGlobarVar.workAddress);
            appendFavouriteSlot(arrayList, 2, "Favorite", MirroringGlobarVar.favAddress);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<NavV2Models.IndexedPlace> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            NavV2Models.IndexedPlace next = it2.next();
            if (!isValidSavedPlace(next)) {
                StringBuilder sb = new StringBuilder("skip invalid favourite name=");
                sb.append(next != null ? next.name : BuildConfig.TRAVIS);
                sb.append(" idx=");
                sb.append(next != null ? next.index : -1);
                sb.append(" lat=");
                sb.append(next != null ? next.latitude : 0.0d);
                sb.append(" lng=");
                sb.append(next != null ? next.longitude : 0.0d);
                Log.w(TAG, sb.toString());
            } else {
                arrayList2.add(new NavV2Models.IndexedPlace(next.index, next.name, next.latitude, next.longitude, next.address));
                if (arrayList2.size() >= 5) {
                    break;
                }
            }
        }
        return arrayList2;
    }

    private static boolean isValidSavedPlace(NavV2Models.IndexedPlace indexedPlace) {
        if (indexedPlace == null) {
            return false;
        }
        return !((indexedPlace.address != null ? indexedPlace.address.trim() : "").isEmpty() && (indexedPlace.name != null ? indexedPlace.name.trim() : "").isEmpty()) && indexedPlace.hasCoordinates();
    }

    private void appendFavouriteSlot(List<NavV2Models.IndexedPlace> list, int i, String str, TftAddress tftAddress) {
        if (list.size() >= 5 || tftAddress == null) {
            return;
        }
        String strTrim = tftAddress.getAddress() != null ? tftAddress.getAddress().trim() : "";
        if (strTrim.isEmpty()) {
            return;
        }
        double dDoubleValue = tftAddress.getLat() != null ? tftAddress.getLat().doubleValue() : 0.0d;
        double dDoubleValue2 = tftAddress.getLng() != null ? tftAddress.getLng().doubleValue() : 0.0d;
        if (dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) {
            Log.w(TAG, "skip favourite slot without coords label=" + str);
            return;
        }
        list.add(new NavV2Models.IndexedPlace(i, str, dDoubleValue, dDoubleValue2, strTrim));
    }

    private void handleGetRecentTrips(FrameSender frameSender) {
        respondIndexedList(10, NavigationRecentTripsStore.load(appContext()), frameSender);
    }

    private void handleGetTripDetail(byte[] bArr, FrameSender frameSender) {
        List<NavV2Models.IndexedPlace> listLoad = NavigationRecentTripsStore.load(appContext());
        if (bArr.length < 1) {
            respondEmptyDetail(11, 0, frameSender);
            return;
        }
        int i = bArr[0] & 255;
        NavV2Models.IndexedPlace indexedPlacePlaceAtIndex = placeAtIndex(i, listLoad);
        if (indexedPlacePlaceAtIndex == null) {
            respondEmptyDetail(11, i, frameSender);
            return;
        }
        int i2 = this.tripDetailGeneration + 1;
        this.tripDetailGeneration = i2;
        fetchDetailForPlace(indexedPlacePlaceAtIndex, 11, i2, frameSender);
    }

    private void handleGetRoutePreview(byte[] bArr, final FrameSender frameSender) {
        final int i = this.routePreviewGeneration + 1;
        this.routePreviewGeneration = i;
        if (bArr.length < 2) {
            sendResponseIfCurrent(12, NavigationProtocolV2Codec.encodeRoutePreview(NavV2Models.Source.POI, 0, this.routePreference.routeMode, "", ""), frameSender, i, new IntSupplier() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda9
                @Override // com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler.IntSupplier
                public final int get() {
                    return this.f$0.lambda$handleGetRoutePreview$4();
                }
            });
            return;
        }
        final NavV2Models.Source sourceFrom = NavV2Models.Source.from(bArr[0] & 255);
        final NavV2Models.IndexedPlace indexedPlaceResolvePlace = sourceFrom != null ? resolvePlace(sourceFrom, bArr[1] & 255) : null;
        if (indexedPlaceResolvePlace == null) {
            if (sourceFrom == null) {
                sourceFrom = NavV2Models.Source.POI;
            }
            sendResponseIfCurrent(12, NavigationProtocolV2Codec.encodeRoutePreview(sourceFrom, bArr[1] & 255, this.routePreference.routeMode, "", ""), frameSender, i, new IntSupplier() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda10
                @Override // com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler.IntSupplier
                public final int get() {
                    return this.f$0.lambda$handleGetRoutePreview$5();
                }
            });
        } else {
            double[] dArrCurrentOrigin = currentOrigin();
            NavigationDirectionsHelper.fetchRouteSummary(appContext(), dArrCurrentOrigin[0], dArrCurrentOrigin[1], indexedPlaceResolvePlace.latitude, indexedPlaceResolvePlace.longitude, this.routePreference, new NavigationDirectionsHelper.SummaryCallback() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda11
                @Override // com.bajajconnect.wifi.navv2.NavigationDirectionsHelper.SummaryCallback
                public final void onResult(NavV2Models.RouteSummary routeSummary) {
                    this.f$0.lambda$handleGetRoutePreview$7(i, indexedPlaceResolvePlace, sourceFrom, frameSender, routeSummary);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$handleGetRoutePreview$4() {
        return this.routePreviewGeneration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$handleGetRoutePreview$5() {
        return this.routePreviewGeneration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleGetRoutePreview$7(final int i, final NavV2Models.IndexedPlace indexedPlace, final NavV2Models.Source source, final FrameSender frameSender, final NavV2Models.RouteSummary routeSummary) {
        this.queue.execute(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleGetRoutePreview$6(i, routeSummary, indexedPlace, source, frameSender);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleGetRoutePreview$6(int i, NavV2Models.RouteSummary routeSummary, NavV2Models.IndexedPlace indexedPlace, NavV2Models.Source source, FrameSender frameSender) {
        String str;
        String str2;
        NavV2Models.RouteMode routeMode;
        if (i != this.routePreviewGeneration) {
            Log.w(TAG, "drop stale route preview gen=" + i);
            return;
        }
        if (routeSummary != null && !routeSummary.distanceText.isEmpty()) {
            str = routeSummary.distanceText;
        } else {
            str = indexedPlace.distanceText;
        }
        if (routeSummary != null && !routeSummary.etaText.isEmpty()) {
            str2 = routeSummary.etaText;
        } else {
            str2 = indexedPlace.etaText;
        }
        if (routeSummary != null) {
            routeMode = routeSummary.appliedRouteMode;
        } else {
            routeMode = this.routePreference.routeMode;
        }
        sendResponse(12, NavigationProtocolV2Codec.encodeRoutePreview(source, indexedPlace.index, routeMode, str, str2), frameSender);
    }

    private void handleSetRoutePreference(byte[] bArr, FrameSender frameSender) {
        if (bArr.length < 4 || (bArr[3] & 255) != 0 || NavV2Models.RouteMode.from(bArr[1] & 255) == null || NavV2Models.Units.from(bArr[2] & 255) == null) {
            sendResponse(13, NavigationProtocolV2Codec.encodePreferenceAck(NavV2Models.AckStatus.FAILURE), frameSender);
            return;
        }
        this.routePreference.bitmask = bArr[0] & Ascii.SI;
        this.routePreference.routeMode = NavV2Models.RouteMode.from(bArr[1] & 255);
        this.routePreference.units = NavV2Models.Units.from(bArr[2] & 255);
        sendResponse(13, NavigationProtocolV2Codec.encodePreferenceAck(NavV2Models.AckStatus.SUCCESS), frameSender);
    }

    private void handleGetRoutePreference(FrameSender frameSender) {
        sendResponse(14, NavigationProtocolV2Codec.encodePreference(this.routePreference), frameSender);
    }

    private void handleStartNavigation(byte[] bArr, final FrameSender frameSender) {
        final int i = this.startNavGeneration + 1;
        this.startNavGeneration = i;
        if (bArr.length < 2) {
            Log.w(TAG, "START_NAV short payload len=" + bArr.length);
            this.freezeCommittedPois = false;
            respondNavStatus(NavV2Models.NavStatus.FAILED, "", frameSender);
            return;
        }
        NavV2Models.Source sourceFrom = NavV2Models.Source.from(bArr[0] & 255);
        int i2 = bArr[1] & 255;
        NavV2Models.IndexedPlace indexedPlaceResolvePlace = sourceFrom != null ? resolvePlace(sourceFrom, i2) : null;
        if (sourceFrom == NavV2Models.Source.POI && indexedPlaceResolvePlace == null && this.lastDetailedPoi != null) {
            Log.w(TAG, "START_NAV index=" + i2 + " miss; using lastDetailedPoi index=" + this.lastDetailedPoi.index + " name=" + this.lastDetailedPoi.name);
            indexedPlaceResolvePlace = this.lastDetailedPoi;
        }
        final NavV2Models.IndexedPlace indexedPlace = indexedPlaceResolvePlace;
        if (sourceFrom == NavV2Models.Source.FAVOURITE && (indexedPlace == null || indexedPlace.index != i2 || !isValidSavedPlace(indexedPlace))) {
            StringBuilder sb = new StringBuilder("START_NAV FAILED favourite slot unset/invalid index=");
            sb.append(i2);
            sb.append(" resolvedIdx=");
            sb.append(indexedPlace != null ? indexedPlace.index : -1);
            sb.append(" name=");
            sb.append(indexedPlace != null ? indexedPlace.name : BuildConfig.TRAVIS);
            Log.w(TAG, sb.toString());
            this.freezeCommittedPois = false;
            respondNavStatus(NavV2Models.NavStatus.FAILED, "", frameSender);
            return;
        }
        if (indexedPlace == null || !indexedPlace.hasCoordinates()) {
            StringBuilder sb2 = new StringBuilder("START_NAV FAILED source=");
            sb2.append(sourceFrom);
            sb2.append(" index=");
            sb2.append(i2);
            sb2.append(" placeNull=");
            sb2.append(indexedPlace == null);
            sb2.append(" committed=");
            sb2.append(this.committedPoiResults.size());
            Log.w(TAG, sb2.toString());
            this.freezeCommittedPois = false;
            respondNavStatus(NavV2Models.NavStatus.FAILED, "", frameSender);
            return;
        }
        final String str = indexedPlace.etaText;
        Log.i(TAG, "START_NAV launch name=" + indexedPlace.name + " idx=" + indexedPlace.index + " lat=" + indexedPlace.latitude + " lng=" + indexedPlace.longitude + " gen=" + i);
        final Context contextAppContext = appContext();
        if (contextAppContext != null) {
            new Thread(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    NavigationProtocolV2Handler.lambda$handleStartNavigation$8(contextAppContext);
                }
            }, "nav-v2-start-prewarm").start();
        }
        this.mainHandler.post(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleStartNavigation$9(indexedPlace, str, i, frameSender);
            }
        });
    }

    static /* synthetic */ void lambda$handleStartNavigation$8(Context context) {
        try {
            MirroringPolicy.ensureCellularNetworkForRouting(context);
        } catch (Exception e) {
            Log.w(TAG, "START_NAV prewarm cellular failed", e);
        }
        try {
            if (NavApplication.streamingHandler != null) {
                if (!NavApplication.streamingHandler.isTcpBoundOrBinding()) {
                    NavApplication.streamingHandler.initTcpServer();
                }
                if (NavApplication.streamingHandler.isUdpBoundOrBinding()) {
                    return;
                }
                NavApplication.streamingHandler.initUdpServer();
            }
        } catch (Exception e2) {
            Log.w(TAG, "START_NAV prewarm sockets failed", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: launchNavigation, reason: merged with bridge method [inline-methods] */
    public void lambda$handleStartNavigation$9(NavV2Models.IndexedPlace indexedPlace, final String str, final int i, final FrameSender frameSender) {
        try {
            if (i != this.startNavGeneration) {
                Log.w(TAG, "drop superseded start-nav launch gen=" + i);
                return;
            }
            Context contextAppContext = appContext();
            if (contextAppContext == null) {
                Log.e(TAG, "launchNavigation: null context");
                this.queue.execute(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$launchNavigation$10(i, frameSender);
                    }
                });
                return;
            }
            GlobalVar.lat = Double.valueOf(indexedPlace.latitude);
            GlobalVar.lng = Double.valueOf(indexedPlace.longitude);
            ELocation eLocation = new ELocation();
            eLocation.latitude = Double.valueOf(indexedPlace.latitude);
            eLocation.longitude = Double.valueOf(indexedPlace.longitude);
            eLocation.placeName = indexedPlace.name;
            eLocation.placeAddress = indexedPlace.address.isEmpty() ? indexedPlace.name : indexedPlace.address;
            NavApplication.eLocation = eLocation;
            NavigationRecentTripsStore.recordTrip(contextAppContext, indexedPlace.name, indexedPlace.latitude, indexedPlace.longitude, indexedPlace.address);
            MirroringPolicy.releaseCaptureBuffersBeforeNavLaunch(contextAppContext);
            try {
                MirroringPolicy.ensureCellularNetworkForRouting(contextAppContext);
            } catch (Exception e) {
                Log.w(TAG, "launchNavigation: cellular bind failed", e);
            }
            if (GlobalVar.isGoogleNavigation) {
                GoogleNavSdkGate.setNavigationActivityOwnsNavigator(true);
            }
            ClusterNavigationLauncher.launchFromCluster(contextAppContext);
            this.queue.execute(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$launchNavigation$11(i, str, frameSender);
                }
            });
        } catch (Exception e2) {
            Log.e(TAG, "launchNavigation failed", e2);
            try {
                GoogleNavSdkGate.setNavigationActivityOwnsNavigator(false);
            } catch (Exception unused) {
            }
            this.queue.execute(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$launchNavigation$12(i, frameSender);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchNavigation$10(int i, FrameSender frameSender) {
        if (i == this.startNavGeneration) {
            respondNavStatus(NavV2Models.NavStatus.FAILED, "", frameSender);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchNavigation$11(int i, String str, FrameSender frameSender) {
        if (i != this.startNavGeneration) {
            Log.w(TAG, "drop stale START_NAV success gen=" + i);
        } else {
            this.freezeCommittedPois = false;
            NavV2Models.NavStatus navStatus = NavV2Models.NavStatus.STARTED;
            if (str == null) {
                str = "";
            }
            respondNavStatus(navStatus, str, frameSender);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchNavigation$12(int i, FrameSender frameSender) {
        if (i == this.startNavGeneration) {
            this.freezeCommittedPois = false;
            respondNavStatus(NavV2Models.NavStatus.FAILED, "", frameSender);
        }
    }

    private void fetchDetailForPlace(final NavV2Models.IndexedPlace indexedPlace, final int i, final int i2, final FrameSender frameSender) {
        if (i == 8 && !indexedPlace.distanceText.isEmpty()) {
            sendResponse(i, NavigationProtocolV2Codec.encodeDetail(indexedPlace.index, indexedPlace.name, indexedPlace.distanceText, indexedPlace.etaText), frameSender);
        } else {
            double[] dArrCurrentOrigin = currentOrigin();
            NavigationDirectionsHelper.fetchRouteSummary(appContext(), dArrCurrentOrigin[0], dArrCurrentOrigin[1], indexedPlace.latitude, indexedPlace.longitude, this.routePreference, new NavigationDirectionsHelper.SummaryCallback() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda1
                @Override // com.bajajconnect.wifi.navv2.NavigationDirectionsHelper.SummaryCallback
                public final void onResult(NavV2Models.RouteSummary routeSummary) {
                    this.f$0.lambda$fetchDetailForPlace$14(i, i2, indexedPlace, frameSender, routeSummary);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchDetailForPlace$14(final int i, final int i2, final NavV2Models.IndexedPlace indexedPlace, final FrameSender frameSender, final NavV2Models.RouteSummary routeSummary) {
        this.queue.execute(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fetchDetailForPlace$13(i, i2, routeSummary, indexedPlace, frameSender);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchDetailForPlace$13(int i, int i2, NavV2Models.RouteSummary routeSummary, NavV2Models.IndexedPlace indexedPlace, FrameSender frameSender) {
        if (i != 8 ? i2 != this.tripDetailGeneration : i2 != this.poiDetailGeneration) {
            Log.w(TAG, "drop stale detail cmd=0x" + String.format("%02X", Integer.valueOf(i)) + " gen=" + i2);
            return;
        }
        sendResponse(i, NavigationProtocolV2Codec.encodeDetail(indexedPlace.index, indexedPlace.name, routeSummary != null ? routeSummary.distanceText : indexedPlace.distanceText, routeSummary != null ? routeSummary.etaText : indexedPlace.etaText), frameSender);
    }

    /* JADX INFO: renamed from: com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bajajconnect$wifi$navv2$NavV2Models$Source;

        static {
            int[] iArr = new int[NavV2Models.Source.values().length];
            $SwitchMap$com$bajajconnect$wifi$navv2$NavV2Models$Source = iArr;
            try {
                iArr[NavV2Models.Source.POI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bajajconnect$wifi$navv2$NavV2Models$Source[NavV2Models.Source.FAVOURITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bajajconnect$wifi$navv2$NavV2Models$Source[NavV2Models.Source.RECENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private NavV2Models.IndexedPlace resolvePlace(NavV2Models.Source source, int i) {
        int i2 = AnonymousClass1.$SwitchMap$com$bajajconnect$wifi$navv2$NavV2Models$Source[source.ordinal()];
        if (i2 == 1) {
            return placeAtIndex(i, this.committedPoiResults);
        }
        if (i2 == 2) {
            return placeAtIndex(i, buildFavouritesList());
        }
        if (i2 != 3) {
            return null;
        }
        return placeAtIndex(i, NavigationRecentTripsStore.load(appContext()));
    }

    private NavV2Models.IndexedPlace placeAtIndex(int i, List<NavV2Models.IndexedPlace> list) {
        if (list != null && !list.isEmpty()) {
            for (NavV2Models.IndexedPlace indexedPlace : list) {
                if (indexedPlace.index == i) {
                    return indexedPlace;
                }
            }
        }
        return null;
    }

    private void respondIndexedList(int i, List<NavV2Models.IndexedPlace> list, FrameSender frameSender) {
        sendResponse(i, NavigationProtocolV2Codec.encodeIndexedNameList(list), frameSender);
    }

    private void respondEmptyDetail(int i, int i2, FrameSender frameSender) {
        sendResponse(i, NavigationProtocolV2Codec.encodeDetail(i2, "", "", ""), frameSender);
    }

    private void respondNavStatus(NavV2Models.NavStatus navStatus, String str, FrameSender frameSender) {
        sendResponse(15, NavigationProtocolV2Codec.encodeNavStatus(navStatus, str), frameSender);
    }

    private void sendResponseIfCurrent(int i, byte[] bArr, FrameSender frameSender, int i2, IntSupplier intSupplier) {
        if (i2 != intSupplier.get()) {
            Log.w(TAG, "drop superseded response cmd=0x" + String.format("%02X", Integer.valueOf(i)));
            return;
        }
        sendResponse(i, bArr, frameSender);
    }

    private void sendResponse(int i, byte[] bArr, FrameSender frameSender) {
        byte[] bArrBuildResponse = NavigationProtocolV2Codec.buildResponse(i, bArr);
        NavigationProtocolV2Codec.logFrame("TX", i, bArr);
        if (frameSender != null) {
            frameSender.send(bArrBuildResponse);
        }
    }

    private static double[] currentOrigin() {
        float f;
        Double d = MirroringGlobarVar.currentLat;
        Double d2 = MirroringGlobarVar.currentLng;
        boolean z = (d == null || d2 == null || (d.doubleValue() == 0.0d && d2.doubleValue() == 0.0d)) ? false : true;
        Location bestLastKnownLocation = readBestLastKnownLocation();
        if (bestLastKnownLocation != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - bestLastKnownLocation.getTime();
            boolean z2 = jCurrentTimeMillis >= 0 && jCurrentTimeMillis <= GPS_ORIGIN_MAX_AGE_MS;
            if (z) {
                float[] fArr = new float[1];
                Location.distanceBetween(d.doubleValue(), d2.doubleValue(), bestLastKnownLocation.getLatitude(), bestLastKnownLocation.getLongitude(), fArr);
                f = fArr[0];
            } else {
                f = Float.MAX_VALUE;
            }
            if (!z || z2 || f >= GPS_ORIGIN_STALE_MOVE_M) {
                publishSearchOrigin(bestLastKnownLocation.getLatitude(), bestLastKnownLocation.getLongitude());
                return new double[]{bestLastKnownLocation.getLatitude(), bestLastKnownLocation.getLongitude()};
            }
        }
        if (z) {
            return new double[]{d.doubleValue(), d2.doubleValue()};
        }
        Double d3 = GlobalVar.lat;
        Double d4 = GlobalVar.lng;
        if (d3 != null && d4 != null && (d3.doubleValue() != 0.0d || d4.doubleValue() != 0.0d)) {
            return new double[]{d3.doubleValue(), d4.doubleValue()};
        }
        return new double[]{0.0d, 0.0d};
    }

    private static void publishSearchOrigin(double d, double d2) {
        MirroringGlobarVar.currentLat = Double.valueOf(d);
        MirroringGlobarVar.currentLng = Double.valueOf(d2);
        GlobalVar.lat = Double.valueOf(d);
        GlobalVar.lng = Double.valueOf(d2);
    }

    private static Location readBestLastKnownLocation() {
        Context contextAppContext = appContext();
        if (contextAppContext == null) {
            return null;
        }
        try {
            boolean z = ContextCompat.checkSelfPermission(contextAppContext, "android.permission.ACCESS_FINE_LOCATION") == 0;
            boolean z2 = ContextCompat.checkSelfPermission(contextAppContext, "android.permission.ACCESS_COARSE_LOCATION") == 0;
            if (!z && !z2) {
                Log.w(TAG, "currentOrigin: location permission not granted");
                return null;
            }
            LocationManager locationManager = (LocationManager) contextAppContext.getSystemService(FirebaseAnalytics.Param.LOCATION);
            if (locationManager == null) {
                return null;
            }
            Iterator<String> it2 = locationManager.getProviders(true).iterator();
            Location location = null;
            while (it2.hasNext()) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(it2.next());
                if (lastKnownLocation != null && (location == null || lastKnownLocation.getTime() > location.getTime())) {
                    location = lastKnownLocation;
                }
            }
            if (location == null || (location.getLatitude() == 0.0d && location.getLongitude() == 0.0d)) {
                return null;
            }
            return location;
        } catch (SecurityException e) {
            Log.w(TAG, "currentOrigin: SecurityException reading last-known", e);
        } catch (Exception e2) {
            Log.w(TAG, "currentOrigin: failed reading last-known", e2);
        }
    }

    private static Context appContext() {
        Context context = BleFeatures.getInstance().context;
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }
}
