package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbnf implements zzbqc {
    int zza;
    byte zzb;
    int zzc;
    int zzd;
    short zze;
    private final zzbpn zzf;

    public zzbnf(zzbpn zzbpnVar) {
        this.zzf = zzbpnVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbqc, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.libraries.places.internal.zzbqc
    public final long zza(zzbpl zzbplVar, long j) throws IOException {
        int i;
        int iZze;
        do {
            int i2 = this.zzd;
            if (i2 == 0) {
                this.zzf.zzF(this.zze);
                this.zze = (short) 0;
                if ((this.zzb & 4) == 0) {
                    i = this.zzc;
                    int iZzb = zzbnj.zzb(this.zzf);
                    this.zzd = iZzb;
                    this.zza = iZzb;
                    int iZzc = this.zzf.zzc() & 255;
                    this.zzb = (byte) (this.zzf.zzc() & 255);
                    byte b = (byte) iZzc;
                    if (zzbnj.zza.isLoggable(Level.FINE)) {
                        zzbnj.zza.logp(Level.FINE, "io.grpc.okhttp.internal.framed.Http2$ContinuationSource", "readContinuationHeader", zzbng.zza(true, this.zzc, this.zza, b, this.zzb));
                    }
                    iZze = this.zzf.zze() & Integer.MAX_VALUE;
                    this.zzc = iZze;
                    if (b != 9) {
                        throw zzbnj.zzi("%s != TYPE_CONTINUATION", Byte.valueOf(b));
                    }
                }
            } else {
                long jZza = this.zzf.zza(zzbplVar, Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_URI, i2));
                if (jZza != -1) {
                    this.zzd -= (int) jZza;
                    return jZza;
                }
            }
            return -1L;
        } while (iZze == i);
        throw zzbnj.zzi("TYPE_CONTINUATION streamId changed", new Object[0]);
    }
}
