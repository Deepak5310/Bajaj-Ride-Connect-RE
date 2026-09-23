package com.google.android.libraries.places.internal;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzos extends zzon {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zzom zzc;

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    final class zza {
        zza() {
        }

        static boolean zza() {
            return zzos.zzt();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        zzb = z;
        zzc = new zzom() { // from class: com.google.android.libraries.places.internal.zzos.1
            @Override // com.google.android.libraries.places.internal.zzom
            public zznq zza(Class<?> cls, int i) {
                return zznq.zza;
            }

            @Override // com.google.android.libraries.places.internal.zzom
            public String zzb(Class cls) {
                StackTraceElement stackTraceElementZza;
                if (zzos.zza) {
                    try {
                        if (cls.equals(zzos.zzp())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zzos.zzb || (stackTraceElementZza = zzpq.zza(cls, 1)) == null) {
                    return null;
                }
                return stackTraceElementZza.getClassName();
            }
        };
    }

    static Class<?> zzp() {
        return VMStack.getStackClass2();
    }

    static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzt() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", null);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzon
    protected zznw zze(String str) {
        return zzov.zzb(str);
    }

    @Override // com.google.android.libraries.places.internal.zzon
    protected zzom zzh() {
        return zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzon
    protected zzpc zzj() {
        return zzow.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzon
    protected String zzm() {
        return "platform: Android";
    }
}
