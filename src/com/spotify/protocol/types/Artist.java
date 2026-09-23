package com.spotify.protocol.types;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist implements Item {

    @SerializedName("name")
    @JsonProperty("name")
    public final String name;

    @SerializedName(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    @JsonProperty(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    public final String uri;

    private Artist() {
        this(null, null);
    }

    public Artist(String str, String str2) {
        this.name = str;
        this.uri = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Artist)) {
            return false;
        }
        Artist artist = (Artist) obj;
        String str = this.name;
        if (str == null ? artist.name != null : !str.equals(artist.name)) {
            return false;
        }
        String str2 = this.uri;
        String str3 = artist.uri;
        if (str2 != null) {
            return str2.equals(str3);
        }
        return str3 == null;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uri;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Artist{name='" + this.name + "', uri='" + this.uri + "'}";
    }
}
