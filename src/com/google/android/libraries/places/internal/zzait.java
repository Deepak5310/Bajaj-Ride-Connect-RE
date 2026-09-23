package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzait extends zzanr implements zzapa {
    private static final zzait zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh = 1;
    private int zzi;
    private int zzj;

    static {
        zzait zzaitVar = new zzait();
        zzb = zzaitVar;
        zzanr.zzaA(zzait.class, zzaitVar);
    }

    private zzait() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzf", "zzg", zzair.zza, "zzh", zzais.zza, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzait();
        }
        zzaip zzaipVar = null;
        if (i2 == 4) {
            return new zzaiq(zzaipVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzait.class) {
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
