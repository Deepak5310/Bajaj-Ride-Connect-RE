package com.google.android.libraries.navigation.internal.gd;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum a implements bm {
    UNKNOWN(0),
    GMM_API(1),
    PAINT(2),
    CHIME(3),
    NAV_SDK_USAGE_SERVER(4),
    HTTP(5),
    MAPS_MOBILE_SDKS(6);

    private final int i;

    a(int i) {
        this.i = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.i);
    }
}
