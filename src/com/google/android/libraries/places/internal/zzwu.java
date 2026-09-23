package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzwu extends zzanr implements zzapa {
    private static final zzwu zzb;
    private static volatile zzapg zze;
    private int zzA;
    private float zzB;
    private boolean zzC;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private int zzs;
    private float zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private zzanz zzz = zzas();

    static {
        zzwu zzwuVar = new zzwu();
        zzb = zzwuVar;
        zzanr.zzaA(zzwu.class, zzwuVar);
    }

    private zzwu() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzanv zzanvVar = zzwt.zza;
            zzanv zzanvVar2 = zzsn.zza;
            zzanv zzanvVar3 = zzsn.zza;
            return zzax(zzb, "\u0001\u0017\u0000\u0001\u0001\u0017\u0017\u0000\u0001\u0000\u0001င\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b\nင\t\u000bင\n\fဇ\u000b\r᠌\f\u000eခ\r\u000f᠌\u000e\u0010᠌\u000f\u0011᠌\u0010\u0012᠌\u0011\u0013᠌\u0012\u0014\u001b\u0015င\u0013\u0016ခ\u0014\u0017ဇ\u0015", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", zzanvVar, "zzt", "zzu", zzanvVar2, "zzv", zzanvVar3, "zzw", zzanvVar3, "zzx", zzanvVar3, "zzy", zzso.zza, "zzz", zzwk.class, "zzA", "zzB", "zzC"});
        }
        if (i2 == 3) {
            return new zzwu();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzws(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzwu.class) {
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
