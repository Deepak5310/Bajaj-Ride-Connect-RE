package com.google.android.libraries.navigation.internal.ir;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum a {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN, 0),
    INITIAL_REFRESH("initial refresh", 1),
    REFRESH("refresh", 2),
    RETRY("retry", 3),
    OOB_MISSING_RETRY("OobMissingRetry", 4),
    ACCOUNT_CHANGE("account change", 5),
    LOCALE_CHANGE("locale change", 6),
    SERVER_RESET_SIGNAL("server reset signal", 7),
    FORCED_UPDATE("forced update", 8),
    PHENTOYPE_BROADCAST_RECEIVED("Phenotype broadcast received", 9),
    PHENOTYPE_FORCED_UPDATE("Phenotype forced update", 10);

    public final String l;
    public final int m;

    a(String str, int i) {
        this.l = str;
        this.m = i;
    }
}
