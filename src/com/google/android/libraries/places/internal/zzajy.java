package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzajy extends zzanr implements zzapa {
    private static final zzajy zzb;
    private static volatile zzapg zze;
    private int zzg;
    private int zzh;
    private String zzf = "";
    private zzanz zzi = zzas();

    static {
        zzajy zzajyVar = new zzajy();
        zzb = zzajyVar;
        zzanr.zzaA(zzajy.class, zzajyVar);
    }

    private zzajy() {
    }

    public final int zza() {
        return this.zzh;
    }

    public final int zzc() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzi;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004\u001b", new Object[]{"zzf", "zzg", "zzh", "zzi", zzajf.class});
        }
        if (i2 == 3) {
            return new zzajy();
        }
        zzajw zzajwVar = null;
        if (i2 == 4) {
            return new zzajx(zzajwVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzajy.class) {
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
