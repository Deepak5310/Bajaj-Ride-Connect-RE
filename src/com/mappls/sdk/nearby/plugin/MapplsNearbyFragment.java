package com.mappls.sdk.nearby.plugin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.nearby.plugin.databinding.MapplsNearbyBaseFragmentBinding;
import com.mappls.sdk.nearby.plugin.fragment.NearbyFragment;
import com.mappls.sdk.nearby.plugin.fragment.NearbyResultFragment;
import com.mappls.sdk.nearby.plugin.model.MapplsNearbyResponse;
import com.mappls.sdk.nearby.plugin.model.NearbyOption;
import com.mappls.sdk.nearby.plugin.model.NearbyUIOption;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResult;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MapplsNearbyFragment extends Fragment implements a, INearbyResultCallback {
    public static final Companion Companion = new Companion(0);
    private MapplsNearbyBaseFragmentBinding mBinding;
    private IMapplsNearbyCallback mCallbcak;
    private MapView mapView;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int i) {
            this();
        }

        @JvmStatic
        public final MapplsNearbyFragment newInstance() {
            NearbyOption nearbyOptionBuild = NearbyOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(nearbyOptionBuild, "builder().build()");
            NearbyUIOption nearbyUIOptionBuild = NearbyUIOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(nearbyUIOptionBuild, "builder().build()");
            return newInstance(nearbyOptionBuild, nearbyUIOptionBuild);
        }

        @JvmStatic
        public final MapplsNearbyFragment newInstance(NearbyOption nearbyOption) {
            Intrinsics.checkNotNullParameter(nearbyOption, "nearbyOption");
            NearbyUIOption nearbyUIOptionBuild = NearbyUIOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(nearbyUIOptionBuild, "builder().build()");
            return newInstance(nearbyOption, nearbyUIOptionBuild);
        }

        @JvmStatic
        public final MapplsNearbyFragment newInstance(NearbyOption nearbyOption, NearbyUIOption neabyUIOption) {
            Intrinsics.checkNotNullParameter(nearbyOption, "nearbyOption");
            Intrinsics.checkNotNullParameter(neabyUIOption, "neabyUIOption");
            MapplsNearbyWidget mapplsNearbyWidget = MapplsNearbyWidget.INSTANCE;
            mapplsNearbyWidget.setNearbyOption$mappls_nearby_widget_othersRelease(nearbyOption);
            mapplsNearbyWidget.setNearbyUIOption$mappls_nearby_widget_othersRelease(neabyUIOption);
            return new MapplsNearbyFragment();
        }

        @JvmStatic
        public final MapplsNearbyFragment newInstance(NearbyUIOption neabyUIOption) {
            Intrinsics.checkNotNullParameter(neabyUIOption, "neabyUIOption");
            NearbyOption nearbyOptionBuild = NearbyOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(nearbyOptionBuild, "builder().build()");
            return newInstance(nearbyOptionBuild, neabyUIOption);
        }
    }

    @JvmStatic
    public static final MapplsNearbyFragment newInstance() {
        return Companion.newInstance();
    }

    @JvmStatic
    public static final MapplsNearbyFragment newInstance(NearbyOption nearbyOption) {
        return Companion.newInstance(nearbyOption);
    }

    @JvmStatic
    public static final MapplsNearbyFragment newInstance(NearbyOption nearbyOption, NearbyUIOption nearbyUIOption) {
        return Companion.newInstance(nearbyOption, nearbyUIOption);
    }

    @JvmStatic
    public static final MapplsNearbyFragment newInstance(NearbyUIOption nearbyUIOption) {
        return Companion.newInstance(nearbyUIOption);
    }

    private final void replaceFragment(Fragment fragment, boolean z) {
        MapplsNearbyBaseFragmentBinding mapplsNearbyBaseFragmentBinding = null;
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(fragment != null ? fragment.getClass().getSimpleName() : null);
        if (fragment == null || fragmentFindFragmentByTag != null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fm.beginTransaction()");
        MapplsNearbyBaseFragmentBinding mapplsNearbyBaseFragmentBinding2 = this.mBinding;
        if (mapplsNearbyBaseFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            mapplsNearbyBaseFragmentBinding = mapplsNearbyBaseFragmentBinding2;
        }
        fragmentTransactionBeginTransaction.replace(mapplsNearbyBaseFragmentBinding.mapplsNearbyBaseFragmentContainer.getId(), fragment, fragment.getClass().getSimpleName());
        if (z) {
            fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (IllegalStateException unused) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.mappls.sdk.nearby.plugin.INearbyResultCallback
    public void onCancel() {
        getChildFragmentManager().popBackStack("NearbyResultFragment", 1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(inflater, R.layout.mappls_nearby_base_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(inflater,\n      …agment, container, false)");
        MapplsNearbyBaseFragmentBinding mapplsNearbyBaseFragmentBinding = (MapplsNearbyBaseFragmentBinding) viewDataBindingInflate;
        this.mBinding = mapplsNearbyBaseFragmentBinding;
        if (mapplsNearbyBaseFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsNearbyBaseFragmentBinding = null;
        }
        View root = mapplsNearbyBaseFragmentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.mappls.sdk.nearby.plugin.a
    public void onSelectCategory(MapplsNearbyResponse mapplsNearbyResponse) {
        Intrinsics.checkNotNullParameter(mapplsNearbyResponse, "mapplsNearbyResponse");
        NearbyResultFragment nearbyResultFragmentNewInstance = NearbyResultFragment.Companion.newInstance(mapplsNearbyResponse, MapplsNearbyWidget.INSTANCE.getNearbyUIOption());
        nearbyResultFragmentNewInstance.setOnNearbyResultCallback(this);
        replaceFragment(nearbyResultFragmentNewInstance, true);
        MapView mapView = this.mapView;
        if (mapView != null) {
            Intrinsics.checkNotNull(mapView);
            nearbyResultFragmentNewInstance.provideMapView(mapView);
        }
    }

    @Override // com.mappls.sdk.nearby.plugin.INearbyResultCallback
    public void onSelectResult(NearbyAtlasResult nearbyAtlasResult) {
        Intrinsics.checkNotNullParameter(nearbyAtlasResult, "nearbyAtlasResult");
        IMapplsNearbyCallback iMapplsNearbyCallback = this.mCallbcak;
        if (iMapplsNearbyCallback != null) {
            iMapplsNearbyCallback.getNearbyCallback(nearbyAtlasResult);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        NearbyUIOption nearbyUIOption = MapplsNearbyWidget.INSTANCE.getNearbyUIOption();
        if (bundle == null) {
            NearbyFragment nearbyFragmentNewInstance = NearbyFragment.Companion.newInstance(nearbyUIOption);
            nearbyFragmentNewInstance.setNearbyCallback(this);
            replaceFragment(nearbyFragmentNewInstance, false);
            return;
        }
        NearbyFragment nearbyFragment = (NearbyFragment) getChildFragmentManager().findFragmentByTag("NearbyFragment");
        if (nearbyFragment != null) {
            nearbyFragment.setNearbyCallback(this);
        }
        NearbyResultFragment nearbyResultFragment = (NearbyResultFragment) getChildFragmentManager().findFragmentByTag("NearbyResultFragment");
        if (nearbyResultFragment != null) {
            nearbyResultFragment.setOnNearbyResultCallback(this);
        }
    }

    public final void provideMapView(MapView mapView) {
        NearbyResultFragment nearbyResultFragment;
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        this.mapView = mapView;
        if (!isAdded() || (nearbyResultFragment = (NearbyResultFragment) getChildFragmentManager().findFragmentByTag(NearbyResultFragment.class.getName())) == null) {
            return;
        }
        nearbyResultFragment.provideMapView(mapView);
    }

    public final void setCategoryList(List<? extends CategoryCode> categories) {
        NearbyFragment nearbyFragment;
        Intrinsics.checkNotNullParameter(categories, "categories");
        MapplsNearbyWidget.INSTANCE.setCategoryList$mappls_nearby_widget_othersRelease(categories);
        if (!isAdded() || (nearbyFragment = (NearbyFragment) getChildFragmentManager().findFragmentByTag("NearbyFragment")) == null) {
            return;
        }
        nearbyFragment.setCategoryCodes(categories);
    }

    public final void setMapplsNearbyCallback(IMapplsNearbyCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallbcak = callback;
    }
}
