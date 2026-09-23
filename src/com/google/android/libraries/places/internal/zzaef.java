package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaef extends zzanr implements zzapa {
    private static final zzanx zzb = new zzaed();
    private static final zzaef zze;
    private static volatile zzapg zzf;
    private zzanw zzg = zzap();

    static {
        zzaef zzaefVar = new zzaef();
        zze = zzaefVar;
        zzanr.zzaA(zzaef.class, zzaefVar);
    }

    private zzaef() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001ࠞ", new Object[]{"zzg", zzabp.zza});
        }
        if (i2 == 3) {
            return new zzaef();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaee(zzabnVar);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zzf;
        if (zzannVar == null) {
            synchronized (zzaef.class) {
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
