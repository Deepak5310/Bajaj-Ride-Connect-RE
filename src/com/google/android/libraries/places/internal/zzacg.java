package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzacg extends zzanr implements zzapa {
    private static final zzacg zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzacg zzacgVar = new zzacg();
        zzb = zzacgVar;
        zzanr.zzaA(zzacg.class, zzacgVar);
    }

    private zzacg() {
    }

    public static zzacf zza() {
        return (zzacf) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzacg zzacgVar, int i) {
        zzacgVar.zzf |= 1;
        zzacgVar.zzg = 1;
    }

    static /* synthetic */ void zze(zzacg zzacgVar, int i) {
        zzacgVar.zzf |= 2;
        zzacgVar.zzh = i;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzacg();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzacf(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzacg.class) {
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
