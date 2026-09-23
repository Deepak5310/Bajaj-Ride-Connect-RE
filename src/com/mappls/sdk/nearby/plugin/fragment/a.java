package com.mappls.sdk.nearby.plugin.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.mappls.sdk.nearby.plugin.R;
import com.mappls.sdk.nearby.plugin.databinding.MapplsNearbyFragmentMapBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends Fragment {
    private MapplsNearbyFragmentMapBinding a;
    private NearbyResultCallback b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NearbyResultCallback nearbyResultCallback = this$0.b;
        if (nearbyResultCallback != null) {
            nearbyResultCallback.onLocationClick();
        }
    }

    public final void a(NearbyResultCallback nearbyResultCallback) {
        Intrinsics.checkNotNullParameter(nearbyResultCallback, "nearbyResultCallback");
        this.b = nearbyResultCallback;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(inflater, R.layout.mappls_nearby_fragment_map, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(inflater, R.layo…nt_map, container, false)");
        MapplsNearbyFragmentMapBinding mapplsNearbyFragmentMapBinding = (MapplsNearbyFragmentMapBinding) viewDataBindingInflate;
        this.a = mapplsNearbyFragmentMapBinding;
        if (mapplsNearbyFragmentMapBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsNearbyFragmentMapBinding = null;
        }
        View root = mapplsNearbyFragmentMapBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        MapplsNearbyFragmentMapBinding mapplsNearbyFragmentMapBinding = this.a;
        if (mapplsNearbyFragmentMapBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsNearbyFragmentMapBinding = null;
        }
        mapplsNearbyFragmentMapBinding.mapplsNearbyUserLocationButton.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.nearby.plugin.fragment.a$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.a(this.f$0, view2);
            }
        });
    }
}
