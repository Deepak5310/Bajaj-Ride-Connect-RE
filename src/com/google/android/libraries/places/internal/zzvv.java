package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzvv extends zzanr implements zzapa {
    private static final zzvv zzb;
    private static volatile zzapg zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private int zzj;

    static {
        zzvv zzvvVar = new zzvv();
        zzb = zzvvVar;
        zzanr.zzaA(zzvv.class, zzvvVar);
    }

    private zzvv() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzvv();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzvu(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzvv.class) {
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
