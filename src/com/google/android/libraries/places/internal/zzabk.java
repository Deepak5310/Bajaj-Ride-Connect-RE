package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabk extends zzanr implements zzapa {
    private static final zzabk zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private zzabh zzh;
    private zzabh zzi;
    private int zzj;
    private zzabm zzk;
    private zzaae zzl;

    static {
        zzabk zzabkVar = new zzabk();
        zzb = zzabkVar;
        zzanr.zzaA(zzabk.class, zzabkVar);
    }

    private zzabk() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004᠌\u0003\u0005ဉ\u0004\u0006ဉ\u0005", new Object[]{"zzf", "zzg", zzabi.zza, "zzh", "zzi", "zzj", zzabj.zza, "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzabk();
        }
        zzyy zzyyVar = null;
        if (i2 == 4) {
            return new zzabe(zzyyVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzabk.class) {
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
