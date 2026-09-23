package com.mappls.sdk.services.api.geolocation;

import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.geolocation.model.GeolocationResponse;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsGeolocation extends MapplsService<GeolocationResponse, GeolocationService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    protected abstract List<GeolocationRequest> cellTowers();

    abstract String radioType();

    public MapplsGeolocation() {
        super(GeolocationService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsGeolocation.Builder().baseUrl(Constants.ATLAS_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<GeolocationResponse> initializeCall() {
        return getLoginService(true).getCall(createRequest());
    }

    private Map createRequest() {
        HashMap map = new HashMap();
        map.put("cellTowers", cellTowers());
        if (radioType() != null) {
            map.put("radioType", radioType());
        }
        return map;
    }

    void enqueue(Callback<GeolocationResponse> callback) {
        super.enqueueCall(callback);
    }

    Response<GeolocationResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        List<GeolocationRequest> geolocationRequests = new ArrayList();

        abstract MapplsGeolocation autoBuild();

        public abstract Builder baseUrl(String str);

        abstract Builder cellTowers(List<GeolocationRequest> list);

        public abstract Builder radioType(String str);

        public Builder addCellTower(Integer num, Integer num2, Integer num3, Integer num4) {
            this.geolocationRequests.add(new GeolocationRequest(num, num2, num3, num4, null));
            return this;
        }

        public Builder addCellTowerWithRadioCellId(Integer num, Integer num2, Integer num3, Integer num4) {
            this.geolocationRequests.add(new GeolocationRequest(null, num2, num3, num4, num));
            return this;
        }

        public MapplsGeolocation build() throws ServicesException {
            if (this.geolocationRequests.size() == 0) {
                throw new ServicesException("Please provide atleast one tower detail");
            }
            cellTowers(this.geolocationRequests);
            return autoBuild();
        }
    }
}
