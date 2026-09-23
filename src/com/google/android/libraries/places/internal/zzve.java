package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzve extends zzanr implements zzapa {
    private static final zzve zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private long zzi;
    private int zzj;
    private boolean zzk;
    private long zzl;
    private zzqt zzm;
    private zzanz zzn = zzas();

    static {
        zzve zzveVar = new zzve();
        zzb = zzveVar;
        zzanr.zzaA(zzve.class, zzveVar);
    }

    private zzve() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003ဂ\u0002\u0004င\u0003\u0005ဇ\u0004\u0006ဂ\u0005\u0007ဉ\u0006\b\u001b", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", zzqt.class});
        }
        if (i2 == 3) {
            return new zzve();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzvd(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzve.class) {
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
