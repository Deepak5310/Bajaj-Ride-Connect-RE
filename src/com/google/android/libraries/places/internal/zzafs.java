package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzafs extends zzanr implements zzapa {
    private static final zzafs zzb;
    private static volatile zzapg zze;
    private zzanz zzf = zzanr.zzas();
    private zzanz zzg = zzas();

    static {
        zzafs zzafsVar = new zzafs();
        zzb = zzafsVar;
        zzanr.zzaA(zzafs.class, zzafsVar);
    }

    private zzafs() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001a\u0002\u001b", new Object[]{"zzf", "zzg", zzabs.class});
        }
        if (i2 == 3) {
            return new zzafs();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzafr(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzafs.class) {
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
