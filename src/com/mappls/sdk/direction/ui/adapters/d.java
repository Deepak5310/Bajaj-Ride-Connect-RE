package com.mappls.sdk.direction.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionFuelTypeAdapterBinding;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends RecyclerView.Adapter<a> {
    private final List<com.mappls.sdk.direction.ui.model.d> a;
    private b b;

    protected class a extends RecyclerView.ViewHolder {
        private final MapplsDirectionFuelTypeAdapterBinding a;

        public a(MapplsDirectionFuelTypeAdapterBinding mapplsDirectionFuelTypeAdapterBinding) {
            super(mapplsDirectionFuelTypeAdapterBinding.getRoot());
            this.a = mapplsDirectionFuelTypeAdapterBinding;
        }
    }

    public interface b {
        void a(String str);
    }

    public d(ArrayList arrayList) {
        this.a = arrayList;
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<com.mappls.sdk.direction.ui.model.d> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        int iA;
        a aVar = (a) viewHolder;
        com.mappls.sdk.direction.ui.model.d dVar = this.a.get(i);
        if (dVar.e().booleanValue()) {
            aVar.a.parentLayout.setBackgroundResource(dVar.f().intValue());
            aVar.a.imageViewFuelType.setImageResource(dVar.g());
            textView = aVar.a.textViewTypeFuel;
            iA = ContextCompat.getColor(aVar.itemView.getContext(), R.color.mappls_directions_white);
        } else {
            aVar.a.parentLayout.setBackgroundResource(dVar.b().intValue());
            aVar.a.imageViewFuelType.setImageResource(dVar.c());
            textView = aVar.a.textViewTypeFuel;
            iA = com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, ContextCompat.getColor(aVar.itemView.getContext(), R.color.mappls_directions_colorTextSecondary), aVar.itemView.getContext());
        }
        textView.setTextColor(iA);
        aVar.a.textViewTypeFuel.setText(dVar.d());
        aVar.a.getRoot().setOnClickListener(new c(this, dVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((MapplsDirectionFuelTypeAdapterBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_fuel_type_adapter, viewGroup, false));
    }
}
