package com.mappls.sdk.navigation.ui.navigation.finished;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends RecyclerView.Adapter {
    public final ArrayList a;

    public e(ArrayList arrayList) {
        this.a = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getAdapterPosition();
        viewHolder.getAdapterPosition();
        d dVar = (d) viewHolder;
        f fVar = (f) this.a.get(i);
        dVar.a.setText(fVar.a);
        dVar.b.setText(fVar.b);
        String str = fVar.c;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "duration":
                dVar.d.setBackgroundColor(Color.parseColor("#e7392a"));
                dVar.c.setImageResource(R.drawable.mappls_navigation_ic_duration);
                break;
            case "avg_speed":
                dVar.d.setBackgroundColor(Color.parseColor("#e7392a"));
                dVar.c.setImageResource(R.drawable.mappls_navigation_ic_average_speed);
                break;
            case "distance":
                dVar.d.setBackgroundColor(Color.parseColor("#f86624"));
                dVar.c.setImageResource(R.drawable.mappls_navigation_ic_distance);
                break;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_trip_status_adapter, viewGroup, false));
    }
}
