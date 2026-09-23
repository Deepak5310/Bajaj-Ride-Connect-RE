package com.google.android.libraries.places.internal;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzazr implements zzazt {
    zzazr() {
    }

    @Override // com.google.android.libraries.places.internal.zzazu
    public final /* bridge */ /* synthetic */ int zza(zzbhb zzbhbVar, int i, Object obj, int i2) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.position() + i);
        zzbhbVar.zzi(byteBuffer);
        byteBuffer.limit(iLimit);
        return 0;
    }
}
