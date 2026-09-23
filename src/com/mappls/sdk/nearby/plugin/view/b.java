package com.mappls.sdk.nearby.plugin.view;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
abstract class b extends NearbyViewOption {
    private final Integer a;
    private final Integer b;
    private final Integer c;
    private final Bitmap d;
    private final Integer e;
    private final String f;
    private final Integer g;
    private final Integer h;
    private final Integer i;
    private final Integer j;
    private final Integer k;
    private final Integer l;
    private final Integer m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Integer f723n;
    private final Integer o;
    private final Integer p;
    private final Integer q;
    private final Integer r;
    private final Integer s;
    private final Integer t;
    private final String u;
    private final String v;

    static class a extends NearbyViewOption.Builder {
        private Integer a;
        private Integer b;
        private Integer c;
        private Bitmap d;
        private Integer e;
        private String f;
        private Integer g;
        private Integer h;
        private Integer i;
        private Integer j;
        private Integer k;
        private Integer l;
        private Integer m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Integer f724n;
        private Integer o;
        private Integer p;
        private Integer q;
        private Integer r;
        private Integer s;
        private Integer t;
        private String u;
        private String v;

        a() {
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder addressBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null addressBackgroundColor");
            }
            this.g = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder addressTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null addressTextColor");
            }
            this.i = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder addressTooltipTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null addressTooltipTextColor");
            }
            this.h = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder backgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null backgroundColor");
            }
            this.a = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption build() {
            String strA = this.a == null ? com.mappls.sdk.nearby.plugin.model.a.a("", " backgroundColor") : "";
            if (this.b == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " toolbarBackgroundColor");
            }
            if (this.c == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " toolbarIcon");
            }
            if (this.e == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " toolbarTextColor");
            }
            if (this.f == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " toolbarText");
            }
            if (this.g == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " addressBackgroundColor");
            }
            if (this.h == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " addressTooltipTextColor");
            }
            if (this.i == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " addressTextColor");
            }
            if (this.j == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " changeLocationButtonTextColor");
            }
            if (this.k == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " useCurrentLocationButtonTextColor");
            }
            if (this.l == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " selectedCategoryBackgroundColor");
            }
            if (this.m == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " selectedCategoryTextColor");
            }
            if (this.f724n == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " selectedCategoryTintColor");
            }
            if (this.o == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " categoryBackgroundColor");
            }
            if (this.p == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " categoryTextColor");
            }
            if (this.q == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " categoryTintColor");
            }
            if (this.r == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " submitButtonResource");
            }
            if (this.t == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " submitButtonTextColor");
            }
            if (this.u == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " submitButtonText");
            }
            if (this.v == null) {
                strA = com.mappls.sdk.nearby.plugin.model.a.a(strA, " locationInfoLabelText");
            }
            if (strA.isEmpty()) {
                return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f724n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v);
            }
            throw new IllegalStateException(com.mappls.sdk.nearby.plugin.model.a.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder categoryBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null categoryBackgroundColor");
            }
            this.o = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder categoryTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null categoryTextColor");
            }
            this.p = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder categoryTintColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null categoryTintColor");
            }
            this.q = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder changeLocationButtonTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null changeLocationButtonTextColor");
            }
            this.j = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder locationInfoLabelText(String str) {
            if (str == null) {
                throw new NullPointerException("Null locationInfoLabelText");
            }
            this.v = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder selectedCategoryBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null selectedCategoryBackgroundColor");
            }
            this.l = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder selectedCategoryTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null selectedCategoryTextColor");
            }
            this.m = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder selectedCategoryTintColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null selectedCategoryTintColor");
            }
            this.f724n = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder submitButtonColor(Integer num) {
            this.s = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder submitButtonResource(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null submitButtonResource");
            }
            this.r = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder submitButtonText(String str) {
            if (str == null) {
                throw new NullPointerException("Null submitButtonText");
            }
            this.u = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder submitButtonTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null submitButtonTextColor");
            }
            this.t = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder toolbarBackgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null toolbarBackgroundColor");
            }
            this.b = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder toolbarBitmap(Bitmap bitmap) {
            this.d = bitmap;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder toolbarIcon(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null toolbarIcon");
            }
            this.c = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder toolbarText(String str) {
            if (str == null) {
                throw new NullPointerException("Null toolbarText");
            }
            this.f = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder toolbarTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null toolbarTextColor");
            }
            this.e = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption.Builder
        public final NearbyViewOption.Builder useCurrentLocationButtonTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null useCurrentLocationButtonTextColor");
            }
            this.k = num;
            return this;
        }
    }

    b(Integer num, Integer num2, Integer num3, Bitmap bitmap, Integer num4, String str, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, String str2, String str3) {
        if (num == null) {
            throw new NullPointerException("Null backgroundColor");
        }
        this.a = num;
        if (num2 == null) {
            throw new NullPointerException("Null toolbarBackgroundColor");
        }
        this.b = num2;
        if (num3 == null) {
            throw new NullPointerException("Null toolbarIcon");
        }
        this.c = num3;
        this.d = bitmap;
        if (num4 == null) {
            throw new NullPointerException("Null toolbarTextColor");
        }
        this.e = num4;
        if (str == null) {
            throw new NullPointerException("Null toolbarText");
        }
        this.f = str;
        if (num5 == null) {
            throw new NullPointerException("Null addressBackgroundColor");
        }
        this.g = num5;
        if (num6 == null) {
            throw new NullPointerException("Null addressTooltipTextColor");
        }
        this.h = num6;
        if (num7 == null) {
            throw new NullPointerException("Null addressTextColor");
        }
        this.i = num7;
        if (num8 == null) {
            throw new NullPointerException("Null changeLocationButtonTextColor");
        }
        this.j = num8;
        if (num9 == null) {
            throw new NullPointerException("Null useCurrentLocationButtonTextColor");
        }
        this.k = num9;
        if (num10 == null) {
            throw new NullPointerException("Null selectedCategoryBackgroundColor");
        }
        this.l = num10;
        if (num11 == null) {
            throw new NullPointerException("Null selectedCategoryTextColor");
        }
        this.m = num11;
        if (num12 == null) {
            throw new NullPointerException("Null selectedCategoryTintColor");
        }
        this.f723n = num12;
        if (num13 == null) {
            throw new NullPointerException("Null categoryBackgroundColor");
        }
        this.o = num13;
        if (num14 == null) {
            throw new NullPointerException("Null categoryTextColor");
        }
        this.p = num14;
        if (num15 == null) {
            throw new NullPointerException("Null categoryTintColor");
        }
        this.q = num15;
        if (num16 == null) {
            throw new NullPointerException("Null submitButtonResource");
        }
        this.r = num16;
        this.s = num17;
        if (num18 == null) {
            throw new NullPointerException("Null submitButtonTextColor");
        }
        this.t = num18;
        if (str2 == null) {
            throw new NullPointerException("Null submitButtonText");
        }
        this.u = str2;
        if (str3 == null) {
            throw new NullPointerException("Null locationInfoLabelText");
        }
        this.v = str3;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Integer addressBackgroundColor() {
        return this.g;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Integer addressTextColor() {
        return this.i;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Integer addressTooltipTextColor() {
        return this.h;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Integer backgroundColor() {
        return this.a;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final Integer categoryBackgroundColor() {
        return this.o;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final Integer categoryTextColor() {
        return this.p;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final Integer categoryTintColor() {
        return this.q;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Integer changeLocationButtonTextColor() {
        return this.j;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NearbyViewOption)) {
            return false;
        }
        NearbyViewOption nearbyViewOption = (NearbyViewOption) obj;
        return this.a.equals(nearbyViewOption.backgroundColor()) && this.b.equals(nearbyViewOption.toolbarBackgroundColor()) && this.c.equals(nearbyViewOption.toolbarIcon()) && ((bitmap = this.d) != null ? bitmap.equals(nearbyViewOption.toolbarBitmap()) : nearbyViewOption.toolbarBitmap() == null) && this.e.equals(nearbyViewOption.toolbarTextColor()) && this.f.equals(nearbyViewOption.toolbarText()) && this.g.equals(nearbyViewOption.addressBackgroundColor()) && this.h.equals(nearbyViewOption.addressTooltipTextColor()) && this.i.equals(nearbyViewOption.addressTextColor()) && this.j.equals(nearbyViewOption.changeLocationButtonTextColor()) && this.k.equals(nearbyViewOption.useCurrentLocationButtonTextColor()) && this.l.equals(nearbyViewOption.selectedCategoryBackgroundColor()) && this.m.equals(nearbyViewOption.selectedCategoryTextColor()) && this.f723n.equals(nearbyViewOption.selectedCategoryTintColor()) && this.o.equals(nearbyViewOption.categoryBackgroundColor()) && this.p.equals(nearbyViewOption.categoryTextColor()) && this.q.equals(nearbyViewOption.categoryTintColor()) && this.r.equals(nearbyViewOption.submitButtonResource()) && ((num = this.s) != null ? num.equals(nearbyViewOption.submitButtonColor()) : nearbyViewOption.submitButtonColor() == null) && this.t.equals(nearbyViewOption.submitButtonTextColor()) && this.u.equals(nearbyViewOption.submitButtonText()) && this.v.equals(nearbyViewOption.locationInfoLabelText());
    }

    public final int hashCode() {
        int iHashCode = (((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003;
        Bitmap bitmap = this.d;
        int iHashCode2 = (((((((((((((((((((((((((((((iHashCode ^ (bitmap == null ? 0 : bitmap.hashCode())) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode()) * 1000003) ^ this.m.hashCode()) * 1000003) ^ this.f723n.hashCode()) * 1000003) ^ this.o.hashCode()) * 1000003) ^ this.p.hashCode()) * 1000003) ^ this.q.hashCode()) * 1000003) ^ this.r.hashCode()) * 1000003;
        Integer num = this.s;
        return ((((((iHashCode2 ^ (num != null ? num.hashCode() : 0)) * 1000003) ^ this.t.hashCode()) * 1000003) ^ this.u.hashCode()) * 1000003) ^ this.v.hashCode();
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final String locationInfoLabelText() {
        return this.v;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final Integer selectedCategoryBackgroundColor() {
        return this.l;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final Integer selectedCategoryTextColor() {
        return this.m;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final Integer selectedCategoryTintColor() {
        return this.f723n;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final Integer submitButtonColor() {
        return this.s;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final Integer submitButtonResource() {
        return this.r;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final String submitButtonText() {
        return this.u;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    public final Integer submitButtonTextColor() {
        return this.t;
    }

    public final String toString() {
        return "NearbyViewOption{backgroundColor=" + this.a + ", toolbarBackgroundColor=" + this.b + ", toolbarIcon=" + this.c + ", toolbarBitmap=" + this.d + ", toolbarTextColor=" + this.e + ", toolbarText=" + this.f + ", addressBackgroundColor=" + this.g + ", addressTooltipTextColor=" + this.h + ", addressTextColor=" + this.i + ", changeLocationButtonTextColor=" + this.j + ", useCurrentLocationButtonTextColor=" + this.k + ", selectedCategoryBackgroundColor=" + this.l + ", selectedCategoryTextColor=" + this.m + ", selectedCategoryTintColor=" + this.f723n + ", categoryBackgroundColor=" + this.o + ", categoryTextColor=" + this.p + ", categoryTintColor=" + this.q + ", submitButtonResource=" + this.r + ", submitButtonColor=" + this.s + ", submitButtonTextColor=" + this.t + ", submitButtonText=" + this.u + ", locationInfoLabelText=" + this.v + "}";
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Integer toolbarBackgroundColor() {
        return this.b;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Bitmap toolbarBitmap() {
        return this.d;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Integer toolbarIcon() {
        return this.c;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final String toolbarText() {
        return this.f;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Integer toolbarTextColor() {
        return this.e;
    }

    @Override // com.mappls.sdk.nearby.plugin.view.NearbyViewOption
    final Integer useCurrentLocationButtonTextColor() {
        return this.k;
    }
}
