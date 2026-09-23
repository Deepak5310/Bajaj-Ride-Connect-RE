package com.mappls.sdk.category.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mappls.sdk.category.model.SearchCategoryOption;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import com.mappls.sdk.category.utils.c;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute;
import com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRouteManager;
import com.mappls.sdk.services.api.alongroute.models.POIAlongRouteResponse;
import com.mappls.sdk.services.api.nearby.MapplsNearby;
import com.mappls.sdk.services.api.nearby.MapplsNearbyManager;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends ViewModel {
    private List<? extends CategoryCode> a = CollectionsKt.emptyList();
    private LinkedHashMap b = new LinkedHashMap();
    private SearchCategoryOption c = com.mappls.sdk.category.a.c();
    private SearchCategoryUIOption d;
    private MutableLiveData<c<POIAlongRouteResponse>> e;
    private MutableLiveData<c<NearbyAtlasResponse>> f;

    /* JADX INFO: renamed from: com.mappls.sdk.category.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0069a implements OnResponseCallback<NearbyAtlasResponse> {
        C0069a() {
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            MutableLiveData<c<NearbyAtlasResponse>> mutableLiveDataC;
            c<NearbyAtlasResponse> cVarA;
            if (i == 204) {
                mutableLiveDataC = a.this.c();
                cVarA = c.a.a((Object) null);
            } else if (101 <= i && i < 401) {
                mutableLiveDataC = a.this.c();
                if (str == null) {
                    str = "Something Went wrong";
                }
                cVarA = c.a.a(str);
            } else {
                if (i == 0) {
                    return;
                }
                mutableLiveDataC = a.this.c();
                cVarA = c.a.a("Something Went wrong");
            }
            mutableLiveDataC.setValue(cVarA);
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(NearbyAtlasResponse nearbyAtlasResponse) {
            a.this.c().setValue(c.a.a(nearbyAtlasResponse));
        }
    }

    public static final class b implements OnResponseCallback<POIAlongRouteResponse> {
        b() {
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            MutableLiveData<c<POIAlongRouteResponse>> mutableLiveDataA;
            c<POIAlongRouteResponse> cVarA;
            if (i == 204) {
                mutableLiveDataA = a.this.a();
                cVarA = c.a.a((Object) null);
            } else if (101 <= i && i < 401) {
                mutableLiveDataA = a.this.a();
                if (str == null) {
                    str = "Something Went wrong";
                }
                cVarA = c.a.a(str);
            } else {
                if (i == 0) {
                    return;
                }
                mutableLiveDataA = a.this.a();
                cVarA = c.a.a("Something Went wrong");
            }
            mutableLiveDataA.setValue(cVarA);
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(POIAlongRouteResponse pOIAlongRouteResponse) {
            a.this.a().setValue(c.a.a(pOIAlongRouteResponse));
        }
    }

    public a() {
        SearchCategoryUIOption searchCategoryUIOptionBuild = SearchCategoryUIOption.builder().build();
        Intrinsics.checkNotNullExpressionValue(searchCategoryUIOptionBuild, "builder().build()");
        this.d = searchCategoryUIOptionBuild;
        this.e = new MutableLiveData<>();
        this.f = new MutableLiveData<>();
    }

    public final MutableLiveData<c<POIAlongRouteResponse>> a() {
        return this.e;
    }

    public final void a(SearchCategoryUIOption searchCategoryUIOption) {
        Intrinsics.checkNotNullParameter(searchCategoryUIOption, "<set-?>");
        this.d = searchCategoryUIOption;
    }

    public final void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public final void a(List<? extends CategoryCode> categoryCodes) {
        Intrinsics.checkNotNullParameter(categoryCodes, "categoryCodes");
        if (this.c.location() == null) {
            this.f.setValue(c.a.a("Location Not found"));
            return;
        }
        this.f.setValue(c.a.a());
        MapplsNearby.Builder builder = MapplsNearby.builder();
        String strLocation = this.c.location();
        Intrinsics.checkNotNull(strLocation);
        MapplsNearby.Builder builderExplain = builder.setLocation(strLocation).bounds(this.c.bounds()).explain(this.c.explain());
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = categoryCodes.iterator();
        while (it2.hasNext()) {
            List<String> categoryCode = ((CategoryCode) it2.next()).getCategoryCode();
            Intrinsics.checkNotNullExpressionValue(categoryCode, "it.categoryCode");
            arrayList.addAll(categoryCode);
        }
        MapplsNearbyManager.newInstance(builderExplain.keyword(com.mappls.sdk.category.utils.b.a(arrayList.toArray(new Object[0]))).filter(this.c.filter()).page(this.c.page()).pod(this.c.pod()).radius(this.c.radius()).richData(this.c.richData()).searchBy(this.c.searchBy()).sortBy(this.c.searchBy()).userName(this.c.userName()).build()).call(new C0069a());
    }

    public final LinkedHashMap b() {
        return this.b;
    }

    public final void b(List<? extends CategoryCode> categoryCodes) {
        Intrinsics.checkNotNullParameter(categoryCodes, "categoryCodes");
        if (this.c.path() == null) {
            this.e.setValue(c.a.a("Path Not found"));
            return;
        }
        this.e.setValue(c.a.a());
        MapplsPOIAlongRoute.Builder builder = MapplsPOIAlongRoute.builder();
        String strPath = this.c.path();
        Intrinsics.checkNotNull(strPath);
        MapplsPOIAlongRoute.Builder builderGeometries = builder.path(strPath).buffer(this.c.buffer()).geometries(this.c.geometries());
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = categoryCodes.iterator();
        while (it2.hasNext()) {
            List<String> categoryCode = ((CategoryCode) it2.next()).getCategoryCode();
            Intrinsics.checkNotNullExpressionValue(categoryCode, "it.categoryCode");
            arrayList.addAll(categoryCode);
        }
        MapplsPOIAlongRouteManager.newInstance(builderGeometries.category(com.mappls.sdk.category.utils.b.a(arrayList.toArray(new Object[0]))).sort(this.c.isSort()).page(this.c.page()).build()).call(new b());
    }

    public final MutableLiveData<c<NearbyAtlasResponse>> c() {
        return this.f;
    }

    public final SearchCategoryOption d() {
        return this.c;
    }

    public final SearchCategoryUIOption e() {
        return this.d;
    }

    public final List<CategoryCode> f() {
        return this.a;
    }
}
