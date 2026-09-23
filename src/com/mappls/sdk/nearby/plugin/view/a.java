package com.mappls.sdk.nearby.plugin.view;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
abstract class a extends NearbyResultViewOption {
    private final Integer a;
    private final Integer b;
    private final Integer c;
    private final Integer d;
    private final String e;
    private final Integer f;
    private final Integer g;
    private final Integer h;
    private final Integer i;
    private final Integer j;
    private final Integer k;
    private final Integer l;
    private final Integer m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Integer f721n;
    private final Integer o;
    private final Integer p;
    private final Integer q;
    private final Integer r;
    private final Integer s;
    private final Bitmap t;
    private final Integer u;
    private final Float v;
    private final Boolean w;

    /* JADX INFO: renamed from: com.mappls.sdk.nearby.plugin.view.a$a, reason: collision with other inner class name */
    static class C0106a extends NearbyResultViewOption.Builder {
        private Integer a;
        private Integer b;
        private Integer c;
        private Integer d;
        private String e;
        private Integer f;
        private Integer g;
        private Integer h;
        private Integer i;
        private Integer j;
        private Integer k;
        private Integer l;
        private Integer m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Integer f722n;
        private Integer o;
        private Integer p;
        private Integer q;
        private Integer r;
        private Integer s;
        private Bitmap t;
        private Integer u;
        private Float v;
        private Boolean w;

