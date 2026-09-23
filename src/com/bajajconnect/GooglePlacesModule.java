package com.bajajconnect;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.NetworkRequestImpl;
import com.bajajconnect.wifi.navv2.GooglePlacesClusterService;
import com.bajajconnect.wifi.navv2.NavV2Models;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import com.spotify.android.appremote.internal.SdkRemoteClientConnector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class GooglePlacesModule extends ReactContextBaseJavaModule {
    private static final String TAG = "GooglePlacesModule";
    private PlacesClient placesClient;
    private AutocompleteSessionToken sessionToken;

    GooglePlacesModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private void prepareNetworkForPlaces() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext == null) {
            return;
        }
        if (MirroringGlobarVar.isWifiConnected) {
            NetworkRequestImpl.bindCellularForRouting(reactApplicationContext, false);
        } else {
            NetworkRequestImpl.restoreDefaultNetwork(reactApplicationContext);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    private String nearbyTypeToAutocompleteQuery(String str) {
        if (str == null || str.length() == 0) {
            return StringUtils.SPACE;
        }
        str.hashCode();
        switch (str) {
            case "restaurant":
                return "restaurant food dining";
            case "tourist_attraction":
                return "tourist attraction museum park monument";
            case "cafe":
                return "cafe coffee tea";
            case "gas_station":
                return "petrol pump fuel gas station";
            default:
                return str.replace('_', ' ');
        }
    }

    private static boolean supportsAutocompleteTypeFilter(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "restaurant":
            case "tourist_attraction":
            case "cafe":
            case "gas_station":
                return true;
            default:
                return false;
        }
    }

    private void nearbySearchFetchPlacesFromPredictions(PlacesClient placesClient, List<AutocompletePrediction> list, AutocompleteSessionToken autocompleteSessionToken, final Promise promise) {
        if (list == null || list.isEmpty()) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    promise.resolve(Arguments.createArray());
                }
            });
            return;
        }
        int iMin = Math.min(list.size(), 40);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iMin; i++) {
            String placeId = list.get(i).getPlaceId();
            if (!TextUtils.isEmpty(placeId)) {
                arrayList.add(placeId);
            }
        }
        if (arrayList.isEmpty()) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    promise.resolve(Arguments.createArray());
                }
            });
            return;
        }
        final int size = arrayList.size();
        final WritableMap[] writableMapArr = new WritableMap[size];
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        List listAsList = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS, Place.Field.TYPES);
        int i2 = 0;
        while (i2 < size) {
            final int i3 = i2;
            placesClient.fetchPlace(FetchPlaceRequest.builder((String) arrayList.get(i2), listAsList).setSessionToken(autocompleteSessionToken).build()).addOnCompleteListener(new OnCompleteListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda15
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    GooglePlacesModule.lambda$nearbySearchFetchPlacesFromPredictions$3(writableMapArr, i3, atomicInteger, size, promise, task);
                }
            });
            i2++;
            arrayList = arrayList;
        }
    }

    static /* synthetic */ void lambda$nearbySearchFetchPlacesFromPredictions$3(WritableMap[] writableMapArr, int i, AtomicInteger atomicInteger, int i2, final Promise promise, Task task) {
        try {
            if (task.isSuccessful() && task.getResult() != null) {
                Place place = ((FetchPlaceResponse) task.getResult()).getPlace();
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("placeId", place.getId());
                writableMapCreateMap.putString("placeName", place.getName() != null ? place.getName() : "");
                writableMapCreateMap.putString("placeAddress", placeDisplayAddress(place));
                if (place.getLatLng() != null) {
                    writableMapCreateMap.putDouble("latitude", place.getLatLng().latitude);
                    writableMapCreateMap.putDouble("longitude", place.getLatLng().longitude);
                } else {
                    writableMapCreateMap.putDouble("latitude", 0.0d);
                    writableMapCreateMap.putDouble("longitude", 0.0d);
                }
                try {
                    List<Place.Type> types = place.getTypes();
                    if (types != null) {
                        WritableArray writableArrayCreateArray = Arguments.createArray();
                        Iterator<Place.Type> it2 = types.iterator();
                        while (it2.hasNext()) {
                            writableArrayCreateArray.pushString(it2.next().toString());
                        }
                        writableMapCreateMap.putArray("types", writableArrayCreateArray);
                    }
                } catch (Exception unused) {
                }
                writableMapArr[i] = writableMapCreateMap;
            }
        } catch (Exception e) {
            Log.w(TAG, "nearbySearch fetchPlace", e);
        }
        if (atomicInteger.incrementAndGet() == i2) {
            final WritableArray writableArrayCreateArray2 = Arguments.createArray();
            for (int i3 = 0; i3 < i2; i3++) {
                WritableMap writableMap = writableMapArr[i3];
                if (writableMap != null) {
                    writableArrayCreateArray2.pushMap(writableMap);
                }
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    promise.resolve(writableArrayCreateArray2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005e  */
    private void nearbySearchPredictThenFetch(final PlacesClient placesClient, final RectangularBounds rectangularBounds, final String str, final int i, final Promise promise) {
        boolean zSupportsAutocompleteTypeFilter;
        final boolean z;
        if (i > 3) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    promise.resolve(Arguments.createArray());
                }
            });
            return;
        }
        final AutocompleteSessionToken autocompleteSessionTokenNewInstance = AutocompleteSessionToken.newInstance();
        FindAutocompletePredictionsRequest.Builder country = FindAutocompletePredictionsRequest.builder().setSessionToken(autocompleteSessionTokenNewInstance).setLocationBias(rectangularBounds).setCountry(null);
        String strNearbyTypeToAutocompleteQuery = StringUtils.SPACE;
        if (i == 0) {
            zSupportsAutocompleteTypeFilter = supportsAutocompleteTypeFilter(str);
        } else {
            if (i == 1) {
                zSupportsAutocompleteTypeFilter = supportsAutocompleteTypeFilter(str);
                if (str != null && str.length() > 0) {
                    strNearbyTypeToAutocompleteQuery = nearbyTypeToAutocompleteQuery(str);
                }
            } else {
                z = false;
                if (i == 2 && str != null && str.length() > 0) {
                    strNearbyTypeToAutocompleteQuery = nearbyTypeToAutocompleteQuery(str);
                }
            }
            if (z) {
                country.setTypesFilter(Collections.singletonList(str));
            }
            country.setQuery(strNearbyTypeToAutocompleteQuery);
            final int i2 = i + 1;
            placesClient.findAutocompletePredictions(country.build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda9
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$nearbySearchPredictThenFetch$5(i, z, placesClient, autocompleteSessionTokenNewInstance, promise, rectangularBounds, str, i2, (FindAutocompletePredictionsResponse) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda10
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$nearbySearchPredictThenFetch$6(i, placesClient, rectangularBounds, str, i2, promise, exc);
                }
            });
        }
        z = zSupportsAutocompleteTypeFilter;
        if (z) {
            country.setTypesFilter(Collections.singletonList(str));
        }
        country.setQuery(strNearbyTypeToAutocompleteQuery);
        final int i3 = i + 1;
        placesClient.findAutocompletePredictions(country.build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda9
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$nearbySearchPredictThenFetch$5(i, z, placesClient, autocompleteSessionTokenNewInstance, promise, rectangularBounds, str, i3, (FindAutocompletePredictionsResponse) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f$0.lambda$nearbySearchPredictThenFetch$6(i, placesClient, rectangularBounds, str, i3, promise, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nearbySearchPredictThenFetch$5(int i, boolean z, PlacesClient placesClient, AutocompleteSessionToken autocompleteSessionToken, Promise promise, RectangularBounds rectangularBounds, String str, int i2, FindAutocompletePredictionsResponse findAutocompletePredictionsResponse) {
        List<AutocompletePrediction> autocompletePredictions = findAutocompletePredictionsResponse.getAutocompletePredictions();
        int size = autocompletePredictions == null ? 0 : autocompletePredictions.size();
        Log.d(TAG, "nearbySearch attempt=" + i + " preds=" + size + " typeFilter=" + z);
        if (size > 0) {
            nearbySearchFetchPlacesFromPredictions(placesClient, autocompletePredictions, autocompleteSessionToken, promise);
        } else {
            nearbySearchPredictThenFetch(placesClient, rectangularBounds, str, i2, promise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nearbySearchPredictThenFetch$6(int i, PlacesClient placesClient, RectangularBounds rectangularBounds, String str, int i2, Promise promise, Exception exc) {
        Log.w(TAG, "nearbySearch attempt=" + i + " failed", exc);
        nearbySearchPredictThenFetch(placesClient, rectangularBounds, str, i2, promise);
    }

    private static String placeDisplayAddress(Place place) {
        if (place == null) {
            return "";
        }
        try {
            String address = place.getAddress();
            return !TextUtils.isEmpty(address) ? address : "";
        } catch (Exception unused) {
        }
    }

    private PlacesClient getClient() {
        if (this.placesClient == null) {
            if (!Places.isInitialized()) {
                Places.initialize(getReactApplicationContext(), getApiKey());
            }
            this.placesClient = Places.createClient(getReactApplicationContext());
        }
        return this.placesClient;
    }

    private String getApiKey() {
        String string;
        try {
            ApplicationInfo applicationInfo = getReactApplicationContext().getPackageManager().getApplicationInfo(getReactApplicationContext().getPackageName(), 128);
            return (applicationInfo.metaData == null || (string = applicationInfo.metaData.getString("com.google.android.geo.API_KEY")) == null) ? "" : string;
        } catch (Exception e) {
            Log.e(TAG, "getApiKey error", e);
            return "";
        }
    }

    @ReactMethod
    public void autocomplete(String str, double d, double d2, final Promise promise) {
        if (TextUtils.isEmpty(str)) {
            promise.resolve(Arguments.createArray());
            return;
        }
        prepareNetworkForPlaces();
        try {
            PlacesClient client = getClient();
            if (this.sessionToken == null) {
                this.sessionToken = AutocompleteSessionToken.newInstance();
            }
            FindAutocompletePredictionsRequest.Builder sessionToken = FindAutocompletePredictionsRequest.builder().setQuery(str).setSessionToken(this.sessionToken);
            if (d != 0.0d && d2 != 0.0d) {
                sessionToken.setLocationBias(RectangularBounds.newInstance(new LatLng(d - 0.5d, d2 - 0.5d), new LatLng(d + 0.5d, d2 + 0.5d)));
            }
            client.findAutocompletePredictions(sessionToken.build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    GooglePlacesModule.lambda$autocomplete$7(promise, (FindAutocompletePredictionsResponse) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GooglePlacesModule.lambda$autocomplete$8(promise, exc);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "autocomplete exception", e);
            promise.reject("PLACES_EXCEPTION", e.getMessage(), e);
        }
    }

    static /* synthetic */ void lambda$autocomplete$7(Promise promise, FindAutocompletePredictionsResponse findAutocompletePredictionsResponse) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (AutocompletePrediction autocompletePrediction : findAutocompletePredictionsResponse.getAutocompletePredictions()) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("placeId", autocompletePrediction.getPlaceId());
            writableMapCreateMap.putString("placeName", autocompletePrediction.getPrimaryText(null).toString());
            writableMapCreateMap.putString("placeAddress", autocompletePrediction.getSecondaryText(null).toString());
            writableArrayCreateArray.pushMap(writableMapCreateMap);
        }
        Log.d(TAG, "autocomplete returned " + writableArrayCreateArray.size() + " results");
        promise.resolve(writableArrayCreateArray);
    }

    static /* synthetic */ void lambda$autocomplete$8(Promise promise, Exception exc) {
        Log.e(TAG, "autocomplete error", exc);
        promise.reject("PLACES_ERROR", exc.getMessage(), exc);
    }

    @ReactMethod
    public void textSearch(String str, double d, double d2, final Promise promise) {
        if (TextUtils.isEmpty(str)) {
            promise.resolve(Arguments.createArray());
            return;
        }
        prepareNetworkForPlaces();
        try {
            PlacesClient client = getClient();
            SearchByTextRequest.Builder maxResultCount = SearchByTextRequest.builder(str, Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG)).setMaxResultCount(20);
            if (d != 0.0d && d2 != 0.0d) {
                maxResultCount.setLocationBias(CircularBounds.newInstance(new LatLng(d, d2), 50000.0d));
            }
            client.searchByText(maxResultCount.build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda6
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$textSearch$9(promise, (SearchByTextResponse) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda7
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GooglePlacesModule.lambda$textSearch$10(promise, exc);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "textSearch exception", e);
            promise.reject("PLACES_TEXT_SEARCH_EXCEPTION", e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$textSearch$9(Promise promise, SearchByTextResponse searchByTextResponse) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        List<Place> places = searchByTextResponse.getPlaces();
        if (places != null) {
            Iterator<Place> it2 = places.iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray.pushMap(placeToWritableMap(it2.next()));
            }
        }
        Log.d(TAG, "textSearch returned " + writableArrayCreateArray.size() + " results");
        promise.resolve(writableArrayCreateArray);
    }

    static /* synthetic */ void lambda$textSearch$10(Promise promise, Exception exc) {
        Log.e(TAG, "textSearch error", exc);
        promise.reject("PLACES_TEXT_SEARCH_ERROR", exc.getMessage(), exc);
    }

    @ReactMethod
    public void getPlaceDetails(String str, final Promise promise) {
        if (TextUtils.isEmpty(str)) {
            promise.reject("INVALID_PLACE_ID", "placeId is empty");
            return;
        }
        prepareNetworkForPlaces();
        try {
            PlacesClient client = getClient();
            FetchPlaceRequest fetchPlaceRequestBuild = FetchPlaceRequest.builder(str, Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS)).setSessionToken(this.sessionToken).build();
            this.sessionToken = null;
            client.fetchPlace(fetchPlaceRequestBuild).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda17
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    GooglePlacesModule.lambda$getPlaceDetails$11(promise, (FetchPlaceResponse) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GooglePlacesModule.lambda$getPlaceDetails$12(promise, exc);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "placeDetails exception", e);
            promise.reject("PLACES_EXCEPTION", e.getMessage(), e);
        }
    }

    static /* synthetic */ void lambda$getPlaceDetails$11(Promise promise, FetchPlaceResponse fetchPlaceResponse) {
        Place place = fetchPlaceResponse.getPlace();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("placeId", place.getId());
        writableMapCreateMap.putString("placeName", place.getName() != null ? place.getName() : "");
        writableMapCreateMap.putString("placeAddress", placeDisplayAddress(place));
        if (place.getLatLng() != null) {
            writableMapCreateMap.putDouble("latitude", place.getLatLng().latitude);
            writableMapCreateMap.putDouble("longitude", place.getLatLng().longitude);
        } else {
            writableMapCreateMap.putDouble("latitude", 0.0d);
            writableMapCreateMap.putDouble("longitude", 0.0d);
        }
        StringBuilder sb = new StringBuilder("placeDetails: ");
        sb.append(place.getName());
        sb.append(" @ ");
        sb.append(place.getLatLng() != null ? place.getLatLng().toString() : com.google.maps.android.BuildConfig.TRAVIS);
        Log.d(TAG, sb.toString());
        promise.resolve(writableMapCreateMap);
    }

    static /* synthetic */ void lambda$getPlaceDetails$12(Promise promise, Exception exc) {
        Log.e(TAG, "placeDetails error", exc);
        promise.reject("PLACES_ERROR", exc.getMessage(), exc);
    }

    @ReactMethod
    public void findCurrentPlace(final Promise promise) {
        try {
            if (ContextCompat.checkSelfPermission(getReactApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
                promise.reject("NO_LOCATION_PERMISSION", "ACCESS_FINE_LOCATION required");
            } else {
                prepareNetworkForPlaces();
                getClient().findCurrentPlace(FindCurrentPlaceRequest.newInstance(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS, Place.Field.TYPES))).addOnSuccessListener(new OnSuccessListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda11
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        GooglePlacesModule.lambda$findCurrentPlace$13(promise, (FindCurrentPlaceResponse) obj);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda12
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        promise.reject("PLACES_ERROR", exc.getMessage(), exc);
                    }
                });
            }
        } catch (Exception e) {
            promise.reject("PLACES_EXCEPTION", e.getMessage(), e);
        }
    }

    static /* synthetic */ void lambda$findCurrentPlace$13(Promise promise, FindCurrentPlaceResponse findCurrentPlaceResponse) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<PlaceLikelihood> it2 = findCurrentPlaceResponse.getPlaceLikelihoods().iterator();
        while (it2.hasNext()) {
            Place place = it2.next().getPlace();
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("placeId", place.getId());
            writableMapCreateMap.putString("placeName", place.getName() != null ? place.getName() : "");
            writableMapCreateMap.putString("placeAddress", placeDisplayAddress(place));
            if (place.getLatLng() != null) {
                writableMapCreateMap.putDouble("latitude", place.getLatLng().latitude);
                writableMapCreateMap.putDouble("longitude", place.getLatLng().longitude);
            } else {
                writableMapCreateMap.putDouble("latitude", 0.0d);
                writableMapCreateMap.putDouble("longitude", 0.0d);
            }
            try {
                List<Place.Type> types = place.getTypes();
                if (types != null) {
                    WritableArray writableArrayCreateArray2 = Arguments.createArray();
                    Iterator<Place.Type> it3 = types.iterator();
                    while (it3.hasNext()) {
                        writableArrayCreateArray2.pushString(it3.next().toString());
                    }
                    writableMapCreateMap.putArray("types", writableArrayCreateArray2);
                }
            } catch (Exception unused) {
            }
            writableArrayCreateArray.pushMap(writableMapCreateMap);
        }
        promise.resolve(writableArrayCreateArray);
    }

    private WritableMap placeToWritableMap(Place place) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("placeId", place.getId() != null ? place.getId() : "");
        writableMapCreateMap.putString("placeName", place.getName() != null ? place.getName() : "");
        writableMapCreateMap.putString("placeAddress", placeDisplayAddress(place));
        if (place.getLatLng() != null) {
            writableMapCreateMap.putDouble("latitude", place.getLatLng().latitude);
            writableMapCreateMap.putDouble("longitude", place.getLatLng().longitude);
        } else {
            writableMapCreateMap.putDouble("latitude", 0.0d);
            writableMapCreateMap.putDouble("longitude", 0.0d);
        }
        try {
            List<Place.Type> types = place.getTypes();
            if (types != null) {
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Iterator<Place.Type> it2 = types.iterator();
                while (it2.hasNext()) {
                    writableArrayCreateArray.pushString(it2.next().toString());
                }
                writableMapCreateMap.putArray("types", writableArrayCreateArray);
            }
        } catch (Exception unused) {
        }
        return writableMapCreateMap;
    }

    @ReactMethod
    public void nearbySearch(double d, double d2, int i, String str, final Promise promise) {
        try {
            if (ContextCompat.checkSelfPermission(getReactApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
                promise.reject("NO_LOCATION_PERMISSION", "ACCESS_FINE_LOCATION required");
                return;
            }
            prepareNetworkForPlaces();
            GooglePlacesClusterService.fetchNearbyPois(getReactApplicationContext(), d, d2, str == null ? "" : str, i > 0 ? i : 8000, 5, SdkRemoteClientConnector.CATEGORY, new GooglePlacesClusterService.PlacesCallback() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda4
                @Override // com.bajajconnect.wifi.navv2.GooglePlacesClusterService.PlacesCallback
                public final void onResult(List list) {
                    GooglePlacesModule.lambda$nearbySearch$16(promise, list);
                }
            });
        } catch (Throwable th) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    Promise promise2 = promise;
                    Throwable th2 = th;
                    promise2.reject("PLACES_EXCEPTION", th2.getMessage(), th2);
                }
            });
        }
    }

    static /* synthetic */ void lambda$nearbySearch$16(final Promise promise, List list) {
        final WritableArray writableArrayCreateArray = Arguments.createArray();
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                NavV2Models.ClusterPoiItem clusterPoiItem = (NavV2Models.ClusterPoiItem) it2.next();
                if (clusterPoiItem != null) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putString("placeId", clusterPoiItem.placeId);
                    writableMapCreateMap.putString("placeName", clusterPoiItem.name);
                    writableMapCreateMap.putString("name", clusterPoiItem.name);
                    writableMapCreateMap.putString("placeAddress", clusterPoiItem.address);
                    writableMapCreateMap.putString(PlaceTypes.ADDRESS, clusterPoiItem.address);
                    writableMapCreateMap.putDouble("latitude", clusterPoiItem.latitude);
                    writableMapCreateMap.putDouble("longitude", clusterPoiItem.longitude);
                    if (clusterPoiItem.hasRouteDistance()) {
                        writableMapCreateMap.putInt("distanceMeters", clusterPoiItem.distanceMeters);
                    }
                    if (clusterPoiItem.distanceText != null && !clusterPoiItem.distanceText.isEmpty()) {
                        writableMapCreateMap.putString("distanceText", clusterPoiItem.distanceText);
                    }
                    writableArrayCreateArray.pushMap(writableMapCreateMap);
                }
            }
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.bajajconnect.GooglePlacesModule$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                promise.resolve(writableArrayCreateArray);
            }
        });
    }
}
