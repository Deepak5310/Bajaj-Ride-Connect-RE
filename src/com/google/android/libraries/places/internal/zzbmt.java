package com.google.android.libraries.places.internal;

import com.google.android.gms.security.ProviderInstaller;
import com.mappls.sdk.services.account.Region;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.Provider;
import java.security.Security;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbmt {
    public static final Logger zza = Logger.getLogger(zzbmt.class.getName());
    private static final String[] zzb = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};
    private static final zzbmt zzc = zzh();
    private final Provider zzd;

    public zzbmt(Provider provider) {
        this.zzd = provider;
    }

    public static zzbmt zze() {
        return zzc;
    }

    public static byte[] zzg(List list) {
        zzbpl zzbplVar = new zzbpl();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            zzbmu zzbmuVar = (zzbmu) list.get(i);
            if (zzbmuVar != zzbmu.HTTP_1_0) {
                zzbplVar.zzm(zzbmuVar.toString().length());
                zzbplVar.zzs(zzbmuVar.toString());
            }
        }
        return zzbplVar.zzH(zzbplVar.getZzb());
    }

    private static zzbmt zzh() {
        Method method;
        Provider provider;
        Method method2;
        int i;
        int i2;
        Provider[] providers = Security.getProviders();
        int length = providers.length;
        int i3 = 0;
        loop0: while (true) {
            method = null;
            if (i3 >= length) {
                zza.logp(Level.WARNING, "io.grpc.okhttp.internal.Platform", "getAndroidSecurityProvider", "Unable to find Conscrypt");
                provider = null;
                break;
            }
            Provider provider2 = providers[i3];
            String[] strArr = zzb;
            int length2 = strArr.length;
            for (int i4 = 0; i4 < 5; i4++) {
                String str = strArr[i4];
                if (str.equals(provider2.getClass().getName())) {
                    zza.logp(Level.FINE, "io.grpc.okhttp.internal.Platform", "getAndroidSecurityProvider", "Found registered provider {0}", str);
                    provider = provider2;
                    break loop0;
                }
            }
            i3++;
        }
        if (provider == null) {
            try {
                Provider provider3 = SSLContext.getDefault().getProvider();
                try {
                    try {
                        SSLContext sSLContext = SSLContext.getInstance(Region.REGION_TIMOR_LESTE, provider3);
                        sSLContext.init(null, null, null);
                        ((Method) AccessController.doPrivileged(new zzbml())).invoke(sSLContext.createSSLEngine(), null);
                        return new zzbmq(provider3, (Method) AccessController.doPrivileged(new zzbmm()), (Method) AccessController.doPrivileged(new zzbmn()), null);
                    } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused) {
                        Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                        return new zzbmr(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider3);
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                    return new zzbmt(provider3);
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        zzbmk zzbmkVar = new zzbmk(null, "setUseSessionTickets", Boolean.TYPE);
        zzbmk zzbmkVar2 = new zzbmk(null, "setHostname", String.class);
        zzbmk zzbmkVar3 = new zzbmk(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
        zzbmk zzbmkVar4 = new zzbmk(null, "setAlpnProtocols", byte[].class);
        try {
            Class<?> cls3 = Class.forName("android.net.TrafficStats");
            method2 = cls3.getMethod("tagSocket", Socket.class);
            try {
                method = cls3.getMethod("untagSocket", Socket.class);
            } catch (ClassNotFoundException | NoSuchMethodException unused3) {
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused4) {
            method2 = null;
        }
        Method method3 = method2;
        Method method4 = method;
        if (!provider.getName().equals(ProviderInstaller.PROVIDER_NAME) && !provider.getName().equals("Conscrypt") && !provider.getName().equals("Ssl_Guard")) {
            try {
                zzbmt.class.getClassLoader().loadClass("android.net.Network");
            } catch (ClassNotFoundException e2) {
                zza.logp(Level.FINE, "io.grpc.okhttp.internal.Platform", "isAtLeastAndroid5", "Can't find class", (Throwable) e2);
                try {
                    zzbmt.class.getClassLoader().loadClass("android.app.ActivityOptions");
                    i2 = 2;
                } catch (ClassNotFoundException e3) {
                    zza.logp(Level.FINE, "io.grpc.okhttp.internal.Platform", "isAtLeastAndroid41", "Can't find class", (Throwable) e3);
                    i2 = 3;
                }
                i = i2;
            }
        }
        i = 1;
        return new zzbmo(zzbmkVar, zzbmkVar2, method3, method4, zzbmkVar3, zzbmkVar4, provider, i);
    }

    public String zza(SSLSocket sSLSocket) {
        return null;
    }

    public void zzb(SSLSocket sSLSocket, String str, List list) {
    }

    public int zzc() {
        return 3;
    }

    public void zzd(SSLSocket sSLSocket) {
    }

    public final Provider zzf() {
        return this.zzd;
    }
}
