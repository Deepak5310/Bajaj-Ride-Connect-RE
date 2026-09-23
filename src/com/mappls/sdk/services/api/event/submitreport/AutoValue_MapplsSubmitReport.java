package com.mappls.sdk.services.api.event.submitreport;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsSubmitReport extends MapplsSubmitReport {
    private final Integer accuracy;
    private final Double altitude;
    private final String appVersion;
    private final String baseUrl;
    private final Integer bearing;
    private final Integer childCategory;
    private final String description;
    private final String deviceName;
    private final Long expiry;
    private final Integer flag;
    private final Double internalLatitude;
    private final Double internalLongitude;
    private final String internalMapplsPin;
    private final String osVersion;
    private final Integer parentCategory;
    private final String placeName;
    private final String quality;
    private final String speed;
    private final Integer subChildCategory;
    private final Long utc;
    private final String zeroId;

    private AutoValue_MapplsSubmitReport(String str, String str2, String str3, Double d, Double d2, Integer num, Integer num2, String str4, Integer num3, Integer num4, Integer num5, String str5, Integer num6, Double d3, String str6, Long l, Long l2, String str7, String str8, String str9, String str10) {
        this.baseUrl = str;
        this.placeName = str2;
        this.internalMapplsPin = str3;
        this.internalLatitude = d;
        this.internalLongitude = d2;
        this.parentCategory = num;
        this.childCategory = num2;
        this.description = str4;
        this.subChildCategory = num3;
        this.bearing = num4;
        this.accuracy = num5;
        this.speed = str5;
        this.flag = num6;
        this.altitude = d3;
        this.quality = str6;
        this.utc = l;
        this.expiry = l2;
        this.zeroId = str7;
        this.appVersion = str8;
        this.osVersion = str9;
        this.deviceName = str10;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    String placeName() {
        return this.placeName;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    String internalMapplsPin() {
        return this.internalMapplsPin;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Double internalLatitude() {
        return this.internalLatitude;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Double internalLongitude() {
        return this.internalLongitude;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Integer parentCategory() {
        return this.parentCategory;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Integer childCategory() {
        return this.childCategory;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    String description() {
        return this.description;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Integer subChildCategory() {
        return this.subChildCategory;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Integer bearing() {
        return this.bearing;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Integer accuracy() {
        return this.accuracy;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    String speed() {
        return this.speed;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Integer flag() {
        return this.flag;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Double altitude() {
        return this.altitude;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    String quality() {
        return this.quality;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Long utc() {
        return this.utc;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    Long expiry() {
        return this.expiry;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    String zeroId() {
        return this.zeroId;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    String appVersion() {
        return this.appVersion;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    String osVersion() {
        return this.osVersion;
    }

    @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport
    String deviceName() {
        return this.deviceName;
    }

    public String toString() {
        return "MapplsSubmitReport{baseUrl=" + this.baseUrl + ", placeName=" + this.placeName + ", internalMapplsPin=" + this.internalMapplsPin + ", internalLatitude=" + this.internalLatitude + ", internalLongitude=" + this.internalLongitude + ", parentCategory=" + this.parentCategory + ", childCategory=" + this.childCategory + ", description=" + this.description + ", subChildCategory=" + this.subChildCategory + ", bearing=" + this.bearing + ", accuracy=" + this.accuracy + ", speed=" + this.speed + ", flag=" + this.flag + ", altitude=" + this.altitude + ", quality=" + this.quality + ", utc=" + this.utc + ", expiry=" + this.expiry + ", zeroId=" + this.zeroId + ", appVersion=" + this.appVersion + ", osVersion=" + this.osVersion + ", deviceName=" + this.deviceName + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Double d;
        Double d2;
        String str3;
        Integer num;
        Integer num2;
        Integer num3;
        String str4;
        Integer num4;
        Double d3;
        String str5;
        Long l;
        Long l2;
        String str6;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsSubmitReport)) {
            return false;
        }
        MapplsSubmitReport mapplsSubmitReport = (MapplsSubmitReport) obj;
        if (this.baseUrl.equals(mapplsSubmitReport.baseUrl()) && ((str = this.placeName) != null ? str.equals(mapplsSubmitReport.placeName()) : mapplsSubmitReport.placeName() == null) && ((str2 = this.internalMapplsPin) != null ? str2.equals(mapplsSubmitReport.internalMapplsPin()) : mapplsSubmitReport.internalMapplsPin() == null) && ((d = this.internalLatitude) != null ? d.equals(mapplsSubmitReport.internalLatitude()) : mapplsSubmitReport.internalLatitude() == null) && ((d2 = this.internalLongitude) != null ? d2.equals(mapplsSubmitReport.internalLongitude()) : mapplsSubmitReport.internalLongitude() == null) && this.parentCategory.equals(mapplsSubmitReport.parentCategory()) && this.childCategory.equals(mapplsSubmitReport.childCategory()) && ((str3 = this.description) != null ? str3.equals(mapplsSubmitReport.description()) : mapplsSubmitReport.description() == null) && ((num = this.subChildCategory) != null ? num.equals(mapplsSubmitReport.subChildCategory()) : mapplsSubmitReport.subChildCategory() == null) && ((num2 = this.bearing) != null ? num2.equals(mapplsSubmitReport.bearing()) : mapplsSubmitReport.bearing() == null) && ((num3 = this.accuracy) != null ? num3.equals(mapplsSubmitReport.accuracy()) : mapplsSubmitReport.accuracy() == null) && ((str4 = this.speed) != null ? str4.equals(mapplsSubmitReport.speed()) : mapplsSubmitReport.speed() == null) && ((num4 = this.flag) != null ? num4.equals(mapplsSubmitReport.flag()) : mapplsSubmitReport.flag() == null) && ((d3 = this.altitude) != null ? d3.equals(mapplsSubmitReport.altitude()) : mapplsSubmitReport.altitude() == null) && ((str5 = this.quality) != null ? str5.equals(mapplsSubmitReport.quality()) : mapplsSubmitReport.quality() == null) && ((l = this.utc) != null ? l.equals(mapplsSubmitReport.utc()) : mapplsSubmitReport.utc() == null) && ((l2 = this.expiry) != null ? l2.equals(mapplsSubmitReport.expiry()) : mapplsSubmitReport.expiry() == null) && ((str6 = this.zeroId) != null ? str6.equals(mapplsSubmitReport.zeroId()) : mapplsSubmitReport.zeroId() == null) && ((str7 = this.appVersion) != null ? str7.equals(mapplsSubmitReport.appVersion()) : mapplsSubmitReport.appVersion() == null) && ((str8 = this.osVersion) != null ? str8.equals(mapplsSubmitReport.osVersion()) : mapplsSubmitReport.osVersion() == null)) {
            String str9 = this.deviceName;
            if (str9 == null) {
                if (mapplsSubmitReport.deviceName() == null) {
                    return true;
                }
            } else if (str9.equals(mapplsSubmitReport.deviceName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.baseUrl.hashCode() ^ 1000003) * 1000003;
        String str = this.placeName;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.internalMapplsPin;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Double d = this.internalLatitude;
        int iHashCode4 = (iHashCode3 ^ (d == null ? 0 : d.hashCode())) * 1000003;
        Double d2 = this.internalLongitude;
        int iHashCode5 = (((((iHashCode4 ^ (d2 == null ? 0 : d2.hashCode())) * 1000003) ^ this.parentCategory.hashCode()) * 1000003) ^ this.childCategory.hashCode()) * 1000003;
        String str3 = this.description;
        int iHashCode6 = (iHashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.subChildCategory;
        int iHashCode7 = (iHashCode6 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.bearing;
        int iHashCode8 = (iHashCode7 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Integer num3 = this.accuracy;
        int iHashCode9 = (iHashCode8 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
        String str4 = this.speed;
        int iHashCode10 = (iHashCode9 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Integer num4 = this.flag;
        int iHashCode11 = (iHashCode10 ^ (num4 == null ? 0 : num4.hashCode())) * 1000003;
        Double d3 = this.altitude;
        int iHashCode12 = (iHashCode11 ^ (d3 == null ? 0 : d3.hashCode())) * 1000003;
        String str5 = this.quality;
        int iHashCode13 = (iHashCode12 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Long l = this.utc;
        int iHashCode14 = (iHashCode13 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.expiry;
        int iHashCode15 = (iHashCode14 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str6 = this.zeroId;
        int iHashCode16 = (iHashCode15 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.appVersion;
        int iHashCode17 = (iHashCode16 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.osVersion;
        int iHashCode18 = (iHashCode17 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.deviceName;
        return iHashCode18 ^ (str9 != null ? str9.hashCode() : 0);
    }

    static final class Builder extends MapplsSubmitReport.Builder {
        private Integer accuracy;
        private Double altitude;
        private String appVersion;
        private String baseUrl;
        private Integer bearing;
        private Integer childCategory;
        private String description;
        private String deviceName;
        private Long expiry;
        private Integer flag;
        private Double internalLatitude;
        private Double internalLongitude;
        private String internalMapplsPin;
        private String osVersion;
        private Integer parentCategory;
        private String placeName;
        private String quality;
        private String speed;
        private Integer subChildCategory;
        private Long utc;
        private String zeroId;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder placeName(String str) {
            this.placeName = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        MapplsSubmitReport.Builder internalMapplsPin(String str) {
            this.internalMapplsPin = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        MapplsSubmitReport.Builder internalLatitude(Double d) {
            this.internalLatitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        MapplsSubmitReport.Builder internalLongitude(Double d) {
            this.internalLongitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder parentCategory(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null parentCategory");
            }
            this.parentCategory = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder childCategory(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null childCategory");
            }
            this.childCategory = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder subChildCategory(Integer num) {
            this.subChildCategory = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder bearing(Integer num) {
            this.bearing = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder accuracy(Integer num) {
            this.accuracy = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder speed(String str) {
            this.speed = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder flag(Integer num) {
            this.flag = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder altitude(Double d) {
            this.altitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder quality(String str) {
            this.quality = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder utc(Long l) {
            this.utc = l;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder expiry(Long l) {
            this.expiry = l;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder zeroId(String str) {
            this.zeroId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder appVersion(String str) {
            this.appVersion = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder osVersion(String str) {
            this.osVersion = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        public MapplsSubmitReport.Builder deviceName(String str) {
            this.deviceName = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.submitreport.MapplsSubmitReport.Builder
        MapplsSubmitReport autoBuild() {
            if (this.baseUrl == null || this.parentCategory == null || this.childCategory == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.parentCategory == null) {
                    sb.append(" parentCategory");
                }
                if (this.childCategory == null) {
                    sb.append(" childCategory");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsSubmitReport(this.baseUrl, this.placeName, this.internalMapplsPin, this.internalLatitude, this.internalLongitude, this.parentCategory, this.childCategory, this.description, this.subChildCategory, this.bearing, this.accuracy, this.speed, this.flag, this.altitude, this.quality, this.utc, this.expiry, this.zeroId, this.appVersion, this.osVersion, this.deviceName);
        }
    }
}
