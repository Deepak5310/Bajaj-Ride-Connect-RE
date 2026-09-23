package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzss extends zzanr implements zzapa {
    private static final zzss zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzsu zzh;
    private zzsw zzi;
    private zzaiw zzj;
    private zzsy zzk;
    private zzte zzl;
    private zzta zzm;
    private byte zzn = 2;
    private int zzg = 1;

    static {
        zzss zzssVar = new zzss();
        zzb = zzssVar;
        zzanr.zzaA(zzss.class, zzssVar);
    }

    private zzss() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ᐉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zzf", "zzg", zzsr.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzss();
        }
        zzsp zzspVar = null;
        if (i2 == 4) {
            return new zzsq(zzspVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            this.zzn = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzss.class) {
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
