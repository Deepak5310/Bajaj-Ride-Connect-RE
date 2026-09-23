package com.mappls.sdk.geoanalytics.listing;

/* JADX INFO: loaded from: classes6.dex */
final class a extends MapplsGeoAnalyticsList {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    static final class b extends MapplsGeoAnalyticsList.Builder {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;

        b() {
        }

        @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList.Builder
        public MapplsGeoAnalyticsList.Builder api(String str) {
            if (str == null) {
                throw new NullPointerException("Null api");
            }
            this.b = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList.Builder
        MapplsGeoAnalyticsList.Builder attributes(String str) {
            if (str == null) {
                throw new NullPointerException("Null attributes");
            }
            this.e = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList.Builder
        public MapplsGeoAnalyticsList.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.a = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList.Builder
        public MapplsGeoAnalyticsList build() {
            String str = this.a == null ? " baseUrl" : "";
            if (this.b == null) {
                str = str + " api";
            }
            if (this.c == null) {
                str = str + " geoBoundType";
            }
            if (this.d == null) {
                str = str + " geoBound";
            }
            if (this.e == null) {
                str = str + " attributes";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.d, this.e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList.Builder
        MapplsGeoAnalyticsList.Builder geoBound(String str) {
            if (str == null) {
                throw new NullPointerException("Null geoBound");
            }
            this.d = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList.Builder
        public MapplsGeoAnalyticsList.Builder geoBoundType(String str) {
            if (str == null) {
                throw new NullPointerException("Null geoBoundType");
            }
            this.c = str;
            return this;
        }
    }

    private a(String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList
    String api() {
        return this.b;
    }

    @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList
    String attributes() {
        return this.e;
    }

    @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsGeoAnalyticsList)) {
            return false;
        }
        MapplsGeoAnalyticsList mapplsGeoAnalyticsList = (MapplsGeoAnalyticsList) obj;
        return this.a.equals(mapplsGeoAnalyticsList.baseUrl()) && this.b.equals(mapplsGeoAnalyticsList.api()) && this.c.equals(mapplsGeoAnalyticsList.geoBoundType()) && this.d.equals(mapplsGeoAnalyticsList.geoBound()) && this.e.equals(mapplsGeoAnalyticsList.attributes());
    }

    @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList
    String geoBound() {
        return this.d;
    }

    @Override // com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList
    String geoBoundType() {
        return this.c;
    }

    public int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    public String toString() {
        return "MapplsGeoAnalyticsList{baseUrl=" + this.a + ", api=" + this.b + ", geoBoundType=" + this.c + ", geoBound=" + this.d + ", attributes=" + this.e + "}";
    }
}
