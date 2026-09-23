package com.google.android.libraries.places.internal;

import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaxy implements zzbju {
    protected abstract zzaxx zzc();

    protected abstract zzbcj zzd();

    @Override // com.google.android.libraries.places.internal.zzbju
    public boolean zzp() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzr() {
        if (zzd().zzf()) {
            return;
        }
        zzd().zzc();
    }

    protected final void zzs(int i) {
        zzaxx.zzn(zzc(), i);
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzt() {
        zzc().zzv();
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzu(int i) {
        zzaxx.zzo(zzc(), 2);
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzv(zzass zzassVar) {
        zzd().zza(zzassVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzw(InputStream inputStream) {
        try {
            if (!zzd().zzf()) {
                zzd().zze(inputStream);
            }
        } finally {
            zzbcu.zzi(inputStream);
        }
    }
}
