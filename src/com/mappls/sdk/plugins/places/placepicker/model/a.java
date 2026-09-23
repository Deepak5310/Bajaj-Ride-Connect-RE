package com.mappls.sdk.plugins.places.placepicker.model;

import android.graphics.Bitmap;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class a extends PlacePickerOptions {
    private final Integer A;
    private final Boolean B;
    private final String C;
    private final Float D;
    private final Boolean E;
    private final Integer F;
    private final String G;
    private final Integer a;
    private final LatLngBounds b;
    private final CameraPosition c;
    private final List<String> d;
    private final String e;
    private final Boolean f;
    private final Double g;
    private final Double h;
    private final Boolean i;
    private final PlaceOptions j;
    private final Bitmap k;
    private final Integer l;
    private final Integer m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Integer f728n;
    private final Boolean o;
    private final Integer p;
    private final Integer q;
    private final Integer r;
    private final String s;
    private final Integer t;
    private final String u;
    private final Boolean v;
    private final String w;
    private final String x;
    private final Double y;
    private final Double z;

    /* JADX INFO: renamed from: com.mappls.sdk.plugins.places.placepicker.model.a$a, reason: collision with other inner class name */
    static class C0115a extends PlacePickerOptions.Builder {
        private Integer A;
        private Boolean B;
        private String C;
        private Float D;
        private Boolean E;
        private Integer F;
        private String G;
        private Integer a;
        private LatLngBounds b;
        private CameraPosition c;
        private List<String> d;
        private String e;
        private Boolean f;
        private Double g;
        private Double h;
        private Boolean i;
        private PlaceOptions j;
        private Bitmap k;
        private Integer l;
        private Integer m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Integer f729n;
        private Boolean o;
        private Integer p;
        private Integer q;
        private Integer r;
        private String s;
        private Integer t;
        private String u;
        private Boolean v;
        private String w;
        private String x;
        private Double y;
        private Double z;

        C0115a() {
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder addressTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null addressTextColor");
            }
            this.f729n = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.G = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions build() {
            String strA = this.f == null ? com.mappls.sdk.plugins.places.autocomplete.model.a.a("", " includeDeviceLocationButton") : "";
            if (this.g == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " mapMaxZoom");
            }
            if (this.h == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " mapMinZoom");
            }
            if (this.i == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " includeSearch");
            }
            if (this.j == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " searchPlaceOption");
            }
            if (this.l == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " toolbarTintColor");
            }
            if (this.m == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " placeNameTextColor");
            }
            if (this.f729n == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " addressTextColor");
            }
            if (this.o == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " showMarkerShadow");
            }
            if (this.q == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " pickerButtonBackgroundResource");
            }
            if (this.r == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " pickerButtonTextColor");
            }
            if (this.s == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " pickerButtonText");
            }
            if (this.t == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " marker");
            }
            if (this.v == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " buildingFootprintsEnabled");
            }
            if (this.w == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " buildingAppearanceFillColor");
            }
            if (this.x == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " buildingAppearanceStrokeColor");
            }
            if (this.y == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " buildingAppearanceStrokeOpacity");
            }
            if (this.z == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " buildingAppearanceFillOpacity");
            }
            if (this.A == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " buildingAppearanceStrokeWidth");
            }
            if (this.B == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " showEntryCoordinate");
            }
            if (this.C == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " entryCoordinateCircleColor");
            }
            if (this.D == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " entryCoordinateCircleRadius");
            }
            if (this.E == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " entryCoordinateSnapEnable");
            }
            if (this.F == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " entryCoordinateSnappingRadius");
            }
            if (this.G == null) {
                strA = com.mappls.sdk.plugins.places.autocomplete.model.a.a(strA, " baseUrl");
            }
            if (strA.isEmpty()) {
                return new b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f729n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G);
            }
            throw new IllegalStateException(com.mappls.sdk.plugins.places.autocomplete.model.a.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder buildingAppearanceFillColor(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildingAppearanceFillColor");
            }
            this.w = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder buildingAppearanceFillOpacity(Double d) {
            if (d == null) {
                throw new NullPointerException("Null buildingAppearanceFillOpacity");
            }
            this.z = d;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder buildingAppearanceStrokeColor(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildingAppearanceStrokeColor");
            }
            this.x = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder buildingAppearanceStrokeOpacity(Double d) {
            if (d == null) {
                throw new NullPointerException("Null buildingAppearanceStrokeOpacity");
            }
            this.y = d;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder buildingAppearanceStrokeWidth(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null buildingAppearanceStrokeWidth");
            }
            this.A = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder buildingFootprintsEnabled(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null buildingFootprintsEnabled");
            }
            this.v = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder entryCoordinateCircleColor(String str) {
            if (str == null) {
                throw new NullPointerException("Null entryCoordinateCircleColor");
            }
            this.C = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder entryCoordinateCircleRadius(Float f) {
            if (f == null) {
                throw new NullPointerException("Null entryCoordinateCircleRadius");
            }
            this.D = f;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder entryCoordinateSnapEnable(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null entryCoordinateSnapEnable");
            }
            this.E = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder entryCoordinateSnappingRadius(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null entryCoordinateSnappingRadius");
            }
            this.F = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder includeDeviceLocationButton(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null includeDeviceLocationButton");
            }
            this.f = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder includeSearch(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null includeSearch");
            }
            this.i = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder lang(String str) {
            this.u = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder mapMaxZoom(Double d) {
            if (d == null) {
                throw new NullPointerException("Null mapMaxZoom");
            }
            this.g = d;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder mapMinZoom(Double d) {
            if (d == null) {
                throw new NullPointerException("Null mapMinZoom");
            }
            this.h = d;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder marker(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null marker");
            }
            this.t = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder markerBitmap(Bitmap bitmap) {
            this.k = bitmap;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder pickerButtonBackgroundColor(Integer num) {
            this.p = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder pickerButtonBackgroundResource(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null pickerButtonBackgroundResource");
            }
            this.q = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder pickerButtonText(String str) {
            if (str == null) {
                throw new NullPointerException("Null pickerButtonText");
            }
            this.s = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder pickerButtonTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null pickerButtonTextColor");
            }
            this.r = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder placeNameTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null placeNameTextColor");
            }
            this.m = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder searchPlaceOption(PlaceOptions placeOptions) {
            if (placeOptions == null) {
                throw new NullPointerException("Null searchPlaceOption");
            }
            this.j = placeOptions;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder showEntryCoordinate(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showEntryCoordinate");
            }
            this.B = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder showMarkerShadow(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showMarkerShadow");
            }
            this.o = bool;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder startingBounds(LatLngBounds latLngBounds) {
            this.b = latLngBounds;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder startingMapplsPinBounds(List<String> list) {
            this.d = list;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder startingMapplsPinPosition(String str) {
            this.e = str;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder statingCameraPosition(CameraPosition cameraPosition) {
            this.c = cameraPosition;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder toolbarColor(Integer num) {
            this.a = num;
            return this;
        }

        @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions.Builder
        public final PlacePickerOptions.Builder toolbarTintColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null toolbarTintColor");
            }
            this.l = num;
            return this;
        }
    }

    a(Integer num, LatLngBounds latLngBounds, CameraPosition cameraPosition, List<String> list, String str, Boolean bool, Double d, Double d2, Boolean bool2, PlaceOptions placeOptions, Bitmap bitmap, Integer num2, Integer num3, Integer num4, Boolean bool3, Integer num5, Integer num6, Integer num7, String str2, Integer num8, String str3, Boolean bool4, String str4, String str5, Double d3, Double d4, Integer num9, Boolean bool5, String str6, Float f, Boolean bool6, Integer num10, String str7) {
        this.a = num;
        this.b = latLngBounds;
        this.c = cameraPosition;
        this.d = list;
        this.e = str;
        if (bool == null) {
            throw new NullPointerException("Null includeDeviceLocationButton");
        }
        this.f = bool;
        if (d == null) {
            throw new NullPointerException("Null mapMaxZoom");
        }
        this.g = d;
        if (d2 == null) {
            throw new NullPointerException("Null mapMinZoom");
        }
        this.h = d2;
        if (bool2 == null) {
            throw new NullPointerException("Null includeSearch");
        }
        this.i = bool2;
        if (placeOptions == null) {
            throw new NullPointerException("Null searchPlaceOption");
        }
        this.j = placeOptions;
        this.k = bitmap;
        if (num2 == null) {
            throw new NullPointerException("Null toolbarTintColor");
        }
        this.l = num2;
        if (num3 == null) {
            throw new NullPointerException("Null placeNameTextColor");
        }
        this.m = num3;
        if (num4 == null) {
            throw new NullPointerException("Null addressTextColor");
        }
        this.f728n = num4;
        if (bool3 == null) {
            throw new NullPointerException("Null showMarkerShadow");
        }
        this.o = bool3;
        this.p = num5;
        if (num6 == null) {
            throw new NullPointerException("Null pickerButtonBackgroundResource");
        }
        this.q = num6;
        if (num7 == null) {
            throw new NullPointerException("Null pickerButtonTextColor");
        }
        this.r = num7;
        if (str2 == null) {
            throw new NullPointerException("Null pickerButtonText");
        }
        this.s = str2;
        if (num8 == null) {
            throw new NullPointerException("Null marker");
        }
        this.t = num8;
        this.u = str3;
        if (bool4 == null) {
            throw new NullPointerException("Null buildingFootprintsEnabled");
        }
        this.v = bool4;
        if (str4 == null) {
            throw new NullPointerException("Null buildingAppearanceFillColor");
        }
        this.w = str4;
        if (str5 == null) {
            throw new NullPointerException("Null buildingAppearanceStrokeColor");
        }
        this.x = str5;
        if (d3 == null) {
            throw new NullPointerException("Null buildingAppearanceStrokeOpacity");
        }
        this.y = d3;
        if (d4 == null) {
            throw new NullPointerException("Null buildingAppearanceFillOpacity");
        }
        this.z = d4;
        if (num9 == null) {
            throw new NullPointerException("Null buildingAppearanceStrokeWidth");
        }
        this.A = num9;
        if (bool5 == null) {
            throw new NullPointerException("Null showEntryCoordinate");
        }
        this.B = bool5;
        if (str6 == null) {
            throw new NullPointerException("Null entryCoordinateCircleColor");
        }
        this.C = str6;
        if (f == null) {
            throw new NullPointerException("Null entryCoordinateCircleRadius");
        }
        this.D = f;
        if (bool6 == null) {
            throw new NullPointerException("Null entryCoordinateSnapEnable");
        }
        this.E = bool6;
        if (num10 == null) {
            throw new NullPointerException("Null entryCoordinateSnappingRadius");
        }
        this.F = num10;
        if (str7 == null) {
            throw new NullPointerException("Null baseUrl");
        }
        this.G = str7;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer addressTextColor() {
        return this.f728n;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final String baseUrl() {
        return this.G;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final String buildingAppearanceFillColor() {
        return this.w;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Double buildingAppearanceFillOpacity() {
        return this.z;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final String buildingAppearanceStrokeColor() {
        return this.x;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Double buildingAppearanceStrokeOpacity() {
        return this.y;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer buildingAppearanceStrokeWidth() {
        return this.A;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Boolean buildingFootprintsEnabled() {
        return this.v;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final String entryCoordinateCircleColor() {
        return this.C;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Float entryCoordinateCircleRadius() {
        return this.D;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Boolean entryCoordinateSnapEnable() {
        return this.E;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer entryCoordinateSnappingRadius() {
        return this.F;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlacePickerOptions)) {
            return false;
        }
        PlacePickerOptions placePickerOptions = (PlacePickerOptions) obj;
        Integer num2 = this.a;
        if (num2 != null ? num2.equals(placePickerOptions.toolbarColor()) : placePickerOptions.toolbarColor() == null) {
            LatLngBounds latLngBounds = this.b;
            if (latLngBounds != null ? latLngBounds.equals(placePickerOptions.startingBounds()) : placePickerOptions.startingBounds() == null) {
                CameraPosition cameraPosition = this.c;
                if (cameraPosition != null ? cameraPosition.equals(placePickerOptions.statingCameraPosition()) : placePickerOptions.statingCameraPosition() == null) {
                    List<String> list = this.d;
                    if (list != null ? list.equals(placePickerOptions.startingMapplsPinBounds()) : placePickerOptions.startingMapplsPinBounds() == null) {
                        String str2 = this.e;
                        if (str2 != null ? str2.equals(placePickerOptions.startingMapplsPinPosition()) : placePickerOptions.startingMapplsPinPosition() == null) {
                            if (this.f.equals(placePickerOptions.includeDeviceLocationButton()) && this.g.equals(placePickerOptions.mapMaxZoom()) && this.h.equals(placePickerOptions.mapMinZoom()) && this.i.equals(placePickerOptions.includeSearch()) && this.j.equals(placePickerOptions.searchPlaceOption()) && ((bitmap = this.k) != null ? bitmap.equals(placePickerOptions.markerBitmap()) : placePickerOptions.markerBitmap() == null) && this.l.equals(placePickerOptions.toolbarTintColor()) && this.m.equals(placePickerOptions.placeNameTextColor()) && this.f728n.equals(placePickerOptions.addressTextColor()) && this.o.equals(placePickerOptions.showMarkerShadow()) && ((num = this.p) != null ? num.equals(placePickerOptions.pickerButtonBackgroundColor()) : placePickerOptions.pickerButtonBackgroundColor() == null) && this.q.equals(placePickerOptions.pickerButtonBackgroundResource()) && this.r.equals(placePickerOptions.pickerButtonTextColor()) && this.s.equals(placePickerOptions.pickerButtonText()) && this.t.equals(placePickerOptions.marker()) && ((str = this.u) != null ? str.equals(placePickerOptions.lang()) : placePickerOptions.lang() == null) && this.v.equals(placePickerOptions.buildingFootprintsEnabled()) && this.w.equals(placePickerOptions.buildingAppearanceFillColor()) && this.x.equals(placePickerOptions.buildingAppearanceStrokeColor()) && this.y.equals(placePickerOptions.buildingAppearanceStrokeOpacity()) && this.z.equals(placePickerOptions.buildingAppearanceFillOpacity()) && this.A.equals(placePickerOptions.buildingAppearanceStrokeWidth()) && this.B.equals(placePickerOptions.showEntryCoordinate()) && this.C.equals(placePickerOptions.entryCoordinateCircleColor()) && this.D.equals(placePickerOptions.entryCoordinateCircleRadius()) && this.E.equals(placePickerOptions.entryCoordinateSnapEnable()) && this.F.equals(placePickerOptions.entryCoordinateSnappingRadius()) && this.G.equals(placePickerOptions.baseUrl())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        LatLngBounds latLngBounds = this.b;
        int iHashCode2 = (iHashCode ^ (latLngBounds == null ? 0 : latLngBounds.hashCode())) * 1000003;
        CameraPosition cameraPosition = this.c;
        int iHashCode3 = (iHashCode2 ^ (cameraPosition == null ? 0 : cameraPosition.hashCode())) * 1000003;
        List<String> list = this.d;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        String str = this.e;
        int iHashCode5 = (((((((((((iHashCode4 ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003;
        Bitmap bitmap = this.k;
        int iHashCode6 = (((((((((iHashCode5 ^ (bitmap == null ? 0 : bitmap.hashCode())) * 1000003) ^ this.l.hashCode()) * 1000003) ^ this.m.hashCode()) * 1000003) ^ this.f728n.hashCode()) * 1000003) ^ this.o.hashCode()) * 1000003;
        Integer num2 = this.p;
        int iHashCode7 = (((((((((iHashCode6 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003) ^ this.q.hashCode()) * 1000003) ^ this.r.hashCode()) * 1000003) ^ this.s.hashCode()) * 1000003) ^ this.t.hashCode()) * 1000003;
        String str2 = this.u;
        return ((((((((((((((((((((((((iHashCode7 ^ (str2 != null ? str2.hashCode() : 0)) * 1000003) ^ this.v.hashCode()) * 1000003) ^ this.w.hashCode()) * 1000003) ^ this.x.hashCode()) * 1000003) ^ this.y.hashCode()) * 1000003) ^ this.z.hashCode()) * 1000003) ^ this.A.hashCode()) * 1000003) ^ this.B.hashCode()) * 1000003) ^ this.C.hashCode()) * 1000003) ^ this.D.hashCode()) * 1000003) ^ this.E.hashCode()) * 1000003) ^ this.F.hashCode()) * 1000003) ^ this.G.hashCode();
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Boolean includeDeviceLocationButton() {
        return this.f;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Boolean includeSearch() {
        return this.i;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final String lang() {
        return this.u;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Double mapMaxZoom() {
        return this.g;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Double mapMinZoom() {
        return this.h;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer marker() {
        return this.t;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Bitmap markerBitmap() {
        return this.k;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer pickerButtonBackgroundColor() {
        return this.p;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer pickerButtonBackgroundResource() {
        return this.q;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final String pickerButtonText() {
        return this.s;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer pickerButtonTextColor() {
        return this.r;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer placeNameTextColor() {
        return this.m;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final PlaceOptions searchPlaceOption() {
        return this.j;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Boolean showEntryCoordinate() {
        return this.B;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Boolean showMarkerShadow() {
        return this.o;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final LatLngBounds startingBounds() {
        return this.b;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final List<String> startingMapplsPinBounds() {
        return this.d;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final String startingMapplsPinPosition() {
        return this.e;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final CameraPosition statingCameraPosition() {
        return this.c;
    }

    public final String toString() {
        return "PlacePickerOptions{toolbarColor=" + this.a + ", startingBounds=" + this.b + ", statingCameraPosition=" + this.c + ", startingMapplsPinBounds=" + this.d + ", startingMapplsPinPosition=" + this.e + ", includeDeviceLocationButton=" + this.f + ", mapMaxZoom=" + this.g + ", mapMinZoom=" + this.h + ", includeSearch=" + this.i + ", searchPlaceOption=" + this.j + ", markerBitmap=" + this.k + ", toolbarTintColor=" + this.l + ", placeNameTextColor=" + this.m + ", addressTextColor=" + this.f728n + ", showMarkerShadow=" + this.o + ", pickerButtonBackgroundColor=" + this.p + ", pickerButtonBackgroundResource=" + this.q + ", pickerButtonTextColor=" + this.r + ", pickerButtonText=" + this.s + ", marker=" + this.t + ", lang=" + this.u + ", buildingFootprintsEnabled=" + this.v + ", buildingAppearanceFillColor=" + this.w + ", buildingAppearanceStrokeColor=" + this.x + ", buildingAppearanceStrokeOpacity=" + this.y + ", buildingAppearanceFillOpacity=" + this.z + ", buildingAppearanceStrokeWidth=" + this.A + ", showEntryCoordinate=" + this.B + ", entryCoordinateCircleColor=" + this.C + ", entryCoordinateCircleRadius=" + this.D + ", entryCoordinateSnapEnable=" + this.E + ", entryCoordinateSnappingRadius=" + this.F + ", baseUrl=" + this.G + "}";
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer toolbarColor() {
        return this.a;
    }

    @Override // com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions
    public final Integer toolbarTintColor() {
        return this.l;
    }
}
