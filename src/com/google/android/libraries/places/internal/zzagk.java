package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagk extends zzanr implements zzapa {
    private static final zzagk zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private zzanz zzh = zzanr.zzas();
    private zzanz zzi = zzas();
    private zzanz zzj = zzas();

    static {
        zzagk zzagkVar = new zzagk();
        zzb = zzagkVar;
        zzanr.zzaA(zzagk.class, zzagkVar);
    }

    private zzagk() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001င\u0000\u0002\u001a\u0003\u001b\u0004\u001b", new Object[]{"zzf", "zzg", "zzh", "zzi", zzagm.class, "zzj", zzabs.class});
        }
        if (i2 == 3) {
            return new zzagk();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzagj(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzagk.class) {
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
