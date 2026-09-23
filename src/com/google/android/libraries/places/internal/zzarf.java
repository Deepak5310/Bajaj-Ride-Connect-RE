package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzarf extends zzanr implements zzapa {
    private static final zzarf zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzarf zzarfVar = new zzarf();
        zzb = zzarfVar;
        zzanr.zzaA(zzarf.class, zzarfVar);
    }

    private zzarf() {
    }

    public static zzarf zzf() {
        return zzb;
    }

    public final int zza() {
        return this.zzh;
    }

    public final int zzc() {
        return this.zzg;
    }

    public final int zzd() {
        return this.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzarf();
        }
        zzard zzardVar = null;
        if (i2 == 4) {
            return new zzare(zzardVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzarf.class) {
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
