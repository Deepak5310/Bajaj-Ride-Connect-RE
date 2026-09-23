package com.mappls.sdk.services.api.alongroute;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.alongroute.models.POIAlongRouteResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsPOIAlongRoute extends MapplsService<POIAlongRouteResponse, POIAlongRouteService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract Integer buffer();

    abstract String category();

    abstract String filter();

    abstract String geometries();

    abstract Integer page();

    abstract String path();

    abstract Boolean sort();

    public MapplsPOIAlongRoute() {
        super(POIAlongRouteService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsPOIAlongRoute.Builder().baseUrl(Constants.ATLAS_BASE_URL).geometries("polyline6");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<POIAlongRouteResponse> initializeCall() {
        return getLoginService(true).getCall(createRequest());
    }

    void enqueue(Callback<POIAlongRouteResponse> callback) {
        enqueueCall(callback);
    }

    Response<POIAlongRouteResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    private HashMap<String, Object> createRequest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, path());
        map.put(SavingTrackHelper.POINT_COL_CATEGORY, category());
        if (buffer() != null) {
            map.put("buffer", buffer());
        }
        if (page() != null) {
            map.put("page", page());
        }
        if (geometries() != null) {
            map.put("geometries", geometries());
        }
        if (sort() != null) {
            map.put(com.facebook.hermes.intl.Constants.SORT, sort());
        }
        if (filter() != null) {
            map.put("filter", filter());
        }
        return map;
    }

    public static abstract class Builder {
        abstract MapplsPOIAlongRoute autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder buffer(Integer num);

        public abstract Builder category(String str);

        public abstract Builder filter(String str);

        public abstract Builder geometries(String str);

        public abstract Builder page(Integer num);

        public abstract Builder path(String str);

        public abstract Builder sort(Boolean bool);

        public MapplsPOIAlongRoute build() {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid keys.");
            }
            return autoBuild();
        }
    }
}
