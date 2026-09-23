package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkn implements zzbqa {
    private final zzbjj zzc;
    private final zzbko zzd;

    @Nullable
    private zzbqa zzh;

    @Nullable
    private Socket zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private final Object zza = new Object();
    private final zzbpl zzb = new zzbpl();
    private boolean zze = false;
    private boolean zzf = false;
    private boolean zzg = false;

    private zzbkn(zzbjj zzbjjVar, zzbko zzbkoVar, int i) {
        zzkt.zzc(zzbjjVar, "executor");
        this.zzc = zzbjjVar;
        this.zzd = zzbkoVar;
    }

    static zzbkn zzc(zzbjj zzbjjVar, zzbko zzbkoVar, int i) {
        return new zzbkn(zzbjjVar, zzbkoVar, 10000);
    }

    @Override // com.google.android.libraries.places.internal.zzbqa, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.zzg) {
            return;
        }
        this.zzg = true;
        this.zzc.execute(new zzbkj(this));
    }

    @Override // com.google.android.libraries.places.internal.zzbqa, java.io.Flushable
    public final void flush() throws IOException {
        if (this.zzg) {
            throw new IOException("closed");
        }
        int i = zzbpb.zza;
        synchronized (this.zza) {
            if (this.zzf) {
                return;
            }
            this.zzf = true;
            this.zzc.execute(new zzbki(this));
        }
    }

    final void zzm(zzbqa zzbqaVar, Socket socket) {
        zzkt.zzo(this.zzh == null, "AsyncSink's becomeConnected should only be called once.");
        this.zzh = zzbqaVar;
        zzkt.zzc(socket, "socket");
        this.zzi = socket;
    }

    @Override // com.google.android.libraries.places.internal.zzbqa
    public final void zzn(zzbpl zzbplVar, long j) throws IOException {
        if (this.zzg) {
            throw new IOException("closed");
        }
        int i = zzbpb.zza;
        synchronized (this.zza) {
            this.zzb.zzn(zzbplVar, j);
            int i2 = this.zzl + this.zzk;
            this.zzl = i2;
            boolean z = false;
            this.zzk = 0;
            if (this.zzj || i2 <= 10000) {
                if (!this.zze && !this.zzf && this.zzb.zzf() > 0) {
                    this.zze = true;
                }
                return;
            }
            this.zzj = true;
            z = true;
            if (!z) {
                this.zzc.execute(new zzbkh(this));
                return;
            }
            try {
                this.zzi.close();
            } catch (IOException e) {
                this.zzd.zzb(e);
            }
        }
    }
}
