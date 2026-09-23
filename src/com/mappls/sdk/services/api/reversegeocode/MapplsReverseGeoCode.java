package com.mappls.sdk.services.api.reversegeocode;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.PlaceResponse;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsReverseGeoCode extends MapplsService<PlaceResponse, ReverseGeoCodeService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String lang();

    abstract double latitude();

    abstract double longitude();

    protected MapplsReverseGeoCode() {
        super(ReverseGeoCodeService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsReverseGeoCode.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<PlaceResponse> initializeCall() {
        return getLoginService(true).getCall(latitude(), longitude(), lang());
    }

    void enqueue(Callback<PlaceResponse> callback) {
        enqueueCall(callback);
    }

    Response<PlaceResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    public static abstract class Builder {
        private Double latitude;
        private Double longitude;

        abstract MapplsReverseGeoCode autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder lang(String str);

        abstract Builder latitude(double d);

        abstract Builder longitude(double d);

        public Builder setLocation(double d, double d2) {
            this.latitude = Double.valueOf(d);
            this.longitude = Double.valueOf(d2);
            return this;
        }

        public MapplsReverseGeoCode build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid Client ID API key.");
            }
            latitude(this.latitude.doubleValue());
            longitude(this.longitude.doubleValue());
            return autoBuild();
        }
    }
}
