package com.mappls.sdk.services.api.event.nearby;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.event.nearby.model.NearbyReportResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyReport extends MapplsService<NearbyReportResponse, NearbyReportService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    protected abstract Double maxX();

    protected abstract Double maxY();

    protected abstract Double minX();

    protected abstract Double minY();

    protected MapplsNearbyReport() {
        super(NearbyReportService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsNearbyReport.Builder().baseUrl(Constants.EXPLORE_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<NearbyReportResponse> initializeCall() {
        return getLoginService(true).getCall(minX().doubleValue(), minY().doubleValue(), maxX().doubleValue(), maxY().doubleValue());
    }

    void enqueue(Callback<NearbyReportResponse> callback) {
        enqueueCall(callback);
    }

    Response<NearbyReportResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        Point bottomRight;
        Point topLeft;

        abstract MapplsNearbyReport autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder maxX(Double d);

        public abstract Builder maxY(Double d);

        public abstract Builder minX(Double d);

        public abstract Builder minY(Double d);

        public Builder topLeft(Point point) {
            this.topLeft = point;
            return this;
        }

        public Builder bottomRight(Point point) {
            this.bottomRight = point;
            return this;
        }

        public MapplsNearbyReport build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId()) && !MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientSecret())) {
                throw new ServicesException("Using Mappls Services requires setting a valid client_id and client_secret.");
            }
            Point point = this.topLeft;
            if (point == null) {
                throw new ServicesException("Please pass a valid top left coordinates.");
            }
            minX(Double.valueOf(point.longitude()));
            minY(Double.valueOf(this.topLeft.latitude()));
            Point point2 = this.bottomRight;
            if (point2 == null) {
                throw new ServicesException("Please pass a valid bottom right coordinates.");
            }
            maxX(Double.valueOf(point2.longitude()));
            maxY(Double.valueOf(this.bottomRight.latitude()));
            return autoBuild();
        }
    }
}
