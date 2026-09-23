package com.google.android.libraries.navigation;

import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalStateException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CustomRoutesOptions {

    /* JADX INFO: compiled from: PG */
    public static abstract class Builder {
        public abstract CustomRoutesOptions a();

        public abstract String b();

        public final CustomRoutesOptions build() throws Throwable {
            try {
                try {
                    com.google.android.libraries.navigation.internal.zn.g.e.j(b());
                    return a();
                } catch (IllegalArgumentException e) {
                    throw new ApiIllegalStateException(String.format("%s: %s", "The route token passed in the builder is malformed", b()), e);
                }
            } catch (Error e2) {
                e = e2;
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public abstract Builder setRouteToken(String str);

        public abstract Builder setTravelMode(int i);
    }

    /* JADX INFO: compiled from: PG */
    public @interface TravelMode {
        public static final int DRIVING = 0;
        public static final int TWO_WHEELER = 1;
    }

    public static Builder builder() {
        try {
            return new a();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public abstract String routeToken();

    public abstract int travelMode();
}
