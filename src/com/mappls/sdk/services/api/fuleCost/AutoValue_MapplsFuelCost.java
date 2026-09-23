package com.mappls.sdk.services.api.fuleCost;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsFuelCost extends MapplsFuelCost {
    private final String baseUrl;
    private final Double latitude;
    private final Double longitude;

    private AutoValue_MapplsFuelCost(String str, Double d, Double d2) {
        this.baseUrl = str;
        this.latitude = d;
        this.longitude = d2;
    }

    @Override // com.mappls.sdk.services.api.fuleCost.MapplsFuelCost, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.fuleCost.MapplsFuelCost
    Double latitude() {
        return this.latitude;
    }

    @Override // com.mappls.sdk.services.api.fuleCost.MapplsFuelCost
    Double longitude() {
        return this.longitude;
    }

    public String toString() {
        return "MapplsFuelCost{baseUrl=" + this.baseUrl + ", latitude=" + this.latitude + ", longitude=" + this.longitude + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsFuelCost)) {
            return false;
        }
        MapplsFuelCost mapplsFuelCost = (MapplsFuelCost) obj;
        return this.baseUrl.equals(mapplsFuelCost.baseUrl()) && this.latitude.equals(mapplsFuelCost.latitude()) && this.longitude.equals(mapplsFuelCost.longitude());
    }

    public int hashCode() {
        return ((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.latitude.hashCode()) * 1000003) ^ this.longitude.hashCode();
    }

    static final class Builder extends MapplsFuelCost.Builder {
        private String baseUrl;
        private Double latitude;
        private Double longitude;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.fuleCost.MapplsFuelCost.Builder
        public MapplsFuelCost.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.fuleCost.MapplsFuelCost.Builder
        MapplsFuelCost.Builder latitude(Double d) {
            if (d == null) {
                throw new NullPointerException("Null latitude");
            }
            this.latitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.fuleCost.MapplsFuelCost.Builder
        MapplsFuelCost.Builder longitude(Double d) {
            if (d == null) {
                throw new NullPointerException("Null longitude");
            }
            this.longitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.fuleCost.MapplsFuelCost.Builder
        MapplsFuelCost autoBuild() {
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
            return new AutoValue_MapplsFuelCost(this.baseUrl, this.latitude, this.longitude);
        }
    }
}
