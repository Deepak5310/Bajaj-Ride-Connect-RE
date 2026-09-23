package com.mappls.sdk.services.api.autosuggest;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.GsonBuilder;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.autosuggest.model.AutoSuggestAtlasResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsAutoSuggest extends MapplsService<AutoSuggestAtlasResponse, AutoSuggestService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    public abstract String baseUrl();

    public abstract Boolean bridge();

    public abstract Boolean explain();

    public abstract String filter();

    public abstract Boolean hyperLocal();

    public abstract String internalQuery();

    public abstract Double internalZoom();

    public abstract String isPrimary();

    public abstract String location();

    public abstract String mapCentre();

    public abstract String pod();

    public abstract String responseLang();

    public abstract Boolean tokenizeAddress();

    public MapplsAutoSuggest() {
        super(AutoSuggestService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsAutoSuggest.Builder().baseUrl(Constants.ATLAS_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<AutoSuggestAtlasResponse> initializeCall() {
        return getLoginService(true).getCall(createRequest());
    }

    void enqueue(Callback<AutoSuggestAtlasResponse> callback) {
        enqueueCall(callback);
    }

    Response<AutoSuggestAtlasResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    private Map<String, Object> createRequest() {
        HashMap map = new HashMap();
        map.put(SearchIntents.EXTRA_QUERY, internalQuery());
        if (location() != null) {
            map.put(FirebaseAnalytics.Param.LOCATION, location());
        }
        if (internalZoom() != null) {
            map.put("zoom", internalZoom());
        }
        if (tokenizeAddress() != null && tokenizeAddress().booleanValue()) {
            map.put("tokenizeAddress", tokenizeAddress());
        }
        if (bridge() != null && bridge().booleanValue()) {
            map.put("bridge", bridge());
        }
        if (pod() != null) {
            map.put("pod", pod());
        }
        if (filter() != null) {
            map.put("filter", filter());
        }
        if (hyperLocal() != null && hyperLocal().booleanValue()) {
            map.put("hyperLocal", hyperLocal());
        }
        if (mapCentre() != null) {
            map.put("mapCentre", mapCentre());
        }
        if (isPrimary() != null) {
            map.put("isPrimary", isPrimary());
        }
        if (responseLang() != null) {
            map.put("responseLang", responseLang());
        }
        if (explain() != null && explain().booleanValue()) {
            map.put("explain", explain());
        }
        return map;
    }

    public static abstract class Builder {
        private Double latitude;
        private Double longitude;
        private String query;
        private Double zoom;

        abstract MapplsAutoSuggest autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder bridge(Boolean bool);

        public abstract Builder explain(Boolean bool);

        public abstract Builder filter(String str);

        public abstract Builder hyperLocal(Boolean bool);

        abstract Builder internalQuery(String str);

        abstract Builder internalZoom(Double d);

        public abstract Builder isPrimary(String str);

        abstract Builder location(String str);

        abstract Builder mapCentre(String str);

        public abstract Builder pod(String str);

        public abstract Builder responseLang(String str);

        public abstract Builder tokenizeAddress(Boolean bool);

        public Builder setLocation(Double d, Double d2) {
            this.latitude = d;
            this.longitude = d2;
            return this;
        }

        public Builder setMapCentre(Double d, Double d2) {
            return mapCentre(d + "," + d2);
        }

        public Builder query(String str) {
            this.query = str;
            return this;
        }

        public Builder zoom(Double d) {
            this.zoom = d;
            return this;
        }

        public MapplsAutoSuggest build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid keys.");
            }
            if (this.query == null) {
                throw new ServicesException("You should provide query");
            }
            if (this.latitude != null && this.longitude != null) {
                location(this.latitude + "," + this.longitude);
            }
            internalQuery(this.query);
            Double d = this.zoom;
            if (d != null && d.doubleValue() >= 4.0d) {
                internalZoom(this.zoom);
            }
            return autoBuild();
        }
    }
}
