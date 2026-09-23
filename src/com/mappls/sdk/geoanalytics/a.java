package com.mappls.sdk.geoanalytics;

import android.graphics.PointF;
import com.mappls.sdk.maps.geometry.LatLngBounds;

/* JADX INFO: loaded from: classes6.dex */
final class a extends MapplsFeatureInfo {
    private final String a;
    private final String b;
    private final PointF c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final LatLngBounds h;
    private final Integer i;
    private final Integer j;
    private final String k;
    private final String l;

    static final class b extends MapplsFeatureInfo.a {
        private String a;
        private String b;
        private PointF c;
        private String d;
        private String e;
        private String f;
        private String g;
        private LatLngBounds h;
        private Integer i;
        private Integer j;
        private String k;
        private String l;

        b() {
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        public MapplsFeatureInfo.a a(PointF pointF) {
            if (pointF == null) {
                throw new NullPointerException("Null clickedPoint");
            }
            this.c = pointF;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        public MapplsFeatureInfo.a a(LatLngBounds latLngBounds) {
            if (latLngBounds == null) {
                throw new NullPointerException("Null visibleRegion");
            }
            this.h = latLngBounds;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        public MapplsFeatureInfo.a a(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null height");
            }
            this.j = num;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        public MapplsFeatureInfo.a a(String str) {
            if (str == null) {
                throw new NullPointerException("Null api");
            }
            this.b = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        public MapplsFeatureInfo a() {
            String str = this.a == null ? " baseUrl" : "";
            if (this.b == null) {
                str = str + " api";
            }
            if (this.c == null) {
                str = str + " clickedPoint";
            }
            if (this.d == null) {
                str = str + " geoBoundType";
            }
            if (this.e == null) {
                str = str + " geoBound";
            }
            if (this.h == null) {
                str = str + " visibleRegion";
            }
            if (this.i == null) {
                str = str + " width";
            }
            if (this.j == null) {
                str = str + " height";
            }
            if (this.k == null) {
                str = str + " pathApi";
            }
            if (this.l == null) {
                str = str + " propertyName";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        public MapplsFeatureInfo.a b(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null width");
            }
            this.i = num;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        MapplsFeatureInfo.a b(String str) {
            this.f = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        MapplsFeatureInfo.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null geoBound");
            }
            this.e = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        public MapplsFeatureInfo.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null geoBoundType");
            }
            this.d = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        public MapplsFeatureInfo.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null pathApi");
            }
            this.k = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        MapplsFeatureInfo.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null propertyName");
            }
            this.l = str;
            return this;
        }

        @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo.a
        public MapplsFeatureInfo.a g(String str) {
            this.g = str;
            return this;
        }

        public MapplsFeatureInfo.a h(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.a = str;
            return this;
        }
    }

    private a(String str, String str2, PointF pointF, String str3, String str4, String str5, String str6, LatLngBounds latLngBounds, Integer num, Integer num2, String str7, String str8) {
        this.a = str;
        this.b = str2;
        this.c = pointF;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = latLngBounds;
        this.i = num;
        this.j = num2;
        this.k = str7;
        this.l = str8;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    String api() {
        return this.b;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    String attributes() {
        return this.f;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.a;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    protected PointF clickedPoint() {
        return this.c;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsFeatureInfo)) {
            return false;
        }
        MapplsFeatureInfo mapplsFeatureInfo = (MapplsFeatureInfo) obj;
        return this.a.equals(mapplsFeatureInfo.baseUrl()) && this.b.equals(mapplsFeatureInfo.api()) && this.c.equals(mapplsFeatureInfo.clickedPoint()) && this.d.equals(mapplsFeatureInfo.geoBoundType()) && this.e.equals(mapplsFeatureInfo.geoBound()) && ((str = this.f) != null ? str.equals(mapplsFeatureInfo.attributes()) : mapplsFeatureInfo.attributes() == null) && ((str2 = this.g) != null ? str2.equals(mapplsFeatureInfo.query()) : mapplsFeatureInfo.query() == null) && this.h.equals(mapplsFeatureInfo.visibleRegion()) && this.i.equals(mapplsFeatureInfo.width()) && this.j.equals(mapplsFeatureInfo.height()) && this.k.equals(mapplsFeatureInfo.pathApi()) && this.l.equals(mapplsFeatureInfo.propertyName());
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    String geoBound() {
        return this.e;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    String geoBoundType() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        String str = this.f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.g;
        return ((((((((((iHashCode2 ^ (str2 != null ? str2.hashCode() : 0)) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode();
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    Integer height() {
        return this.j;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    String pathApi() {
        return this.k;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    String propertyName() {
        return this.l;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    String query() {
        return this.g;
    }

    public String toString() {
        return "MapplsFeatureInfo{baseUrl=" + this.a + ", api=" + this.b + ", clickedPoint=" + this.c + ", geoBoundType=" + this.d + ", geoBound=" + this.e + ", attributes=" + this.f + ", query=" + this.g + ", visibleRegion=" + this.h + ", width=" + this.i + ", height=" + this.j + ", pathApi=" + this.k + ", propertyName=" + this.l + "}";
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    protected LatLngBounds visibleRegion() {
        return this.h;
    }

    @Override // com.mappls.sdk.geoanalytics.MapplsFeatureInfo
    Integer width() {
        return this.i;
    }
}
