package com.mappls.sdk.geoanalytics.listing;

import com.mappls.sdk.geoanalytics.listing.model.GeoAnalyticsListResponse;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsGeoAnalyticsList extends MapplsService<GeoAnalyticsListResponse, b> {

    public static abstract class Builder {
        public abstract Builder api(String str);

        abstract Builder attributes(String str);

        public Builder attributes(String... strArr) {
            return attributes(MapplsUtils.join(",", strArr));
        }

        public abstract Builder baseUrl(String str);

        public abstract MapplsGeoAnalyticsList build();

        abstract Builder geoBound(String str);

        public Builder geoBound(String... strArr) {
            return geoBound(MapplsUtils.join(",", strArr));
        }

        public abstract Builder geoBoundType(String str);
    }

    public MapplsGeoAnalyticsList() {
        super(b.class);
    }

    public static Builder builder() {
        return new a.b().baseUrl(Constants.MGIS_APIS_BASE_URL);
    }

    abstract String api();

    abstract String attributes();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    void cancel() {
        cancelCall();
    }

    void enqueue(Callback<GeoAnalyticsListResponse> callback) {
        enqueueCall(callback);
    }

    Response<GeoAnalyticsListResponse> execute() {
        return super.executeCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    abstract String geoBound();

    abstract String geoBoundType();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<GeoAnalyticsListResponse> initializeCall() {
        return getLoginService(true).a(api(), geoBoundType(), geoBound(), attributes());
    }
}
