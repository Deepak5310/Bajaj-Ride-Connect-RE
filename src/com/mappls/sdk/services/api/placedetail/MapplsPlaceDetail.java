package com.mappls.sdk.services.api.placedetail;

import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.placedetail.model.PlaceDetailResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsPlaceDetail extends MapplsService<PlaceDetailResponse, PlaceDetailService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String mapplsPin();

    public MapplsPlaceDetail() {
        super(PlaceDetailService.class);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<PlaceDetailResponse> initializeCall() {
        return getLoginService(true).getCall(mapplsPin());
    }

    public static Builder builder() {
        return new AutoValue_MapplsPlaceDetail.Builder().baseUrl(Constants.EXPLORE_BASE_URL);
    }

    void enqueue(Callback<PlaceDetailResponse> callback) {
        enqueueCall(callback);
    }

    Response<PlaceDetailResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        abstract MapplsPlaceDetail autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder mapplsPin(String str);

        public MapplsPlaceDetail build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid rest API key.");
            }
            return autoBuild();
        }
    }
}
