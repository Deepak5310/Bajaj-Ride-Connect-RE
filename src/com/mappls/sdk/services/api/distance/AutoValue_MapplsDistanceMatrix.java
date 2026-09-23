package com.mappls.sdk.services.api.distance;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsDistanceMatrix extends MapplsDistanceMatrix {
    private final String baseUrl;
    private final String coordinates;
    private final String destinations;
    private final String fallbackCoordinate;
    private final Double fallbackSpeed;
    private final String internalDateTime;
    private final String profile;
    private final String resource;
    private final Integer routeType;
    private final String sources;

    private AutoValue_MapplsDistanceMatrix(String str, String str2, String str3, Integer num, String str4, String str5, Double d, String str6, String str7, String str8) {
        this.coordinates = str;
        this.profile = str2;
        this.resource = str3;
        this.routeType = num;
        this.sources = str4;
        this.destinations = str5;
        this.fallbackSpeed = d;
        this.fallbackCoordinate = str6;
        this.internalDateTime = str7;
        this.baseUrl = str8;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix
    String coordinates() {
        return this.coordinates;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix
    String profile() {
        return this.profile;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix
    String resource() {
        return this.resource;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix
    Integer routeType() {
        return this.routeType;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix
    String sources() {
        return this.sources;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix
    String destinations() {
        return this.destinations;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix
    Double fallbackSpeed() {
        return this.fallbackSpeed;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix
    String fallbackCoordinate() {
        return this.fallbackCoordinate;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix
    String internalDateTime() {
        return this.internalDateTime;
    }

    @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapplsDistanceMatrix{coordinates=" + this.coordinates + ", profile=" + this.profile + ", resource=" + this.resource + ", routeType=" + this.routeType + ", sources=" + this.sources + ", destinations=" + this.destinations + ", fallbackSpeed=" + this.fallbackSpeed + ", fallbackCoordinate=" + this.fallbackCoordinate + ", internalDateTime=" + this.internalDateTime + ", baseUrl=" + this.baseUrl + "}";
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        String str2;
        Double d;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsDistanceMatrix)) {
            return false;
        }
        MapplsDistanceMatrix mapplsDistanceMatrix = (MapplsDistanceMatrix) obj;
        return this.coordinates.equals(mapplsDistanceMatrix.coordinates()) && this.profile.equals(mapplsDistanceMatrix.profile()) && this.resource.equals(mapplsDistanceMatrix.resource()) && ((num = this.routeType) != null ? num.equals(mapplsDistanceMatrix.routeType()) : mapplsDistanceMatrix.routeType() == null) && ((str = this.sources) != null ? str.equals(mapplsDistanceMatrix.sources()) : mapplsDistanceMatrix.sources() == null) && ((str2 = this.destinations) != null ? str2.equals(mapplsDistanceMatrix.destinations()) : mapplsDistanceMatrix.destinations() == null) && ((d = this.fallbackSpeed) != null ? d.equals(mapplsDistanceMatrix.fallbackSpeed()) : mapplsDistanceMatrix.fallbackSpeed() == null) && ((str3 = this.fallbackCoordinate) != null ? str3.equals(mapplsDistanceMatrix.fallbackCoordinate()) : mapplsDistanceMatrix.fallbackCoordinate() == null) && ((str4 = this.internalDateTime) != null ? str4.equals(mapplsDistanceMatrix.internalDateTime()) : mapplsDistanceMatrix.internalDateTime() == null) && this.baseUrl.equals(mapplsDistanceMatrix.baseUrl());
    }

    public int hashCode() {
        int iHashCode = (((((this.coordinates.hashCode() ^ 1000003) * 1000003) ^ this.profile.hashCode()) * 1000003) ^ this.resource.hashCode()) * 1000003;
        Integer num = this.routeType;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.sources;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.destinations;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Double d = this.fallbackSpeed;
        int iHashCode5 = (iHashCode4 ^ (d == null ? 0 : d.hashCode())) * 1000003;
        String str3 = this.fallbackCoordinate;
        int iHashCode6 = (iHashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.internalDateTime;
        return ((iHashCode6 ^ (str4 != null ? str4.hashCode() : 0)) * 1000003) ^ this.baseUrl.hashCode();
    }

    static final class Builder extends MapplsDistanceMatrix.Builder {
        private String baseUrl;
        private String coordinates;
        private String destinations;
        private String fallbackCoordinate;
        private Double fallbackSpeed;
        private String internalDateTime;
        private String profile;
        private String resource;
        private Integer routeType;
        private String sources;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        MapplsDistanceMatrix.Builder coordinates(String str) {
            if (str == null) {
                throw new NullPointerException("Null coordinates");
            }
            this.coordinates = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        public MapplsDistanceMatrix.Builder profile(String str) {
            if (str == null) {
                throw new NullPointerException("Null profile");
            }
            this.profile = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        public MapplsDistanceMatrix.Builder resource(String str) {
            if (str == null) {
                throw new NullPointerException("Null resource");
            }
            this.resource = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        public MapplsDistanceMatrix.Builder routeType(Integer num) {
            this.routeType = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        MapplsDistanceMatrix.Builder sources(String str) {
            this.sources = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        MapplsDistanceMatrix.Builder destinations(String str) {
            this.destinations = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        public MapplsDistanceMatrix.Builder fallbackSpeed(Double d) {
            this.fallbackSpeed = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        public MapplsDistanceMatrix.Builder fallbackCoordinate(String str) {
            this.fallbackCoordinate = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        MapplsDistanceMatrix.Builder internalDateTime(String str) {
            this.internalDateTime = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        public MapplsDistanceMatrix.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.distance.MapplsDistanceMatrix.Builder
        MapplsDistanceMatrix autoBuild() {
            if (this.coordinates == null || this.profile == null || this.resource == null || this.baseUrl == null) {
                StringBuilder sb = new StringBuilder();
                if (this.coordinates == null) {
                    sb.append(" coordinates");
                }
                if (this.profile == null) {
                    sb.append(" profile");
                }
                if (this.resource == null) {
                    sb.append(" resource");
                }
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsDistanceMatrix(this.coordinates, this.profile, this.resource, this.routeType, this.sources, this.destinations, this.fallbackSpeed, this.fallbackCoordinate, this.internalDateTime, this.baseUrl);
        }
    }
}
