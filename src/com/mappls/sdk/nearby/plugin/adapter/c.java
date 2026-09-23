package com.mappls.sdk.nearby.plugin.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import com.mappls.sdk.nearby.plugin.R;
import com.mappls.sdk.nearby.plugin.databinding.MapplsNearbyResultCategoryAdapterBinding;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends RecyclerView.Adapter<a> {
    private List<? extends CategoryCode> a;

    public static final class a extends RecyclerView.ViewHolder {
        private final MapplsNearbyResultCategoryAdapterBinding a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MapplsNearbyResultCategoryAdapterBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.a = binding;
        }

        public final MapplsNearbyResultCategoryAdapterBinding a() {
            return this.a;
        }
    }

    public final void a(List<? extends CategoryCode> selectedCategories) {
        Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
        this.a = selectedCategories;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<? extends CategoryCode> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        CategoryCode categoryCode;
        a holder = (a) viewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        TextView textView = holder.a().mapplsNearbyCategoryTv;
        List<? extends CategoryCode> list = this.a;
        textView.setText((list == null || (categoryCode = list.get(i)) == null) ? null : categoryCode.getCategory());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.mappls_nearby_result_category_adapter, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(LayoutInflater.f…y_adapter, parent, false)");
        return new a((MapplsNearbyResultCategoryAdapterBinding) viewDataBindingInflate);
    }
}
