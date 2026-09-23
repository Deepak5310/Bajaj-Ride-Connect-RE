package com.google.android.libraries.places.internal;

import io.grpc.Metadata;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzavs extends zzavp {
    private final zzavt zza;

    /* synthetic */ zzavs(String str, boolean z, zzavt zzavtVar, zzavr zzavrVar) {
        super(str, z, zzavtVar, null);
        zzkt.zzk(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
        zzkt.zzc(zzavtVar, "marshaller");
        this.zza = zzavtVar;
    }

    @Override // com.google.android.libraries.places.internal.zzavp
    final Object zza(byte[] bArr) {
        return this.zza.zza(bArr);
    }

    @Override // com.google.android.libraries.places.internal.zzavp
    final byte[] zzb(Object obj) {
        byte[] bArrZzb = this.zza.zzb(obj);
        zzkt.zzc(bArrZzb, "null marshaller.toAsciiString()");
        return bArrZzb;
    }
}
