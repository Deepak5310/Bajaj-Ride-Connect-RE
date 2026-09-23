package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzva extends zzanr implements zzapa {
    private static final zzva zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzany zzg = zzar();
    private zzany zzh = zzar();
    private zzany zzi = zzar();
    private zzany zzj = zzar();
    private zzany zzk = zzar();
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;

    static {
        zzva zzvaVar = new zzva();
        zzb = zzvaVar;
        zzanr.zzaA(zzva.class, zzvaVar);
    }

    private zzva() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0005\u0000\u0001\u0014\u0002\u0014\u0003\u0014\u0004\u0014\u0005\u0014\u0006င\u0000\u0007᠌\u0001\b᠌\u0002\t᠌\u0003\nင\u0004", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzuz.zza, "zzn", zzuy.zza, "zzo", zzuw.zza, "zzp"});
        }
        if (i2 == 3) {
            return new zzva();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzux(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzva.class) {
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
