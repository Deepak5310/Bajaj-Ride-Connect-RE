package com.mappls.sdk.services.api.tripplan;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsSmartTripPlan extends MapplsSmartTripPlan {
    private final Integer actualDistanceToEmpty;
    private final String baseUrl;
    private final List<String> coordinates;
    private final String geometries;
    private final String routeGeometry;
    private final Integer searchStateOfCharge;
    private final List<String> snappedCoordinates;
    private final String socketType;
    private final Integer stateOfCharge;
    private final List<String> waypointNames;

    private AutoValue_MapplsSmartTripPlan(String str, List<String> list, List<String> list2, Integer num, Integer num2, Integer num3, String str2, String str3, String str4, List<String> list3) {
        this.baseUrl = str;
        this.coordinates = list;
        this.snappedCoordinates = list2;
        this.actualDistanceToEmpty = num;
        this.stateOfCharge = num2;
        this.searchStateOfCharge = num3;
        this.geometries = str2;
        this.routeGeometry = str3;
        this.socketType = str4;
        this.waypointNames = list3;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan
    List<String> coordinates() {
        return this.coordinates;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan
    List<String> snappedCoordinates() {
        return this.snappedCoordinates;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan
    Integer actualDistanceToEmpty() {
        return this.actualDistanceToEmpty;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan
    Integer stateOfCharge() {
        return this.stateOfCharge;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan
    Integer searchStateOfCharge() {
        return this.searchStateOfCharge;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan
    String geometries() {
        return this.geometries;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan
    String routeGeometry() {
        return this.routeGeometry;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan
    String socketType() {
        return this.socketType;
    }

    @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan
    List<String> waypointNames() {
        return this.waypointNames;
    }

    public String toString() {
        return "MapplsSmartTripPlan{baseUrl=" + this.baseUrl + ", coordinates=" + this.coordinates + ", snappedCoordinates=" + this.snappedCoordinates + ", actualDistanceToEmpty=" + this.actualDistanceToEmpty + ", stateOfCharge=" + this.stateOfCharge + ", searchStateOfCharge=" + this.searchStateOfCharge + ", geometries=" + this.geometries + ", routeGeometry=" + this.routeGeometry + ", socketType=" + this.socketType + ", waypointNames=" + this.waypointNames + "}";
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsSmartTripPlan)) {
            return false;
        }
        MapplsSmartTripPlan mapplsSmartTripPlan = (MapplsSmartTripPlan) obj;
        if (this.baseUrl.equals(mapplsSmartTripPlan.baseUrl()) && this.coordinates.equals(mapplsSmartTripPlan.coordinates()) && this.snappedCoordinates.equals(mapplsSmartTripPlan.snappedCoordinates()) && this.actualDistanceToEmpty.equals(mapplsSmartTripPlan.actualDistanceToEmpty()) && this.stateOfCharge.equals(mapplsSmartTripPlan.stateOfCharge()) && this.searchStateOfCharge.equals(mapplsSmartTripPlan.searchStateOfCharge()) && this.geometries.equals(mapplsSmartTripPlan.geometries()) && this.routeGeometry.equals(mapplsSmartTripPlan.routeGeometry()) && ((str = this.socketType) != null ? str.equals(mapplsSmartTripPlan.socketType()) : mapplsSmartTripPlan.socketType() == null)) {
            List<String> list = this.waypointNames;
            if (list == null) {
                if (mapplsSmartTripPlan.waypointNames() == null) {
                    return true;
                }
            } else if (list.equals(mapplsSmartTripPlan.waypointNames())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((((((((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.coordinates.hashCode()) * 1000003) ^ this.snappedCoordinates.hashCode()) * 1000003) ^ this.actualDistanceToEmpty.hashCode()) * 1000003) ^ this.stateOfCharge.hashCode()) * 1000003) ^ this.searchStateOfCharge.hashCode()) * 1000003) ^ this.geometries.hashCode()) * 1000003) ^ this.routeGeometry.hashCode()) * 1000003;
        String str = this.socketType;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<String> list = this.waypointNames;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    static final class Builder extends MapplsSmartTripPlan.Builder {
        private Integer actualDistanceToEmpty;
        private String baseUrl;
        private List<String> coordinates;
        private String geometries;
        private String routeGeometry;
        private Integer searchStateOfCharge;
        private List<String> snappedCoordinates;
        private String socketType;
        private Integer stateOfCharge;
        private List<String> waypointNames;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        public MapplsSmartTripPlan.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        MapplsSmartTripPlan.Builder coordinates(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null coordinates");
            }
            this.coordinates = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        MapplsSmartTripPlan.Builder snappedCoordinates(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null snappedCoordinates");
            }
            this.snappedCoordinates = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        public MapplsSmartTripPlan.Builder actualDistanceToEmpty(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null actualDistanceToEmpty");
            }
            this.actualDistanceToEmpty = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        public MapplsSmartTripPlan.Builder stateOfCharge(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null stateOfCharge");
            }
            this.stateOfCharge = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        public MapplsSmartTripPlan.Builder searchStateOfCharge(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null searchStateOfCharge");
            }
            this.searchStateOfCharge = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        public MapplsSmartTripPlan.Builder geometries(String str) {
            if (str == null) {
                throw new NullPointerException("Null geometries");
            }
            this.geometries = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        public MapplsSmartTripPlan.Builder routeGeometry(String str) {
            if (str == null) {
                throw new NullPointerException("Null routeGeometry");
            }
            this.routeGeometry = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        public MapplsSmartTripPlan.Builder socketType(String str) {
            this.socketType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        public MapplsSmartTripPlan.Builder waypointNames(List<String> list) {
            this.waypointNames = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripplan.MapplsSmartTripPlan.Builder
        MapplsSmartTripPlan autoBuild() {
            if (this.baseUrl == null || this.coordinates == null || this.snappedCoordinates == null || this.actualDistanceToEmpty == null || this.stateOfCharge == null || this.searchStateOfCharge == null || this.geometries == null || this.routeGeometry == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.coordinates == null) {
                    sb.append(" coordinates");
                }
                if (this.snappedCoordinates == null) {
                    sb.append(" snappedCoordinates");
                }
                if (this.actualDistanceToEmpty == null) {
                    sb.append(" actualDistanceToEmpty");
                }
                if (this.stateOfCharge == null) {
                    sb.append(" stateOfCharge");
                }
                if (this.searchStateOfCharge == null) {
                    sb.append(" searchStateOfCharge");
                }
                if (this.geometries == null) {
                    sb.append(" geometries");
                }
                if (this.routeGeometry == null) {
                    sb.append(" routeGeometry");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsSmartTripPlan(this.baseUrl, this.coordinates, this.snappedCoordinates, this.actualDistanceToEmpty, this.stateOfCharge, this.searchStateOfCharge, this.geometries, this.routeGeometry, this.socketType, this.waypointNames);
        }
    }
}
