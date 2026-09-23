package com.mappls.sdk.services.api.directions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public final class DirectionsCriteria {
    public static final String ANNOTATION_BASE_DURATION = "baseDuration";
    public static final String ANNOTATION_CONGESTION = "congestion";
    public static final String ANNOTATION_DISTANCE = "distance";
    public static final String ANNOTATION_DURATION = "duration";
    public static final String ANNOTATION_MAXSPEED = "maxspeed";
    public static final String ANNOTATION_NODES = "nodes";
    public static final String ANNOTATION_SPEED = "speed";
    public static final String ANNOTATION_SPEED_LIMIT = "spdlmt";
    public static final String ANNOTATION_TOLL_ROAD = "toll_road";
    public static final String APPROACH_CURB = "curb";
    public static final String APPROACH_UNRESTRICTED = "unrestricted";
    public static final String DESTINATION_ANY = "any";
    public static final String DESTINATION_LAST = "last";
    public static final int DISTANCE_ROUTE_TYPE_OPTIMAL = 0;
    public static final int DISTANCE_ROUTE_TYPE_SHORTEST = 1;
    public static final String EXCLUDE_FERRY = "ferry";
    public static final String EXCLUDE_MOTORWAY = "motorway";
    public static final String EXCLUDE_RESTRICTED = "restricted";
    public static final String EXCLUDE_TOLL = "toll";
    public static final String EXCLUDE_TUNNEL = "tunnel";
    public static final String GEOMETRY_COORDINATES = "geojson";
    public static final String GEOMETRY_POLYLINE = "polyline";
    public static final String GEOMETRY_POLYLINE6 = "polyline6";
    public static final String IMPERIAL = "imperial";
    public static final String METRIC = "metric";
    public static final String OVERVIEW_FALSE = "false";
    public static final String OVERVIEW_FULL = "full";
    public static final String OVERVIEW_SIMPLIFIED = "simplified";
    public static final String PROFILE_BIKING = "biking";
    public static final String PROFILE_DEFAULT_USER = "mappls";
    public static final String PROFILE_DRIVING = "driving";
    public static final String PROFILE_EV_DRIVING = "EV4W";
    public static final String PROFILE_TRUCKING = "trucking";
    public static final String PROFILE_WALKING = "walking";
    public static final String RESOURCE_DISTANCE = "distance_matrix";
    public static final String RESOURCE_DISTANCE_ETA = "distance_matrix_eta";
    public static final String RESOURCE_DISTANCE_PREDICTIVE = "distance_matrix_predictive";
    public static final String RESOURCE_DISTANCE_TRAFFIC = "distance_matrix_traffic";
    public static final String RESOURCE_ROUTE = "route_adv";
    public static final String RESOURCE_ROUTE_ETA = "route_eta";
    public static final String RESOURCE_ROUTE_PREDICTIVE = "route_adv_predictive";
    public static final String RESOURCE_ROUTE_TRAFFIC = "route_traffic";
    public static final int ROUTE_TYPE_OPTIMAL = 0;
    public static final int ROUTE_TYPE_SHORTEST = 1;
    public static final int ROUTE_TYPE_WITHOUT_CONTAINMENT_ZONE = 2;
    public static final String SOURCE_ANY = "any";
    public static final String SOURCE_FIRST = "first";
    public static final int SPECIFIED_ARRIVAL = 2;
    public static final int SPECIFIED_DEPARTURE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnnotationCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ApproachesCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DestinationCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DistanceProfileCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DistanceResourceCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DistanceRouteType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExcludeCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GeometriesCriteria {
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

    @Retention(RetentionPolicy.SOURCE)
    public @interface RouteType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SourceCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SpecifiedTypeCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VoiceUnitCriteria {
    }

    private DirectionsCriteria() {
    }
}
