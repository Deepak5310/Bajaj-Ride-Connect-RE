package com.google.android.libraries.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class a extends CustomRoutesOptions.Builder {
    private String a;
    private int b;
    private byte c;

    @Override // com.google.android.libraries.navigation.CustomRoutesOptions.Builder
    public final CustomRoutesOptions a() {
        String str;
        if (this.c == 1 && (str = this.a) != null) {
            return new b(str, this.b);
        }
        StringBuilder sb = new StringBuilder();
        if (this.a == null) {
            sb.append(" routeToken");
        }
        if (this.c == 0) {
            sb.append(" travelMode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.navigation.CustomRoutesOptions.Builder
    public final String b() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Property \"routeToken\" has not been set");
    }

    @Override // com.google.android.libraries.navigation.CustomRoutesOptions.Builder
    public final CustomRoutesOptions.Builder setRouteToken(String str) {
        if (str == null) {
            throw new NullPointerException("Null routeToken");
        }
        this.a = str;
        return this;
    }

    @Override // com.google.android.libraries.navigation.CustomRoutesOptions.Builder
    public final CustomRoutesOptions.Builder setTravelMode(int i) {
        this.b = i;
        this.c = (byte) 1;
        return this;
    }
}
