package com.mappls.sdk.nearby.plugin.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import com.mappls.sdk.nearby.plugin.MapplsNearbyWidget;
import com.mappls.sdk.nearby.plugin.model.NearbyUIOption;
import com.mappls.sdk.services.api.nearby.MapplsNearby;
import com.mappls.sdk.services.api.nearby.MapplsNearbyManager;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends ViewModel {
    private ArrayList<CategoryCode> a;
    private MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<NearbyAtlasResponse>> b = new MutableLiveData<>();
    private int c = 1;
    private NearbyAtlasResponse d;
    private LatLng e;
    private String f;
    private NearbyUIOption g;

    public final int a() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<NearbyAtlasResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.b = mutableLiveData;
    }

    public final void a(LatLng latLng) {
        this.e = latLng;
    }

    public final void a(NearbyUIOption nearbyUIOption) {
        this.g = nearbyUIOption;
    }

    public final void a(NearbyAtlasResponse nearbyAtlasResponse) {
        this.d = nearbyAtlasResponse;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void a(ArrayList<CategoryCode> arrayList) {
        this.a = arrayList;
    }

    public final void a(ArrayList selectedCategory, int i) {
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
        builderKeyword.page(Integer.valueOf(i));
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
        MapplsNearbyManager.newInstance(builderKeyword.build()).call(new a(this));
    }

    public final NearbyAtlasResponse b() {
        return this.d;
    }

    public final MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<NearbyAtlasResponse>> c() {
        return this.b;
    }

    public final NearbyUIOption d() {
        return this.g;
    }

    public final LatLng e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final ArrayList<CategoryCode> g() {
        return this.a;
    }
}
