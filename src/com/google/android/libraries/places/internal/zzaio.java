package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaio extends zzanr implements zzapa {
    private static final zzaio zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg = 1;
    private int zzh = 1;
    private int zzi;

    static {
        zzaio zzaioVar = new zzaio();
        zzb = zzaioVar;
        zzanr.zzaA(zzaio.class, zzaioVar);
    }

    private zzaio() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002", new Object[]{"zzf", "zzg", zzain.zza, "zzh", zzaim.zza, "zzi"});
        }
        if (i2 == 3) {
            return new zzaio();
        }
        zzaik zzaikVar = null;
        if (i2 == 4) {
            return new zzail(zzaikVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaio.class) {
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
