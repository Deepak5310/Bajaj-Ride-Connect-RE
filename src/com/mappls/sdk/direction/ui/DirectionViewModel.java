package com.mappls.sdk.direction.ui;

import android.content.Context;
import android.provider.Settings;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.direction.ui.model.StopModel;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.costestimation.CostEstimationCriteria;
import com.mappls.sdk.services.api.costestimation.MapplsCostEstimation;
import com.mappls.sdk.services.api.costestimation.MapplsCostEstimationManager;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationResponse;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.MapplsDirectionManager;
import com.mappls.sdk.services.api.directions.MapplsDirections;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.event.route.MapplsRouteSummary;
import com.mappls.sdk.services.api.event.route.MapplsRouteSummaryManager;
import com.mappls.sdk.services.api.event.route.model.RouteReportSummaryResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes6.dex */
public class DirectionViewModel extends ViewModel {
    private DirectionsResponse directionsResponse;
    public DirectionOptions options;
    public String profile;
    private RouteReportSummaryResponse routeReportSummaryResponse;
    private int selectedIndex;
    private int theme;
    public final HashMap<Integer, CostEstimationResponse> tollHashMap = new HashMap<>();
    public MutableLiveData<com.mappls.sdk.direction.ui.common.b<DirectionsResponse>> directionResponseResourceLiveData = new MutableLiveData<>();
    public MutableLiveData<com.mappls.sdk.direction.ui.common.b<RouteReportSummaryResponse>> routeReportSummaryResourceLiveData = new MutableLiveData<>();
    public MutableLiveData<com.mappls.sdk.direction.ui.common.b<Pair<Integer, CostEstimationResponse>>> costEstimationResponseLiveData = new MutableLiveData<>();
    private List<StopModel> stopModels = new ArrayList();

    final class a implements OnResponseCallback<DirectionsResponse> {
        a() {
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            Timber.d("Directions:- %s", str);
            DirectionViewModel.this.directionsResponse = null;
            DirectionViewModel.this.directionResponseResourceLiveData.postValue(new com.mappls.sdk.direction.ui.common.b<>(2, null, "Something went wrong"));
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(DirectionsResponse directionsResponse) {
            DirectionsResponse directionsResponse2 = directionsResponse;
            DirectionViewModel.this.selectedIndex = 0;
            DirectionViewModel.this.directionsResponse = directionsResponse2;
            DirectionViewModel.this.directionResponseResourceLiveData.postValue(new com.mappls.sdk.direction.ui.common.b<>(1, directionsResponse2, null));
        }
    }

    final class b implements OnResponseCallback<RouteReportSummaryResponse> {
        b() {
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            DirectionViewModel.this.routeReportSummaryResourceLiveData.postValue(new com.mappls.sdk.direction.ui.common.b<>(2, null, "Something went wrong"));
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(RouteReportSummaryResponse routeReportSummaryResponse) {
            DirectionViewModel.this.routeReportSummaryResourceLiveData.postValue(new com.mappls.sdk.direction.ui.common.b<>(1, routeReportSummaryResponse, null));
        }
    }

    final class c implements OnResponseCallback<CostEstimationResponse> {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            DirectionViewModel.this.costEstimationResponseLiveData.postValue(new com.mappls.sdk.direction.ui.common.b<>(2, null, "Something went wrong"));
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(CostEstimationResponse costEstimationResponse) {
            DirectionViewModel.this.costEstimationResponseLiveData.postValue(new com.mappls.sdk.direction.ui.common.b<>(1, new Pair(Integer.valueOf(this.a), costEstimationResponse), null));
        }
    }

    public void addStop(StopModel stopModel) {
        this.stopModels.add(stopModel);
    }

    public void addWayPoint(StopModel stopModel) {
        if (this.stopModels.size() >= 2) {
            List<StopModel> list = this.stopModels;
            list.add(list.size() - 1, stopModel);
        }
    }

    public String getDestinationLocation() {
        List<StopModel> list;
        int size;
        List<StopModel> list2 = this.stopModels;
        if (com.mappls.sdk.direction.ui.common.a.a(list2.get(list2.size() - 1))) {
            List<StopModel> list3 = this.stopModels;
            if (list3.get(list3.size() - 2).getLocationType() == StopModel.TYPE_CURRENT_LOCATION) {
                return "Your Current Location";
            }
            list = this.stopModels;
            size = list.size() - 2;
        } else {
            List<StopModel> list4 = this.stopModels;
            if (list4.get(list4.size() - 1).getLocationType() == StopModel.TYPE_CURRENT_LOCATION) {
                return "Your Current Location";
            }
            list = this.stopModels;
            size = list.size() - 1;
        }
        return list.get(size).getPlaceName();
    }

    public DirectionsResponse getDirectionsResponse() {
        return this.directionsResponse;
    }

