package com.bajajconnect.navigate.poi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bajajconnect.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PoiResultsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<PoiModel> items = new ArrayList();
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(PoiModel poiModel);
    }

    public PoiResultsAdapter(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public void setItems(List<PoiModel> list) {
        this.items.clear();
        if (list != null) {
            this.items.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.poi_result_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final PoiModel poiModel = this.items.get(i);
        viewHolder.name.setText(poiModel.name);
        viewHolder.address.setText(poiModel.address == null ? "" : poiModel.address);
        if (poiModel.distanceMeters > 0.0f) {
            viewHolder.distance.setText(String.format("%dm", Integer.valueOf((int) poiModel.distanceMeters)));
        } else {
            viewHolder.distance.setText("");
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.poi.PoiResultsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(poiModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(PoiModel poiModel, View view) {
        this.listener.onItemClick(poiModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        TextView distance;
        ImageView icon;
        TextView name;

        ViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(R.id.poi_icon);
            this.name = (TextView) view.findViewById(R.id.poi_name);
            this.address = (TextView) view.findViewById(R.id.poi_address);
            this.distance = (TextView) view.findViewById(R.id.poi_distance);
        }
    }
}
