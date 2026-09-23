package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalk extends zzanr implements zzapa {
    private static final zzalk zzb;
    private static volatile zzapg zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private zzarl zzi;
    private zzarl zzj;
    private double zzk;
    private zzajf zzl;
    private zzaqe zzm;

    static {
        zzalk zzalkVar = new zzalk();
        zzb = zzalkVar;
        zzanr.zzaA(zzalk.class, zzalkVar);
    }

    private zzalk() {
    }

    public final double zza() {
        return this.zzk;
    }

    public final zzajf zzc() {
        zzajf zzajfVar = this.zzl;
        return zzajfVar == null ? zzajf.zzc() : zzajfVar;
    }

    public final zzaqe zze() {
        zzaqe zzaqeVar = this.zzm;
        return zzaqeVar == null ? zzaqe.zzf() : zzaqeVar;
    }

    public final zzarl zzf() {
        zzarl zzarlVar = this.zzj;
        return zzarlVar == null ? zzarl.zzc() : zzarlVar;
    }

    public final zzarl zzg() {
        zzarl zzarlVar = this.zzi;
        return zzarlVar == null ? zzarl.zzc() : zzarlVar;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zzf & 4) != 0;
    }

    public final boolean zzj() {
        return (this.zzf & 2) != 0;
    }

    public final boolean zzk() {
        return (this.zzf & 8) != 0;
    }

    public final boolean zzl() {
        return (this.zzf & 1) != 0;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0007\u0000\u0001\u0001\u000e\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0007\u0000\tဉ\u0000\fဉ\u0001\rဉ\u0002\u000eဉ\u0003", new Object[]{"zzf", "zzg", "zzh", "zzk", "zzi", "zzj", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzalk();
        }
        zzali zzaliVar = null;
        if (i2 == 4) {
            return new zzalj(zzaliVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzalk.class) {
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
