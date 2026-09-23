package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzafe extends zzanr implements zzapa {
    private static final zzafe zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;

    static {
        zzafe zzafeVar = new zzafe();
        zzb = zzafeVar;
        zzanr.zzaA(zzafe.class, zzafeVar);
    }

    private zzafe() {
    }

    public static zzafc zza() {
        return (zzafc) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzafe zzafeVar, int i) {
        zzafeVar.zzg = 1;
        zzafeVar.zzf = 1 | zzafeVar.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003ဇ\u0002", new Object[]{"zzf", "zzg", zzafd.zza, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzafe();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzafc(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzafe.class) {
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
