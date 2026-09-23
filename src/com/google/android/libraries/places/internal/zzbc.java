package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbc extends zzanr implements zzapa {
    private static final zzanx zzb = new zzaz();
    private static final zzbc zze;
    private static volatile zzapg zzf;
    private int zzg;
    private int zzh;
    private long zzi;
    private long zzj;
    private int zzk;
    private int zzl;
    private zzanw zzm = zzap();
    private int zzn;

    static {
        zzbc zzbcVar = new zzbc();
        zze = zzbcVar;
        zzanr.zzaA(zzbc.class, zzbcVar);
    }

    private zzbc() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzanv zzanvVar = zzas.zza;
            zzanv zzanvVar2 = zzbb.zza;
            return zzax(zze, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004င\u0003\u0005င\u0004\u0006ࠞ\u0007᠌\u0005", new Object[]{"zzg", "zzh", zzanvVar, "zzi", "zzj", "zzk", "zzl", "zzm", zzanvVar2, "zzn", zzanvVar2});
        }
        if (i2 == 3) {
            return new zzbc();
        }
        zzaw zzawVar = null;
        if (i2 == 4) {
            return new zzba(zzawVar);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zzf;
        if (zzannVar == null) {
            synchronized (zzbc.class) {
                zzannVar = zzf;
                if (zzannVar == null) {
                    zzannVar = new zzann(zze);
                    zzf = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
