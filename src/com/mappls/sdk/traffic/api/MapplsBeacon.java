package com.mappls.sdk.traffic.api;

import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import com.mappls.sdk.traffic.model.BeaconPacket;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsBeacon extends MapplsService<ResponseBody, b> {

    public static abstract class Builder {
        abstract MapplsBeacon autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder beaconKey(String str);

        public abstract Builder beaconPacket(BeaconPacket beaconPacket);

        public MapplsBeacon build() {
            if (MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                return autoBuild();
            }
            throw new ServicesException("Using Mappls Services requires setting a valid keys.");
        }
    }

    public MapplsBeacon() {
        super(b.class);
    }

    public static Builder c() {
        return new a.C0117a().baseUrl(Constants.TRAFFIC_BASE_URL);
    }

    abstract String a();

    abstract BeaconPacket b();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    @Override // com.mappls.sdk.services.api.MapplsService
    public final void enqueueCall(Callback<ResponseBody> callback) {
        super.enqueueCall(callback);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public final Response<ResponseBody> executeCall() {
        return super.executeCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected final Call<ResponseBody> initializeCall() {
        return getService(false).a(a(), b());
    }
}
