package com.google.android.libraries.navigation.internal.ady;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ad implements bm {
    REROUTE_TYPE_BETTER_ETA(1),
    REROUTE_TYPE_AVOIDS_CLOSURE(2),
    REROUTE_TYPE_AVOIDS_VEHICLE_RESTRICTION(3),
    REROUTE_TYPE_AVOIDS_DYNAMIC_CLOSURE(4);

    public final int e;

    ad(int i) {
        this.e = i;
    }

    public static ad b(int i) {
        if (i == 1) {
            return REROUTE_TYPE_BETTER_ETA;
        }
        if (i == 2) {
            return REROUTE_TYPE_AVOIDS_CLOSURE;
        }
        if (i == 3) {
            return REROUTE_TYPE_AVOIDS_VEHICLE_RESTRICTION;
        }
        if (i != 4) {
            return null;
        }
        return REROUTE_TYPE_AVOIDS_DYNAMIC_CLOSURE;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.e;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.e);
    }
}
