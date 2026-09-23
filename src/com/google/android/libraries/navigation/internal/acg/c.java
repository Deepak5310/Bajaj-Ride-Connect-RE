package com.google.android.libraries.navigation.internal.acg;

import com.google.android.libraries.navigation.internal.ael.bm;
import com.google.android.libraries.navigation.internal.ael.bn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum c implements bm {
    DECORATION_RELEVANCE_STATE_UNSPECIFIED(0),
    UPCOMING(1),
    IN_RANGE(2),
    PASSED(3);

    public static final bn e = new bn() { // from class: com.google.android.libraries.navigation.internal.acg.a
        @Override // com.google.android.libraries.navigation.internal.ael.bn
        public final /* synthetic */ bm a(int i) {
            return c.b(i);
        }
    };
    public final int f;

    c(int i) {
        this.f = i;
    }

    public static c b(int i) {
        if (i == 0) {
            return DECORATION_RELEVANCE_STATE_UNSPECIFIED;
        }
        if (i == 1) {
            return UPCOMING;
        }
        if (i == 2) {
            return IN_RANGE;
        }
        if (i != 3) {
            return null;
        }
        return PASSED;
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
