package com.mappls.sdk.plugins.places.autocomplete.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.plugins.places.autocomplete.data.SearchHistoryDatabase;
import com.mappls.sdk.plugins.places.autocomplete.model.MapplsFavoritePlace;
import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mappls.sdk.plugins.places.common.utils.d;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest;
import com.mappls.sdk.services.api.autosuggest.MapplsAutosuggestManager;
import com.mappls.sdk.services.api.autosuggest.model.AutoSuggestAtlasResponse;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.feedback.MapplsFeedback;
import com.mappls.sdk.services.api.feedback.MapplsFeedbackManager;
import com.mappls.sdk.services.api.textsearch.MapplsTextSearch;
import com.mappls.sdk.services.api.textsearch.MapplsTextSearchManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends AndroidViewModel implements OnResponseCallback<AutoSuggestAtlasResponse> {
    public final MutableLiveData<d<AutoSuggestAtlasResponse>> a;
    public final MutableLiveData<List<MapplsFavoritePlace>> b;
    private MapplsTextSearch.Builder c;
    private MapplsAutoSuggest.Builder d;
    private PlaceOptions e;
    private MapplsAutosuggestManager f;
    private ArrayList g;

    /* JADX INFO: renamed from: com.mappls.sdk.plugins.places.autocomplete.viewmodel.a$a, reason: collision with other inner class name */
    final class C0114a implements OnResponseCallback<Void> {
        C0114a() {
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final /* bridge */ /* synthetic */ void onSuccess(Void r1) {
        }
    }

    public static class b implements ViewModelProvider.Factory {
        private final Application a;
        private final PlaceOptions b;

        public b(Application application, PlaceOptions placeOptions) {
            this.a = application;
            this.b = placeOptions;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> cls) {
            return new a(this.a, this.b);
        }
    }

    a(Application application, PlaceOptions placeOptions) {
        super(application);
        this.e = placeOptions;
        this.a = new MutableLiveData<>();
        this.b = new MutableLiveData<>();
    }

    public final void a() {
        this.d = MapplsAutoSuggest.builder();
        this.c = MapplsTextSearch.builder();
        Point pointLocation = this.e.location();
        if (pointLocation != null) {
            this.d.setLocation(Double.valueOf(pointLocation.latitude()), Double.valueOf(pointLocation.longitude()));
            this.c.setLocation(Double.valueOf(pointLocation.latitude()), Double.valueOf(pointLocation.longitude()));
        }
        String strFilter = this.e.filter();
        if (strFilter != null) {
            this.d.filter(strFilter);
        }
        String strPod = this.e.pod();
        if (strPod != null) {
            this.d.pod(strPod);
        }
        Boolean bool = this.e.tokenizeAddress();
        if (bool != null) {
            this.d.tokenizeAddress(bool);
        }
        Boolean boolHyperLocal = this.e.hyperLocal();
        if (boolHyperLocal != null) {
            this.d.hyperLocal(boolHyperLocal);
        }
        Boolean boolBridge = this.e.bridge();
        if (boolBridge != null) {
            this.d.bridge(boolBridge);
            this.c.bridge(boolBridge);
        }
        if (this.e.responseLang() != null) {
            this.d.responseLang(this.e.responseLang());
        }
        Double dZoom = this.e.zoom();
        if (dZoom != null) {
            this.d.zoom(dZoom);
        }
    }

    public final void a(ELocation eLocation) {
        if (this.e.saveHistory().booleanValue()) {
            com.mappls.sdk.plugins.places.autocomplete.a.a(d()).a(new com.mappls.sdk.plugins.places.autocomplete.data.entity.a(eLocation.getMapplsPin(), eLocation, eLocation.placeName, eLocation.placeAddress, eLocation.alternateName, System.currentTimeMillis()));
        }
    }

    public final void a(ELocation eLocation, String str) {
        MapplsFeedback.Builder builderLocationName = MapplsFeedback.builder().baseUrl(this.e.feedbackBaseUrl()).mapplsPin(eLocation.mapplsPin).index(Integer.valueOf((int) eLocation.orderIndex)).userName("AUTOCOMPLETE_USER").appVersion("2.4.0").typedKeyword(str).locationName(eLocation.placeName);
        if (this.e.location() != null) {
            builderLocationName.latitude(Double.valueOf(this.e.location().latitude()));
            builderLocationName.longitude(Double.valueOf(this.e.location().longitude()));
        }
        MapplsFeedbackManager.newInstance(builderLocationName.build()).call(new C0114a());
    }

    public final void a(CharSequence charSequence) {
        String string = charSequence.toString();
        if (string.isEmpty()) {
            return;
        }
        this.a.setValue(d.a());
        if (string.length() >= 45) {
            b(string);
            return;
        }
        MapplsAutoSuggest.Builder builder = this.d;
        if (builder == null) {
            builder = MapplsAutoSuggest.builder();
            this.d = builder;
        }
        MapplsAutosuggestManager mapplsAutosuggestManagerNewInstance = MapplsAutosuggestManager.newInstance(builder.baseUrl(this.e.autoSuggestBaseUrl()).query(string).build());
        this.f = mapplsAutosuggestManagerNewInstance;
        mapplsAutosuggestManagerNewInstance.call(this);
    }

    public final void a(String str) {
        ArrayList arrayList = new ArrayList();
        for (MapplsFavoritePlace mapplsFavoritePlace : this.g) {
            if (mapplsFavoritePlace.getPlaceName().contains(str) || ((mapplsFavoritePlace.getPlaceAddress() != null && mapplsFavoritePlace.getPlaceAddress().toLowerCase().contains(str.toLowerCase())) || (mapplsFavoritePlace.getMapplsPin() != null && mapplsFavoritePlace.getMapplsPin().toLowerCase().contains(str.toLowerCase())))) {
                arrayList.add(mapplsFavoritePlace);
            }
        }
        this.b.postValue(arrayList);
    }

    public final void b() {
        MapplsAutosuggestManager mapplsAutosuggestManager = this.f;
        if (mapplsAutosuggestManager == null || !mapplsAutosuggestManager.isExecuted()) {
            return;
        }
        this.f.cancel();
    }

    public final void b(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.a.setValue(d.a());
        MapplsTextSearch.Builder builder = this.c;
        if (builder == null) {
            builder = MapplsTextSearch.builder();
            this.c = builder;
        }
        builder.baseUrl(this.e.textSearchBaseUrl()).query(str);
        MapplsTextSearchManager.newInstance(this.c.build()).call(this);
    }

    public final void c() {
        this.b.postValue(this.g);
    }

    public final SearchHistoryDatabase d() {
        return SearchHistoryDatabase.a(getApplication().getApplicationContext());
    }

    public final void e() {
        List<String> listInjectedPlaces = this.e.injectedPlaces();
        this.g = new ArrayList();
        if (listInjectedPlaces == null || listInjectedPlaces.isEmpty()) {
            return;
        }
        Iterator<String> it2 = listInjectedPlaces.iterator();
        while (it2.hasNext()) {
            this.g.add((MapplsFavoritePlace) new Gson().fromJson(it2.next(), MapplsFavoritePlace.class));
        }
    }

    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onError(int i, String str) {
        MutableLiveData<d<AutoSuggestAtlasResponse>> mutableLiveData;
        if (i == 0) {
            return;
        }
        if (i == 204) {
            mutableLiveData = this.a;
        } else {
            Timber.e(str, new Object[0]);
            mutableLiveData = this.a;
            str = "Something Went wrong";
        }
        mutableLiveData.setValue(d.a(str));
    }

    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onSuccess(AutoSuggestAtlasResponse autoSuggestAtlasResponse) {
        this.a.setValue(d.a(autoSuggestAtlasResponse));
    }
}
