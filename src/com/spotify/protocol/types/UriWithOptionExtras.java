package com.spotify.protocol.types;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UriWithOptionExtras implements Item {

    @SerializedName("options")
    @JsonProperty("options")
    public final String[] options;

    @SerializedName(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    @JsonProperty(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    public final String uri;

    public UriWithOptionExtras() {
        this(null, null);
    }

    public UriWithOptionExtras(String str, String[] strArr) {
        this.uri = str;
        this.options = strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UriWithOptionExtras)) {
            return false;
        }
        UriWithOptionExtras uriWithOptionExtras = (UriWithOptionExtras) obj;
        return this.uri.equals(uriWithOptionExtras.uri) && Arrays.equals(this.options, uriWithOptionExtras.options);
    }

    public int hashCode() {
        return (this.uri.hashCode() * 31) + Arrays.hashCode(this.options);
    }

    public String toString() {
        return "UriWithOptionExtras{uri='" + this.uri + "', options=" + Arrays.toString(this.options) + '}';
    }
}
