package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaeh extends zzanr implements zzapa {
    private static final zzaeh zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzanz zzg = zzanr.zzas();
    private int zzh;
    private int zzi;
    private zzafg zzj;

    static {
        zzaeh zzaehVar = new zzaeh();
        zzb = zzaehVar;
        zzanr.zzaA(zzaeh.class, zzaehVar);
    }

    private zzaeh() {
    }

    public static zzaeg zza() {
        return (zzaeg) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzaeh zzaehVar, int i) {
        zzaehVar.zzf |= 2;
        zzaehVar.zzi = 1;
    }

    static /* synthetic */ void zze(zzaeh zzaehVar, zzafg zzafgVar) {
        zzafgVar.getClass();
        zzaehVar.zzj = zzafgVar;
        zzaehVar.zzf |= 4;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001a\u0002᠌\u0000\u0003ဋ\u0001\u0004ဉ\u0002", new Object[]{"zzf", "zzg", "zzh", zzacc.zza, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzaeh();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaeg(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaeh.class) {
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
