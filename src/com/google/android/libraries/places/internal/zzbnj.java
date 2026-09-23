package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnj implements zzbnn {
    private static final Logger zza = Logger.getLogger(zzbng.class.getName());
    private static final zzbpp zzb;

    static {
        zzbpo zzbpoVar = zzbpp.zza;
        zzb = zzbpo.zza("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    }

    static /* bridge */ /* synthetic */ int zza(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return i - s;
        }
        throw zzi("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    static /* bridge */ /* synthetic */ int zzb(zzbpn zzbpnVar) {
        return (zzbpnVar.zzc() & 255) | ((zzbpnVar.zzc() & 255) << 16) | ((zzbpnVar.zzc() & 255) << 8);
    }

    static /* bridge */ /* synthetic */ IllegalArgumentException zzf(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IOException zzi(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    @Override // com.google.android.libraries.places.internal.zzbnn
    public final zzbmz zzc(zzbpn zzbpnVar, boolean z) {
        return new zzbnh(zzbpnVar, 4096, true);
    }

    @Override // com.google.android.libraries.places.internal.zzbnn
    public final zzbna zzd(zzbpm zzbpmVar, boolean z) {
        return new zzbni(zzbpmVar, true);
    }
}
