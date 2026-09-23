package com.mappls.sdk.direction.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.mappls.sdk.category.IMapplsCategoryCallback;
import com.mappls.sdk.category.IMapplsPOICallback;
import com.mappls.sdk.category.MapplsCategorySearchFragment;
import com.mappls.sdk.category.model.PoiResult;
import com.mappls.sdk.category.model.SearchCategoryOption;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionLayoutBinding;
import com.mappls.sdk.direction.ui.fragment.RouteSummaryBottomSheetFragment;
import com.mappls.sdk.direction.ui.fragment.g;
import com.mappls.sdk.direction.ui.fragment.h;
import com.mappls.sdk.direction.ui.fragment.i;
import com.mappls.sdk.direction.ui.fragment.n;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.direction.ui.model.DirectionPoint;
import com.mappls.sdk.direction.ui.plugin.l;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.MapplsMapOptions;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import com.mappls.sdk.services.api.event.route.model.RouteReport;
import com.mappls.sdk.services.api.event.route.model.RouteReportSummaryResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public class DirectionFragment extends Fragment implements OnMapReadyCallback, h, n.d {
    private MapplsDirectionLayoutBinding binding;
    private List<CategoryCode> categoryCodes;
    private com.mappls.sdk.direction.ui.plugin.f directionPolylinePlugin;
    private boolean isMapInitialised;
    public DirectionCallback mCallback;
    private Context mContext;
    private POISearchCallback mPoiSearchCallback;
    private com.mappls.sdk.direction.ui.b mViewModel;
    private l mapEventsPlugin;
    private MapView mapView;
    private DirectionOptions options;

    final class a implements com.mappls.sdk.direction.ui.fragment.d.InterfaceC0073d {
        a() {
        }

        @Override // com.mappls.sdk.direction.ui.fragment.d.InterfaceC0073d
        public final void a(CostEstimationResponse costEstimationResponse) {
            if (DirectionFragment.this.isAdded()) {
                com.mappls.sdk.direction.ui.fragment.l lVar = (com.mappls.sdk.direction.ui.fragment.l) DirectionFragment.this.getChildFragmentManager().findFragmentByTag(com.mappls.sdk.direction.ui.fragment.l.class.getName());
                if (lVar != null) {
                    lVar.a(costEstimationResponse);
                }
                n nVar = (n) DirectionFragment.this.getChildFragmentManager().findFragmentByTag(n.class.getName());
                if (nVar != null) {
                    nVar.a(costEstimationResponse);
                    return;
                }
                n nVarA = n.a(costEstimationResponse, DirectionFragment.this.mViewModel.h, DirectionFragment.this.mViewModel.g, DirectionFragment.this.mViewModel.a);
                nVarA.a(DirectionFragment.this);
                DirectionFragment.this.replaceFragment(nVarA, true);
            }
        }
    }

    final class b implements Style.OnStyleLoaded {
        final /* synthetic */ MapplsMap a;

        final class a implements com.mappls.sdk.direction.ui.plugin.f.o {
            a() {
            }

            @Override // com.mappls.sdk.direction.ui.plugin.f.o
            public final void a(int i, DirectionsRoute directionsRoute) {
                com.mappls.sdk.direction.ui.fragment.l lVar;
                if (!DirectionFragment.this.isAdded() || (lVar = (com.mappls.sdk.direction.ui.fragment.l) DirectionFragment.this.getChildFragmentManager().findFragmentByTag(com.mappls.sdk.direction.ui.fragment.l.class.getName())) == null) {
                    return;
                }
                lVar.a(i, directionsRoute);
            }
        }

        b(MapplsMap mapplsMap) {
            this.a = mapplsMap;
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            DirectionFragment directionFragment = DirectionFragment.this;
            directionFragment.directionPolylinePlugin = new com.mappls.sdk.direction.ui.plugin.f(directionFragment.mapView, this.a, DirectionFragment.this.options);
            DirectionFragment.this.directionPolylinePlugin.a(DirectionFragment.this.options.profile());
            DirectionFragment.this.directionPolylinePlugin.a(new a());
            if (DirectionFragment.this.mViewModel.f != null) {
                DirectionFragment.this.directionPolylinePlugin.a(DirectionFragment.this.mViewModel.c, DirectionFragment.this.mViewModel.d, DirectionFragment.this.mViewModel.e, DirectionFragment.this.mViewModel.f, DirectionFragment.this.mViewModel.g);
            }
            if (DirectionFragment.this.options.showRouteReportSummaryOnMap().booleanValue()) {
                DirectionFragment directionFragment2 = DirectionFragment.this;
                directionFragment2.mapEventsPlugin = new l(directionFragment2.mapView, this.a);
            }
        }
    }

    final class c implements IMapplsPOICallback {
        c() {
        }

        @Override // com.mappls.sdk.category.IMapplsPOICallback
        public final void getPOIResultListener(List<PoiResult> list) {
            if (DirectionFragment.this.mPoiSearchCallback != null) {
                DirectionFragment.this.mPoiSearchCallback.getPoiSearchResults(list);
            }
        }
    }

    final class d implements IMapplsCategoryCallback {

        final class a implements com.mappls.sdk.direction.ui.fragment.a.InterfaceC0071a {
            a() {
            }

            @Override // com.mappls.sdk.direction.ui.fragment.a.InterfaceC0071a
            public final void a(PoiResult poiResult) {
                com.mappls.sdk.direction.ui.fragment.l lVar;
                DirectionFragment.this.getChildFragmentManager().popBackStack(com.mappls.sdk.direction.ui.fragment.a.class.getName(), 1);
                if (!DirectionFragment.this.isAdded() || (lVar = (com.mappls.sdk.direction.ui.fragment.l) DirectionFragment.this.getChildFragmentManager().findFragmentByTag(com.mappls.sdk.direction.ui.fragment.l.class.getName())) == null) {
                    return;
                }
                lVar.a(poiResult);
            }

            @Override // com.mappls.sdk.direction.ui.fragment.a.InterfaceC0071a
            public final void onCancel() {
                DirectionFragment.this.getChildFragmentManager().popBackStack(com.mappls.sdk.direction.ui.fragment.a.class.getName(), 1);
            }
        }

        d() {
        }

        @Override // com.mappls.sdk.category.IMapplsCategoryCallback
        public final void onCancel() {
            DirectionFragment.this.getChildFragmentManager().popBackStack(MapplsCategorySearchFragment.class.getName(), 1);
        }

        @Override // com.mappls.sdk.category.IMapplsCategoryCallback
        public final void onCategorySelected(PoiResult data) {
            DirectionFragment.this.getChildFragmentManager().popBackStack(MapplsCategorySearchFragment.class.getName(), 1);
            int i = com.mappls.sdk.direction.ui.fragment.a.g;
            Intrinsics.checkNotNullParameter(data, "data");
            com.mappls.sdk.direction.ui.fragment.a aVar = new com.mappls.sdk.direction.ui.fragment.a();
            Bundle bundle = new Bundle();
            bundle.putString("arg_search_data", new Gson().toJson(data));
            aVar.setArguments(bundle);
            aVar.a(new a());
            DirectionFragment.this.replaceFragment(aVar, true);
            aVar.a(DirectionFragment.this.mapView);
        }
    }

    final class e implements g {
        final /* synthetic */ DirectionsResponse a;

        e(DirectionsResponse directionsResponse) {
            this.a = directionsResponse;
        }

        @Override // com.mappls.sdk.direction.ui.fragment.g
        public final void a(int i) {
            com.mappls.sdk.direction.ui.fragment.l lVar;
            if (DirectionFragment.this.isAdded() && (lVar = (com.mappls.sdk.direction.ui.fragment.l) DirectionFragment.this.getChildFragmentManager().findFragmentByTag(com.mappls.sdk.direction.ui.fragment.l.class.getName())) != null) {
                lVar.a(i, this.a.routes().get(i));
            }
            if (DirectionFragment.this.directionPolylinePlugin != null) {
                DirectionFragment.this.directionPolylinePlugin.a(i);
            }
        }

        @Override // com.mappls.sdk.direction.ui.fragment.g
        public final void a(String str, ArrayList<ReportDetails> arrayList) {
            DirectionFragment.this.replaceFragment(new i(str, arrayList), true);
        }
    }

    final class f implements com.mappls.sdk.direction.ui.fragment.d.InterfaceC0073d {
        final /* synthetic */ DirectionsResponse a;
        final /* synthetic */ int b;

        f(DirectionsResponse directionsResponse, int i) {
            this.a = directionsResponse;
            this.b = i;
        }

        @Override // com.mappls.sdk.direction.ui.fragment.d.InterfaceC0073d
        public final void a(CostEstimationResponse costEstimationResponse) {
            if (DirectionFragment.this.isAdded()) {
                com.mappls.sdk.direction.ui.fragment.l lVar = (com.mappls.sdk.direction.ui.fragment.l) DirectionFragment.this.getChildFragmentManager().findFragmentByTag(com.mappls.sdk.direction.ui.fragment.l.class.getName());
                if (lVar != null) {
                    lVar.a(costEstimationResponse);
                }
                n nVar = (n) DirectionFragment.this.getChildFragmentManager().findFragmentByTag(n.class.getName());
                if (nVar != null) {
                    nVar.a(costEstimationResponse);
                    return;
                }
                n nVarA = n.a(costEstimationResponse, this.a, this.b, DirectionFragment.this.mViewModel.a);
                nVarA.a(DirectionFragment.this);
                DirectionFragment.this.replaceFragment(nVarA, true);
            }
        }
    }

    private void callFuelCostFragment(CostEstimationResponse costEstimationResponse, DirectionsResponse directionsResponse, int i) {
        com.mappls.sdk.direction.ui.fragment.d dVarA = com.mappls.sdk.direction.ui.fragment.d.a(costEstimationResponse, directionsResponse, i, this.mViewModel.a);
        dVarA.a(new f(directionsResponse, i));
        replaceFragment(dVarA, true);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x0055  */
    /* JADX WARN: Code duplicated, block: B:9:0x001f  */
    private SearchCategoryUIOption getUiOption(DirectionOptions directionOptions) {
        Context contextRequireContext;
        Integer numAlongRouteDayTheme;
        SearchCategoryUIOption.Builder builder;
        if (directionOptions.theme().intValue() == 0) {
            int i = getResources().getConfiguration().uiMode & 48;
            if (i == 16) {
                contextRequireContext = requireContext();
                numAlongRouteDayTheme = directionOptions.alongRouteDayTheme();
            } else if (i != 32) {
                builder = SearchCategoryUIOption.builder();
            } else {
                contextRequireContext = requireContext();
                numAlongRouteDayTheme = directionOptions.alongRouteDarkTheme();
            }
            builder = SearchCategoryUIOption.createFromAttributes(contextRequireContext, numAlongRouteDayTheme.intValue());
        } else {
            if (directionOptions.theme().intValue() == 1) {
                contextRequireContext = requireContext();
                numAlongRouteDayTheme = directionOptions.alongRouteDayTheme();
            } else if (directionOptions.theme().intValue() == 2) {
                contextRequireContext = requireContext();
                numAlongRouteDayTheme = directionOptions.alongRouteDarkTheme();
            } else {
                builder = SearchCategoryUIOption.builder();
            }
            builder = SearchCategoryUIOption.createFromAttributes(contextRequireContext, numAlongRouteDayTheme.intValue());
        }
        return builder.build();
    }

    public static DirectionFragment newInstance() {
        return newInstance(DirectionOptions.builder().build());
    }

    public static DirectionFragment newInstance(DirectionOptions directionOptions) {
        DirectionFragment directionFragment = new DirectionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.mappls.sdk.direction.ui.DirectionModel", directionOptions);
        directionFragment.setArguments(bundle);
        return directionFragment;
    }

    public void addFragment(Fragment fragment, boolean z) {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager() != null ? getChildFragmentManager().findFragmentByTag(fragment.getClass().getName()) : null;
        if (fragment == null || fragmentFindFragmentByTag != null) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.add(this.binding.fragmentContainer.getId(), fragment, fragment.getClass().getName());
        if (z) {
            fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        }
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (IllegalStateException unused) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void clearRoute() {
        com.mappls.sdk.direction.ui.plugin.f fVar = this.directionPolylinePlugin;
        if (fVar != null) {
            fVar.b();
        }
        l lVar = this.mapEventsPlugin;
        if (lVar != null) {
            lVar.b();
        }
    }

    public com.mappls.sdk.direction.ui.plugin.f getDirectionPolylinePlugin() {
        return this.directionPolylinePlugin;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void onCancel() {
        DirectionCallback directionCallback = this.mCallback;
        if (directionCallback != null) {
            directionCallback.onCancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (MapplsDirectionLayoutBinding) DataBindingUtil.inflate(layoutInflater, R.layout.mappls_direction_layout, viewGroup, false);
        this.mViewModel = (com.mappls.sdk.direction.ui.b) new ViewModelProvider(this).get(com.mappls.sdk.direction.ui.b.class);
        Bundle arguments = getArguments();
        DirectionOptions directionOptions = this.mViewModel.a;
        if (directionOptions == null) {
            if (bundle != null) {
                this.options = (DirectionOptions) bundle.getParcelable("com.mappls.sdk.direction.ui.DirectionModel");
                bundle.clear();
            } else if (arguments != null) {
                this.options = (DirectionOptions) arguments.getParcelable("com.mappls.sdk.direction.ui.DirectionModel");
                arguments.clear();
            }
            if (this.options == null) {
                this.options = DirectionOptions.builder().build();
            }
            this.mViewModel.a = this.options;
        } else {
            this.options = directionOptions;
        }
        if (this.options.showDefaultMap().booleanValue() && this.mapView == null) {
            MapView mapView = new MapView(this.mContext, MapplsMapOptions.createFromAttributes(requireContext()).textureMode(true));
            this.mapView = mapView;
            this.binding.mapContainer.addView(mapView);
            this.mapView.onCreate(bundle);
        }
        MapView mapView2 = this.mapView;
        if (mapView2 != null) {
            mapView2.getMapAsync(this);
        }
        if (bundle == null) {
            DirectionOptions directionOptions2 = this.options;
            com.mappls.sdk.direction.ui.fragment.l lVar = new com.mappls.sdk.direction.ui.fragment.l();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("com.mappls.sdk.direction.ui.DirectionModel", directionOptions2);
            lVar.setArguments(bundle2);
            addFragment(lVar, false);
            MapView mapView3 = this.mapView;
            if (mapView3 != null) {
                lVar.a(mapView3);
            }
            lVar.a(this);
        } else {
            com.mappls.sdk.direction.ui.fragment.l lVar2 = (com.mappls.sdk.direction.ui.fragment.l) getChildFragmentManager().findFragmentByTag(com.mappls.sdk.direction.ui.fragment.l.class.getName());
            if (lVar2 != null) {
                MapView mapView4 = this.mapView;
                if (mapView4 != null) {
                    lVar2.a(mapView4);
                }
                lVar2.a(this);
            }
        }
        com.mappls.sdk.direction.ui.fragment.b bVar = (com.mappls.sdk.direction.ui.fragment.b) getChildFragmentManager().findFragmentByTag(com.mappls.sdk.direction.ui.fragment.b.class.getName());
        if (bVar != null) {
            bVar.a(this.mapView, this.mViewModel.b);
        }
        com.mappls.sdk.direction.ui.fragment.d dVar = (com.mappls.sdk.direction.ui.fragment.d) getChildFragmentManager().findFragmentByTag(com.mappls.sdk.direction.ui.fragment.d.class.getName());
        if (dVar != null) {
            dVar.a(new a());
        }
        n nVar = (n) getChildFragmentManager().findFragmentByTag(n.class.getName());
        if (nVar != null) {
            nVar.a(this);
        }
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.mappls.sdk.direction.ui.plugin.f fVar = this.directionPolylinePlugin;
        if (fVar != null) {
            fVar.b();
            this.directionPolylinePlugin.a();
        }
        l lVar = this.mapEventsPlugin;
        if (lVar != null) {
            lVar.b();
            this.mapEventsPlugin.a();
        }
        if (this.options.showDefaultMap().booleanValue()) {
            this.mapView.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (this.options.showDefaultMap().booleanValue()) {
            this.mapView.onLowMemory();
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(MapplsMap mapplsMap) {
        this.isMapInitialised = true;
        if (this.mViewModel.a.mapplsStyle() != null) {
            mapplsMap.setMapplsStyle(this.mViewModel.a.mapplsStyle());
        }
        mapplsMap.getStyle(new b(mapplsMap));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.options.showDefaultMap().booleanValue()) {
            this.mapView.onPause();
        }
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void onPreviewClick(List<LegStep> list, int i, int i2) {
        com.mappls.sdk.direction.ui.fragment.b bVarA = com.mappls.sdk.direction.ui.fragment.b.a(list, this.mapView, i, i2, this.mViewModel.a);
        this.mViewModel.b = i2;
        replaceFragment(bVarA, true);
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void onProfileUpdate(String str) {
        com.mappls.sdk.direction.ui.plugin.f fVar = this.directionPolylinePlugin;
        if (fVar != null) {
            fVar.a(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.options.showDefaultMap().booleanValue()) {
            this.mapView.onResume();
        }
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void onRouteReportSummaryClick(RouteReportSummaryResponse routeReportSummaryResponse, Integer num, DirectionsResponse directionsResponse) {
        com.mappls.sdk.direction.ui.b bVar = this.mViewModel;
        bVar.h = directionsResponse;
        bVar.g = num.intValue();
        RouteSummaryBottomSheetFragment routeSummaryBottomSheetFragment = new RouteSummaryBottomSheetFragment(routeReportSummaryResponse, num, directionsResponse, this.mViewModel.a);
        routeSummaryBottomSheetFragment.setRouteSummaryCallback(new e(directionsResponse));
        routeSummaryBottomSheetFragment.show(getChildFragmentManager(), "RouteSummaryBottomSheetFragment");
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.options.showDefaultMap().booleanValue()) {
            this.mapView.onSaveInstanceState(bundle);
        }
        bundle.putParcelable("com.mappls.sdk.direction.ui.DirectionModel", this.options);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.options.showDefaultMap().booleanValue()) {
            this.mapView.onStart();
        }
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void onStartNavigation(DirectionPoint directionPoint, DirectionPoint directionPoint2, List<DirectionPoint> list, DirectionsResponse directionsResponse, int i) {
        DirectionCallback directionCallback = this.mCallback;
        if (directionCallback != null) {
            directionCallback.onStartNavigation(directionPoint, directionPoint2, list, directionsResponse, i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.options.showDefaultMap().booleanValue()) {
            this.mapView.onStop();
        }
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void onTollInformationUpdate(HashMap<Integer, CostEstimationResponse> map) {
        com.mappls.sdk.direction.ui.plugin.f fVar = this.directionPolylinePlugin;
        if (fVar != null) {
            fVar.a(map);
        }
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void onTripEstimation(CostEstimationResponse costEstimationResponse, DirectionsResponse directionsResponse, int i) {
        com.mappls.sdk.direction.ui.b bVar = this.mViewModel;
        bVar.h = directionsResponse;
        bVar.g = i;
        if (costEstimationResponse == null || costEstimationResponse.getTotalTolls() == null || costEstimationResponse.getTotalTolls().intValue() <= 0) {
            callFuelCostFragment(costEstimationResponse, directionsResponse, i);
            return;
        }
        n nVarA = n.a(costEstimationResponse, directionsResponse, i, this.mViewModel.a);
        nVarA.a(this);
        replaceFragment(nVarA, true);
    }

    @Override // com.mappls.sdk.direction.ui.fragment.n.d
    public void onUpdateFuelCost(CostEstimationResponse costEstimationResponse, DirectionsResponse directionsResponse, int i) {
        com.mappls.sdk.direction.ui.b bVar = this.mViewModel;
        bVar.h = directionsResponse;
        bVar.g = i;
        callFuelCostFragment(costEstimationResponse, directionsResponse, i);
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void onUpdateRoute(LatLng latLng, LatLng latLng2, List<LatLng> list, List<DirectionsRoute> list2, int i) {
        com.mappls.sdk.direction.ui.b bVar = this.mViewModel;
        bVar.c = latLng;
        bVar.d = latLng2;
        bVar.e = list;
        bVar.f = list2;
        bVar.g = i;
        com.mappls.sdk.direction.ui.plugin.f fVar = this.directionPolylinePlugin;
        if (fVar != null) {
            fVar.a(latLng, latLng2, list, list2, i);
        }
        l lVar = this.mapEventsPlugin;
        if (lVar != null) {
            lVar.b();
        }
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void onUpdateRouteReport(List<RouteReport> list, int i) {
        l lVar = this.mapEventsPlugin;
        if (lVar != null) {
            lVar.a(list.get(i).getReports());
        }
    }

    public void provideMapView(MapView mapView) {
        com.mappls.sdk.direction.ui.fragment.l lVar;
        this.mapView = mapView;
        if (this.mContext != null && !this.isMapInitialised) {
            mapView.getMapAsync(this);
        }
        if (!isAdded() || (lVar = (com.mappls.sdk.direction.ui.fragment.l) getChildFragmentManager().findFragmentByTag(com.mappls.sdk.direction.ui.fragment.l.class.getName())) == null) {
            return;
        }
        lVar.a(mapView);
    }

    public void replaceFragment(Fragment fragment, boolean z) {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager() != null ? getChildFragmentManager().findFragmentByTag(fragment.getClass().getName()) : null;
        if (fragment == null || fragmentFindFragmentByTag != null) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(this.binding.fragmentContainer.getId(), fragment, fragment.getClass().getName());
        if (z) {
            fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        }
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (IllegalStateException unused) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.mappls.sdk.direction.ui.fragment.h
    public void searchCategory(String str, DirectionOptions directionOptions) {
        SearchCategoryOption.Builder builder = SearchCategoryOption.builder();
        Boolean bool = Boolean.FALSE;
        MapplsCategorySearchFragment mapplsCategorySearchFragmentNewInstance = MapplsCategorySearchFragment.newInstance(builder.isUsingInternalMap(bool).showRequestOnMap(bool).path(str).isSort(Boolean.TRUE).buffer(directionOptions.alongRouteBuffer()).build(), getUiOption(directionOptions));
        replaceFragment(mapplsCategorySearchFragmentNewInstance, true);
        mapplsCategorySearchFragmentNewInstance.provideMapView(this.mapView);
        List<CategoryCode> list = this.categoryCodes;
        if (list != null) {
            mapplsCategorySearchFragmentNewInstance.setCategoryCodes(list);
        }
        mapplsCategorySearchFragmentNewInstance.setPoiResultCallback(new c());
        mapplsCategorySearchFragmentNewInstance.setCategoryCallback(new d());
    }

    public void setCategoryCodes(List<CategoryCode> list) {
        this.categoryCodes = list;
    }

    public void setDirectionCallback(DirectionCallback directionCallback) {
        this.mCallback = directionCallback;
    }

    public void setPoiSearchCallback(POISearchCallback pOISearchCallback) {
        this.mPoiSearchCallback = pOISearchCallback;
    }
}
