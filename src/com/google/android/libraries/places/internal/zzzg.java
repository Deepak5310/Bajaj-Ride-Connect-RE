package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzzg extends zzanr implements zzapa {
    private static final zzzg zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private zzzn zzh;
    private zzza zzi;

    static {
        zzzg zzzgVar = new zzzg();
        zzb = zzzgVar;
        zzanr.zzaA(zzzg.class, zzzgVar);
    }

    private zzzg() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzf", "zzg", zzzf.zza, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzzg();
        }
        zzyy zzyyVar = null;
        if (i2 == 4) {
            return new zzze(zzyyVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzzg.class) {
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
