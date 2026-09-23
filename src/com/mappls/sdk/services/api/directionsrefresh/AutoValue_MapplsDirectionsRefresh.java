package com.mappls.sdk.services.api.directionsrefresh;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsDirectionsRefresh extends MapplsDirectionsRefresh {
    private final String baseUrl;
    private final String categories;
    private final Boolean isNotify;
    private final Boolean isRefresh;
    private final Boolean isSort;
    private final Long nodeIndex;
    private final String profile;
    private final String requestId;
    private final Integer routeIndex;
    private final String sessionId;
    private final String sourceInternal;
    private final Integer tripType;

    private AutoValue_MapplsDirectionsRefresh(String str, String str2, Integer num, Boolean bool, Boolean bool2, Long l, String str3, Integer num2, String str4, String str5, Boolean bool3, String str6) {
        this.profile = str;
        this.requestId = str2;
        this.routeIndex = num;
        this.isRefresh = bool;
        this.isNotify = bool2;
        this.nodeIndex = l;
        this.categories = str3;
        this.tripType = num2;
        this.sessionId = str4;
        this.sourceInternal = str5;
        this.isSort = bool3;
        this.baseUrl = str6;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    String profile() {
        return this.profile;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    String requestId() {
        return this.requestId;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    Integer routeIndex() {
        return this.routeIndex;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    Boolean isRefresh() {
        return this.isRefresh;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    Boolean isNotify() {
        return this.isNotify;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    Long nodeIndex() {
        return this.nodeIndex;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    String categories() {
        return this.categories;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    Integer tripType() {
        return this.tripType;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    String sessionId() {
        return this.sessionId;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    String sourceInternal() {
        return this.sourceInternal;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    Boolean isSort() {
        return this.isSort;
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapplsDirectionsRefresh{profile=" + this.profile + ", requestId=" + this.requestId + ", routeIndex=" + this.routeIndex + ", isRefresh=" + this.isRefresh + ", isNotify=" + this.isNotify + ", nodeIndex=" + this.nodeIndex + ", categories=" + this.categories + ", tripType=" + this.tripType + ", sessionId=" + this.sessionId + ", sourceInternal=" + this.sourceInternal + ", isSort=" + this.isSort + ", baseUrl=" + this.baseUrl + "}";
    }

    public boolean equals(Object obj) {
        Boolean bool;
        Boolean bool2;
        Long l;
        String str;
        String str2;
        String str3;
        Boolean bool3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsDirectionsRefresh)) {
            return false;
        }
        MapplsDirectionsRefresh mapplsDirectionsRefresh = (MapplsDirectionsRefresh) obj;
        return this.profile.equals(mapplsDirectionsRefresh.profile()) && this.requestId.equals(mapplsDirectionsRefresh.requestId()) && this.routeIndex.equals(mapplsDirectionsRefresh.routeIndex()) && ((bool = this.isRefresh) != null ? bool.equals(mapplsDirectionsRefresh.isRefresh()) : mapplsDirectionsRefresh.isRefresh() == null) && ((bool2 = this.isNotify) != null ? bool2.equals(mapplsDirectionsRefresh.isNotify()) : mapplsDirectionsRefresh.isNotify() == null) && ((l = this.nodeIndex) != null ? l.equals(mapplsDirectionsRefresh.nodeIndex()) : mapplsDirectionsRefresh.nodeIndex() == null) && ((str = this.categories) != null ? str.equals(mapplsDirectionsRefresh.categories()) : mapplsDirectionsRefresh.categories() == null) && this.tripType.equals(mapplsDirectionsRefresh.tripType()) && ((str2 = this.sessionId) != null ? str2.equals(mapplsDirectionsRefresh.sessionId()) : mapplsDirectionsRefresh.sessionId() == null) && ((str3 = this.sourceInternal) != null ? str3.equals(mapplsDirectionsRefresh.sourceInternal()) : mapplsDirectionsRefresh.sourceInternal() == null) && ((bool3 = this.isSort) != null ? bool3.equals(mapplsDirectionsRefresh.isSort()) : mapplsDirectionsRefresh.isSort() == null) && this.baseUrl.equals(mapplsDirectionsRefresh.baseUrl());
    }

    public int hashCode() {
        int iHashCode = (((((this.profile.hashCode() ^ 1000003) * 1000003) ^ this.requestId.hashCode()) * 1000003) ^ this.routeIndex.hashCode()) * 1000003;
        Boolean bool = this.isRefresh;
        int iHashCode2 = (iHashCode ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Boolean bool2 = this.isNotify;
        int iHashCode3 = (iHashCode2 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Long l = this.nodeIndex;
        int iHashCode4 = (iHashCode3 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        String str = this.categories;
        int iHashCode5 = (((iHashCode4 ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.tripType.hashCode()) * 1000003;
        String str2 = this.sessionId;
        int iHashCode6 = (iHashCode5 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.sourceInternal;
        int iHashCode7 = (iHashCode6 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Boolean bool3 = this.isSort;
        return ((iHashCode7 ^ (bool3 != null ? bool3.hashCode() : 0)) * 1000003) ^ this.baseUrl.hashCode();
    }

    @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh
    public MapplsDirectionsRefresh.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends MapplsDirectionsRefresh.Builder {
        private String baseUrl;
        private String categories;
        private Boolean isNotify;
        private Boolean isRefresh;
        private Boolean isSort;
        private Long nodeIndex;
        private String profile;
        private String requestId;
        private Integer routeIndex;
        private String sessionId;
        private String sourceInternal;
        private Integer tripType;

        Builder() {
        }

        private Builder(MapplsDirectionsRefresh mapplsDirectionsRefresh) {
            this.profile = mapplsDirectionsRefresh.profile();
            this.requestId = mapplsDirectionsRefresh.requestId();
            this.routeIndex = mapplsDirectionsRefresh.routeIndex();
            this.isRefresh = mapplsDirectionsRefresh.isRefresh();
            this.isNotify = mapplsDirectionsRefresh.isNotify();
            this.nodeIndex = mapplsDirectionsRefresh.nodeIndex();
            this.categories = mapplsDirectionsRefresh.categories();
            this.tripType = mapplsDirectionsRefresh.tripType();
            this.sessionId = mapplsDirectionsRefresh.sessionId();
            this.sourceInternal = mapplsDirectionsRefresh.sourceInternal();
            this.isSort = mapplsDirectionsRefresh.isSort();
            this.baseUrl = mapplsDirectionsRefresh.baseUrl();
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder profile(String str) {
            if (str == null) {
                throw new NullPointerException("Null profile");
            }
            this.profile = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder requestId(String str) {
            if (str == null) {
                throw new NullPointerException("Null requestId");
            }
            this.requestId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder routeIndex(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null routeIndex");
            }
            this.routeIndex = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder isRefresh(Boolean bool) {
            this.isRefresh = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder isNotify(Boolean bool) {
            this.isNotify = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder nodeIndex(Long l) {
            this.nodeIndex = l;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder categories(String str) {
            this.categories = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder tripType(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tripType");
            }
            this.tripType = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder sessionId(String str) {
            this.sessionId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        MapplsDirectionsRefresh.Builder sourceInternal(String str) {
            this.sourceInternal = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder isSort(Boolean bool) {
            this.isSort = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh.Builder
        public MapplsDirectionsRefresh build() {
            if (this.profile == null || this.requestId == null || this.routeIndex == null || this.tripType == null || this.baseUrl == null) {
                StringBuilder sb = new StringBuilder();
                if (this.profile == null) {
                    sb.append(" profile");
                }
                if (this.requestId == null) {
                    sb.append(" requestId");
                }
                if (this.routeIndex == null) {
                    sb.append(" routeIndex");
                }
                if (this.tripType == null) {
                    sb.append(" tripType");
                }
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsDirectionsRefresh(this.profile, this.requestId, this.routeIndex, this.isRefresh, this.isNotify, this.nodeIndex, this.categories, this.tripType, this.sessionId, this.sourceInternal, this.isSort, this.baseUrl);
        }
    }
}
