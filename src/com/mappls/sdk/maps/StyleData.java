package com.mappls.sdk.maps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.navigation.util.SavingTrackHelper;

/* JADX INFO: loaded from: classes4.dex */
class StyleData {

    @SerializedName(SavingTrackHelper.POINT_COL_DESCRIPTION)
    @Expose
    private String description;

    @SerializedName("displayName")
    @Expose
    private String displayName;

    @SerializedName("logoId")
    @Expose
    private String globalLogoId;

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @SerializedName("isDefault")
    @Expose
    private Integer isDefault;

    @SerializedName("logoId_india")
    @Expose
    private String logoIdIndia;

    @SerializedName("modified")
    @Expose
    private Integer modified;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("owner")
    @Expose
    private String owner;

    @SerializedName("styleUrl")
    @Expose
    private String styleUrl;

    @SerializedName("visibility")
    @Expose
    private String visibility;

    StyleData() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public Integer isDefault() {
        return this.isDefault;
    }

    public void setIsDefault(Integer num) {
        this.isDefault = num;
    }

    public Integer getModified() {
        return this.modified;
    }

    public void setModified(Integer num) {
        this.modified = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public String getStyleUrl() {
        return this.styleUrl;
    }

    public void setStyleUrl(String str) {
        this.styleUrl = str;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public void setVisibility(String str) {
        this.visibility = str;
    }

    public String getGlobalLogoId() {
        return this.globalLogoId;
    }

    public void setGlobalLogoId(String str) {
        this.globalLogoId = str;
    }

    public String getLogoIdIndia() {
        return this.logoIdIndia;
    }

    public void setLogoIdIndia(String str) {
        this.logoIdIndia = str;
    }
}
