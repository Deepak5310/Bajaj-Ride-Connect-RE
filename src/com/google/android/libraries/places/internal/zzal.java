package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzal extends zzanr implements zzapa {
    private static final zzal zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private float zzk;
    private boolean zzl;
    private zzanz zzm = zzanr.zzas();
    private zzanz zzn = zzas();
    private zzanz zzo = zzas();
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private long zzv;

    static {
        zzal zzalVar = new zzal();
        zzb = zzalVar;
        zzanr.zzaA(zzal.class, zzalVar);
    }

    private zzal() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0003\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006ဇ\u0005\u0007\u001a\b\u001b\t\u001b\nင\u0006\u000bဂ\f\fင\u000b\rင\u0007\u000eင\b\u000fင\t\u0010င\n", new Object[]{"zzf", "zzg", zzas.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", zzar.class, "zzo", zzar.class, "zzp", "zzv", "zzu", "zzq", "zzr", "zzs", "zzt"});
        }
        if (i2 == 3) {
            return new zzal();
        }
        zzaj zzajVar = null;
        if (i2 == 4) {
            return new zzak(zzajVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzal.class) {
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
