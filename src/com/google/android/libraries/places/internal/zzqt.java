package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzqt extends zzanr implements zzapa {
    private static final zzqt zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private String zzg = "";
    private String zzj = "";

    static {
        zzqt zzqtVar = new zzqt();
        zzb = zzqtVar;
        zzanr.zzaA(zzqt.class, zzqtVar);
    }

    private zzqt() {
    }

    public static zzqo zza() {
        return (zzqo) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzqt zzqtVar, String str) {
        zzqtVar.zzf |= 1;
        zzqtVar.zzg = str;
    }

    static /* synthetic */ void zze(zzqt zzqtVar, int i) {
        zzqtVar.zzf |= 2;
        zzqtVar.zzh = i;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0002\u0004ဈ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007\t᠌\b", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzqp.zza, "zzm", zzqr.zza, "zzn", zzqq.zza, "zzo", zzqs.zza});
        }
        if (i2 == 3) {
            return new zzqt();
        }
        zzqn zzqnVar = null;
        if (i2 == 4) {
            return new zzqo(zzqnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzqt.class) {
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
