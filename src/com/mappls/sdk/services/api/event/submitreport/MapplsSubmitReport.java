package com.mappls.sdk.services.api.event.submitreport;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsSubmitReport extends MapplsService<Void, SubmitReportService> {
    abstract Integer accuracy();

    abstract Double altitude();

    abstract String appVersion();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract Integer bearing();

    abstract Integer childCategory();

    abstract String description();

    abstract String deviceName();

    abstract Long expiry();

    abstract Integer flag();

    abstract Double internalLatitude();

    abstract Double internalLongitude();

    abstract String internalMapplsPin();

    abstract String osVersion();

    abstract Integer parentCategory();

    abstract String placeName();

    abstract String quality();

    abstract String speed();

    abstract Integer subChildCategory();

    abstract Long utc();

    abstract String zeroId();

    protected MapplsSubmitReport() {
        super(SubmitReportService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsSubmitReport.Builder().baseUrl(Constants.EXPLORE_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<Void> initializeCall() {
        return getLoginService(true).getCall(createRequest());
    }

    private Map<String, Object> createRequest() {
        HashMap map = new HashMap();
        map.put("placeName", placeName());
        map.put("eloc", internalMapplsPin());
        map.put("latitude", internalLatitude());
        map.put("longitude", internalLongitude());
        map.put("parentCategory", parentCategory());
        map.put("childCategory", childCategory());
        map.put(SavingTrackHelper.POINT_COL_DESCRIPTION, description());
        map.put("subChildCategory", subChildCategory());
        map.put("bearing", bearing());
        map.put("accuracy", accuracy());
        map.put("speed", speed());
        map.put("flag", flag());
        map.put("alt", altitude());
        map.put("quality", quality());
        map.put("utc", utc());
        map.put("expiry", expiry());
        map.put("zeroId", zeroId());
        map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, appVersion());
        map.put("osVersionoptional", osVersion());
        map.put("deviceName", deviceName());
        return map;
    }

    void enqueue(Callback<Void> callback) {
        enqueueCall(callback);
    }

    Response<Void> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        private Double latitude;
        private Double longitude;
        private String mapplsPin;

        public abstract Builder accuracy(Integer num);

        public abstract Builder altitude(Double d);

        public abstract Builder appVersion(String str);

        abstract MapplsSubmitReport autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder bearing(Integer num);

        public abstract Builder childCategory(Integer num);

        public abstract Builder description(String str);

        public abstract Builder deviceName(String str);

        public abstract Builder expiry(Long l);

        public abstract Builder flag(Integer num);

        abstract Builder internalLatitude(Double d);

        abstract Builder internalLongitude(Double d);

        abstract Builder internalMapplsPin(String str);

        public abstract Builder osVersion(String str);

        public abstract Builder parentCategory(Integer num);

        public abstract Builder placeName(String str);

        public abstract Builder quality(String str);

        public abstract Builder speed(String str);

        public abstract Builder subChildCategory(Integer num);

        public abstract Builder utc(Long l);

        public abstract Builder zeroId(String str);

        public Builder mapplsPin(String str) {
            this.mapplsPin = str;
            return this;
        }

        public Builder latitude(Double d) {
            this.latitude = d;
            return this;
        }

        public Builder longitude(Double d) {
            this.longitude = d;
            return this;
        }

        public MapplsSubmitReport build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId()) && !MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientSecret())) {
                throw new ServicesException("Using Mappls Services requires setting a valid client_id and client_secret.");
            }
            if (this.mapplsPin == null && this.latitude == null) {
                throw new ServicesException("Please pass either mappls pin or Latitude and longitude");
            }
            internalLatitude(this.latitude);
            internalLongitude(this.longitude);
            internalMapplsPin(this.mapplsPin);
            return autoBuild();
        }
    }
}
