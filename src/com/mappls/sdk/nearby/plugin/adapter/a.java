package com.mappls.sdk.nearby.plugin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import com.mappls.sdk.nearby.plugin.R;
import com.mappls.sdk.nearby.plugin.databinding.MapplsNearbyCategoryAdapterBinding;
import com.mappls.sdk.nearby.plugin.view.NearbyView;
import com.mappls.sdk.nearby.plugin.view.NearbyViewOption;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends RecyclerView.Adapter<b> {
    private final NearbyViewOption a;
    private List<? extends CategoryCode> b;
    private InterfaceC0104a c;

    /* JADX INFO: renamed from: com.mappls.sdk.nearby.plugin.adapter.a$a, reason: collision with other inner class name */
    public interface InterfaceC0104a {
        void a();
    }

    public static final class b extends RecyclerView.ViewHolder {
        private final MapplsNearbyCategoryAdapterBinding a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapplsNearbyCategoryAdapterBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.a = binding;
        }

        public final MapplsNearbyCategoryAdapterBinding a() {
            return this.a;
        }
    }

    public a(NearbyViewOption options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.a = options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, int i, View view) {
        CategoryCode categoryCode;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<? extends CategoryCode> list = this$0.b;
        Boolean boolValueOf = null;
        CategoryCode categoryCode2 = list != null ? list.get(i) : null;
        if (categoryCode2 != null) {
            List<? extends CategoryCode> list2 = this$0.b;
            if (list2 != null && (categoryCode = list2.get(i)) != null) {
                boolValueOf = Boolean.valueOf(categoryCode.isSelected());
            }
            Intrinsics.checkNotNull(boolValueOf);
            categoryCode2.setSelected(!boolValueOf.booleanValue());
        }
        InterfaceC0104a interfaceC0104a = this$0.c;
        if (interfaceC0104a != null) {
            interfaceC0104a.a();
        }
        this$0.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(b holder, final int i) {
        CategoryCode categoryCode;
        ImageView imageView;
        Integer numCategoryTintColor;
        String str;
        CategoryCode categoryCode2;
        CategoryCode categoryCode3;
        CategoryCode categoryCode4;
        CategoryCode categoryCode5;
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<? extends CategoryCode> list = this.b;
        Boolean boolValueOf = null;
        if (((list == null || (categoryCode5 = list.get(i)) == null) ? null : categoryCode5.getBitmapIcon()) != null) {
            ImageView imageView2 = holder.a().mapplsNearbyCategoryIcon;
            List<? extends CategoryCode> list2 = this.b;
            imageView2.setImageBitmap((list2 == null || (categoryCode4 = list2.get(i)) == null) ? null : categoryCode4.getBitmapIcon());
        } else {
            ImageView imageView3 = holder.a().mapplsNearbyCategoryIcon;
            Context context = holder.a().getRoot().getContext();
            List<? extends CategoryCode> list3 = this.b;
            Integer numValueOf = (list3 == null || (categoryCode = list3.get(i)) == null) ? null : Integer.valueOf(categoryCode.getIcon());
            Intrinsics.checkNotNull(numValueOf);
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, numValueOf.intValue()));
        }
        TextView textView = holder.a().mapplsNearbyKeyword;
        List<? extends CategoryCode> list4 = this.b;
        String category = (list4 == null || (categoryCode3 = list4.get(i)) == null) ? null : categoryCode3.getCategory();
        Intrinsics.checkNotNull(category);
        textView.setText(category);
        List<? extends CategoryCode> list5 = this.b;
        if (list5 != null && (categoryCode2 = list5.get(i)) != null) {
            boolValueOf = Boolean.valueOf(categoryCode2.isSelected());
        }
        Intrinsics.checkNotNull(boolValueOf);
        if (boolValueOf.booleanValue()) {
            CardView cardView = holder.a().mapplsNearbyCategoryBackground;
            Integer numSelectedCategoryBackgroundColor = this.a.selectedCategoryBackgroundColor();
            Intrinsics.checkNotNullExpressionValue(numSelectedCategoryBackgroundColor, "options.selectedCategoryBackgroundColor()");
            cardView.setCardBackgroundColor(numSelectedCategoryBackgroundColor.intValue());
            TextView textView2 = holder.a().mapplsNearbyKeyword;
            Integer numSelectedCategoryTextColor = this.a.selectedCategoryTextColor();
            Intrinsics.checkNotNullExpressionValue(numSelectedCategoryTextColor, "options.selectedCategoryTextColor()");
            textView2.setTextColor(numSelectedCategoryTextColor.intValue());
            imageView = holder.a().mapplsNearbyCategoryIcon;
            numCategoryTintColor = this.a.selectedCategoryTintColor();
            str = "options.selectedCategoryTintColor()";
        } else {
            CardView cardView2 = holder.a().mapplsNearbyCategoryBackground;
            Integer numCategoryBackgroundColor = this.a.categoryBackgroundColor();
            Intrinsics.checkNotNullExpressionValue(numCategoryBackgroundColor, "options.categoryBackgroundColor()");
            cardView2.setCardBackgroundColor(numCategoryBackgroundColor.intValue());
            TextView textView3 = holder.a().mapplsNearbyKeyword;
            Integer numCategoryTextColor = this.a.categoryTextColor();
            Intrinsics.checkNotNullExpressionValue(numCategoryTextColor, "options.categoryTextColor()");
            textView3.setTextColor(numCategoryTextColor.intValue());
            imageView = holder.a().mapplsNearbyCategoryIcon;
            numCategoryTintColor = this.a.categoryTintColor();
            str = "options.categoryTintColor()";
        }
        Intrinsics.checkNotNullExpressionValue(numCategoryTintColor, str);
        imageView.setColorFilter(numCategoryTintColor.intValue());
        holder.a().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.nearby.plugin.adapter.a$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.a(this.f$0, i, view);
            }
        });
    }

    public final void a(NearbyView.a onCategorySelect) {
        Intrinsics.checkNotNullParameter(onCategorySelect, "onCategorySelect");
        this.c = onCategorySelect;
    }

    public final void a(List<? extends CategoryCode> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<? extends CategoryCode> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.mappls_nearby_category_adapter, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(LayoutInflater.f…y_adapter, parent, false)");
        return new b((MapplsNearbyCategoryAdapterBinding) viewDataBindingInflate);
    }
}
