package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxv extends zzanr implements zzapa {
    private static final zzanx zzb = new zzxq();
    private static final zzanx zze = new zzxr();
    private static final zzxv zzf;
    private static volatile zzapg zzg;
    private int zzh;
    private long zzj;
    private zzanz zzi = zzas();
    private zzanw zzk = zzap();
    private zzanw zzl = zzap();

    static {
        zzxv zzxvVar = new zzxv();
        zzf = zzxvVar;
        zzanr.zzaA(zzxv.class, zzxvVar);
    }

    private zzxv() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001\u001b\u0002ဂ\u0000\u0003ࠬ\u0004ࠬ", new Object[]{"zzh", "zzi", zzxu.class, "zzj", "zzk", zzso.zza, "zzl", zzso.zza});
        }
        if (i2 == 3) {
            return new zzxv();
        }
        zzwz zzwzVar = null;
        if (i2 == 4) {
            return new zzxs(zzwzVar);
        }
        if (i2 == 5) {
            return zzf;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zzg;
        if (zzannVar == null) {
            synchronized (zzxv.class) {
                zzannVar = zzg;
                if (zzannVar == null) {
                    zzannVar = new zzann(zzf);
                    zzg = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
