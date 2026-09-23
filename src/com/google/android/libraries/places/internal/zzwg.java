package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzwg extends zzanr implements zzapa {
    private static final zzwg zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private long zzi;
    private long zzj;

    static {
        zzwg zzwgVar = new zzwg();
        zzb = zzwgVar;
        zzanr.zzaA(zzwg.class, zzwgVar);
    }

    private zzwg() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzwg();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzwf(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzwg.class) {
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
