package com.mappls.sdk.services.api.predictive.directions;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsPredictiveDirections extends MapplsPredictiveDirections {
    private final Integer alternatives;
    private final List<String> avoidLocations;
    private final Boolean avoidTolls;
    private final Double axleLoad;
    private final String baseUrl;
    private final List<String> coordinates;
    private final Boolean excludeBridge;
    private final Boolean excludeTunnel;
    private final Boolean hazmat;
    private final Integer heading;
    private final Integer headingTolerance;
    private final Double height;
    private final List<String> internalAvoidPolygons;
    private final String internalDateTime;
    private final String internalSpeedType;
    private final Double length;
    private final String maxRouteClass;
    private final String minRouteClass;
    private final String preferredSide;
    private final String profile;
    private final String routeName;
    private final Integer searchCutoff;
    private final Double useFerry;
    private final Double useHighway;
    private final Double weight;
    private final Double width;

    private AutoValue_MapplsPredictiveDirections(String str, List<String> list, String str2, String str3, String str4, Integer num, Integer num2, String str5, Integer num3, List<String> list2, List<String> list3, String str6, Double d, Double d2, Integer num4, Boolean bool, Boolean bool2, Boolean bool3, String str7, String str8, Double d3, Double d4, Double d5, Double d6, Double d7, Boolean bool4) {
        this.baseUrl = str;
        this.coordinates = list;
        this.profile = str2;
        this.internalSpeedType = str3;
        this.internalDateTime = str4;
        this.heading = num;
        this.headingTolerance = num2;
        this.preferredSide = str5;
        this.searchCutoff = num3;
        this.avoidLocations = list2;
        this.internalAvoidPolygons = list3;
        this.routeName = str6;
        this.useFerry = d;
        this.useHighway = d2;
        this.alternatives = num4;
        this.excludeTunnel = bool;
        this.excludeBridge = bool2;
        this.avoidTolls = bool3;
        this.minRouteClass = str7;
        this.maxRouteClass = str8;
        this.height = d3;
        this.width = d4;
        this.length = d5;
        this.weight = d6;
        this.axleLoad = d7;
        this.hazmat = bool4;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    List<String> coordinates() {
        return this.coordinates;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    String profile() {
        return this.profile;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    String internalSpeedType() {
        return this.internalSpeedType;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    String internalDateTime() {
        return this.internalDateTime;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Integer heading() {
        return this.heading;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Integer headingTolerance() {
        return this.headingTolerance;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    String preferredSide() {
        return this.preferredSide;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Integer searchCutoff() {
        return this.searchCutoff;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    List<String> avoidLocations() {
        return this.avoidLocations;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    List<String> internalAvoidPolygons() {
        return this.internalAvoidPolygons;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    String routeName() {
        return this.routeName;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Double useFerry() {
        return this.useFerry;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Double useHighway() {
        return this.useHighway;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Integer alternatives() {
        return this.alternatives;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Boolean excludeTunnel() {
        return this.excludeTunnel;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Boolean excludeBridge() {
        return this.excludeBridge;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Boolean avoidTolls() {
        return this.avoidTolls;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    String minRouteClass() {
        return this.minRouteClass;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    String maxRouteClass() {
        return this.maxRouteClass;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Double height() {
        return this.height;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Double width() {
        return this.width;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Double length() {
        return this.length;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Double weight() {
        return this.weight;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Double axleLoad() {
        return this.axleLoad;
    }

    @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections
    Boolean hazmat() {
        return this.hazmat;
    }

    public String toString() {
        return "MapplsPredictiveDirections{baseUrl=" + this.baseUrl + ", coordinates=" + this.coordinates + ", profile=" + this.profile + ", internalSpeedType=" + this.internalSpeedType + ", internalDateTime=" + this.internalDateTime + ", heading=" + this.heading + ", headingTolerance=" + this.headingTolerance + ", preferredSide=" + this.preferredSide + ", searchCutoff=" + this.searchCutoff + ", avoidLocations=" + this.avoidLocations + ", internalAvoidPolygons=" + this.internalAvoidPolygons + ", routeName=" + this.routeName + ", useFerry=" + this.useFerry + ", useHighway=" + this.useHighway + ", alternatives=" + this.alternatives + ", excludeTunnel=" + this.excludeTunnel + ", excludeBridge=" + this.excludeBridge + ", avoidTolls=" + this.avoidTolls + ", minRouteClass=" + this.minRouteClass + ", maxRouteClass=" + this.maxRouteClass + ", height=" + this.height + ", width=" + this.width + ", length=" + this.length + ", weight=" + this.weight + ", axleLoad=" + this.axleLoad + ", hazmat=" + this.hazmat + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Integer num;
        Integer num2;
        String str3;
        Integer num3;
        List<String> list;
        List<String> list2;
        String str4;
        Double d;
        Double d2;
        Integer num4;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        String str5;
        String str6;
        Double d3;
        Double d4;
        Double d5;
        Double d6;
        Double d7;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsPredictiveDirections)) {
            return false;
        }
        MapplsPredictiveDirections mapplsPredictiveDirections = (MapplsPredictiveDirections) obj;
        if (this.baseUrl.equals(mapplsPredictiveDirections.baseUrl()) && this.coordinates.equals(mapplsPredictiveDirections.coordinates()) && this.profile.equals(mapplsPredictiveDirections.profile()) && ((str = this.internalSpeedType) != null ? str.equals(mapplsPredictiveDirections.internalSpeedType()) : mapplsPredictiveDirections.internalSpeedType() == null) && ((str2 = this.internalDateTime) != null ? str2.equals(mapplsPredictiveDirections.internalDateTime()) : mapplsPredictiveDirections.internalDateTime() == null) && ((num = this.heading) != null ? num.equals(mapplsPredictiveDirections.heading()) : mapplsPredictiveDirections.heading() == null) && ((num2 = this.headingTolerance) != null ? num2.equals(mapplsPredictiveDirections.headingTolerance()) : mapplsPredictiveDirections.headingTolerance() == null) && ((str3 = this.preferredSide) != null ? str3.equals(mapplsPredictiveDirections.preferredSide()) : mapplsPredictiveDirections.preferredSide() == null) && ((num3 = this.searchCutoff) != null ? num3.equals(mapplsPredictiveDirections.searchCutoff()) : mapplsPredictiveDirections.searchCutoff() == null) && ((list = this.avoidLocations) != null ? list.equals(mapplsPredictiveDirections.avoidLocations()) : mapplsPredictiveDirections.avoidLocations() == null) && ((list2 = this.internalAvoidPolygons) != null ? list2.equals(mapplsPredictiveDirections.internalAvoidPolygons()) : mapplsPredictiveDirections.internalAvoidPolygons() == null) && ((str4 = this.routeName) != null ? str4.equals(mapplsPredictiveDirections.routeName()) : mapplsPredictiveDirections.routeName() == null) && ((d = this.useFerry) != null ? d.equals(mapplsPredictiveDirections.useFerry()) : mapplsPredictiveDirections.useFerry() == null) && ((d2 = this.useHighway) != null ? d2.equals(mapplsPredictiveDirections.useHighway()) : mapplsPredictiveDirections.useHighway() == null) && ((num4 = this.alternatives) != null ? num4.equals(mapplsPredictiveDirections.alternatives()) : mapplsPredictiveDirections.alternatives() == null) && ((bool = this.excludeTunnel) != null ? bool.equals(mapplsPredictiveDirections.excludeTunnel()) : mapplsPredictiveDirections.excludeTunnel() == null) && ((bool2 = this.excludeBridge) != null ? bool2.equals(mapplsPredictiveDirections.excludeBridge()) : mapplsPredictiveDirections.excludeBridge() == null) && ((bool3 = this.avoidTolls) != null ? bool3.equals(mapplsPredictiveDirections.avoidTolls()) : mapplsPredictiveDirections.avoidTolls() == null) && ((str5 = this.minRouteClass) != null ? str5.equals(mapplsPredictiveDirections.minRouteClass()) : mapplsPredictiveDirections.minRouteClass() == null) && ((str6 = this.maxRouteClass) != null ? str6.equals(mapplsPredictiveDirections.maxRouteClass()) : mapplsPredictiveDirections.maxRouteClass() == null) && ((d3 = this.height) != null ? d3.equals(mapplsPredictiveDirections.height()) : mapplsPredictiveDirections.height() == null) && ((d4 = this.width) != null ? d4.equals(mapplsPredictiveDirections.width()) : mapplsPredictiveDirections.width() == null) && ((d5 = this.length) != null ? d5.equals(mapplsPredictiveDirections.length()) : mapplsPredictiveDirections.length() == null) && ((d6 = this.weight) != null ? d6.equals(mapplsPredictiveDirections.weight()) : mapplsPredictiveDirections.weight() == null) && ((d7 = this.axleLoad) != null ? d7.equals(mapplsPredictiveDirections.axleLoad()) : mapplsPredictiveDirections.axleLoad() == null)) {
            Boolean bool4 = this.hazmat;
            if (bool4 == null) {
                if (mapplsPredictiveDirections.hazmat() == null) {
                    return true;
                }
            } else if (bool4.equals(mapplsPredictiveDirections.hazmat())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.coordinates.hashCode()) * 1000003) ^ this.profile.hashCode()) * 1000003;
        String str = this.internalSpeedType;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.internalDateTime;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.heading;
        int iHashCode4 = (iHashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.headingTolerance;
        int iHashCode5 = (iHashCode4 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str3 = this.preferredSide;
        int iHashCode6 = (iHashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num3 = this.searchCutoff;
        int iHashCode7 = (iHashCode6 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
        List<String> list = this.avoidLocations;
        int iHashCode8 = (iHashCode7 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.internalAvoidPolygons;
        int iHashCode9 = (iHashCode8 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        String str4 = this.routeName;
        int iHashCode10 = (iHashCode9 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Double d = this.useFerry;
        int iHashCode11 = (iHashCode10 ^ (d == null ? 0 : d.hashCode())) * 1000003;
        Double d2 = this.useHighway;
        int iHashCode12 = (iHashCode11 ^ (d2 == null ? 0 : d2.hashCode())) * 1000003;
        Integer num4 = this.alternatives;
        int iHashCode13 = (iHashCode12 ^ (num4 == null ? 0 : num4.hashCode())) * 1000003;
        Boolean bool = this.excludeTunnel;
        int iHashCode14 = (iHashCode13 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Boolean bool2 = this.excludeBridge;
        int iHashCode15 = (iHashCode14 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Boolean bool3 = this.avoidTolls;
        int iHashCode16 = (iHashCode15 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        String str5 = this.minRouteClass;
        int iHashCode17 = (iHashCode16 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.maxRouteClass;
        int iHashCode18 = (iHashCode17 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Double d3 = this.height;
        int iHashCode19 = (iHashCode18 ^ (d3 == null ? 0 : d3.hashCode())) * 1000003;
        Double d4 = this.width;
        int iHashCode20 = (iHashCode19 ^ (d4 == null ? 0 : d4.hashCode())) * 1000003;
        Double d5 = this.length;
        int iHashCode21 = (iHashCode20 ^ (d5 == null ? 0 : d5.hashCode())) * 1000003;
        Double d6 = this.weight;
        int iHashCode22 = (iHashCode21 ^ (d6 == null ? 0 : d6.hashCode())) * 1000003;
        Double d7 = this.axleLoad;
        int iHashCode23 = (iHashCode22 ^ (d7 == null ? 0 : d7.hashCode())) * 1000003;
        Boolean bool4 = this.hazmat;
        return iHashCode23 ^ (bool4 != null ? bool4.hashCode() : 0);
    }

    static final class Builder extends MapplsPredictiveDirections.Builder {
        private Integer alternatives;
        private List<String> avoidLocations;
        private Boolean avoidTolls;
        private Double axleLoad;
        private String baseUrl;
        private List<String> coordinates;
        private Boolean excludeBridge;
        private Boolean excludeTunnel;
        private Boolean hazmat;
        private Integer heading;
        private Integer headingTolerance;
        private Double height;
        private List<String> internalAvoidPolygons;
        private String internalDateTime;
        private String internalSpeedType;
        private Double length;
        private String maxRouteClass;
        private String minRouteClass;
        private String preferredSide;
        private String profile;
        private String routeName;
        private Integer searchCutoff;
        private Double useFerry;
        private Double useHighway;
        private Double weight;
        private Double width;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        MapplsPredictiveDirections.Builder coordinates(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null coordinates");
            }
            this.coordinates = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder profile(String str) {
            if (str == null) {
                throw new NullPointerException("Null profile");
            }
            this.profile = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        MapplsPredictiveDirections.Builder internalSpeedType(String str) {
            this.internalSpeedType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        MapplsPredictiveDirections.Builder internalDateTime(String str) {
            this.internalDateTime = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder heading(Integer num) {
            this.heading = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder headingTolerance(Integer num) {
            this.headingTolerance = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder preferredSide(String str) {
            this.preferredSide = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder searchCutoff(Integer num) {
            this.searchCutoff = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        MapplsPredictiveDirections.Builder avoidLocations(List<String> list) {
            this.avoidLocations = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        MapplsPredictiveDirections.Builder internalAvoidPolygons(List<String> list) {
            this.internalAvoidPolygons = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder routeName(String str) {
            this.routeName = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder useFerry(Double d) {
            this.useFerry = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder useHighway(Double d) {
            this.useHighway = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder alternatives(Integer num) {
            this.alternatives = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder excludeTunnel(Boolean bool) {
            this.excludeTunnel = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder excludeBridge(Boolean bool) {
            this.excludeBridge = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder avoidTolls(Boolean bool) {
            this.avoidTolls = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder minRouteClass(String str) {
            this.minRouteClass = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder maxRouteClass(String str) {
            this.maxRouteClass = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder height(Double d) {
            this.height = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder width(Double d) {
            this.width = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder length(Double d) {
            this.length = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder weight(Double d) {
            this.weight = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder axleLoad(Double d) {
            this.axleLoad = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        public MapplsPredictiveDirections.Builder hazmat(Boolean bool) {
            this.hazmat = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirections.Builder
        MapplsPredictiveDirections autoBuild() {
            if (this.baseUrl == null || this.coordinates == null || this.profile == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.coordinates == null) {
                    sb.append(" coordinates");
                }
                if (this.profile == null) {
                    sb.append(" profile");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsPredictiveDirections(this.baseUrl, this.coordinates, this.profile, this.internalSpeedType, this.internalDateTime, this.heading, this.headingTolerance, this.preferredSide, this.searchCutoff, this.avoidLocations, this.internalAvoidPolygons, this.routeName, this.useFerry, this.useHighway, this.alternatives, this.excludeTunnel, this.excludeBridge, this.avoidTolls, this.minRouteClass, this.maxRouteClass, this.height, this.width, this.length, this.weight, this.axleLoad, this.hazmat);
        }
    }
}
