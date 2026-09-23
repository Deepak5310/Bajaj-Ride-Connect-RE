package com.mappls.sdk.services.api.nearby;

import androidx.autofill.HintConstants;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearby extends MapplsService<NearbyAtlasResponse, NearbyService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    public abstract String baseUrl();

    public abstract String bounds();

    public abstract Boolean explain();

    public abstract String filter();

    public abstract Boolean ignoreAutoExpand();

    public abstract String internalIncludes();

    public abstract Integer itemCount();

    public abstract String keywordString();

    public abstract String location();

    public abstract Integer page();

    public abstract String pod();

    public abstract Integer radius();

    public abstract Boolean richData();

    public abstract String searchBy();

    public abstract String sortBy();

    public abstract String userName();

    public MapplsNearby() {
        super(NearbyService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsNearby.Builder().baseUrl(Constants.ATLAS_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<NearbyAtlasResponse> initializeCall() {
        return getLoginService(true).getCall(createRequest());
    }

    private Map<String, Object> createRequest() {
        HashMap map = new HashMap();
        map.put("keywords", keywordString());
        map.put("refLocation", location());
        if (page() != null) {
            map.put("page", page());
        }
        if (explain() != null && explain().booleanValue()) {
            map.put("explain", explain());
        }
        if (richData() != null && richData().booleanValue()) {
            map.put("richData", richData());
        }
        if (sortBy() != null) {
            map.put("sortBy", sortBy());
        }
        if (filter() != null) {
            map.put("filter", filter());
        }
        if (searchBy() != null) {
            map.put("searchBy", searchBy());
        }
        if (radius() != null) {
            map.put("radius", radius());
        }
        if (bounds() != null) {
            map.put("bounds", bounds());
        }
        if (pod() != null) {
            map.put("pod", pod());
        }
        if (userName() != null) {
            map.put(HintConstants.AUTOFILL_HINT_USERNAME, userName());
        }
        if (ignoreAutoExpand() != null) {
            map.put("ignoreAutoExpand", ignoreAutoExpand());
        }
        if (internalIncludes() != null) {
            map.put("includes", internalIncludes());
        }
        if (itemCount() != null) {
            map.put("itemCount", itemCount());
        }
        return map;
    }

    void enqueue(Callback<NearbyAtlasResponse> callback) {
        enqueueCall(callback);
    }

    Response<NearbyAtlasResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        private String keyword;
        private String location;

        abstract MapplsNearby autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder bounds(String str);

        public abstract Builder explain(Boolean bool);

        public abstract Builder filter(String str);

        public abstract Builder ignoreAutoExpand(Boolean bool);

        abstract Builder internalIncludes(String str);

        public abstract Builder itemCount(Integer num);

        abstract Builder keywordString(String str);

        abstract Builder location(String str);

        public abstract Builder page(Integer num);

        public abstract Builder pod(String str);

        public abstract Builder radius(Integer num);

        public abstract Builder richData(Boolean bool);

        public abstract Builder searchBy(String str);

        public abstract Builder sortBy(String str);

        public abstract Builder userName(String str);

        public Builder setLocation(Double d, Double d2) {
            if (d != null && d2 != null) {
                this.location = d + "," + d2;
            }
            return this;
        }

        public Builder setLocation(String str) {
            this.location = str;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder includes(String... strArr) {
            return internalIncludes(MapplsUtils.join(",", strArr));
        }

        public MapplsNearby build() throws ServicesException {
            if (this.keyword == null) {
                throw new ServicesException("You should provide keyword");
            }
            String str = this.location;
            if (str != null) {
                location(str);
            }
            keywordString(this.keyword);
            return autoBuild();
        }
    }
}
