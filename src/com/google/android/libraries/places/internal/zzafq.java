package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzafq extends zzanr implements zzapa {
    private static final zzafq zzb;
    private static volatile zzapg zze;
    private zzanz zzf = zzanr.zzas();

    static {
        zzafq zzafqVar = new zzafq();
        zzb = zzafqVar;
        zzanr.zzaA(zzafq.class, zzafqVar);
    }

    private zzafq() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzf"});
        }
        if (i2 == 3) {
            return new zzafq();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzafp(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzafq.class) {
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
