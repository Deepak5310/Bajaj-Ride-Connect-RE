package com.mappls.sdk.nearby.plugin.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.nearby.plugin.R;
import com.mappls.sdk.nearby.plugin.adapter.d;
import com.mappls.sdk.nearby.plugin.databinding.MapplsNearbyFragmentResultListBinding;
import com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResult;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends Fragment {
    public static final /* synthetic */ int f = 0;
    private MapplsNearbyFragmentResultListBinding a;
    private com.mappls.sdk.nearby.plugin.viewmodel.b b;
    private d c;
    private NearbyResultViewOption d;
    private NearbyResultCallback e;

    public static final class a {
        public static b a(NearbyResultViewOption viewOption) {
            Intrinsics.checkNotNullParameter(viewOption, "viewOption");
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.mappls.sdk.nearby.plugin.NEARBY_RESULT_OPTION_KEY", viewOption);
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.nearby.plugin.fragment.b$b, reason: collision with other inner class name */
    public static final class C0105b implements d.a {
        C0105b() {
        }

        @Override // com.mappls.sdk.nearby.plugin.adapter.d.a
        public final void a(NearbyAtlasResult nearbyAtlasResult) {
            Intrinsics.checkNotNullParameter(nearbyAtlasResult, "nearbyAtlasResult");
            NearbyResultCallback nearbyResultCallback = b.this.e;
            if (nearbyResultCallback != null) {
                nearbyResultCallback.onNearbyResultClick(nearbyAtlasResult);
            }
        }
    }

    public final void a() {
        com.mappls.sdk.nearby.plugin.viewmodel.b bVar = this.b;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar = null;
        }
        NearbyAtlasResponse nearbyAtlasResponseB = bVar.b();
        if ((nearbyAtlasResponseB != null ? nearbyAtlasResponseB.getSuggestedLocations() : null) != null) {
            d dVar = this.c;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                dVar = null;
            }
            com.mappls.sdk.nearby.plugin.viewmodel.b bVar2 = this.b;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                bVar2 = null;
            }
            NearbyAtlasResponse nearbyAtlasResponseB2 = bVar2.b();
            ArrayList<NearbyAtlasResult> suggestedLocations = nearbyAtlasResponseB2 != null ? nearbyAtlasResponseB2.getSuggestedLocations() : null;
            Intrinsics.checkNotNull(suggestedLocations);
            dVar.a(suggestedLocations);
        }
    }

    public final void a(NearbyResultCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.e = callback;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(inflater, R.layout.mappls_nearby_fragment_result_list, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(inflater, R.layo…t_list, container, false)");
        MapplsNearbyFragmentResultListBinding mapplsNearbyFragmentResultListBinding = (MapplsNearbyFragmentResultListBinding) viewDataBindingInflate;
        this.a = mapplsNearbyFragmentResultListBinding;
        if (mapplsNearbyFragmentResultListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsNearbyFragmentResultListBinding = null;
        }
        View root = mapplsNearbyFragmentResultListBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        NearbyResultViewOption nearbyResultViewOption = this.d;
        if (nearbyResultViewOption == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewOption");
            nearbyResultViewOption = null;
        }
        outState.putParcelable("com.mappls.sdk.nearby.plugin.NEARBY_RESULT_OPTION_KEY", nearbyResultViewOption);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0046  */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        NearbyResultViewOption nearbyResultViewOptionBuild;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.b = (com.mappls.sdk.nearby.plugin.viewmodel.b) new ViewModelProvider(fragmentActivityRequireActivity).get(com.mappls.sdk.nearby.plugin.viewmodel.b.class);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            nearbyResultViewOptionBuild = arguments != null ? (NearbyResultViewOption) arguments.getParcelable("com.mappls.sdk.nearby.plugin.NEARBY_RESULT_OPTION_KEY") : null;
            if (nearbyResultViewOptionBuild == null) {
                nearbyResultViewOptionBuild = NearbyResultViewOption.builder().build();
                Intrinsics.checkNotNullExpressionValue(nearbyResultViewOptionBuild, "builder().build()");
            }
        } else {
            nearbyResultViewOptionBuild = bundle != null ? (NearbyResultViewOption) bundle.getParcelable("com.mappls.sdk.nearby.plugin.NEARBY_RESULT_OPTION_KEY") : null;
            if (nearbyResultViewOptionBuild == null) {
                nearbyResultViewOptionBuild = NearbyResultViewOption.builder().build();
                Intrinsics.checkNotNullExpressionValue(nearbyResultViewOptionBuild, "builder().build()");
            }
        }
        this.d = nearbyResultViewOptionBuild;
        NearbyResultViewOption nearbyResultViewOption = this.d;
        if (nearbyResultViewOption == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewOption");
            nearbyResultViewOption = null;
        }
        this.c = new d(nearbyResultViewOption);
        MapplsNearbyFragmentResultListBinding mapplsNearbyFragmentResultListBinding = this.a;
        if (mapplsNearbyFragmentResultListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsNearbyFragmentResultListBinding = null;
        }
        RecyclerView recyclerView = mapplsNearbyFragmentResultListBinding.mapplsNearbyRecyclerView;
        NearbyResultViewOption nearbyResultViewOption2 = this.d;
        if (nearbyResultViewOption2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewOption");
            nearbyResultViewOption2 = null;
        }
        Integer numListBackgroundColor = nearbyResultViewOption2.listBackgroundColor();
        Intrinsics.checkNotNullExpressionValue(numListBackgroundColor, "mViewOption.listBackgroundColor()");
        recyclerView.setBackgroundColor(numListBackgroundColor.intValue());
        MapplsNearbyFragmentResultListBinding mapplsNearbyFragmentResultListBinding2 = this.a;
        if (mapplsNearbyFragmentResultListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsNearbyFragmentResultListBinding2 = null;
        }
        mapplsNearbyFragmentResultListBinding2.mapplsNearbyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MapplsNearbyFragmentResultListBinding mapplsNearbyFragmentResultListBinding3 = this.a;
        if (mapplsNearbyFragmentResultListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsNearbyFragmentResultListBinding3 = null;
        }
        RecyclerView recyclerView2 = mapplsNearbyFragmentResultListBinding3.mapplsNearbyRecyclerView;
        d dVar = this.c;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            dVar = null;
        }
        recyclerView2.setAdapter(dVar);
        d dVar2 = this.c;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            dVar2 = null;
        }
        dVar2.a(new C0105b());
        com.mappls.sdk.nearby.plugin.viewmodel.b bVar = this.b;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar = null;
        }
        NearbyAtlasResponse nearbyAtlasResponseB = bVar.b();
        if ((nearbyAtlasResponseB != null ? nearbyAtlasResponseB.getSuggestedLocations() : null) != null) {
            d dVar3 = this.c;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                dVar3 = null;
            }
            com.mappls.sdk.nearby.plugin.viewmodel.b bVar2 = this.b;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                bVar2 = null;
            }
            NearbyAtlasResponse nearbyAtlasResponseB2 = bVar2.b();
            ArrayList<NearbyAtlasResult> suggestedLocations = nearbyAtlasResponseB2 != null ? nearbyAtlasResponseB2.getSuggestedLocations() : null;
            Intrinsics.checkNotNull(suggestedLocations);
            dVar3.a(suggestedLocations);
        }
    }
}
