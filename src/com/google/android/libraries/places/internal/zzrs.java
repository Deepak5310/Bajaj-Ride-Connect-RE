package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrs extends zzanr implements zzapa {
    private static final zzrs zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private zzru zzh;
    private zzsc zzi;
    private zzrx zzj;
    private zzsa zzk;

    static {
        zzrs zzrsVar = new zzrs();
        zzb = zzrsVar;
        zzanr.zzaA(zzrs.class, zzrsVar);
    }

    private zzrs() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"zzf", "zzg", zzrr.zza, "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzrs();
        }
        zzrn zzrnVar = null;
        if (i2 == 4) {
            return new zzrq(zzrnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzrs.class) {
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
