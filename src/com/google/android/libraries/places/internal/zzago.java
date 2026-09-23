package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzago extends zzanr implements zzapa {
    private static final zzago zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzago zzagoVar = new zzago();
        zzb = zzagoVar;
        zzanr.zzaA(zzago.class, zzagoVar);
    }

    private zzago() {
    }

    public static zzagn zza() {
        return (zzagn) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzago zzagoVar, int i) {
        zzagoVar.zzf |= 1;
        zzagoVar.zzg = i;
    }

    static /* synthetic */ void zze(zzago zzagoVar, int i) {
        zzagoVar.zzf |= 2;
        zzagoVar.zzh = i;
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
            return new zzago();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzagn(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzago.class) {
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
