package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalo extends zzanr implements zzapa {
    private static final zzalo zzb;
    private static volatile zzapg zze;
    private int zzf = 0;
    private Object zzg;

    static {
        zzalo zzaloVar = new zzalo();
        zzb = zzaloVar;
        zzanr.zzaA(zzalo.class, zzaloVar);
    }

    private zzalo() {
    }

    public static zzaln zza() {
        return (zzaln) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzalo zzaloVar, zzahw zzahwVar) {
        zzahwVar.getClass();
        zzaloVar.zzg = zzahwVar;
        zzaloVar.zzf = 1;
    }

    static /* synthetic */ void zze(zzalo zzaloVar, zzaji zzajiVar) {
        zzajiVar.getClass();
        zzaloVar.zzg = zzajiVar;
        zzaloVar.zzf = 2;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zzg", "zzf", zzahw.class, zzaji.class});
        }
        if (i2 == 3) {
            return new zzalo();
        }
        zzall zzallVar = null;
        if (i2 == 4) {
            return new zzaln(zzallVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzalo.class) {
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
