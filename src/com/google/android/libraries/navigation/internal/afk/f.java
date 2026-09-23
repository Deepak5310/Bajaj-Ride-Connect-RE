package com.google.android.libraries.navigation.internal.afk;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum f implements bm {
    NOT_SET(0),
    CPS_APP_PROCESS_GLOBAL_PROVIDER(1),
    NON_CPS_APP_PROCESS_GLOBAL_PROVIDER(2),
    LOGGER_OVERRIDE_PROVIDER(3),
    LOGGER_DEFERRING_PROVIDER(4),
    EVENT_OVERRIDE(5),
    EVENT_DEFERRING(6),
    LOG_SOURCE_MAPPED(7),
    SERVER_INFRASTRUCTURE(8),
    LOG_REQUEST_SETTER_WEB(9),
    PRIVACY_CONTEXT_RESOLVER(10);

    public final int l;

    f(int i) {
        this.l = i;
    }

    public static f b(int i) {
        switch (i) {
            case 0:
                return NOT_SET;
            case 1:
                return CPS_APP_PROCESS_GLOBAL_PROVIDER;
            case 2:
                return NON_CPS_APP_PROCESS_GLOBAL_PROVIDER;
            case 3:
                return LOGGER_OVERRIDE_PROVIDER;
            case 4:
                return LOGGER_DEFERRING_PROVIDER;
            case 5:
                return EVENT_OVERRIDE;
            case 6:
                return EVENT_DEFERRING;
            case 7:
                return LOG_SOURCE_MAPPED;
            case 8:
                return SERVER_INFRASTRUCTURE;
            case 9:
                return LOG_REQUEST_SETTER_WEB;
            case 10:
                return PRIVACY_CONTEXT_RESOLVER;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.l;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.l);
    }
}
