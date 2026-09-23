package com.mappls.sdk.category.model;

/* JADX INFO: loaded from: classes6.dex */
abstract class c extends SearchCategoryUIOption {
    private final Integer a;
    private final Integer b;
    private final Integer c;
    private final Integer d;
    private final Integer e;
    private final Integer f;
    private final Integer g;
    private final Integer h;
    private final Integer i;
    private final Integer j;
    private final Integer k;
    private final Integer l;
    private final Integer m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Float f697n;
    private final Integer o;

    static class a extends SearchCategoryUIOption.Builder {
        private Integer a;
        private Integer b;
        private Integer c;
        private Integer d;
        private Integer e;
        private Integer f;
        private Integer g;
        private Integer h;
        private Integer i;
        private Integer j;
        private Integer k;
        private Integer l;
        private Integer m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Float f698n;
        private Integer o;

        a() {
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder backIcon(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null backIcon");
            }
            this.g = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder backgroundColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null backgroundColor");
            }
            this.f = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption build() {
            String strA = this.a == null ? com.mappls.sdk.category.model.a.a("", " iconTintColor") : "";
            if (this.b == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " itemTextColor");
            }
            if (this.c == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " nextButtonTextColor");
            }
            if (this.d == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " nextButtonColor");
            }
            if (this.e == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " searchTextColor");
            }
            if (this.f == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " backgroundColor");
            }
            if (this.g == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " backIcon");
            }
            if (this.h == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " hintTextColor");
            }
            if (this.i == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " resultCountTextColor");
            }
            if (this.j == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " resultPlaceNameTextColor");
            }
            if (this.k == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " resultPlaceAddressTextColor");
            }
            if (this.l == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " resultPlaceDistanceTextColor");
            }
            if (this.m == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " resultMessageTextColor");
            }
            if (this.f698n == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " polylineWidth");
            }
            if (this.o == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " polylineColor");
            }
            if (strA.isEmpty()) {
                return new e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f698n, this.o);
            }
            throw new IllegalStateException(com.mappls.sdk.category.model.a.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder hintTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null hintTextColor");
            }
            this.h = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder iconTintColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null iconTintColor");
            }
            this.a = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder itemTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null itemTextColor");
            }
            this.b = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder nextButtonColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null nextButtonColor");
            }
            this.d = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder nextButtonTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null nextButtonTextColor");
            }
            this.c = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder polylineColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null polylineColor");
            }
            this.o = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder polylineWidth(Float f) {
            if (f == null) {
                throw new NullPointerException("Null polylineWidth");
            }
            this.f698n = f;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder resultCountTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null resultCountTextColor");
            }
            this.i = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder resultMessageTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null resultMessageTextColor");
            }
            this.m = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder resultPlaceAddressTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null resultPlaceAddressTextColor");
            }
            this.k = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder resultPlaceDistanceTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null resultPlaceDistanceTextColor");
            }
            this.l = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder resultPlaceNameTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null resultPlaceNameTextColor");
            }
            this.j = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryUIOption.Builder
        public final SearchCategoryUIOption.Builder searchTextColor(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null searchTextColor");
            }
            this.e = num;
            return this;
        }
    }

    c(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Float f, Integer num14) {
        if (num == null) {
            throw new NullPointerException("Null iconTintColor");
        }
        this.a = num;
        if (num2 == null) {
            throw new NullPointerException("Null itemTextColor");
        }
        this.b = num2;
        if (num3 == null) {
            throw new NullPointerException("Null nextButtonTextColor");
        }
        this.c = num3;
        if (num4 == null) {
            throw new NullPointerException("Null nextButtonColor");
        }
        this.d = num4;
        if (num5 == null) {
            throw new NullPointerException("Null searchTextColor");
        }
        this.e = num5;
        if (num6 == null) {
            throw new NullPointerException("Null backgroundColor");
        }
        this.f = num6;
        if (num7 == null) {
            throw new NullPointerException("Null backIcon");
        }
        this.g = num7;
        if (num8 == null) {
            throw new NullPointerException("Null hintTextColor");
        }
        this.h = num8;
        if (num9 == null) {
            throw new NullPointerException("Null resultCountTextColor");
        }
        this.i = num9;
        if (num10 == null) {
            throw new NullPointerException("Null resultPlaceNameTextColor");
        }
        this.j = num10;
        if (num11 == null) {
            throw new NullPointerException("Null resultPlaceAddressTextColor");
        }
        this.k = num11;
        if (num12 == null) {
            throw new NullPointerException("Null resultPlaceDistanceTextColor");
        }
        this.l = num12;
        if (num13 == null) {
            throw new NullPointerException("Null resultMessageTextColor");
        }
        this.m = num13;
        if (f == null) {
            throw new NullPointerException("Null polylineWidth");
        }
        this.f697n = f;
        if (num14 == null) {
            throw new NullPointerException("Null polylineColor");
        }
        this.o = num14;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer backIcon() {
        return this.g;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer backgroundColor() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCategoryUIOption)) {
            return false;
        }
        SearchCategoryUIOption searchCategoryUIOption = (SearchCategoryUIOption) obj;
        return this.a.equals(searchCategoryUIOption.iconTintColor()) && this.b.equals(searchCategoryUIOption.itemTextColor()) && this.c.equals(searchCategoryUIOption.nextButtonTextColor()) && this.d.equals(searchCategoryUIOption.nextButtonColor()) && this.e.equals(searchCategoryUIOption.searchTextColor()) && this.f.equals(searchCategoryUIOption.backgroundColor()) && this.g.equals(searchCategoryUIOption.backIcon()) && this.h.equals(searchCategoryUIOption.hintTextColor()) && this.i.equals(searchCategoryUIOption.resultCountTextColor()) && this.j.equals(searchCategoryUIOption.resultPlaceNameTextColor()) && this.k.equals(searchCategoryUIOption.resultPlaceAddressTextColor()) && this.l.equals(searchCategoryUIOption.resultPlaceDistanceTextColor()) && this.m.equals(searchCategoryUIOption.resultMessageTextColor()) && this.f697n.equals(searchCategoryUIOption.polylineWidth()) && this.o.equals(searchCategoryUIOption.polylineColor());
    }

    public final int hashCode() {
        return ((((((((((((((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode()) * 1000003) ^ this.m.hashCode()) * 1000003) ^ this.f697n.hashCode()) * 1000003) ^ this.o.hashCode();
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer hintTextColor() {
        return this.h;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer iconTintColor() {
        return this.a;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer itemTextColor() {
        return this.b;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer nextButtonColor() {
        return this.d;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer nextButtonTextColor() {
        return this.c;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer polylineColor() {
        return this.o;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Float polylineWidth() {
        return this.f697n;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer resultCountTextColor() {
        return this.i;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer resultMessageTextColor() {
        return this.m;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer resultPlaceAddressTextColor() {
        return this.k;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer resultPlaceDistanceTextColor() {
        return this.l;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer resultPlaceNameTextColor() {
        return this.j;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryUIOption
    public final Integer searchTextColor() {
        return this.e;
    }

    public final String toString() {
        return "SearchCategoryUIOption{iconTintColor=" + this.a + ", itemTextColor=" + this.b + ", nextButtonTextColor=" + this.c + ", nextButtonColor=" + this.d + ", searchTextColor=" + this.e + ", backgroundColor=" + this.f + ", backIcon=" + this.g + ", hintTextColor=" + this.h + ", resultCountTextColor=" + this.i + ", resultPlaceNameTextColor=" + this.j + ", resultPlaceAddressTextColor=" + this.k + ", resultPlaceDistanceTextColor=" + this.l + ", resultMessageTextColor=" + this.m + ", polylineWidth=" + this.f697n + ", polylineColor=" + this.o + "}";
    }
}
