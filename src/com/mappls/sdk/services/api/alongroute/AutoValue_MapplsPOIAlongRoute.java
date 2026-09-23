package com.mappls.sdk.services.api.alongroute;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsPOIAlongRoute extends MapplsPOIAlongRoute {
    private final String baseUrl;
    private final Integer buffer;
    private final String category;
    private final String filter;
    private final String geometries;
    private final Integer page;
    private final String path;
    private final Boolean sort;

    private AutoValue_MapplsPOIAlongRoute(String str, String str2, String str3, Integer num, Integer num2, Boolean bool, String str4, String str5) {
        this.baseUrl = str;
        this.path = str2;
        this.category = str3;
        this.buffer = num;
        this.page = num2;
        this.sort = bool;
        this.geometries = str4;
        this.filter = str5;
    }

    @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute
    String path() {
        return this.path;
    }

    @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute
    String category() {
        return this.category;
    }

    @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute
    Integer buffer() {
        return this.buffer;
    }

    @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute
    Integer page() {
        return this.page;
    }

    @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute
    Boolean sort() {
        return this.sort;
    }

    @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute
    String geometries() {
        return this.geometries;
    }

    @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute
    String filter() {
        return this.filter;
    }

    public String toString() {
        return "MapplsPOIAlongRoute{baseUrl=" + this.baseUrl + ", path=" + this.path + ", category=" + this.category + ", buffer=" + this.buffer + ", page=" + this.page + ", sort=" + this.sort + ", geometries=" + this.geometries + ", filter=" + this.filter + "}";
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        Boolean bool;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsPOIAlongRoute)) {
            return false;
        }
        MapplsPOIAlongRoute mapplsPOIAlongRoute = (MapplsPOIAlongRoute) obj;
        if (this.baseUrl.equals(mapplsPOIAlongRoute.baseUrl()) && this.path.equals(mapplsPOIAlongRoute.path()) && this.category.equals(mapplsPOIAlongRoute.category()) && ((num = this.buffer) != null ? num.equals(mapplsPOIAlongRoute.buffer()) : mapplsPOIAlongRoute.buffer() == null) && ((num2 = this.page) != null ? num2.equals(mapplsPOIAlongRoute.page()) : mapplsPOIAlongRoute.page() == null) && ((bool = this.sort) != null ? bool.equals(mapplsPOIAlongRoute.sort()) : mapplsPOIAlongRoute.sort() == null) && ((str = this.geometries) != null ? str.equals(mapplsPOIAlongRoute.geometries()) : mapplsPOIAlongRoute.geometries() == null)) {
            String str2 = this.filter;
            if (str2 == null) {
                if (mapplsPOIAlongRoute.filter() == null) {
                    return true;
                }
            } else if (str2.equals(mapplsPOIAlongRoute.filter())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.path.hashCode()) * 1000003) ^ this.category.hashCode()) * 1000003;
        Integer num = this.buffer;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.page;
        int iHashCode3 = (iHashCode2 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Boolean bool = this.sort;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str = this.geometries;
        int iHashCode5 = (iHashCode4 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.filter;
        return iHashCode5 ^ (str2 != null ? str2.hashCode() : 0);
    }

    static final class Builder extends MapplsPOIAlongRoute.Builder {
        private String baseUrl;
        private Integer buffer;
        private String category;
        private String filter;
        private String geometries;
        private Integer page;
        private String path;
        private Boolean sort;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute.Builder
        public MapplsPOIAlongRoute.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute.Builder
        public MapplsPOIAlongRoute.Builder path(String str) {
            if (str == null) {
                throw new NullPointerException("Null path");
            }
            this.path = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute.Builder
        public MapplsPOIAlongRoute.Builder category(String str) {
            if (str == null) {
                throw new NullPointerException("Null category");
            }
            this.category = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute.Builder
        public MapplsPOIAlongRoute.Builder buffer(Integer num) {
            this.buffer = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute.Builder
        public MapplsPOIAlongRoute.Builder page(Integer num) {
            this.page = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute.Builder
        public MapplsPOIAlongRoute.Builder sort(Boolean bool) {
            this.sort = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute.Builder
        public MapplsPOIAlongRoute.Builder geometries(String str) {
            this.geometries = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute.Builder
        public MapplsPOIAlongRoute.Builder filter(String str) {
            this.filter = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute.Builder
        MapplsPOIAlongRoute autoBuild() {
            if (this.baseUrl == null || this.path == null || this.category == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.path == null) {
                    sb.append(" path");
                }
                if (this.category == null) {
                    sb.append(" category");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsPOIAlongRoute(this.baseUrl, this.path, this.category, this.buffer, this.page, this.sort, this.geometries, this.filter);
        }
    }
}
