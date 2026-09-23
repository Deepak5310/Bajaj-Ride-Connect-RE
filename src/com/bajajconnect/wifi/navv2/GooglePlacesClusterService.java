package com.bajajconnect.wifi.navv2;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.bajajconnect.gMaps.util.GmapUtil;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToDoubleFunction;

/* JADX INFO: loaded from: classes3.dex */
public final class GooglePlacesClusterService {
    private static final Map<String, CacheEntry> CACHE = new ConcurrentHashMap();
    private static final long CACHE_TTL_MS = 45000;
    private static final String TAG = "ClusterPOI";
    private static PlacesClient placesClient;

    public interface PlaceCallback {
        void onResult(NavV2Models.ClusterPoiItem clusterPoiItem);
    }

    public interface PlacesCallback {
        void onResult(List<NavV2Models.ClusterPoiItem> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class CacheEntry {
        final long expiresAtMs;
        final List<NavV2Models.ClusterPoiItem> items;

        CacheEntry(List<NavV2Models.ClusterPoiItem> list, long j) {
            this.items = list;
            this.expiresAtMs = j;
        }
    }

    private GooglePlacesClusterService() {
    }

    public static void fetchNearbyPois(Context context, final double d, final double d2, String str, int i, int i2, final String str2, final PlacesCallback placesCallback) {
        if (placesCallback == null) {
            return;
        }
        final Context applicationContext = context != null ? context.getApplicationContext() : null;
        final int iMin = Math.min(50000, Math.max(1, i > 0 ? i : 8000));
        final int iMin2 = Math.min(5, Math.max(1, i2 > 0 ? i2 : 5));
        String strTrim = str != null ? str.trim() : "";
        final String strCacheKey = cacheKey(strTrim, d, d2, iMin);
        CacheEntry cacheEntry = CACHE.get(strCacheKey);
        if (cacheEntry != null && cacheEntry.expiresAtMs > System.currentTimeMillis()) {
            Log.i(TAG, "[POI][" + sourceTag(str2) + "] phase=cache type=" + strTrim + " count=" + cacheEntry.items.size());
            logResults(str2, cacheEntry.items);
            placesCallback.onResult(new ArrayList(cacheEntry.items));
            return;
        }
        Log.i(TAG, "[POI][" + sourceTag(str2) + "] phase=fetch type=" + strTrim + " radius=" + iMin + " max=" + iMin2 + " origin=" + d + "," + d2);
        searchPlacesSdk(applicationContext, d, d2, iMin, strTrim, new PlacesCallback() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda3
            @Override // com.bajajconnect.wifi.navv2.GooglePlacesClusterService.PlacesCallback
            public final void onResult(List list) {
                Context context2 = applicationContext;
                double d3 = d;
                double d4 = d2;
                int i3 = iMin;
                int i4 = iMin2;
                String str3 = str2;
                GooglePlacesClusterService.finalizeNearbyPois(context2, d3, d4, i3, i4, str3, list != null ? list : new ArrayList(), new GooglePlacesClusterService.PlacesCallback() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda6
                    @Override // com.bajajconnect.wifi.navv2.GooglePlacesClusterService.PlacesCallback
                    public final void onResult(List list2) {
                        GooglePlacesClusterService.lambda$fetchNearbyPois$0(str, str3, placesCallback, list2);
                    }
                });
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$fetchNearbyPois$0(String str, String str2, PlacesCallback placesCallback, List list) {
        if (list == null) {
            list = new ArrayList();
        }
        CACHE.put(str, new CacheEntry(new ArrayList(list), System.currentTimeMillis() + CACHE_TTL_MS));
        logResults(str2, list);
        placesCallback.onResult(list);
    }

    public static void nearbySearch(Context context, double d, double d2, int i, String str, PlacesCallback placesCallback) {
        fetchNearbyPois(context, d, d2, str, i, 5, "cluster-tcp", placesCallback);
    }

    public static void placeDetails(Context context, String str, final PlaceCallback placeCallback) {
        if (placeCallback == null) {
            return;
        }
        if (str == null || str.isEmpty()) {
            placeCallback.onResult(null);
            return;
        }
        PlacesClient placesClientClient = client(context);
        if (placesClientClient == null) {
            placeCallback.onResult(null);
        } else {
            placesClientClient.fetchPlace(FetchPlaceRequest.newInstance(str, Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS))).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda4
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    placeCallback.onResult(GooglePlacesClusterService.fromPlace(((FetchPlaceResponse) obj).getPlace()));
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda5
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GooglePlacesClusterService.lambda$placeDetails$3(placeCallback, exc);
                }
            });
        }
    }

