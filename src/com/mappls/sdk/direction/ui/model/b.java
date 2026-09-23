package com.mappls.sdk.direction.ui.model;

import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
abstract class b extends DirectionOptions {
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
    private final Boolean M;
    private final Boolean N;
    private final Boolean O;
    private final Boolean P;
    private final Boolean Q;
    private final Boolean R;
    private final String S;
    private final Integer T;
    private final Boolean U;
    private final String a;
    private final String b;
    private final String c;
    private final Boolean d;
    private final Boolean e;
    private final Integer f;
    private final Integer g;
    private final Integer h;
    private final String i;
    private final String j;
    private final String k;
    private final List<String> l;
    private final Boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Boolean f700n;
    private final List<String> o;
    private final Integer p;
    private final Boolean q;
    private final Boolean r;
    private final String s;
    private final Boolean t;
    private final Boolean u;
    private final PlaceOptions v;
    private final DirectionPoint w;
    private final DirectionPoint x;
    private final Boolean y;
    private final Boolean z;

    static class a extends DirectionOptions.Builder {
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
        private Boolean M;
        private Boolean N;
        private Boolean O;
        private Boolean P;
        private Boolean Q;
        private Boolean R;
        private String S;
        private Integer T;
        private Boolean U;
        private String a;
        private String b;
        private String c;
        private Boolean d;
        private Boolean e;
        private Integer f;
        private Integer g;
        private Integer h;
        private String i;
        private String j;
        private String k;
        private List<String> l;
        private Boolean m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Boolean f701n;
        private List<String> o;
        private Integer p;
        private Boolean q;
        private Boolean r;
        private String s;
        private Boolean t;
        private Boolean u;
        private PlaceOptions v;
        private DirectionPoint w;
        private DirectionPoint x;
        private Boolean y;
        private Boolean z;

