package com.google.android.libraries.navigation.internal.adl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum w {
    IS_DESTINATION_REFINEMENT,
    PLACEMARK_METADATA,
    FRIEND_LABEL_METADATA,
    PERSONAL_PLACE_METADATA,
    IS_FROM_SPOTLIGHT,
    IS_TRANSIT_VEHICLE,
    IS_INJECTED_PERSISTENT_PLACE,
    IS_VISUAL_EXPLORE_CLUSTER,
    IS_BIKESHARING_VEHICLE,
    IS_RECENTLY_VIEWED,
    IS_BLUE_DOT_CALLOUT,
    TRANSIT_STATION_METADATA,
    POLYLINE_TRAVERSAL_SPRITE_ID,
    IS_STREET_VIEW_POINT_OF_VIEW,
    FEATURE_NOT_SET;

    public static w a(int i) {
        if (i == 0) {
            return FEATURE_NOT_SET;
        }
        if (i == 1) {
            return IS_DESTINATION_REFINEMENT;
        }
        if (i == 2) {
            return PLACEMARK_METADATA;
        }
        if (i == 4) {
            return FRIEND_LABEL_METADATA;
        }
        if (i == 5) {
            return PERSONAL_PLACE_METADATA;
        }
        if (i == 10) {
            return IS_FROM_SPOTLIGHT;
        }
        if (i == 35) {
            return TRANSIT_STATION_METADATA;
        }
        if (i == 21) {
            return IS_RECENTLY_VIEWED;
        }
        if (i == 22) {
            return IS_BLUE_DOT_CALLOUT;
        }
        if (i == 37) {
            return POLYLINE_TRAVERSAL_SPRITE_ID;
        }
        if (i == 38) {
            return IS_STREET_VIEW_POINT_OF_VIEW;
        }
        switch (i) {
            case 16:
                return IS_TRANSIT_VEHICLE;
            case 17:
                return IS_INJECTED_PERSISTENT_PLACE;
            case 18:
                return IS_VISUAL_EXPLORE_CLUSTER;
            case 19:
                return IS_BIKESHARING_VEHICLE;
            default:
                return null;
        }
    }
}
