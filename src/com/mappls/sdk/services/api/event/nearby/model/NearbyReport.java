package com.mappls.sdk.services.api.event.nearby.model;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.services.utils.MapplsUtils;

/* JADX INFO: loaded from: classes4.dex */
public class NearbyReport {

    @SerializedName("addedBy")
    @Expose
    private String addedBy;

    @SerializedName("addedByName")
    @Expose
    private String addedByName;

    @SerializedName(PlaceTypes.ADDRESS)
    @Expose
    private String address;

    @SerializedName("audiosCount")
    @Expose
    private Integer audiosCount;

    @SerializedName("bearing")
    @Expose
    private Double bearing;

    @SerializedName(SavingTrackHelper.POINT_COL_CATEGORY)
    @Expose
    private String category;

    @SerializedName("childCategory")
    @Expose
    private String childCategory;

    @SerializedName("createdOn")
    @Expose
    private Long createdOn;

    @SerializedName(SavingTrackHelper.POINT_COL_DESCRIPTION)
    @Expose
    private String description;

    @SerializedName("expiry")
    @Expose
    private Long expiry;

    @SerializedName("iconBaseUrl")
    @Expose
    private String iconBaseUrl;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("latitude")
    @Expose
    private Double latitude;

    @SerializedName("longitude")
    @Expose
    private Double longitude;

    @SerializedName("parentCategory")
    @Expose
    private String parentCategory;

    @SerializedName("picturesCount")
    @Expose
    private Integer picturesCount;

    @SerializedName("reportIcon")
    @Expose
    private String reportIcon;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    @Expose
    private String status;

    @SerializedName("userProfileIcon")
    @Expose
    private String userProfileIcon;

    @SerializedName("usersCount")
    @Expose
    private Integer usersCount;

    @SerializedName("videosCount")
    @Expose
    private Integer videosCount;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Long l) {
        this.createdOn = l;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double d) {
        this.longitude = d;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double d) {
        this.latitude = d;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public Double getBearing() {
        return this.bearing;
    }

    public void setBearing(Double d) {
        this.bearing = d;
    }

    public String getParentCategory() {
        return this.parentCategory;
    }

    public void setParentCategory(String str) {
        this.parentCategory = str;
    }

    public String getChildCategory() {
        return this.childCategory;
    }

    public void setChildCategory(String str) {
        this.childCategory = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getUserProfileIcon() {
        return this.userProfileIcon;
    }

    public void setUserProfileIcon(String str) {
        this.userProfileIcon = str;
    }

    public String getAddedByName() {
        return this.addedByName;
    }

    public void setAddedByName(String str) {
        this.addedByName = str;
    }

    public String getAddedBy() {
        return this.addedBy;
    }

    public void setAddedBy(String str) {
        this.addedBy = str;
    }

    public Long getExpiry() {
        return this.expiry;
    }

    public void setExpiry(Long l) {
        this.expiry = l;
    }

    public Integer getUsersCount() {
        return this.usersCount;
    }

    public void setUsersCount(Integer num) {
        this.usersCount = num;
    }

    public Integer getAudiosCount() {
        return this.audiosCount;
    }

    public void setAudiosCount(Integer num) {
        this.audiosCount = num;
    }

    public Integer getVideosCount() {
        return this.videosCount;
    }

    public void setVideosCount(Integer num) {
        this.videosCount = num;
    }

    public Integer getPicturesCount() {
        return this.picturesCount;
    }

    public void setPicturesCount(Integer num) {
        this.picturesCount = num;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getReportIcon(String str) {
        String str2 = this.iconBaseUrl;
        if (str2 == null) {
            str2 = "";
        }
        return Uri.parse(str2).buildUpon().appendPath("0").appendPath(SystemMediaRouteProvider.PACKAGE_NAME).appendPath(str).appendPath("drawable-" + MapplsUtils.getDensityName()).appendPath(this.reportIcon).build().toString();
    }

    public String getReportIcon(String str, int i) {
        String str2 = this.iconBaseUrl;
        if (str2 == null) {
            str2 = "";
        }
        return Uri.parse(str2).buildUpon().appendPath("" + i).appendPath(SystemMediaRouteProvider.PACKAGE_NAME).appendPath(str).appendPath("drawable-" + MapplsUtils.getDensityName()).appendPath(this.reportIcon).build().toString();
    }
}
