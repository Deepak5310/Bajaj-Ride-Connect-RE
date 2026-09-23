package com.bajajconnect.wifi.navv2;

/* JADX INFO: loaded from: classes3.dex */
public final class NavV2Models {
    public static final int CMD_GET_FAVOURITES = 9;
    public static final int CMD_GET_POI_DETAIL = 8;
    public static final int CMD_GET_POI_LIST = 7;
    public static final int CMD_GET_RECENT_TRIPS = 10;
    public static final int CMD_GET_ROUTE_PREFERENCE = 14;
    public static final int CMD_GET_ROUTE_PREVIEW = 12;
    public static final int CMD_GET_TRIP_DETAIL = 11;
    public static final int CMD_SET_ROUTE_PREFERENCE = 13;
    public static final int CMD_START_NAVIGATION = 15;
    public static final int GROUP_DASHBOARD_REQUESTS = 2;

    private NavV2Models() {
    }

    public enum Source {
        POI(0),
        FAVOURITE(1),
        RECENT(2);

        public final int value;

        Source(int i) {
            this.value = i;
        }

        public static Source from(int i) {
            for (Source source : values()) {
                if (source.value == i) {
                    return source;
                }
            }
            return null;
        }
    }

    public enum RouteMode {
        FASTEST(0),
        SHORTEST(1),
        ECO(2),
        AVOID_TOLLS(3);

        public final int value;

        RouteMode(int i) {
            this.value = i;
        }

        public static RouteMode from(int i) {
            for (RouteMode routeMode : values()) {
                if (routeMode.value == i) {
                    return routeMode;
                }
            }
            return null;
        }
    }

    public enum Units {
        KILOMETRES(0),
        MILES(1);

        public final int value;

        Units(int i) {
            this.value = i;
        }

        public static Units from(int i) {
            for (Units units : values()) {
                if (units.value == i) {
                    return units;
                }
            }
            return null;
        }
    }

    public enum AckStatus {
        SUCCESS(0),
        FAILURE(1),
        INVALID_INDEX(2);

        public final int value;

        AckStatus(int i) {
            this.value = i;
        }
    }

    public enum NavStatus {
        STARTED(0),
        FAILED(1),
        REROUTING(2);

        public final int value;

        NavStatus(int i) {
            this.value = i;
        }
    }

    public static final class RoutePreference {
        public int bitmask = 12;
        public RouteMode routeMode = RouteMode.FASTEST;
        public Units units = Units.KILOMETRES;

        public byte[] payloadBytes() {
            return new byte[]{(byte) (this.bitmask & 15), (byte) this.routeMode.value, (byte) this.units.value, 0};
        }
    }

    public static final class IndexedPlace {
        public final String address;
        public final String distanceText;
        public final String etaText;
        public final int index;
        public final double latitude;
        public final double longitude;
        public final String name;
        public final String placeId;

        public IndexedPlace(int i, String str, double d, double d2, String str2) {
            this(i, str, d, d2, str2, "", "", "");
        }

        public IndexedPlace(int i, String str, double d, double d2, String str2, String str3, String str4, String str5) {
            this.index = i & 255;
            this.name = str == null ? "" : str;
            this.latitude = d;
            this.longitude = d2;
            this.address = str2 == null ? "" : str2;
            this.placeId = str3 == null ? "" : str3;
            this.distanceText = str4 == null ? "" : str4;
            this.etaText = str5 == null ? "" : str5;
        }

        public boolean hasCoordinates() {
            return (this.latitude == 0.0d && this.longitude == 0.0d) ? false : true;
        }
    }

    public static final class RouteSummary {
        public final RouteMode appliedRouteMode;
        public final int distanceMeters;
        public final String distanceText;
        public final int durationSeconds;
        public final String etaText;

        public RouteSummary(String str, String str2, int i, int i2, RouteMode routeMode) {
            this.distanceText = str == null ? "" : str;
            this.etaText = str2 == null ? "" : str2;
            this.distanceMeters = i;
            this.durationSeconds = i2;
            this.appliedRouteMode = routeMode == null ? RouteMode.FASTEST : routeMode;
        }
    }

    public static final class ClusterPoiItem {
        public final String address;
        public final int distanceMeters;
        public final String distanceText;
        public final double latitude;
        public final double longitude;
        public final String name;
        public final String placeId;

        public ClusterPoiItem(String str, String str2, String str3, double d, double d2) {
            this(str, str2, str3, d, d2, -1, "");
        }

        public ClusterPoiItem(String str, String str2, String str3, double d, double d2, int i, String str4) {
            this.placeId = str == null ? "" : str;
            this.name = str2 == null ? "" : str2;
            this.address = str3 == null ? "" : str3;
            this.latitude = d;
            this.longitude = d2;
            this.distanceMeters = i;
            this.distanceText = str4 == null ? "" : str4;
        }

        public ClusterPoiItem withRouteDistance(int i, String str) {
            return new ClusterPoiItem(this.placeId, this.name, this.address, this.latitude, this.longitude, i, str);
        }

        public boolean hasCoordinates() {
            return (this.latitude == 0.0d && this.longitude == 0.0d) ? false : true;
        }

        public boolean hasRouteDistance() {
            return this.distanceMeters >= 0;
        }

        public String displayTitle() {
            return this.name;
        }

        public String displaySubtitle() {
            return this.address;
        }
    }
}
