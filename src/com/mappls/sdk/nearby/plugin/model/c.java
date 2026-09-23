package com.mappls.sdk.nearby.plugin.model;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
abstract class c extends NearbyUIOption {
    private final Integer A;
    private final Integer B;
    private final Integer C;
    private final Integer D;
    private final Integer E;
    private final Integer F;
    private final Integer G;
    private final Integer H;
    private final Integer I;
    private final Integer J;
    private final Integer K;
    private final Integer L;
    private final Bitmap M;
    private final Integer N;
    private final Float O;
    private final Boolean P;
    private final Integer a;
    private final Integer b;
    private final Integer c;
    private final Integer d;
    private final Bitmap e;
    private final Integer f;
    private final Integer g;
    private final Integer h;
    private final Integer i;
    private final Integer j;
    private final Integer k;
    private final Integer l;
    private final String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Integer f719n;
    private final Integer o;
    private final Integer p;
    private final Integer q;
    private final Integer r;
    private final Integer s;
    private final Integer t;
    private final Integer u;
    private final String v;
    private final Integer w;
    private final Integer x;
    private final Integer y;
    private final Integer z;

    static class a extends NearbyUIOption.Builder {
        private Integer A;
        private Integer B;
        private Integer C;
        private Integer D;
        private Integer E;
        private Integer F;
        private Integer G;
        private Integer H;
        private Integer I;
        private Integer J;
        private Integer K;
        private Integer L;
        private Bitmap M;
        private Integer N;
        private Float O;
        private Boolean P;
        private Integer a;
        private Integer b;
        private Integer c;
        private Integer d;
        private Bitmap e;
        private Integer f;
        private Integer g;
        private Integer h;
        private Integer i;
        private Integer j;
        private Integer k;
        private Integer l;
        private String m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Integer f720n;
        private Integer o;
        private Integer p;
        private Integer q;
        private Integer r;
        private Integer s;
        private Integer t;
        private Integer u;
        private String v;
        private Integer w;
        private Integer x;
        private Integer y;
        private Integer z;

