package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzvh extends zzanr implements zzapa {
    private static final zzvh zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private long zzh;
    private zzuv zzi;
    private long zzj;
    private int zzk;
    private zzanw zzl = zzap();
    private zzanw zzm = zzap();
    private int zzn;

    static {
        zzvh zzvhVar = new zzvh();
        zzb = zzvhVar;
        zzanr.zzaA(zzvh.class, zzvhVar);
    }

    private zzvh() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001᠌\u0000\u0002စ\u0001\u0003ဉ\u0002\u0004ဂ\u0003\u0005င\u0004\u0006\u0016\u0007\u0016\bင\u0005", new Object[]{"zzf", "zzg", zzvg.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zzvh();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzvf(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzvh.class) {
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
