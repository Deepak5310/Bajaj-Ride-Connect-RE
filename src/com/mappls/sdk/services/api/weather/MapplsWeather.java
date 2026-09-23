package com.mappls.sdk.services.api.weather;

import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.google.gson.GsonBuilder;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.weather.model.WeatherResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsWeather extends MapplsService<WeatherResponse, WeatherService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract Double latitude();

    abstract Double longitude();

    abstract String size();

    abstract String tempUnit();

    abstract String theme();

    abstract Integer unit();

    abstract String unitType();

    public MapplsWeather() {
        super(WeatherService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsWeather.Builder().baseUrl(Constants.EXPLORE_BASE_URL).theme(WeatherCriteria.THEME_LIGHT).size("36px");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<WeatherResponse> initializeCall() {
        return getLoginService(true).getCall(createRequest());
    }

    Response<WeatherResponse> execute() throws IOException {
        return executeCall();
    }

    void enqueue(Callback<WeatherResponse> callback) {
        super.enqueueCall(callback);
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected void cancelCall() {
        super.cancelCall();
    }

    private Map<String, Object> createRequest() {
        HashMap map = new HashMap();
        map.put("latitude", latitude());
        map.put("longitude", longitude());
        map.put("density", "drawable-" + MapplsUtils.getDensityName());
        map.put("platform", SystemMediaRouteProvider.PACKAGE_NAME);
        map.put("theme", theme());
        map.put("size", size());
        if (tempUnit() != null) {
            map.put("tempUnit", tempUnit());
        }
        if (unitType() != null) {
            map.put("unitType", unitType());
        }
        if (unit() != null) {
            map.put("unit", unit());
        }
        return map;
    }

    public static abstract class Builder {
        abstract MapplsWeather autoBuild();

        public abstract Builder baseUrl(String str);

        abstract Builder latitude(Double d);

        abstract Builder longitude(Double d);

        public abstract Builder size(String str);

        public abstract Builder tempUnit(String str);

        public abstract Builder theme(String str);

        public abstract Builder unit(Integer num);

        public abstract Builder unitType(String str);

        public Builder location(Double d, Double d2) {
            return latitude(d).longitude(d2);
        }

        public MapplsWeather build() {
            if (MapplsUtils.isEmpty(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid Rest API Key.");
            }
            return autoBuild();
        }
    }
}
