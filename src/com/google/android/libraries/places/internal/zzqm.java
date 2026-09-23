package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzqm extends zzanr implements zzapa {
    private static final zzqm zzb;
    private static volatile zzapg zze;
    private zzbf zzA;
    private zzae zzB;
    private zzcg zzC;
    private zzbl zzD;
    private int zzf;
    private zzaea zzh;
    private zzss zzi;
    private zzagy zzj;
    private zzaaw zzk;
    private zzwa zzl;
    private zzbw zzm;
    private zzsm zzn;
    private zzrs zzo;
    private zztn zzp;
    private zzyc zzq;
    private zzyu zzr;
    private zzyx zzs;
    private zzra zzt;
    private zzuh zzu;
    private zzc zzv;
    private zzan zzw;
    private zzav zzx;
    private zzcy zzy;
    private zzay zzz;
    private byte zzE = 2;
    private int zzg = 1;

    static {
        zzqm zzqmVar = new zzqm();
        zzb = zzqmVar;
        zzanr.zzaA(zzqm.class, zzqmVar);
    }

    private zzqm() {
    }

    public static zzqk zza() {
        return (zzqk) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzqm zzqmVar, zzaea zzaeaVar) {
        zzaeaVar.getClass();
        zzqmVar.zzh = zzaeaVar;
        zzqmVar.zzf |= 2;
    }

    static /* synthetic */ void zze(zzqm zzqmVar, int i) {
        zzqmVar.zzg = 1;
        zzqmVar.zzf = 1 | zzqmVar.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzE);
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0018\u0000\u0001\u0001\u0019\u0018\u0000\u0000\u0002\u0001᠌\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000fဉ\r\u0010ဉ\u000e\u0011ဉ\u000f\u0012ဉ\u0010\u0013ဉ\u0011\u0014ဉ\u0012\u0015ဉ\u0013\u0016ဉ\u0014\u0017ဉ\u0015\u0018ဉ\u0016\u0019ဉ\u0017", new Object[]{"zzf", "zzg", zzql.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD"});
        }
        if (i2 == 3) {
            return new zzqm();
        }
        zzqj zzqjVar = null;
        if (i2 == 4) {
            return new zzqk(zzqjVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            this.zzE = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzqm.class) {
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
