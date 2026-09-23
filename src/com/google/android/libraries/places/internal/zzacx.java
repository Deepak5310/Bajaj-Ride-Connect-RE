package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzacx extends zzanr implements zzapa {
    private static final zzacx zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private boolean zzk;
    private zzanz zzh = zzanr.zzas();
    private String zzi = "";
    private String zzj = "";
    private zzanz zzl = zzanr.zzas();

    static {
        zzacx zzacxVar = new zzacx();
        zzb = zzacxVar;
        zzanr.zzaA(zzacx.class, zzacxVar);
    }

    private zzacx() {
    }

    public static zzacw zza() {
        return (zzacw) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzacx zzacxVar, String str) {
        str.getClass();
        zzanz zzanzVar = zzacxVar.zzh;
        if (!zzanzVar.zzc()) {
            zzacxVar.zzh = zzanr.zzat(zzanzVar);
        }
        zzacxVar.zzh.add(str);
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001င\u0000\u0002\u001a\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006\u001a", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzacx();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzacw(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzacx.class) {
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
