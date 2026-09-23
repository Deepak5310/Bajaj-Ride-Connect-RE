package com.spotify.protocol.types;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibraryState implements Item {

    @SerializedName("can_save")
    @JsonProperty("can_save")
    public final boolean canAdd;

    @SerializedName("saved")
    @JsonProperty("saved")
    public final boolean isAdded;

    @SerializedName(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    @JsonProperty(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    public final String uri;

    private LibraryState() {
        this(null, false, false);
    }

    public LibraryState(String str, boolean z, boolean z2) {
        this.uri = str;
        this.isAdded = z;
        this.canAdd = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LibraryState)) {
            return false;
        }
        LibraryState libraryState = (LibraryState) obj;
        if (this.isAdded != libraryState.isAdded || this.canAdd != libraryState.canAdd) {
            return false;
        }
        String str = this.uri;
        String str2 = libraryState.uri;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        String str = this.uri;
        return ((((str != null ? str.hashCode() : 0) * 31) + (this.isAdded ? 1 : 0)) * 31) + (this.canAdd ? 1 : 0);
    }

    public String toString() {
        return "LibraryState{uri='" + this.uri + "', isAdded=" + this.isAdded + ", canAdd=" + this.canAdd + '}';
    }
}
