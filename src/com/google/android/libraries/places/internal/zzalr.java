package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalr extends zzanr implements zzapa {
    private static final zzanx zzb = new zzall();
    private static final zzalr zze;
    private static volatile zzapg zzf;
    private int zzg;
    private int zzk;
    private boolean zzm;
    private double zzn;
    private int zzo;
    private boolean zzq;
    private zzalo zzr;
    private zzalq zzs;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzl = "";
    private zzanw zzp = zzap();

    static {
        zzalr zzalrVar = new zzalr();
        zze = zzalrVar;
        zzanr.zzaA(zzalr.class, zzalrVar);
    }

    private zzalr() {
    }

    public static zzalm zza() {
        return (zzalm) zze.zzam();
    }

    public static zzalr zzd() {
        return zze;
    }

    static /* synthetic */ void zze(zzalr zzalrVar, String str) {
        str.getClass();
        zzalrVar.zzh = str;
    }

    static /* synthetic */ void zzf(zzalr zzalrVar, String str) {
        str.getClass();
        zzalrVar.zzi = str;
    }

    static /* synthetic */ void zzl(zzalr zzalrVar, Iterable iterable) {
        zzanw zzanwVar = zzalrVar.zzp;
        if (!zzanwVar.zzc()) {
            zzalrVar.zzp = zzanr.zzaq(zzanwVar);
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            zzalrVar.zzp.zzh(((zzalh) it2.next()).zza());
        }
    }

    static /* synthetic */ void zzn(zzalr zzalrVar, zzalo zzaloVar) {
        zzaloVar.getClass();
        zzalrVar.zzr = zzaloVar;
        zzalrVar.zzg |= 1;
    }

    static /* synthetic */ void zzo(zzalr zzalrVar, zzalq zzalqVar) {
        zzalqVar.getClass();
        zzalrVar.zzs = zzalqVar;
        zzalrVar.zzg |= 2;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zze, "\u0000\f\u0000\u0001\u0001\u000e\f\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\f\u0006Ȉ\u0007\u0007\t\u0000\n\u0004\u000b,\f\u0007\rဉ\u0000\u000eဉ\u0001", new Object[]{"zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i2 == 3) {
            return new zzalr();
        }
        zzall zzallVar = null;
        if (i2 == 4) {
            return new zzalm(zzallVar);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zzf;
        if (zzannVar == null) {
            synchronized (zzalr.class) {
                zzannVar = zzf;
                if (zzannVar == null) {
                    zzannVar = new zzann(zze);
                    zzf = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
