package com.mappls.sdk.plugins.places.autocomplete.model;

import com.mappls.sdk.geojson.Point;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class b extends PlaceOptions {
    private final Integer A;
    private final Boolean B;
    private final Integer C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private final Integer I;
    private final String J;
    private final Boolean K;
    private final Boolean L;
    private final Boolean M;
    private final Integer N;
    private final Integer O;
    private final Integer P;
    private final Integer Q;
    private final String R;
    private final Integer S;
    private final Point a;
    private final String b;
    private final String c;
    private final String d;
    private final Boolean e;
    private final String f;
    private final int g;
    private final Integer h;
    private final Integer i;
    private final Double j;
    private final Boolean k;
    private final Boolean l;
    private final String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Boolean f726n;
    private final List<String> o;
    private final int p;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private final int u;
    private final int v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    static class a extends PlaceOptions.Builder {
        private Integer A;
        private Boolean B;
        private Integer C;
        private Integer D;
        private Integer E;
        private Integer F;
        private Integer G;
        private Integer H;
        private Integer I;
        private String J;
        private Boolean K;
        private Boolean L;
        private Boolean M;
        private Integer N;
        private Integer O;
        private Integer P;
        private Integer Q;
        private String R;
        private Integer S;
        private Point a;
        private String b;
        private String c;
        private String d;
        private Boolean e;
        private String f;
        private Integer g;
        private Integer h;
        private Integer i;
        private Double j;
        private Boolean k;
        private Boolean l;
        private String m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Boolean f727n;
        private List<String> o;
        private Integer p;
        private Integer q;
        private Integer r;
        private Integer s;
        private Integer t;
        private Integer u;
        private Integer v;
        private Integer w;
        private Integer x;
        private Integer y;
        private Integer z;

        a() {
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder addressTextColor(int i) {
            this.t = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder attributionBackgroundColor(int i) {
            this.G = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder attributionHorizontalAlignment(int i) {
            this.F = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder attributionVerticalAlignment(int i) {
            this.E = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        final PlaceOptions autoBuild() {
            String strA = this.b == null ? com.mappls.sdk.plugins.places.autocomplete.model.a.a("", " autoSuggestBaseUrl") : "";
            if (this.c == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " textSearchBaseUrl");
            }
            if (this.d == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " feedbackBaseUrl");
            }
            if (this.e == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " userAddedLocationEnable");
            }
            if (this.g == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " limit");
            }
            if (this.k == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " saveHistory");
            }
            if (this.l == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " enableTextSearch");
            }
            if (this.p == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " viewMode");
            }
            if (this.q == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " backgroundColor");
            }
            if (this.r == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " resultBackgroundColor");
            }
            if (this.s == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " placeNameTextColor");
            }
            if (this.t == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " addressTextColor");
            }
            if (this.u == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " savedPlaceNameTextColor");
            }
            if (this.v == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " favoritePlaceNameTextColor");
            }
            if (this.w == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " distanceTextColor");
            }
            if (this.x == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " errorBackgroundColor");
            }
            if (this.y == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " errorTextColor");
            }
            if (this.z == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " toolbarColor");
            }
            if (this.B == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " showPoweredByText");
            }
            if (this.C == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " poweredByTextColor");
            }
            if (this.D == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " toolbarTintColor");
            }
            if (this.E == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " attributionVerticalAlignment");
            }
            if (this.F == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " attributionHorizontalAlignment");
            }
            if (this.G == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " attributionBackgroundColor");
            }
            if (this.H == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " logoSize");
            }
            if (this.I == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " internalMinCharactersForSearch");
            }
            if (this.M == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " isShowCurrentLocation");
            }
            if (this.N == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " currentLocationTextColor");
            }
            if (this.O == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " currentLocationBackground");
            }
            if (this.P == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " internalDebounce");
            }
            if (this.Q == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " currentLocationIcon");
            }
            if (strA.isEmpty()) {
                return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g.intValue(), this.h, this.i, this.j, this.k, this.l, this.m, this.f727n, this.o, this.p.intValue(), this.q.intValue(), this.r.intValue(), this.s.intValue(), this.t.intValue(), this.u.intValue(), this.v.intValue(), this.w.intValue(), this.x.intValue(), this.y.intValue(), this.z.intValue(), this.A, this.B, this.C, this.D.intValue(), this.E.intValue(), this.F.intValue(), this.G.intValue(), this.H.intValue(), this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R, this.S);
            }
            throw new IllegalStateException(com.mappls.sdk.plugins.places.autocomplete.model.a.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder autoSuggestBaseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null autoSuggestBaseUrl");
            }
            this.b = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder backgroundColor(int i) {
            this.q = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder bridge(Boolean bool) {
            this.L = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder currentLocationBackground(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null currentLocationBackground");
            }
            this.O = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder currentLocationIcon(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null currentLocationIcon");
            }
            this.Q = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder currentLocationTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null currentLocationTextColor");
            }
            this.N = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder distanceTextColor(int i) {
            this.w = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder enableTextSearch(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null enableTextSearch");
            }
            this.l = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder errorBackgroundColor(int i) {
            this.x = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder errorTextColor(int i) {
            this.y = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder favoriteCount(Integer num) {
            this.i = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder favoritePlaceNameTextColor(int i) {
            this.v = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder feedbackBaseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null feedbackBaseUrl");
            }
            this.d = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder filter(String str) {
            this.f = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder hint(String str) {
            this.J = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder hintColor(Integer num) {
            this.S = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder historyCount(Integer num) {
            this.h = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder hyperLocal(Boolean bool) {
            this.K = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        final PlaceOptions.Builder injectedPlaces(List<String> list) {
            this.o = list;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        final PlaceOptions.Builder internalDebounce(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null internalDebounce");
            }
            this.P = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder internalMinCharactersForSearch(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null internalMinCharactersForSearch");
            }
            this.I = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder isShowCurrentLocation(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null isShowCurrentLocation");
            }
            this.M = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder limit(int i) {
            this.g = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder location(Point point) {
            this.a = point;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder logoSize(int i) {
            this.H = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder placeNameTextColor(int i) {
            this.s = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder pod(String str) {
            this.m = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder poweredByTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null poweredByTextColor");
            }
            this.C = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder responseLang(String str) {
            this.R = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder resultBackgroundColor(int i) {
            this.r = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder saveHistory(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null saveHistory");
            }
            this.k = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder savedPlaceNameTextColor(int i) {
            this.u = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder showPoweredByText(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showPoweredByText");
            }
            this.B = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder statusBarColor(Integer num) {
            this.A = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder textSearchBaseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null textSearchBaseUrl");
            }
            this.c = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder tokenizeAddress(Boolean bool) {
            this.f727n = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder toolbarColor(int i) {
            this.z = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder toolbarTintColor(int i) {
            this.D = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder userAddedLocationEnable(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null userAddedLocationEnable");
            }
            this.e = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        final PlaceOptions.Builder viewMode(int i) {
            this.p = Integer.valueOf(i);
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions.Builder
        public final PlaceOptions.Builder zoom(Double d) {
            this.j = d;
            return this;
        }
    }

    b(Point point, String str, String str2, String str3, Boolean bool, String str4, int i, Integer num, Integer num2, Double d, Boolean bool2, Boolean bool3, String str5, Boolean bool4, List<String> list, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, Integer num3, Boolean bool5, Integer num4, int i13, int i14, int i15, int i16, int i17, Integer num5, String str6, Boolean bool6, Boolean bool7, Boolean bool8, Integer num6, Integer num7, Integer num8, Integer num9, String str7, Integer num10) {
        this.a = point;
        if (str == null) {
            throw new NullPointerException("Null autoSuggestBaseUrl");
        }
        this.b = str;
        if (str2 == null) {
            throw new NullPointerException("Null textSearchBaseUrl");
        }
        this.c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null feedbackBaseUrl");
        }
        this.d = str3;
        if (bool == null) {
            throw new NullPointerException("Null userAddedLocationEnable");
        }
        this.e = bool;
        this.f = str4;
        this.g = i;
        this.h = num;
        this.i = num2;
        this.j = d;
        if (bool2 == null) {
            throw new NullPointerException("Null saveHistory");
        }
        this.k = bool2;
        if (bool3 == null) {
            throw new NullPointerException("Null enableTextSearch");
        }
        this.l = bool3;
        this.m = str5;
        this.f726n = bool4;
        this.o = list;
        this.p = i2;
        this.q = i3;
        this.r = i4;
        this.s = i5;
        this.t = i6;
        this.u = i7;
        this.v = i8;
        this.w = i9;
        this.x = i10;
        this.y = i11;
        this.z = i12;
        this.A = num3;
        if (bool5 == null) {
            throw new NullPointerException("Null showPoweredByText");
        }
        this.B = bool5;
        if (num4 == null) {
            throw new NullPointerException("Null poweredByTextColor");
        }
        this.C = num4;
        this.D = i13;
        this.E = i14;
        this.F = i15;
        this.G = i16;
        this.H = i17;
        if (num5 == null) {
            throw new NullPointerException("Null internalMinCharactersForSearch");
        }
        this.I = num5;
        this.J = str6;
        this.K = bool6;
        this.L = bool7;
        if (bool8 == null) {
            throw new NullPointerException("Null isShowCurrentLocation");
        }
        this.M = bool8;
        if (num6 == null) {
            throw new NullPointerException("Null currentLocationTextColor");
        }
        this.N = num6;
        if (num7 == null) {
            throw new NullPointerException("Null currentLocationBackground");
        }
        this.O = num7;
        if (num8 == null) {
            throw new NullPointerException("Null internalDebounce");
        }
        this.P = num8;
        if (num9 == null) {
            throw new NullPointerException("Null currentLocationIcon");
        }
        this.Q = num9;
        this.R = str7;
        this.S = num10;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int addressTextColor() {
        return this.t;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int attributionBackgroundColor() {
        return this.G;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int attributionHorizontalAlignment() {
        return this.F;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int attributionVerticalAlignment() {
        return this.E;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final String autoSuggestBaseUrl() {
        return this.b;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int backgroundColor() {
        return this.q;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Boolean bridge() {
        return this.L;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer currentLocationBackground() {
        return this.O;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer currentLocationIcon() {
        return this.Q;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer currentLocationTextColor() {
        return this.N;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int distanceTextColor() {
        return this.w;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Boolean enableTextSearch() {
        return this.l;
    }

    public final boolean equals(Object obj) {
        String str;
        Integer num;
        Integer num2;
        Double d;
        String str2;
        Boolean bool;
        List<String> list;
        Integer num3;
        String str3;
        Boolean bool2;
        Boolean bool3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlaceOptions)) {
            return false;
        }
        PlaceOptions placeOptions = (PlaceOptions) obj;
        Point point = this.a;
        if (point != null ? point.equals(placeOptions.location()) : placeOptions.location() == null) {
            if (this.b.equals(placeOptions.autoSuggestBaseUrl()) && this.c.equals(placeOptions.textSearchBaseUrl()) && this.d.equals(placeOptions.feedbackBaseUrl()) && this.e.equals(placeOptions.userAddedLocationEnable()) && ((str = this.f) != null ? str.equals(placeOptions.filter()) : placeOptions.filter() == null) && this.g == placeOptions.limit() && ((num = this.h) != null ? num.equals(placeOptions.historyCount()) : placeOptions.historyCount() == null) && ((num2 = this.i) != null ? num2.equals(placeOptions.favoriteCount()) : placeOptions.favoriteCount() == null) && ((d = this.j) != null ? d.equals(placeOptions.zoom()) : placeOptions.zoom() == null) && this.k.equals(placeOptions.saveHistory()) && this.l.equals(placeOptions.enableTextSearch()) && ((str2 = this.m) != null ? str2.equals(placeOptions.pod()) : placeOptions.pod() == null) && ((bool = this.f726n) != null ? bool.equals(placeOptions.tokenizeAddress()) : placeOptions.tokenizeAddress() == null) && ((list = this.o) != null ? list.equals(placeOptions.injectedPlaces()) : placeOptions.injectedPlaces() == null) && this.p == placeOptions.viewMode() && this.q == placeOptions.backgroundColor() && this.r == placeOptions.resultBackgroundColor() && this.s == placeOptions.placeNameTextColor() && this.t == placeOptions.addressTextColor() && this.u == placeOptions.savedPlaceNameTextColor() && this.v == placeOptions.favoritePlaceNameTextColor() && this.w == placeOptions.distanceTextColor() && this.x == placeOptions.errorBackgroundColor() && this.y == placeOptions.errorTextColor() && this.z == placeOptions.toolbarColor() && ((num3 = this.A) != null ? num3.equals(placeOptions.statusBarColor()) : placeOptions.statusBarColor() == null) && this.B.equals(placeOptions.showPoweredByText()) && this.C.equals(placeOptions.poweredByTextColor()) && this.D == placeOptions.toolbarTintColor() && this.E == placeOptions.attributionVerticalAlignment() && this.F == placeOptions.attributionHorizontalAlignment() && this.G == placeOptions.attributionBackgroundColor() && this.H == placeOptions.logoSize() && this.I.equals(placeOptions.internalMinCharactersForSearch()) && ((str3 = this.J) != null ? str3.equals(placeOptions.hint()) : placeOptions.hint() == null) && ((bool2 = this.K) != null ? bool2.equals(placeOptions.hyperLocal()) : placeOptions.hyperLocal() == null) && ((bool3 = this.L) != null ? bool3.equals(placeOptions.bridge()) : placeOptions.bridge() == null) && this.M.equals(placeOptions.isShowCurrentLocation()) && this.N.equals(placeOptions.currentLocationTextColor()) && this.O.equals(placeOptions.currentLocationBackground()) && this.P.equals(placeOptions.internalDebounce()) && this.Q.equals(placeOptions.currentLocationIcon()) && ((str4 = this.R) != null ? str4.equals(placeOptions.responseLang()) : placeOptions.responseLang() == null)) {
                Integer num4 = this.S;
                Integer numHintColor = placeOptions.hintColor();
                if (num4 == null) {
                    if (numHintColor == null) {
                        return true;
                    }
                } else if (num4.equals(numHintColor)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int errorBackgroundColor() {
        return this.x;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int errorTextColor() {
        return this.y;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer favoriteCount() {
        return this.i;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int favoritePlaceNameTextColor() {
        return this.v;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final String feedbackBaseUrl() {
        return this.d;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final String filter() {
        return this.f;
    }

    public final int hashCode() {
        Point point = this.a;
        int iHashCode = ((((((((((point == null ? 0 : point.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        String str = this.f;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.g) * 1000003;
        Integer num = this.h;
        int iHashCode3 = (iHashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.i;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Double d = this.j;
        int iHashCode5 = (((((iHashCode4 ^ (d == null ? 0 : d.hashCode())) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode()) * 1000003;
        String str2 = this.m;
        int iHashCode6 = (iHashCode5 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Boolean bool = this.f726n;
        int iHashCode7 = (iHashCode6 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        List<String> list = this.o;
        int iHashCode8 = (((((((((((((((((((((((iHashCode7 ^ (list == null ? 0 : list.hashCode())) * 1000003) ^ this.p) * 1000003) ^ this.q) * 1000003) ^ this.r) * 1000003) ^ this.s) * 1000003) ^ this.t) * 1000003) ^ this.u) * 1000003) ^ this.v) * 1000003) ^ this.w) * 1000003) ^ this.x) * 1000003) ^ this.y) * 1000003) ^ this.z) * 1000003;
        Integer num3 = this.A;
        int iHashCode9 = (((((((((((((((((iHashCode8 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003) ^ this.B.hashCode()) * 1000003) ^ this.C.hashCode()) * 1000003) ^ this.D) * 1000003) ^ this.E) * 1000003) ^ this.F) * 1000003) ^ this.G) * 1000003) ^ this.H) * 1000003) ^ this.I.hashCode()) * 1000003;
        String str3 = this.J;
        int iHashCode10 = (iHashCode9 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Boolean bool2 = this.K;
        int iHashCode11 = (iHashCode10 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Boolean bool3 = this.L;
        int iHashCode12 = (((((((((((iHashCode11 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003) ^ this.M.hashCode()) * 1000003) ^ this.N.hashCode()) * 1000003) ^ this.O.hashCode()) * 1000003) ^ this.P.hashCode()) * 1000003) ^ this.Q.hashCode()) * 1000003;
        String str4 = this.R;
        int iHashCode13 = (iHashCode12 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Integer num4 = this.S;
        return iHashCode13 ^ (num4 != null ? num4.hashCode() : 0);
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final String hint() {
        return this.J;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer hintColor() {
        return this.S;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer historyCount() {
        return this.h;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Boolean hyperLocal() {
        return this.K;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final List<String> injectedPlaces() {
        return this.o;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer internalDebounce() {
        return this.P;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer internalMinCharactersForSearch() {
        return this.I;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Boolean isShowCurrentLocation() {
        return this.M;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int limit() {
        return this.g;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Point location() {
        return this.a;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int logoSize() {
        return this.H;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int placeNameTextColor() {
        return this.s;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final String pod() {
        return this.m;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer poweredByTextColor() {
        return this.C;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final String responseLang() {
        return this.R;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int resultBackgroundColor() {
        return this.r;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Boolean saveHistory() {
        return this.k;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int savedPlaceNameTextColor() {
        return this.u;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Boolean showPoweredByText() {
        return this.B;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Integer statusBarColor() {
        return this.A;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final String textSearchBaseUrl() {
        return this.c;
    }

    public final String toString() {
        return "PlaceOptions{location=" + this.a + ", autoSuggestBaseUrl=" + this.b + ", textSearchBaseUrl=" + this.c + ", feedbackBaseUrl=" + this.d + ", userAddedLocationEnable=" + this.e + ", filter=" + this.f + ", limit=" + this.g + ", historyCount=" + this.h + ", favoriteCount=" + this.i + ", zoom=" + this.j + ", saveHistory=" + this.k + ", enableTextSearch=" + this.l + ", pod=" + this.m + ", tokenizeAddress=" + this.f726n + ", injectedPlaces=" + this.o + ", viewMode=" + this.p + ", backgroundColor=" + this.q + ", resultBackgroundColor=" + this.r + ", placeNameTextColor=" + this.s + ", addressTextColor=" + this.t + ", savedPlaceNameTextColor=" + this.u + ", favoritePlaceNameTextColor=" + this.v + ", distanceTextColor=" + this.w + ", errorBackgroundColor=" + this.x + ", errorTextColor=" + this.y + ", toolbarColor=" + this.z + ", statusBarColor=" + this.A + ", showPoweredByText=" + this.B + ", poweredByTextColor=" + this.C + ", toolbarTintColor=" + this.D + ", attributionVerticalAlignment=" + this.E + ", attributionHorizontalAlignment=" + this.F + ", attributionBackgroundColor=" + this.G + ", logoSize=" + this.H + ", internalMinCharactersForSearch=" + this.I + ", hint=" + this.J + ", hyperLocal=" + this.K + ", bridge=" + this.L + ", isShowCurrentLocation=" + this.M + ", currentLocationTextColor=" + this.N + ", currentLocationBackground=" + this.O + ", internalDebounce=" + this.P + ", currentLocationIcon=" + this.Q + ", responseLang=" + this.R + ", hintColor=" + this.S + "}";
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Boolean tokenizeAddress() {
        return this.f726n;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int toolbarColor() {
        return this.z;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int toolbarTintColor() {
        return this.D;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Boolean userAddedLocationEnable() {
        return this.e;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final int viewMode() {
        return this.p;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions
    public final Double zoom() {
        return this.j;
    }
}
