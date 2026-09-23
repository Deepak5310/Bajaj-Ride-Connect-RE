package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzww extends zzanr implements zzapa {
    private static final zzww zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private float zzh;

    static {
        zzww zzwwVar = new zzww();
        zzb = zzwwVar;
        zzanr.zzaA(zzww.class, zzwwVar);
    }

    private zzww() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0002\u0000\u0001\u0010\u0011\u0002\u0000\u0000\u0000\u0010᠌\u0000\u0011ခ\u0001", new Object[]{"zzf", "zzg", zzso.zza, "zzh"});
        }
        if (i2 == 3) {
            return new zzww();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzwv(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzww.class) {
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
