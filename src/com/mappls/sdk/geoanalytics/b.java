package com.mappls.sdk.geoanalytics;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class b extends MapplsGeoAnalyticsRequest {
    private final String a;
    private final Boolean b;
    private final String c;
    private final String d;
    private final GeoAnalyticsAppearanceOption e;
    private final List<String> f;
    private final String g;

    /* JADX INFO: renamed from: com.mappls.sdk.geoanalytics.b$b, reason: collision with other inner class name */
    static final class C0079b extends MapplsGeoAnalyticsRequest.Builder {
        private String a;
        private Boolean b;
        private String c;
        private String d;
        private GeoAnalyticsAppearanceOption e;
        private List<String> f;
        private String g;

        C0079b() {
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest.Builder
        public MapplsGeoAnalyticsRequest.Builder attribute(String str) {
            this.c = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest.Builder
        public MapplsGeoAnalyticsRequest build() {
            String str = this.a == null ? " geoboundType" : "";
            if (this.b == null) {
                str = str + " transparent";
            }
            if (this.f == null) {
                str = str + " geoBoundList";
            }
            if (this.g == null) {
                str = str + " propertyNames";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest.Builder
        MapplsGeoAnalyticsRequest.Builder geoBoundList(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null geoBoundList");
            }
            this.f = list;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest.Builder
        public MapplsGeoAnalyticsRequest.Builder geoboundType(String str) {
            if (str == null) {
                throw new NullPointerException("Null geoboundType");
            }
            this.a = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest.Builder
        MapplsGeoAnalyticsRequest.Builder propertyNames(String str) {
            if (str == null) {
                throw new NullPointerException("Null propertyNames");
            }
            this.g = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest.Builder
        public MapplsGeoAnalyticsRequest.Builder query(String str) {
            this.d = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest.Builder
        public MapplsGeoAnalyticsRequest.Builder style(GeoAnalyticsAppearanceOption geoAnalyticsAppearanceOption) {
            this.e = geoAnalyticsAppearanceOption;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest.Builder
        public MapplsGeoAnalyticsRequest.Builder transparent(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null transparent");
            }
            this.b = bool;
            return this;
        }
    }

    private b(String str, Boolean bool, String str2, String str3, GeoAnalyticsAppearanceOption geoAnalyticsAppearanceOption, List<String> list, String str4) {
        this.a = str;
        this.b = bool;
        this.c = str2;
        this.d = str3;
        this.e = geoAnalyticsAppearanceOption;
        this.f = list;
        this.g = str4;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest
    String attribute() {
        return this.c;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        GeoAnalyticsAppearanceOption geoAnalyticsAppearanceOption;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsGeoAnalyticsRequest)) {
            return false;
        }
        MapplsGeoAnalyticsRequest mapplsGeoAnalyticsRequest = (MapplsGeoAnalyticsRequest) obj;
        return this.a.equals(mapplsGeoAnalyticsRequest.geoboundType()) && this.b.equals(mapplsGeoAnalyticsRequest.transparent()) && ((str = this.c) != null ? str.equals(mapplsGeoAnalyticsRequest.attribute()) : mapplsGeoAnalyticsRequest.attribute() == null) && ((str2 = this.d) != null ? str2.equals(mapplsGeoAnalyticsRequest.query()) : mapplsGeoAnalyticsRequest.query() == null) && ((geoAnalyticsAppearanceOption = this.e) != null ? geoAnalyticsAppearanceOption.equals(mapplsGeoAnalyticsRequest.style()) : mapplsGeoAnalyticsRequest.style() == null) && this.f.equals(mapplsGeoAnalyticsRequest.geoBoundList()) && this.g.equals(mapplsGeoAnalyticsRequest.propertyNames());
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest
    List<String> geoBoundList() {
        return this.f;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest
    String geoboundType() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        String str = this.c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        GeoAnalyticsAppearanceOption geoAnalyticsAppearanceOption = this.e;
        return ((((iHashCode3 ^ (geoAnalyticsAppearanceOption != null ? geoAnalyticsAppearanceOption.hashCode() : 0)) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode();
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest
    String propertyNames() {
        return this.g;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest
    String query() {
        return this.d;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest
    GeoAnalyticsAppearanceOption style() {
        return this.e;
    }

    public String toString() {
        return "MapplsGeoAnalyticsRequest{geoboundType=" + this.a + ", transparent=" + this.b + ", attribute=" + this.c + ", query=" + this.d + ", style=" + this.e + ", geoBoundList=" + this.f + ", propertyNames=" + this.g + "}";
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest
    Boolean transparent() {
        return this.b;
    }
}
