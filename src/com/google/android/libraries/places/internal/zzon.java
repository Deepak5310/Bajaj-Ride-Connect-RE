package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzon {
    private static String zza = "com.google.android.libraries.places.internal.zzos";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.libraries.places.internal.zzos", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzpt.zza();
    }

    public static long zzb() {
        return zzol.zza.zzc();
    }

    public static zznw zzd(String str) {
        return zzol.zza.zze(str);
    }

    public static zzny zzf() {
        return zzi().zza();
    }

    public static zzom zzg() {
        return zzol.zza.zzh();
    }

    public static zzpc zzi() {
        return zzol.zza.zzj();
    }

    public static zzpp zzk() {
        return zzi().zzc();
    }

    public static String zzl() {
        return zzol.zza.zzm();
    }

    public static boolean zzn(String str, Level level, boolean z) {
        zzi().zzd(str, level, z);
        return false;
    }

    protected long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    protected abstract zznw zze(String str);

    protected abstract zzom zzh();

    protected zzpc zzj() {
        return zzpc.zze();
    }

    protected abstract String zzm();
}
