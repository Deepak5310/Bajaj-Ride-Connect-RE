package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaeo extends zzanr implements zzapa {
    private static final zzaeo zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzacx zzg;
    private int zzh;
    private int zzi;
    private zzafg zzj;

    static {
        zzaeo zzaeoVar = new zzaeo();
        zzb = zzaeoVar;
        zzanr.zzaA(zzaeo.class, zzaeoVar);
    }

    private zzaeo() {
    }

    public static zzaem zza() {
        return (zzaem) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzaeo zzaeoVar, int i) {
        zzaeoVar.zzf |= 4;
        zzaeoVar.zzi = i;
    }

    static /* synthetic */ void zze(zzaeo zzaeoVar, zzafg zzafgVar) {
        zzafgVar.getClass();
        zzaeoVar.zzj = zzafgVar;
        zzaeoVar.zzf |= 8;
    }

    static /* synthetic */ void zzf(zzaeo zzaeoVar, int i) {
        zzaeoVar.zzh = i - 1;
        zzaeoVar.zzf |= 2;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003င\u0002\u0004ဉ\u0003", new Object[]{"zzf", "zzg", "zzh", zzaen.zza, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzaeo();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaem(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaeo.class) {
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
