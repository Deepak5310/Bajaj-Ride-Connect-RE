package com.mappls.sdk.nearby.plugin.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import com.mappls.sdk.nearby.plugin.MapplsNearbyWidget;
import com.mappls.sdk.nearby.plugin.model.NearbyUIOption;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.Place;
import com.mappls.sdk.services.api.PlaceResponse;
import com.mappls.sdk.services.api.nearby.MapplsNearby;
import com.mappls.sdk.services.api.nearby.MapplsNearbyManager;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCodeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends ViewModel {
    private NearbyUIOption c;
    private LatLng e;
    private String f;
    private MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<List<Place>>> a = new MutableLiveData<>();
    private MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<NearbyAtlasResponse>> b = new MutableLiveData<>();
    private List<? extends CategoryCode> d = MapplsNearbyWidget.INSTANCE.getCategoryList();
    private boolean g = true;

    public static final class a implements OnResponseCallback<PlaceResponse> {
        final /* synthetic */ LatLng b;

        a(LatLng latLng) {
            this.b = latLng;
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<List<Place>>> mutableLiveDataF;
            ArrayList arrayListArrayListOf;
            String str2;
            if (i == 0) {
                return;
            }
            if (i == 1) {
                Place place = new Place();
                place.setLat(Double.valueOf(this.b.getLatitude()));
                place.setLng(Double.valueOf(this.b.getLongitude()));
                place.setFormattedAddress("[" + this.b.getLatitude() + ", " + this.b.getLongitude() + ']');
                mutableLiveDataF = d.this.f();
                arrayListArrayListOf = CollectionsKt.arrayListOf(place);
                str2 = "No Internet Connection";
            } else if (i != 204) {
                Place place2 = new Place();
                place2.setLat(Double.valueOf(this.b.getLatitude()));
                place2.setLng(Double.valueOf(this.b.getLongitude()));
                place2.setFormattedAddress("[" + this.b.getLatitude() + ", " + this.b.getLongitude() + ']');
                mutableLiveDataF = d.this.f();
                arrayListArrayListOf = CollectionsKt.arrayListOf(place2);
                str2 = "Something went wrong";
            } else {
                Place place3 = new Place();
                place3.setLat(Double.valueOf(this.b.getLatitude()));
                place3.setLng(Double.valueOf(this.b.getLongitude()));
                place3.setFormattedAddress("[" + this.b.getLatitude() + ", " + this.b.getLongitude() + ']');
                mutableLiveDataF = d.this.f();
                arrayListArrayListOf = CollectionsKt.arrayListOf(place3);
                str2 = "No address Found";
            }
            mutableLiveDataF.setValue(com.mappls.sdk.nearby.plugin.util.d.a.a(str2, arrayListArrayListOf));
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(PlaceResponse placeResponse) {
            MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<List<Place>>> mutableLiveDataF;
            com.mappls.sdk.nearby.plugin.util.d<List<Place>> dVarA;
            PlaceResponse placeResponse2 = placeResponse;
            if ((placeResponse2 != null ? placeResponse2.getPlaces() : null) == null || placeResponse2.getPlaces().size() <= 0) {
                Place place = new Place();
                place.setLat(Double.valueOf(this.b.getLatitude()));
                place.setLng(Double.valueOf(this.b.getLongitude()));
                place.setFormattedAddress("[" + this.b.getLatitude() + ", " + this.b.getLongitude() + ']');
                mutableLiveDataF = d.this.f();
                dVarA = com.mappls.sdk.nearby.plugin.util.d.a.a("No address Found", CollectionsKt.arrayListOf(place));
            } else {
                mutableLiveDataF = d.this.f();
                dVarA = com.mappls.sdk.nearby.plugin.util.d.a.a(placeResponse2.getPlaces());
            }
            mutableLiveDataF.setValue(dVarA);
        }
    }

    public final List<CategoryCode> a() {
        return this.d;
    }

    public final void a(MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<NearbyAtlasResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.b = mutableLiveData;
    }

    public final void a(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        this.a.setValue(com.mappls.sdk.nearby.plugin.util.d.a.a());
        MapplsReverseGeoCodeManager.newInstance(MapplsReverseGeoCode.builder().setLocation(latLng.getLatitude(), latLng.getLongitude()).build()).call(new a(latLng));
    }

    public final void a(NearbyUIOption nearbyUIOption) {
        this.c = nearbyUIOption;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void a(ArrayList selectedCategory) {
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        this.b.setValue(com.mappls.sdk.nearby.plugin.util.d.a.a());
        MapplsNearby.Builder builder = MapplsNearby.builder();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = selectedCategory.iterator();
        while (it2.hasNext()) {
            List<String> categoryCode = ((CategoryCode) it2.next()).getCategoryCode();
            Intrinsics.checkNotNullExpressionValue(categoryCode, "it.categoryCode");
            arrayList.addAll(categoryCode);
        }
        MapplsNearby.Builder builderKeyword = builder.keyword(com.mappls.sdk.nearby.plugin.util.c.a(arrayList.toArray(new Object[0])));
        LatLng latLng = this.e;
        if (latLng != null) {
            Double dValueOf = Double.valueOf(latLng.getLatitude());
            LatLng latLng2 = this.e;
            builderKeyword.setLocation(dValueOf, latLng2 != null ? Double.valueOf(latLng2.getLongitude()) : null);
        } else {
            builderKeyword.setLocation(this.f);
        }
        MapplsNearbyWidget mapplsNearbyWidget = MapplsNearbyWidget.INSTANCE;
        builderKeyword.radius(mapplsNearbyWidget.getNearbyOption().radius());
        builderKeyword.bounds(mapplsNearbyWidget.getNearbyOption().bounds());
        builderKeyword.explain(mapplsNearbyWidget.getNearbyOption().explain());
        builderKeyword.filter(mapplsNearbyWidget.getNearbyOption().filter());
        builderKeyword.pod(mapplsNearbyWidget.getNearbyOption().pod());
        builderKeyword.richData(mapplsNearbyWidget.getNearbyOption().richData());
        builderKeyword.searchBy(mapplsNearbyWidget.getNearbyOption().searchBy());
        builderKeyword.sortBy(mapplsNearbyWidget.getNearbyOption().sortBy());
        builderKeyword.userName(mapplsNearbyWidget.getNearbyOption().userName());
        MapplsNearbyManager.newInstance(builderKeyword.build()).call(new c(this));
    }

    public final void a(List<? extends CategoryCode> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.d = list;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final LatLng b() {
        return this.e;
    }

    public final void b(LatLng latLng) {
        this.e = latLng;
    }

    public final String c() {
        return this.f;
    }

    public final MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<NearbyAtlasResponse>> d() {
        return this.b;
    }

    public final NearbyUIOption e() {
        return this.c;
    }

    public final MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<List<Place>>> f() {
        return this.a;
    }

    public final boolean g() {
        return this.g;
    }
}
