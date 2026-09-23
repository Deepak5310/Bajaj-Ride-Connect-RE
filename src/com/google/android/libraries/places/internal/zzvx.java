package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzvx extends zzanr implements zzapa {
    private static final zzvx zzb;
    private static volatile zzapg zze;
    private int zzf;
    private long zzg;
    private long zzj;
    private long zzk;
    private long zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private int zzr;
    private long zzs;
    private zzva zzt;
    private long zzu;
    private zzwy zzx;
    private zzwy zzy;
    private zzanz zzh = zzas();
    private zzanz zzi = zzas();
    private zzanz zzv = zzas();
    private zzanz zzw = zzas();
    private zzanz zzz = zzas();
    private zzanz zzA = zzas();
    private zzanz zzB = zzas();
    private zzanz zzC = zzas();

    static {
        zzvx zzvxVar = new zzvx();
        zzb = zzvxVar;
        zzanr.zzaA(zzvx.class, zzvxVar);
    }

    private zzvx() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0017\u0000\u0001\u0001\u0018\u0017\u0000\b\u0000\u0001စ\u0000\u0003\u001b\u0004\u001b\u0005ဂ\u0001\u0006ဂ\u0002\u0007ဂ\u0003\bင\u0004\tင\u0005\nဂ\u0006\u000bဂ\u0007\fင\b\rင\t\u000eဂ\n\u000fဉ\u000b\u0010ဂ\f\u0011\u001b\u0012\u001b\u0013ဉ\r\u0014ဉ\u000e\u0015\u001b\u0016\u001b\u0017\u001b\u0018\u001b", new Object[]{"zzf", "zzg", "zzh", zzwe.class, "zzi", zzwg.class, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", zzwr.class, "zzw", zzwr.class, "zzx", "zzy", "zzz", zzvv.class, "zzA", zzvv.class, "zzB", zzwm.class, "zzC", zzwp.class});
        }
        if (i2 == 3) {
            return new zzvx();
        }
        zzur zzurVar = null;
        if (i2 == 4) {
            return new zzvw(zzurVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzvx.class) {
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
