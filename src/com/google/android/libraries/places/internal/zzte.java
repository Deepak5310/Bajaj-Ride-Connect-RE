package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzte extends zzanr implements zzapa {
    private static final zzte zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzanz zzg = zzas();
    private zzco zzh;

    static {
        zzte zzteVar = new zzte();
        zzb = zzteVar;
        zzanr.zzaA(zzte.class, zzteVar);
    }

    private zzte() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzf", "zzg", zztc.class, "zzh"});
        }
        if (i2 == 3) {
            return new zzte();
        }
        zzsp zzspVar = null;
        if (i2 == 4) {
            return new zztd(zzspVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzte.class) {
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
