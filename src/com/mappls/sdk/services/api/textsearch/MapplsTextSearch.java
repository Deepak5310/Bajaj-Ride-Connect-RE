package com.mappls.sdk.services.api.textsearch;

import androidx.autofill.HintConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.autosuggest.model.AutoSuggestAtlasResponse;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsTextSearch extends MapplsService<AutoSuggestAtlasResponse, TextSearchService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract Boolean bridge();

    abstract Boolean explain();

    abstract String filter();

    abstract String location();

    abstract String queryString();

    abstract String username();

    public MapplsTextSearch() {
        super(TextSearchService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsTextSearch.Builder().baseUrl(Constants.ATLAS_BASE_URL);
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
        map.put(SearchIntents.EXTRA_QUERY, queryString());
        if (location() != null) {
            map.put(FirebaseAnalytics.Param.LOCATION, location());
        }
        if (explain() != null && explain().booleanValue()) {
            map.put("explain", explain());
        }
        if (bridge() != null && bridge().booleanValue()) {
            map.put("bridge", bridge());
        }
        if (username() != null) {
            map.put(HintConstants.AUTOFILL_HINT_USERNAME, username());
        }
        if (filter() != null) {
            map.put("filter", filter());
        }
        return map;
    }

    public static abstract class Builder {
        private Double latitude;
        private Double longitude;
        private String query;

        abstract MapplsTextSearch autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder bridge(Boolean bool);

        public abstract Builder explain(Boolean bool);

        public abstract Builder filter(String str);

        abstract Builder location(String str);

        abstract Builder queryString(String str);

        public abstract Builder username(String str);

        public Builder setLocation(Double d, Double d2) {
            this.latitude = d;
            this.longitude = d2;
            return this;
        }

        public Builder query(String str) {
            this.query = str;
            return this;
        }

        public MapplsTextSearch build() throws ServicesException {
            if (this.query == null) {
                throw new ServicesException("You should provide query");
            }
            if (this.latitude != null && this.longitude != null) {
                location(this.latitude + "," + this.longitude);
            }
            queryString(this.query);
            return autoBuild();
        }
    }
}
