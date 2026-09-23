package com.mappls.sdk.services.api.geocoding;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.GsonBuilder;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsGeoCoding extends MapplsService<GeoCodeResponse, GeoCodingService> {
    abstract String address();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract Integer bias();

    abstract String bound();

    abstract String clientAppName();

    abstract Integer itemCount();

    abstract String podFilter();

    abstract Boolean scores();

    protected MapplsGeoCoding() {
        super(GeoCodingService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsGeoCoding.Builder().baseUrl(Constants.ATLAS_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<GeoCodeResponse> initializeCall() {
        HashMap map = new HashMap();
        map.put(PlaceTypes.ADDRESS, address());
        if (itemCount() != null) {
            map.put("itemCount", itemCount());
        }
        if (bias() != null) {
            map.put("bias", bias());
        }
        if (podFilter() != null) {
            map.put("podFilter", podFilter());
        }
        if (bound() != null) {
            map.put("bound", bound());
        }
        if (scores() != null && scores().booleanValue()) {
            map.put("scores", scores());
        }
        return getLoginService(true).getCall(map);
    }

    void enqueue(Callback<GeoCodeResponse> callback) {
        enqueueCall(callback);
    }

    Response<GeoCodeResponse> execute() throws IOException {
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
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(GeoCodeResponse.class, new GeoCodeJsonDeserializer()).create();
        return gsonBuilder;
    }

    public static abstract class Builder {
        private String address;

        abstract Builder address(String str);

        abstract MapplsGeoCoding autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder bias(Integer num);

        public abstract Builder bound(String str);

        public abstract Builder clientAppName(String str);

        public abstract Builder itemCount(Integer num);

        public abstract Builder podFilter(String str);

        public abstract Builder scores(Boolean bool);

        public Builder setAddress(String str) {
            this.address = str;
            return this;
        }

        public MapplsGeoCoding build() throws ServicesException {
            if (MapplsUtils.isEmpty(this.address)) {
                throw new ServicesException("Please pass valid address");
            }
            address(this.address);
            return autoBuild();
        }
    }
}
