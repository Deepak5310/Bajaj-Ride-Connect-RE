package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzae extends zzanr implements zzapa {
    private static final zzae zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzco zzg;
    private boolean zzh;
    private zzanz zzi = zzas();
    private zzanz zzj = zzas();
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private long zzo;

    static {
        zzae zzaeVar = new zzae();
        zzb = zzaeVar;
        zzanr.zzaA(zzae.class, zzaeVar);
    }

    private zzae() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005င\u0002\u0006င\u0003\u0007င\u0004\bင\u0005\tဂ\u0006", new Object[]{"zzf", "zzg", "zzh", "zzi", zzar.class, "zzj", zzar.class, "zzk", "zzl", "zzm", "zzn", "zzo"});
        }
        if (i2 == 3) {
            return new zzae();
        }
        zzac zzacVar = null;
        if (i2 == 4) {
            return new zzad(zzacVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzae.class) {
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
