package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaer extends zzanr implements zzapa {
    private static final zzanx zzb = new zzaep();
    private static final zzaer zze;
    private static volatile zzapg zzf;
    private zzanw zzg = zzap();

    static {
        zzaer zzaerVar = new zzaer();
        zze = zzaerVar;
        zzanr.zzaA(zzaer.class, zzaerVar);
    }

    private zzaer() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001ࠞ", new Object[]{"zzg", zzags.zza});
        }
        if (i2 == 3) {
            return new zzaer();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaeq(zzabnVar);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zzf;
        if (zzannVar == null) {
            synchronized (zzaer.class) {
                zzannVar = zzf;
                if (zzannVar == null) {
                    zzannVar = new zzann(zze);
                    zzf = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
