package com.mappls.sdk.navigation.ui.navigation.infobar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutBottomSheetAdapterBinding;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends RecyclerView.Adapter {
    public List a;
    public e b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        b bVar = (b) viewHolder;
        LayoutBottomSheetAdapterBinding layoutBottomSheetAdapterBinding = bVar.a;
        layoutBottomSheetAdapterBinding.ivBottomItem.setBackgroundResource(com.mappls.sdk.navigation.ui.theme.a.a(layoutBottomSheetAdapterBinding.getRoot().getContext(), R.attr.navigationViewBottomSheetImageBackground).resourceId);
        if (((d) this.a.get(bVar.getAdapterPosition())).a.equalsIgnoreCase("mappls_navigation_ui_day_night_mode") || ((d) this.a.get(bVar.getAdapterPosition())).a.equalsIgnoreCase("mappls_navigation_ui_setting") || ((d) this.a.get(bVar.getAdapterPosition())).a.equalsIgnoreCase("mappls_navigation_ui_trafffic") || ((d) this.a.get(bVar.getAdapterPosition())).a.equalsIgnoreCase("mappls_navigation_ui_direction_list")) {
            LayoutBottomSheetAdapterBinding layoutBottomSheetAdapterBinding2 = bVar.a;
            ImageView imageView = layoutBottomSheetAdapterBinding2.ivBottomItem;
            Context context = layoutBottomSheetAdapterBinding2.getRoot().getContext();
            imageView.setImageDrawable(AppCompatResources.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, ((d) this.a.get(bVar.getAdapterPosition())).c).resourceId));
        } else {
            bVar.a.ivBottomItem.setImageResource(((d) this.a.get(bVar.getAdapterPosition())).c);
        }
        LayoutBottomSheetAdapterBinding layoutBottomSheetAdapterBinding3 = bVar.a;
        layoutBottomSheetAdapterBinding3.tvBottomItem.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(layoutBottomSheetAdapterBinding3.getRoot().getContext(), R.attr.navigationTextColorSecondary));
        bVar.a.tvBottomItem.setText(((d) this.a.get(bVar.getAdapterPosition())).b);
        bVar.a.getRoot().setOnClickListener(new a(this, bVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b((LayoutBottomSheetAdapterBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.layout_bottom_sheet_adapter, viewGroup, false));
    }
}
