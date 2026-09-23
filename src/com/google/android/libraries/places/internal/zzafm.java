package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzafm extends zzanr implements zzapa {
    private static final zzafm zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private zzacx zzj;
    private zzafy zzk;
    private zzaej zzl;
    private zzadh zzm;
    private zzaeh zzn;
    private zzadj zzo;
    private zzaef zzp;
    private zzaga zzq;
    private zzaga zzr;
    private zzael zzs;
    private zzadt zzt;
    private zzafo zzu;
    private zzafq zzv;
    private zzafb zzw;
    private zzaer zzx;
    private zzafs zzy;
    private zzafv zzz;
    private byte zzA = 2;
    private String zzh = "";
    private String zzi = "";

    static {
        zzafm zzafmVar = new zzafm();
        zzb = zzafmVar;
        zzanr.zzaA(zzafm.class, zzafmVar);
    }

    private zzafm() {
    }

    public static zzafk zza() {
        return (zzafk) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzafm zzafmVar, String str) {
        str.getClass();
        zzafmVar.zzf |= 2;
        zzafmVar.zzh = str;
    }

    static /* synthetic */ void zze(zzafm zzafmVar, String str) {
        str.getClass();
        zzafmVar.zzf |= 4;
        zzafmVar.zzi = str;
    }

    static /* synthetic */ void zzf(zzafm zzafmVar, zzaeh zzaehVar) {
        zzaehVar.getClass();
        zzafmVar.zzn = zzaehVar;
        zzafmVar.zzf |= 128;
    }

    static /* synthetic */ void zzg(zzafm zzafmVar, zzadj zzadjVar) {
        zzadjVar.getClass();
        zzafmVar.zzo = zzadjVar;
        zzafmVar.zzf |= 256;
    }

    static /* synthetic */ void zzh(zzafm zzafmVar, zzafv zzafvVar) {
        zzafvVar.getClass();
        zzafmVar.zzz = zzafvVar;
        zzafmVar.zzf |= 524288;
    }

    static /* synthetic */ void zzi(zzafm zzafmVar, int i) {
        zzafmVar.zzg = i - 1;
        zzafmVar.zzf |= 1;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzA);
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0014\u0000\u0001\u0001\u0014\u0014\u0000\u0000\u0004\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003\u0005ᐉ\u0004\u0006ᐉ\u0005\u0007ᐉ\u0006\bဉ\u0007\tᐉ\b\nဉ\t\u000bဉ\u000b\fဉ\n\rဉ\f\u000eဉ\r\u000fဉ\u000e\u0010ဉ\u000f\u0011ဉ\u0010\u0012ဉ\u0011\u0013ဉ\u0012\u0014ဉ\u0013", new Object[]{"zzf", "zzg", zzafl.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzr", "zzq", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz"});
        }
        if (i2 == 3) {
            return new zzafm();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzafk(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            this.zzA = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzafm.class) {
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
