package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzajs extends zzanr implements zzapa {
    private static final zzajs zzb;
    private static volatile zzapg zze;
    private zzanz zzf = zzas();

    static {
        zzajs zzajsVar = new zzajs();
        zzb = zzajsVar;
        zzanr.zzaA(zzajs.class, zzajsVar);
    }

    private zzajs() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzf", zzajr.class});
        }
        if (i2 == 3) {
            return new zzajs();
        }
        zzajo zzajoVar = null;
        if (i2 == 4) {
            return new zzajp(zzajoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzajs.class) {
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
