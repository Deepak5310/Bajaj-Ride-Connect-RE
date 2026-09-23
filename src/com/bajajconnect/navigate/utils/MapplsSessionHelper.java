package com.bajajconnect.navigate.utils;

import com.bajajconnect.BuildConfig;
import com.mappls.sdk.services.account.MapplsAccountManager;

/* JADX INFO: loaded from: classes3.dex */
public final class MapplsSessionHelper {
    private MapplsSessionHelper() {
    }

    public static void applyBuildConfigCredentials() {
        MapplsAccountManager.getInstance().setRestAPIKey("b1307a05531ee9af4a58eb0b5d0674ef");
        MapplsAccountManager.getInstance().setMapSDKKey("b1307a05531ee9af4a58eb0b5d0674ef");
        MapplsAccountManager.getInstance().setAtlasClientId(BuildConfig.MAPPLS_CLIENT_ID);
        MapplsAccountManager.getInstance().setAtlasClientSecret(BuildConfig.MAPPLS_CLIENT_SECRET_ID);
    }
}
