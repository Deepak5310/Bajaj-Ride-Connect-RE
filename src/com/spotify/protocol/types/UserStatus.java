package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.spotify.sdk.android.auth.AccountsQueryParameters;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserStatus implements Item {
    public static final int STATUS_CODE_NOT_LOGGED_IN = 1;
    public static final int STATUS_CODE_OK = 0;

    @SerializedName(AccountsQueryParameters.CODE)
    @JsonProperty(AccountsQueryParameters.CODE)
    public final int code;

    @SerializedName("long_text")
    @JsonProperty("long_text")
    public final String longMessage;

    @SerializedName("short_text")
    @JsonProperty("short_text")
    public final String shortMessage;

    private UserStatus() {
        this(1, null, null);
    }

    public UserStatus(int i, String str, String str2) {
        this.code = i;
        this.shortMessage = str;
        this.longMessage = str2;
    }

    @JsonIgnore
    public boolean isLoggedIn() {
        return this.code == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserStatus)) {
            return false;
        }
        UserStatus userStatus = (UserStatus) obj;
        if (this.code != userStatus.code) {
            return false;
        }
        String str = this.shortMessage;
        if (str == null ? userStatus.shortMessage != null : !str.equals(userStatus.shortMessage)) {
            return false;
        }
        String str2 = this.longMessage;
        String str3 = userStatus.longMessage;
        if (str2 != null) {
            return str2.equals(str3);
        }
        return str3 == null;
    }

    public int hashCode() {
        int i = this.code * 31;
        String str = this.shortMessage;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.longMessage;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "UserStatus{code=" + this.code + ", shortMessage='" + this.shortMessage + "', longMessage='" + this.longMessage + "'}";
    }
}
