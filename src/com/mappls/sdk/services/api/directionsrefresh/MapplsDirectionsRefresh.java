package com.mappls.sdk.services.api.directionsrefresh;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directionsrefresh.models.DirectionsRefreshAdapterFactory;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsDirectionsRefresh extends MapplsService<DirectionsRoute, DirectionsRefreshService> {
    private static final int ZERO = 0;

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String categories();

    abstract Boolean isNotify();

    abstract Boolean isRefresh();

    abstract Boolean isSort();

    abstract Long nodeIndex();

    abstract String profile();

    abstract String requestId();

    abstract Integer routeIndex();

    abstract String sessionId();

    abstract String sourceInternal();

    public abstract Builder toBuilder();

    abstract Integer tripType();

    protected MapplsDirectionsRefresh() {
        super(DirectionsRefreshService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsDirectionsRefresh.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL).profile("driving").routeIndex(0);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<DirectionsRoute> initializeCall() {
        return getLoginService(true).getCall(MapplsAccountManager.getInstance().getRestAPIKey(), profile(), requestId(), routeIndex(), isRefresh(), isNotify(), nodeIndex(), categories(), tripType(), sessionId(), isSort(), sourceInternal());
    }

    void enqueue(final Callback<DirectionsRoute> callback) {
        enqueueCall(new Callback<DirectionsRoute>() { // from class: com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.1
            @Override // retrofit2.Callback
            public void onResponse(Call<DirectionsRoute> call, Response<DirectionsRoute> response) {
                callback.onResponse(call, new DirectionsRefreshResponseFactory(MapplsDirectionsRefresh.this).generate(response));
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<DirectionsRoute> call, Throwable th) {
                callback.onFailure(call, th);
            }
        });
    }

    Response<DirectionsRoute> execute() throws IOException {
        return new DirectionsRefreshResponseFactory(this).generate(super.executeCall());
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return super.getGsonBuilder().registerTypeAdapterFactory(DirectionsRefreshAdapterFactory.create()).registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    }

    public static abstract class Builder {
        public abstract Builder baseUrl(String str);

        public abstract MapplsDirectionsRefresh build();

        public abstract Builder categories(String str);

        public abstract Builder isNotify(Boolean bool);

        public abstract Builder isRefresh(Boolean bool);

        public abstract Builder isSort(Boolean bool);

        public abstract Builder nodeIndex(Long l);

        public abstract Builder profile(String str);

        public abstract Builder requestId(String str);

        public abstract Builder routeIndex(Integer num);

        public abstract Builder sessionId(String str);

        abstract Builder sourceInternal(String str);

        public abstract Builder tripType(Integer num);

        public Builder source(Point point) {
            return sourceInternal(point.longitude() + "," + point.latitude());
        }
    }
}
