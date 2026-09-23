package com.mappls.sdk.services.api.geocoding;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsGeoCoding extends MapplsGeoCoding {
    private final String address;
    private final String baseUrl;
    private final Integer bias;
    private final String bound;
    private final String clientAppName;
    private final Integer itemCount;
    private final String podFilter;
    private final Boolean scores;

    private AutoValue_MapplsGeoCoding(String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, Boolean bool) {
        this.baseUrl = str;
        this.address = str2;
        this.itemCount = num;
        this.bias = num2;
        this.clientAppName = str3;
        this.podFilter = str4;
        this.bound = str5;
        this.scores = bool;
    }

    @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding
    String address() {
        return this.address;
    }

    @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding
    Integer itemCount() {
        return this.itemCount;
    }

    @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding
    Integer bias() {
        return this.bias;
    }

    @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding
    String clientAppName() {
        return this.clientAppName;
    }

    @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding
    String podFilter() {
        return this.podFilter;
    }

    @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding
    String bound() {
        return this.bound;
    }

    @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding
    Boolean scores() {
        return this.scores;
    }

    public String toString() {
        return "MapplsGeoCoding{baseUrl=" + this.baseUrl + ", address=" + this.address + ", itemCount=" + this.itemCount + ", bias=" + this.bias + ", clientAppName=" + this.clientAppName + ", podFilter=" + this.podFilter + ", bound=" + this.bound + ", scores=" + this.scores + "}";
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsGeoCoding)) {
            return false;
        }
        MapplsGeoCoding mapplsGeoCoding = (MapplsGeoCoding) obj;
        if (this.baseUrl.equals(mapplsGeoCoding.baseUrl()) && this.address.equals(mapplsGeoCoding.address()) && ((num = this.itemCount) != null ? num.equals(mapplsGeoCoding.itemCount()) : mapplsGeoCoding.itemCount() == null) && ((num2 = this.bias) != null ? num2.equals(mapplsGeoCoding.bias()) : mapplsGeoCoding.bias() == null) && ((str = this.clientAppName) != null ? str.equals(mapplsGeoCoding.clientAppName()) : mapplsGeoCoding.clientAppName() == null) && ((str2 = this.podFilter) != null ? str2.equals(mapplsGeoCoding.podFilter()) : mapplsGeoCoding.podFilter() == null) && ((str3 = this.bound) != null ? str3.equals(mapplsGeoCoding.bound()) : mapplsGeoCoding.bound() == null)) {
            Boolean bool = this.scores;
            if (bool == null) {
                if (mapplsGeoCoding.scores() == null) {
                    return true;
                }
            } else if (bool.equals(mapplsGeoCoding.scores())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.address.hashCode()) * 1000003;
        Integer num = this.itemCount;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.bias;
        int iHashCode3 = (iHashCode2 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.clientAppName;
        int iHashCode4 = (iHashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.podFilter;
        int iHashCode5 = (iHashCode4 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.bound;
        int iHashCode6 = (iHashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Boolean bool = this.scores;
        return iHashCode6 ^ (bool != null ? bool.hashCode() : 0);
    }

    static final class Builder extends MapplsGeoCoding.Builder {
        private String address;
        private String baseUrl;
        private Integer bias;
        private String bound;
        private String clientAppName;
        private Integer itemCount;
        private String podFilter;
        private Boolean scores;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding.Builder
        public MapplsGeoCoding.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding.Builder
        MapplsGeoCoding.Builder address(String str) {
            if (str == null) {
                throw new NullPointerException("Null address");
            }
            this.address = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding.Builder
        public MapplsGeoCoding.Builder itemCount(Integer num) {
            this.itemCount = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding.Builder
        public MapplsGeoCoding.Builder bias(Integer num) {
            this.bias = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding.Builder
        public MapplsGeoCoding.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding.Builder
        public MapplsGeoCoding.Builder podFilter(String str) {
            this.podFilter = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding.Builder
        public MapplsGeoCoding.Builder bound(String str) {
            this.bound = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding.Builder
        public MapplsGeoCoding.Builder scores(Boolean bool) {
            this.scores = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.geocoding.MapplsGeoCoding.Builder
        MapplsGeoCoding autoBuild() {
            if (this.baseUrl == null || this.address == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.address == null) {
                    sb.append(" address");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsGeoCoding(this.baseUrl, this.address, this.itemCount, this.bias, this.clientAppName, this.podFilter, this.bound, this.scores);
        }
    }
}
