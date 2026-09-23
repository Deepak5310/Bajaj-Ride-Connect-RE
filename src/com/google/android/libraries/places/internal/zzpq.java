package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpq {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzpu zzb;

    static {
        zzpu zzpvVar;
        for (int i = 0; i < 2; i++) {
            zzpvVar = null;
            try {
                zzpvVar = (zzpu) Class.forName(zza[i]).asSubclass(zzpu.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzpvVar != null) {
                zzb = zzpvVar;
            }
        }
        zzpvVar = new zzpv();
        zzb = zzpvVar;
    }

    public static StackTraceElement zza(Class cls, int i) {
        zzpr.zza(cls, "target");
        return zzb.zza(cls, 2);
    }
}
