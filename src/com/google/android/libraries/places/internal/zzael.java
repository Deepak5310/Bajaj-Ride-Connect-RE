package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzael extends zzanr implements zzapa {
    private static final zzael zzb;
    private static volatile zzapg zze;

    static {
        zzael zzaelVar = new zzael();
        zzb = zzaelVar;
        zzanr.zzaA(zzael.class, zzaelVar);
    }

    private zzael() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzabn zzabnVar = null;
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzael();
        }
        if (i2 == 4) {
            return new zzaek(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzael.class) {
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
