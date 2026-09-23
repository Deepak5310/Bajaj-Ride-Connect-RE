package com.google.android.libraries.places.internal;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkz implements zzazn {
    final Executor zza;
    final ScheduledExecutorService zzb;
    final zzbkb zzc;

    @Nullable
    final SSLSocketFactory zzd;
    final zzbme zze;
    private final zzayd zzf = new zzayd("keepalive time nanos", Long.MAX_VALUE);
    private boolean zzg;
    private final zzbjs zzh;
    private final zzbjs zzi;

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.concurrent.Executor] */
    /* synthetic */ zzbkz(zzbjs zzbjsVar, zzbjs zzbjsVar2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, zzbme zzbmeVar, int i, boolean z, long j, long j2, int i2, boolean z2, int i3, zzbkb zzbkbVar, boolean z3, zzbky zzbkyVar) {
        this.zzh = zzbjsVar;
        this.zza = zzbjsVar.zzb();
        this.zzi = zzbjsVar2;
        this.zzb = (ScheduledExecutorService) zzbjsVar2.zzb();
        this.zzd = sSLSocketFactory;
        this.zze = zzbmeVar;
        this.zzc = zzbkbVar;
    }

    @Override // com.google.android.libraries.places.internal.zzazn, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.zzg) {
            return;
        }
        this.zzg = true;
        this.zzh.zzc(this.zza);
        this.zzi.zzc(this.zzb);
    }

    @Override // com.google.android.libraries.places.internal.zzazn
    public final zzazw zza(SocketAddress socketAddress, zzazm zzazmVar, zzasd zzasdVar) {
        if (this.zzg) {
            throw new IllegalStateException("The transport factory is closed.");
        }
        return new zzblk(this, (InetSocketAddress) socketAddress, zzazmVar.zzg(), null, zzazmVar.zza(), zzazmVar.zzb(), new zzbkx(this, this.zzf.zza()));
    }

    @Override // com.google.android.libraries.places.internal.zzazn
    public final ScheduledExecutorService zzb() {
        return this.zzb;
    }
}
