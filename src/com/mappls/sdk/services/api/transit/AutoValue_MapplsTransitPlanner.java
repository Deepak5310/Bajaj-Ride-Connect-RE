package com.mappls.sdk.services.api.transit;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsTransitPlanner extends MapplsTransitPlanner {
    private final Boolean arriveBy;
    private final String baseUrl;
    private final String date;
    private final String destination;
    private final Integer maxTransfers;
    private final String mode;
    private final Boolean optimalRoute;
    private final String origin;
    private final Integer searchWindow;
    private final Boolean showIntermediateStops;
    private final String time;
    private final Double walkSpeed;

    private AutoValue_MapplsTransitPlanner(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, Integer num, Integer num2, Boolean bool3, Double d) {
        this.baseUrl = str;
        this.mode = str2;
        this.origin = str3;
        this.destination = str4;
        this.date = str5;
        this.time = str6;
        this.arriveBy = bool;
        this.optimalRoute = bool2;
        this.searchWindow = num;
        this.maxTransfers = num2;
        this.showIntermediateStops = bool3;
        this.walkSpeed = d;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner, com.mappls.sdk.services.api.MapplsService
    public String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    String mode() {
        return this.mode;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    String origin() {
        return this.origin;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    String destination() {
        return this.destination;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    String date() {
        return this.date;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    String time() {
        return this.time;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    Boolean arriveBy() {
        return this.arriveBy;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    Boolean optimalRoute() {
        return this.optimalRoute;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    Integer searchWindow() {
        return this.searchWindow;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    Integer maxTransfers() {
        return this.maxTransfers;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    Boolean showIntermediateStops() {
        return this.showIntermediateStops;
    }

    @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner
    Double walkSpeed() {
        return this.walkSpeed;
    }

    public String toString() {
        return "MapplsTransitPlanner{baseUrl=" + this.baseUrl + ", mode=" + this.mode + ", origin=" + this.origin + ", destination=" + this.destination + ", date=" + this.date + ", time=" + this.time + ", arriveBy=" + this.arriveBy + ", optimalRoute=" + this.optimalRoute + ", searchWindow=" + this.searchWindow + ", maxTransfers=" + this.maxTransfers + ", showIntermediateStops=" + this.showIntermediateStops + ", walkSpeed=" + this.walkSpeed + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Boolean bool;
        Boolean bool2;
        Integer num;
        Integer num2;
        Boolean bool3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsTransitPlanner)) {
            return false;
        }
        MapplsTransitPlanner mapplsTransitPlanner = (MapplsTransitPlanner) obj;
        if (this.baseUrl.equals(mapplsTransitPlanner.baseUrl()) && this.mode.equals(mapplsTransitPlanner.mode()) && this.origin.equals(mapplsTransitPlanner.origin()) && this.destination.equals(mapplsTransitPlanner.destination()) && ((str = this.date) != null ? str.equals(mapplsTransitPlanner.date()) : mapplsTransitPlanner.date() == null) && ((str2 = this.time) != null ? str2.equals(mapplsTransitPlanner.time()) : mapplsTransitPlanner.time() == null) && ((bool = this.arriveBy) != null ? bool.equals(mapplsTransitPlanner.arriveBy()) : mapplsTransitPlanner.arriveBy() == null) && ((bool2 = this.optimalRoute) != null ? bool2.equals(mapplsTransitPlanner.optimalRoute()) : mapplsTransitPlanner.optimalRoute() == null) && ((num = this.searchWindow) != null ? num.equals(mapplsTransitPlanner.searchWindow()) : mapplsTransitPlanner.searchWindow() == null) && ((num2 = this.maxTransfers) != null ? num2.equals(mapplsTransitPlanner.maxTransfers()) : mapplsTransitPlanner.maxTransfers() == null) && ((bool3 = this.showIntermediateStops) != null ? bool3.equals(mapplsTransitPlanner.showIntermediateStops()) : mapplsTransitPlanner.showIntermediateStops() == null)) {
            Double d = this.walkSpeed;
            if (d == null) {
                if (mapplsTransitPlanner.walkSpeed() == null) {
                    return true;
                }
            } else if (d.equals(mapplsTransitPlanner.walkSpeed())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.mode.hashCode()) * 1000003) ^ this.origin.hashCode()) * 1000003) ^ this.destination.hashCode()) * 1000003;
        String str = this.date;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.time;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Boolean bool = this.arriveBy;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Boolean bool2 = this.optimalRoute;
        int iHashCode5 = (iHashCode4 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Integer num = this.searchWindow;
        int iHashCode6 = (iHashCode5 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.maxTransfers;
        int iHashCode7 = (iHashCode6 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Boolean bool3 = this.showIntermediateStops;
        int iHashCode8 = (iHashCode7 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        Double d = this.walkSpeed;
        return iHashCode8 ^ (d != null ? d.hashCode() : 0);
    }

    static final class Builder extends MapplsTransitPlanner.Builder {
        private Boolean arriveBy;
        private String baseUrl;
        private String date;
        private String destination;
        private Integer maxTransfers;
        private String mode;
        private Boolean optimalRoute;
        private String origin;
        private Integer searchWindow;
        private Boolean showIntermediateStops;
        private String time;
        private Double walkSpeed;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder mode(String str) {
            if (str == null) {
                throw new NullPointerException("Null mode");
            }
            this.mode = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder origin(String str) {
            if (str == null) {
                throw new NullPointerException("Null origin");
            }
            this.origin = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder destination(String str) {
            if (str == null) {
                throw new NullPointerException("Null destination");
            }
            this.destination = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder date(String str) {
            this.date = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder time(String str) {
            this.time = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder arriveBy(Boolean bool) {
            this.arriveBy = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder optimalRoute(Boolean bool) {
            this.optimalRoute = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder searchWindow(Integer num) {
            this.searchWindow = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder maxTransfers(Integer num) {
            this.maxTransfers = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder showIntermediateStops(Boolean bool) {
            this.showIntermediateStops = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        public MapplsTransitPlanner.Builder walkSpeed(Double d) {
            this.walkSpeed = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.transit.MapplsTransitPlanner.Builder
        MapplsTransitPlanner autoBuild() {
            if (this.baseUrl == null || this.mode == null || this.origin == null || this.destination == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.mode == null) {
                    sb.append(" mode");
                }
                if (this.origin == null) {
                    sb.append(" origin");
                }
                if (this.destination == null) {
                    sb.append(" destination");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsTransitPlanner(this.baseUrl, this.mode, this.origin, this.destination, this.date, this.time, this.arriveBy, this.optimalRoute, this.searchWindow, this.maxTransfers, this.showIntermediateStops, this.walkSpeed);
        }
    }
}
