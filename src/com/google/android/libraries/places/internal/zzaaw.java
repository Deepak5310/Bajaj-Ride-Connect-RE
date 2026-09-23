package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaaw extends zzanr implements zzapa {
    private static final zzaaw zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private zzanw zzl = zzap();
    private int zzm;
    private zzaac zzn;
    private zzaas zzo;
    private zzzd zzp;
    private zzaam zzq;
    private zzaai zzr;
    private zzaao zzs;
    private zzzg zzt;
    private zzzl zzu;
    private zzabd zzv;
    private zzabk zzw;
    private zzzu zzx;
    private zzzq zzy;

    static {
        zzaaw zzaawVar = new zzaaw();
        zzb = zzaawVar;
        zzanr.zzaA(zzaaw.class, zzaawVar);
    }

    private zzaaw() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0001\u0000\u0001᠌\u0001\u0002᠌\u0002\u0003င\u0003\u0004ဉ\u0006\u0005ဉ\u0007\u0006ဉ\b\u0007ဉ\t\bဇ\u0004\tဉ\n\nဉ\u000b\u000b\u0016\fင\u0005\rဉ\f\u000eဉ\r\u000fဉ\u000e\u0010ဉ\u000f\u0011င\u0000\u0012ဉ\u0010\u0013ဉ\u0011", new Object[]{"zzf", "zzh", zzaau.zza, "zzi", zzaav.zza, "zzj", "zzn", "zzo", "zzp", "zzq", "zzk", "zzr", "zzs", "zzl", "zzm", "zzt", "zzu", "zzv", "zzw", "zzg", "zzx", "zzy"});
        }
        if (i2 == 3) {
            return new zzaaw();
        }
        zzyy zzyyVar = null;
        if (i2 == 4) {
            return new zzaat(zzyyVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaaw.class) {
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
