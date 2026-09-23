package com.mappls.sdk.nearby.plugin.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import com.mappls.sdk.nearby.plugin.R;
import com.mappls.sdk.nearby.plugin.databinding.MapplsNearbyFragmentBinding;
import com.mappls.sdk.nearby.plugin.model.MapplsNearbyResponse;
import com.mappls.sdk.nearby.plugin.model.NearbyUIOption;
import com.mappls.sdk.nearby.plugin.view.NearbyView;
import com.mappls.sdk.nearby.plugin.view.NearbyViewOption;
import com.mappls.sdk.nearby.plugin.view.f;
import com.mappls.sdk.nearby.plugin.viewmodel.d;
import com.mappls.sdk.plugins.places.placepicker.PlacePicker;
import com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions;
import com.mappls.sdk.services.api.Place;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class NearbyFragment extends Fragment implements f {
    public static final Companion Companion = new Companion(0);
    private MapplsNearbyFragmentBinding mBinding;
    private d mViewModel;
    private com.mappls.sdk.nearby.plugin.a nearbyCallback;
    private NearbyView nearbyView;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int i) {
            this();
        }

        @JvmStatic
        public final NearbyFragment newInstance() {
            NearbyUIOption nearbyUIOptionBuild = NearbyUIOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(nearbyUIOptionBuild, "builder().build()");
            return newInstance(nearbyUIOptionBuild);
        }

        @JvmStatic
        public final NearbyFragment newInstance(NearbyUIOption nearbyUIOption) {
            Intrinsics.checkNotNullParameter(nearbyUIOption, "nearbyUIOption");
            NearbyFragment nearbyFragment = new NearbyFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.mappls.sdk.nearby.plugin.NEARBY_OPTION_KEY", nearbyUIOption);
            nearbyFragment.setArguments(bundle);
            return nearbyFragment;
        }
    }

    @JvmStatic
    public static final NearbyFragment newInstance() {
        return Companion.newInstance();
    }

    @JvmStatic
    public static final NearbyFragment newInstance(NearbyUIOption nearbyUIOption) {
        return Companion.newInstance(nearbyUIOption);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Place place;
        super.onActivityResult(i, i2, intent);
        if (i == 101 && i2 == -1 && (place = PlacePicker.getPlace(intent)) != null) {
            NearbyView nearbyView = this.nearbyView;
            if (nearbyView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nearbyView");
                nearbyView = null;
            }
            nearbyView.setSelectedLocation(place);
        }
    }

    @Override // com.mappls.sdk.nearby.plugin.view.f
    public void onChangeLocationRequest(Double d, Double d2, String str) {
        PlacePickerOptions.Builder builder = PlacePickerOptions.builder();
        if (d != null && d2 != null) {
            builder.statingCameraPosition(new CameraPosition.Builder().target(new LatLng(d.doubleValue(), d2.doubleValue())).zoom(16.0d).build());
        } else if (str != null) {
            builder.startingMapplsPinPosition(str);
        }
        startActivityForResult(new PlacePicker.IntentBuilder().placeOptions(builder.build()).build(requireActivity()), 101);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(inflater, R.layout.mappls_nearby_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(inflater, R.layo…agment, container, false)");
        MapplsNearbyFragmentBinding mapplsNearbyFragmentBinding = (MapplsNearbyFragmentBinding) viewDataBindingInflate;
        this.mBinding = mapplsNearbyFragmentBinding;
        if (mapplsNearbyFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsNearbyFragmentBinding = null;
        }
        View root = mapplsNearbyFragmentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        NearbyView nearbyView = this.nearbyView;
        if (nearbyView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbyView");
            nearbyView = null;
        }
        nearbyView.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        if (i == 0) {
            if ((grantResults.length == 0) || grantResults[0] != 0) {
                return;
            }
            NearbyView nearbyView = this.nearbyView;
            if (nearbyView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nearbyView");
                nearbyView = null;
            }
            nearbyView.enableLocationRequest();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        NearbyView nearbyView = this.nearbyView;
        if (nearbyView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbyView");
            nearbyView = null;
        }
        nearbyView.onResume();
    }

    @Override // com.mappls.sdk.nearby.plugin.view.f
    public void onSelectCategory(MapplsNearbyResponse nearbyAtlasResponse) {
        Intrinsics.checkNotNullParameter(nearbyAtlasResponse, "nearbyAtlasResponse");
        Timber.e(new Gson().toJson(nearbyAtlasResponse), new Object[0]);
        com.mappls.sdk.nearby.plugin.a aVar = this.nearbyCallback;
        if (aVar != null) {
            aVar.onSelectCategory(nearbyAtlasResponse);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NearbyView nearbyView = this.nearbyView;
        if (nearbyView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbyView");
            nearbyView = null;
        }
        nearbyView.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle arguments;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.mViewModel = (d) new ViewModelProvider(fragmentActivityRequireActivity).get(d.class);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (!com.mappls.sdk.nearby.plugin.util.a.a(contextRequireContext)) {
            com.mappls.sdk.nearby.plugin.util.a.a(this);
        }
        d dVar = this.mViewModel;
        NearbyView nearbyView = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            dVar = null;
        }
        if (dVar.e() == null && (arguments = getArguments()) != null) {
            d dVar2 = this.mViewModel;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                dVar2 = null;
            }
            dVar2.a((NearbyUIOption) arguments.getParcelable("com.mappls.sdk.nearby.plugin.NEARBY_OPTION_KEY"));
            arguments.clear();
        }
        d dVar3 = this.mViewModel;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            dVar3 = null;
        }
        if (dVar3.e() == null) {
            d dVar4 = this.mViewModel;
            if (dVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                dVar4 = null;
            }
            dVar4.a(NearbyUIOption.builder().build());
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        d dVar5 = this.mViewModel;
        if (dVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            dVar5 = null;
        }
        NearbyViewOption nearbyViewOptionCreateFromNearbyOption = NearbyViewOption.createFromNearbyOption(dVar5.e());
        Intrinsics.checkNotNullExpressionValue(nearbyViewOptionCreateFromNearbyOption, "createFromNearbyOption(mViewModel.nearbyUIOption)");
        this.nearbyView = new NearbyView(contextRequireContext2, nearbyViewOptionCreateFromNearbyOption);
        MapplsNearbyFragmentBinding mapplsNearbyFragmentBinding = this.mBinding;
        if (mapplsNearbyFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsNearbyFragmentBinding = null;
        }
        FrameLayout frameLayout = mapplsNearbyFragmentBinding.mapplsNearbyView;
        NearbyView nearbyView2 = this.nearbyView;
        if (nearbyView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbyView");
            nearbyView2 = null;
        }
        frameLayout.addView(nearbyView2);
        NearbyView nearbyView3 = this.nearbyView;
        if (nearbyView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbyView");
            nearbyView3 = null;
        }
        nearbyView3.onCreate(bundle);
        NearbyView nearbyView4 = this.nearbyView;
        if (nearbyView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbyView");
        } else {
            nearbyView = nearbyView4;
        }
        nearbyView.setNearbyViewCallback(this);
    }

    public final void setCategoryCodes(List<? extends CategoryCode> categories) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        d dVar = this.mViewModel;
        if (dVar != null) {
            NearbyView nearbyView = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                dVar = null;
            }
            dVar.a(categories);
            NearbyView nearbyView2 = this.nearbyView;
            if (nearbyView2 != null) {
                if (nearbyView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nearbyView");
                } else {
                    nearbyView = nearbyView2;
                }
                nearbyView.setCategoryCodes(categories);
            }
        }
    }

    public final void setNearbyCallback(com.mappls.sdk.nearby.plugin.a nearbyCallback) {
        Intrinsics.checkNotNullParameter(nearbyCallback, "nearbyCallback");
        this.nearbyCallback = nearbyCallback;
    }
}
