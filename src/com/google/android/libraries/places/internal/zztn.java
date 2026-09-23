package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zztn extends zzanr implements zzapa {
    private static final zztn zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzco zzg;
    private zztj zzh;
    private zzanz zzi = zzas();
    private int zzj;
    private int zzk;

    static {
        zztn zztnVar = new zztn();
        zzb = zztnVar;
        zzanr.zzaA(zztn.class, zztnVar);
    }

    private zztn() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0001\u0002\u001b\u0003᠌\u0002\u0004᠌\u0003\u0005ဉ\u0000", new Object[]{"zzf", "zzh", "zzi", zzth.class, "zzj", zztm.zza, "zzk", zztl.zza, "zzg"});
        }
        if (i2 == 3) {
            return new zztn();
        }
        zztf zztfVar = null;
        if (i2 == 4) {
            return new zztk(zztfVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zztn.class) {
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
