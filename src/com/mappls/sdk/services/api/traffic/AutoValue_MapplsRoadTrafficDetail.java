package com.mappls.sdk.services.api.traffic;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsRoadTrafficDetail extends MapplsRoadTrafficDetail {
    private final String baseUrl;
    private final Double latitude;
    private final Double longitude;
    private final Long radius;

    private AutoValue_MapplsRoadTrafficDetail(String str, Double d, Double d2, Long l) {
        this.baseUrl = str;
        this.latitude = d;
        this.longitude = d2;
        this.radius = l;
    }

    @Override // com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail
    Double latitude() {
        return this.latitude;
    }

    @Override // com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail
    Double longitude() {
        return this.longitude;
    }

    @Override // com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail
    Long radius() {
        return this.radius;
    }

    public String toString() {
        return "MapplsRoadTrafficDetail{baseUrl=" + this.baseUrl + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", radius=" + this.radius + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsRoadTrafficDetail)) {
            return false;
        }
        MapplsRoadTrafficDetail mapplsRoadTrafficDetail = (MapplsRoadTrafficDetail) obj;
        if (this.baseUrl.equals(mapplsRoadTrafficDetail.baseUrl()) && this.latitude.equals(mapplsRoadTrafficDetail.latitude()) && this.longitude.equals(mapplsRoadTrafficDetail.longitude())) {
            Long l = this.radius;
            if (l == null) {
                if (mapplsRoadTrafficDetail.radius() == null) {
                    return true;
                }
            } else if (l.equals(mapplsRoadTrafficDetail.radius())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.latitude.hashCode()) * 1000003) ^ this.longitude.hashCode()) * 1000003;
        Long l = this.radius;
        return iHashCode ^ (l == null ? 0 : l.hashCode());
    }

    static final class Builder extends MapplsRoadTrafficDetail.Builder {
        private String baseUrl;
        private Double latitude;
        private Double longitude;
        private Long radius;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail.Builder
        public MapplsRoadTrafficDetail.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail.Builder
        public MapplsRoadTrafficDetail.Builder latitude(Double d) {
            if (d == null) {
                throw new NullPointerException("Null latitude");
            }
            this.latitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail.Builder
        public MapplsRoadTrafficDetail.Builder longitude(Double d) {
            if (d == null) {
                throw new NullPointerException("Null longitude");
            }
            this.longitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail.Builder
        public MapplsRoadTrafficDetail.Builder radius(Long l) {
            this.radius = l;
            return this;
        }

        @Override // com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail.Builder
        public MapplsRoadTrafficDetail build() {
            if (this.baseUrl == null || this.latitude == null || this.longitude == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.latitude == null) {
                    sb.append(" latitude");
                }
                if (this.longitude == null) {
                    sb.append(" longitude");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsRoadTrafficDetail(this.baseUrl, this.latitude, this.longitude, this.radius);
        }
    }
}