    static /* synthetic */ void lambda$placeDetails$3(PlaceCallback placeCallback, Exception exc) {
        Log.w(TAG, "placeDetails failed: " + exc.getMessage());
        placeCallback.onResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void finalizeNearbyPois(Context context, final double d, final double d2, int i, int i2, String str, List<NavV2Models.ClusterPoiItem> list, PlacesCallback placesCallback) {
        String str2;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (NavV2Models.ClusterPoiItem clusterPoiItem : list) {
            if (clusterPoiItem != null && clusterPoiItem.hasCoordinates()) {
                if (clusterPoiItem.placeId.isEmpty()) {
                    str2 = String.format(Locale.US, "geo:%s:%.4f:%.4f", clusterPoiItem.name != null ? clusterPoiItem.name.trim().toLowerCase(Locale.US) : "", Double.valueOf(clusterPoiItem.latitude), Double.valueOf(clusterPoiItem.longitude));
                } else {
                    str2 = "id:" + clusterPoiItem.placeId;
                }
                if (hashSet.add(str2)) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(d, d2, clusterPoiItem.latitude, clusterPoiItem.longitude, fArr);
                    if (fArr[0] <= i) {
                        arrayList.add(clusterPoiItem);
                    }
                }
            }
        }
        arrayList.sort(Comparator.comparingDouble(new ToDoubleFunction() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda1
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                NavV2Models.ClusterPoiItem clusterPoiItem2 = (NavV2Models.ClusterPoiItem) obj;
                return GooglePlacesClusterService.crowFliesMeters(d, d2, clusterPoiItem2.latitude, clusterPoiItem2.longitude);
            }
        }));
        int iMax = Math.max(10, i2 * 2);
        ArrayList arrayList2 = arrayList.size() > iMax ? new ArrayList(arrayList.subList(0, iMax)) : arrayList;
        Log.i(TAG, "[POI][" + sourceTag(str) + "] phase=directions candidates=" + arrayList2.size());
        NavigationDirectionsHelper.enrichAndSortByRouteDistance(context, d, d2, arrayList2, i2, placesCallback);
    }

    private static void searchPlacesSdk(Context context, final double d, final double d2, final int i, final String str, final PlacesCallback placesCallback) {
        final PlacesClient placesClientClient = client(context);
        if (placesClientClient == null) {
            Log.w(TAG, "Places client unavailable");
            placesCallback.onResult(new ArrayList());
            return;
        }
        SearchByTextRequest.Builder locationBias = SearchByTextRequest.builder(PoiChipCatalog.humanQueryForType(str), Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS, Place.Field.TYPES)).setMaxResultCount(20).setLocationBias(CircularBounds.newInstance(new LatLng(d, d2), Math.max(i, 1000)));
        if (PoiChipCatalog.supportsIncludedType(str)) {
            locationBias.setIncludedType(str);
        }
        placesClientClient.searchByText(locationBias.build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda9
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GooglePlacesClusterService.lambda$searchPlacesSdk$5(str, placesClientClient, d, d2, i, placesCallback, (SearchByTextResponse) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GooglePlacesClusterService.lambda$searchPlacesSdk$6(placesClientClient, d, d2, i, str, placesCallback, exc);
            }
        });
    }

    static /* synthetic */ void lambda$searchPlacesSdk$5(String str, PlacesClient placesClient2, double d, double d2, int i, PlacesCallback placesCallback, SearchByTextResponse searchByTextResponse) {
        List<Place> places = searchByTextResponse.getPlaces();
        ArrayList arrayList = new ArrayList();
        if (places != null) {
            Iterator<Place> it2 = places.iterator();
            while (it2.hasNext()) {
                NavV2Models.ClusterPoiItem clusterPoiItemFromPlace = fromPlace(it2.next());
                if (clusterPoiItemFromPlace != null) {
                    arrayList.add(clusterPoiItemFromPlace);
                }
            }
        }
        Log.i(TAG, "searchByText places=" + arrayList.size() + " type=" + str);
        if (arrayList.isEmpty()) {
            searchPlacesAutocompleteFallback(placesClient2, d, d2, i, str, placesCallback);
        } else {
            placesCallback.onResult(arrayList);
        }
    }

    static /* synthetic */ void lambda$searchPlacesSdk$6(PlacesClient placesClient2, double d, double d2, int i, String str, PlacesCallback placesCallback, Exception exc) {
        Log.w(TAG, "searchByText failed; autocomplete fallback", exc);
        searchPlacesAutocompleteFallback(placesClient2, d, d2, i, str, placesCallback);
    }

    private static void searchPlacesAutocompleteFallback(final PlacesClient placesClient2, double d, double d2, int i, String str, final PlacesCallback placesCallback) {
        double dMin = ((double) Math.min(Math.max(i * 3, 12000), 50000)) / 111000.0d;
        double dAbs = Math.abs(dMin / Math.cos(Math.toRadians(d)));
        placesClient2.findAutocompletePredictions(FindAutocompletePredictionsRequest.builder().setQuery(PoiChipCatalog.humanQueryForType(str)).setLocationBias(RectangularBounds.newInstance(new LatLng(d - dMin, d2 - dAbs), new LatLng(d + dMin, d2 + dAbs))).build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GooglePlacesClusterService.lambda$searchPlacesAutocompleteFallback$9(placesCallback, placesClient2, (FindAutocompletePredictionsResponse) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GooglePlacesClusterService.lambda$searchPlacesAutocompleteFallback$10(placesCallback, exc);
            }
        });
    }

    static /* synthetic */ void lambda$searchPlacesAutocompleteFallback$9(final PlacesCallback placesCallback, PlacesClient placesClient2, FindAutocompletePredictionsResponse findAutocompletePredictionsResponse) {
        List<AutocompletePrediction> autocompletePredictions = findAutocompletePredictionsResponse.getAutocompletePredictions();
        if (autocompletePredictions == null || autocompletePredictions.isEmpty()) {
            placesCallback.onResult(new ArrayList());
            return;
        }
        int iMin = Math.min(10, autocompletePredictions.size());
        final List listSynchronizedList = Collections.synchronizedList(new ArrayList());
        final AtomicInteger atomicInteger = new AtomicInteger(iMin);
        List listAsList = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS);
        for (int i = 0; i < iMin; i++) {
            placesClient2.fetchPlace(FetchPlaceRequest.newInstance(autocompletePredictions.get(i).getPlaceId(), listAsList)).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda7
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    GooglePlacesClusterService.lambda$searchPlacesAutocompleteFallback$7(listSynchronizedList, atomicInteger, placesCallback, (FetchPlaceResponse) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.wifi.navv2.GooglePlacesClusterService$$ExternalSyntheticLambda8
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GooglePlacesClusterService.lambda$searchPlacesAutocompleteFallback$8(atomicInteger, placesCallback, listSynchronizedList, exc);
                }
            });
        }
    }

    static /* synthetic */ void lambda$searchPlacesAutocompleteFallback$7(List list, AtomicInteger atomicInteger, PlacesCallback placesCallback, FetchPlaceResponse fetchPlaceResponse) {
        NavV2Models.ClusterPoiItem clusterPoiItemFromPlace = fromPlace(fetchPlaceResponse.getPlace());
        if (clusterPoiItemFromPlace != null) {
            list.add(clusterPoiItemFromPlace);
        }
        if (atomicInteger.decrementAndGet() == 0) {
            placesCallback.onResult(new ArrayList(list));
        }
    }

    static /* synthetic */ void lambda$searchPlacesAutocompleteFallback$8(AtomicInteger atomicInteger, PlacesCallback placesCallback, List list, Exception exc) {
        if (atomicInteger.decrementAndGet() == 0) {
            placesCallback.onResult(new ArrayList(list));
        }
    }

    static /* synthetic */ void lambda$searchPlacesAutocompleteFallback$10(PlacesCallback placesCallback, Exception exc) {
        Log.w(TAG, "autocomplete fallback failed", exc);
        placesCallback.onResult(new ArrayList());
    }

    private static NavV2Models.ClusterPoiItem fromPlace(Place place) {
        double d;
        double d2;
        if (place == null) {
            return null;
        }
        String id = place.getId() != null ? place.getId() : "";
        if (id.isEmpty()) {
            return null;
        }
        String name = place.getName() != null ? place.getName() : "";
        String address = place.getAddress() != null ? place.getAddress() : "";
        if (place.getLatLng() != null) {
            d = place.getLatLng().latitude;
            d2 = place.getLatLng().longitude;
        } else {
            d = 0.0d;
            d2 = 0.0d;
        }
        if (name.isEmpty() && d == 0.0d && d2 == 0.0d) {
            return null;
        }
        return new NavV2Models.ClusterPoiItem(id, name, address, d, d2);
    }

    private static PlacesClient client(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!Places.isInitialized()) {
                String apiKey = GmapUtil.getApiKey();
                if (apiKey != null && !apiKey.trim().isEmpty()) {
                    Places.initialize(context.getApplicationContext(), apiKey.trim());
                }
                return null;
            }
            if (placesClient == null) {
                placesClient = Places.createClient(context.getApplicationContext());
            }
            return placesClient;
        } catch (Exception e) {
            Log.w(TAG, "Places init failed", e);
            return null;
        }
    }

    private static String cacheKey(String str, double d, double d2, int i) {
        return str + "|" + String.format(Locale.US, "%.4f", Double.valueOf(d)) + "|" + String.format(Locale.US, "%.4f", Double.valueOf(d2)) + "|" + i;
    }

    private static String sourceTag(String str) {
        if (str != null && !str.isEmpty()) {
            if (str.startsWith("cluster")) {
                return "CLUSTER";
            }
            if (str.contains("tft")) {
                return "TFT";
            }
        }
        return "APP";
    }

    private static void logResults(String str, List<NavV2Models.ClusterPoiItem> list) {
        String strSourceTag = sourceTag(str);
        StringBuilder sb = new StringBuilder("[POI][");
        sb.append(strSourceTag);
        sb.append("] results count=");
        sb.append(list != null ? list.size() : 0);
        Log.i(TAG, sb.toString());
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            NavV2Models.ClusterPoiItem clusterPoiItem = list.get(i);
            StringBuilder sb2 = new StringBuilder("[POI][");
            sb2.append(strSourceTag);
            sb2.append("] #");
            sb2.append(i);
            sb2.append(" name=\"");
            sb2.append(clusterPoiItem.name);
            sb2.append("\" dist=");
            sb2.append(clusterPoiItem.distanceText.isEmpty() ? "?" : clusterPoiItem.distanceText);
            sb2.append(" @");
            sb2.append(clusterPoiItem.latitude);
            sb2.append(",");
            sb2.append(clusterPoiItem.longitude);
            Log.i(TAG, sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double crowFliesMeters(double d, double d2, double d3, double d4) {
        float[] fArr = new float[1];
        Location.distanceBetween(d, d2, d3, d4, fArr);
        return fArr[0];
    }
}
