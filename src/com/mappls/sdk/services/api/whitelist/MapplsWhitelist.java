package com.mappls.sdk.services.api.whitelist;

import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.auth.model.AtlasAuthToken;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.Utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsWhitelist extends MapplsService<AtlasAuthToken, WhiteListService> {

    public static abstract class Builder {
        abstract Builder baseUrl(String str);

        public abstract MapplsWhitelist build();

        public abstract Builder otp(String str);

        public abstract Builder refLocation(String str);

        public abstract Builder userHandle(String str);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String otp();

    abstract String refLocation();

    abstract String userHandle();

    public MapplsWhitelist() {
        super(WhiteListService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsWhitelist.Builder().baseUrl(Constants.OUTPOST_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<AtlasAuthToken> initializeCall() {
        return getService(false).getCall(createRequest());
    }

    private Map<String, String> createRequest() {
        HashMap map = new HashMap();
        map.put("clientId", MapplsAccountManager.getInstance().getAtlasClientId());
        map.put("refLocation", refLocation());
        map.put("userHandle", userHandle());
        map.put("passPhrase", Utils.sha256(Utils.encode(otp())));
        return map;
    }

    void enqueue(Callback<AtlasAuthToken> callback) {
        enqueueCall(callback);
    }

    Response<AtlasAuthToken> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }
}
