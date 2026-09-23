package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzwp extends zzanr implements zzapa {
    private static final zzwp zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private zzanz zzh = zzas();

    static {
        zzwp zzwpVar = new zzwp();
        zzb = zzwpVar;
        zzanr.zzaA(zzwp.class, zzwpVar);
    }

    private zzwp() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzf", "zzg", zzwo.zza, "zzh", zzwm.class});
        }
        if (i2 == 3) {
            return new zzwp();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzwn(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzwp.class) {
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
