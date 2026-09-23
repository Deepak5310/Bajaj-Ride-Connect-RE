package com.mappls.sdk.maps.promo;

import com.mappls.sdk.maps.promo.model.Promo;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.utils.Constants;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsPromo extends MapplsService<List<Promo>, PromoService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    public MapplsPromo() {
        super(PromoService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsPromo.Builder().baseUrl(Constants.ANCHOR_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<List<Promo>> initializeCall() {
        return getLoginService(true).getCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void enqueueCall(Callback<List<Promo>> callback) {
        super.enqueueCall(callback);
    }

    public static abstract class Builder {
        abstract MapplsPromo autoBuild();

        abstract Builder baseUrl(String str);

        public MapplsPromo build() throws ServicesException {
            return autoBuild();
        }
    }
}
