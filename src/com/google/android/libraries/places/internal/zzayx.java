package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayx {
    static final Logger zza = Logger.getLogger(zzasd.class.getName());
    private final Object zzb = new Object();
    private final zzauf zzc;

    zzayx(zzauf zzaufVar, int i, long j, String str) {
        zzkt.zzc(zzaufVar, "logId");
        this.zzc = zzaufVar;
        zzatr zzatrVar = new zzatr();
        zzatrVar.zza(str.concat(" created"));
        zzatrVar.zzb(zzats.CT_INFO);
        zzatrVar.zzd(j);
        zzc(zzatrVar.zze());
    }

    static void zzb(zzauf zzaufVar, Level level, String str) {
        Logger logger = zza;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + zzaufVar.toString() + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    final zzauf zza() {
        return this.zzc;
    }

    final void zzc(zzatu zzatuVar) {
        Level level;
        zzats zzatsVar = zzats.CT_UNKNOWN;
        int iOrdinal = zzatuVar.zzb.ordinal();
        if (iOrdinal != 2) {
            level = iOrdinal != 3 ? Level.FINEST : Level.FINE;
        } else {
            level = Level.FINER;
        }
        synchronized (this.zzb) {
        }
        zzb(this.zzc, level, zzatuVar.zza);
    }

    final boolean zzd() {
        synchronized (this.zzb) {
        }
        return false;
    }
}
