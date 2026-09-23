package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info implements Item {

    @SerializedName(SavingTrackHelper.POINT_COL_CATEGORY)
    @JsonProperty(SavingTrackHelper.POINT_COL_CATEGORY)
    public final String category;

    @SerializedName("default_image_height")
    @JsonProperty("default_image_height")
    public final int defaultImageHeight;

    @SerializedName("default_image_width")
    @JsonProperty("default_image_width")
    public final int defaultImageWidth;

    @SerializedName("default_thumbnail_image_height")
    @JsonProperty("default_thumbnail_image_height")
    public final int defaultThumbnailImageHeight;

    @SerializedName("default_thumbnail_image_width")
    @JsonProperty("default_thumbnail_image_width")
    public final int defaultThumbnailImageWidth;

    @SerializedName("id")
    @JsonProperty("id")
    public final String id;

    @SerializedName("image_type")
    @JsonProperty("image_type")
    public final String imageType;

    @SerializedName("model")
    @JsonProperty("model")
    public final String model;

    @SerializedName("name")
    @JsonProperty("name")
    public final String name;

    @SerializedName("protocol_version")
    @JsonProperty("protocol_version")
    public final int protocolVersion;

    @SerializedName("required_features")
    @JsonProperty("required_features")
    public final List<String> requiredFeatures;

    @SerializedName("version")
    @JsonProperty("version")
    public final String version;

    private Info() {
        this(0, null, null, null, null, null, null, null, 0, 0, 0, 0);
    }

    public Info(int i, List<String> list, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4, int i5) {
        this.protocolVersion = i;
        this.id = str;
        this.name = str2;
        this.model = str3;
        this.category = str4;
        this.version = str5;
        this.imageType = str6;
        this.requiredFeatures = list;
        this.defaultImageHeight = i3;
        this.defaultImageWidth = i2;
        this.defaultThumbnailImageHeight = i5;
        this.defaultThumbnailImageWidth = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Info)) {
            return false;
        }
        Info info = (Info) obj;
        if (this.protocolVersion != info.protocolVersion || this.defaultImageHeight != info.defaultImageHeight || this.defaultImageWidth != info.defaultImageWidth || this.defaultThumbnailImageHeight != info.defaultThumbnailImageHeight || this.defaultThumbnailImageWidth != info.defaultThumbnailImageWidth) {
            return false;
        }
        String str = this.id;
        if (str == null ? info.id != null : !str.equals(info.id)) {
            return false;
        }
        String str2 = this.name;
        if (str2 == null ? info.name != null : !str2.equals(info.name)) {
            return false;
        }
        String str3 = this.model;
        if (str3 == null ? info.model != null : !str3.equals(info.model)) {
            return false;
        }
        String str4 = this.category;
        if (str4 == null ? info.category != null : !str4.equals(info.category)) {
            return false;
        }
        String str5 = this.version;
        if (str5 == null ? info.version != null : !str5.equals(info.version)) {
            return false;
        }
        String str6 = this.imageType;
        if (str6 == null ? info.imageType != null : !str6.equals(info.imageType)) {
            return false;
        }
        List<String> list = this.requiredFeatures;
        return list == null ? info.requiredFeatures == null : list.equals(info.requiredFeatures);
    }

    public int hashCode() {
        int i = this.protocolVersion * 31;
        String str = this.id;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.model;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.category;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.version;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.imageType;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<String> list = this.requiredFeatures;
        return ((((((((iHashCode6 + (list != null ? list.hashCode() : 0)) * 31) + this.defaultImageHeight) * 31) + this.defaultImageWidth) * 31) + this.defaultThumbnailImageHeight) * 31) + this.defaultThumbnailImageWidth;
    }

    public String toString() {
        return "Info{protocolVersion=" + this.protocolVersion + ", id='" + this.id + "', name='" + this.name + "', model='" + this.model + "', category='" + this.category + "', version='" + this.version + "', imageType='" + this.imageType + "', requiredFeatures=" + this.requiredFeatures + ", defaultImageHeight=" + this.defaultImageHeight + ", defaultImageWidth=" + this.defaultImageWidth + ", defaultThumbnailImageHeight=" + this.defaultThumbnailImageHeight + ", defaultThumbnailImageWidth=" + this.defaultThumbnailImageWidth + '}';
    }
}
