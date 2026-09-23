package com.mappls.sdk.direction.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionItemTollRowLayoutBinding;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.plugin.directions.DateTimeFormat;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.DistanceType;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationTollDetail;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class k extends RecyclerView.Adapter<a> {
    private final List<CostEstimationTollDetail> a;
    private final DirectionOptions b;

    static class a extends RecyclerView.ViewHolder {
        private final MapplsDirectionItemTollRowLayoutBinding a;

        public a(MapplsDirectionItemTollRowLayoutBinding mapplsDirectionItemTollRowLayoutBinding) {
            super(mapplsDirectionItemTollRowLayoutBinding.getRoot());
            this.a = mapplsDirectionItemTollRowLayoutBinding;
        }
    }

    public k(List<CostEstimationTollDetail> list, DirectionOptions directionOptions) {
        this.a = list;
        this.b = directionOptions;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<CostEstimationTollDetail> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        StringBuilder sb;
        double dDoubleValue;
        DistanceType distanceType;
        a aVar = (a) viewHolder;
        CostEstimationTollDetail costEstimationTollDetail = this.a.get(i);
        aVar.a.textViewTollName.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(aVar.itemView.getContext(), R.color.mappls_directions_colorTextPrimary), aVar.itemView.getContext()));
        aVar.a.textViewTollInfo.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, ContextCompat.getColor(aVar.itemView.getContext(), R.color.mappls_directions_colorTextSecondary), aVar.itemView.getContext()));
        aVar.a.textViewTollName.setText(costEstimationTollDetail.getTollName());
        if (costEstimationTollDetail.getCost() != null) {
            DirectionOptions directionOptions = this.b;
            if (directionOptions == null || directionOptions.distanceType().intValue() == 0) {
                textView = aVar.a.textViewTollInfo;
                sb = new StringBuilder("₹ ");
                sb.append(costEstimationTollDetail.getCost());
                sb.append(" • ");
                dDoubleValue = costEstimationTollDetail.getDistance().doubleValue();
                distanceType = DistanceType.METRIC;
            } else {
                textView = aVar.a.textViewTollInfo;
                sb = new StringBuilder("₹ ");
                sb.append(costEstimationTollDetail.getCost());
                sb.append(" • ");
                dDoubleValue = costEstimationTollDetail.getDistance().doubleValue();
                distanceType = DistanceType.IMPERIAL;
            }
        } else {
            DirectionOptions directionOptions2 = this.b;
            if (directionOptions2 == null || directionOptions2.distanceType().intValue() == 0) {
                textView = aVar.a.textViewTollInfo;
                sb = new StringBuilder("₹ NA • ");
                dDoubleValue = costEstimationTollDetail.getDistance().doubleValue();
                distanceType = DistanceType.METRIC;
            } else {
                textView = aVar.a.textViewTollInfo;
                sb = new StringBuilder("₹ NA • ");
                dDoubleValue = costEstimationTollDetail.getDistance().doubleValue();
                distanceType = DistanceType.IMPERIAL;
            }
        }
        sb.append(DirectionFormatter.getFormattedDistanceRound(dDoubleValue, distanceType));
        sb.append(" • ETA:");
        sb.append(DirectionFormatter.getArrivalTime(costEstimationTollDetail.getDuration().doubleValue(), DateTimeFormat.DATE_12_HOUR));
        textView.setText(sb.toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((MapplsDirectionItemTollRowLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_item_toll_row_layout, viewGroup, false));
    }
}
