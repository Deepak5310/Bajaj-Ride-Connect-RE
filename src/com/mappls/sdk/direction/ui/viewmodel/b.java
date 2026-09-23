package com.mappls.sdk.direction.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.costestimation.CostEstimationCriteria;
import com.mappls.sdk.services.api.costestimation.MapplsCostEstimation;
import com.mappls.sdk.services.api.costestimation.MapplsCostEstimationManager;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.fuleCost.MapplsFuelCost;
import com.mappls.sdk.services.api.fuleCost.MapplsFuelCostManager;
import com.mappls.sdk.services.api.fuleCost.models.FuelCostResponse;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends ViewModel {
    public MutableLiveData<com.mappls.sdk.direction.ui.common.b<CostEstimationResponse>> a = new MutableLiveData<>();
    public MutableLiveData<com.mappls.sdk.direction.ui.common.b<FuelCostResponse>> b = new MutableLiveData<>();
    public CostEstimationResponse c;
    public DirectionsResponse d;
    public int e;
    public FuelCostResponse f;

    final class a implements OnResponseCallback<FuelCostResponse> {
        a() {
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            b.this.b.postValue(new com.mappls.sdk.direction.ui.common.b<>(2, null, "Something went wrong"));
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(FuelCostResponse fuelCostResponse) {
            b.this.b.postValue(new com.mappls.sdk.direction.ui.common.b<>(1, fuelCostResponse, null));
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.direction.ui.viewmodel.b$b, reason: collision with other inner class name */
    final class C0077b implements OnResponseCallback<CostEstimationResponse> {
        C0077b() {
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            b.this.a.postValue(new com.mappls.sdk.direction.ui.common.b<>(2, null, "Something went wrong"));
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(CostEstimationResponse costEstimationResponse) {
            b.this.a.postValue(new com.mappls.sdk.direction.ui.common.b<>(1, costEstimationResponse, null));
        }
    }

    public final void a(double d, double d2) {
        this.b.postValue(new com.mappls.sdk.direction.ui.common.b<>(3, null, null));
        MapplsFuelCostManager.newInstance(MapplsFuelCost.builder().location(Double.valueOf(d), Double.valueOf(d2)).build()).call(new a());
    }

    public final void a(String str, int i, String str2, Integer num, Double d, String str3) {
        String str4;
        String str5;
        byte b = 3;
        this.a.postValue(new com.mappls.sdk.direction.ui.common.b<>(3, null, null));
        MapplsCostEstimation.Builder builderRouteIndex = MapplsCostEstimation.builder().routeId(str).isTollEnabled(Boolean.TRUE).routeIndex(Integer.valueOf(i));
        if (str2 != null) {
            builderRouteIndex.vehicleFuelType(str2);
            str2.hashCode();
            switch (str2.hashCode()) {
                case -1331959846:
                    b = !str2.equals(CostEstimationCriteria.VEHICLE_FUEL_TYPE_DIESEL) ? (byte) -1 : (byte) 0;
                    break;
                case -991657904:
                    b = !str2.equals(CostEstimationCriteria.VEHICLE_FUEL_TYPE_PETROL) ? (byte) -1 : (byte) 1;
                    break;
                case -17124067:
                    b = !str2.equals(CostEstimationCriteria.VEHICLE_FUEL_TYPE_ELECTRIC) ? (byte) -1 : (byte) 2;
                    break;
                case 66876:
                    if (!str2.equals(CostEstimationCriteria.VEHICLE_FUEL_TYPE_CNG)) {
                        b = -1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                    str5 = CostEstimationCriteria.UNIT_KM_P_L;
                    break;
                case 2:
                    str5 = CostEstimationCriteria.UNIT_KM_P_UNIT;
                    break;
                case 3:
                    str5 = CostEstimationCriteria.UNIT_KM_P_KG;
                    break;
            }
            builderRouteIndex.fuelEfficiencyUnit(str5);
        }
        if (num != null) {
            builderRouteIndex.fuelEfficiency(num);
        }
        if (d != null) {
            builderRouteIndex.fuelPrice(d);
        }
        if (str3.equalsIgnoreCase("driving")) {
            str4 = CostEstimationCriteria.VEHICLE_TYPE_AUTO;
        } else {
            if (!str3.equalsIgnoreCase("biking")) {
                if (str3.equalsIgnoreCase("trucking")) {
                    str4 = CostEstimationCriteria.VEHICLE_TYPE_TRUCK;
                }
                MapplsCostEstimationManager.newInstance(builderRouteIndex.build()).call(new C0077b());
            }
            str4 = CostEstimationCriteria.VEHICLE_TYPE_MOTO;
        }
        builderRouteIndex.vehicleType(str4);
        MapplsCostEstimationManager.newInstance(builderRouteIndex.build()).call(new C0077b());
    }
}
