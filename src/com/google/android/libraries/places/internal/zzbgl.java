package com.google.android.libraries.places.internal;

import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgl extends OutputStream {
    final /* synthetic */ zzbgn zza;

    /* synthetic */ zzbgl(zzbgn zzbgnVar, zzbgk zzbgkVar) {
        this.zza = zzbgnVar;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.zza.zzk(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        this.zza.zzk(bArr, i, i2);
    }
}
