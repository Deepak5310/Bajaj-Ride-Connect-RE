package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaga extends zzanr implements zzapa {
    private static final zzaga zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private String zzh = "";
    private String zzi = "";

    static {
        zzaga zzagaVar = new zzaga();
        zzb = zzagaVar;
        zzanr.zzaA(zzaga.class, zzagaVar);
    }

    private zzaga() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzf", "zzg", zzabp.zza, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzaga();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzafz(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaga.class) {
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
