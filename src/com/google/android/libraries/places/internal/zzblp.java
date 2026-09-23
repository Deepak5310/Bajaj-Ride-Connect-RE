package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzblp {
    private static final Logger zzb = Logger.getLogger(zzblp.class.getName());
    private static final zzbmt zzc = zzbmt.zze();
    private static final zzblp zzd;
    protected final zzbmt zza;

    static {
        zzblp zzblpVar;
        ClassLoader classLoader = zzblp.class.getClassLoader();
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            zzb.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator", "createNegotiator", "Unable to find Conscrypt. Skipping", (Throwable) e);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e2) {
                zzb.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator", "createNegotiator", "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e2);
                zzblpVar = new zzblp(zzc);
            }
        }
        zzblpVar = new zzblo(zzc);
        zzd = zzblpVar;
    }

    zzblp(zzbmt zzbmtVar) {
        zzkt.zzc(zzbmtVar, "platform");
        this.zza = zzbmtVar;
    }

    public static zzblp zzd() {
        return zzd;
    }

    public String zza(SSLSocket sSLSocket) {
        return this.zza.zza(sSLSocket);
    }

    public String zzb(SSLSocket sSLSocket, String str, @Nullable List list) throws IOException {
        if (list != null) {
            zzc(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String strZza = zza(sSLSocket);
            if (strZza != null) {
                this.zza.zzd(sSLSocket);
                return strZza;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + String.valueOf(list));
        } catch (Throwable th) {
            this.zza.zzd(sSLSocket);
            throw th;
        }
    }

    protected void zzc(SSLSocket sSLSocket, String str, List list) {
        this.zza.zzb(sSLSocket, str, list);
    }
}
