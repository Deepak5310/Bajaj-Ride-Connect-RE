package com.mappls.sdk.services.api.tripoptimisation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public final class TripOptimisationCriteria {
    public static final String GEOMETRY_COORDINATES = "geojson";
    public static final String GEOMETRY_POLYLINE = "polyline";
    public static final String GEOMETRY_POLYLINE6 = "polyline6";
    public static final String LOCATION_INDEX_ANY = "any";
    public static final String LOCATION_INDEX_FIRST = "first";
    public static final String LOCATION_INDEX_LAST = "last";
    public static final String OVERVIEW_FALSE = "false";
    public static final String OVERVIEW_FULL = "full";
    public static final String OVERVIEW_SIMPLIFIED = "simplified";
    public static final String PROFILE_BIKING = "biking";
    public static final String PROFILE_DRIVING = "driving";
    public static final String PROFILE_TRUCKING = "trucking";
    public static final String PROFILE_WALKING = "walking";
    public static final String RESOURCE_TRIP_OPTIMISATION = "trip_optimization";
    public static final String RESOURCE_TRIP_OPTIMISATION_ETA = "trip_optimization_eta";
    public static final String RESOURCE_TRIP_OPTIMISATION_TRAFFIC = "trip_optimization_traffic";

    @Retention(RetentionPolicy.SOURCE)
    public @interface GeometryCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationIndexCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OverviewCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProfileCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResourceCriteria {
    }
}
