package com.google.android.libraries.navigation.internal.xt;

import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bh {
    public static final az a(String str, boolean z, String str2, Set set, boolean z2) {
        return new az("com.google.android.gms.maps", str, false, new h(true, set, new bc(), new bd(Boolean.class)));
    }

    public static final az b(String str, long j, String str2, Set set, boolean z) {
        final Class<Long> cls = Long.class;
        return new az("com.google.android.gms.maps", "BoomerangReliabilityManagement__recovery_crash_count_threshold", 3L, new h(true, set, new bg() { // from class: com.google.android.libraries.navigation.internal.xt.ba
            @Override // com.google.android.libraries.navigation.internal.xt.bg
            public final Object a(Object obj) {
                return Long.valueOf(Long.parseLong((String) obj));
            }
        }, new bg() { // from class: com.google.android.libraries.navigation.internal.xt.bb
            @Override // com.google.android.libraries.navigation.internal.xt.bg
            public final Object a(Object obj) {
                return (Long) cls.cast(obj);
            }
        }), true);
    }

    public static final az c(String str, String str2, String str3, Set set, boolean z) {
        final Class<String> cls = String.class;
        return new az("com.google.android.gms.maps", str, str2, new h(true, set, new bg() { // from class: com.google.android.libraries.navigation.internal.xt.be
            @Override // com.google.android.libraries.navigation.internal.xt.bg
            public final Object a(Object obj) {
                return (String) obj;
            }
        }, new bg() { // from class: com.google.android.libraries.navigation.internal.xt.bf
            @Override // com.google.android.libraries.navigation.internal.xt.bg
            public final Object a(Object obj) {
                return (String) cls.cast(obj);
            }
        }), true);
    }

    public static final az d(String str, boolean z, String str2, Set set, boolean z2) {
        return new az(str2, str, Boolean.valueOf(z), new h(true, set, new bc(), new bd(Boolean.class)), true);
    }
}
