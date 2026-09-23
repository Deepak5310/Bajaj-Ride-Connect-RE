package com.mappls.sdk.services.api;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public class SDKPreferenceHelper {
    private static final String API_DETAIL_KEY = "com.mappls.sdk.services.api.API_DETAIL_KEY";
    private static final String SDK_CONFIG_KEY = "com.mappls.sdk.services.api.SDK_CONFIG_KEY";
    private static final String SDK_CONFIG_LAST_DOWNLOAD_KEY = "com.mappls.sdk.services.api.SDK_CONFIG_LAST_DOWNLOAD_KEY";
    private static final String SHARED_PREFERENCE_FILE_NAME = "com.mappls.sdk.services.api.STORAGE_SHARED_PREFERENCE";
    private static SDKPreferenceHelper mSDKPreferenceHelper;
    private final SharedPreferences sharedPreferences;

    private SDKPreferenceHelper(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, 0);
    }

    public static SDKPreferenceHelper getInstance(Context context) {
        if (mSDKPreferenceHelper == null) {
            mSDKPreferenceHelper = new SDKPreferenceHelper(context);
        }
        return mSDKPreferenceHelper;
    }

    String getApiDetail() {
        return this.sharedPreferences.getString(API_DETAIL_KEY, null);
    }

    void clearApiDetail() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public void setApiDetail(String str) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(API_DETAIL_KEY, str);
        editorEdit.apply();
    }

    void setSDKConfigData(String str) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(SDK_CONFIG_KEY, str);
        editorEdit.apply();
    }

    String getSDKConfigData() {
        return this.sharedPreferences.getString(SDK_CONFIG_KEY, null);
    }

    void setSDKConfigDownloadTime(Long l) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putLong(SDK_CONFIG_LAST_DOWNLOAD_KEY, l.longValue());
        editorEdit.apply();
    }

    Long getSDKConfigDownloadTime() {
        return Long.valueOf(this.sharedPreferences.getLong(SDK_CONFIG_LAST_DOWNLOAD_KEY, 0L));
    }
}
