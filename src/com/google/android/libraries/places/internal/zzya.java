package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzya extends zzanr implements zzapa {
    private static final zzya zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private float zzh;

    static {
        zzya zzyaVar = new zzya();
        zzb = zzyaVar;
        zzanr.zzaA(zzya.class, zzyaVar);
    }

    private zzya() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ခ\u0001", new Object[]{"zzf", "zzg", zzxy.zza, "zzh"});
        }
        if (i2 == 3) {
            return new zzya();
        }
        zzwz zzwzVar = null;
        if (i2 == 4) {
            return new zzxz(zzwzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzya.class) {
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
