package com.google.android.libraries.places.internal;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzato {
    private SocketAddress zza;
    private InetSocketAddress zzb;

    @Nullable
    private String zzc;

    @Nullable
    private String zzd;

    private zzato() {
    }

    /* synthetic */ zzato(zzatn zzatnVar) {
    }

    public final zzato zza(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    public final zzato zzb(SocketAddress socketAddress) {
        zzkt.zzc(socketAddress, "proxyAddress");
        this.zza = socketAddress;
        return this;
    }

    public final zzato zzc(InetSocketAddress inetSocketAddress) {
        zzkt.zzc(inetSocketAddress, "targetAddress");
        this.zzb = inetSocketAddress;
        return this;
    }

    public final zzato zzd(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    public final zzatq zze() {
        return new zzatq(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
