package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzav extends zzanr implements zzapa {
    private static final zzav zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzco zzg;
    private zzai zzh;

    static {
        zzav zzavVar = new zzav();
        zzb = zzavVar;
        zzanr.zzaA(zzav.class, zzavVar);
    }

    private zzav() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0001\u0002ဉ\u0000", new Object[]{"zzf", "zzh", "zzg"});
        }
        if (i2 == 3) {
            return new zzav();
        }
        zzat zzatVar = null;
        if (i2 == 4) {
            return new zzau(zzatVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzav.class) {
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
