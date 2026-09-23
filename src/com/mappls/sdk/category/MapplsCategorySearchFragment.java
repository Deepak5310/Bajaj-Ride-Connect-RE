package com.mappls.sdk.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.mappls.sdk.category.databinding.MapplsCategorySearchFragmentBinding;
import com.mappls.sdk.category.fragment.CategoryResultFragment;
import com.mappls.sdk.category.fragment.CategorySearchFragment;
import com.mappls.sdk.category.fragment.ICategoryResultListener;
import com.mappls.sdk.category.fragment.ICategorySelectionListener;
import com.mappls.sdk.category.model.PoiResult;
import com.mappls.sdk.category.model.SearchCategoryOption;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.MapplsMapOptions;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: loaded from: classes6.dex */
public final class MapplsCategorySearchFragment extends Fragment implements OnMapReadyCallback, ICategorySelectionListener, ICategoryResultListener {
    public static final Companion Companion = new Companion(0);
    private MapplsCategorySearchFragmentBinding mBinding;
    private IMapplsCategoryCallback mCallback;
    private MapView mMapView;
    private IMapplsPOICallback mPoiCallback;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int i) {
            this();
        }

        @JvmStatic
        public final MapplsCategorySearchFragment newInstance() {
            SearchCategoryOption searchCategoryOptionBuild = SearchCategoryOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(searchCategoryOptionBuild, "builder().build()");
            SearchCategoryUIOption searchCategoryUIOptionBuild = SearchCategoryUIOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(searchCategoryUIOptionBuild, "builder().build()");
            return newInstance(searchCategoryOptionBuild, searchCategoryUIOptionBuild);
        }

        @JvmStatic
        public final MapplsCategorySearchFragment newInstance(SearchCategoryOption options) {
            Intrinsics.checkNotNullParameter(options, "options");
            SearchCategoryUIOption searchCategoryUIOptionBuild = SearchCategoryUIOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(searchCategoryUIOptionBuild, "builder().build()");
            return newInstance(options, searchCategoryUIOptionBuild);
        }

        @JvmStatic
        public final MapplsCategorySearchFragment newInstance(SearchCategoryOption options, SearchCategoryUIOption uiOption) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(uiOption, "uiOption");
            a.a();
            a.a(options);
            a.a(uiOption);
            return new MapplsCategorySearchFragment();
        }

        @JvmStatic
        public final MapplsCategorySearchFragment newInstance(SearchCategoryUIOption uiOption) {
            Intrinsics.checkNotNullParameter(uiOption, "uiOption");
            SearchCategoryOption searchCategoryOptionBuild = SearchCategoryOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(searchCategoryOptionBuild, "builder().build()");
            return newInstance(searchCategoryOptionBuild, uiOption);
        }
    }

    @JvmStatic
    public static final MapplsCategorySearchFragment newInstance() {
        return Companion.newInstance();
    }

    @JvmStatic
    public static final MapplsCategorySearchFragment newInstance(SearchCategoryOption searchCategoryOption) {
        return Companion.newInstance(searchCategoryOption);
    }

    @JvmStatic
    public static final MapplsCategorySearchFragment newInstance(SearchCategoryOption searchCategoryOption, SearchCategoryUIOption searchCategoryUIOption) {
        return Companion.newInstance(searchCategoryOption, searchCategoryUIOption);
    }

    @JvmStatic
    public static final MapplsCategorySearchFragment newInstance(SearchCategoryUIOption searchCategoryUIOption) {
        return Companion.newInstance(searchCategoryUIOption);
    }

    private final void replaceFragment(Fragment fragment, boolean z) {
        MapplsCategorySearchFragmentBinding mapplsCategorySearchFragmentBinding = null;
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(fragment != null ? fragment.getClass().getSimpleName() : null);
        if (fragment == null || fragmentFindFragmentByTag != null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fm.beginTransaction()");
        MapplsCategorySearchFragmentBinding mapplsCategorySearchFragmentBinding2 = this.mBinding;
        if (mapplsCategorySearchFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            mapplsCategorySearchFragmentBinding = mapplsCategorySearchFragmentBinding2;
        }
        fragmentTransactionBeginTransaction.replace(mapplsCategorySearchFragmentBinding.mapplsCategoryView.getId(), fragment, fragment.getClass().getSimpleName());
        if (z) {
            fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (IllegalStateException unused) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.mappls.sdk.category.fragment.ICategorySelectionListener
    public void onCancel() {
        IMapplsCategoryCallback iMapplsCategoryCallback = this.mCallback;
        if (iMapplsCategoryCallback != null) {
            iMapplsCategoryCallback.onCancel();
        }
    }

    @Override // com.mappls.sdk.category.fragment.ICategoryResultListener
    public void onCategoryResult(List<PoiResult> poiResults) {
        Intrinsics.checkNotNullParameter(poiResults, "poiResults");
        IMapplsPOICallback iMapplsPOICallback = this.mPoiCallback;
        if (iMapplsPOICallback != null) {
            iMapplsPOICallback.getPOIResultListener(new ArrayList(poiResults));
        }
    }

    @Override // com.mappls.sdk.category.fragment.ICategorySelectionListener
    public void onCategorySelected(List<? extends CategoryCode> categories) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        CategoryResultFragment.a aVar = CategoryResultFragment.Companion;
        ArrayList arrayList = new ArrayList(categories);
        SearchCategoryUIOption searchCategoryUIOptionD = a.d();
        aVar.getClass();
        CategoryResultFragment categoryResultFragmentA = CategoryResultFragment.a.a(arrayList, searchCategoryUIOptionD);
        categoryResultFragmentA.setCategoryResultListener(this);
        replaceFragment(categoryResultFragmentA, true);
        MapView mapView = this.mMapView;
        if (mapView != null) {
            Intrinsics.checkNotNull(mapView);
            categoryResultFragmentA.setMapView(mapView);
        }
    }

    @Override // com.mappls.sdk.category.fragment.ICategoryResultListener
    public void onCategorySelectedResult(PoiResult poiResult) {
        Intrinsics.checkNotNullParameter(poiResult, "poiResult");
        IMapplsCategoryCallback iMapplsCategoryCallback = this.mCallback;
        if (iMapplsCategoryCallback != null) {
            iMapplsCategoryCallback.onCategorySelected(poiResult);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MapplsCategorySearchFragmentBinding mapplsCategorySearchFragmentBindingInflate = MapplsCategorySearchFragmentBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(mapplsCategorySearchFragmentBindingInflate, "inflate(inflater, container, false)");
        this.mBinding = mapplsCategorySearchFragmentBindingInflate;
        if (mapplsCategorySearchFragmentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategorySearchFragmentBindingInflate = null;
        }
        View root = mapplsCategorySearchFragmentBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        MapView mapView;
        super.onDestroyView();
        Boolean boolIsUsingInternalMap = a.c().isUsingInternalMap();
        Intrinsics.checkNotNullExpressionValue(boolIsUsingInternalMap, "MapplsCategoryWidget.sea…Option.isUsingInternalMap");
        if (boolIsUsingInternalMap.booleanValue() && (mapView = this.mMapView) != null) {
            mapView.onDestroy();
        }
        a.a();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        MapView mapView;
        super.onLowMemory();
        Boolean boolIsUsingInternalMap = a.c().isUsingInternalMap();
        Intrinsics.checkNotNullExpressionValue(boolIsUsingInternalMap, "MapplsCategoryWidget.sea…Option.isUsingInternalMap");
        if (!boolIsUsingInternalMap.booleanValue() || (mapView = this.mMapView) == null) {
            return;
        }
        mapView.onLowMemory();
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
        Timber.e(i + " --- " + str, new Object[0]);
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(MapplsMap mapplsMap) {
        Intrinsics.checkNotNullParameter(mapplsMap, "mapplsMap");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        MapView mapView;
        super.onPause();
        Boolean boolIsUsingInternalMap = a.c().isUsingInternalMap();
        Intrinsics.checkNotNullExpressionValue(boolIsUsingInternalMap, "MapplsCategoryWidget.sea…Option.isUsingInternalMap");
        if (!boolIsUsingInternalMap.booleanValue() || (mapView = this.mMapView) == null) {
            return;
        }
        mapView.onPause();
    }

    @Override // com.mappls.sdk.category.fragment.ICategoryResultListener
    public void onResultCancel() {
        getChildFragmentManager().popBackStack("CategoryResultFragment", 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        MapView mapView;
        super.onResume();
        Boolean boolIsUsingInternalMap = a.c().isUsingInternalMap();
        Intrinsics.checkNotNullExpressionValue(boolIsUsingInternalMap, "MapplsCategoryWidget.sea…Option.isUsingInternalMap");
        if (!boolIsUsingInternalMap.booleanValue() || (mapView = this.mMapView) == null) {
            return;
        }
        mapView.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        MapView mapView;
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Boolean boolIsUsingInternalMap = a.c().isUsingInternalMap();
        Intrinsics.checkNotNullExpressionValue(boolIsUsingInternalMap, "MapplsCategoryWidget.sea…Option.isUsingInternalMap");
        if (!boolIsUsingInternalMap.booleanValue() || (mapView = this.mMapView) == null) {
            return;
        }
        mapView.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        MapView mapView;
        super.onStart();
        Boolean boolIsUsingInternalMap = a.c().isUsingInternalMap();
        Intrinsics.checkNotNullExpressionValue(boolIsUsingInternalMap, "MapplsCategoryWidget.sea…Option.isUsingInternalMap");
        if (!boolIsUsingInternalMap.booleanValue() || (mapView = this.mMapView) == null) {
            return;
        }
        mapView.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        MapView mapView;
        super.onStop();
        Boolean boolIsUsingInternalMap = a.c().isUsingInternalMap();
        Intrinsics.checkNotNullExpressionValue(boolIsUsingInternalMap, "MapplsCategoryWidget.sea…Option.isUsingInternalMap");
        if (!boolIsUsingInternalMap.booleanValue() || (mapView = this.mMapView) == null) {
            return;
        }
        mapView.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Boolean boolIsUsingInternalMap = a.c().isUsingInternalMap();
        Intrinsics.checkNotNullExpressionValue(boolIsUsingInternalMap, "MapplsCategoryWidget.sea…Option.isUsingInternalMap");
        if (boolIsUsingInternalMap.booleanValue() && this.mMapView == null) {
            this.mMapView = new MapView(requireContext(), MapplsMapOptions.createFromAttributes(requireContext()).textureMode(true));
            MapplsCategorySearchFragmentBinding mapplsCategorySearchFragmentBinding = this.mBinding;
            if (mapplsCategorySearchFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                mapplsCategorySearchFragmentBinding = null;
            }
            mapplsCategorySearchFragmentBinding.mapplsCategoryView.addView(this.mMapView);
            MapView mapView = this.mMapView;
            if (mapView != null) {
                mapView.onCreate(bundle);
            }
        }
        if (bundle == null) {
            CategorySearchFragment.a aVar = CategorySearchFragment.Companion;
            SearchCategoryUIOption searchCategoryUIOptionD = a.d();
            aVar.getClass();
            CategorySearchFragment categorySearchFragmentA = CategorySearchFragment.a.a(searchCategoryUIOptionD);
            categorySearchFragmentA.setCategorySelectionListener(this);
            replaceFragment(categorySearchFragmentA, false);
            return;
        }
        CategorySearchFragment categorySearchFragment = (CategorySearchFragment) getChildFragmentManager().findFragmentByTag("CategorySearchFragment");
        if (categorySearchFragment != null) {
            categorySearchFragment.setCategorySelectionListener(this);
        }
        CategoryResultFragment categoryResultFragment = (CategoryResultFragment) getChildFragmentManager().findFragmentByTag("CategoryResultFragment");
        MapView mapView2 = this.mMapView;
        if (mapView2 != null && categoryResultFragment != null) {
            Intrinsics.checkNotNull(mapView2);
            categoryResultFragment.setMapView(mapView2);
        }
        if (categoryResultFragment != null) {
            categoryResultFragment.setCategoryResultListener(this);
        }
    }

    public final void provideMapView(MapView mapView) {
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        if (this.mMapView != null) {
            throw new RuntimeException("MapView is already added");
        }
        this.mMapView = mapView;
    }

    public final void setCategoryCallback(IMapplsCategoryCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
    }

    public final void setCategoryCodes(List<? extends CategoryCode> categories) {
        CategorySearchFragment categorySearchFragment;
        Intrinsics.checkNotNullParameter(categories, "categories");
        a.a(categories);
        if (!isAdded() || (categorySearchFragment = (CategorySearchFragment) getChildFragmentManager().findFragmentByTag("CategorySearchFragment")) == null) {
            return;
        }
        categorySearchFragment.setCategoryCodes(categories);
    }

    public final void setPoiResultCallback(IMapplsPOICallback mPOICallback) {
        Intrinsics.checkNotNullParameter(mPOICallback, "mPOICallback");
        this.mPoiCallback = mPOICallback;
    }
}