        a() {
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder alongRouteBuffer(Integer num) {
            this.A = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder alongRouteDarkTheme(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null alongRouteDarkTheme");
            }
            this.C = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder alongRouteDayTheme(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null alongRouteDayTheme");
            }
            this.B = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder alternateCasingRouteColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null alternateCasingRouteColor");
            }
            this.G = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder alternateRouteColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null alternateRouteColor");
            }
            this.F = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder annotation(List<String> list) {
            this.l = list;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions build() {
            String strA = this.a == null ? " routingBaseUrl" : "";
            if (this.b == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " routeReportSummaryBaseUrl");
            }
            if (this.c == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " tripCostEstimationBaseUrl");
            }
            if (this.d == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showProfileOption");
            }
            if (this.e == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showAlternative");
            }
            if (this.f == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " theme");
            }
            if (this.g == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " directionDayTheme");
            }
            if (this.h == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " directionDarkTheme");
            }
            if (this.i == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " resource");
            }
            if (this.j == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " profile");
            }
            if (this.k == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " overview");
            }
            if (this.m == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " steps");
            }
            if (this.s == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " geometries");
            }
            if (this.u == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showStartNavigation");
            }
            if (this.v == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " searchPlaceOption");
            }
            if (this.y == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showDefaultMap");
            }
            if (this.z == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " searchAlongRoute");
            }
            if (this.B == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " alongRouteDayTheme");
            }
            if (this.C == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " alongRouteDarkTheme");
            }
            if (this.D == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " selectedRouteColor");
            }
            if (this.E == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " selectedCasingRouteColor");
            }
            if (this.F == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " alternateRouteColor");
            }
            if (this.G == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " alternateCasingRouteColor");
            }
            if (this.H == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " destinationMarker");
            }
            if (this.I == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " sourceMarker");
            }
            if (this.J == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " firstWayPointMarker");
            }
            if (this.K == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " secondWayPointMarker");
            }
            if (this.L == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " thirdWayPointMarker");
            }
            if (this.M == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showAddWaypointOption");
            }
            if (this.N == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showRouteReportSummary");
            }
            if (this.O == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showRouteReportSummaryOnMap");
            }
            if (this.P == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showTripCostSummary");
            }
            if (this.Q == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showHeavyVehicleProfile");
            }
            if (this.R == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showWalkingProfile");
            }
            if (this.T == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " distanceType");
            }
            if (this.U == null) {
                strA = com.mappls.sdk.direction.ui.model.a.a(strA, " showCurrentLocationOnMap");
            }
            if (strA.isEmpty()) {
                return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f701n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R, this.S, this.T, this.U);
            }
            throw new IllegalStateException("Missing required properties:".concat(strA));
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder continueStraight(Boolean bool) {
            this.r = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder destination(DirectionPoint directionPoint) {
            this.w = directionPoint;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder destinationMarker(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null destinationMarker");
            }
            this.H = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder directionDarkTheme(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null directionDarkTheme");
            }
            this.h = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder directionDayTheme(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null directionDayTheme");
            }
            this.g = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder distanceType(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null distanceType");
            }
            this.T = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder excludes(List<String> list) {
            this.o = list;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        final DirectionOptions.Builder firstWayPointMarker(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null firstWayPointMarker");
            }
            this.J = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder geometries(String str) {
            if (str == null) {
                throw new NullPointerException("Null geometries");
            }
            this.s = str;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder instructions(Boolean bool) {
            this.t = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder isSort(Boolean bool) {
            this.f701n = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder lessVerbose(Boolean bool) {
            this.q = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder mapplsStyle(String str) {
            this.S = str;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder origin(DirectionPoint directionPoint) {
            this.x = directionPoint;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder overview(String str) {
            if (str == null) {
                throw new NullPointerException("Null overview");
            }
            this.k = str;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder profile(String str) {
            if (str == null) {
                throw new NullPointerException("Null profile");
            }
            this.j = str;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder resource(String str) {
            if (str == null) {
                throw new NullPointerException("Null resource");
            }
            this.i = str;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder routeReportSummaryBaseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null routeReportSummaryBaseUrl");
            }
            this.b = str;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder routeType(Integer num) {
            this.p = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder routingBaseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null routingBaseUrl");
            }
            this.a = str;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder searchAlongRoute(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null searchAlongRoute");
            }
            this.z = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder searchPlaceOption(PlaceOptions placeOptions) {
            if (placeOptions == null) {
                throw new NullPointerException("Null searchPlaceOption");
            }
            this.v = placeOptions;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        final DirectionOptions.Builder secondWayPointMarker(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null secondWayPointMarker");
            }
            this.K = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder selectedCasingRouteColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null selectedCasingRouteColor");
            }
            this.E = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder selectedRouteColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null selectedRouteColor");
            }
            this.D = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showAddWaypointOption(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showAddWaypointOption");
            }
            this.M = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showAlternative(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showAlternative");
            }
            this.e = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showCurrentLocationOnMap(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showCurrentLocationOnMap");
            }
            this.U = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showDefaultMap(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showDefaultMap");
            }
            this.y = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showHeavyVehicleProfile(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showHeavyVehicleProfile");
            }
            this.Q = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showProfileOption(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showProfileOption");
            }
            this.d = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showRouteReportSummary(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showRouteReportSummary");
            }
            this.N = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showRouteReportSummaryOnMap(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showRouteReportSummaryOnMap");
            }
            this.O = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showStartNavigation(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showStartNavigation");
            }
            this.u = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showTripCostSummary(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showTripCostSummary");
            }
            this.P = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder showWalkingProfile(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showWalkingProfile");
            }
            this.R = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder sourceMarker(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null sourceMarker");
            }
            this.I = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder steps(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null steps");
            }
            this.m = bool;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder theme(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null theme");
            }
            this.f = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        final DirectionOptions.Builder thirdWayPointMarker(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null thirdWayPointMarker");
            }
            this.L = num;
            return this;
        }

        @Override // com.mappls.sdk.direction.ui.model.DirectionOptions.Builder
        public final DirectionOptions.Builder tripCostEstimationBaseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null tripCostEstimationBaseUrl");
            }
            this.c = str;
            return this;
        }
    }

    b(String str, String str2, String str3, Boolean bool, Boolean bool2, Integer num, Integer num2, Integer num3, String str4, String str5, String str6, List<String> list, Boolean bool3, Boolean bool4, List<String> list2, Integer num4, Boolean bool5, Boolean bool6, String str7, Boolean bool7, Boolean bool8, PlaceOptions placeOptions, DirectionPoint directionPoint, DirectionPoint directionPoint2, Boolean bool9, Boolean bool10, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, String str8, Integer num17, Boolean bool17) {
        if (str == null) {
            throw new NullPointerException("Null routingBaseUrl");
        }
        this.a = str;
        if (str2 == null) {
            throw new NullPointerException("Null routeReportSummaryBaseUrl");
        }
        this.b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null tripCostEstimationBaseUrl");
        }
        this.c = str3;
        if (bool == null) {
            throw new NullPointerException("Null showProfileOption");
        }
        this.d = bool;
        if (bool2 == null) {
            throw new NullPointerException("Null showAlternative");
        }
        this.e = bool2;
        if (num == null) {
            throw new NullPointerException("Null theme");
        }
        this.f = num;
        if (num2 == null) {
            throw new NullPointerException("Null directionDayTheme");
        }
        this.g = num2;
        if (num3 == null) {
            throw new NullPointerException("Null directionDarkTheme");
        }
        this.h = num3;
        if (str4 == null) {
            throw new NullPointerException("Null resource");
        }
        this.i = str4;
        if (str5 == null) {
            throw new NullPointerException("Null profile");
        }
        this.j = str5;
        if (str6 == null) {
            throw new NullPointerException("Null overview");
        }
        this.k = str6;
        this.l = list;
        if (bool3 == null) {
            throw new NullPointerException("Null steps");
        }
        this.m = bool3;
        this.f700n = bool4;
        this.o = list2;
        this.p = num4;
        this.q = bool5;
        this.r = bool6;
        if (str7 == null) {
            throw new NullPointerException("Null geometries");
        }
        this.s = str7;
        this.t = bool7;
        if (bool8 == null) {
            throw new NullPointerException("Null showStartNavigation");
        }
        this.u = bool8;
        if (placeOptions == null) {
            throw new NullPointerException("Null searchPlaceOption");
        }
        this.v = placeOptions;
        this.w = directionPoint;
        this.x = directionPoint2;
        if (bool9 == null) {
            throw new NullPointerException("Null showDefaultMap");
        }
        this.y = bool9;
        if (bool10 == null) {
            throw new NullPointerException("Null searchAlongRoute");
        }
        this.z = bool10;
        this.A = num5;
        if (num6 == null) {
            throw new NullPointerException("Null alongRouteDayTheme");
        }
        this.B = num6;
        if (num7 == null) {
            throw new NullPointerException("Null alongRouteDarkTheme");
        }
        this.C = num7;
        if (num8 == null) {
            throw new NullPointerException("Null selectedRouteColor");
        }
        this.D = num8;
        if (num9 == null) {
            throw new NullPointerException("Null selectedCasingRouteColor");
        }
        this.E = num9;
        if (num10 == null) {
            throw new NullPointerException("Null alternateRouteColor");
        }
        this.F = num10;
        if (num11 == null) {
            throw new NullPointerException("Null alternateCasingRouteColor");
        }
        this.G = num11;
        if (num12 == null) {
            throw new NullPointerException("Null destinationMarker");
        }
        this.H = num12;
        if (num13 == null) {
            throw new NullPointerException("Null sourceMarker");
        }
        this.I = num13;
        if (num14 == null) {
            throw new NullPointerException("Null firstWayPointMarker");
        }
        this.J = num14;
        if (num15 == null) {
            throw new NullPointerException("Null secondWayPointMarker");
        }
        this.K = num15;
        if (num16 == null) {
            throw new NullPointerException("Null thirdWayPointMarker");
        }
        this.L = num16;
        if (bool11 == null) {
            throw new NullPointerException("Null showAddWaypointOption");
        }
        this.M = bool11;
        if (bool12 == null) {
            throw new NullPointerException("Null showRouteReportSummary");
        }
        this.N = bool12;
        if (bool13 == null) {
            throw new NullPointerException("Null showRouteReportSummaryOnMap");
        }
        this.O = bool13;
        if (bool14 == null) {
            throw new NullPointerException("Null showTripCostSummary");
        }
        this.P = bool14;
        if (bool15 == null) {
            throw new NullPointerException("Null showHeavyVehicleProfile");
        }
        this.Q = bool15;
        if (bool16 == null) {
            throw new NullPointerException("Null showWalkingProfile");
        }
        this.R = bool16;
        this.S = str8;
        if (num17 == null) {
            throw new NullPointerException("Null distanceType");
        }
        this.T = num17;
        if (bool17 == null) {
            throw new NullPointerException("Null showCurrentLocationOnMap");
        }
        this.U = bool17;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer alongRouteBuffer() {
        return this.A;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer alongRouteDarkTheme() {
        return this.C;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer alongRouteDayTheme() {
        return this.B;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer alternateCasingRouteColor() {
        return this.G;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer alternateRouteColor() {
        return this.F;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final List<String> annotation() {
        return this.l;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean continueStraight() {
        return this.r;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final DirectionPoint destination() {
        return this.w;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer destinationMarker() {
        return this.H;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer directionDarkTheme() {
        return this.h;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer directionDayTheme() {
        return this.g;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer distanceType() {
        return this.T;
    }

    public final boolean equals(Object obj) {
        List<String> list;
        Boolean bool;
        List<String> list2;
        Integer num;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        DirectionPoint directionPoint;
        DirectionPoint directionPoint2;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DirectionOptions)) {
            return false;
        }
        DirectionOptions directionOptions = (DirectionOptions) obj;
        return this.a.equals(directionOptions.routingBaseUrl()) && this.b.equals(directionOptions.routeReportSummaryBaseUrl()) && this.c.equals(directionOptions.tripCostEstimationBaseUrl()) && this.d.equals(directionOptions.showProfileOption()) && this.e.equals(directionOptions.showAlternative()) && this.f.equals(directionOptions.theme()) && this.g.equals(directionOptions.directionDayTheme()) && this.h.equals(directionOptions.directionDarkTheme()) && this.i.equals(directionOptions.resource()) && this.j.equals(directionOptions.profile()) && this.k.equals(directionOptions.overview()) && ((list = this.l) != null ? list.equals(directionOptions.annotation()) : directionOptions.annotation() == null) && this.m.equals(directionOptions.steps()) && ((bool = this.f700n) != null ? bool.equals(directionOptions.isSort()) : directionOptions.isSort() == null) && ((list2 = this.o) != null ? list2.equals(directionOptions.excludes()) : directionOptions.excludes() == null) && ((num = this.p) != null ? num.equals(directionOptions.routeType()) : directionOptions.routeType() == null) && ((bool2 = this.q) != null ? bool2.equals(directionOptions.lessVerbose()) : directionOptions.lessVerbose() == null) && ((bool3 = this.r) != null ? bool3.equals(directionOptions.continueStraight()) : directionOptions.continueStraight() == null) && this.s.equals(directionOptions.geometries()) && ((bool4 = this.t) != null ? bool4.equals(directionOptions.instructions()) : directionOptions.instructions() == null) && this.u.equals(directionOptions.showStartNavigation()) && this.v.equals(directionOptions.searchPlaceOption()) && ((directionPoint = this.w) != null ? directionPoint.equals(directionOptions.destination()) : directionOptions.destination() == null) && ((directionPoint2 = this.x) != null ? directionPoint2.equals(directionOptions.origin()) : directionOptions.origin() == null) && this.y.equals(directionOptions.showDefaultMap()) && this.z.equals(directionOptions.searchAlongRoute()) && ((num2 = this.A) != null ? num2.equals(directionOptions.alongRouteBuffer()) : directionOptions.alongRouteBuffer() == null) && this.B.equals(directionOptions.alongRouteDayTheme()) && this.C.equals(directionOptions.alongRouteDarkTheme()) && this.D.equals(directionOptions.selectedRouteColor()) && this.E.equals(directionOptions.selectedCasingRouteColor()) && this.F.equals(directionOptions.alternateRouteColor()) && this.G.equals(directionOptions.alternateCasingRouteColor()) && this.H.equals(directionOptions.destinationMarker()) && this.I.equals(directionOptions.sourceMarker()) && this.J.equals(directionOptions.firstWayPointMarker()) && this.K.equals(directionOptions.secondWayPointMarker()) && this.L.equals(directionOptions.thirdWayPointMarker()) && this.M.equals(directionOptions.showAddWaypointOption()) && this.N.equals(directionOptions.showRouteReportSummary()) && this.O.equals(directionOptions.showRouteReportSummaryOnMap()) && this.P.equals(directionOptions.showTripCostSummary()) && this.Q.equals(directionOptions.showHeavyVehicleProfile()) && this.R.equals(directionOptions.showWalkingProfile()) && ((str = this.S) != null ? str.equals(directionOptions.mapplsStyle()) : directionOptions.mapplsStyle() == null) && this.T.equals(directionOptions.distanceType()) && this.U.equals(directionOptions.showCurrentLocationOnMap());
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final List<String> excludes() {
        return this.o;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer firstWayPointMarker() {
        return this.J;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final String geometries() {
        return this.s;
    }

    public final int hashCode() {
        int iHashCode = (((((((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003;
        List<String> list = this.l;
        int iHashCode2 = (((iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003) ^ this.m.hashCode()) * 1000003;
        Boolean bool = this.f700n;
        int iHashCode3 = (iHashCode2 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        List<String> list2 = this.o;
        int iHashCode4 = (iHashCode3 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Integer num = this.p;
        int iHashCode5 = (iHashCode4 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Boolean bool2 = this.q;
        int iHashCode6 = (iHashCode5 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Boolean bool3 = this.r;
        int iHashCode7 = (((iHashCode6 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003) ^ this.s.hashCode()) * 1000003;
        Boolean bool4 = this.t;
        int iHashCode8 = (((((iHashCode7 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003) ^ this.u.hashCode()) * 1000003) ^ this.v.hashCode()) * 1000003;
        DirectionPoint directionPoint = this.w;
        int iHashCode9 = (iHashCode8 ^ (directionPoint == null ? 0 : directionPoint.hashCode())) * 1000003;
        DirectionPoint directionPoint2 = this.x;
        int iHashCode10 = (((((iHashCode9 ^ (directionPoint2 == null ? 0 : directionPoint2.hashCode())) * 1000003) ^ this.y.hashCode()) * 1000003) ^ this.z.hashCode()) * 1000003;
        Integer num2 = this.A;
        int iHashCode11 = (((((((((((((((((((((((((((((((((((iHashCode10 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003) ^ this.B.hashCode()) * 1000003) ^ this.C.hashCode()) * 1000003) ^ this.D.hashCode()) * 1000003) ^ this.E.hashCode()) * 1000003) ^ this.F.hashCode()) * 1000003) ^ this.G.hashCode()) * 1000003) ^ this.H.hashCode()) * 1000003) ^ this.I.hashCode()) * 1000003) ^ this.J.hashCode()) * 1000003) ^ this.K.hashCode()) * 1000003) ^ this.L.hashCode()) * 1000003) ^ this.M.hashCode()) * 1000003) ^ this.N.hashCode()) * 1000003) ^ this.O.hashCode()) * 1000003) ^ this.P.hashCode()) * 1000003) ^ this.Q.hashCode()) * 1000003) ^ this.R.hashCode()) * 1000003;
        String str = this.S;
        return ((((iHashCode11 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.T.hashCode()) * 1000003) ^ this.U.hashCode();
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean instructions() {
        return this.t;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean isSort() {
        return this.f700n;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean lessVerbose() {
        return this.q;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final String mapplsStyle() {
        return this.S;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final DirectionPoint origin() {
        return this.x;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final String overview() {
        return this.k;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final String profile() {
        return this.j;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final String resource() {
        return this.i;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final String routeReportSummaryBaseUrl() {
        return this.b;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer routeType() {
        return this.p;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final String routingBaseUrl() {
        return this.a;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean searchAlongRoute() {
        return this.z;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final PlaceOptions searchPlaceOption() {
        return this.v;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer secondWayPointMarker() {
        return this.K;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer selectedCasingRouteColor() {
        return this.E;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer selectedRouteColor() {
        return this.D;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showAddWaypointOption() {
        return this.M;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showAlternative() {
        return this.e;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showCurrentLocationOnMap() {
        return this.U;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showDefaultMap() {
        return this.y;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showHeavyVehicleProfile() {
        return this.Q;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showProfileOption() {
        return this.d;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showRouteReportSummary() {
        return this.N;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showRouteReportSummaryOnMap() {
        return this.O;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showStartNavigation() {
        return this.u;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showTripCostSummary() {
        return this.P;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean showWalkingProfile() {
        return this.R;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer sourceMarker() {
        return this.I;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Boolean steps() {
        return this.m;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer theme() {
        return this.f;
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final Integer thirdWayPointMarker() {
        return this.L;
    }

    public final String toString() {
        return "DirectionOptions{routingBaseUrl=" + this.a + ", routeReportSummaryBaseUrl=" + this.b + ", tripCostEstimationBaseUrl=" + this.c + ", showProfileOption=" + this.d + ", showAlternative=" + this.e + ", theme=" + this.f + ", directionDayTheme=" + this.g + ", directionDarkTheme=" + this.h + ", resource=" + this.i + ", profile=" + this.j + ", overview=" + this.k + ", annotation=" + this.l + ", steps=" + this.m + ", isSort=" + this.f700n + ", excludes=" + this.o + ", routeType=" + this.p + ", lessVerbose=" + this.q + ", continueStraight=" + this.r + ", geometries=" + this.s + ", instructions=" + this.t + ", showStartNavigation=" + this.u + ", searchPlaceOption=" + this.v + ", destination=" + this.w + ", origin=" + this.x + ", showDefaultMap=" + this.y + ", searchAlongRoute=" + this.z + ", alongRouteBuffer=" + this.A + ", alongRouteDayTheme=" + this.B + ", alongRouteDarkTheme=" + this.C + ", selectedRouteColor=" + this.D + ", selectedCasingRouteColor=" + this.E + ", alternateRouteColor=" + this.F + ", alternateCasingRouteColor=" + this.G + ", destinationMarker=" + this.H + ", sourceMarker=" + this.I + ", firstWayPointMarker=" + this.J + ", secondWayPointMarker=" + this.K + ", thirdWayPointMarker=" + this.L + ", showAddWaypointOption=" + this.M + ", showRouteReportSummary=" + this.N + ", showRouteReportSummaryOnMap=" + this.O + ", showTripCostSummary=" + this.P + ", showHeavyVehicleProfile=" + this.Q + ", showWalkingProfile=" + this.R + ", mapplsStyle=" + this.S + ", distanceType=" + this.T + ", showCurrentLocationOnMap=" + this.U + "}";
    }

    @Override // com.mappls.sdk.direction.ui.model.DirectionOptions
    public final String tripCostEstimationBaseUrl() {
        return this.c;
    }
}
