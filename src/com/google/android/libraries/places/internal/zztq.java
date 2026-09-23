package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zztq extends zzanr implements zzapa {
    private static final zztq zzb;
    private static volatile zzapg zze;

    static {
        zztq zztqVar = new zztq();
        zzb = zztqVar;
        zzanr.zzaA(zztq.class, zztqVar);
    }

    private zztq() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzto zztoVar = null;
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zztq();
        }
        if (i2 == 4) {
            return new zztp(zztoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zztq.class) {
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
