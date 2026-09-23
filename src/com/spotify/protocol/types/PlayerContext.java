package com.spotify.protocol.types;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerContext implements Item {

    @SerializedName("subtitle")
    @JsonProperty("subtitle")
    public final String subtitle;

    @SerializedName("title")
    @JsonProperty("title")
    public final String title;

    @SerializedName("type")
    @JsonProperty("type")
    public final String type;

    @SerializedName(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    @JsonProperty(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    public final String uri;

    public PlayerContext() {
        this(null, null, null, null);
    }

    public PlayerContext(String str, String str2, String str3, String str4) {
        this.uri = str;
        this.title = str2;
        this.subtitle = str3;
        this.type = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerContext)) {
            return false;
        }
        PlayerContext playerContext = (PlayerContext) obj;
        String str = this.uri;
        if (str == null ? playerContext.uri != null : !str.equals(playerContext.uri)) {
            return false;
        }
        String str2 = this.title;
        if (str2 == null ? playerContext.title != null : !str2.equals(playerContext.title)) {
            return false;
        }
        String str3 = this.subtitle;
        if (str3 == null ? playerContext.subtitle != null : !str3.equals(playerContext.subtitle)) {
            return false;
        }
        String str4 = this.type;
        String str5 = playerContext.type;
        if (str4 != null) {
            if (!str4.equals(str5)) {
                return true;
            }
        } else if (str5 != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.uri;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subtitle;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.type;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "PlayerContext{, uri=" + this.uri + ", title=" + this.title + ", subtitle=" + this.subtitle + ", type=" + this.type + '}';
    }
}