    public void getRouteLiveData(Context context, String str, String str2, List<String> list) {
        this.directionResponseResourceLiveData.postValue(new com.mappls.sdk.direction.ui.common.b<>(3, null, null));
        MapplsDirections.Builder builderDestination = MapplsDirections.builder().baseUrl(this.options.routingBaseUrl()).overview(this.options.overview()).alternatives(this.options.showAlternative()).geometries(this.options.geometries()).instructions(this.options.instructions()).steps(this.options.steps()).origin(str).profile(this.profile).destination(str2);
        if (!this.profile.equalsIgnoreCase("walking")) {
            builderDestination.resource(this.options.resource());
            if (this.options.resource().equalsIgnoreCase(DirectionsCriteria.RESOURCE_ROUTE_ETA)) {
                builderDestination.deviceId(Settings.Secure.getString(context.getContentResolver(), "android_id"));
                builderDestination.routeRefresh(Boolean.TRUE);
            }
            if (this.options.annotation() != null) {
                String[] strArr = new String[this.options.annotation().size()];
                for (int i = 0; i < this.options.annotation().size(); i++) {
                    strArr[i] = this.options.annotation().get(i);
                }
                builderDestination.annotations(strArr);
            }
            if (this.options.excludes() != null) {
                String[] strArr2 = new String[this.options.excludes().size()];
                for (int i2 = 0; i2 < this.options.excludes().size(); i2++) {
                    strArr2[i2] = this.options.excludes().get(i2);
                }
                builderDestination.excludes(strArr2);
            }
            if (this.options.routeType() != null) {
                builderDestination.routeType(this.options.routeType());
            }
        }
        if (list != null) {
            for (String str3 : list) {
                if (str3 != null) {
                    builderDestination.addWaypoint(str3);
                }
            }
        }
        if (this.options.isSort() != null) {
            builderDestination.isSort(this.options.isSort());
        }
        if (this.options.lessVerbose() != null) {
            builderDestination.lessVerbose(this.options.lessVerbose());
        }
        if (this.options.continueStraight() != null) {
            builderDestination.continueStraight(this.options.continueStraight());
        }
        MapplsDirectionManager.newInstance(builderDestination.build()).call(new a());
    }

    public RouteReportSummaryResponse getRouteReportSummaryResponse() {
        return this.routeReportSummaryResponse;
    }

    public void getRouteSummaryLiveData(String str) {
        this.routeReportSummaryResourceLiveData.postValue(new com.mappls.sdk.direction.ui.common.b<>(3, null, null));
        MapplsRouteSummaryManager.newInstance(MapplsRouteSummary.builder().baseUrl(this.options.routeReportSummaryBaseUrl()).routeId(str).isGroup(0).build()).call(new b());
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public String getSourceLocation() {
        return this.stopModels.get(0).getLocationType() == StopModel.TYPE_CURRENT_LOCATION ? "Your Current Location" : this.stopModels.get(0).getPlaceName();
    }

    public List<StopModel> getStopModels() {
        return this.stopModels;
    }

    public int getTheme() {
        return this.theme;
    }

    public void getTollCostLiveData(String str, int i, String str2, Integer num, Double d) {
        String str3;
        String str4;
        byte b2 = 3;
        this.costEstimationResponseLiveData.postValue(new com.mappls.sdk.direction.ui.common.b<>(3, null, null));
        MapplsCostEstimation.Builder builderRouteIndex = MapplsCostEstimation.builder().baseUrl(this.options.tripCostEstimationBaseUrl()).routeId(str).isTollEnabled(Boolean.TRUE).routeIndex(Integer.valueOf(i));
        if (str2 != null) {
            builderRouteIndex.vehicleFuelType(str2);
            str2.hashCode();
            switch (str2.hashCode()) {
                case -1331959846:
                    b2 = !str2.equals(CostEstimationCriteria.VEHICLE_FUEL_TYPE_DIESEL) ? (byte) -1 : (byte) 0;
                    break;
                case -991657904:
                    b2 = !str2.equals(CostEstimationCriteria.VEHICLE_FUEL_TYPE_PETROL) ? (byte) -1 : (byte) 1;
                    break;
                case -17124067:
                    b2 = !str2.equals(CostEstimationCriteria.VEHICLE_FUEL_TYPE_ELECTRIC) ? (byte) -1 : (byte) 2;
                    break;
                case 66876:
                    if (!str2.equals(CostEstimationCriteria.VEHICLE_FUEL_TYPE_CNG)) {
                        b2 = -1;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                case 1:
                    str4 = CostEstimationCriteria.UNIT_KM_P_L;
                    break;
                case 2:
                    str4 = CostEstimationCriteria.UNIT_KM_P_UNIT;
                    break;
                case 3:
                    str4 = CostEstimationCriteria.UNIT_KM_P_KG;
                    break;
            }
            builderRouteIndex.fuelEfficiencyUnit(str4);
        }
        if (num != null) {
            builderRouteIndex.fuelEfficiency(num);
        }
        if (d != null) {
            builderRouteIndex.fuelPrice(d);
        }
        if (this.profile.equalsIgnoreCase("driving")) {
            str3 = CostEstimationCriteria.VEHICLE_TYPE_AUTO;
        } else {
            if (!this.profile.equalsIgnoreCase("biking")) {
                if (this.profile.equalsIgnoreCase("trucking")) {
                    str3 = CostEstimationCriteria.VEHICLE_TYPE_TRUCK;
                }
                MapplsCostEstimationManager.newInstance(builderRouteIndex.build()).call(new c(i));
            }
            str3 = CostEstimationCriteria.VEHICLE_TYPE_MOTO;
        }
        builderRouteIndex.vehicleType(str3);
        MapplsCostEstimationManager.newInstance(builderRouteIndex.build()).call(new c(i));
    }

    public boolean isCurrentLocation() {
        return this.stopModels.get(0).getLocationType() == StopModel.TYPE_CURRENT_LOCATION && this.options.showStartNavigation().booleanValue();
    }

    public String setLocationText() {
        return (this.stopModels.get(0).getLocationType() == StopModel.TYPE_CURRENT_LOCATION && this.options.showStartNavigation().booleanValue()) ? "Start" : "Preview";
    }

    public void setRouteReportSummaryResponse(RouteReportSummaryResponse routeReportSummaryResponse) {
        this.routeReportSummaryResponse = routeReportSummaryResponse;
    }

    public void setSelectedIndex(int i) {
        this.selectedIndex = i;
    }

    public void setStopModels(List<StopModel> list) {
        this.stopModels = list;
    }

    public void setTheme(int i) {
        this.theme = i;
    }
}
