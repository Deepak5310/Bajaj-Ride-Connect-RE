package com.mappls.sdk.services.api.feedback;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsFeedback extends MapplsFeedback {
    private final String appVersion;
    private final String baseUrl;
    private final Integer index;
    private final Double latitude;
    private final String locationName;
    private final Double longitude;
    private final String mapplsPin;
    private final String typedKeyword;
    private final String userName;

    private AutoValue_MapplsFeedback(String str, String str2, String str3, String str4, Integer num, String str5, Double d, Double d2, String str6) {
        this.baseUrl = str;
        this.typedKeyword = str2;
        this.mapplsPin = str3;
        this.locationName = str4;
        this.index = num;
        this.userName = str5;
        this.latitude = d;
        this.longitude = d2;
        this.appVersion = str6;
    }

    @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback
    protected String typedKeyword() {
        return this.typedKeyword;
    }

    @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback
    protected String mapplsPin() {
        return this.mapplsPin;
    }

    @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback
    protected String locationName() {
        return this.locationName;
    }

    @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback
    protected Integer index() {
        return this.index;
    }

    @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback
    protected String userName() {
        return this.userName;
    }

    @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback
    protected Double latitude() {
        return this.latitude;
    }

    @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback
    protected Double longitude() {
        return this.longitude;
    }

    @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback
    protected String appVersion() {
        return this.appVersion;
    }

    public String toString() {
        return "MapplsFeedback{baseUrl=" + this.baseUrl + ", typedKeyword=" + this.typedKeyword + ", mapplsPin=" + this.mapplsPin + ", locationName=" + this.locationName + ", index=" + this.index + ", userName=" + this.userName + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", appVersion=" + this.appVersion + "}";
    }

    public boolean equals(Object obj) {
        String str;
        Double d;
        Double d2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsFeedback)) {
            return false;
        }
        MapplsFeedback mapplsFeedback = (MapplsFeedback) obj;
        return this.baseUrl.equals(mapplsFeedback.baseUrl()) && this.typedKeyword.equals(mapplsFeedback.typedKeyword()) && ((str = this.mapplsPin) != null ? str.equals(mapplsFeedback.mapplsPin()) : mapplsFeedback.mapplsPin() == null) && this.locationName.equals(mapplsFeedback.locationName()) && this.index.equals(mapplsFeedback.index()) && this.userName.equals(mapplsFeedback.userName()) && ((d = this.latitude) != null ? d.equals(mapplsFeedback.latitude()) : mapplsFeedback.latitude() == null) && ((d2 = this.longitude) != null ? d2.equals(mapplsFeedback.longitude()) : mapplsFeedback.longitude() == null) && this.appVersion.equals(mapplsFeedback.appVersion());
    }

    public int hashCode() {
        int iHashCode = (((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.typedKeyword.hashCode()) * 1000003;
        String str = this.mapplsPin;
        int iHashCode2 = (((((((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.locationName.hashCode()) * 1000003) ^ this.index.hashCode()) * 1000003) ^ this.userName.hashCode()) * 1000003;
        Double d = this.latitude;
        int iHashCode3 = (iHashCode2 ^ (d == null ? 0 : d.hashCode())) * 1000003;
        Double d2 = this.longitude;
        return ((iHashCode3 ^ (d2 != null ? d2.hashCode() : 0)) * 1000003) ^ this.appVersion.hashCode();
    }

    static final class Builder extends MapplsFeedback.Builder {
        private String appVersion;
        private String baseUrl;
        private Integer index;
        private Double latitude;
        private String locationName;
        private Double longitude;
        private String mapplsPin;
        private String typedKeyword;
        private String userName;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        public MapplsFeedback.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        public MapplsFeedback.Builder typedKeyword(String str) {
            if (str == null) {
                throw new NullPointerException("Null typedKeyword");
            }
            this.typedKeyword = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        public MapplsFeedback.Builder mapplsPin(String str) {
            this.mapplsPin = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        public MapplsFeedback.Builder locationName(String str) {
            if (str == null) {
                throw new NullPointerException("Null locationName");
            }
            this.locationName = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        public MapplsFeedback.Builder index(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null index");
            }
            this.index = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        public MapplsFeedback.Builder userName(String str) {
            if (str == null) {
                throw new NullPointerException("Null userName");
            }
            this.userName = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        public MapplsFeedback.Builder latitude(Double d) {
            this.latitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        public MapplsFeedback.Builder longitude(Double d) {
            this.longitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        public MapplsFeedback.Builder appVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null appVersion");
            }
            this.appVersion = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.feedback.MapplsFeedback.Builder
        MapplsFeedback autoBuild() {
            if (this.baseUrl == null || this.typedKeyword == null || this.locationName == null || this.index == null || this.userName == null || this.appVersion == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.typedKeyword == null) {
                    sb.append(" typedKeyword");
                }
                if (this.locationName == null) {
                    sb.append(" locationName");
                }
                if (this.index == null) {
                    sb.append(" index");
                }
                if (this.userName == null) {
                    sb.append(" userName");
                }
                if (this.appVersion == null) {
                    sb.append(" appVersion");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsFeedback(this.baseUrl, this.typedKeyword, this.mapplsPin, this.locationName, this.index, this.userName, this.latitude, this.longitude, this.appVersion);
        }
    }
}
