package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzacs extends zzanr implements zzapa {
    private static final zzacs zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private zzacg zzl;
    private zzabz zzm;
    private zzabu zzn;
    private zzage zzo;
    private zzacb zzp;
    private zzace zzq;
    private zzagg zzr;
    private zzago zzs;
    private zzagk zzt;
    private int zzu;

    static {
        zzacs zzacsVar = new zzacs();
        zzb = zzacsVar;
        zzanr.zzaA(zzacs.class, zzacsVar);
    }

    private zzacs() {
    }

    public static zzacn zza() {
        return (zzacn) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzacs zzacsVar, int i) {
        zzacsVar.zzf |= 4;
        zzacsVar.zzi = i;
    }

    static /* synthetic */ void zze(zzacs zzacsVar, zzacg zzacgVar) {
        zzacgVar.getClass();
        zzacsVar.zzl = zzacgVar;
        zzacsVar.zzf |= 32;
    }

    static /* synthetic */ void zzf(zzacs zzacsVar, zzabu zzabuVar) {
        zzabuVar.getClass();
        zzacsVar.zzn = zzabuVar;
        zzacsVar.zzf |= 128;
    }

    static /* synthetic */ void zzg(zzacs zzacsVar, zzacb zzacbVar) {
        zzacbVar.getClass();
        zzacsVar.zzp = zzacbVar;
        zzacsVar.zzf |= 512;
    }

    static /* synthetic */ void zzh(zzacs zzacsVar, zzago zzagoVar) {
        zzagoVar.getClass();
        zzacsVar.zzs = zzagoVar;
        zzacsVar.zzf |= 4096;
    }

    static /* synthetic */ void zzi(zzacs zzacsVar, int i) {
        zzacsVar.zzg = i - 1;
        zzacsVar.zzf |= 1;
    }

    static /* synthetic */ void zzj(zzacs zzacsVar, int i) {
        zzacsVar.zzh = i - 1;
        zzacsVar.zzf |= 2;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000eဉ\r\u000f᠌\u000e", new Object[]{"zzf", "zzg", zzacp.zza, "zzh", zzacr.zza, "zzi", "zzj", zzaco.zza, "zzk", zzacm.zza, "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", zzacq.zza});
        }
        if (i2 == 3) {
            return new zzacs();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzacn(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzacs.class) {
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
