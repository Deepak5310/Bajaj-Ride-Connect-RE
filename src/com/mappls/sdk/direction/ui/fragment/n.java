package com.mappls.sdk.direction.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionTollCostFragmentBinding;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.DistanceType;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;

/* JADX INFO: loaded from: classes6.dex */
public class n extends Fragment {
    private CostEstimationResponse a;
    private DirectionsResponse b;
    private int c;
    private MapplsDirectionTollCostFragmentBinding d;
    private d e;
    private com.mappls.sdk.direction.ui.viewmodel.c f;
    private DirectionOptions g;

    final class a extends OnBackPressedCallback {
        a() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            n.this.getParentFragmentManager().popBackStack(n.this.getClass().getName(), 1);
        }
    }

    final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (n.this.e != null) {
                n.this.e.onUpdateFuelCost(n.this.a, n.this.b, n.this.c);
            }
        }
    }

    final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ImageView imageView;
            int i;
            int i2;
            if (n.this.d.recyclerViewToll.getVisibility() == 0) {
                n.this.d.recyclerViewToll.setVisibility(8);
                imageView = n.this.d.imageViewShowHideTollInfo;
                i = R.styleable.mappls_direction_mappls_directions_toll_cost_expand_icon;
                i2 = R.drawable.mappls_direction_baseline_arrow_down;
            } else {
                n.this.d.recyclerViewToll.setVisibility(0);
                imageView = n.this.d.imageViewShowHideTollInfo;
                i = R.styleable.mappls_direction_mappls_directions_toll_cost_collapse_icon;
                i2 = R.drawable.mappls_direction_baseline_arrow_up;
            }
            imageView.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(i, i2, n.this.requireContext()));
        }
    }

    public interface d {
        void onUpdateFuelCost(CostEstimationResponse costEstimationResponse, DirectionsResponse directionsResponse, int i);
    }

    public static n a(CostEstimationResponse costEstimationResponse, DirectionsResponse directionsResponse, int i, DirectionOptions directionOptions) {
        n nVar = new n();
        nVar.a = costEstimationResponse;
        nVar.b = directionsResponse;
        nVar.c = i;
        nVar.g = directionOptions;
        return nVar;
    }

    private void a() {
        TextView textView;
        String str;
        TextView textView2;
        StringBuilder sb;
        Object totalFuelCost;
        String formattedDistanceRound;
        TextView textView3;
        StringBuilder sb2;
        TextView textView4;
        String str2;
        if (this.a.getHasTolls() == null || !this.a.getHasTolls().booleanValue()) {
            a(false);
        } else {
            a(true);
            this.d.textViewNumberOfToll.setText(this.a.getTotalTolls() + "");
            if (this.a.getTotalTollCost() != null) {
                textView4 = this.d.textViewTotalTollFee;
                str2 = "₹ " + this.a.getTotalTollCost();
            } else {
                textView4 = this.d.textViewTotalTollFee;
                str2 = "₹ NA";
            }
            textView4.setText(str2);
        }
        if (this.a.getTotalFuelCost() != null) {
            this.d.layoutFuelAndTotalCost.setVisibility(0);
            this.d.textViewTotalFuelCostDisplay.setText("₹ " + this.a.getTotalFuelCost());
            if (this.a.getTotalTripCostEstimate() != null) {
                textView2 = this.d.textViewGrandTotalFee;
                sb = new StringBuilder("₹ ");
                totalFuelCost = this.a.getTotalTripCostEstimate();
            } else {
                textView2 = this.d.textViewGrandTotalFee;
                sb = new StringBuilder("₹ ");
                totalFuelCost = this.a.getTotalFuelCost();
            }
            sb.append(totalFuelCost);
            textView2.setText(sb.toString());
            DirectionOptions directionOptions = this.g;
            if (directionOptions == null || directionOptions.distanceType().intValue() == 0) {
                formattedDistanceRound = DirectionFormatter.getFormattedDistanceRound(this.a.getDistance().doubleValue(), DistanceType.METRIC);
                textView3 = this.d.textViewFuelCostInfo;
                sb2 = new StringBuilder();
            } else {
                formattedDistanceRound = DirectionFormatter.getFormattedDistanceRound(this.a.getDistance().doubleValue(), DistanceType.IMPERIAL);
                textView3 = this.d.textViewFuelCostInfo;
                sb2 = new StringBuilder();
            }
            sb2.append(formattedDistanceRound);
            sb2.append(" / ");
            sb2.append(this.a.getFuelEfficiency());
            sb2.append(" * ₹ ");
            sb2.append(this.a.getFuelPrice());
            textView3.setText(sb2.toString());
            int iIntValue = this.a.getTotalTollCost() != null ? this.a.getTotalTollCost().intValue() : 0;
            int iIntValue2 = this.a.getTotalFuelCost() != null ? this.a.getTotalFuelCost().intValue() : 0;
            this.d.textViewGrandTotalInfo.setText("Toll Fee (₹ " + iIntValue + ") + Fuel Cost (₹ " + iIntValue2 + ")");
            textView = this.d.textViewAddUpdateFuelCost;
            str = "Update Fuel Cost";
        } else {
            this.d.layoutFuelAndTotalCost.setVisibility(8);
            textView = this.d.textViewAddUpdateFuelCost;
            str = "Add Fuel Cost";
        }
        textView.setText(str);
        this.d.recyclerViewToll.setLayoutManager(new LinearLayoutManager(requireContext()));
        this.d.recyclerViewToll.setHasFixedSize(true);
        this.d.recyclerViewToll.setAdapter(new com.mappls.sdk.direction.ui.adapters.k(this.a.getTolls(), this.g));
        this.d.imageViewShowHideTollInfo.setOnClickListener(new c());
    }

    private void a(boolean z) {
        this.d.recyclerViewToll.setVisibility(z ? 0 : 8);
        this.d.imageViewShowHideTollInfo.setVisibility(z ? 0 : 8);
        this.d.textViewNumberOfToll.setVisibility(z ? 0 : 8);
        this.d.imageViewTotalTollCost.setVisibility(z ? 0 : 8);
        this.d.textViewTollRoute.setVisibility(z ? 0 : 8);
        this.d.viewTollSeperator.setVisibility(z ? 0 : 8);
        this.d.textViewTotalTollFee.setVisibility(z ? 0 : 8);
    }

    public final void a(d dVar) {
        this.e = dVar;
    }

    public final void a(CostEstimationResponse costEstimationResponse) {
        this.a = costEstimationResponse;
        this.f.a = costEstimationResponse;
        a();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MapplsDirectionTollCostFragmentBinding mapplsDirectionTollCostFragmentBinding = (MapplsDirectionTollCostFragmentBinding) DataBindingUtil.inflate(layoutInflater, R.layout.mappls_direction_toll_cost_fragment, viewGroup, false);
        this.d = mapplsDirectionTollCostFragmentBinding;
        return mapplsDirectionTollCostFragmentBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        this.d.layoutTollCost.toolbar.setTitle("Estimated Trip Cost");
        this.d.layoutTollCost.toolbar.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary));
        this.d.layoutTollCost.toolbar.setNavigationOnClickListener(new o(this));
        this.d.layoutTollCost.toolbar.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(requireContext(), R.color.mappls_direction_colorPrimary), requireContext()));
        this.d.layoutTollCost.toolbar.setTitleTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.layoutTollCost.toolbar.setNavigationIcon(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_route_back, R.drawable.mappls_direction_baseline_arrow_back_24, requireContext()));
        this.d.previewView.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_toolbar_seperator, Color.parseColor("#eeeeee"), requireContext()));
        this.d.tollCostLayout.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_fuel_cost_background, ContextCompat.getColor(requireContext(), R.color.mappls_directions_white), requireContext()));
        this.d.textViewTollRoute.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewTotalTollFee.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewTotalFuelCost.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewTotalFuelCostDisplay.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewGrandTotalFee.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewFuelCostInfo.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextSecondary), requireContext()));
        this.d.textViewGrandTotalInfo.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextSecondary), requireContext()));
        this.d.imageViewShowHideTollInfo.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_toll_cost_collapse_icon, R.drawable.mappls_direction_baseline_arrow_up, requireContext()));
        this.d.viewTollSeperator.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_toll_cost_seperator, Color.parseColor("#DEDEDE"), requireContext()));
        this.d.view1.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_toll_cost_seperator, Color.parseColor("#DEDEDE"), requireContext()));
        com.mappls.sdk.direction.ui.viewmodel.c cVar = (com.mappls.sdk.direction.ui.viewmodel.c) new ViewModelProvider(this).get(com.mappls.sdk.direction.ui.viewmodel.c.class);
        this.f = cVar;
        if (bundle != null) {
            this.a = cVar.a;
            this.b = cVar.b;
            this.c = cVar.c;
        } else {
            cVar.a = this.a;
            cVar.b = this.b;
            cVar.c = this.c;
        }
        a();
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new a());
        this.d.textViewAddUpdateFuelCost.setOnClickListener(new b());
    }
}
