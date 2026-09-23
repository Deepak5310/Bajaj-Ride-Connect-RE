package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadc extends zzanr implements zzapa {
    private static final zzadc zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzacx zzi;
    private zzub zzj;
    private int zzm;
    private int zzn;
    private int zzp;
    private byte zzq = 2;
    private String zzg = "";
    private String zzh = "";
    private int zzk = 1;
    private String zzl = "";
    private String zzo = "";

    static {
        zzadc zzadcVar = new zzadc();
        zzb = zzadcVar;
        zzanr.zzaA(zzadc.class, zzadcVar);
    }

    private zzadc() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzq);
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ᐉ\u0003\u0005᠌\u0004\u0006ဈ\u0005\u0007᠌\u0006\bင\u0007\tဈ\b\n᠌\t", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzacz.zza, "zzl", "zzm", zzadb.zza, "zzn", "zzo", "zzp", zzada.zza});
        }
        if (i2 == 3) {
            return new zzadc();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzacy(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            this.zzq = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzadc.class) {
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
