package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzyc extends zzanr implements zzapa {
    private static final zzyc zzb;
    private static volatile zzapg zze;
    private int zzf;
    private long zzg;
    private zzxp zzh;
    private zzxp zzi;
    private zzyl zzj;
    private zzxx zzk;
    private zzxf zzl;
    private zzyo zzm;
    private zzyq zzn;
    private zzye zzo;
    private zzxb zzp;
    private zzxh zzq;
    private zzya zzr;
    private zzyg zzs;
    private zzyi zzt;

    static {
        zzyc zzycVar = new zzyc();
        zzb = zzycVar;
        zzanr.zzaA(zzyc.class, zzycVar);
    }

    private zzyc() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000eဉ\r", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        }
        if (i2 == 3) {
            return new zzyc();
        }
        zzwz zzwzVar = null;
        if (i2 == 4) {
            return new zzyb(zzwzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzyc.class) {
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
