package com.mappls.sdk.services.api.event.nearby;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsNearbyReport extends MapplsNearbyReport {
    private final String baseUrl;
    private final Double maxX;
    private final Double maxY;
    private final Double minX;
    private final Double minY;

    private AutoValue_MapplsNearbyReport(String str, Double d, Double d2, Double d3, Double d4) {
        this.baseUrl = str;
        this.minX = d;
        this.minY = d2;
        this.maxX = d3;
        this.maxY = d4;
    }

    @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport
    protected Double minX() {
        return this.minX;
    }

    @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport
    protected Double minY() {
        return this.minY;
    }

    @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport
    protected Double maxX() {
        return this.maxX;
    }

    @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport
    protected Double maxY() {
        return this.maxY;
    }

    public String toString() {
        return "MapplsNearbyReport{baseUrl=" + this.baseUrl + ", minX=" + this.minX + ", minY=" + this.minY + ", maxX=" + this.maxX + ", maxY=" + this.maxY + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsNearbyReport)) {
            return false;
        }
        MapplsNearbyReport mapplsNearbyReport = (MapplsNearbyReport) obj;
        return this.baseUrl.equals(mapplsNearbyReport.baseUrl()) && this.minX.equals(mapplsNearbyReport.minX()) && this.minY.equals(mapplsNearbyReport.minY()) && this.maxX.equals(mapplsNearbyReport.maxX()) && this.maxY.equals(mapplsNearbyReport.maxY());
    }

    public int hashCode() {
        return ((((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.minX.hashCode()) * 1000003) ^ this.minY.hashCode()) * 1000003) ^ this.maxX.hashCode()) * 1000003) ^ this.maxY.hashCode();
    }

    static final class Builder extends MapplsNearbyReport.Builder {
        private String baseUrl;
        private Double maxX;
        private Double maxY;
        private Double minX;
        private Double minY;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport.Builder
        public MapplsNearbyReport.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport.Builder
        public MapplsNearbyReport.Builder minX(Double d) {
            if (d == null) {
                throw new NullPointerException("Null minX");
            }
            this.minX = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport.Builder
        public MapplsNearbyReport.Builder minY(Double d) {
            if (d == null) {
                throw new NullPointerException("Null minY");
            }
            this.minY = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport.Builder
        public MapplsNearbyReport.Builder maxX(Double d) {
            if (d == null) {
                throw new NullPointerException("Null maxX");
            }
            this.maxX = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport.Builder
        public MapplsNearbyReport.Builder maxY(Double d) {
            if (d == null) {
                throw new NullPointerException("Null maxY");
            }
            this.maxY = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport.Builder
        MapplsNearbyReport autoBuild() {
            if (this.baseUrl == null || this.minX == null || this.minY == null || this.maxX == null || this.maxY == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.minX == null) {
                    sb.append(" minX");
                }
                if (this.minY == null) {
                    sb.append(" minY");
                }
                if (this.maxX == null) {
                    sb.append(" maxX");
                }
                if (this.maxY == null) {
                    sb.append(" maxY");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsNearbyReport(this.baseUrl, this.minX, this.minY, this.maxX, this.maxY);
        }
    }
}