        a() {
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder backgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null backgroundColor");
            }
            this.a = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption build() {
            String strA = this.a == null ? com.mappls.sdk.nearby.plugin.model.a.a("", " backgroundColor") : "";
            if (this.b == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " toolbarColor");
            }
            if (this.c == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " nearbyToolbarColor");
            }
            if (this.d == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " nearbyToolbarIcon");
            }
            if (this.f == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " toolbarTintColor");
            }
            if (this.g == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " nearbyToolbarTintColor");
            }
            if (this.h == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " locationDetailsBackgroundColor");
            }
            if (this.i == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " detailListBackgroundColor");
            }
            if (this.j == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " categoryFilterBackgroundColor");
            }
            if (this.k == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " detailListSeperatorBackgroundColor");
            }
            if (this.l == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " locationDetailInfoTextColor");
            }
            if (this.m == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " locationDetailsInfoLabelText");
            }
            if (this.f720n == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " locationDetailFormattedAddressTextColor");
            }
            if (this.o == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " changeLocationButtonTextColor");
            }
            if (this.p == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " prevButtonBackgroundColor");
            }
            if (this.q == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " nextButtonBackgroundColor");
            }
            if (this.r == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " useCurrentLocationButtonTextColor");
            }
            if (this.t == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " submitButtonResource");
            }
            if (this.u == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " submitButtonTextColor");
            }
            if (this.v == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " submitButtonText");
            }
            if (this.w == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " selectedCategoryBackgroundColor");
            }
            if (this.x == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " selectedCategoryTextColor");
            }
            if (this.y == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " selectedCategoryTintColor");
            }
            if (this.z == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " categoryBackgroundColor");
            }
            if (this.A == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " categoryTextColor");
            }
            if (this.B == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " categoryTintColor");
            }
            if (this.C == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " paginationBackgroundColor");
            }
            if (this.D == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " tabTextColor");
            }
            if (this.E == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " selectedTabTextColor");
            }
            if (this.F == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " tabIndicatorColor");
            }
            if (this.G == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " tabBackgroundColor");
            }
            if (this.H == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " tabIconTint");
            }
            if (this.I == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " placeNameTextColor");
            }
            if (this.J == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " distanceTextColor");
            }
            if (this.K == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " placeAddressTextColor");
            }
            if (this.L == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " refLocationIcon");
            }
            if (this.N == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " refLocationCircleColor");
            }
            if (this.O == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " refLocationCircleAlpha");
            }
            if (this.P == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " showDefaultMap");
            }
            if (strA.isEmpty()) {
                return new e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f720n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P);
            }
            throw new IllegalStateException(com.mappls.sdk.nearby.plugin.model.a.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder categoryBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null categoryBackgroundColor");
            }
            this.z = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder categoryFilterBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null categoryFilterBackgroundColor");
            }
            this.j = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder categoryTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null categoryTextColor");
            }
            this.A = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder categoryTintColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null categoryTintColor");
            }
            this.B = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder changeLocationButtonTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null changeLocationButtonTextColor");
            }
            this.o = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder detailListBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null detailListBackgroundColor");
            }
            this.i = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder detailListSeperatorBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null detailListSeperatorBackgroundColor");
            }
            this.k = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder distanceTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null distanceTextColor");
            }
            this.J = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder locationDetailFormattedAddressTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null locationDetailFormattedAddressTextColor");
            }
            this.f720n = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder locationDetailInfoTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null locationDetailInfoTextColor");
            }
            this.l = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder locationDetailsBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null locationDetailsBackgroundColor");
            }
            this.h = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder locationDetailsInfoLabelText(String str) {
            if (str == null) {
                throw new NullPointerException("Null locationDetailsInfoLabelText");
            }
            this.m = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        protected final NearbyUIOption.Builder nearbyToolbarBitmap(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder nearbyToolbarColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null nearbyToolbarColor");
            }
            this.c = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder nearbyToolbarIcon(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null nearbyToolbarIcon");
            }
            this.d = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder nearbyToolbarTintColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null nearbyToolbarTintColor");
            }
            this.g = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder nextButtonBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null nextButtonBackgroundColor");
            }
            this.q = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder paginationBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null paginationBackgroundColor");
            }
            this.C = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder placeAddressTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null placeAddressTextColor");
            }
            this.K = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder placeNameTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null placeNameTextColor");
            }
            this.I = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder prevButtonBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null prevButtonBackgroundColor");
            }
            this.p = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        final NearbyUIOption.Builder refLocationBitmap(Bitmap bitmap) {
            this.M = bitmap;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder refLocationCircleAlpha(Float f) {
            if (f == null) {
                throw new NullPointerException("Null refLocationCircleAlpha");
            }
            this.O = f;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder refLocationCircleColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null refLocationCircleColor");
            }
            this.N = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder refLocationIcon(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null refLocationIcon");
            }
            this.L = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder selectedCategoryBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null selectedCategoryBackgroundColor");
            }
            this.w = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder selectedCategoryTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null selectedCategoryTextColor");
            }
            this.x = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder selectedCategoryTintColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null selectedCategoryTintColor");
            }
            this.y = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder selectedTabTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null selectedTabTextColor");
            }
            this.E = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder showDefaultMap(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showDefaultMap");
            }
            this.P = bool;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder submitButtonColor(Integer num) {
            this.s = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder submitButtonResource(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null submitButtonResource");
            }
            this.t = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder submitButtonText(String str) {
            if (str == null) {
                throw new NullPointerException("Null submitButtonText");
            }
            this.v = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder submitButtonTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null submitButtonTextColor");
            }
            this.u = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder tabBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tabBackgroundColor");
            }
            this.G = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder tabIconTint(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tabIconTint");
            }
            this.H = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder tabIndicatorColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tabIndicatorColor");
            }
            this.F = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder tabTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null tabTextColor");
            }
            this.D = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder toolbarColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null toolbarColor");
            }
            this.b = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder toolbarTintColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null toolbarTintColor");
            }
            this.f = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption.Builder
        public final NearbyUIOption.Builder useCurrentLocationButtonTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null useCurrentLocationButtonTextColor");
            }
            this.r = num;
            return this;
        }
    }

    c(Integer num, Integer num2, Integer num3, Integer num4, Bitmap bitmap, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, String str, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, String str2, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Bitmap bitmap2, Integer num36, Float f, Boolean bool) {
        if (num == null) {
            throw new NullPointerException("Null backgroundColor");
        }
        this.a = num;
        if (num2 == null) {
            throw new NullPointerException("Null toolbarColor");
        }
        this.b = num2;
        if (num3 == null) {
            throw new NullPointerException("Null nearbyToolbarColor");
        }
        this.c = num3;
        if (num4 == null) {
            throw new NullPointerException("Null nearbyToolbarIcon");
        }
        this.d = num4;
        this.e = bitmap;
        if (num5 == null) {
            throw new NullPointerException("Null toolbarTintColor");
        }
        this.f = num5;
        if (num6 == null) {
            throw new NullPointerException("Null nearbyToolbarTintColor");
        }
        this.g = num6;
        if (num7 == null) {
            throw new NullPointerException("Null locationDetailsBackgroundColor");
        }
        this.h = num7;
        if (num8 == null) {
            throw new NullPointerException("Null detailListBackgroundColor");
        }
        this.i = num8;
        if (num9 == null) {
            throw new NullPointerException("Null categoryFilterBackgroundColor");
        }
        this.j = num9;
        if (num10 == null) {
            throw new NullPointerException("Null detailListSeperatorBackgroundColor");
        }
        this.k = num10;
        if (num11 == null) {
            throw new NullPointerException("Null locationDetailInfoTextColor");
        }
        this.l = num11;
        if (str == null) {
            throw new NullPointerException("Null locationDetailsInfoLabelText");
        }
        this.m = str;
        if (num12 == null) {
            throw new NullPointerException("Null locationDetailFormattedAddressTextColor");
        }
        this.f719n = num12;
        if (num13 == null) {
            throw new NullPointerException("Null changeLocationButtonTextColor");
        }
        this.o = num13;
        if (num14 == null) {
            throw new NullPointerException("Null prevButtonBackgroundColor");
        }
        this.p = num14;
        if (num15 == null) {
            throw new NullPointerException("Null nextButtonBackgroundColor");
        }
        this.q = num15;
        if (num16 == null) {
            throw new NullPointerException("Null useCurrentLocationButtonTextColor");
        }
        this.r = num16;
        this.s = num17;
        if (num18 == null) {
            throw new NullPointerException("Null submitButtonResource");
        }
        this.t = num18;
        if (num19 == null) {
            throw new NullPointerException("Null submitButtonTextColor");
        }
        this.u = num19;
        if (str2 == null) {
            throw new NullPointerException("Null submitButtonText");
        }
        this.v = str2;
        if (num20 == null) {
            throw new NullPointerException("Null selectedCategoryBackgroundColor");
        }
        this.w = num20;
        if (num21 == null) {
            throw new NullPointerException("Null selectedCategoryTextColor");
        }
        this.x = num21;
        if (num22 == null) {
            throw new NullPointerException("Null selectedCategoryTintColor");
        }
        this.y = num22;
        if (num23 == null) {
            throw new NullPointerException("Null categoryBackgroundColor");
        }
        this.z = num23;
        if (num24 == null) {
            throw new NullPointerException("Null categoryTextColor");
        }
        this.A = num24;
        if (num25 == null) {
            throw new NullPointerException("Null categoryTintColor");
        }
        this.B = num25;
        if (num26 == null) {
            throw new NullPointerException("Null paginationBackgroundColor");
        }
        this.C = num26;
        if (num27 == null) {
            throw new NullPointerException("Null tabTextColor");
        }
        this.D = num27;
        if (num28 == null) {
            throw new NullPointerException("Null selectedTabTextColor");
        }
        this.E = num28;
        if (num29 == null) {
            throw new NullPointerException("Null tabIndicatorColor");
        }
        this.F = num29;
        if (num30 == null) {
            throw new NullPointerException("Null tabBackgroundColor");
        }
        this.G = num30;
        if (num31 == null) {
            throw new NullPointerException("Null tabIconTint");
        }
        this.H = num31;
        if (num32 == null) {
            throw new NullPointerException("Null placeNameTextColor");
        }
        this.I = num32;
        if (num33 == null) {
            throw new NullPointerException("Null distanceTextColor");
        }
        this.J = num33;
        if (num34 == null) {
            throw new NullPointerException("Null placeAddressTextColor");
        }
        this.K = num34;
        if (num35 == null) {
            throw new NullPointerException("Null refLocationIcon");
        }
        this.L = num35;
        this.M = bitmap2;
        if (num36 == null) {
            throw new NullPointerException("Null refLocationCircleColor");
        }
        this.N = num36;
        if (f == null) {
            throw new NullPointerException("Null refLocationCircleAlpha");
        }
        this.O = f;
        if (bool == null) {
            throw new NullPointerException("Null showDefaultMap");
        }
        this.P = bool;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer backgroundColor() {
        return this.a;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer categoryBackgroundColor() {
        return this.z;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer categoryFilterBackgroundColor() {
        return this.j;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer categoryTextColor() {
        return this.A;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer categoryTintColor() {
        return this.B;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer changeLocationButtonTextColor() {
        return this.o;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer detailListBackgroundColor() {
        return this.i;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer detailListSeperatorBackgroundColor() {
        return this.k;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer distanceTextColor() {
        return this.J;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        Integer num;
        Bitmap bitmap2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NearbyUIOption)) {
            return false;
        }
        NearbyUIOption nearbyUIOption = (NearbyUIOption) obj;
        return this.a.equals(nearbyUIOption.backgroundColor()) && this.b.equals(nearbyUIOption.toolbarColor()) && this.c.equals(nearbyUIOption.nearbyToolbarColor()) && this.d.equals(nearbyUIOption.nearbyToolbarIcon()) && ((bitmap = this.e) != null ? bitmap.equals(nearbyUIOption.nearbyToolbarBitmap()) : nearbyUIOption.nearbyToolbarBitmap() == null) && this.f.equals(nearbyUIOption.toolbarTintColor()) && this.g.equals(nearbyUIOption.nearbyToolbarTintColor()) && this.h.equals(nearbyUIOption.locationDetailsBackgroundColor()) && this.i.equals(nearbyUIOption.detailListBackgroundColor()) && this.j.equals(nearbyUIOption.categoryFilterBackgroundColor()) && this.k.equals(nearbyUIOption.detailListSeperatorBackgroundColor()) && this.l.equals(nearbyUIOption.locationDetailInfoTextColor()) && this.m.equals(nearbyUIOption.locationDetailsInfoLabelText()) && this.f719n.equals(nearbyUIOption.locationDetailFormattedAddressTextColor()) && this.o.equals(nearbyUIOption.changeLocationButtonTextColor()) && this.p.equals(nearbyUIOption.prevButtonBackgroundColor()) && this.q.equals(nearbyUIOption.nextButtonBackgroundColor()) && this.r.equals(nearbyUIOption.useCurrentLocationButtonTextColor()) && ((num = this.s) != null ? num.equals(nearbyUIOption.submitButtonColor()) : nearbyUIOption.submitButtonColor() == null) && this.t.equals(nearbyUIOption.submitButtonResource()) && this.u.equals(nearbyUIOption.submitButtonTextColor()) && this.v.equals(nearbyUIOption.submitButtonText()) && this.w.equals(nearbyUIOption.selectedCategoryBackgroundColor()) && this.x.equals(nearbyUIOption.selectedCategoryTextColor()) && this.y.equals(nearbyUIOption.selectedCategoryTintColor()) && this.z.equals(nearbyUIOption.categoryBackgroundColor()) && this.A.equals(nearbyUIOption.categoryTextColor()) && this.B.equals(nearbyUIOption.categoryTintColor()) && this.C.equals(nearbyUIOption.paginationBackgroundColor()) && this.D.equals(nearbyUIOption.tabTextColor()) && this.E.equals(nearbyUIOption.selectedTabTextColor()) && this.F.equals(nearbyUIOption.tabIndicatorColor()) && this.G.equals(nearbyUIOption.tabBackgroundColor()) && this.H.equals(nearbyUIOption.tabIconTint()) && this.I.equals(nearbyUIOption.placeNameTextColor()) && this.J.equals(nearbyUIOption.distanceTextColor()) && this.K.equals(nearbyUIOption.placeAddressTextColor()) && this.L.equals(nearbyUIOption.refLocationIcon()) && ((bitmap2 = this.M) != null ? bitmap2.equals(nearbyUIOption.refLocationBitmap()) : nearbyUIOption.refLocationBitmap() == null) && this.N.equals(nearbyUIOption.refLocationCircleColor()) && this.O.equals(nearbyUIOption.refLocationCircleAlpha()) && this.P.equals(nearbyUIOption.showDefaultMap());
    }

    public final int hashCode() {
        int iHashCode = (((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        Bitmap bitmap = this.e;
        int iHashCode2 = (((((((((((((((((((((((((((iHashCode ^ (bitmap == null ? 0 : bitmap.hashCode())) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode()) * 1000003) ^ this.m.hashCode()) * 1000003) ^ this.f719n.hashCode()) * 1000003) ^ this.o.hashCode()) * 1000003) ^ this.p.hashCode()) * 1000003) ^ this.q.hashCode()) * 1000003) ^ this.r.hashCode()) * 1000003;
        Integer num = this.s;
        int iHashCode3 = (((((((((((((((((((((((((((((((((((((((iHashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.t.hashCode()) * 1000003) ^ this.u.hashCode()) * 1000003) ^ this.v.hashCode()) * 1000003) ^ this.w.hashCode()) * 1000003) ^ this.x.hashCode()) * 1000003) ^ this.y.hashCode()) * 1000003) ^ this.z.hashCode()) * 1000003) ^ this.A.hashCode()) * 1000003) ^ this.B.hashCode()) * 1000003) ^ this.C.hashCode()) * 1000003) ^ this.D.hashCode()) * 1000003) ^ this.E.hashCode()) * 1000003) ^ this.F.hashCode()) * 1000003) ^ this.G.hashCode()) * 1000003) ^ this.H.hashCode()) * 1000003) ^ this.I.hashCode()) * 1000003) ^ this.J.hashCode()) * 1000003) ^ this.K.hashCode()) * 1000003) ^ this.L.hashCode()) * 1000003;
        Bitmap bitmap2 = this.M;
        return ((((((iHashCode3 ^ (bitmap2 != null ? bitmap2.hashCode() : 0)) * 1000003) ^ this.N.hashCode()) * 1000003) ^ this.O.hashCode()) * 1000003) ^ this.P.hashCode();
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer locationDetailFormattedAddressTextColor() {
        return this.f719n;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer locationDetailInfoTextColor() {
        return this.l;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer locationDetailsBackgroundColor() {
        return this.h;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final String locationDetailsInfoLabelText() {
        return this.m;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Bitmap nearbyToolbarBitmap() {
        return this.e;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer nearbyToolbarColor() {
        return this.c;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer nearbyToolbarIcon() {
        return this.d;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer nearbyToolbarTintColor() {
        return this.g;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer nextButtonBackgroundColor() {
        return this.q;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer paginationBackgroundColor() {
        return this.C;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer placeAddressTextColor() {
        return this.K;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer placeNameTextColor() {
        return this.I;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer prevButtonBackgroundColor() {
        return this.p;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Bitmap refLocationBitmap() {
        return this.M;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Float refLocationCircleAlpha() {
        return this.O;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer refLocationCircleColor() {
        return this.N;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer refLocationIcon() {
        return this.L;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer selectedCategoryBackgroundColor() {
        return this.w;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer selectedCategoryTextColor() {
        return this.x;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer selectedCategoryTintColor() {
        return this.y;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer selectedTabTextColor() {
        return this.E;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Boolean showDefaultMap() {
        return this.P;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer submitButtonColor() {
        return this.s;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer submitButtonResource() {
        return this.t;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final String submitButtonText() {
        return this.v;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer submitButtonTextColor() {
        return this.u;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer tabBackgroundColor() {
        return this.G;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer tabIconTint() {
        return this.H;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer tabIndicatorColor() {
        return this.F;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer tabTextColor() {
        return this.D;
    }

    public final String toString() {
        return "NearbyUIOption{backgroundColor=" + this.a + ", toolbarColor=" + this.b + ", nearbyToolbarColor=" + this.c + ", nearbyToolbarIcon=" + this.d + ", nearbyToolbarBitmap=" + this.e + ", toolbarTintColor=" + this.f + ", nearbyToolbarTintColor=" + this.g + ", locationDetailsBackgroundColor=" + this.h + ", detailListBackgroundColor=" + this.i + ", categoryFilterBackgroundColor=" + this.j + ", detailListSeperatorBackgroundColor=" + this.k + ", locationDetailInfoTextColor=" + this.l + ", locationDetailsInfoLabelText=" + this.m + ", locationDetailFormattedAddressTextColor=" + this.f719n + ", changeLocationButtonTextColor=" + this.o + ", prevButtonBackgroundColor=" + this.p + ", nextButtonBackgroundColor=" + this.q + ", useCurrentLocationButtonTextColor=" + this.r + ", submitButtonColor=" + this.s + ", submitButtonResource=" + this.t + ", submitButtonTextColor=" + this.u + ", submitButtonText=" + this.v + ", selectedCategoryBackgroundColor=" + this.w + ", selectedCategoryTextColor=" + this.x + ", selectedCategoryTintColor=" + this.y + ", categoryBackgroundColor=" + this.z + ", categoryTextColor=" + this.A + ", categoryTintColor=" + this.B + ", paginationBackgroundColor=" + this.C + ", tabTextColor=" + this.D + ", selectedTabTextColor=" + this.E + ", tabIndicatorColor=" + this.F + ", tabBackgroundColor=" + this.G + ", tabIconTint=" + this.H + ", placeNameTextColor=" + this.I + ", distanceTextColor=" + this.J + ", placeAddressTextColor=" + this.K + ", refLocationIcon=" + this.L + ", refLocationBitmap=" + this.M + ", refLocationCircleColor=" + this.N + ", refLocationCircleAlpha=" + this.O + ", showDefaultMap=" + this.P + "}";
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer toolbarColor() {
        return this.b;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer toolbarTintColor() {
        return this.f;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyUIOption
    public final Integer useCurrentLocationButtonTextColor() {
        return this.r;
    }
}
