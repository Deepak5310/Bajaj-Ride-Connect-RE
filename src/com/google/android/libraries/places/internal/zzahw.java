package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzahw extends zzanr implements zzapa {
    private static final zzahw zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzari zzg;
    private zzari zzh;

    static {
        zzahw zzahwVar = new zzahw();
        zzb = zzahwVar;
        zzanr.zzaA(zzahw.class, zzahwVar);
    }

    private zzahw() {
    }

    public static zzahv zza() {
        return (zzahv) zzb.zzam();
    }

    public static zzahw zzd() {
        return zzb;
    }

    static /* synthetic */ void zzg(zzahw zzahwVar, zzari zzariVar) {
        zzariVar.getClass();
        zzahwVar.zzg = zzariVar;
        zzahwVar.zzf |= 1;
    }

    static /* synthetic */ void zzh(zzahw zzahwVar, zzari zzariVar) {
        zzariVar.getClass();
        zzahwVar.zzh = zzariVar;
        zzahwVar.zzf |= 2;
    }

    public final zzari zze() {
        zzari zzariVar = this.zzh;
        return zzariVar == null ? zzari.zzf() : zzariVar;
    }

    public final zzari zzf() {
        zzari zzariVar = this.zzg;
        return zzariVar == null ? zzari.zzf() : zzariVar;
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
            return new zzahw();
        }
        zzahu zzahuVar = null;
        if (i2 == 4) {
            return new zzahv(zzahuVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzahw.class) {
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
