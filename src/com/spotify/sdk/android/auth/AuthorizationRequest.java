package com.spotify.sdk.android.auth;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AuthorizationRequest implements Parcelable {
    static final String ACCOUNTS_AUTHORITY = "accounts.spotify.com";
    static final String ACCOUNTS_PATH = "authorize";
    static final String ACCOUNTS_SCHEME = "https";
    static final String ANDROID_SDK = "android-sdk";
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new Parcelable.Creator<AuthorizationRequest>() { // from class: com.spotify.sdk.android.auth.AuthorizationRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthorizationRequest createFromParcel(Parcel parcel) {
            return new AuthorizationRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthorizationRequest[] newArray(int i) {
            return new AuthorizationRequest[i];
        }
    };
    static final String SCOPES_SEPARATOR = " ";
    static final String SPOTIFY_SDK = "spotify-sdk";
    private final String mCampaign;
    private final String mClientId;
    private final Map<String, String> mCustomParams;
    private final String mRedirectUri;
    private final String mResponseType;
    private final String[] mScopes;
    private final boolean mShowDialog;
    private final String mState;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static class Builder {
        private String mCampaign;
        private final String mClientId;
        private final Map<String, String> mCustomParams = new HashMap();
        private final String mRedirectUri;
        private final AuthorizationResponse.Type mResponseType;
        private String[] mScopes;
        private boolean mShowDialog;
        private String mState;

        public Builder(String str, AuthorizationResponse.Type type, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("Client ID can't be null");
            }
            if (type == null) {
                throw new IllegalArgumentException("Response type can't be null");
            }
            if (str2 == null || str2.length() == 0) {
                throw new IllegalArgumentException("Redirect URI can't be null or empty");
            }
            this.mClientId = str;
            this.mResponseType = type;
            this.mRedirectUri = str2;
        }

        public Builder setState(String str) {
            this.mState = str;
            return this;
        }

        public Builder setScopes(String[] strArr) {
            this.mScopes = strArr;
            return this;
        }

        public Builder setShowDialog(boolean z) {
            this.mShowDialog = z;
            return this;
        }

        public Builder setCustomParam(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("Custom parameter key can't be null or empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Custom parameter value can't be null or empty");
            }
            this.mCustomParams.put(str, str2);
            return this;
        }

        public Builder setCampaign(String str) {
            this.mCampaign = str;
            return this;
        }

        public AuthorizationRequest build() {
            return new AuthorizationRequest(this.mClientId, this.mResponseType, this.mRedirectUri, this.mState, this.mScopes, this.mShowDialog, this.mCustomParams, this.mCampaign);
        }
    }

    public AuthorizationRequest(Parcel parcel) {
        this.mClientId = parcel.readString();
        this.mResponseType = parcel.readString();
        this.mRedirectUri = parcel.readString();
        this.mState = parcel.readString();
        this.mScopes = parcel.createStringArray();
        this.mShowDialog = parcel.readByte() == 1;
        this.mCustomParams = new HashMap();
        this.mCampaign = parcel.readString();
        Bundle bundle = parcel.readBundle(getClass().getClassLoader());
        for (String str : bundle.keySet()) {
            this.mCustomParams.put(str, bundle.getString(str));
        }
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getResponseType() {
        return this.mResponseType;
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public String getState() {
        return this.mState;
    }

    public String[] getScopes() {
        return this.mScopes;
    }

    public String getCustomParam(String str) {
        return this.mCustomParams.get(str);
    }

    public String getCampaign() {
        return TextUtils.isEmpty(this.mCampaign) ? ANDROID_SDK : this.mCampaign;
    }

    private AuthorizationRequest(String str, AuthorizationResponse.Type type, String str2, String str3, String[] strArr, boolean z, Map<String, String> map, String str4) {
        this.mClientId = str;
        this.mResponseType = type.toString();
        this.mRedirectUri = str2;
        this.mState = str3;
        this.mScopes = strArr;
        this.mShowDialog = z;
        this.mCustomParams = map;
        this.mCampaign = str4;
    }

    public Uri toUri() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https").authority(ACCOUNTS_AUTHORITY).appendPath(ACCOUNTS_PATH).appendQueryParameter(AccountsQueryParameters.CLIENT_ID, this.mClientId).appendQueryParameter(AccountsQueryParameters.RESPONSE_TYPE, this.mResponseType).appendQueryParameter("redirect_uri", this.mRedirectUri).appendQueryParameter(AccountsQueryParameters.SHOW_DIALOG, String.valueOf(this.mShowDialog)).appendQueryParameter("utm_source", SPOTIFY_SDK).appendQueryParameter("utm_medium", ANDROID_SDK).appendQueryParameter("utm_campaign", getCampaign());
        String[] strArr = this.mScopes;
        if (strArr != null && strArr.length > 0) {
            builder.appendQueryParameter(AccountsQueryParameters.SCOPE, scopesToString());
        }
        String str = this.mState;
        if (str != null) {
            builder.appendQueryParameter("state", str);
        }
        if (this.mCustomParams.size() > 0) {
            for (Map.Entry<String, String> entry : this.mCustomParams.entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    private String scopesToString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.mScopes) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mClientId);
        parcel.writeString(this.mResponseType);
        parcel.writeString(this.mRedirectUri);
        parcel.writeString(this.mState);
        parcel.writeStringArray(this.mScopes);
        parcel.writeByte(this.mShowDialog ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mCampaign);
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : this.mCustomParams.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        parcel.writeBundle(bundle);
    }
}
