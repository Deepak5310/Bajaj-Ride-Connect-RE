package com.mappls.sdk.navigation.apis.junction;

import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.n;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class b extends MapplsGetJunctionName {
    private final String a;
    private final List<String> b;
    private final String c;
    private final String d;

    static final class a extends MapplsGetJunctionName.Builder {
        private String a;
        private List<String> b;
        private String c;
        private String d;

        a() {
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName.Builder
        final MapplsGetJunctionName autoBuild() {
            String strA = this.a == null ? n.a("", " baseUrl") : "";
            if (this.b == null) {
                strA = n.a(strA, " imageName");
            }
            if (this.c == null) {
                strA = n.a(strA, " junctionViewMode");
            }
            if (this.d == null) {
                strA = n.a(strA, " size");
            }
            if (strA.isEmpty()) {
                return new b(this.a, this.b, this.c, this.d, 0);
            }
            throw new IllegalStateException(n.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName.Builder
        public final MapplsGetJunctionName.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.a = str;
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName.Builder
        public final MapplsGetJunctionName.Builder imageName(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null imageName");
            }
            this.b = list;
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName.Builder
        public final MapplsGetJunctionName.Builder junctionViewMode(String str) {
            if (str == null) {
                throw new NullPointerException("Null junctionViewMode");
            }
            this.c = str;
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName.Builder
        public final MapplsGetJunctionName.Builder size(String str) {
            if (str == null) {
                throw new NullPointerException("Null size");
            }
            this.d = str;
            return this;
        }
    }

    private b(String str, List<String> list, String str2, String str3) {
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = str3;
    }

    /* synthetic */ b(String str, List list, String str2, String str3, int i) {
        this(str, list, str2, str3);
    }

    @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName, com.mappls.sdk.services.api.MapplsService
    protected final String baseUrl() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsGetJunctionName)) {
            return false;
        }
        MapplsGetJunctionName mapplsGetJunctionName = (MapplsGetJunctionName) obj;
        return this.a.equals(mapplsGetJunctionName.baseUrl()) && this.b.equals(mapplsGetJunctionName.imageName()) && this.c.equals(mapplsGetJunctionName.junctionViewMode()) && this.d.equals(mapplsGetJunctionName.size());
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName
    final List<String> imageName() {
        return this.b;
    }

    @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName
    final String junctionViewMode() {
        return this.c;
    }

    @Override // com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName
    final String size() {
        return this.d;
    }

    public final String toString() {
        StringBuilder sbA = h.a("MapplsGetJunctionName{baseUrl=");
        sbA.append(this.a);
        sbA.append(", imageName=");
        sbA.append(this.b);
        sbA.append(", junctionViewMode=");
        sbA.append(this.c);
        sbA.append(", size=");
        sbA.append(this.d);
        sbA.append("}");
        return sbA.toString();
    }
}
