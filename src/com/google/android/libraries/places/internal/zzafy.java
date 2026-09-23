package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzafy extends zzanr implements zzapa {
    private static final zzafy zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzub zzg;
    private int zzh;
    private int zzi;
    private int zzk;
    private byte zzl = 2;
    private String zzj = "";

    static {
        zzafy zzafyVar = new zzafy();
        zzb = zzafyVar;
        zzanr.zzaA(zzafy.class, zzafyVar);
    }

    private zzafy() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ᐉ\u0000\u0002င\u0001\u0003င\u0002\u0004ဈ\u0003\u0005᠌\u0004", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzafx.zza});
        }
        if (i2 == 3) {
            return new zzafy();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzafw(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            this.zzl = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzafy.class) {
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
