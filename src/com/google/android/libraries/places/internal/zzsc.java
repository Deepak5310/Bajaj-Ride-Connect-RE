package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzsc extends zzanr implements zzapa {
    private static final zzsc zzb;
    private static volatile zzapg zze;
    private int zzf;
    private long zzg;

    static {
        zzsc zzscVar = new zzsc();
        zzb = zzscVar;
        zzanr.zzaA(zzsc.class, zzscVar);
    }

    private zzsc() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဂ\u0000", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzsc();
        }
        zzrn zzrnVar = null;
        if (i2 == 4) {
            return new zzsb(zzrnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzsc.class) {
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
