package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqe extends zzanr implements zzapa {
    private static final zzaqe zzb;
    private static volatile zzapg zze;
    private long zzf;
    private int zzg;

    static {
        zzaqe zzaqeVar = new zzaqe();
        zzb = zzaqeVar;
        zzanr.zzaA(zzaqe.class, zzaqeVar);
    }

    private zzaqe() {
    }

    public static zzaqd zzd() {
        return (zzaqd) zzb.zzam();
    }

    public static zzaqe zzf() {
        return zzb;
    }

    public final int zza() {
        return this.zzg;
    }

    public final long zzc() {
        return this.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzapk(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzaqe();
        }
        zzaqc zzaqcVar = null;
        if (i2 == 4) {
            return new zzaqd(zzaqcVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaqe.class) {
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
