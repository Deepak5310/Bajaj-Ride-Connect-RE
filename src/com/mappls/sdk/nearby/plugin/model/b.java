package com.mappls.sdk.nearby.plugin.model;

/* JADX INFO: loaded from: classes4.dex */
abstract class b extends NearbyOption {
    private final Integer a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final Boolean g;
    private final Boolean h;
    private final String i;

    static class a extends NearbyOption.Builder {
        private Integer a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private Boolean g;
        private Boolean h;
        private String i;

        a() {
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption.Builder bounds(String str) {
            this.d = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption build() {
            String strA = this.a == null ? com.mappls.sdk.nearby.plugin.model.a.a("", " radius") : "";
            if (strA.isEmpty()) {
                return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
            }
            throw new IllegalStateException(com.mappls.sdk.nearby.plugin.model.a.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption.Builder explain(Boolean bool) {
            this.g = bool;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption.Builder filter(String str) {
            this.f = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption.Builder pod(String str) {
            this.e = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption.Builder radius(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null radius");
            }
            this.a = num;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption.Builder richData(Boolean bool) {
            this.h = bool;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption.Builder searchBy(String str) {
            this.c = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption.Builder sortBy(String str) {
            this.b = str;
            return this;
        }

        @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption.Builder
        public final NearbyOption.Builder userName(String str) {
            this.i = str;
            return this;
        }
    }

    b(Integer num, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, String str6) {
        if (num == null) {
            throw new NullPointerException("Null radius");
        }
        this.a = num;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = bool;
        this.h = bool2;
        this.i = str6;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption
    public final String bounds() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NearbyOption)) {
            return false;
        }
        NearbyOption nearbyOption = (NearbyOption) obj;
        if (this.a.equals(nearbyOption.radius()) && ((str = this.b) != null ? str.equals(nearbyOption.sortBy()) : nearbyOption.sortBy() == null) && ((str2 = this.c) != null ? str2.equals(nearbyOption.searchBy()) : nearbyOption.searchBy() == null) && ((str3 = this.d) != null ? str3.equals(nearbyOption.bounds()) : nearbyOption.bounds() == null) && ((str4 = this.e) != null ? str4.equals(nearbyOption.pod()) : nearbyOption.pod() == null) && ((str5 = this.f) != null ? str5.equals(nearbyOption.filter()) : nearbyOption.filter() == null) && ((bool = this.g) != null ? bool.equals(nearbyOption.explain()) : nearbyOption.explain() == null) && ((bool2 = this.h) != null ? bool2.equals(nearbyOption.richData()) : nearbyOption.richData() == null)) {
            String str6 = this.i;
            String strUserName = nearbyOption.userName();
            if (str6 == null) {
                if (strUserName == null) {
                    return true;
                }
            } else if (str6.equals(strUserName)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption
    public final Boolean explain() {
        return this.g;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption
    public final String filter() {
        return this.f;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Boolean bool = this.g;
        int iHashCode7 = (iHashCode6 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Boolean bool2 = this.h;
        int iHashCode8 = (iHashCode7 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        String str6 = this.i;
        return iHashCode8 ^ (str6 != null ? str6.hashCode() : 0);
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption
    public final String pod() {
        return this.e;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption
    public final Integer radius() {
        return this.a;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption
    public final Boolean richData() {
        return this.h;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption
    public final String searchBy() {
        return this.c;
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption
    public final String sortBy() {
        return this.b;
    }

    public final String toString() {
        return "NearbyOption{radius=" + this.a + ", sortBy=" + this.b + ", searchBy=" + this.c + ", bounds=" + this.d + ", pod=" + this.e + ", filter=" + this.f + ", explain=" + this.g + ", richData=" + this.h + ", userName=" + this.i + "}";
    }

    @Override // com.mappls.sdk.nearby.plugin.model.NearbyOption
    public final String userName() {
        return this.i;
    }
}
