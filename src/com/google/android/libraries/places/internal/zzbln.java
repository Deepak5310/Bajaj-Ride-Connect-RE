package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbln {
    private final Logger zza;
    private final Level zzb;

    zzbln(Level level, Class cls) {
        Logger logger = Logger.getLogger(cls.getName());
        zzkt.zzc(level, FirebaseAnalytics.Param.LEVEL);
        this.zzb = level;
        zzkt.zzc(logger, "logger");
        this.zza = logger;
    }

    private static String zzk(zzbpl zzbplVar) {
        return zzbplVar.getZzb() <= 64 ? zzbplVar.zzz().zze() : String.valueOf(zzbplVar.zzA((int) Math.min(zzbplVar.getZzb(), 64L)).zze()).concat("...");
    }

    private final boolean zzl() {
        return this.zza.isLoggable(this.zzb);
    }

    final void zza(int i, int i2, zzbpl zzbplVar, int i3, boolean z) {
        if (zzl()) {
            this.zza.logp(this.zzb, "io.grpc.okhttp.OkHttpFrameLogger", "logData", zzbll.zza(i) + " DATA: streamId=" + i2 + " endStream=" + z + " length=" + i3 + " bytes=" + zzk(zzbplVar));
        }
    }

    final void zzb(int i, int i2, zzbmx zzbmxVar, zzbpp zzbppVar) {
        if (zzl()) {
            Logger logger = this.zza;
            Level level = this.zzb;
            String strZza = zzbll.zza(i);
            String strValueOf = String.valueOf(zzbmxVar);
            int iZzc = zzbppVar.zzc();
            zzbpl zzbplVar = new zzbpl();
            zzbplVar.zzk(zzbppVar);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logGoAway", strZza + " GO_AWAY: lastStreamId=" + i2 + " errorCode=" + strValueOf + " length=" + iZzc + " bytes=" + zzk(zzbplVar));
        }
    }

    final void zzc(int i, int i2, List list, boolean z) {
        if (zzl()) {
            this.zza.logp(this.zzb, "io.grpc.okhttp.OkHttpFrameLogger", "logHeaders", "INBOUND HEADERS: streamId=" + i2 + " headers=" + list.toString() + " endStream=" + z);
        }
    }

    final void zzd(int i, long j) {
        if (zzl()) {
            this.zza.logp(this.zzb, "io.grpc.okhttp.OkHttpFrameLogger", "logPing", zzbll.zza(i) + " PING: ack=false bytes=" + j);
        }
    }

    final void zze(int i, long j) {
        if (zzl()) {
            this.zza.logp(this.zzb, "io.grpc.okhttp.OkHttpFrameLogger", "logPingAck", zzbll.zza(2) + " PING: ack=true bytes=" + j);
        }
    }

    final void zzf(int i, int i2, int i3, List list) {
        if (zzl()) {
            this.zza.logp(this.zzb, "io.grpc.okhttp.OkHttpFrameLogger", "logPushPromise", "INBOUND PUSH_PROMISE: streamId=" + i2 + " promisedStreamId=" + i3 + " headers=" + list.toString());
        }
    }

    final void zzg(int i, int i2, zzbmx zzbmxVar) {
        if (zzl()) {
            this.zza.logp(this.zzb, "io.grpc.okhttp.OkHttpFrameLogger", "logRstStream", zzbll.zza(i) + " RST_STREAM: streamId=" + i2 + " errorCode=" + String.valueOf(zzbmxVar));
        }
    }

    final void zzh(int i, zzbnm zzbnmVar) {
        if (zzl()) {
            Logger logger = this.zza;
            Level level = this.zzb;
            String strZza = zzbll.zza(i);
            EnumMap enumMap = new EnumMap(zzblm.class);
            for (zzblm zzblmVar : zzblm.values()) {
                if (zzbnmVar.zzf(zzblmVar.zza())) {
                    enumMap.put(zzblmVar, Integer.valueOf(zzbnmVar.zza(zzblmVar.zza())));
                }
            }
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logSettings", strZza + " SETTINGS: ack=false settings=" + enumMap.toString());
        }
    }

    final void zzi(int i) {
        if (zzl()) {
            this.zza.logp(this.zzb, "io.grpc.okhttp.OkHttpFrameLogger", "logSettingsAck", zzbll.zza(2).concat(" SETTINGS: ack=true"));
        }
    }

    final void zzj(int i, int i2, long j) {
        if (zzl()) {
            this.zza.logp(this.zzb, "io.grpc.okhttp.OkHttpFrameLogger", "logWindowsUpdate", zzbll.zza(i) + " WINDOW_UPDATE: streamId=" + i2 + " windowSizeIncrement=" + j);
        }
    }
}
