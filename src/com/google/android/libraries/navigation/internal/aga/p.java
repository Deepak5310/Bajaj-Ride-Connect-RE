package com.google.android.libraries.navigation.internal.aga;

import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p {
    static final Logger a = Logger.getLogger(com.google.android.libraries.navigation.internal.afx.g.class.getName());
    public final Object b = new Object();
    public final com.google.android.libraries.navigation.internal.afx.aj c;
    public final Collection d;

    public p(com.google.android.libraries.navigation.internal.afx.aj ajVar, long j, String str) {
        com.google.android.libraries.navigation.internal.yx.ar.r(str, SavingTrackHelper.POINT_COL_DESCRIPTION);
        com.google.android.libraries.navigation.internal.yx.ar.r(ajVar, "logId");
        this.c = ajVar;
        this.d = null;
        com.google.android.libraries.navigation.internal.afx.ad adVar = new com.google.android.libraries.navigation.internal.afx.ad();
        adVar.a = String.valueOf(str).concat(" created");
        adVar.b = com.google.android.libraries.navigation.internal.afx.ae.CT_INFO;
        adVar.b(j);
        b(adVar.a());
    }

    static void a(com.google.android.libraries.navigation.internal.afx.aj ajVar, Level level, String str) {
        Logger logger = a;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + String.valueOf(ajVar) + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    final void b(com.google.android.libraries.navigation.internal.afx.af afVar) {
        Level level;
        int iOrdinal = afVar.b.ordinal();
        if (iOrdinal != 2) {
            level = iOrdinal != 3 ? Level.FINEST : Level.FINE;
        } else {
            level = Level.FINER;
        }
        c(afVar);
        a(this.c, level, afVar.a);
    }

    final void c(com.google.android.libraries.navigation.internal.afx.af afVar) {
        synchronized (this.b) {
        }
    }
}
