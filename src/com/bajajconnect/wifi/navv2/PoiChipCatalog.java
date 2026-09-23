package com.bajajconnect.wifi.navv2;

import com.google.android.libraries.places.api.model.PlaceTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class PoiChipCatalog {
    public static final int DEFAULT_MAX_RESULTS = 5;
    public static final int DEFAULT_RADIUS_METERS = 8000;
    public static final int DIRECTIONS_CANDIDATE_CAP = 10;

    private PoiChipCatalog() {
    }

    public static String placeTypeForCategoryIndex(int i) {
        int i2 = i & 255;
        if (i2 == 1) {
            return PlaceTypes.CAFE;
        }
        if (i2 == 2) {
            return PlaceTypes.RESTAURANT;
        }
        if (i2 == 3) {
            return PlaceTypes.TOURIST_ATTRACTION;
        }
        return PlaceTypes.GAS_STATION;
    }

    public static String humanQueryForType(String str) {
        if (str == null || str.isEmpty()) {
            return "places";
        }
        str.hashCode();
        switch (str) {
            case "restaurant":
                return "restaurant food dining";
            case "tourist_attraction":
                return "tourist attraction museum park monument";
            case "cafe":
                return "cafe coffee tea";
            case "gas_station":
                return "petrol pump fuel gas station";
            default:
                return str.replace('_', ' ');
        }
    }

    public static boolean supportsIncludedType(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "restaurant":
            case "tourist_attraction":
            case "cafe":
            case "gas_station":
                return true;
            default:
                return false;
        }
    }
}
