package com.google.android.libraries.navigation.internal.aap;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum f implements bm {
    UNKNOWN_ENGINE_TYPE(0),
    FUEL_GASOLINE(1),
    FUEL_DIESEL(2),
    FUEL_HYBRID(3),
    BATTERY_ELECTRIC(4);

    public final int f;

    f(int i) {
        this.f = i;
    }

    public static f b(int i) {
        if (i == 0) {
            return UNKNOWN_ENGINE_TYPE;
        }
        if (i == 1) {
            return FUEL_GASOLINE;
        }
        if (i == 2) {
            return FUEL_DIESEL;
        }
        if (i == 3) {
            return FUEL_HYBRID;
        }
        if (i != 4) {
            return null;
        }
        return BATTERY_ELECTRIC;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.f;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f);
    }
}
