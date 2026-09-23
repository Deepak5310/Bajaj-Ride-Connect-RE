package com.google.android.libraries.navigation;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class RoutingOptions {
    private List a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private long g;
    private boolean f = true;
    private AlternateRoutesStrategy h = AlternateRoutesStrategy.SHOW_ALL;

    /* JADX INFO: compiled from: PG */
    public @interface RoutingStrategy {
        public static final int DEFAULT_BEST = 0;
        public static final int SHORTER = 1;
        public static final int TARGET_DISTANCE = 2;
    }

    /* JADX INFO: compiled from: PG */
    public @interface TravelMode {
        public static final int CYCLING = 1;
        public static final int DRIVING = 0;
        public static final int TAXI = 4;
        public static final int TWO_WHEELER = 3;
        public static final int WALKING = 2;
    }

    public RoutingOptions alternateRoutesStrategy(AlternateRoutesStrategy alternateRoutesStrategy) {
        try {
            this.h = alternateRoutesStrategy;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public RoutingOptions avoidFerries(boolean z) {
        try {
            this.f = z;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public RoutingOptions avoidHighways(boolean z) {
        try {
            this.e = z;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public RoutingOptions avoidTolls(boolean z) {
        try {
            this.d = z;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public AlternateRoutesStrategy getAlternateRoutesStrategy() {
        try {
            return this.h;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean getAvoidFerries() {
        try {
            return this.f;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean getAvoidHighways() {
        try {
            return this.e;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean getAvoidTolls() {
        try {
            return this.d;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public long getLocationTimeoutMs() {
        try {
            return this.g;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getRoutingStrategy() {
        try {
            return this.c;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public List<Integer> getTargetDistancesMeters() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getTravelMode() {
        try {
            return this.b;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public RoutingOptions locationTimeoutMs(long j) {
        try {
            this.g = j;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public RoutingOptions routingStrategy(int i) {
        if (i != 2) {
            try {
                this.a = null;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }
        this.c = i;
        return this;
    }

    public RoutingOptions targetDistancesMeters(List<Integer> list) {
        try {
            this.c = 2;
            this.a = list;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public RoutingOptions travelMode(int i) {
        try {
            this.b = i;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
