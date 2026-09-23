package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfx {
    static final zzary zza = zzary.zza("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");
    final Long zzb;
    final Boolean zzc;
    final Integer zzd;
    final Integer zze;
    final zzbiu zzf;
    final zzbcv zzg;

    zzbfx(Map map, boolean z, int i, int i2) {
        zzbiu zzbiuVar;
        zzbcv zzbcvVar;
        this.zzb = zzbdx.zzd(map, "timeout");
        this.zzc = zzbdx.zza(map, "waitForReady");
        Integer numZzc = zzbdx.zzc(map, "maxResponseMessageBytes");
        this.zzd = numZzc;
        if (numZzc != null) {
            zzkt.zzj(numZzc.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numZzc);
        }
        Integer numZzc2 = zzbdx.zzc(map, "maxRequestMessageBytes");
        this.zze = numZzc2;
        if (numZzc2 != null) {
            zzkt.zzj(numZzc2.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numZzc2);
        }
        Map mapZzj = z ? zzbdx.zzj(map, "retryPolicy") : null;
        if (mapZzj == null) {
            zzbiuVar = null;
        } else {
            Integer numZzc3 = zzbdx.zzc(mapZzj, "maxAttempts");
            zzkt.zzc(numZzc3, "maxAttempts cannot be empty");
            int iIntValue = numZzc3.intValue();
            zzkt.zzh(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, 5);
            Long lZzd = zzbdx.zzd(mapZzj, "initialBackoff");
            zzkt.zzc(lZzd, "initialBackoff cannot be empty");
            long jLongValue = lZzd.longValue();
            zzkt.zzi(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            Long lZzd2 = zzbdx.zzd(mapZzj, "maxBackoff");
            zzkt.zzc(lZzd2, "maxBackoff cannot be empty");
            long jLongValue2 = lZzd2.longValue();
            zzkt.zzi(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double dZzb = zzbdx.zzb(mapZzj, "backoffMultiplier");
            zzkt.zzc(dZzb, "backoffMultiplier cannot be empty");
            double dDoubleValue = dZzb.doubleValue();
            zzkt.zzj(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", dZzb);
            Long lZzd3 = zzbdx.zzd(mapZzj, "perAttemptRecvTimeout");
            zzkt.zzj(lZzd3 == null || lZzd3.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lZzd3);
            Set setZzb = zzbjm.zzb(mapZzj);
            zzkt.zzf((lZzd3 == null && setZzb.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            zzbiuVar = new zzbiu(iMin, jLongValue, jLongValue2, dDoubleValue, lZzd3, setZzb);
        }
        this.zzf = zzbiuVar;
        Map mapZzj2 = z ? zzbdx.zzj(map, "hedgingPolicy") : null;
        if (mapZzj2 == null) {
            zzbcvVar = null;
        } else {
            Integer numZzc4 = zzbdx.zzc(mapZzj2, "maxAttempts");
            zzkt.zzc(numZzc4, "maxAttempts cannot be empty");
            int iIntValue2 = numZzc4.intValue();
            zzkt.zzh(iIntValue2 >= 2, "maxAttempts must be greater than 1: %s", iIntValue2);
            int iMin2 = Math.min(iIntValue2, 5);
            Long lZzd4 = zzbdx.zzd(mapZzj2, "hedgingDelay");
            zzkt.zzc(lZzd4, "hedgingDelay cannot be empty");
            long jLongValue3 = lZzd4.longValue();
            zzkt.zzi(jLongValue3 >= 0, "hedgingDelay must not be negative: %s", jLongValue3);
            zzbcvVar = new zzbcv(iMin2, jLongValue3, zzbjm.zza(mapZzj2));
        }
        this.zzg = zzbcvVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbfx)) {
            return false;
        }
        zzbfx zzbfxVar = (zzbfx) obj;
        return zzkp.zza(this.zzb, zzbfxVar.zzb) && zzkp.zza(this.zzc, zzbfxVar.zzc) && zzkp.zza(this.zzd, zzbfxVar.zzd) && zzkp.zza(this.zze, zzbfxVar.zze) && zzkp.zza(this.zzf, zzbfxVar.zzf) && zzkp.zza(this.zzg, zzbfxVar.zzg);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("timeoutNanos", this.zzb);
        zzknVarZzb.zzd("waitForReady", this.zzc);
        zzknVarZzb.zzd("maxInboundMessageSize", this.zzd);
        zzknVarZzb.zzd("maxOutboundMessageSize", this.zze);
        zzknVarZzb.zzd("retryPolicy", this.zzf);
        zzknVarZzb.zzd("hedgingPolicy", this.zzg);
        return zzknVarZzb.toString();
    }
}
