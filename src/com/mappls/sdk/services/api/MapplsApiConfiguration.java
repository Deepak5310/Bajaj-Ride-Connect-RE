package com.mappls.sdk.services.api;

import android.location.Location;
import com.google.gson.Gson;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.services.api.sdkconfig.ServerInfo;
import com.mappls.sdk.services.api.sdkconfig.UrlData;
import com.mappls.sdk.services.api.utils.EncryptionUtility;
import com.mappls.sdk.services.utils.Constants;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsApiConfiguration extends BaseApiConfiguration {
    private static final MapplsApiConfiguration OUR_INSTANCE = new MapplsApiConfiguration();
    private List<String> certificateHash;
    private Long expiry;
    private UrlData urlData;

    private MapplsApiConfiguration() {
    }

    public static MapplsApiConfiguration getInstance() {
        return OUR_INSTANCE;
    }

    public void init() {
        this.isLoginRequired = null;
    }

    Boolean isLoginRequired() {
        return this.isLoginRequired;
    }

    String getPublicKey() {
        return this.publicKey;
    }

    void setPublicKey(String str) {
        this.publicKey = str;
    }

    long getPublicKeyExpirationTime() {
        return this.publicKeyExpirationTime;
    }

    void setPublicKeyExpirationTime(long j) {
        this.publicKeyExpirationTime = j;
    }

    public ITokenRepo getTokenRepo() {
        return this.iTokenRepo;
    }

    public void setCustomTokenRepo(ITokenRepo iTokenRepo) {
        this.iTokenRepo = iTokenRepo;
    }

    Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    boolean isNavigating() {
        return this.isNavigating;
    }

    public void setNavigating(boolean z) {
        this.isNavigating = z;
    }

    public void setProxy(String str, Integer num) {
        this.proxyHost = str;
        this.proxyPort = num;
        MapplsService.initProxy();
        if (MapplsLMSManager.isInitialised()) {
            MapplsLMSManager.getInstance().setProxy(str, num);
        }
    }

    public void setTimeOut(int i) {
        this.timeOut = i;
        MapplsService.initTimeOut();
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public int getProxyPort() {
        return this.proxyPort.intValue();
    }

    public void setValidationData(String str) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (str == null) {
            this.urlData = null;
            this.certificateHash = null;
            this.expiry = null;
            return;
        }
        ServerInfo serverInfo = (ServerInfo) new Gson().fromJson(EncryptionUtility.decryptData(str), ServerInfo.class);
        if (serverInfo != null) {
            UrlData urlData = serverInfo.getUrlData();
            this.urlData = urlData;
            if (urlData != null && urlData.getLmsUrl() != null && MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().setBaseUrl(this.urlData.getLmsUrl());
            }
            this.certificateHash = serverInfo.getCh();
            this.expiry = serverInfo.getExpiry();
        }
    }

    public UrlData getUrlData() {
        return this.urlData;
    }

    List<String> getCertificateHash() {
        return this.certificateHash;
    }

    Long getExpiry() {
        return this.expiry;
    }

    public String getMGISUrl() {
        UrlData urlData = this.urlData;
        if (urlData != null && urlData.getMgisUrl() != null) {
            return this.urlData.getMgisUrl();
        }
        return Constants.MGIS_BASE_URL;
    }

    public String getMGISApiUrl() {
        UrlData urlData = this.urlData;
        if (urlData != null && urlData.getMgisApiUrl() != null) {
            return this.urlData.getMgisApiUrl();
        }
        return Constants.MGIS_APIS_BASE_URL;
    }

    public String getGeoanalyticsUrl() {
        UrlData urlData = this.urlData;
        if (urlData != null && urlData.getGeoanalyticsUrl() != null) {
            return this.urlData.getGeoanalyticsUrl();
        }
        return Constants.GEOANALYTICS_BASE_URL;
    }

    public String getBackendUrl() {
        UrlData urlData = this.urlData;
        if (urlData != null && urlData.getBackendUrl() != null) {
            return this.urlData.getBackendUrl();
        }
        return Constants.BACKEND_API_BASE_URL;
    }
}
