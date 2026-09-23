package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzblt implements zzbkg {
    zzblt() {
    }

    @Override // com.google.android.libraries.places.internal.zzbkg
    public final zzbkf zza(int i) {
        return new zzbls(new zzbpl(), Math.min(1048576, Math.max(4096, i)));
    }
}
