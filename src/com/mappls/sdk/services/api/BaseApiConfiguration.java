package com.mappls.sdk.services.api;

import android.location.Location;

/* JADX INFO: loaded from: classes4.dex */
public class BaseApiConfiguration {
    Boolean clusterId;
    Boolean deviceFingerPrint;
    Boolean isLoginRequired;
    Location location;
    String proxyHost;
    Integer proxyPort;
    String publicKey;
    long publicKeyExpirationTime;
    Boolean userId;
    Boolean vin;
    Boolean xDh;
    Boolean xMsSeh;
    ITokenRepo iTokenRepo = new DefaultTokenRepo();
    boolean isNavigating = false;
    int timeOut = 20;
}
