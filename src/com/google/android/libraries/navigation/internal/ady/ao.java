package com.google.android.libraries.navigation.internal.ady;

import com.google.android.libraries.navigation.internal.ael.bm;
import com.google.android.libraries.navigation.internal.ael.bn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ao implements bm {
    TRIP_RESULT_DISPLAY_STYLE_UNSPECIFIED(0),
    TRIP_RESULT_DISPLAY_STYLE_DEFAULT(1),
    TRIP_RESULT_DISPLAY_STYLE_GLANCEABLE(2);

    private static final bn e = new bn() { // from class: com.google.android.libraries.navigation.internal.ady.am
        @Override // com.google.android.libraries.navigation.internal.ael.bn
        public final /* synthetic */ bm a(int i) {
            return ao.b(i);
        }
    };
    public final int d;

    ao(int i) {
        this.d = i;
    }

    public static ao b(int i) {
        if (i == 0) {
            return TRIP_RESULT_DISPLAY_STYLE_UNSPECIFIED;
        }
        if (i == 1) {
            return TRIP_RESULT_DISPLAY_STYLE_DEFAULT;
        }
        if (i != 2) {
            return null;
        }
        return TRIP_RESULT_DISPLAY_STYLE_GLANCEABLE;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.d;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.d);
    }
}
