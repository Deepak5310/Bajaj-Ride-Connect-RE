package com.mappls.sdk.services.api.event.route;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.event.route.model.RouteReportSummaryResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsRouteSummary extends MapplsService<RouteReportSummaryResponse, RouteSummaryService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    protected abstract String currentNode();

    protected abstract String internalCategories();

    protected abstract Integer isGroup();

    protected abstract String routeId();

    protected abstract Integer routeIdx();

    protected abstract String screenName();

    protected MapplsRouteSummary() {
        super(RouteSummaryService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsRouteSummary.Builder().baseUrl(Constants.EXPLORE_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<RouteReportSummaryResponse> initializeCall() {
        return getLoginService(true).getCall(routeId(), routeIdx(), currentNode(), isGroup(), internalCategories(), screenName());
    }

    void enqueue(Callback<RouteReportSummaryResponse> callback) {
        enqueueCall(callback);
    }

    Response<RouteReportSummaryResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        abstract MapplsRouteSummary autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder currentNode(String str);

        abstract Builder internalCategories(String str);

        public abstract Builder isGroup(Integer num);

        public abstract Builder routeId(String str);

        public abstract Builder routeIdx(Integer num);

        public abstract Builder screenName(String str);

        public Builder categories(String... strArr) {
            return internalCategories(MapplsUtils.join(",", strArr));
        }

        public MapplsRouteSummary build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId()) && !MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientSecret())) {
                throw new ServicesException("Using Mappls Services requires setting a valid client_id and client_secret.");
            }
            return autoBuild();
        }
    }
}
