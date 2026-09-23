package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalq extends zzanr implements zzapa {
    private static final zzalq zzb;
    private static volatile zzapg zze;
    private int zzf = 0;
    private Object zzg;

    static {
        zzalq zzalqVar = new zzalq();
        zzb = zzalqVar;
        zzanr.zzaA(zzalq.class, zzalqVar);
    }

    private zzalq() {
    }

    public static zzalp zza() {
        return (zzalp) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzalq zzalqVar, zzahw zzahwVar) {
        zzahwVar.getClass();
        zzalqVar.zzg = zzahwVar;
        zzalqVar.zzf = 1;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001<\u0000", new Object[]{"zzg", "zzf", zzahw.class});
        }
        if (i2 == 3) {
            return new zzalq();
        }
        zzall zzallVar = null;
        if (i2 == 4) {
            return new zzalp(zzallVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzalq.class) {
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
