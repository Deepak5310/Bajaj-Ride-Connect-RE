package com.mappls.sdk.category.model;

/* JADX INFO: loaded from: classes6.dex */
abstract class b extends SearchCategoryOption {
    private final Integer a;
    private final Integer b;
    private final Boolean c;
    private final Integer d;
    private final Integer e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final Boolean l;
    private final Boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f695n;
    private final String o;
    private final String p;
    private final Integer q;
    private final Boolean r;
    private final Boolean s;

    static class a extends SearchCategoryOption.Builder {
        private Integer a;
        private Integer b;
        private Boolean c;
        private Integer d;
        private Integer e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private Boolean l;
        private Boolean m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f696n;
        private String o;
        private String p;
        private Integer q;
        private Boolean r;
        private Boolean s;

        a() {
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder bounds(String str) {
            this.i = str;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder buffer(Integer num) {
            this.q = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption build() {
            String strA = this.a == null ? com.mappls.sdk.category.model.a.a("", " maxSelectionCount") : "";
            if (this.b == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " searchType");
            }
            if (this.c == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " isUsingInternalMap");
            }
            if (this.d == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " radius");
            }
            if (this.s == null) {
                strA = com.mappls.sdk.category.model.a.a(strA, " showRequestOnMap");
            }
            if (strA.isEmpty()) {
                return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f696n, this.o, this.p, this.q, this.r, this.s);
            }
            throw new IllegalStateException(com.mappls.sdk.category.model.a.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder explain(Boolean bool) {
            this.l = bool;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder filter(String str) {
            this.k = str;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder geometries(String str) {
            this.p = str;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder isSort(Boolean bool) {
            this.r = bool;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder isUsingInternalMap(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null isUsingInternalMap");
            }
            this.c = bool;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder location(String str) {
            this.f = str;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder maxSelectionCount(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null maxSelectionCount");
            }
            this.a = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder page(Integer num) {
            this.e = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder path(String str) {
            this.o = str;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder pod(String str) {
            this.j = str;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder radius(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null radius");
            }
            this.d = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder richData(Boolean bool) {
            this.m = bool;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder searchBy(String str) {
            this.h = str;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder searchType(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null searchType");
            }
            this.b = num;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder showRequestOnMap(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null showRequestOnMap");
            }
            this.s = bool;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder sortBy(String str) {
            this.g = str;
            return this;
        }

        @Override // com.mappls.sdk.category.model.SearchCategoryOption.Builder
        public final SearchCategoryOption.Builder userName(String str) {
            this.f696n = str;
            return this;
        }
    }

    b(Integer num, Integer num2, Boolean bool, Integer num3, Integer num4, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool2, Boolean bool3, String str7, String str8, String str9, Integer num5, Boolean bool4, Boolean bool5) {
        if (num == null) {
            throw new NullPointerException("Null maxSelectionCount");
        }
        this.a = num;
        if (num2 == null) {
            throw new NullPointerException("Null searchType");
        }
        this.b = num2;
        if (bool == null) {
            throw new NullPointerException("Null isUsingInternalMap");
        }
        this.c = bool;
        if (num3 == null) {
            throw new NullPointerException("Null radius");
        }
        this.d = num3;
        this.e = num4;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = str6;
        this.l = bool2;
        this.m = bool3;
        this.f695n = str7;
        this.o = str8;
        this.p = str9;
        this.q = num5;
        this.r = bool4;
        if (bool5 == null) {
            throw new NullPointerException("Null showRequestOnMap");
        }
        this.s = bool5;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final String bounds() {
        return this.i;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Integer buffer() {
        return this.q;
    }

    public final boolean equals(Object obj) {
        Integer num;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Boolean bool;
        Boolean bool2;
        String str7;
        String str8;
        String str9;
        Integer num2;
        Boolean bool3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCategoryOption)) {
            return false;
        }
        SearchCategoryOption searchCategoryOption = (SearchCategoryOption) obj;
        return this.a.equals(searchCategoryOption.maxSelectionCount()) && this.b.equals(searchCategoryOption.searchType()) && this.c.equals(searchCategoryOption.isUsingInternalMap()) && this.d.equals(searchCategoryOption.radius()) && ((num = this.e) != null ? num.equals(searchCategoryOption.page()) : searchCategoryOption.page() == null) && ((str = this.f) != null ? str.equals(searchCategoryOption.location()) : searchCategoryOption.location() == null) && ((str2 = this.g) != null ? str2.equals(searchCategoryOption.sortBy()) : searchCategoryOption.sortBy() == null) && ((str3 = this.h) != null ? str3.equals(searchCategoryOption.searchBy()) : searchCategoryOption.searchBy() == null) && ((str4 = this.i) != null ? str4.equals(searchCategoryOption.bounds()) : searchCategoryOption.bounds() == null) && ((str5 = this.j) != null ? str5.equals(searchCategoryOption.pod()) : searchCategoryOption.pod() == null) && ((str6 = this.k) != null ? str6.equals(searchCategoryOption.filter()) : searchCategoryOption.filter() == null) && ((bool = this.l) != null ? bool.equals(searchCategoryOption.explain()) : searchCategoryOption.explain() == null) && ((bool2 = this.m) != null ? bool2.equals(searchCategoryOption.richData()) : searchCategoryOption.richData() == null) && ((str7 = this.f695n) != null ? str7.equals(searchCategoryOption.userName()) : searchCategoryOption.userName() == null) && ((str8 = this.o) != null ? str8.equals(searchCategoryOption.path()) : searchCategoryOption.path() == null) && ((str9 = this.p) != null ? str9.equals(searchCategoryOption.geometries()) : searchCategoryOption.geometries() == null) && ((num2 = this.q) != null ? num2.equals(searchCategoryOption.buffer()) : searchCategoryOption.buffer() == null) && ((bool3 = this.r) != null ? bool3.equals(searchCategoryOption.isSort()) : searchCategoryOption.isSort() == null) && this.s.equals(searchCategoryOption.showRequestOnMap());
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Boolean explain() {
        return this.l;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final String filter() {
        return this.k;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final String geometries() {
        return this.p;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        Integer num = this.e;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.g;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.h;
        int iHashCode5 = (iHashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.i;
        int iHashCode6 = (iHashCode5 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.j;
        int iHashCode7 = (iHashCode6 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.k;
        int iHashCode8 = (iHashCode7 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Boolean bool = this.l;
        int iHashCode9 = (iHashCode8 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Boolean bool2 = this.m;
        int iHashCode10 = (iHashCode9 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        String str7 = this.f695n;
        int iHashCode11 = (iHashCode10 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.o;
        int iHashCode12 = (iHashCode11 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.p;
        int iHashCode13 = (iHashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        Integer num2 = this.q;
        int iHashCode14 = (iHashCode13 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Boolean bool3 = this.r;
        return ((iHashCode14 ^ (bool3 != null ? bool3.hashCode() : 0)) * 1000003) ^ this.s.hashCode();
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Boolean isSort() {
        return this.r;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Boolean isUsingInternalMap() {
        return this.c;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final String location() {
        return this.f;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Integer maxSelectionCount() {
        return this.a;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Integer page() {
        return this.e;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final String path() {
        return this.o;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final String pod() {
        return this.j;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Integer radius() {
        return this.d;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Boolean richData() {
        return this.m;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final String searchBy() {
        return this.h;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Integer searchType() {
        return this.b;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final Boolean showRequestOnMap() {
        return this.s;
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final String sortBy() {
        return this.g;
    }

    public final String toString() {
        return "SearchCategoryOption{maxSelectionCount=" + this.a + ", searchType=" + this.b + ", isUsingInternalMap=" + this.c + ", radius=" + this.d + ", page=" + this.e + ", location=" + this.f + ", sortBy=" + this.g + ", searchBy=" + this.h + ", bounds=" + this.i + ", pod=" + this.j + ", filter=" + this.k + ", explain=" + this.l + ", richData=" + this.m + ", userName=" + this.f695n + ", path=" + this.o + ", geometries=" + this.p + ", buffer=" + this.q + ", isSort=" + this.r + ", showRequestOnMap=" + this.s + "}";
    }

    @Override // com.mappls.sdk.category.model.SearchCategoryOption
    public final String userName() {
        return this.f695n;
    }
}
