package com.mappls.sdk.services.api.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.spotify.sdk.android.auth.AccountsQueryParameters;

/* JADX INFO: loaded from: classes4.dex */
public class AtlasAuthToken {

    @SerializedName(AccountsQueryParameters.ACCESS_TOKEN)
    @Expose
    public String accessToken;

    @SerializedName(AccountsQueryParameters.CLIENT_ID)
    @Expose
    public String clientId;

    @SerializedName(AccountsQueryParameters.EXPIRES_IN)
    @Expose
    public long expiresIn;

    @SerializedName("project_code")
    @Expose
    public String projectCode;

    @SerializedName("refresh_token")
    @Expose
    public String refreshToken;

    @SerializedName(AccountsQueryParameters.SCOPE)
    @Expose
    public String scope;

    @SerializedName("token_type")
    @Expose
    public String tokenType;

    @SerializedName("user_name")
    @Expose
    public String userId;

    public String getTokenType() {
        return this.tokenType;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getScope() {
        return this.scope;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getProjectCode() {
        return this.projectCode;
    }
}
