package com.mappls.sdk.services.api.textsearch;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsTextSearch extends MapplsTextSearch {
    private final String baseUrl;
    private final Boolean bridge;
    private final Boolean explain;
    private final String filter;
    private final String location;
    private final String queryString;
    private final String username;

    private AutoValue_MapplsTextSearch(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, String str5) {
        this.baseUrl = str;
        this.queryString = str2;
        this.location = str3;
        this.bridge = bool;
        this.explain = bool2;
        this.username = str4;
        this.filter = str5;
    }

    @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch
    String queryString() {
        return this.queryString;
    }

    @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch
    String location() {
        return this.location;
    }

    @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch
    Boolean bridge() {
        return this.bridge;
    }

    @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch
    Boolean explain() {
        return this.explain;
    }

    @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch
    String username() {
        return this.username;
    }

    @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch
    String filter() {
        return this.filter;
    }

    public String toString() {
        return "MapplsTextSearch{baseUrl=" + this.baseUrl + ", queryString=" + this.queryString + ", location=" + this.location + ", bridge=" + this.bridge + ", explain=" + this.explain + ", username=" + this.username + ", filter=" + this.filter + "}";
    }

    public boolean equals(Object obj) {
        String str;
        Boolean bool;
        Boolean bool2;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsTextSearch)) {
            return false;
        }
        MapplsTextSearch mapplsTextSearch = (MapplsTextSearch) obj;
        if (this.baseUrl.equals(mapplsTextSearch.baseUrl()) && this.queryString.equals(mapplsTextSearch.queryString()) && ((str = this.location) != null ? str.equals(mapplsTextSearch.location()) : mapplsTextSearch.location() == null) && ((bool = this.bridge) != null ? bool.equals(mapplsTextSearch.bridge()) : mapplsTextSearch.bridge() == null) && ((bool2 = this.explain) != null ? bool2.equals(mapplsTextSearch.explain()) : mapplsTextSearch.explain() == null) && ((str2 = this.username) != null ? str2.equals(mapplsTextSearch.username()) : mapplsTextSearch.username() == null)) {
            String str3 = this.filter;
            if (str3 == null) {
                if (mapplsTextSearch.filter() == null) {
                    return true;
                }
            } else if (str3.equals(mapplsTextSearch.filter())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.queryString.hashCode()) * 1000003;
        String str = this.location;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Boolean bool = this.bridge;
        int iHashCode3 = (iHashCode2 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Boolean bool2 = this.explain;
        int iHashCode4 = (iHashCode3 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        String str2 = this.username;
        int iHashCode5 = (iHashCode4 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.filter;
        return iHashCode5 ^ (str3 != null ? str3.hashCode() : 0);
    }

    static final class Builder extends MapplsTextSearch.Builder {
        private String baseUrl;
        private Boolean bridge;
        private Boolean explain;
        private String filter;
        private String location;
        private String queryString;
        private String username;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch.Builder
        public MapplsTextSearch.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch.Builder
        MapplsTextSearch.Builder queryString(String str) {
            if (str == null) {
                throw new NullPointerException("Null queryString");
            }
            this.queryString = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch.Builder
        MapplsTextSearch.Builder location(String str) {
            this.location = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch.Builder
        public MapplsTextSearch.Builder bridge(Boolean bool) {
            this.bridge = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch.Builder
        public MapplsTextSearch.Builder explain(Boolean bool) {
            this.explain = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch.Builder
        public MapplsTextSearch.Builder username(String str) {
            this.username = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch.Builder
        public MapplsTextSearch.Builder filter(String str) {
            this.filter = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.textsearch.MapplsTextSearch.Builder
        MapplsTextSearch autoBuild() {
            if (this.baseUrl == null || this.queryString == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.queryString == null) {
                    sb.append(" queryString");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsTextSearch(this.baseUrl, this.queryString, this.location, this.bridge, this.explain, this.username, this.filter);
        }
    }
}
