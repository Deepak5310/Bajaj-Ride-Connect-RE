package com.bajajconnect.navigate.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bajajconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AddRouteAdapter extends RecyclerView.Adapter<ViewHolder> {
    private AddRouteListener addRouteListener;
    private List<String> eLocations;
    private boolean shownextBlankLocation = false;

    public interface AddRouteListener {
        void onAddRoute();

        void onClickRouteText(int i);

        void onRemoveRoute(int i);
    }

    public void setShowNextBlankLocation(boolean z) {
        this.shownextBlankLocation = z;
        notifyDataSetChanged();
    }

    public void setAddRouteListener(AddRouteListener addRouteListener) {
        this.addRouteListener = addRouteListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_route_text, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        if (i < this.eLocations.size()) {
            if (i == this.eLocations.size() - 1) {
                viewHolder.imageViewRemove.setVisibility(8);
                viewHolder.imageViewAdd.setVisibility(8);
            } else {
                viewHolder.imageViewRemove.setVisibility(8);
                viewHolder.imageViewAdd.setVisibility(8);
            }
            viewHolder.textViewTo.setText(this.eLocations.get(i));
        } else {
            viewHolder.imageViewRemove.setVisibility(8);
            viewHolder.imageViewAdd.setVisibility(8);
        }
        viewHolder.imageViewRemove.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.adapter.AddRouteAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddRouteAdapter.this.addRouteListener.onRemoveRoute(viewHolder.getAdapterPosition());
            }
        });
        viewHolder.imageViewAdd.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.adapter.AddRouteAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddRouteAdapter.this.addRouteListener.onAddRoute();
            }
        });
        viewHolder.textViewTo.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.adapter.AddRouteAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddRouteAdapter.this.addRouteListener.onClickRouteText(viewHolder.getAdapterPosition());
            }
        });
    }

    public void updateList(List<String> list) {
        this.shownextBlankLocation = false;
        this.eLocations = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.eLocations;
        if (list == null) {
            return this.shownextBlankLocation ? 1 : 0;
        }
        boolean z = this.shownextBlankLocation;
        int size = list.size();
        return z ? size + 1 : size;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewAdd;
        private ImageView imageViewRemove;
        private TextView textViewTo;

        ViewHolder(View view) {
            super(view);
            this.textViewTo = (TextView) view.findViewById(R.id.text_view_to);
            this.imageViewAdd = (ImageView) view.findViewById(R.id.image_view_plus);
            this.imageViewRemove = (ImageView) view.findViewById(R.id.image_view_remove);
        }
    }
}
