package com.mappls.sdk.services.api.nearby.model;

import android.net.Uri;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.autosuggest.model.AddressTokens;
import com.mappls.sdk.services.api.autosuggest.model.PartnerFlag;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class NearbyAtlasResult {

    @SerializedName("addressTokens")
    @Expose
    public AddressTokens addressTokens;

    @SerializedName("baseUrl")
    @Expose
    private String baseUrl;

    @SerializedName(DirectionsCriteria.ANNOTATION_DISTANCE)
    @Expose
    public Long distance;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("entryLatitude")
    @Expose
    public Double entryLatitude;

    @SerializedName("entryLongitude")
    @Expose
    public Double entryLongitude;

    @SerializedName("hourOfOperation")
    @Expose
    public String hourOfOperation;

    @SerializedName("keywords")
    @Expose
    public List<String> keywords = null;

    @SerializedName("landlineNo")
    @Expose
    public String landlineNo;

    @SerializedName("latitude")
    @Expose
    public Double latitude;

    @SerializedName("longitude")
    @Expose
    public Double longitude;

    @SerializedName(alternate = {"eLoc"}, value = "mapplsPin")
    @Expose
    public String mapplsPin;

    @SerializedName("mobileNo")
    @Expose
    public String mobileNo;

    @SerializedName("orderIndex")
    @Expose
    public long orderIndex;

    @SerializedName("partnersFlag")
    @Expose
    public List<PartnerFlag> partnersFlag;

    @SerializedName("placeAddress")
    @Expose
    public String placeAddress;

    @SerializedName("placeName")
    @Expose
    public String placeName;

    @SerializedName("richInfo")
    @Expose
    private Map richInfo;

    @SerializedName("type")
    @Expose
    public String type;

    public Long getDistance() {
        return this.distance;
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public String getEmail() {
        return this.email;
    }

    public Double getEntryLatitude() {
        return this.entryLatitude;
    }

    public Double getEntryLongitude() {
        return this.entryLongitude;
    }

    public List<String> getKeywords() {
        return this.keywords;
    }

    public String getLandlineNo() {
        return this.landlineNo;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public long getOrderIndex() {
        return this.orderIndex;
    }

    public String getPlaceAddress() {
        return this.placeAddress;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public String getType() {
        return this.type;
    }

    public Map getRichInfo() {
        return this.richInfo;
    }

    public void setRichInfo(Map map) {
        this.richInfo = map;
    }

    public void setDistance(Long l) {
        this.distance = l;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEntryLatitude(Double d) {
        this.entryLatitude = d;
    }

    public void setEntryLongitude(Double d) {
        this.entryLongitude = d;
    }

    public void setKeywords(List<String> list) {
        this.keywords = list;
    }

    public void setLandlineNo(String str) {
        this.landlineNo = str;
    }

    public void setLatitude(Double d) {
        this.latitude = d;
    }

    public void setLongitude(Double d) {
        this.longitude = d;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public void setOrderIndex(long j) {
        this.orderIndex = j;
    }

    public void setPlaceAddress(String str) {
        this.placeAddress = str;
    }

    public void setPlaceName(String str) {
        this.placeName = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getHourOfOperation() {
        return this.hourOfOperation;
    }

    public void setHourOfOperation(String str) {
        this.hourOfOperation = str;
    }

    public AddressTokens getAddressTokens() {
        return this.addressTokens;
    }

    public void setAddressTokens(AddressTokens addressTokens) {
        this.addressTokens = addressTokens;
    }

    public List<PartnerFlag> getPartnersFlag() {
        return this.partnersFlag;
    }

    public void setPartnersFlag(List<PartnerFlag> list) {
        this.partnersFlag = list;
    }

    public String getIconUrl(String str) {
        String str2;
        List<String> list = this.keywords;
        if (list == null || list.isEmpty() || (str2 = this.baseUrl) == null) {
            return null;
        }
        return Uri.parse(str2).buildUpon().appendPath("0").appendPath(SystemMediaRouteProvider.PACKAGE_NAME).appendPath(str).appendPath("drawable-" + MapplsUtils.getDensityName()).appendPath(this.keywords.get(0) + ".png").build().toString();
    }

    public String getIconUrl(String str, int i) {
        String str2;
        List<String> list = this.keywords;
        if (list == null || list.isEmpty() || (str2 = this.baseUrl) == null) {
            return null;
        }
        return Uri.parse(str2).buildUpon().appendPath("" + i).appendPath(SystemMediaRouteProvider.PACKAGE_NAME).appendPath(str).appendPath("drawable-" + MapplsUtils.getDensityName()).appendPath(this.keywords.get(0) + ".png").build().toString();
    }
}
