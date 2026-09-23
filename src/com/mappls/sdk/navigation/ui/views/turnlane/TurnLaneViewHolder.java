package com.mappls.sdk.navigation.ui.views.turnlane;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.R;

/* JADX INFO: loaded from: classes4.dex */
class TurnLaneViewHolder extends RecyclerView.ViewHolder {
    TurnLaneView turnLaneView;

    TurnLaneViewHolder(View view) {
        super(view);
        this.turnLaneView = (TurnLaneView) view.findViewById(R.id.turnLaneView);
    }
}
