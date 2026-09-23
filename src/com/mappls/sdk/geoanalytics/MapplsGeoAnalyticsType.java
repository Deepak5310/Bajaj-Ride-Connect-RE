package com.mappls.sdk.geoanalytics;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;

/* JADX INFO: loaded from: classes6.dex */
public enum MapplsGeoAnalyticsType {
    STATE("state"),
    DISTRICT("district"),
    SUB_DISTRICT("subdistrict"),
    TOWN("town"),
    CITY(GeoCodingCriteria.POD_CITY),
    PINCODE(GeoCodingCriteria.POD_PINCODE),
    WARD("ward"),
    LOCALITY(PlaceTypes.LOCALITY),
    PANCHAYAT("panchayat"),
    BLOCK("block"),
    VILLAGE(GeoCodingCriteria.POD_VILLAGE),
    SUB_LOCALITY(PlaceTypes.SUBLOCALITY),
    SUB_SUB_LOCALITY("sub_sublocality");

    private String name;

    MapplsGeoAnalyticsType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
