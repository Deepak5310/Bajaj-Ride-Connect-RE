package com.mappls.sdk.services.api;

import com.mappls.sdk.services.utils.MapplsUtils;

/* JADX INFO: loaded from: classes4.dex */
class DefaultTokenRepo implements ITokenRepo {
    DefaultTokenRepo() {
    }

    @Override // com.mappls.sdk.services.api.ITokenRepo
    public String getToken() {
        return SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).getApiDetail();
    }

    @Override // com.mappls.sdk.services.api.ITokenRepo
    public void setToken(String str) {
        SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setApiDetail(str);
    }

    @Override // com.mappls.sdk.services.api.ITokenRepo
    public void clearToken() {
        SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).clearApiDetail();
    }
}
