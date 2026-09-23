package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalu extends zzanr implements zzapa {
    private static final zzalu zzb;
    private static volatile zzapg zze;
    private zzanz zzf = zzas();

    static {
        zzalu zzaluVar = new zzalu();
        zzb = zzaluVar;
        zzanr.zzaA(zzalu.class, zzaluVar);
    }

    private zzalu() {
    }

    public static zzalu zzc() {
        return zzb;
    }

    public final List zzd() {
        return this.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzf", zzalb.class});
        }
        if (i2 == 3) {
            return new zzalu();
        }
        zzals zzalsVar = null;
        if (i2 == 4) {
            return new zzalt(zzalsVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzalu.class) {
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
