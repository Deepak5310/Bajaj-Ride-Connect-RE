package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzar extends zzanr implements zzapa {
    private static final zzar zzb;
    private static volatile zzapg zze;
    private boolean zzA;
    private boolean zzB;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;
    private int zzj;
    private float zzk;
    private float zzl;
    private boolean zzm;
    private float zzn;
    private double zzo;
    private int zzp;
    private long zzq;
    private float zzr;
    private float zzs;
    private float zzt;
    private float zzu;
    private float zzv;
    private float zzw;
    private float zzx;
    private float zzy;
    private boolean zzz;

    static {
        zzar zzarVar = new zzar();
        zzb = zzarVar;
        zzanr.zzaA(zzar.class, zzarVar);
    }

    private zzar() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzanv zzanvVar = zzaq.zza;
            return zzax(zzb, "\u0001\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004᠌\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ဇ\u0006\bခ\u0007\tက\b\n᠌\t\u000bဂ\n\fခ\u000b\rခ\f\u000eခ\r\u000fခ\u000e\u0010ခ\u000f\u0011ခ\u0010\u0012ခ\u0011\u0013ခ\u0012\u0014ဇ\u0013\u0015ဇ\u0014\u0016ဇ\u0015", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", zzanvVar, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzanvVar, "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB"});
        }
        if (i2 == 3) {
            return new zzar();
        }
        zzao zzaoVar = null;
        if (i2 == 4) {
            return new zzap(zzaoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzar.class) {
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
