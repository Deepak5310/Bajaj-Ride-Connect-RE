package com.mappls.sdk.services.api.directions;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsDirections extends MapplsDirections {
    private final Boolean alternatives;
    private final String annotation;
    private final String approaches;
    private final Double aux;
    private final Boolean bannerInstructions;
    private final String baseUrl;
    private final Integer batteryCapacity;
    private final String bearing;
    private final String clientAppName;
    private final Boolean continueStraight;
    private final List<String> coordinates;
    private final String deviceId;
    private final Double efficiency;
    private final String exclude;
    private final String geometries;
    private final Boolean instructions;
    private final String internalDateTime;
    private final String internalSoc;
    private final Boolean isSort;
    private final String language;
    private final Boolean lessVerbose;
    private final Integer mass;
    private final String overview;
    private final String profile;
    private final String radius;
    private final Double regen;
    private final String resource;
    private final Boolean roundaboutExits;
    private final Boolean routeRefresh;
    private final Integer routeType;
    private final String sessionId;
    private final Boolean skipWaypoints;
    private final Boolean steps;
    private final Boolean usePostMethod;
    private final String user;
    private final WalkingOptions walkingOptions;
    private final String waypointIndices;
    private final String waypointNames;
    private final String waypointTargets;

    private AutoValue_MapplsDirections(String str, String str2, String str3, List<String> list, String str4, Boolean bool, String str5, String str6, String str7, String str8, Boolean bool2, Boolean bool3, String str9, String str10, Boolean bool4, String str11, Boolean bool5, Boolean bool6, String str12, String str13, String str14, String str15, String str16, Boolean bool7, WalkingOptions walkingOptions, String str17, Boolean bool8, String str18, Boolean bool9, Boolean bool10, Boolean bool11, Integer num, String str19, String str20, Integer num2, Integer num3, Double d, Double d2, Double d3) {
        this.user = str;
        this.profile = str2;
        this.resource = str3;
        this.coordinates = list;
        this.baseUrl = str4;
        this.alternatives = bool;
        this.geometries = str5;
        this.overview = str6;
        this.radius = str7;
        this.bearing = str8;
        this.steps = bool2;
        this.lessVerbose = bool3;
        this.annotation = str9;
        this.language = str10;
        this.roundaboutExits = bool4;
        this.clientAppName = str11;
        this.continueStraight = bool5;
        this.bannerInstructions = bool6;
        this.exclude = str12;
        this.approaches = str13;
        this.waypointIndices = str14;
        this.waypointNames = str15;
        this.waypointTargets = str16;
        this.usePostMethod = bool7;
        this.walkingOptions = walkingOptions;
        this.deviceId = str17;
        this.routeRefresh = bool8;
        this.sessionId = str18;
        this.isSort = bool9;
        this.skipWaypoints = bool10;
        this.instructions = bool11;
        this.routeType = num;
        this.internalDateTime = str19;
        this.internalSoc = str20;
        this.batteryCapacity = num2;
        this.mass = num3;
        this.efficiency = d;
        this.aux = d2;
        this.regen = d3;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String user() {
        return this.user;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String profile() {
        return this.profile;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String resource() {
        return this.resource;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public List<String> coordinates() {
        return this.coordinates;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections, com.mappls.sdk.services.api.MapplsService
    public String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean alternatives() {
        return this.alternatives;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String geometries() {
        return this.geometries;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String overview() {
        return this.overview;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String radius() {
        return this.radius;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String bearing() {
        return this.bearing;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean steps() {
        return this.steps;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean lessVerbose() {
        return this.lessVerbose;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String annotation() {
        return this.annotation;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String language() {
        return this.language;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean roundaboutExits() {
        return this.roundaboutExits;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String clientAppName() {
        return this.clientAppName;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean continueStraight() {
        return this.continueStraight;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean bannerInstructions() {
        return this.bannerInstructions;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String exclude() {
        return this.exclude;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String approaches() {
        return this.approaches;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String waypointIndices() {
        return this.waypointIndices;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String waypointNames() {
        return this.waypointNames;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String waypointTargets() {
        return this.waypointTargets;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean usePostMethod() {
        return this.usePostMethod;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public WalkingOptions walkingOptions() {
        return this.walkingOptions;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String deviceId() {
        return this.deviceId;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean routeRefresh() {
        return this.routeRefresh;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String sessionId() {
        return this.sessionId;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean isSort() {
        return this.isSort;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean skipWaypoints() {
        return this.skipWaypoints;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Boolean instructions() {
        return this.instructions;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Integer routeType() {
        return this.routeType;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String internalDateTime() {
        return this.internalDateTime;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public String internalSoc() {
        return this.internalSoc;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Integer batteryCapacity() {
        return this.batteryCapacity;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Integer mass() {
        return this.mass;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Double efficiency() {
        return this.efficiency;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Double aux() {
        return this.aux;
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public Double regen() {
        return this.regen;
    }

    public String toString() {
        return "MapplsDirections{user=" + this.user + ", profile=" + this.profile + ", resource=" + this.resource + ", coordinates=" + this.coordinates + ", baseUrl=" + this.baseUrl + ", alternatives=" + this.alternatives + ", geometries=" + this.geometries + ", overview=" + this.overview + ", radius=" + this.radius + ", bearing=" + this.bearing + ", steps=" + this.steps + ", lessVerbose=" + this.lessVerbose + ", annotation=" + this.annotation + ", language=" + this.language + ", roundaboutExits=" + this.roundaboutExits + ", clientAppName=" + this.clientAppName + ", continueStraight=" + this.continueStraight + ", bannerInstructions=" + this.bannerInstructions + ", exclude=" + this.exclude + ", approaches=" + this.approaches + ", waypointIndices=" + this.waypointIndices + ", waypointNames=" + this.waypointNames + ", waypointTargets=" + this.waypointTargets + ", usePostMethod=" + this.usePostMethod + ", walkingOptions=" + this.walkingOptions + ", deviceId=" + this.deviceId + ", routeRefresh=" + this.routeRefresh + ", sessionId=" + this.sessionId + ", isSort=" + this.isSort + ", skipWaypoints=" + this.skipWaypoints + ", instructions=" + this.instructions + ", routeType=" + this.routeType + ", internalDateTime=" + this.internalDateTime + ", internalSoc=" + this.internalSoc + ", batteryCapacity=" + this.batteryCapacity + ", mass=" + this.mass + ", efficiency=" + this.efficiency + ", aux=" + this.aux + ", regen=" + this.regen + "}";
    }

    public boolean equals(Object obj) {
        Boolean bool;
        String str;
        String str2;
        String str3;
        String str4;
        Boolean bool2;
        Boolean bool3;
        String str5;
        String str6;
        Boolean bool4;
        String str7;
        Boolean bool5;
        Boolean bool6;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Boolean bool7;
        WalkingOptions walkingOptions;
        String str13;
        Boolean bool8;
        String str14;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        Integer num;
        String str15;
        String str16;
        Integer num2;
        Integer num3;
        Double d;
        Double d2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsDirections)) {
            return false;
        }
        MapplsDirections mapplsDirections = (MapplsDirections) obj;
        if (this.user.equals(mapplsDirections.user()) && this.profile.equals(mapplsDirections.profile()) && this.resource.equals(mapplsDirections.resource()) && this.coordinates.equals(mapplsDirections.coordinates()) && this.baseUrl.equals(mapplsDirections.baseUrl()) && ((bool = this.alternatives) != null ? bool.equals(mapplsDirections.alternatives()) : mapplsDirections.alternatives() == null) && ((str = this.geometries) != null ? str.equals(mapplsDirections.geometries()) : mapplsDirections.geometries() == null) && ((str2 = this.overview) != null ? str2.equals(mapplsDirections.overview()) : mapplsDirections.overview() == null) && ((str3 = this.radius) != null ? str3.equals(mapplsDirections.radius()) : mapplsDirections.radius() == null) && ((str4 = this.bearing) != null ? str4.equals(mapplsDirections.bearing()) : mapplsDirections.bearing() == null) && ((bool2 = this.steps) != null ? bool2.equals(mapplsDirections.steps()) : mapplsDirections.steps() == null) && ((bool3 = this.lessVerbose) != null ? bool3.equals(mapplsDirections.lessVerbose()) : mapplsDirections.lessVerbose() == null) && ((str5 = this.annotation) != null ? str5.equals(mapplsDirections.annotation()) : mapplsDirections.annotation() == null) && ((str6 = this.language) != null ? str6.equals(mapplsDirections.language()) : mapplsDirections.language() == null) && ((bool4 = this.roundaboutExits) != null ? bool4.equals(mapplsDirections.roundaboutExits()) : mapplsDirections.roundaboutExits() == null) && ((str7 = this.clientAppName) != null ? str7.equals(mapplsDirections.clientAppName()) : mapplsDirections.clientAppName() == null) && ((bool5 = this.continueStraight) != null ? bool5.equals(mapplsDirections.continueStraight()) : mapplsDirections.continueStraight() == null) && ((bool6 = this.bannerInstructions) != null ? bool6.equals(mapplsDirections.bannerInstructions()) : mapplsDirections.bannerInstructions() == null) && ((str8 = this.exclude) != null ? str8.equals(mapplsDirections.exclude()) : mapplsDirections.exclude() == null) && ((str9 = this.approaches) != null ? str9.equals(mapplsDirections.approaches()) : mapplsDirections.approaches() == null) && ((str10 = this.waypointIndices) != null ? str10.equals(mapplsDirections.waypointIndices()) : mapplsDirections.waypointIndices() == null) && ((str11 = this.waypointNames) != null ? str11.equals(mapplsDirections.waypointNames()) : mapplsDirections.waypointNames() == null) && ((str12 = this.waypointTargets) != null ? str12.equals(mapplsDirections.waypointTargets()) : mapplsDirections.waypointTargets() == null) && ((bool7 = this.usePostMethod) != null ? bool7.equals(mapplsDirections.usePostMethod()) : mapplsDirections.usePostMethod() == null) && ((walkingOptions = this.walkingOptions) != null ? walkingOptions.equals(mapplsDirections.walkingOptions()) : mapplsDirections.walkingOptions() == null) && ((str13 = this.deviceId) != null ? str13.equals(mapplsDirections.deviceId()) : mapplsDirections.deviceId() == null) && ((bool8 = this.routeRefresh) != null ? bool8.equals(mapplsDirections.routeRefresh()) : mapplsDirections.routeRefresh() == null) && ((str14 = this.sessionId) != null ? str14.equals(mapplsDirections.sessionId()) : mapplsDirections.sessionId() == null) && ((bool9 = this.isSort) != null ? bool9.equals(mapplsDirections.isSort()) : mapplsDirections.isSort() == null) && ((bool10 = this.skipWaypoints) != null ? bool10.equals(mapplsDirections.skipWaypoints()) : mapplsDirections.skipWaypoints() == null) && ((bool11 = this.instructions) != null ? bool11.equals(mapplsDirections.instructions()) : mapplsDirections.instructions() == null) && ((num = this.routeType) != null ? num.equals(mapplsDirections.routeType()) : mapplsDirections.routeType() == null) && ((str15 = this.internalDateTime) != null ? str15.equals(mapplsDirections.internalDateTime()) : mapplsDirections.internalDateTime() == null) && ((str16 = this.internalSoc) != null ? str16.equals(mapplsDirections.internalSoc()) : mapplsDirections.internalSoc() == null) && ((num2 = this.batteryCapacity) != null ? num2.equals(mapplsDirections.batteryCapacity()) : mapplsDirections.batteryCapacity() == null) && ((num3 = this.mass) != null ? num3.equals(mapplsDirections.mass()) : mapplsDirections.mass() == null) && ((d = this.efficiency) != null ? d.equals(mapplsDirections.efficiency()) : mapplsDirections.efficiency() == null) && ((d2 = this.aux) != null ? d2.equals(mapplsDirections.aux()) : mapplsDirections.aux() == null)) {
            Double d3 = this.regen;
            if (d3 == null) {
                if (mapplsDirections.regen() == null) {
                    return true;
                }
            } else if (d3.equals(mapplsDirections.regen())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((((((this.user.hashCode() ^ 1000003) * 1000003) ^ this.profile.hashCode()) * 1000003) ^ this.resource.hashCode()) * 1000003) ^ this.coordinates.hashCode()) * 1000003) ^ this.baseUrl.hashCode()) * 1000003;
        Boolean bool = this.alternatives;
        int iHashCode2 = (iHashCode ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str = this.geometries;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.overview;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.radius;
        int iHashCode5 = (iHashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.bearing;
        int iHashCode6 = (iHashCode5 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Boolean bool2 = this.steps;
        int iHashCode7 = (iHashCode6 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Boolean bool3 = this.lessVerbose;
        int iHashCode8 = (iHashCode7 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        String str5 = this.annotation;
        int iHashCode9 = (iHashCode8 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.language;
        int iHashCode10 = (iHashCode9 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Boolean bool4 = this.roundaboutExits;
        int iHashCode11 = (iHashCode10 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
        String str7 = this.clientAppName;
        int iHashCode12 = (iHashCode11 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        Boolean bool5 = this.continueStraight;
        int iHashCode13 = (iHashCode12 ^ (bool5 == null ? 0 : bool5.hashCode())) * 1000003;
        Boolean bool6 = this.bannerInstructions;
        int iHashCode14 = (iHashCode13 ^ (bool6 == null ? 0 : bool6.hashCode())) * 1000003;
        String str8 = this.exclude;
        int iHashCode15 = (iHashCode14 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.approaches;
        int iHashCode16 = (iHashCode15 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.waypointIndices;
        int iHashCode17 = (iHashCode16 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.waypointNames;
        int iHashCode18 = (iHashCode17 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.waypointTargets;
        int iHashCode19 = (iHashCode18 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        Boolean bool7 = this.usePostMethod;
        int iHashCode20 = (iHashCode19 ^ (bool7 == null ? 0 : bool7.hashCode())) * 1000003;
        WalkingOptions walkingOptions = this.walkingOptions;
        int iHashCode21 = (iHashCode20 ^ (walkingOptions == null ? 0 : walkingOptions.hashCode())) * 1000003;
        String str13 = this.deviceId;
        int iHashCode22 = (iHashCode21 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        Boolean bool8 = this.routeRefresh;
        int iHashCode23 = (iHashCode22 ^ (bool8 == null ? 0 : bool8.hashCode())) * 1000003;
        String str14 = this.sessionId;
        int iHashCode24 = (iHashCode23 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        Boolean bool9 = this.isSort;
        int iHashCode25 = (iHashCode24 ^ (bool9 == null ? 0 : bool9.hashCode())) * 1000003;
        Boolean bool10 = this.skipWaypoints;
        int iHashCode26 = (iHashCode25 ^ (bool10 == null ? 0 : bool10.hashCode())) * 1000003;
        Boolean bool11 = this.instructions;
        int iHashCode27 = (iHashCode26 ^ (bool11 == null ? 0 : bool11.hashCode())) * 1000003;
        Integer num = this.routeType;
        int iHashCode28 = (iHashCode27 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str15 = this.internalDateTime;
        int iHashCode29 = (iHashCode28 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.internalSoc;
        int iHashCode30 = (iHashCode29 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        Integer num2 = this.batteryCapacity;
        int iHashCode31 = (iHashCode30 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Integer num3 = this.mass;
        int iHashCode32 = (iHashCode31 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
        Double d = this.efficiency;
        int iHashCode33 = (iHashCode32 ^ (d == null ? 0 : d.hashCode())) * 1000003;
        Double d2 = this.aux;
        int iHashCode34 = (iHashCode33 ^ (d2 == null ? 0 : d2.hashCode())) * 1000003;
        Double d3 = this.regen;
        return iHashCode34 ^ (d3 != null ? d3.hashCode() : 0);
    }

    @Override // com.mappls.sdk.services.api.directions.MapplsDirections
    public MapplsDirections.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends MapplsDirections.Builder {
        private Boolean alternatives;
        private String annotation;
        private String approaches;
        private Double aux;
        private Boolean bannerInstructions;
        private String baseUrl;
        private Integer batteryCapacity;
        private String bearing;
        private String clientAppName;
        private Boolean continueStraight;
        private List<String> coordinates;
        private String deviceId;
        private Double efficiency;
        private String exclude;
        private String geometries;
        private Boolean instructions;
        private String internalDateTime;
        private String internalSoc;
        private Boolean isSort;
        private String language;
        private Boolean lessVerbose;
        private Integer mass;
        private String overview;
        private String profile;
        private String radius;
        private Double regen;
        private String resource;
        private Boolean roundaboutExits;
        private Boolean routeRefresh;
        private Integer routeType;
        private String sessionId;
        private Boolean skipWaypoints;
        private Boolean steps;
        private Boolean usePostMethod;
        private String user;
        private WalkingOptions walkingOptions;
        private String waypointIndices;
        private String waypointNames;
        private String waypointTargets;

        Builder() {
        }

        private Builder(MapplsDirections mapplsDirections) {
            this.user = mapplsDirections.user();
            this.profile = mapplsDirections.profile();
            this.resource = mapplsDirections.resource();
            this.coordinates = mapplsDirections.coordinates();
            this.baseUrl = mapplsDirections.baseUrl();
            this.alternatives = mapplsDirections.alternatives();
            this.geometries = mapplsDirections.geometries();
            this.overview = mapplsDirections.overview();
            this.radius = mapplsDirections.radius();
            this.bearing = mapplsDirections.bearing();
            this.steps = mapplsDirections.steps();
            this.lessVerbose = mapplsDirections.lessVerbose();
            this.annotation = mapplsDirections.annotation();
            this.language = mapplsDirections.language();
            this.roundaboutExits = mapplsDirections.roundaboutExits();
            this.clientAppName = mapplsDirections.clientAppName();
            this.continueStraight = mapplsDirections.continueStraight();
            this.bannerInstructions = mapplsDirections.bannerInstructions();
            this.exclude = mapplsDirections.exclude();
            this.approaches = mapplsDirections.approaches();
            this.waypointIndices = mapplsDirections.waypointIndices();
            this.waypointNames = mapplsDirections.waypointNames();
            this.waypointTargets = mapplsDirections.waypointTargets();
            this.usePostMethod = mapplsDirections.usePostMethod();
            this.walkingOptions = mapplsDirections.walkingOptions();
            this.deviceId = mapplsDirections.deviceId();
            this.routeRefresh = mapplsDirections.routeRefresh();
            this.sessionId = mapplsDirections.sessionId();
            this.isSort = mapplsDirections.isSort();
            this.skipWaypoints = mapplsDirections.skipWaypoints();
            this.instructions = mapplsDirections.instructions();
            this.routeType = mapplsDirections.routeType();
            this.internalDateTime = mapplsDirections.internalDateTime();
            this.internalSoc = mapplsDirections.internalSoc();
            this.batteryCapacity = mapplsDirections.batteryCapacity();
            this.mass = mapplsDirections.mass();
            this.efficiency = mapplsDirections.efficiency();
            this.aux = mapplsDirections.aux();
            this.regen = mapplsDirections.regen();
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder user(String str) {
            if (str == null) {
                throw new NullPointerException("Null user");
            }
            this.user = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder profile(String str) {
            if (str == null) {
                throw new NullPointerException("Null profile");
            }
            this.profile = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder resource(String str) {
            if (str == null) {
                throw new NullPointerException("Null resource");
            }
            this.resource = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder coordinates(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null coordinates");
            }
            this.coordinates = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder alternatives(Boolean bool) {
            this.alternatives = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder geometries(String str) {
            this.geometries = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder overview(String str) {
            this.overview = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder radius(String str) {
            this.radius = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder bearing(String str) {
            this.bearing = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder steps(Boolean bool) {
            this.steps = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder lessVerbose(Boolean bool) {
            this.lessVerbose = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder annotation(String str) {
            this.annotation = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder language(String str) {
            this.language = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder roundaboutExits(Boolean bool) {
            this.roundaboutExits = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder continueStraight(Boolean bool) {
            this.continueStraight = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder bannerInstructions(Boolean bool) {
            this.bannerInstructions = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder exclude(String str) {
            this.exclude = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder approaches(String str) {
            this.approaches = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder waypointIndices(String str) {
            this.waypointIndices = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder waypointNames(String str) {
            this.waypointNames = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder waypointTargets(String str) {
            this.waypointTargets = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder usePostMethod(Boolean bool) {
            this.usePostMethod = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        Boolean usePostMethod() {
            return this.usePostMethod;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder walkingOptions(WalkingOptions walkingOptions) {
            this.walkingOptions = walkingOptions;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        WalkingOptions walkingOptions() {
            return this.walkingOptions;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder routeRefresh(Boolean bool) {
            this.routeRefresh = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder sessionId(String str) {
            this.sessionId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder isSort(Boolean bool) {
            this.isSort = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder skipWaypoints(Boolean bool) {
            this.skipWaypoints = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder instructions(Boolean bool) {
            this.instructions = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder routeType(Integer num) {
            this.routeType = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder internalDateTime(String str) {
            this.internalDateTime = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections.Builder internalSoc(String str) {
            this.internalSoc = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder batteryCapacity(Integer num) {
            this.batteryCapacity = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder mass(Integer num) {
            this.mass = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder efficiency(Double d) {
            this.efficiency = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder aux(Double d) {
            this.aux = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        public MapplsDirections.Builder regen(Double d) {
            this.regen = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directions.MapplsDirections.Builder
        MapplsDirections autoBuild() {
            if (this.user == null || this.profile == null || this.resource == null || this.coordinates == null || this.baseUrl == null) {
                StringBuilder sb = new StringBuilder();
                if (this.user == null) {
                    sb.append(" user");
                }
                if (this.profile == null) {
                    sb.append(" profile");
                }
                if (this.resource == null) {
                    sb.append(" resource");
                }
                if (this.coordinates == null) {
                    sb.append(" coordinates");
                }
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsDirections(this.user, this.profile, this.resource, this.coordinates, this.baseUrl, this.alternatives, this.geometries, this.overview, this.radius, this.bearing, this.steps, this.lessVerbose, this.annotation, this.language, this.roundaboutExits, this.clientAppName, this.continueStraight, this.bannerInstructions, this.exclude, this.approaches, this.waypointIndices, this.waypointNames, this.waypointTargets, this.usePostMethod, this.walkingOptions, this.deviceId, this.routeRefresh, this.sessionId, this.isSort, this.skipWaypoints, this.instructions, this.routeType, this.internalDateTime, this.internalSoc, this.batteryCapacity, this.mass, this.efficiency, this.aux, this.regen);
        }
    }
}
