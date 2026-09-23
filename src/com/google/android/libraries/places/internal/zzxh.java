package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxh extends zzanr implements zzapa {
    private static final zzxh zzb;
    private static volatile zzapg zze;
    private int zzf;
    private String zzg = "";
    private int zzh;
    private int zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private long zzm;
    private boolean zzn;

    static {
        zzxh zzxhVar = new zzxh();
        zzb = zzxhVar;
        zzanr.zzaA(zzxh.class, zzxhVar);
    }

    private zzxh() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003င\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ဂ\u0006\bဇ\u0007", new Object[]{"zzf", "zzg", "zzh", zzxy.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zzxh();
        }
        zzwz zzwzVar = null;
        if (i2 == 4) {
            return new zzxg(zzwzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzxh.class) {
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
