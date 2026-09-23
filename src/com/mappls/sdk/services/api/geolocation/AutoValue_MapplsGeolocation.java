package com.mappls.sdk.services.api.geolocation;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsGeolocation extends MapplsGeolocation {
    private final String baseUrl;
    private final List<GeolocationRequest> cellTowers;
    private final String radioType;

    private AutoValue_MapplsGeolocation(String str, List<GeolocationRequest> list, String str2) {
        this.baseUrl = str;
        this.cellTowers = list;
        this.radioType = str2;
    }

    @Override // com.mappls.sdk.services.api.geolocation.MapplsGeolocation, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.geolocation.MapplsGeolocation
    protected List<GeolocationRequest> cellTowers() {
        return this.cellTowers;
    }

    @Override // com.mappls.sdk.services.api.geolocation.MapplsGeolocation
    String radioType() {
        return this.radioType;
    }

    public String toString() {
        return "MapplsGeolocation{baseUrl=" + this.baseUrl + ", cellTowers=" + this.cellTowers + ", radioType=" + this.radioType + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsGeolocation)) {
            return false;
        }
        MapplsGeolocation mapplsGeolocation = (MapplsGeolocation) obj;
        if (this.baseUrl.equals(mapplsGeolocation.baseUrl()) && this.cellTowers.equals(mapplsGeolocation.cellTowers())) {
            String str = this.radioType;
            if (str == null) {
                if (mapplsGeolocation.radioType() == null) {
                    return true;
                }
            } else if (str.equals(mapplsGeolocation.radioType())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.cellTowers.hashCode()) * 1000003;
        String str = this.radioType;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    static final class Builder extends MapplsGeolocation.Builder {
        private String baseUrl;
        private List<GeolocationRequest> cellTowers;
        private String radioType;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.geolocation.MapplsGeolocation.Builder
        public MapplsGeolocation.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geolocation.MapplsGeolocation.Builder
        MapplsGeolocation.Builder cellTowers(List<GeolocationRequest> list) {
            if (list == null) {
                throw new NullPointerException("Null cellTowers");
            }
            this.cellTowers = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geolocation.MapplsGeolocation.Builder
        public MapplsGeolocation.Builder radioType(String str) {
            this.radioType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geolocation.MapplsGeolocation.Builder
        MapplsGeolocation autoBuild() {
            if (this.baseUrl == null || this.cellTowers == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.cellTowers == null) {
                    sb.append(" cellTowers");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsGeolocation(this.baseUrl, this.cellTowers, this.radioType);
        }
    }
}
