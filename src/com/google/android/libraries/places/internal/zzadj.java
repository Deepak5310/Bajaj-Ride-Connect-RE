package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadj extends zzanr implements zzapa {
    private static final zzadj zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzub zzh;
    private zzacx zzi;
    private byte zzj = 2;
    private String zzg = "";

    static {
        zzadj zzadjVar = new zzadj();
        zzb = zzadjVar;
        zzanr.zzaA(zzadj.class, zzadjVar);
    }

    private zzadj() {
    }

    public static zzadi zza() {
        return (zzadi) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzadj zzadjVar, zzacx zzacxVar) {
        zzadjVar.zzi = zzacxVar;
        zzadjVar.zzf |= 4;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001\u0003ဉ\u0002", new Object[]{"zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzadj();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzadi(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            this.zzj = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzadj.class) {
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
