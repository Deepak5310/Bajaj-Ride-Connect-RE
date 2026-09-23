package com.google.android.libraries.places.internal;

import io.grpc.Metadata;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzavl extends zzavp {
    private final zzavm zza;

    /* synthetic */ zzavl(String str, boolean z, zzavm zzavmVar, zzavk zzavkVar) {
        super(str, false, zzavmVar, null);
        zzkt.zzk(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
        zzkt.zzc(zzavmVar, "marshaller");
        this.zza = zzavmVar;
    }

    @Override // com.google.android.libraries.places.internal.zzavp
    final Object zza(byte[] bArr) {
        return this.zza.zza(new String(bArr, zzkc.zza));
    }

    @Override // com.google.android.libraries.places.internal.zzavp
    final byte[] zzb(Object obj) {
        String strZzb = this.zza.zzb(obj);
        zzkt.zzc(strZzb, "null marshaller.toAsciiString()");
        return strZzb.getBytes(zzkc.zza);
    }
}
