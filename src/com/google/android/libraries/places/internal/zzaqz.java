package com.google.android.libraries.places.internal;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Nullable;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqz {
    public static final zzaqe zza;
    public static final zzaqe zzb;
    public static final zzaqe zzc;
    private static final ThreadLocal zzd;

    @Nullable
    private static final Method zze;

    @Nullable
    private static final Method zzf;

    @Nullable
    private static final Method zzg;

    static {
        zzaqd zzaqdVarZzd = zzaqe.zzd();
        zzaqdVarZzd.zzb(-62135596800L);
        zzaqdVarZzd.zza(0);
        zza = (zzaqe) zzaqdVarZzd.zzq();
        zzaqd zzaqdVarZzd2 = zzaqe.zzd();
        zzaqdVarZzd2.zzb(253402300799L);
        zzaqdVarZzd2.zza(999999999);
        zzb = (zzaqe) zzaqdVarZzd2.zzq();
        zzaqd zzaqdVarZzd3 = zzaqe.zzd();
        zzaqdVarZzd3.zzb(0L);
        zzaqdVarZzd3.zza(0);
        zzc = (zzaqe) zzaqdVarZzd3.zzq();
        zzd = new zzaqy();
        zze = zzb("now");
        zzf = zzb("getEpochSecond");
        zzg = zzb("getNano");
    }

    public static String zza(zzaqe zzaqeVar) {
        String str;
        long jZzc = zzaqeVar.zzc();
        int iZza = zzaqeVar.zza();
        if (jZzc < -62135596800L || jZzc > 253402300799L || iZza < 0 || iZza >= 1000000000) {
            throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(jZzc), Integer.valueOf(iZza)));
        }
        long jZzc2 = zzaqeVar.zzc();
        int iZza2 = zzaqeVar.zza();
        StringBuilder sb = new StringBuilder();
        sb.append(((SimpleDateFormat) zzd.get()).format(new Date(jZzc2 * 1000)));
        if (iZza2 != 0) {
            sb.append(".");
            if (iZza2 % DurationKt.NANOS_IN_MILLIS == 0) {
                str = String.format(Locale.ENGLISH, "%1$03d", Integer.valueOf(iZza2 / DurationKt.NANOS_IN_MILLIS));
            } else {
                str = iZza2 % 1000 == 0 ? String.format(Locale.ENGLISH, "%1$06d", Integer.valueOf(iZza2 / 1000)) : String.format(Locale.ENGLISH, "%1$09d", Integer.valueOf(iZza2));
            }
            sb.append(str);
        }
        sb.append("Z");
        return sb.toString();
    }

    @Nullable
    private static Method zzb(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }
}
