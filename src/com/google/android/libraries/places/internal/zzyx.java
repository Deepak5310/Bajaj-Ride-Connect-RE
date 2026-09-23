package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzyx extends zzanr implements zzapa {
    private static final zzyx zzb;
    private static volatile zzapg zze;
    private int zzf = 0;
    private Object zzg;

    static {
        zzyx zzyxVar = new zzyx();
        zzb = zzyxVar;
        zzanr.zzaA(zzyx.class, zzyxVar);
    }

    private zzyx() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001<\u0000", new Object[]{"zzg", "zzf", zzts.class});
        }
        if (i2 == 3) {
            return new zzyx();
        }
        zzyv zzyvVar = null;
        if (i2 == 4) {
            return new zzyw(zzyvVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzyx.class) {
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
