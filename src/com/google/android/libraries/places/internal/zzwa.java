package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzwa extends zzanr implements zzapa {
    private static final zzwa zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzvx zzg;
    private zzvj zzi;
    private zzvj zzj;
    private zzsf zzk;
    private int zzl;
    private zzvl zzm;
    private zzvh zzn;
    private zzve zzo;
    private zzvn zzp;
    private zzvc zzr;
    private zzvp zzs;
    private zzut zzt;
    private zzwu zzu;
    private zzww zzv;
    private zzwi zzw;
    private zzanz zzh = zzas();
    private zzanz zzq = zzas();

    static {
        zzwa zzwaVar = new zzwa();
        zzb = zzwaVar;
        zzanr.zzaA(zzwa.class, zzwaVar);
    }

    private zzwa() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0011\u0000\u0001\u0001\u0011\u0011\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003\u0006᠌\u0004\u0007ဉ\u0005\bဉ\u0006\tဉ\u0007\nဉ\b\u000b\u001b\fဉ\t\rဉ\n\u000eဉ\u000b\u000fဉ\f\u0010ဉ\r\u0011ဉ\u000e", new Object[]{"zzf", "zzg", "zzh", zzwc.class, "zzi", "zzj", "zzk", "zzl", zzvz.zza, "zzm", "zzn", "zzo", "zzp", "zzq", zzvt.class, "zzr", "zzs", "zzt", "zzu", "zzv", "zzw"});
        }
        if (i2 == 3) {
            return new zzwa();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzvy(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzwa.class) {
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
