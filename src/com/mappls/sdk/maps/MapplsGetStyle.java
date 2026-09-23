package com.mappls.sdk.maps;

import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import retrofit2.Call;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes4.dex */
abstract class MapplsGetStyle extends MapplsService<GetStylesResponse, StyleService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    protected abstract String logoResolution();

    public MapplsGetStyle() {
        super(StyleService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsGetStyle.Builder().baseUrl("https://apis.mappls.com/advancedmaps/vapi/");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<GetStylesResponse> initializeCall() {
        return getLoginService(true).getStyles(logoResolution());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void enqueueCall(Callback<GetStylesResponse> callback) {
        super.enqueueCall(callback);
    }

    public static abstract class Builder {
        abstract MapplsGetStyle autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder logoResolution(String str);

        public MapplsGetStyle build() throws ServicesException {
            return autoBuild();
        }
    }
}
