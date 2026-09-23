package com.google.android.libraries.places.internal;

import com.adobe.internal.xmp.options.PropertyOptions;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaea extends zzanr implements zzapa {
    private static final zzaea zzb;
    private static volatile zzapg zze;
    private zzadf zzA;
    private zzaci zzB;
    private zzagr zzC;
    private boolean zzD;
    private zzacs zzF;
    private boolean zzG;
    private int zzI;
    private int zzL;
    private int zzN;
    private int zzf;
    private int zzg;
    private zzqt zzi;
    private zztz zzj;
    private int zzk;
    private float zzl;
    private zzafm zzn;
    private zzacv zzp;
    private zzadc zzq;
    private zzafe zzr;
    private zzaeo zzs;
    private zzaex zzt;
    private zzaet zzu;
    private zzafj zzv;
    private zzado zzw;
    private zzaec zzx;
    private zzaez zzy;
    private zzadr zzz;
    private byte zzO = 2;
    private int zzh = 1;
    private zzanz zzm = zzas();
    private zzanz zzo = zzas();
    private String zzE = "";
    private String zzH = "";
    private String zzJ = "";
    private String zzK = "";
    private String zzM = "";

    static {
        zzaea zzaeaVar = new zzaea();
        zzb = zzaeaVar;
        zzanr.zzaA(zzaea.class, zzaeaVar);
    }

    private zzaea() {
    }

    public static zzadu zza() {
        return (zzadu) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzaea zzaeaVar, zzafm zzafmVar) {
        zzafmVar.getClass();
        zzaeaVar.zzn = zzafmVar;
        zzaeaVar.zzf |= 64;
    }

    static /* synthetic */ void zze(zzaea zzaeaVar, zzafe zzafeVar) {
        zzafeVar.getClass();
        zzaeaVar.zzr = zzafeVar;
        zzaeaVar.zzf |= 512;
    }

    static /* synthetic */ void zzf(zzaea zzaeaVar, zzaeo zzaeoVar) {
        zzaeoVar.getClass();
        zzaeaVar.zzs = zzaeoVar;
        zzaeaVar.zzf |= 1024;
    }

    static /* synthetic */ void zzg(zzaea zzaeaVar, zzqt zzqtVar) {
        zzqtVar.getClass();
        zzaeaVar.zzi = zzqtVar;
        zzaeaVar.zzf |= 4;
    }

    static /* synthetic */ void zzh(zzaea zzaeaVar, zzado zzadoVar) {
        zzadoVar.getClass();
        zzaeaVar.zzw = zzadoVar;
        zzaeaVar.zzf |= 16384;
    }

    static /* synthetic */ void zzi(zzaea zzaeaVar, zzacs zzacsVar) {
        zzacsVar.getClass();
        zzaeaVar.zzF = zzacsVar;
        zzaeaVar.zzf |= 8388608;
    }

    static /* synthetic */ void zzj(zzaea zzaeaVar, boolean z) {
        zzaeaVar.zzf |= 16777216;
        zzaeaVar.zzG = z;
    }

    static /* synthetic */ void zzk(zzaea zzaeaVar, String str) {
        str.getClass();
        zzaeaVar.zzf |= 33554432;
        zzaeaVar.zzH = str;
    }

    static /* synthetic */ void zzl(zzaea zzaeaVar, String str) {
        zzaeaVar.zzf |= 134217728;
        zzaeaVar.zzJ = "3.3.0";
    }

    static /* synthetic */ void zzm(zzaea zzaeaVar, String str) {
        str.getClass();
        zzaeaVar.zzf |= 1073741824;
        zzaeaVar.zzM = str;
    }

    static /* synthetic */ void zzn(zzaea zzaeaVar, int i) {
        zzaeaVar.zzh = i;
        zzaeaVar.zzf |= 2;
    }

    static /* synthetic */ void zzo(zzaea zzaeaVar, int i) {
        zzaeaVar.zzL = i - 1;
        zzaeaVar.zzf |= PropertyOptions.DELETE_EXISTING;
    }

    static /* synthetic */ void zzp(zzaea zzaeaVar, int i) {
        zzaeaVar.zzN = i - 1;
        zzaeaVar.zzf |= Integer.MIN_VALUE;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzO);
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\"\u0000\u0001\u0001\"\"\u0000\u0002\u0003\u0001᠌\u0001\u0002ဉ\u0002\u0003ᐉ\u0003\u0004\u001b\u0005ᐉ\u0006\u0006\u001b\u0007ဉ\u0007\bᐉ\b\t᠌\u0004\nခ\u0005\u000bဇ\u0015\fဉ\t\rဈ\u0016\u000eဉ\n\u000fဉ\u000b\u0010ဉ\f\u0011ဉ\r\u0012ဉ\u000e\u0013ဉ\u000f\u0014ဉ\u0010\u0015ဉ\u0011\u0016ဉ\u0012\u0017ဉ\u0013\u0018ဉ\u0017\u0019င\u0000\u001aဉ\u0014\u001bဇ\u0018\u001cဈ\u0019\u001d᠌\u001a\u001eဈ\u001b\u001fဈ\u001c ᠌\u001d!ဈ\u001e\"᠌\u001f", new Object[]{"zzf", "zzh", zzadw.zza, "zzi", "zzj", "zzm", zzagv.class, "zzn", "zzo", zzacv.class, "zzp", "zzq", "zzk", zzadv.zza, "zzl", "zzD", "zzr", "zzE", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzF", "zzg", "zzC", "zzG", "zzH", "zzI", zzadx.zza, "zzJ", "zzK", "zzL", zzadz.zza, "zzM", "zzN", zzady.zza});
        }
        if (i2 == 3) {
            return new zzaea();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzadu(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            this.zzO = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaea.class) {
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
