package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zztc extends zzanr implements zzapa {
    private static final zztc zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private float zzj;
    private int zzk;
    private String zzg = "";
    private String zzl = "";

    static {
        zztc zztcVar = new zztc();
        zzb = zztcVar;
        zzanr.zzaA(zztc.class, zztcVar);
    }

    private zztc() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0002\u0004ခ\u0003\u0005င\u0004\u0006ဈ\u0005", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zztc();
        }
        zzsp zzspVar = null;
        if (i2 == 4) {
            return new zztb(zzspVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zztc.class) {
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
