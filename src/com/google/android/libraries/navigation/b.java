package com.google.android.libraries.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class b extends CustomRoutesOptions {
    private final String a;
    private final int b;

    public b(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CustomRoutesOptions) {
            CustomRoutesOptions customRoutesOptions = (CustomRoutesOptions) obj;
            if (this.a.equals(customRoutesOptions.routeToken()) && this.b == customRoutesOptions.travelMode()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    @Override // com.google.android.libraries.navigation.CustomRoutesOptions
    public final String routeToken() {
        return this.a;
    }

    public final String toString() {
        return "CustomRoutesOptions{routeToken=" + this.a + ", travelMode=" + this.b + "}";
    }

    @Override // com.google.android.libraries.navigation.CustomRoutesOptions
    public final int travelMode() {
        return this.b;
    }
}
