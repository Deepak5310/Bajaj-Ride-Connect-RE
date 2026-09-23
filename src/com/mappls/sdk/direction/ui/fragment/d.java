package com.mappls.sdk.direction.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionFuelCostFragmentBinding;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.DistanceType;
import com.mappls.sdk.services.api.costestimation.CostEstimationCriteria;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.fuleCost.models.FuelCostResponse;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class d extends Fragment {
    private CostEstimationResponse a;
    private DirectionsResponse b;
    private int c;
    private MapplsDirectionFuelCostFragmentBinding d;
    private String e = CostEstimationCriteria.VEHICLE_FUEL_TYPE_PETROL;
    private InterfaceC0073d f;
    private com.mappls.sdk.direction.ui.viewmodel.b g;
    private DirectionOptions h;

    final class a extends OnBackPressedCallback {
        a() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            d.this.getParentFragmentManager().popBackStack(d.this.getClass().getName(), 1);
        }
    }

    final class b implements com.mappls.sdk.direction.ui.adapters.d.b {
        b() {
        }

        @Override // com.mappls.sdk.direction.ui.adapters.d.b
        public final void a(String str) {
            EditText editText;
            int i;
            str.getClass();
            str.hashCode();
            switch (str) {
                case "diesel":
                case "petrol":
                    editText = d.this.d.editTextAverage;
                    i = R.string.mappls_direction_fuel_efficiency_ltr;
                    break;
                case "electric":
                    editText = d.this.d.editTextAverage;
                    i = R.string.mappls_direction_fuel_efficiency_in_km;
                    break;
                case "CNG":
                    editText = d.this.d.editTextAverage;
                    i = R.string.mappls_direction_fuel_efficiency_kg;
                    break;
                default:
                    d.this.e = str;
                    d.this.a();
            }
            editText.setHint(i);
            d.this.e = str;
            d.this.a();
        }
    }

    final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.c(d.this);
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.direction.ui.fragment.d$d, reason: collision with other inner class name */
    public interface InterfaceC0073d {
        void a(CostEstimationResponse costEstimationResponse);
    }

    public static d a(CostEstimationResponse costEstimationResponse, DirectionsResponse directionsResponse, int i, DirectionOptions directionOptions) {
        d dVar = new d();
        dVar.a = costEstimationResponse;
        dVar.b = directionsResponse;
        dVar.c = i;
        dVar.h = directionOptions;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        EditText editText;
        StringBuilder sb;
        Double diesel;
        if (this.g.f == null) {
            return;
        }
        String str = this.e;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "diesel":
                editText = this.d.editTextCost;
                sb = new StringBuilder();
                diesel = this.g.f.getDiesel();
                break;
            case "petrol":
                editText = this.d.editTextCost;
                sb = new StringBuilder();
                diesel = this.g.f.getPetrol();
                break;
            case "electric":
                editText = this.d.editTextCost;
                sb = new StringBuilder();
                diesel = this.g.f.getElectric();
                break;
            case "CNG":
                editText = this.d.editTextCost;
                sb = new StringBuilder();
                diesel = this.g.f.getCng();
                break;
            default:
                return;
        }
        sb.append(diesel);
        sb.append("");
        editText.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(com.mappls.sdk.direction.ui.common.b bVar) {
        if (bVar != null) {
            int i = bVar.a;
            if (i != 1 || bVar.c == 0) {
                if (i == 2) {
                    Toast.makeText(requireContext(), bVar.b, 0).show();
                }
            } else {
                getParentFragmentManager().popBackStack(getClass().getName(), 1);
                InterfaceC0073d interfaceC0073d = this.f;
                if (interfaceC0073d != null) {
                    interfaceC0073d.a((CostEstimationResponse) bVar.c);
                }
            }
        }
    }

    private void b() {
        this.g.a.observe(getViewLifecycleOwner(), new Observer() { // from class: com.mappls.sdk.direction.ui.fragment.d$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.a((com.mappls.sdk.direction.ui.common.b) obj);
            }
        });
        this.g.b.observe(getViewLifecycleOwner(), new Observer() { // from class: com.mappls.sdk.direction.ui.fragment.d$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.b((com.mappls.sdk.direction.ui.common.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void b(com.mappls.sdk.direction.ui.common.b bVar) {
        T t;
        if (bVar == null || bVar.a != 1 || (t = bVar.c) == 0) {
            return;
        }
        this.g.f = (FuelCostResponse) t;
        if (TextUtils.isEmpty(this.d.editTextAverage.getText().toString())) {
            a();
        }
    }

    static void c(d dVar) {
        Context contextRequireContext;
        String str;
        com.mappls.sdk.direction.ui.utils.a.a(dVar.d.getRoot());
        if (TextUtils.isEmpty(dVar.d.editTextCost.getText().toString())) {
            contextRequireContext = dVar.requireContext();
            str = "Please enter fuel price";
        } else {
            if (!TextUtils.isEmpty(dVar.d.editTextAverage.getText().toString())) {
                int i = Integer.parseInt(dVar.d.editTextAverage.getText().toString());
                double d = Double.parseDouble(dVar.d.editTextCost.getText().toString());
                DirectionsResponse directionsResponse = dVar.b;
                dVar.g.a(dVar.b.sessionId(), dVar.c, dVar.e, Integer.valueOf(i), Double.valueOf(d), (directionsResponse == null || directionsResponse.routes().size() <= 0 || dVar.b.routes().get(0).routeOptions() == null) ? "driving" : dVar.b.routes().get(0).routeOptions().profile());
                return;
            }
            contextRequireContext = dVar.requireContext();
            str = "Please enter fuel efficiency";
        }
        Toast.makeText(contextRequireContext, str, 0).show();
    }

    public final void a(InterfaceC0073d interfaceC0073d) {
        this.f = interfaceC0073d;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MapplsDirectionFuelCostFragmentBinding mapplsDirectionFuelCostFragmentBinding = (MapplsDirectionFuelCostFragmentBinding) DataBindingUtil.inflate(layoutInflater, R.layout.mappls_direction_fuel_cost_fragment, viewGroup, false);
        this.d = mapplsDirectionFuelCostFragmentBinding;
        return mapplsDirectionFuelCostFragmentBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Toolbar toolbar;
        String str;
        TextView textView;
        String str2;
        DirectionsResponse directionsResponse;
        Point pointLocation;
        TextView textView2;
        double dDoubleValue;
        DistanceType distanceType;
        super.onViewCreated(view, bundle);
        com.mappls.sdk.direction.ui.viewmodel.b bVar = (com.mappls.sdk.direction.ui.viewmodel.b) new ViewModelProvider(this).get(com.mappls.sdk.direction.ui.viewmodel.b.class);
        this.g = bVar;
        if (bundle != null) {
            this.a = bVar.c;
            this.b = bVar.d;
            this.c = bVar.e;
        } else {
            bVar.c = this.a;
            bVar.d = this.b;
            bVar.e = this.c;
        }
        b();
        CostEstimationResponse costEstimationResponse = this.a;
        if (costEstimationResponse == null || costEstimationResponse.getVehicleFuelType() == null) {
            toolbar = this.d.fuelCostHeader.toolbar;
            str = "Add Fuel Cost";
        } else {
            toolbar = this.d.fuelCostHeader.toolbar;
            str = "Update Fuel Cost";
        }
        toolbar.setTitle(str);
        this.d.fuelCostHeader.toolbar.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary));
        this.d.fuelCostHeader.toolbar.setNavigationOnClickListener(new e(this));
        this.d.fuelCostHeader.toolbar.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(requireContext(), R.color.mappls_direction_colorPrimary), requireContext()));
        this.d.fuelCostHeader.toolbar.setTitleTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.fuelCostHeader.toolbar.setNavigationIcon(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_route_back, R.drawable.mappls_direction_baseline_arrow_back_24, requireContext()));
        this.d.previewView.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_toolbar_seperator, Color.parseColor("#eeeeee"), requireContext()));
        this.d.fuelCostLayout.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_fuel_cost_background, ContextCompat.getColor(requireContext(), R.color.mappls_directions_white), requireContext()));
        this.d.textViewTollLebel.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewTollFee.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewDurationLebel.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewDuration.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewDistanceLebel.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewDistance.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.editTextCost.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.editTextAverage.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.textViewSelectFuelType.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.d.fuelCostSeperatorView.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_fuel_cost_seperator_background, ContextCompat.getColor(requireContext(), R.color.mappls_directions_white_smoke), requireContext()));
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new a());
        CostEstimationResponse costEstimationResponse2 = this.a;
        if (costEstimationResponse2 == null || costEstimationResponse2.getHasTolls() == null || !this.a.getHasTolls().booleanValue()) {
            textView = this.d.textViewTollFee;
            str2 = "₹ 0";
        } else if (this.a.getTotalTollCost() != null) {
            textView = this.d.textViewTollFee;
            str2 = "₹ " + this.a.getTotalTollCost();
        } else {
            textView = this.d.textViewTollFee;
            str2 = "₹ NA";
        }
        textView.setText(str2);
        if (this.b.routes().get(this.c) != null) {
            DirectionOptions directionOptions = this.h;
            if (directionOptions == null || directionOptions.distanceType().intValue() == 0) {
                textView2 = this.d.textViewDistance;
                dDoubleValue = this.b.routes().get(this.c).distance().doubleValue();
                distanceType = DistanceType.METRIC;
            } else {
                textView2 = this.d.textViewDistance;
                dDoubleValue = this.b.routes().get(this.c).distance().doubleValue();
                distanceType = DistanceType.IMPERIAL;
            }
            textView2.setText(DirectionFormatter.getFormattedDistanceRound(dDoubleValue, distanceType));
            this.d.textViewDuration.setText(DirectionFormatter.getFormattedDuration(this.b.routes().get(this.c).duration().doubleValue()));
        }
        this.d.recyclerViewFuelType.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        CostEstimationResponse costEstimationResponse3 = this.a;
        if (costEstimationResponse3 != null && costEstimationResponse3.getVehicleFuelType() != null) {
            this.e = this.a.getVehicleFuelType();
        }
        CostEstimationResponse costEstimationResponse4 = this.a;
        if (costEstimationResponse4 != null && costEstimationResponse4.getVehicleFuelType() != null) {
            this.e = this.a.getVehicleFuelType();
        }
        CostEstimationResponse costEstimationResponse5 = this.a;
        if (costEstimationResponse5 != null && costEstimationResponse5.getFuelPrice() != null) {
            this.d.editTextCost.setText(this.a.getFuelPrice() + "");
        }
        CostEstimationResponse costEstimationResponse6 = this.a;
        if (costEstimationResponse6 != null && costEstimationResponse6.getFuelEfficiency() != null) {
            this.d.editTextAverage.setText(this.a.getFuelEfficiency().replaceAll("\\D", ""));
        }
        if (TextUtils.isEmpty(this.d.editTextAverage.getText().toString()) && (directionsResponse = this.b) != null && directionsResponse.waypoints() != null && this.b.waypoints().size() > 0 && (pointLocation = this.b.waypoints().get(0).location()) != null) {
            this.g.a(pointLocation.latitude(), pointLocation.longitude());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.mappls.sdk.direction.ui.model.d("Petrol", CostEstimationCriteria.VEHICLE_FUEL_TYPE_PETROL, com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_petrol_station_unselected_icon, R.drawable.mappls_direction_petrol_station_grey, requireContext()), com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_petrol_station_selected_icon, R.drawable.mappls_direction_petrol_station_white, requireContext()), Integer.valueOf(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_fuel_type_unselected_background, R.drawable.mappls_direction_fuel_type_bg, requireContext())), Integer.valueOf(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_fuel_type_selected_background, R.drawable.mappls_direction_fuel_type_bg_selected, requireContext())), Boolean.valueOf(this.e.equalsIgnoreCase(CostEstimationCriteria.VEHICLE_FUEL_TYPE_PETROL))));
        arrayList.add(new com.mappls.sdk.direction.ui.model.d("Diesel", CostEstimationCriteria.VEHICLE_FUEL_TYPE_DIESEL, com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_diesel_station_unselected_icon, R.drawable.mappls_direction_diesel_station_grey, requireContext()), com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_diesel_station_selected_icon, R.drawable.mappls_direction_diesel_station_white, requireContext()), Integer.valueOf(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_fuel_type_unselected_background, R.drawable.mappls_direction_fuel_type_bg, requireContext())), Integer.valueOf(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_fuel_type_selected_background, R.drawable.mappls_direction_fuel_type_bg_selected, requireContext())), Boolean.valueOf(this.e.equalsIgnoreCase(CostEstimationCriteria.VEHICLE_FUEL_TYPE_DIESEL))));
        arrayList.add(new com.mappls.sdk.direction.ui.model.d(CostEstimationCriteria.VEHICLE_FUEL_TYPE_CNG, CostEstimationCriteria.VEHICLE_FUEL_TYPE_CNG, com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_cng_station_unselected_icon, R.drawable.mappls_direction_cng_station_grey, requireContext()), com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_cng_station_selected_icon, R.drawable.mappls_direction_cng_station_white, requireContext()), Integer.valueOf(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_fuel_type_unselected_background, R.drawable.mappls_direction_fuel_type_bg, requireContext())), Integer.valueOf(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_fuel_type_selected_background, R.drawable.mappls_direction_fuel_type_bg_selected, requireContext())), Boolean.valueOf(this.e.equalsIgnoreCase(CostEstimationCriteria.VEHICLE_FUEL_TYPE_CNG))));
        arrayList.add(new com.mappls.sdk.direction.ui.model.d("Electric", CostEstimationCriteria.VEHICLE_FUEL_TYPE_ELECTRIC, com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_ev_station_unselected_icon, R.drawable.mappls_direction_ev_station_grey, requireContext()), com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_ev_station_selected_icon, R.drawable.mappls_direction_ev_station_white, requireContext()), Integer.valueOf(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_fuel_type_unselected_background, R.drawable.mappls_direction_fuel_type_bg, requireContext())), Integer.valueOf(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_fuel_type_selected_background, R.drawable.mappls_direction_fuel_type_bg_selected, requireContext())), Boolean.valueOf(this.e.equalsIgnoreCase(CostEstimationCriteria.VEHICLE_FUEL_TYPE_ELECTRIC))));
        com.mappls.sdk.direction.ui.adapters.d dVar = new com.mappls.sdk.direction.ui.adapters.d(arrayList);
        dVar.a(new b());
        this.d.recyclerViewFuelType.setAdapter(dVar);
        this.d.textViewCalculate.setOnClickListener(new c());
    }
}
