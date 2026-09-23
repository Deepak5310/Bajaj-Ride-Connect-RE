package com.mappls.sdk.nearby.plugin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.nearby.plugin.R;
import com.mappls.sdk.nearby.plugin.databinding.MapplsNearbyResultListAdapterBinding;
import com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResult;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends RecyclerView.Adapter<b> {
    private final NearbyResultViewOption a;
    private List<? extends NearbyAtlasResult> b;
    private a c;

    public interface a {
        void a(NearbyAtlasResult nearbyAtlasResult);
    }

    public final class b extends RecyclerView.ViewHolder {
        private final MapplsNearbyResultListAdapterBinding a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapplsNearbyResultListAdapterBinding mBinding) {
            super(mBinding.getRoot());
            Intrinsics.checkNotNullParameter(mBinding, "mBinding");
            this.a = mBinding;
        }

        public final MapplsNearbyResultListAdapterBinding a() {
            return this.a;
        }
    }

    public d(NearbyResultViewOption viewOption) {
        Intrinsics.checkNotNullParameter(viewOption, "viewOption");
        this.a = viewOption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(d this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.c;
        if (aVar != null) {
            List<? extends NearbyAtlasResult> list = this$0.b;
            NearbyAtlasResult nearbyAtlasResult = list != null ? list.get(i) : null;
            Intrinsics.checkNotNull(nearbyAtlasResult);
            aVar.a(nearbyAtlasResult);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(b holder, final int i) {
        String str;
        NearbyAtlasResult nearbyAtlasResult;
        NearbyAtlasResult nearbyAtlasResult2;
        NearbyAtlasResult nearbyAtlasResult3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        TextView textView = holder.a().mapplsNearbyPlaceNameTv;
        List<? extends NearbyAtlasResult> list = this.b;
        Long l = null;
        textView.setText((list == null || (nearbyAtlasResult3 = list.get(i)) == null) ? null : nearbyAtlasResult3.placeName);
        TextView textView2 = holder.a().mapplsNearbyAddressTv;
        List<? extends NearbyAtlasResult> list2 = this.b;
        textView2.setText((list2 == null || (nearbyAtlasResult2 = list2.get(i)) == null) ? null : nearbyAtlasResult2.placeAddress);
        TextView textView3 = holder.a().mapplsNearbyDistanceTv;
        List<? extends NearbyAtlasResult> list3 = this.b;
        if (list3 != null && (nearbyAtlasResult = list3.get(i)) != null) {
            l = nearbyAtlasResult.distance;
        }
        if (l == null) {
            str = "";
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setRoundingMode(RoundingMode.CEILING);
            str = "Approx. " + decimalFormat.format(l.longValue() / 1000.0d) + " km away";
        }
        textView3.setText(str);
        TextView textView4 = holder.a().mapplsNearbyPlaceNameTv;
        Integer numPlaceNameTextColor = this.a.placeNameTextColor();
        Intrinsics.checkNotNullExpressionValue(numPlaceNameTextColor, "viewOption.placeNameTextColor()");
        textView4.setTextColor(numPlaceNameTextColor.intValue());
        TextView textView5 = holder.a().mapplsNearbyDistanceTv;
        Integer numDistanceTextColor = this.a.distanceTextColor();
        Intrinsics.checkNotNullExpressionValue(numDistanceTextColor, "viewOption.distanceTextColor()");
        textView5.setTextColor(numDistanceTextColor.intValue());
        TextView textView6 = holder.a().mapplsNearbyAddressTv;
        Integer numAddressTextColor = this.a.addressTextColor();
        Intrinsics.checkNotNullExpressionValue(numAddressTextColor, "viewOption.addressTextColor()");
        textView6.setTextColor(numAddressTextColor.intValue());
        View view = holder.a().mapplsNearbyResultSeperator;
        Integer numListSeperatorColor = this.a.listSeperatorColor();
        Intrinsics.checkNotNullExpressionValue(numListSeperatorColor, "viewOption.listSeperatorColor()");
        view.setBackgroundColor(numListSeperatorColor.intValue());
        holder.a().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.nearby.plugin.adapter.d$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.a(this.f$0, i, view2);
            }
        });
    }

    public final void a(com.mappls.sdk.nearby.plugin.fragment.b.C0105b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.c = callback;
    }

    public final void a(ArrayList list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<? extends NearbyAtlasResult> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.mappls_nearby_result_list_adapter, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(LayoutInflater.f…t_adapter, parent, false)");
        return new b((MapplsNearbyResultListAdapterBinding) viewDataBindingInflate);
    }
}
