package com.mappls.sdk.navigation.apis.junction;

import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.n;

/* JADX INFO: loaded from: classes4.dex */
final class a extends MapplsGetJunction {
    private final String a;
    private final String b;
    private final String c;
    private final Integer d;
    private final String e;

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.apis.junction.a$a, reason: collision with other inner class name */
    static final class C0093a extends MapplsGetJunction.Builder {
        private String a;
        private String b;
        private String c;
        private Integer d;
        private String e;

        C0093a() {
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction.Builder
        final MapplsGetJunction autoBuild() {
            String strA = this.a == null ? n.a("", " baseUrl") : "";
            if (this.b == null) {
                strA = n.a(strA, " routeId");
            }
            if (this.c == null) {
                strA = n.a(strA, " junctionViewMode");
            }
            if (this.d == null) {
                strA = n.a(strA, " routeIdx");
            }
            if (this.e == null) {
                strA = n.a(strA, " size");
            }
            if (strA.isEmpty()) {
                return new a(this.a, this.b, this.c, this.d, this.e, 0);
            }
            throw new IllegalStateException(n.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction.Builder
        public final MapplsGetJunction.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.a = str;
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction.Builder
        public final MapplsGetJunction.Builder junctionViewMode(String str) {
            if (str == null) {
                throw new NullPointerException("Null junctionViewMode");
            }
            this.c = str;
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction.Builder
        public final MapplsGetJunction.Builder routeId(String str) {
            if (str == null) {
                throw new NullPointerException("Null routeId");
            }
            this.b = str;
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction.Builder
        public final MapplsGetJunction.Builder routeIdx(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null routeIdx");
            }
            this.d = num;
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction.Builder
        public final MapplsGetJunction.Builder size(String str) {
            if (str == null) {
                throw new NullPointerException("Null size");
            }
            this.e = str;
            return this;
        }
    }

    private a(String str, String str2, String str3, Integer num, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = num;
        this.e = str4;
    }

    /* synthetic */ a(String str, String str2, String str3, Integer num, String str4, int i) {
        this(str, str2, str3, num, str4);
    }

    @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction, com.mappls.sdk.services.api.MapplsService
    protected final String baseUrl() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsGetJunction)) {
            return false;
        }
        MapplsGetJunction mapplsGetJunction = (MapplsGetJunction) obj;
        return this.a.equals(mapplsGetJunction.baseUrl()) && this.b.equals(mapplsGetJunction.routeId()) && this.c.equals(mapplsGetJunction.junctionViewMode()) && this.d.equals(mapplsGetJunction.routeIdx()) && this.e.equals(mapplsGetJunction.size());
    }

    public final int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction
    final String junctionViewMode() {
        return this.c;
    }

    @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction
    final String routeId() {
        return this.b;
    }

    @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction
    final Integer routeIdx() {
        return this.d;
    }

    @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunction
    final String size() {
        return this.e;
    }

    public final String toString() {
        StringBuilder sbA = h.a("MapplsGetJunction{baseUrl=");
        sbA.append(this.a);
        sbA.append(", routeId=");
        sbA.append(this.b);
        sbA.append(", junctionViewMode=");
        sbA.append(this.c);
        sbA.append(", routeIdx=");
        sbA.append(this.d);
        sbA.append(", size=");
        sbA.append(this.e);
        sbA.append("}");
        return sbA.toString();
    }
}
