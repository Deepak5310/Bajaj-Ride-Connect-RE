package com.mappls.sdk.services.api.nearby;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public final class NearbyCriteria {
    public static final String DISTANCE = "dist";
    public static final String DISTANCE_ASCENDING = "dist:asc";
    public static final String DISTANCE_DESCENDING = "dist:desc";
    public static final String ICON_24_PX = "24px";
    public static final String ICON_36_PX = "36px";
    public static final String ICON_48_PX = "48px";
    public static final String ICON_54_PX = "54px";
    public static final int ICON_DARK_MODE = 1;
    public static final int ICON_LIGHT_MODE = 0;
    public static final String IMPORTANCE = "imp";
    public static final String NAME_ASCENDING = "name:asc";
    public static final String NAME_DESCENDING = "name:desc";
    public static final String POD_CITY = "CITY";
    public static final String POD_LOCALITY = "LC";
    public static final String POD_STATE = "STATE";
    public static final String POD_SUB_LOCALITY = "SLC";

    @Retention(RetentionPolicy.SOURCE)
    public @interface NearbyIconModeCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NearbyIconSizeCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PodCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SearchingCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SortingCriteria {
    }

    private NearbyCriteria() {
    }
}
