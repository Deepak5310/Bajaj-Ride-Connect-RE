package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaet extends zzanr implements zzapa {
    private static final zzaet zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzi;
    private int zzj;
    private long zzk;
    private boolean zzm;
    private zzanz zzh = zzanr.zzas();
    private String zzl = "";

    static {
        zzaet zzaetVar = new zzaet();
        zzb = zzaetVar;
        zzanr.zzaA(zzaet.class, zzaetVar);
    }

    private zzaet() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001a\u0003င\u0001\u0004᠌\u0002\u0005ဂ\u0003\u0006ဈ\u0004\u0007ဇ\u0005", new Object[]{"zzf", "zzg", zzacl.zza, "zzh", "zzi", "zzj", zzaew.zza, "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzaet();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaes(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaet.class) {
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
