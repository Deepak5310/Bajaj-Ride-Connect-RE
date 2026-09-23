package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzakn extends zzanr implements zzapa {
    private static final zzakn zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzakm zzg;
    private zzakm zzh;

    static {
        zzakn zzaknVar = new zzakn();
        zzb = zzaknVar;
        zzanr.zzaA(zzakn.class, zzaknVar);
    }

    private zzakn() {
    }

    public final zzakm zza() {
        zzakm zzakmVar = this.zzh;
        return zzakmVar == null ? zzakm.zzf() : zzakmVar;
    }

    public final zzakm zzc() {
        zzakm zzakmVar = this.zzg;
        return zzakmVar == null ? zzakm.zzf() : zzakmVar;
    }

    public final boolean zze() {
        return (this.zzf & 2) != 0;
    }

    public final boolean zzf() {
        return (this.zzf & 1) != 0;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzakn();
        }
        zzajz zzajzVar = null;
        if (i2 == 4) {
            return new zzakk(zzajzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzakn.class) {
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
