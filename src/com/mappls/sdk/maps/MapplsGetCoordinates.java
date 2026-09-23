package com.mappls.sdk.maps;

import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes4.dex */
abstract class MapplsGetCoordinates extends MapplsService<CoordinateResponse, GetCoordinatesService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String formattedMapplsPin();

    public MapplsGetCoordinates() {
        super(GetCoordinatesService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsGetCoordinates.Builder().baseUrl(Constants.EXPLORE_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<CoordinateResponse> initializeCall() {
        return getService(true).getCall(formattedMapplsPin());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void enqueueCall(Callback<CoordinateResponse> callback) {
        super.enqueueCall(callback);
    }

    public static abstract class Builder {
        private List<String> mapplsPinList = new ArrayList();

        abstract MapplsGetCoordinates autoBuild();

        public abstract Builder baseUrl(String str);

        abstract Builder formattedMapplsPin(String str);

        public Builder mapplsPin(String str) {
            this.mapplsPinList.add(str);
            return this;
        }

        public Builder mapplsPin(List<String> list) {
            this.mapplsPinList.addAll(list);
            return this;
        }

        public MapplsGetCoordinates build() {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getRestAPIKey())) {
                throw new ServicesException("Using Mappls Services requires setting a valid rest API key.");
            }
            List<String> list = this.mapplsPinList;
            if (list == null || list.size() == 0) {
                throw new ServicesException("At least one mappls id must be provided with your API request.");
            }
            formattedMapplsPin(MapplsUtils.join(",", this.mapplsPinList.toArray()));
            return autoBuild();
        }
    }
}
