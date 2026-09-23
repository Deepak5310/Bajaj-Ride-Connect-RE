package com.google.android.libraries.places.internal;

import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbha implements zzawt {
    private final zzlc zzc;
    private final InetSocketAddress zzd;
    private final zzbgy zzf;
    private static final Logger zza = Logger.getLogger(zzbha.class.getName());
    private static final zzbgy zze = new zzbgy();
    private static final zzlc zzb = new zzbgz();

    public zzbha() {
        zzlc zzlcVar = zzb;
        zzbgy zzbgyVar = zze;
        String str = System.getenv("GRPC_PROXY_EXP");
        zzlcVar.getClass();
        this.zzc = zzlcVar;
        zzbgyVar.getClass();
        this.zzf = zzbgyVar;
        if (str == null) {
            this.zzd = null;
            return;
        }
        String[] strArrSplit = str.split(":", 2);
        int i = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "overrideProxy", "Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        this.zzd = new InetSocketAddress(strArrSplit[0], i);
    }

    private static final zzaws zzc(InetSocketAddress inetSocketAddress) throws IOException {
        try {
            try {
                URI uri = new URI(UriUtil.HTTPS_SCHEME, null, zzbcu.zze(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = ProxySelector.getDefault();
                if (proxySelector == null) {
                    zza.logp(Level.FINE, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> listSelect = proxySelector.select(uri);
                if (listSelect.size() > 1) {
                    zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = listSelect.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication passwordAuthenticationZza = zzbgy.zza(zzbcu.zze(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), UriUtil.HTTPS_SCHEME, "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                zzato zzatoVarZza = zzatq.zza();
                zzatoVarZza.zzc(inetSocketAddress);
                zzatoVarZza.zzb(inetSocketAddress2);
                if (passwordAuthenticationZza == null) {
                    return zzatoVarZza.zze();
                }
                zzatoVarZza.zzd(passwordAuthenticationZza.getUserName());
                zzatoVarZza.zza(passwordAuthenticationZza.getPassword() != null ? new String(passwordAuthenticationZza.getPassword()) : null);
                return zzatoVarZza.zze();
            } catch (URISyntaxException e) {
                zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e);
                return null;
            }
        } catch (Throwable th) {
            zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzawt
    @Nullable
    public final zzaws zza(SocketAddress socketAddress) throws IOException {
        if (!(socketAddress instanceof InetSocketAddress)) {
            return null;
        }
        InetSocketAddress inetSocketAddress = this.zzd;
        if (inetSocketAddress == null) {
            return zzc((InetSocketAddress) socketAddress);
        }
        zzato zzatoVarZza = zzatq.zza();
        zzatoVarZza.zzb(inetSocketAddress);
        zzatoVarZza.zzc((InetSocketAddress) socketAddress);
        return zzatoVarZza.zze();
    }
}
