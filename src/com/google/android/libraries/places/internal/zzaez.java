package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaez extends zzanr implements zzapa {
    private static final zzaez zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzh;
    private boolean zzj;
    private zzanz zzg = zzanr.zzas();
    private String zzi = "";

    static {
        zzaez zzaezVar = new zzaez();
        zzb = zzaezVar;
        zzanr.zzaA(zzaez.class, zzaezVar);
    }

    private zzaez() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001a\u0002᠌\u0000\u0003ဈ\u0001\u0004ဇ\u0002", new Object[]{"zzf", "zzg", "zzh", zzaew.zza, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzaez();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaey(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaez.class) {
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
