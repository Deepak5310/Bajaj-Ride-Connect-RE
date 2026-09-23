package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzajv extends zzanr implements zzapa {
    private static final zzajv zzb;
    private static volatile zzapg zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzajv zzajvVar = new zzajv();
        zzb = zzajvVar;
        zzanr.zzaA(zzajv.class, zzajvVar);
    }

    private zzajv() {
    }

    public static zzaju zza() {
        return (zzaju) zzb.zzam();
    }

    public static zzajv zzd() {
        return zzb;
    }

    static /* synthetic */ void zzf(zzajv zzajvVar, String str) {
        str.getClass();
        zzajvVar.zzg = str;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzajv();
        }
        zzajt zzajtVar = null;
        if (i2 == 4) {
            return new zzaju(zzajtVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzajv.class) {
                zzannVar = zze;
                if (zzannVar == null) {
                    zzannVar = new zzann(zzb);
                    zze = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
