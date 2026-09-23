package com.mappls.sdk.services.account;

import android.content.Context;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.services.BuildConfig;
import com.mappls.sdk.services.api.ITokenRepo;
import com.mappls.sdk.services.api.MapplsApiConfiguration;
import com.mappls.sdk.services.utils.MapplsUtils;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsAccountManager {
    private static final MapplsAccountManager ourInstance = new MapplsAccountManager();
    private String associationId;
    private String atlasClientId;
    private String atlasClientSecret;
    private String clusterId;
    private String deviceAlias;
    private String mapSDKKey;
    private String restAPIKey;
    private String userId;
    private String accessToken = null;
    private String refreshToken = null;
    private String region = null;
    private boolean disableHostnameVerifier = false;

    private MapplsAccountManager() {
    }

    public static MapplsAccountManager getInstance() {
        return ourInstance;
    }

    public void init(Context context) {
        MapplsUtils.setSDKContext(context);
        if (!MapplsLMSManager.isInitialised()) {
            MapplsLMSManager.initialize(context);
        }
        MapplsLMSManager.getInstance().setRestApiVersion(BuildConfig.VERSION_NAME);
    }

    public String getRestAPIKey() {
        return this.restAPIKey;
    }

    public void setRestAPIKey(String str) {
        this.restAPIKey = str;
    }

    public String getMapSDKKey() {
        return this.mapSDKKey;
    }

    public void setMapSDKKey(String str) {
        this.mapSDKKey = str;
    }

    public String getAtlasClientId() {
        return this.atlasClientId;
    }

    public void setAtlasClientId(String str) {
        this.atlasClientId = str;
    }

    public String getAtlasClientSecret() {
        return this.atlasClientSecret;
    }

    public void setAtlasClientSecret(String str) {
        this.atlasClientSecret = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String str, String str2) {
        this.refreshToken = str;
        this.accessToken = str2;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public String getDeviceAlias() {
        return this.deviceAlias;
    }

    public String getClusterId() {
        return this.clusterId;
    }

    public void setClusterId(String str) {
        this.clusterId = str;
        MapplsApiConfiguration.getInstance().init();
    }

    public void setClusterId(String str, String str2) {
        this.clusterId = str;
        this.deviceAlias = str2;
        MapplsApiConfiguration.getInstance().init();
    }

    public void setCustomTokenRepo(ITokenRepo iTokenRepo) {
        MapplsApiConfiguration.getInstance().setCustomTokenRepo(iTokenRepo);
    }

    public String getAssociationId() {
        return this.associationId;
    }

    public void setAssociationId(String str) {
        this.associationId = str;
    }

    public void setProxy(String str, int i) {
        MapplsApiConfiguration.getInstance().setProxy(str, Integer.valueOf(i));
    }

    public boolean isDisableHostnameVerifier() {
        return this.disableHostnameVerifier;
    }

    public void setDisableHostnameVerifier(boolean z) {
        this.disableHostnameVerifier = z;
    }
}
