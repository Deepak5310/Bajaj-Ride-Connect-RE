package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzado extends zzanr implements zzapa {
    private static final zzado zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh = 1;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private boolean zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    static {
        zzado zzadoVar = new zzado();
        zzb = zzadoVar;
        zzanr.zzaA(zzado.class, zzadoVar);
    }

    private zzado() {
    }

    public static zzadl zza() {
        return (zzadl) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzado zzadoVar, boolean z) {
        zzadoVar.zzf |= 4;
        zzadoVar.zzi = z;
    }

    static /* synthetic */ void zze(zzado zzadoVar, boolean z) {
        zzadoVar.zzf |= 8;
        zzadoVar.zzj = z;
    }

    static /* synthetic */ void zzf(zzado zzadoVar, boolean z) {
        zzadoVar.zzf |= 16;
        zzadoVar.zzk = z;
    }

    static /* synthetic */ void zzg(zzado zzadoVar, int i) {
        zzadoVar.zzf |= 32;
        zzadoVar.zzl = i;
    }

    static /* synthetic */ void zzh(zzado zzadoVar, int i) {
        zzadoVar.zzf |= 64;
        zzadoVar.zzm = i;
    }

    static /* synthetic */ void zzi(zzado zzadoVar, int i) {
        zzadoVar.zzf |= 128;
        zzadoVar.zzn = i;
    }

    static /* synthetic */ void zzj(zzado zzadoVar, int i) {
        zzadoVar.zzf |= 256;
        zzadoVar.zzo = i;
    }

    static /* synthetic */ void zzk(zzado zzadoVar, int i) {
        zzadoVar.zzf |= 512;
        zzadoVar.zzp = i;
    }

    static /* synthetic */ void zzl(zzado zzadoVar, int i) {
        zzadoVar.zzf |= 1024;
        zzadoVar.zzq = i;
    }

    static /* synthetic */ void zzm(zzado zzadoVar, int i) {
        zzadoVar.zzf |= 2048;
        zzadoVar.zzr = i;
    }

    static /* synthetic */ void zzn(zzado zzadoVar, boolean z) {
        zzadoVar.zzf |= 4096;
        zzadoVar.zzs = z;
    }

    static /* synthetic */ void zzo(zzado zzadoVar, int i) {
        zzadoVar.zzf |= 8192;
        zzadoVar.zzt = i;
    }

    static /* synthetic */ void zzp(zzado zzadoVar, int i) {
        zzadoVar.zzg = i - 1;
        zzadoVar.zzf |= 1;
    }

    static /* synthetic */ void zzq(zzado zzadoVar, int i) {
        zzadoVar.zzh = i;
        zzadoVar.zzf |= 2;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0010\u0000\u0001\u0001\u0011\u0010\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဋ\u0005\u0007ဋ\u0006\bဋ\u0007\nဋ\t\u000bဋ\n\fဋ\u000b\rဇ\f\u000eဋ\r\u000fဋ\b\u0010ဋ\u000e\u0011᠌\u000f", new Object[]{"zzf", "zzg", zzadn.zza, "zzh", zzadk.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzp", "zzq", "zzr", "zzs", "zzt", "zzo", "zzu", "zzv", zzadm.zza});
        }
        if (i2 == 3) {
            return new zzado();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzadl(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzado.class) {
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
