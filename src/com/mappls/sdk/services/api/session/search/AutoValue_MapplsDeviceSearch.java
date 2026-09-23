package com.mappls.sdk.services.api.session.search;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsDeviceSearch extends MapplsDeviceSearch {
    private final String baseUrl;
    private final String query;

    private AutoValue_MapplsDeviceSearch(String str, String str2) {
        this.query = str;
        this.baseUrl = str2;
    }

    @Override // com.mappls.sdk.services.api.session.search.MapplsDeviceSearch
    public String query() {
        return this.query;
    }

    @Override // com.mappls.sdk.services.api.session.search.MapplsDeviceSearch, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapplsDeviceSearch{query=" + this.query + ", baseUrl=" + this.baseUrl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsDeviceSearch)) {
            return false;
        }
        MapplsDeviceSearch mapplsDeviceSearch = (MapplsDeviceSearch) obj;
        return this.query.equals(mapplsDeviceSearch.query()) && this.baseUrl.equals(mapplsDeviceSearch.baseUrl());
    }

    public int hashCode() {
        return ((this.query.hashCode() ^ 1000003) * 1000003) ^ this.baseUrl.hashCode();
    }

    static final class Builder extends MapplsDeviceSearch.Builder {
        private String baseUrl;
        private String query;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.session.search.MapplsDeviceSearch.Builder
        public MapplsDeviceSearch.Builder query(String str) {
            if (str == null) {
                throw new NullPointerException("Null query");
            }
            this.query = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.search.MapplsDeviceSearch.Builder
        public MapplsDeviceSearch.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.search.MapplsDeviceSearch.Builder
        MapplsDeviceSearch autoBuild() {
            if (this.query == null || this.baseUrl == null) {
                StringBuilder sb = new StringBuilder();
                if (this.query == null) {
                    sb.append(" query");
                }
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsDeviceSearch(this.query, this.baseUrl);
        }
    }
}
