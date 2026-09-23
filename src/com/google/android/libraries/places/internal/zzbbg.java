package com.google.android.libraries.places.internal;

import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbg implements Runnable {
    final /* synthetic */ InputStream zza;
    final /* synthetic */ zzbbp zzb;

    zzbbg(zzbbp zzbbpVar, InputStream inputStream) {
        this.zzb = zzbbpVar;
        this.zza = inputStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzw(this.zza);
    }
}
