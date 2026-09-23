package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcy extends zzanr implements zzapa {
    private static final zzcy zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private zzanz zzh = zzas();
    private zzanz zzi = zzas();

    static {
        zzcy zzcyVar = new zzcy();
        zzb = zzcyVar;
        zzanr.zzaA(zzcy.class, zzcyVar);
    }

    private zzcy() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0003\u0000\u0001\u0001✐\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b✐᠌\u0000", new Object[]{"zzf", "zzh", zzdd.class, "zzi", zzdg.class, "zzg", zzcx.zza});
        }
        if (i2 == 3) {
            return new zzcy();
        }
        zzcv zzcvVar = null;
        if (i2 == 4) {
            return new zzcw(zzcvVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzcy.class) {
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
