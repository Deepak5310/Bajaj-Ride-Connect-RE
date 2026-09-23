package com.mappls.sdk.services.api.nearby;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsNearby extends MapplsNearby {
    private final String baseUrl;
    private final String bounds;
    private final Boolean explain;
    private final String filter;
    private final Boolean ignoreAutoExpand;
    private final String internalIncludes;
    private final Integer itemCount;
    private final String keywordString;
    private final String location;
    private final Integer page;
    private final String pod;
    private final Integer radius;
    private final Boolean richData;
    private final String searchBy;
    private final String sortBy;
    private final String userName;

    private AutoValue_MapplsNearby(String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, String str6, String str7, String str8, Boolean bool, Boolean bool2, String str9, String str10, Integer num3, Boolean bool3) {
        this.baseUrl = str;
        this.keywordString = str2;
        this.location = str3;
        this.page = num;
        this.sortBy = str4;
        this.searchBy = str5;
        this.radius = num2;
        this.bounds = str6;
        this.pod = str7;
        this.filter = str8;
        this.explain = bool;
        this.richData = bool2;
        this.userName = str9;
        this.internalIncludes = str10;
        this.itemCount = num3;
        this.ignoreAutoExpand = bool3;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby, com.mappls.sdk.services.api.MapplsService
    public String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public String keywordString() {
        return this.keywordString;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public String location() {
        return this.location;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public Integer page() {
        return this.page;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public String sortBy() {
        return this.sortBy;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public String searchBy() {
        return this.searchBy;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public Integer radius() {
        return this.radius;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public String bounds() {
        return this.bounds;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public String pod() {
        return this.pod;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public String filter() {
        return this.filter;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public Boolean explain() {
        return this.explain;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public Boolean richData() {
        return this.richData;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public String userName() {
        return this.userName;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public String internalIncludes() {
        return this.internalIncludes;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public Integer itemCount() {
        return this.itemCount;
    }

    @Override // com.mappls.sdk.services.api.nearby.MapplsNearby
    public Boolean ignoreAutoExpand() {
        return this.ignoreAutoExpand;
    }

    public String toString() {
        return "MapplsNearby{baseUrl=" + this.baseUrl + ", keywordString=" + this.keywordString + ", location=" + this.location + ", page=" + this.page + ", sortBy=" + this.sortBy + ", searchBy=" + this.searchBy + ", radius=" + this.radius + ", bounds=" + this.bounds + ", pod=" + this.pod + ", filter=" + this.filter + ", explain=" + this.explain + ", richData=" + this.richData + ", userName=" + this.userName + ", internalIncludes=" + this.internalIncludes + ", itemCount=" + this.itemCount + ", ignoreAutoExpand=" + this.ignoreAutoExpand + "}";
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        String str2;
        Integer num2;
        String str3;
        String str4;
        String str5;
        Boolean bool;
        Boolean bool2;
        String str6;
        String str7;
        Integer num3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsNearby)) {
            return false;
        }
        MapplsNearby mapplsNearby = (MapplsNearby) obj;
        if (this.baseUrl.equals(mapplsNearby.baseUrl()) && this.keywordString.equals(mapplsNearby.keywordString()) && this.location.equals(mapplsNearby.location()) && ((num = this.page) != null ? num.equals(mapplsNearby.page()) : mapplsNearby.page() == null) && ((str = this.sortBy) != null ? str.equals(mapplsNearby.sortBy()) : mapplsNearby.sortBy() == null) && ((str2 = this.searchBy) != null ? str2.equals(mapplsNearby.searchBy()) : mapplsNearby.searchBy() == null) && ((num2 = this.radius) != null ? num2.equals(mapplsNearby.radius()) : mapplsNearby.radius() == null) && ((str3 = this.bounds) != null ? str3.equals(mapplsNearby.bounds()) : mapplsNearby.bounds() == null) && ((str4 = this.pod) != null ? str4.equals(mapplsNearby.pod()) : mapplsNearby.pod() == null) && ((str5 = this.filter) != null ? str5.equals(mapplsNearby.filter()) : mapplsNearby.filter() == null) && ((bool = this.explain) != null ? bool.equals(mapplsNearby.explain()) : mapplsNearby.explain() == null) && ((bool2 = this.richData) != null ? bool2.equals(mapplsNearby.richData()) : mapplsNearby.richData() == null) && ((str6 = this.userName) != null ? str6.equals(mapplsNearby.userName()) : mapplsNearby.userName() == null) && ((str7 = this.internalIncludes) != null ? str7.equals(mapplsNearby.internalIncludes()) : mapplsNearby.internalIncludes() == null) && ((num3 = this.itemCount) != null ? num3.equals(mapplsNearby.itemCount()) : mapplsNearby.itemCount() == null)) {
            Boolean bool3 = this.ignoreAutoExpand;
            if (bool3 == null) {
                if (mapplsNearby.ignoreAutoExpand() == null) {
                    return true;
                }
            } else if (bool3.equals(mapplsNearby.ignoreAutoExpand())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.keywordString.hashCode()) * 1000003) ^ this.location.hashCode()) * 1000003;
        Integer num = this.page;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.sortBy;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.searchBy;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num2 = this.radius;
        int iHashCode5 = (iHashCode4 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str3 = this.bounds;
        int iHashCode6 = (iHashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.pod;
        int iHashCode7 = (iHashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.filter;
        int iHashCode8 = (iHashCode7 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Boolean bool = this.explain;
        int iHashCode9 = (iHashCode8 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Boolean bool2 = this.richData;
        int iHashCode10 = (iHashCode9 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        String str6 = this.userName;
        int iHashCode11 = (iHashCode10 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.internalIncludes;
        int iHashCode12 = (iHashCode11 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        Integer num3 = this.itemCount;
        int iHashCode13 = (iHashCode12 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
        Boolean bool3 = this.ignoreAutoExpand;
        return iHashCode13 ^ (bool3 != null ? bool3.hashCode() : 0);
    }

    static final class Builder extends MapplsNearby.Builder {
        private String baseUrl;
        private String bounds;
        private Boolean explain;
        private String filter;
        private Boolean ignoreAutoExpand;
        private String internalIncludes;
        private Integer itemCount;
        private String keywordString;
        private String location;
        private Integer page;
        private String pod;
        private Integer radius;
        private Boolean richData;
        private String searchBy;
        private String sortBy;
        private String userName;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        MapplsNearby.Builder keywordString(String str) {
            if (str == null) {
                throw new NullPointerException("Null keywordString");
            }
            this.keywordString = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        MapplsNearby.Builder location(String str) {
            if (str == null) {
                throw new NullPointerException("Null location");
            }
            this.location = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder page(Integer num) {
            this.page = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder sortBy(String str) {
            this.sortBy = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder searchBy(String str) {
            this.searchBy = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder radius(Integer num) {
            this.radius = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder bounds(String str) {
            this.bounds = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder pod(String str) {
            this.pod = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder filter(String str) {
            this.filter = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder explain(Boolean bool) {
            this.explain = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder richData(Boolean bool) {
            this.richData = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder userName(String str) {
            this.userName = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        MapplsNearby.Builder internalIncludes(String str) {
            this.internalIncludes = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder itemCount(Integer num) {
            this.itemCount = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        public MapplsNearby.Builder ignoreAutoExpand(Boolean bool) {
            this.ignoreAutoExpand = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.nearby.MapplsNearby.Builder
        MapplsNearby autoBuild() {
            if (this.baseUrl == null || this.keywordString == null || this.location == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.keywordString == null) {
                    sb.append(" keywordString");
                }
                if (this.location == null) {
                    sb.append(" location");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsNearby(this.baseUrl, this.keywordString, this.location, this.page, this.sortBy, this.searchBy, this.radius, this.bounds, this.pod, this.filter, this.explain, this.richData, this.userName, this.internalIncludes, this.itemCount, this.ignoreAutoExpand);
        }
    }
}
