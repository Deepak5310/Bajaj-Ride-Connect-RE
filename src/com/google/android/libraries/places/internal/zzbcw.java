package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbcw implements zzaug {
    zzbcw() {
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final /* bridge */ /* synthetic */ Object zza(byte[] bArr) {
        if (bArr.length < 3) {
            throw new NumberFormatException("Malformed status code ".concat(new String(bArr, zzauh.zza)));
        }
        return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final /* synthetic */ byte[] zzb(Object obj) {
        throw new UnsupportedOperationException();
    }
}
