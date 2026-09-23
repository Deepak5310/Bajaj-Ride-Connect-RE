package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaxv implements zzbhb {
    @Override // com.google.android.libraries.places.internal.zzbhb, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    protected final void zza(int i) {
        if (zzf() < i) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public void zzb() {
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public void zzc() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public boolean zzd() {
        return false;
    }
}
