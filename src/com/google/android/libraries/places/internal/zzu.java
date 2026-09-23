package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzu extends zzanr implements zzapa {
    private static final zzu zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzcd zzg;
    private int zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private float zzo;
    private long zzp;
    private int zzq;
    private boolean zzr;
    private int zzs;
    private zzanz zzt = zzas();
    private zzanz zzu = zzas();
    private int zzv;
    private int zzw;
    private long zzx;

    static {
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzanr.zzaA(zzu.class, zzuVar);
    }

    private zzu() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0012\u0000\u0001\u0001\u0012\u0012\u0000\u0002\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဂ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tခ\b\nဂ\t\u000bင\n\fဇ\u000b\r᠌\f\u000e\u001b\u000f\u001b\u0010င\r\u0011င\u000e\u0012ဂ\u000f", new Object[]{"zzf", "zzg", "zzh", zzt.zza, "zzi", "zzj", zzas.zza, "zzk", zzm.zza, "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", zzab.zza, "zzt", zzar.class, "zzu", zzar.class, "zzv", "zzw", "zzx"});
        }
        if (i2 == 3) {
            return new zzu();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzs(zzaVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzu.class) {
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
