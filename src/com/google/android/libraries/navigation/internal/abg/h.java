package com.google.android.libraries.navigation.internal.abg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h implements n {
    private static final String b = "h";
    private int c;
    private final com.google.android.libraries.navigation.internal.abf.a d = com.google.android.libraries.navigation.internal.abf.a.a;
    volatile long a = 0;

    public h() {
        synchronized (this) {
            this.c = 0;
        }
    }

    private final String k() {
        int iH = h();
        if (iH == 15) {
            return "COOKIE_REQUEST";
        }
        if (iH == 36) {
            return "LAYER_TILE_REQUEST";
        }
        if (iH == 45) {
            return "STREET_VIEW_REPORT";
        }
        if (iH == 50) {
            return "REVERSE_GEOCODE_REQUEST";
        }
        if (iH == 62) {
            return "CLIENT_PROPERTIES_2_REQUEST";
        }
        if (iH == 75) {
            return "CLIENT_PARAMETERS_REQUEST";
        }
        if (iH == 108) {
            return "MAP_TILE_4_REQUEST";
        }
        if (iH == 118) {
            return "INDOOR_BUILDING_REQUEST";
        }
        if (iH == 132) {
            return "API_TOKEN_REQUEST";
        }
        if (iH == 147) {
            return "API_QUOTA_EVENT_REQUEST";
        }
        if (iH != 39) {
            return iH != 40 ? com.google.android.libraries.navigation.internal.b.b.b(iH, "UNKNOWN_TYPE ") : "STREETVIEW_REQUEST";
        }
        return "RESOURCE_REQUEST";
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public void a() {
        g();
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public void b() {
        g();
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final synchronized void c() {
        this.c++;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void d() {
        if (com.google.android.libraries.navigation.internal.abf.p.f(b, 3)) {
            k();
        }
        this.a = System.currentTimeMillis();
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public boolean e() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public boolean f() {
        boolean z;
        g();
        synchronized (this) {
            z = this.c < 3;
        }
        return z;
    }

    public final void g() {
        if (this.a > 0) {
            if (com.google.android.libraries.navigation.internal.abf.p.f(b, 3)) {
                k();
            }
        } else if (com.google.android.libraries.navigation.internal.abf.p.f(b, 3)) {
            k();
        }
    }

    public String toString() {
        return k();
    }
}
