package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzacb extends zzanr implements zzapa {
    private static final zzacb zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;

    static {
        zzacb zzacbVar = new zzacb();
        zzb = zzacbVar;
        zzanr.zzaA(zzacb.class, zzacbVar);
    }

    private zzacb() {
    }

    public static zzaca zza() {
        return (zzaca) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzacb zzacbVar, int i) {
        zzacbVar.zzf |= 1;
        zzacbVar.zzg = i;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzacb();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaca(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzacb.class) {
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
