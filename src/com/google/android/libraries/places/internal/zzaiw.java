package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaiw extends zzanr implements zzapa {
    private static final zzaiw zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private zzaia zzh;
    private zzaia zzi;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private zzaia zzp;
    private zzaid zzq;
    private zzaij zzr;
    private int zzs;
    private int zzt;
    private zzaig zzu;
    private byte zzv = 2;
    private zzanz zzj = zzas();

    static {
        zzaiw zzaiwVar = new zzaiw();
        zzb = zzaiwVar;
        zzanr.zzaA(zzaiw.class, zzaiwVar);
    }

    private zzaiw() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzv);
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u000f\u0000\u0001\u0002\u0010\u000f\u0000\u0001\u0001\u0002ᔄ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005\u001b\u0006င\u0003\u0007င\u0004\bင\u0005\tင\u0006\nင\u0007\u000bဉ\b\fဉ\t\rဉ\n\u000eင\u000b\u000fင\f\u0010ဉ\r", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", zzait.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
        }
        if (i2 == 3) {
            return new zzaiw();
        }
        zzaiu zzaiuVar = null;
        if (i2 == 4) {
            return new zzaiv(zzaiuVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            this.zzv = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaiw.class) {
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
