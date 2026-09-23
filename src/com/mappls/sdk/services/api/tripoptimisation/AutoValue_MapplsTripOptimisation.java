package com.mappls.sdk.services.api.tripoptimisation;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsTripOptimisation extends MapplsTripOptimisation {
    private final String baseUrl;
    private final Boolean continueStraight;
    private final String destination;
    private final String destinationType;
    private final String geometries;
    private final Boolean lessVerbose;
    private final String origin;
    private final String overview;
    private final String profile;
    private final String resource;
    private final Boolean roundTrip;
    private final String sourceType;
    private final Boolean steps;
    private final List<String> waypoints;

    private AutoValue_MapplsTripOptimisation(String str, String str2, String str3, String str4, String str5, List<String> list, String str6, String str7, Boolean bool, String str8, String str9, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.baseUrl = str;
        this.profile = str2;
        this.resource = str3;
        this.origin = str4;
        this.destination = str5;
        this.waypoints = list;
        this.overview = str6;
        this.geometries = str7;
        this.steps = bool;
        this.sourceType = str8;
        this.destinationType = str9;
        this.roundTrip = bool2;
        this.lessVerbose = bool3;
        this.continueStraight = bool4;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation, com.mappls.sdk.services.api.MapplsService
    public String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    String profile() {
        return this.profile;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    String resource() {
        return this.resource;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    String origin() {
        return this.origin;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    String destination() {
        return this.destination;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    List<String> waypoints() {
        return this.waypoints;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    String overview() {
        return this.overview;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    String geometries() {
        return this.geometries;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    Boolean steps() {
        return this.steps;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    String sourceType() {
        return this.sourceType;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    String destinationType() {
        return this.destinationType;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    Boolean roundTrip() {
        return this.roundTrip;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    Boolean lessVerbose() {
        return this.lessVerbose;
    }

    @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation
    Boolean continueStraight() {
        return this.continueStraight;
    }

    public String toString() {
        return "MapplsTripOptimisation{baseUrl=" + this.baseUrl + ", profile=" + this.profile + ", resource=" + this.resource + ", origin=" + this.origin + ", destination=" + this.destination + ", waypoints=" + this.waypoints + ", overview=" + this.overview + ", geometries=" + this.geometries + ", steps=" + this.steps + ", sourceType=" + this.sourceType + ", destinationType=" + this.destinationType + ", roundTrip=" + this.roundTrip + ", lessVerbose=" + this.lessVerbose + ", continueStraight=" + this.continueStraight + "}";
    }

    public boolean equals(Object obj) {
        Boolean bool;
        String str;
        String str2;
        Boolean bool2;
        Boolean bool3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsTripOptimisation)) {
            return false;
        }
        MapplsTripOptimisation mapplsTripOptimisation = (MapplsTripOptimisation) obj;
        if (this.baseUrl.equals(mapplsTripOptimisation.baseUrl()) && this.profile.equals(mapplsTripOptimisation.profile()) && this.resource.equals(mapplsTripOptimisation.resource()) && this.origin.equals(mapplsTripOptimisation.origin()) && this.destination.equals(mapplsTripOptimisation.destination()) && this.waypoints.equals(mapplsTripOptimisation.waypoints()) && this.overview.equals(mapplsTripOptimisation.overview()) && this.geometries.equals(mapplsTripOptimisation.geometries()) && ((bool = this.steps) != null ? bool.equals(mapplsTripOptimisation.steps()) : mapplsTripOptimisation.steps() == null) && ((str = this.sourceType) != null ? str.equals(mapplsTripOptimisation.sourceType()) : mapplsTripOptimisation.sourceType() == null) && ((str2 = this.destinationType) != null ? str2.equals(mapplsTripOptimisation.destinationType()) : mapplsTripOptimisation.destinationType() == null) && ((bool2 = this.roundTrip) != null ? bool2.equals(mapplsTripOptimisation.roundTrip()) : mapplsTripOptimisation.roundTrip() == null) && ((bool3 = this.lessVerbose) != null ? bool3.equals(mapplsTripOptimisation.lessVerbose()) : mapplsTripOptimisation.lessVerbose() == null)) {
            Boolean bool4 = this.continueStraight;
            if (bool4 == null) {
                if (mapplsTripOptimisation.continueStraight() == null) {
                    return true;
                }
            } else if (bool4.equals(mapplsTripOptimisation.continueStraight())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((((((((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.profile.hashCode()) * 1000003) ^ this.resource.hashCode()) * 1000003) ^ this.origin.hashCode()) * 1000003) ^ this.destination.hashCode()) * 1000003) ^ this.waypoints.hashCode()) * 1000003) ^ this.overview.hashCode()) * 1000003) ^ this.geometries.hashCode()) * 1000003;
        Boolean bool = this.steps;
        int iHashCode2 = (iHashCode ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str = this.sourceType;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.destinationType;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Boolean bool2 = this.roundTrip;
        int iHashCode5 = (iHashCode4 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Boolean bool3 = this.lessVerbose;
        int iHashCode6 = (iHashCode5 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        Boolean bool4 = this.continueStraight;
        return iHashCode6 ^ (bool4 != null ? bool4.hashCode() : 0);
    }

    static final class Builder extends MapplsTripOptimisation.Builder {
        private String baseUrl;
        private Boolean continueStraight;
        private String destination;
        private String destinationType;
        private String geometries;
        private Boolean lessVerbose;
        private String origin;
        private String overview;
        private String profile;
        private String resource;
        private Boolean roundTrip;
        private String sourceType;
        private Boolean steps;
        private List<String> waypoints;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder profile(String str) {
            if (str == null) {
                throw new NullPointerException("Null profile");
            }
            this.profile = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder resource(String str) {
            if (str == null) {
                throw new NullPointerException("Null resource");
            }
            this.resource = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder origin(String str) {
            if (str == null) {
                throw new NullPointerException("Null origin");
            }
            this.origin = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder destination(String str) {
            if (str == null) {
                throw new NullPointerException("Null destination");
            }
            this.destination = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        MapplsTripOptimisation.Builder waypoints(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null waypoints");
            }
            this.waypoints = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder overview(String str) {
            if (str == null) {
                throw new NullPointerException("Null overview");
            }
            this.overview = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder geometries(String str) {
            if (str == null) {
                throw new NullPointerException("Null geometries");
            }
            this.geometries = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder steps(Boolean bool) {
            this.steps = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder sourceType(String str) {
            this.sourceType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder destinationType(String str) {
            this.destinationType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder roundTrip(Boolean bool) {
            this.roundTrip = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder lessVerbose(Boolean bool) {
            this.lessVerbose = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        public MapplsTripOptimisation.Builder continueStraight(Boolean bool) {
            this.continueStraight = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation.Builder
        MapplsTripOptimisation autoBuild() {
            if (this.baseUrl == null || this.profile == null || this.resource == null || this.origin == null || this.destination == null || this.waypoints == null || this.overview == null || this.geometries == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.profile == null) {
                    sb.append(" profile");
                }
                if (this.resource == null) {
                    sb.append(" resource");
                }
                if (this.origin == null) {
                    sb.append(" origin");
                }
                if (this.destination == null) {
                    sb.append(" destination");
                }
                if (this.waypoints == null) {
                    sb.append(" waypoints");
                }
                if (this.overview == null) {
                    sb.append(" overview");
                }
                if (this.geometries == null) {
                    sb.append(" geometries");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsTripOptimisation(this.baseUrl, this.profile, this.resource, this.origin, this.destination, this.waypoints, this.overview, this.geometries, this.steps, this.sourceType, this.destinationType, this.roundTrip, this.lessVerbose, this.continueStraight);
        }
    }
}
