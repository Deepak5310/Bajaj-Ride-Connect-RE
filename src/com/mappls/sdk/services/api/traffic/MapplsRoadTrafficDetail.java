package com.mappls.sdk.services.api.traffic;

import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.traffic.model.TrafficRoadDetailResponse;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsRoadTrafficDetail extends MapplsService<TrafficRoadDetailResponse, TrafficRoadDetailService> {

    public static abstract class Builder {
        public abstract Builder baseUrl(String str);

        public abstract MapplsRoadTrafficDetail build();

        public abstract Builder latitude(Double d);

        public abstract Builder longitude(Double d);

        public abstract Builder radius(Long l);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract Double latitude();

    abstract Double longitude();

    abstract Long radius();

    public MapplsRoadTrafficDetail() {
        super(TrafficRoadDetailService.class);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<TrafficRoadDetailResponse> initializeCall() {
        return getLoginService(true).getCall(latitude(), longitude(), radius());
    }

    public static Builder builder() {
        return new AutoValue_MapplsRoadTrafficDetail.Builder().baseUrl(Constants.TRAFFIC_BASE_URL);
    }

    void enqueue(Callback<TrafficRoadDetailResponse> callback) {
        enqueueCall(callback);
    }

    Response<TrafficRoadDetailResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }
}
