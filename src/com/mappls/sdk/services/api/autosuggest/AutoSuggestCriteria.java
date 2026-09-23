package com.mappls.sdk.services.api.autosuggest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoSuggestCriteria {
    public static final String POD_CITY = "CITY";
    public static final String POD_DISTRICT = "DIST";
    public static final String POD_LOCALITY = "LC";
    public static final String POD_POI = "POI";
    public static final String POD_STATE = "STATE";
    public static final String POD_SUB_DISTRICT = "SDIST";
    public static final String POD_SUB_LOCALITY = "SLC";
    public static final String POD_SUB_SUB_LOCALITY = "SSLC";
    public static final String POD_VILLAGE = "VLG";

    @Retention(RetentionPolicy.SOURCE)
    public @interface PODCriteria {
    }

    private AutoSuggestCriteria() {
    }
}
