package com.mappls.sdk.navigation.ui.views.turnlane;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.services.api.directions.models.IntersectionLanes;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TurnLaneAdapter extends RecyclerView.Adapter<TurnLaneViewHolder> {
    private String maneuverModifier;
    private int primaryColor = Color.parseColor("#FFFFFF");
    private int secondaryColor = Color.parseColor("#AAFFFFFF");
    private List<IntersectionLanes> lanes = new ArrayList();

    public void addTurnLanes(List<IntersectionLanes> list, String str) {
        this.maneuverModifier = str;
        this.lanes.clear();
        this.lanes = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.lanes.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TurnLaneViewHolder turnLaneViewHolder, int i) {
        IntersectionLanes intersectionLanes = this.lanes.get(i);
        turnLaneViewHolder.turnLaneView.updateManeuverColor(this.primaryColor, this.secondaryColor);
        turnLaneViewHolder.turnLaneView.updateLaneView(intersectionLanes, this.maneuverModifier);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TurnLaneViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TurnLaneViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.turn_lane_listitem_layout, viewGroup, false));
    }

    public void setLanesColor(int i, int i2) {
        this.primaryColor = i;
        this.secondaryColor = i2;
        notifyDataSetChanged();
    }
}
