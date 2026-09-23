package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzts extends zzanr implements zzapa {
    private static final zzts zzb;
    private static volatile zzapg zze;
    private int zzf = 0;
    private Object zzg;

    static {
        zzts zztsVar = new zzts();
        zzb = zztsVar;
        zzanr.zzaA(zzts.class, zztsVar);
    }

    private zzts() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zzg", "zzf", zztw.class, zztq.class, zztu.class});
        }
        if (i2 == 3) {
            return new zzts();
        }
        zzto zztoVar = null;
        if (i2 == 4) {
            return new zztr(zztoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzts.class) {
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
