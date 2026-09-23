package com.mappls.sdk.maps.style.model;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsStyle {
    private String description;
    private String displayName;
    private String imageUrl;
    private Integer isDefault;
    private String name;

    public MapplsStyle(String str, String str2, String str3, String str4, Integer num) {
        this.description = str3;
        this.displayName = str2;
        this.imageUrl = str4;
        this.isDefault = num;
        this.name = str;
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

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
