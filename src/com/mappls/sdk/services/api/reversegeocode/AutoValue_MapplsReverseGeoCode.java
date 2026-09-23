package com.mappls.sdk.services.api.reversegeocode;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsReverseGeoCode extends MapplsReverseGeoCode {
    private final String baseUrl;
    private final String lang;
    private final double latitude;
    private final double longitude;

    private AutoValue_MapplsReverseGeoCode(String str, double d, double d2, String str2) {
        this.baseUrl = str;
        this.latitude = d;
        this.longitude = d2;
        this.lang = str2;
    }

    @Override // com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode
    double latitude() {
        return this.latitude;
    }

    @Override // com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode
    double longitude() {
        return this.longitude;
    }

    @Override // com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode
    String lang() {
        return this.lang;
    }

    public String toString() {
        return "MapplsReverseGeoCode{baseUrl=" + this.baseUrl + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", lang=" + this.lang + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsReverseGeoCode)) {
            return false;
        }
        MapplsReverseGeoCode mapplsReverseGeoCode = (MapplsReverseGeoCode) obj;
        if (this.baseUrl.equals(mapplsReverseGeoCode.baseUrl()) && Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(mapplsReverseGeoCode.latitude()) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(mapplsReverseGeoCode.longitude())) {
            String str = this.lang;
            if (str == null) {
                if (mapplsReverseGeoCode.lang() == null) {
                    return true;
                }
            } else if (str.equals(mapplsReverseGeoCode.lang())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.latitude) >>> 32) ^ Double.doubleToLongBits(this.latitude)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.longitude) >>> 32) ^ Double.doubleToLongBits(this.longitude)))) * 1000003;
        String str = this.lang;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    static final class Builder extends MapplsReverseGeoCode.Builder {
        private String baseUrl;
        private String lang;
        private double latitude;
        private double longitude;
        private byte set$0;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode.Builder
        public MapplsReverseGeoCode.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode.Builder
        MapplsReverseGeoCode.Builder latitude(double d) {
            this.latitude = d;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        @Override // com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode.Builder
        MapplsReverseGeoCode.Builder longitude(double d) {
            this.longitude = d;
            this.set$0 = (byte) (this.set$0 | 2);
            return this;
        }

        @Override // com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode.Builder
        public MapplsReverseGeoCode.Builder lang(String str) {
            this.lang = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode.Builder
        MapplsReverseGeoCode autoBuild() {
            if (this.set$0 != 3 || this.baseUrl == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if ((this.set$0 & 1) == 0) {
                    sb.append(" latitude");
                }
                if ((this.set$0 & 2) == 0) {
                    sb.append(" longitude");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsReverseGeoCode(this.baseUrl, this.latitude, this.longitude, this.lang);
        }
    }
}
