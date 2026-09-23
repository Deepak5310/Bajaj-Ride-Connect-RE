package com.mappls.sdk.services.api.session.devicelist;

import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.session.devicelist.model.Device;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsClusterLinkedDevices extends MapplsService<List<Device>, DeviceListService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String clusterId();

    abstract String sessionType();

    public MapplsClusterLinkedDevices() {
        super(DeviceListService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsClusterLinkedDevices.Builder().baseUrl(Constants.OUTPOST_BASE_URL).sessionType("global");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<List<Device>> initializeCall() {
        return getLoginService(true).getCall(sessionType(), clusterId());
    }

    void enqueue(Callback<List<Device>> callback) {
        enqueueCall(callback);
    }

    Response<List<Device>> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        abstract MapplsClusterLinkedDevices autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder clusterId(String str);

        public abstract Builder sessionType(String str);

        public MapplsClusterLinkedDevices build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId()) && !MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientSecret())) {
                throw new ServicesException("Using Mappls Services requires setting a valid client_id and client_secret.");
            }
            return autoBuild();
        }
    }
}
