package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaji extends zzanr implements zzapa {
    private static final zzaji zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzari zzg;
    private double zzh;

    static {
        zzaji zzajiVar = new zzaji();
        zzb = zzajiVar;
        zzanr.zzaA(zzaji.class, zzajiVar);
    }

    private zzaji() {
    }

    public static zzajh zza() {
        return (zzajh) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzaji zzajiVar, zzari zzariVar) {
        zzariVar.getClass();
        zzajiVar.zzg = zzariVar;
        zzajiVar.zzf |= 1;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0000", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzaji();
        }
        zzajg zzajgVar = null;
        if (i2 == 4) {
            return new zzajh(zzajgVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaji.class) {
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
