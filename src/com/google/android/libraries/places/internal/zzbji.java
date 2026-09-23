package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbji extends zzbje {
    private zzbji() {
        super(null);
    }

    /* synthetic */ zzbji(zzbjh zzbjhVar) {
        super(null);
    }

    @Override // com.google.android.libraries.places.internal.zzbje
    public final void zza(zzbjj zzbjjVar, int i) {
        synchronized (zzbjjVar) {
            zzbjjVar.zze = 0;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbje
    public final boolean zzb(zzbjj zzbjjVar, int i, int i2) {
        synchronized (zzbjjVar) {
            if (zzbjjVar.zze != 0) {
                return false;
            }
            zzbjjVar.zze = -1;
            return true;
        }
    }
}
