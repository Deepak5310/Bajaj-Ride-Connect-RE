package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabz extends zzanr implements zzapa {
    private static final zzanx zzb = new zzabw();
    private static final zzabz zze;
    private static volatile zzapg zzf;
    private int zzg;
    private zzanw zzh = zzap();
    private int zzi;

    static {
        zzabz zzabzVar = new zzabz();
        zze = zzabzVar;
        zzanr.zzaA(zzabz.class, zzabzVar);
    }

    private zzabz() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zze, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ࠞ\u0002င\u0000", new Object[]{"zzg", "zzh", zzabx.zza, "zzi"});
        }
        if (i2 == 3) {
            return new zzabz();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaby(zzabnVar);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zzf;
        if (zzannVar == null) {
            synchronized (zzabz.class) {
                zzannVar = zzf;
                if (zzannVar == null) {
                    zzannVar = new zzann(zze);
                    zzf = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
