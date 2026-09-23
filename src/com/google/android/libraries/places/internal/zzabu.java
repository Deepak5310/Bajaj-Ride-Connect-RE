package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabu extends zzanr implements zzapa {
    private static final zzabu zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;

    static {
        zzabu zzabuVar = new zzabu();
        zzb = zzabuVar;
        zzanr.zzaA(zzabu.class, zzabuVar);
    }

    private zzabu() {
    }

    public static zzabt zza() {
        return (zzabt) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzabu zzabuVar, int i) {
        zzabuVar.zzf |= 1;
        zzabuVar.zzg = i;
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
            return new zzabu();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzabt(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzabu.class) {
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
