package com.mappls.sdk.services.api.weather;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsWeather extends MapplsWeather {
    private final String baseUrl;
    private final Double latitude;
    private final Double longitude;
    private final String size;
    private final String tempUnit;
    private final String theme;
    private final Integer unit;
    private final String unitType;

    private AutoValue_MapplsWeather(String str, Double d, Double d2, String str2, String str3, String str4, String str5, Integer num) {
        this.baseUrl = str;
        this.latitude = d;
        this.longitude = d2;
        this.theme = str2;
        this.size = str3;
        this.tempUnit = str4;
        this.unitType = str5;
        this.unit = num;
    }

    @Override // com.mappls.sdk.services.api.weather.MapplsWeather, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.weather.MapplsWeather
    Double latitude() {
        return this.latitude;
    }

    @Override // com.mappls.sdk.services.api.weather.MapplsWeather
    Double longitude() {
        return this.longitude;
    }

    @Override // com.mappls.sdk.services.api.weather.MapplsWeather
    String theme() {
        return this.theme;
    }

    @Override // com.mappls.sdk.services.api.weather.MapplsWeather
    String size() {
        return this.size;
    }

    @Override // com.mappls.sdk.services.api.weather.MapplsWeather
    String tempUnit() {
        return this.tempUnit;
    }

    @Override // com.mappls.sdk.services.api.weather.MapplsWeather
    String unitType() {
        return this.unitType;
    }

    @Override // com.mappls.sdk.services.api.weather.MapplsWeather
    Integer unit() {
        return this.unit;
    }

    public String toString() {
        return "MapplsWeather{baseUrl=" + this.baseUrl + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", theme=" + this.theme + ", size=" + this.size + ", tempUnit=" + this.tempUnit + ", unitType=" + this.unitType + ", unit=" + this.unit + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsWeather)) {
            return false;
        }
        MapplsWeather mapplsWeather = (MapplsWeather) obj;
        if (this.baseUrl.equals(mapplsWeather.baseUrl()) && this.latitude.equals(mapplsWeather.latitude()) && this.longitude.equals(mapplsWeather.longitude()) && this.theme.equals(mapplsWeather.theme()) && this.size.equals(mapplsWeather.size()) && ((str = this.tempUnit) != null ? str.equals(mapplsWeather.tempUnit()) : mapplsWeather.tempUnit() == null) && ((str2 = this.unitType) != null ? str2.equals(mapplsWeather.unitType()) : mapplsWeather.unitType() == null)) {
            Integer num = this.unit;
            if (num == null) {
                if (mapplsWeather.unit() == null) {
                    return true;
                }
            } else if (num.equals(mapplsWeather.unit())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.latitude.hashCode()) * 1000003) ^ this.longitude.hashCode()) * 1000003) ^ this.theme.hashCode()) * 1000003) ^ this.size.hashCode()) * 1000003;
        String str = this.tempUnit;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.unitType;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.unit;
        return iHashCode3 ^ (num != null ? num.hashCode() : 0);
    }

    static final class Builder extends MapplsWeather.Builder {
        private String baseUrl;
        private Double latitude;
        private Double longitude;
        private String size;
        private String tempUnit;
        private String theme;
        private Integer unit;
        private String unitType;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.weather.MapplsWeather.Builder
        public MapplsWeather.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.weather.MapplsWeather.Builder
        MapplsWeather.Builder latitude(Double d) {
            if (d == null) {
                throw new NullPointerException("Null latitude");
            }
            this.latitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.weather.MapplsWeather.Builder
        MapplsWeather.Builder longitude(Double d) {
            if (d == null) {
                throw new NullPointerException("Null longitude");
            }
            this.longitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.weather.MapplsWeather.Builder
        public MapplsWeather.Builder theme(String str) {
            if (str == null) {
                throw new NullPointerException("Null theme");
            }
            this.theme = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.weather.MapplsWeather.Builder
        public MapplsWeather.Builder size(String str) {
            if (str == null) {
                throw new NullPointerException("Null size");
            }
            this.size = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.weather.MapplsWeather.Builder
        public MapplsWeather.Builder tempUnit(String str) {
            this.tempUnit = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.weather.MapplsWeather.Builder
        public MapplsWeather.Builder unitType(String str) {
            this.unitType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.weather.MapplsWeather.Builder
        public MapplsWeather.Builder unit(Integer num) {
            this.unit = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.weather.MapplsWeather.Builder
        MapplsWeather autoBuild() {
            if (this.baseUrl == null || this.latitude == null || this.longitude == null || this.theme == null || this.size == null) {
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
                if (this.theme == null) {
                    sb.append(" theme");
                }
                if (this.size == null) {
                    sb.append(" size");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsWeather(this.baseUrl, this.latitude, this.longitude, this.theme, this.size, this.tempUnit, this.unitType, this.unit);
        }
    }
}
