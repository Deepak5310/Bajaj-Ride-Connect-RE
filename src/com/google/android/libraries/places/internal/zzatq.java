package com.google.android.libraries.places.internal;

import androidx.autofill.HintConstants;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatq extends zzaws {
    private final SocketAddress zza;
    private final InetSocketAddress zzb;

    @Nullable
    private final String zzc;

    @Nullable
    private final String zzd;

    /* synthetic */ zzatq(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, zzatp zzatpVar) {
        zzkt.zzc(socketAddress, "proxyAddress");
        zzkt.zzc(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            zzkt.zzq(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.zza = socketAddress;
        this.zzb = inetSocketAddress;
        this.zzc = str;
        this.zzd = str2;
    }

    public static zzato zza() {
        return new zzato(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzatq)) {
            return false;
        }
        zzatq zzatqVar = (zzatq) obj;
        return zzkp.zza(this.zza, zzatqVar.zza) && zzkp.zza(this.zzb, zzatqVar.zzb) && zzkp.zza(this.zzc, zzatqVar.zzc) && zzkp.zza(this.zzd, zzatqVar.zzd);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("proxyAddr", this.zza);
        zzknVarZzb.zzd("targetAddr", this.zzb);
        zzknVarZzb.zzd(HintConstants.AUTOFILL_HINT_USERNAME, this.zzc);
        zzknVarZzb.zze("hasPassword", this.zzd != null);
        return zzknVarZzb.toString();
    }

    @Nullable
    public final String zzb() {
        return this.zzd;
    }

    @Nullable
    public final String zzc() {
        return this.zzc;
    }

    public final InetSocketAddress zzd() {
        return this.zzb;
    }

    public final SocketAddress zze() {
        return this.zza;
    }
}
