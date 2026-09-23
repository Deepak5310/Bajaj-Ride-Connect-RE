package com.mappls.sdk.geoanalytics;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;

/* JADX INFO: loaded from: classes6.dex */
enum h {
    STATE("state", "geoAnalyticsState"),
    DISTRICT("district", "geoAnalyticsDistrict"),
    SUB_DISTRICT("subdistrict", "geoAnalyticsSubDistrict"),
    TOWN("town", "geoAnalyticsTown"),
    CITY(GeoCodingCriteria.POD_CITY, "geoAnalyticsCity"),
    PINCODE(GeoCodingCriteria.POD_PINCODE, "geoAnalyticsPincode"),
    WARD("ward", "geoAnalyticsWard"),
    LOCALITY(PlaceTypes.LOCALITY, "geoAnalyticsLocality"),
    PANCHAYAT("panchayat", "geoAnalyticsPanchayat"),
    BLOCK("block", "geoAnalyticsBlock"),
    VILLAGE(GeoCodingCriteria.POD_VILLAGE, "geoAnalyticsVillage"),
    SUB_LOCALITY(PlaceTypes.SUBLOCALITY, "geoAnalyticsSubLocality"),
    SUB_SUB_LOCALITY("sub_sublocality", "geoAnalyticsSubSubLocality");

    public String a;
    public String b;

    h(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static h a(MapplsGeoAnalyticsType mapplsGeoAnalyticsType) {
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.STATE) {
            return STATE;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.DISTRICT) {
            return DISTRICT;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.SUB_DISTRICT) {
            return SUB_DISTRICT;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.TOWN) {
            return TOWN;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.CITY) {
            return CITY;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.PINCODE) {
            return PINCODE;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.WARD) {
            return WARD;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.LOCALITY) {
            return LOCALITY;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.PANCHAYAT) {
            return PANCHAYAT;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.BLOCK) {
            return BLOCK;
        }
        if (mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.VILLAGE) {
            return VILLAGE;
        }
        return mapplsGeoAnalyticsType == MapplsGeoAnalyticsType.SUB_LOCALITY ? SUB_LOCALITY : SUB_SUB_LOCALITY;
    }
}
