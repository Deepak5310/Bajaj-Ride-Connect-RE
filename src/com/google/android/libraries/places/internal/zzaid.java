package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaid extends zzanr implements zzapa {
    private static final zzaid zzb;
    private static volatile zzapg zze;
    private zzanz zzf = zzas();

    static {
        zzaid zzaidVar = new zzaid();
        zzb = zzaidVar;
        zzanr.zzaA(zzaid.class, zzaidVar);
    }

    private zzaid() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzf", zzaio.class});
        }
        if (i2 == 3) {
            return new zzaid();
        }
        zzaib zzaibVar = null;
        if (i2 == 4) {
            return new zzaic(zzaibVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaid.class) {
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
