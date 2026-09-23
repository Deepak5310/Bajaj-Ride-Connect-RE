package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzblo extends zzblp {
    private static final zzbmk zzb = new zzbmk(null, "setUseSessionTickets", Boolean.TYPE);
    private static final zzbmk zzc = new zzbmk(null, "setHostname", String.class);
    private static final zzbmk zzd = new zzbmk(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
    private static final zzbmk zze = new zzbmk(null, "setAlpnProtocols", byte[].class);
    private static final zzbmk zzf = new zzbmk(byte[].class, "getNpnSelectedProtocol", new Class[0]);
    private static final zzbmk zzg = new zzbmk(null, "setNpnProtocols", byte[].class);
    private static final Method zzh;
    private static final Method zzi;
    private static final Method zzj;
    private static final Method zzk;
    private static final Method zzl;
    private static final Method zzm;
    private static final Constructor zzn;

    static {
        NoSuchMethodException e;
        Method method;
        Method method2;
        Method method3;
        ClassNotFoundException e2;
        Method method4;
        NoSuchMethodException noSuchMethodException;
        ClassNotFoundException classNotFoundException;
        Method method5;
        Method method6;
        Method method7;
        NoSuchMethodException noSuchMethodException2;
        Method method8;
        ClassNotFoundException classNotFoundException2;
        Constructor<?> constructor = null;
        try {
            method2 = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
            try {
                method = SSLParameters.class.getMethod("getApplicationProtocols", null);
                try {
                    method6 = SSLSocket.class.getMethod("getApplicationProtocol", null);
                    try {
                        Class<?> cls = Class.forName("android.net.ssl.SSLSockets");
                        method7 = cls.getMethod("isSupportedSocket", SSLSocket.class);
                        try {
                            method5 = cls.getMethod("setUseSessionTickets", SSLSocket.class, Boolean.TYPE);
                        } catch (ClassNotFoundException e3) {
                            classNotFoundException = e3;
                            method3 = method6;
                            method4 = method7;
                            zzblp.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) classNotFoundException);
                            method5 = null;
                            method6 = method3;
                            method7 = method4;
                        } catch (NoSuchMethodException e4) {
                            noSuchMethodException = e4;
                            method3 = method6;
                            method4 = method7;
                            zzblp.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) noSuchMethodException);
                            method5 = null;
                            method6 = method3;
                            method7 = method4;
                        }
                    } catch (ClassNotFoundException e5) {
                        method4 = null;
                        classNotFoundException = e5;
                        method3 = method6;
                    } catch (NoSuchMethodException e6) {
                        method4 = null;
                        noSuchMethodException = e6;
                        method3 = method6;
                    }
                } catch (ClassNotFoundException e7) {
                    e2 = e7;
                    method3 = null;
                    method4 = method3;
                    classNotFoundException = e2;
                    zzblp.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) classNotFoundException);
                    method5 = null;
                    method6 = method3;
                    method7 = method4;
                    zzj = method2;
                    zzk = method;
                    zzl = method6;
                    zzh = method7;
                    zzi = method5;
                    method8 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    zzm = method8;
                    zzn = constructor;
                } catch (NoSuchMethodException e8) {
                    e = e8;
                    method3 = null;
                    method4 = method3;
                    noSuchMethodException = e;
                    zzblp.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) noSuchMethodException);
                    method5 = null;
                    method6 = method3;
                    method7 = method4;
                    zzj = method2;
                    zzk = method;
                    zzl = method6;
                    zzh = method7;
                    zzi = method5;
                    method8 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    zzm = method8;
                    zzn = constructor;
                }
            } catch (ClassNotFoundException e9) {
                e2 = e9;
                method = null;
                method3 = null;
            } catch (NoSuchMethodException e10) {
                e = e10;
                method = null;
                method3 = null;
            }
        } catch (ClassNotFoundException e11) {
            e2 = e11;
            method = null;
            method2 = null;
            method3 = null;
        } catch (NoSuchMethodException e12) {
            e = e12;
            method = null;
            method2 = null;
            method3 = null;
        }
        zzj = method2;
        zzk = method;
        zzl = method6;
        zzh = method7;
        zzi = method5;
        try {
            method8 = SSLParameters.class.getMethod("setServerNames", List.class);
            try {
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException e13) {
                classNotFoundException2 = e13;
                zzblp.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (Throwable) classNotFoundException2);
            } catch (NoSuchMethodException e14) {
                noSuchMethodException2 = e14;
                zzblp.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (Throwable) noSuchMethodException2);
            }
        } catch (ClassNotFoundException e15) {
            classNotFoundException2 = e15;
            method8 = null;
        } catch (NoSuchMethodException e16) {
            noSuchMethodException2 = e16;
            method8 = null;
        }
        zzm = method8;
        zzn = constructor;
    }

    zzblo(zzbmt zzbmtVar) {
        super(zzbmtVar);
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final String zza(SSLSocket sSLSocket) {
        Method method = zzl;
        if (method != null) {
            try {
                return (String) method.invoke(sSLSocket, null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                if (!(e2.getTargetException() instanceof UnsupportedOperationException)) {
                    throw new RuntimeException(e2);
                }
                zzblp.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Socket unsupported for getApplicationProtocol, will try old methods");
            }
        }
        if (this.zza.zzc() == 1) {
            try {
                byte[] bArr = (byte[]) zzd.zzb(sSLSocket, new Object[0]);
                if (bArr != null) {
                    return new String(bArr, zzbmw.zzb);
                }
            } catch (Exception e3) {
                zzblp.zzb.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getAlpnSelectedProtocol()", (Throwable) e3);
            }
        }
        if (this.zza.zzc() != 3) {
            try {
                byte[] bArr2 = (byte[]) zzf.zzb(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, zzbmw.zzb);
                }
            } catch (Exception e4) {
                zzblp.zzb.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getNpnSelectedProtocol()", (Throwable) e4);
            }
        }
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final String zzb(SSLSocket sSLSocket, String str, List list) throws IOException {
        String strZza = zza(sSLSocket);
        return strZza == null ? super.zzb(sSLSocket, str, list) : strZza;
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    protected final void zzc(SSLSocket sSLSocket, String str, List list) {
        Constructor constructor;
        Method method;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((zzbmu) it2.next()).toString());
        }
        boolean z = false;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (str != null) {
            try {
                try {
                    if (!str.contains("_")) {
                        try {
                            zzkt.zzj(zzbcu.zzf(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
                            Method method2 = zzh;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                zzb.zza(sSLSocket, true);
                            } else {
                                zzi.invoke(null, sSLSocket, true);
                            }
                            Method method3 = zzm;
                            if (method3 == null || (constructor = zzn) == null) {
                                zzc.zza(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(e3);
            }
        }
        Method method4 = zzl;
        if (method4 != null) {
            try {
                method4.invoke(sSLSocket, null);
                zzj.invoke(sSLParameters, strArr);
                z = true;
            } catch (InvocationTargetException e4) {
                if (!(e4.getTargetException() instanceof UnsupportedOperationException)) {
                    throw e4;
                }
                zzblp.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "configureTlsExtensions", "setApplicationProtocol unsupported, will try old methods");
            }
        }
        sSLSocket.setSSLParameters(sSLParameters);
        if (z && (method = zzk) != null && Arrays.equals(strArr, (String[]) method.invoke(sSLSocket.getSSLParameters(), null))) {
            return;
        }
        Object[] objArr = {zzbmt.zzg(list)};
        if (this.zza.zzc() == 1) {
            zze.zzb(sSLSocket, objArr);
        }
        if (this.zza.zzc() == 3) {
            throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
        }
        zzg.zzb(sSLSocket, objArr);
    }
}
