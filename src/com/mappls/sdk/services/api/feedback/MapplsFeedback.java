package com.mappls.sdk.services.api.feedback;

import androidx.autofill.HintConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsFeedback extends MapplsService<Void, FeedbackService> {
    protected abstract String appVersion();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    protected abstract Integer index();

    protected abstract Double latitude();

    protected abstract String locationName();

    protected abstract Double longitude();

    protected abstract String mapplsPin();

    protected abstract String typedKeyword();

    protected abstract String userName();

    public MapplsFeedback() {
        super(FeedbackService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsFeedback.Builder().baseUrl(Constants.ATLAS_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<Void> initializeCall() {
        return getLoginService(true).getCall(createRequest());
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

    private HashMap<String, String> createRequest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("typedKeyword", typedKeyword());
        map.put("selectedEloc", mapplsPin());
        map.put("selectedLocationName", locationName());
        map.put("apiVersion", "versionless");
        map.put("selectedIndex", String.valueOf(index()));
        map.put(HintConstants.AUTOFILL_HINT_USERNAME, userName());
        map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, appVersion());
        if (latitude() != null) {
            map.put("latitude", String.valueOf(latitude()));
        }
        if (longitude() != null) {
            map.put("longitude", String.valueOf(longitude()));
        }
        return map;
    }

    public static abstract class Builder {
        public abstract Builder appVersion(String str);

        abstract MapplsFeedback autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder index(Integer num);

        public abstract Builder latitude(Double d);

        public abstract Builder locationName(String str);

        public abstract Builder longitude(Double d);

        public abstract Builder mapplsPin(String str);

        public abstract Builder typedKeyword(String str);

        public abstract Builder userName(String str);

        public MapplsFeedback build() {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid rest API key.");
            }
            return autoBuild();
        }
    }
}
