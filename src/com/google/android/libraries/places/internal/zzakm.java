package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzakm extends zzanr implements zzapa {
    private static final zzakm zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private zzarf zzj;
    private boolean zzk;

    static {
        zzakm zzakmVar = new zzakm();
        zzb = zzakmVar;
        zzanr.zzaA(zzakm.class, zzakmVar);
    }

    private zzakm() {
    }

    public static zzakm zzf() {
        return zzb;
    }

    public final int zza() {
        return this.zzg;
    }

    public final int zzc() {
        return this.zzh;
    }

    public final int zzd() {
        return this.zzi;
    }

    public final zzarf zzg() {
        zzarf zzarfVar = this.zzj;
        return zzarfVar == null ? zzarf.zzf() : zzarfVar;
    }

    public final boolean zzh() {
        return this.zzk;
    }

    public final boolean zzi() {
        return (this.zzf & 8) != 0;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0005\u0007\u0006ဉ\u0003", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzk", "zzj"});
        }
        if (i2 == 3) {
            return new zzakm();
        }
        zzajz zzajzVar = null;
        if (i2 == 4) {
            return new zzakl(zzajzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzakm.class) {
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