        C0106a() {
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder addressTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null addressTextColor");
            }
            this.r = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder backgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null backgroundColor");
            }
            this.a = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption build() {
            String strA = this.a == null ? com.mappls.sdk.nearby.plugin.model.a.a("", " backgroundColor") : "";
            if (this.b == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " paginationBackgroundColor");
            }
            if (this.c == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " toolbarBackgroundColor");
            }
            if (this.d == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " toolbarTintColor");
            }
            if (this.e == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " toolbarText");
            }
            if (this.f == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " tabTextColor");
            }
            if (this.g == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " tabSelectedTextColor");
            }
            if (this.h == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " categoryFilterBackgroundColor");
            }
            if (this.i == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " tabIndicatorColor");
            }
            if (this.j == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " tabBackgroundColor");
            }
            if (this.k == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " tabIconTint");
            }
            if (this.l == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " placeNameTextColor");
            }
            if (this.m == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " distanceTextColor");
            }
            if (this.f722n == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " listBackgroundColor");
            }
            if (this.o == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " prevButtonBackgroundColor");
            }
            if (this.p == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " nextButtonBackgroundColor");
            }
            if (this.q == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " listSeperatorColor");
            }
            if (this.r == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " addressTextColor");
            }
            if (this.s == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " locationMarkerIcon");
            }
            if (this.u == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " locationCircleColor");
            }
            if (this.v == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " locationCircleAlpha");
            }
            if (this.w == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " showDefaultMap");
            }
            if (strA.isEmpty()) {
                return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f722n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w);
            }
            throw new IllegalStateException(com.mappls.sdk.nearby.plugin.model.a.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder categoryFilterBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null categoryFilterBackgroundColor");
            }
            this.h = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder distanceTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null distanceTextColor");
            }
            this.m = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder listBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null listBackgroundColor");
            }
            this.f722n = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder listSeperatorColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null listSeperatorColor");
            }
            this.q = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder locationCircleAlpha(Float f) {
            if (f == null) {
                throw new NullPointerException("Null locationCircleAlpha");
            }
            this.v = f;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder locationCircleColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null locationCircleColor");
            }
            this.u = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder locationMarkerBitmap(Bitmap bitmap) {
            this.t = bitmap;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder locationMarkerIcon(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null locationMarkerIcon");
            }
            this.s = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder nextButtonBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null nextButtonBackgroundColor");
            }
            this.p = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder paginationBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null paginationBackgroundColor");
            }
            this.b = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder placeNameTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null placeNameTextColor");
            }
            this.l = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder prevButtonBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null prevButtonBackgroundColor");
            }
            this.o = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder showDefaultMap(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showDefaultMap");
            }
            this.w = bool;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder tabBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tabBackgroundColor");
            }
            this.j = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder tabIconTint(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tabIconTint");
            }
            this.k = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder tabIndicatorColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tabIndicatorColor");
            }
            this.i = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder tabSelectedTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tabSelectedTextColor");
            }
            this.g = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder tabTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tabTextColor");
            }
            this.f = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder toolbarBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null toolbarBackgroundColor");
            }
            this.c = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder toolbarText(String str) {
            if (str == null) {
                throw new NullPointerException("Null toolbarText");
            }
            this.e = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption.Builder
        public final NearbyResultViewOption.Builder toolbarTintColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null toolbarTintColor");
            }
            this.d = num;
            return this;
        }
    }

    a(Integer num, Integer num2, Integer num3, Integer num4, String str, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Bitmap bitmap, Integer num19, Float f, Boolean bool) {
        if (num == null) {
            throw new NullPointerException("Null backgroundColor");
        }
        this.a = num;
        if (num2 == null) {
            throw new NullPointerException("Null paginationBackgroundColor");
        }
        this.b = num2;
        if (num3 == null) {
            throw new NullPointerException("Null toolbarBackgroundColor");
        }
        this.c = num3;
        if (num4 == null) {
            throw new NullPointerException("Null toolbarTintColor");
        }
        this.d = num4;
        if (str == null) {
            throw new NullPointerException("Null toolbarText");
        }
        this.e = str;
        if (num5 == null) {
            throw new NullPointerException("Null tabTextColor");
        }
        this.f = num5;
        if (num6 == null) {
            throw new NullPointerException("Null tabSelectedTextColor");
        }
        this.g = num6;
        if (num7 == null) {
            throw new NullPointerException("Null categoryFilterBackgroundColor");
        }
        this.h = num7;
        if (num8 == null) {
            throw new NullPointerException("Null tabIndicatorColor");
        }
        this.i = num8;
        if (num9 == null) {
            throw new NullPointerException("Null tabBackgroundColor");
        }
        this.j = num9;
        if (num10 == null) {
            throw new NullPointerException("Null tabIconTint");
        }
        this.k = num10;
        if (num11 == null) {
            throw new NullPointerException("Null placeNameTextColor");
        }
        this.l = num11;
        if (num12 == null) {
            throw new NullPointerException("Null distanceTextColor");
        }
        this.m = num12;
        if (num13 == null) {
            throw new NullPointerException("Null listBackgroundColor");
        }
        this.f721n = num13;
        if (num14 == null) {
            throw new NullPointerException("Null prevButtonBackgroundColor");
        }
        this.o = num14;
        if (num15 == null) {
            throw new NullPointerException("Null nextButtonBackgroundColor");
        }
        this.p = num15;
        if (num16 == null) {
            throw new NullPointerException("Null listSeperatorColor");
        }
        this.q = num16;
        if (num17 == null) {
            throw new NullPointerException("Null addressTextColor");
        }
        this.r = num17;
        if (num18 == null) {
            throw new NullPointerException("Null locationMarkerIcon");
        }
        this.s = num18;
        this.t = bitmap;
        if (num19 == null) {
            throw new NullPointerException("Null locationCircleColor");
        }
        this.u = num19;
        if (f == null) {
            throw new NullPointerException("Null locationCircleAlpha");
        }
        this.v = f;
        if (bool == null) {
            throw new NullPointerException("Null showDefaultMap");
        }
        this.w = bool;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer addressTextColor() {
        return this.r;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer backgroundColor() {
        return this.a;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer categoryFilterBackgroundColor() {
        return this.h;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer distanceTextColor() {
        return this.m;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NearbyResultViewOption)) {
            return false;
        }
        NearbyResultViewOption nearbyResultViewOption = (NearbyResultViewOption) obj;
        return this.a.equals(nearbyResultViewOption.backgroundColor()) && this.b.equals(nearbyResultViewOption.paginationBackgroundColor()) && this.c.equals(nearbyResultViewOption.toolbarBackgroundColor()) && this.d.equals(nearbyResultViewOption.toolbarTintColor()) && this.e.equals(nearbyResultViewOption.toolbarText()) && this.f.equals(nearbyResultViewOption.tabTextColor()) && this.g.equals(nearbyResultViewOption.tabSelectedTextColor()) && this.h.equals(nearbyResultViewOption.categoryFilterBackgroundColor()) && this.i.equals(nearbyResultViewOption.tabIndicatorColor()) && this.j.equals(nearbyResultViewOption.tabBackgroundColor()) && this.k.equals(nearbyResultViewOption.tabIconTint()) && this.l.equals(nearbyResultViewOption.placeNameTextColor()) && this.m.equals(nearbyResultViewOption.distanceTextColor()) && this.f721n.equals(nearbyResultViewOption.listBackgroundColor()) && this.o.equals(nearbyResultViewOption.prevButtonBackgroundColor()) && this.p.equals(nearbyResultViewOption.nextButtonBackgroundColor()) && this.q.equals(nearbyResultViewOption.listSeperatorColor()) && this.r.equals(nearbyResultViewOption.addressTextColor()) && this.s.equals(nearbyResultViewOption.locationMarkerIcon()) && ((bitmap = this.t) != null ? bitmap.equals(nearbyResultViewOption.locationMarkerBitmap()) : nearbyResultViewOption.locationMarkerBitmap() == null) && this.u.equals(nearbyResultViewOption.locationCircleColor()) && this.v.equals(nearbyResultViewOption.locationCircleAlpha()) && this.w.equals(nearbyResultViewOption.showDefaultMap());
    }

    public final int hashCode() {
        int iHashCode = (((((((((((((((((((((((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode()) * 1000003) ^ this.m.hashCode()) * 1000003) ^ this.f721n.hashCode()) * 1000003) ^ this.o.hashCode()) * 1000003) ^ this.p.hashCode()) * 1000003) ^ this.q.hashCode()) * 1000003) ^ this.r.hashCode()) * 1000003) ^ this.s.hashCode()) * 1000003;
        Bitmap bitmap = this.t;
        return ((((((iHashCode ^ (bitmap == null ? 0 : bitmap.hashCode())) * 1000003) ^ this.u.hashCode()) * 1000003) ^ this.v.hashCode()) * 1000003) ^ this.w.hashCode();
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer listBackgroundColor() {
        return this.f721n;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer listSeperatorColor() {
        return this.q;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Float locationCircleAlpha() {
        return this.v;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer locationCircleColor() {
        return this.u;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Bitmap locationMarkerBitmap() {
        return this.t;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer locationMarkerIcon() {
        return this.s;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer nextButtonBackgroundColor() {
        return this.p;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer paginationBackgroundColor() {
        return this.b;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer placeNameTextColor() {
        return this.l;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer prevButtonBackgroundColor() {
        return this.o;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Boolean showDefaultMap() {
        return this.w;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer tabBackgroundColor() {
        return this.j;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer tabIconTint() {
        return this.k;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer tabIndicatorColor() {
        return this.i;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer tabSelectedTextColor() {
        return this.g;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer tabTextColor() {
        return this.f;
    }

    public final String toString() {
        return "NearbyResultViewOption{backgroundColor=" + this.a + ", paginationBackgroundColor=" + this.b + ", toolbarBackgroundColor=" + this.c + ", toolbarTintColor=" + this.d + ", toolbarText=" + this.e + ", tabTextColor=" + this.f + ", tabSelectedTextColor=" + this.g + ", categoryFilterBackgroundColor=" + this.h + ", tabIndicatorColor=" + this.i + ", tabBackgroundColor=" + this.j + ", tabIconTint=" + this.k + ", placeNameTextColor=" + this.l + ", distanceTextColor=" + this.m + ", listBackgroundColor=" + this.f721n + ", prevButtonBackgroundColor=" + this.o + ", nextButtonBackgroundColor=" + this.p + ", listSeperatorColor=" + this.q + ", addressTextColor=" + this.r + ", locationMarkerIcon=" + this.s + ", locationMarkerBitmap=" + this.t + ", locationCircleColor=" + this.u + ", locationCircleAlpha=" + this.v + ", showDefaultMap=" + this.w + "}";
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer toolbarBackgroundColor() {
        return this.c;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final String toolbarText() {
        return this.e;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption
    public final Integer toolbarTintColor() {
        return this.d;
    }
}
