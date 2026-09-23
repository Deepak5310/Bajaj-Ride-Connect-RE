package com.google.android.libraries.places.internal;

import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzblk implements zzazw, zzbko, zzblw {
    private static final Map zzc;
    private static final Logger zzd;
    private boolean zzA;
    private zzbcy zzB;
    private boolean zzC;
    private boolean zzD;
    private final SocketFactory zzE;
    private SSLSocketFactory zzF;
    private Socket zzG;
    private int zzH;
    private final Deque zzI;
    private final zzbme zzJ;
    private zzbdy zzK;
    private final Runnable zzL;
    private final int zzM;
    private final zzbke zzN;
    private final zzbcz zzO;
    private zzatv zzP;

    @Nullable
    final zzatq zza;
    int zzb;
    private final InetSocketAddress zze;
    private final String zzf;
    private final String zzg;
    private final Random zzh;
    private final zzlc zzi;
    private final int zzj;
    private final zzbnn zzk;
    private zzbgb zzl;
    private zzbkp zzm;
    private zzblz zzn;
    private final Object zzo;
    private final zzauf zzp;
    private int zzq;
    private final Map zzr;
    private final Executor zzs;
    private final zzbjj zzt;
    private final ScheduledExecutorService zzu;
    private final int zzv;
    private int zzw;
    private zzblj zzx;
    private zzarv zzy;
    private zzaxd zzz;

    static {
        EnumMap enumMap = new EnumMap(zzbmx.class);
        enumMap.put(zzbmx.NO_ERROR, zzaxd.zzo.zzg("No error: A GRPC status of OK should have been sent"));
        enumMap.put(zzbmx.PROTOCOL_ERROR, zzaxd.zzo.zzg("Protocol error"));
        enumMap.put(zzbmx.INTERNAL_ERROR, zzaxd.zzo.zzg("Internal error"));
        enumMap.put(zzbmx.FLOW_CONTROL_ERROR, zzaxd.zzo.zzg("Flow control error"));
        enumMap.put(zzbmx.STREAM_CLOSED, zzaxd.zzo.zzg("Stream closed"));
        enumMap.put(zzbmx.FRAME_TOO_LARGE, zzaxd.zzo.zzg("Frame too large"));
        enumMap.put(zzbmx.REFUSED_STREAM, zzaxd.zzp.zzg("Refused stream"));
        enumMap.put(zzbmx.CANCEL, zzaxd.zzb.zzg("Cancelled"));
        enumMap.put(zzbmx.COMPRESSION_ERROR, zzaxd.zzo.zzg("Compression error"));
        enumMap.put(zzbmx.CONNECT_ERROR, zzaxd.zzo.zzg("Connect error"));
        enumMap.put(zzbmx.ENHANCE_YOUR_CALM, zzaxd.zzj.zzg("Enhance your calm"));
        enumMap.put(zzbmx.INADEQUATE_SECURITY, zzaxd.zzh.zzg("Inadequate security"));
        zzc = Collections.unmodifiableMap(enumMap);
        zzd = Logger.getLogger(zzblk.class.getName());
    }

    public zzblk(zzbkz zzbkzVar, InetSocketAddress inetSocketAddress, String str, @Nullable String str2, zzarv zzarvVar, @Nullable zzatq zzatqVar, Runnable runnable) {
        zzlc zzlcVar = zzbcu.zzr;
        zzbnj zzbnjVar = new zzbnj();
        this.zzh = new Random();
        Object obj = new Object();
        this.zzo = obj;
        this.zzr = new HashMap();
        this.zzH = 0;
        this.zzI = new LinkedList();
        this.zzO = new zzble(this);
        this.zzb = HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
        zzkt.zzc(inetSocketAddress, PlaceTypes.ADDRESS);
        this.zze = inetSocketAddress;
        this.zzf = str;
        this.zzv = 4194304;
        this.zzj = 65535;
        Executor executor = zzbkzVar.zza;
        zzkt.zzc(executor, "executor");
        this.zzs = executor;
        this.zzt = new zzbjj(zzbkzVar.zza);
        ScheduledExecutorService scheduledExecutorService = zzbkzVar.zzb;
        zzkt.zzc(scheduledExecutorService, "scheduledExecutorService");
        this.zzu = scheduledExecutorService;
        this.zzq = 3;
        this.zzE = SocketFactory.getDefault();
        this.zzF = zzbkzVar.zzd;
        zzbme zzbmeVar = zzbkzVar.zze;
        zzkt.zzc(zzbmeVar, "connectionSpec");
        this.zzJ = zzbmeVar;
        zzkt.zzc(zzlcVar, "stopwatchFactory");
        this.zzi = zzlcVar;
        this.zzk = zzbnjVar;
        this.zzg = "grpc-java-okhttp/1.60.0-SNAPSHOT";
        this.zza = zzatqVar;
        this.zzL = runnable;
        this.zzM = Integer.MAX_VALUE;
        zzbke zzbkeVarZza = zzbkzVar.zzc.zza();
        this.zzN = zzbkeVarZza;
        this.zzp = zzauf.zzb(getClass(), inetSocketAddress.toString());
        zzars zzarsVarZza = zzarv.zza();
        zzarsVarZza.zzb(zzbck.zzb, zzarvVar);
        this.zzy = zzarsVarZza.zzc();
        synchronized (obj) {
            zzbkeVarZza.zzf(new zzblf(this));
        }
    }

    static /* bridge */ /* synthetic */ Socket zzA(zzblk zzblkVar, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws zzaxe {
        Socket socketCreateSocket;
        int i;
        String strSubstring;
        try {
            socketCreateSocket = inetSocketAddress2.getAddress() != null ? zzblkVar.zzE.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : zzblkVar.zzE.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            try {
                socketCreateSocket.setTcpNoDelay(true);
                socketCreateSocket.setSoTimeout(zzblkVar.zzb);
                zzbqc zzbqcVarZzd = zzbpr.zzd(socketCreateSocket);
                zzbpm zzbpmVarZza = zzbpr.zza(zzbpr.zzc(socketCreateSocket));
                zzbno zzbnoVar = new zzbno();
                zzbnoVar.zzd(UriUtil.HTTPS_SCHEME);
                zzbnoVar.zzb(inetSocketAddress.getHostName());
                zzbnoVar.zzc(inetSocketAddress.getPort());
                zzbnq zzbnqVarZze = zzbnoVar.zze();
                zzbnr zzbnrVar = new zzbnr();
                zzbnrVar.zzd(zzbnqVarZze);
                zzbnrVar.zzc(HttpHeaders.HOST, zzbnqVarZze.zzd() + ":" + zzbnqVarZze.zzc());
                zzbnrVar.zzc(HttpHeaders.USER_AGENT, zzblkVar.zzg);
                if (str != null && str2 != null) {
                    try {
                        byte[] bytes = (str + ":" + str2).getBytes(CharEncoding.ISO_8859_1);
                        zzbpo zzbpoVar = zzbpp.zza;
                        zzbnrVar.zzc(HttpHeaders.PROXY_AUTHORIZATION, "Basic " + zzbpo.zzb(bytes).zzd());
                    } catch (UnsupportedEncodingException unused) {
                        throw new AssertionError();
                    }
                }
                zzbnt zzbntVarZze = zzbnrVar.zze();
                zzbnq zzbnqVarZzb = zzbntVarZze.zzb();
                zzbpmVarZza.zzx(String.format(Locale.US, "CONNECT %s:%d HTTP/1.1", zzbnqVarZzb.zzd(), Integer.valueOf(zzbnqVarZzb.zzc())));
                zzbpmVarZza.zzx("\r\n");
                int iZza = zzbntVarZze.zza().zza();
                for (int i2 = 0; i2 < iZza; i2++) {
                    zzbpmVarZza.zzx(zzbntVarZze.zza().zzb(i2));
                    zzbpmVarZza.zzx(": ");
                    zzbpmVarZza.zzx(zzbntVarZze.zza().zzc(i2));
                    zzbpmVarZza.zzx("\r\n");
                }
                zzbpmVarZza.zzx("\r\n");
                zzbpmVarZza.flush();
                String strZzW = zzW(zzbqcVarZzd);
                if (strZzW.startsWith("HTTP/1.")) {
                    i = 9;
                    if (strZzW.length() < 9 || strZzW.charAt(8) != ' ') {
                        throw new ProtocolException("Unexpected status line: ".concat(strZzW));
                    }
                    int iCharAt = strZzW.charAt(7) - '0';
                    if (iCharAt != 0 && iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(strZzW));
                    }
                    zzbmu zzbmuVar = zzbmu.HTTP_1_0;
                } else {
                    if (!strZzW.startsWith("ICY ")) {
                        throw new ProtocolException("Unexpected status line: ".concat(strZzW));
                    }
                    zzbmu zzbmuVar2 = zzbmu.HTTP_1_0;
                    i = 4;
                }
                int i3 = i + 3;
                if (strZzW.length() < i3) {
                    throw new ProtocolException("Unexpected status line: ".concat(strZzW));
                }
                try {
                    int i4 = Integer.parseInt(strZzW.substring(i, i3));
                    if (strZzW.length() <= i3) {
                        strSubstring = "";
                    } else {
                        if (strZzW.charAt(i3) != ' ') {
                            throw new ProtocolException("Unexpected status line: ".concat(strZzW));
                        }
                        strSubstring = strZzW.substring(i + 4);
                    }
                    while (!zzW(zzbqcVarZzd).equals("")) {
                    }
                    if (i4 >= 200 && i4 < 300) {
                        socketCreateSocket.setSoTimeout(0);
                        return socketCreateSocket;
                    }
                    zzbpl zzbplVar = new zzbpl();
                    try {
                        socketCreateSocket.shutdownOutput();
                        zzbqcVarZzd.zza(zzbplVar, 1024L);
                    } catch (IOException e) {
                        zzbplVar.zzs("Unable to read body: " + e.toString());
                    }
                    try {
                        socketCreateSocket.close();
                    } catch (IOException unused2) {
                    }
                    throw new zzaxe(zzaxd.zzp.zzg(String.format(Locale.US, "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(i4), strSubstring, zzbplVar.zzi())), null);
                } catch (NumberFormatException unused3) {
                    throw new ProtocolException("Unexpected status line: ".concat(strZzW));
                }
            } catch (IOException e2) {
                e = e2;
                if (socketCreateSocket != null) {
                    zzbcu.zzi(socketCreateSocket);
                }
                throw new zzaxe(zzaxd.zzp.zzg("Failed trying to connect with proxy").zzf(e), null);
            }
        } catch (IOException e3) {
            e = e3;
            socketCreateSocket = null;
        }
    }

    private static String zzW(zzbqc zzbqcVar) throws IOException {
        zzbpl zzbplVar = new zzbpl();
        while (zzbqcVar.zza(zzbplVar, 1L) != -1) {
            if (zzbplVar.zzb(zzbplVar.getZzb() - 1) == 10) {
                return zzbplVar.zzj(Long.MAX_VALUE);
            }
        }
        throw new EOFException("\\n not found: ".concat(String.valueOf(zzbplVar.zzy(zzbplVar.getZzb()).zze())));
    }

    private final Throwable zzX() {
        synchronized (this.zzo) {
            zzaxd zzaxdVar = this.zzz;
            if (zzaxdVar != null) {
                return new zzaxe(zzaxdVar, null);
            }
            return new zzaxe(zzaxd.zzp.zzg("Connection closed"), null);
        }
    }

    private final void zzY(zzbld zzbldVar) {
        if (this.zzD && this.zzI.isEmpty() && this.zzr.isEmpty()) {
            this.zzD = false;
            zzbdy zzbdyVar = this.zzK;
            if (zzbdyVar != null) {
                zzbdyVar.zzc();
            }
        }
        if (zzbldVar.zzq()) {
            this.zzO.zzc(zzbldVar, false);
        }
    }

    private final void zzZ(zzbld zzbldVar) {
        if (!this.zzD) {
            this.zzD = true;
            zzbdy zzbdyVar = this.zzK;
            if (zzbdyVar != null) {
                zzbdyVar.zzb();
            }
        }
        if (zzbldVar.zzq()) {
            this.zzO.zzc(zzbldVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(int i, zzbmx zzbmxVar, zzaxd zzaxdVar) {
        synchronized (this.zzo) {
            if (this.zzz == null) {
                this.zzz = zzaxdVar;
                this.zzl.zzc(zzaxdVar);
            }
            if (zzbmxVar != null && !this.zzA) {
                this.zzA = true;
                this.zzm.zzh(0, zzbmxVar, new byte[0]);
            }
            Iterator it2 = this.zzr.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (((Integer) entry.getKey()).intValue() > i) {
                    it2.remove();
                    ((zzbld) entry.getValue()).zzD().zzj(zzaxdVar, zzazj.REFUSED, false, new zzavu());
                    zzY((zzbld) entry.getValue());
                }
            }
            for (zzbld zzbldVar : this.zzI) {
                zzbldVar.zzD().zzj(zzaxdVar, zzazj.MISCARRIED, true, new zzavu());
                zzY(zzbldVar);
            }
            this.zzI.clear();
            zzac();
        }
    }

    private final void zzab(zzbld zzbldVar) {
        zzkt.zzo(zzbldVar.zzD().zzG() == -1, "StreamId already assigned");
        this.zzr.put(Integer.valueOf(this.zzq), zzbldVar);
        zzZ(zzbldVar);
        zzbldVar.zzD().zzN(this.zzq);
        if (zzbldVar.zzx() == zzavy.UNARY || zzbldVar.zzx() == zzavy.SERVER_STREAMING) {
            zzbldVar.zzI();
        } else {
            this.zzm.zzg();
        }
        int i = this.zzq;
        if (i < 2147483645) {
            this.zzq = i + 2;
        } else {
            this.zzq = Integer.MAX_VALUE;
            zzaa(Integer.MAX_VALUE, zzbmx.NO_ERROR, zzaxd.zzp.zzg("Stream ids exhausted"));
        }
    }

    private final void zzac() {
        if (this.zzz == null || !this.zzr.isEmpty() || !this.zzI.isEmpty() || this.zzC) {
            return;
        }
        this.zzC = true;
        zzbdy zzbdyVar = this.zzK;
        if (zzbdyVar != null) {
            zzbdyVar.zzd();
        }
        zzbcy zzbcyVar = this.zzB;
        if (zzbcyVar != null) {
            zzbcyVar.zzb(zzX());
            this.zzB = null;
        }
        if (!this.zzA) {
            this.zzA = true;
            this.zzm.zzh(0, zzbmx.NO_ERROR, new byte[0]);
        }
        this.zzm.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzad() {
        boolean z = false;
        while (!this.zzI.isEmpty() && this.zzr.size() < this.zzH) {
            zzab((zzbld) this.zzI.poll());
            z = true;
        }
        return z;
    }

    static zzaxd zzm(zzbmx zzbmxVar) {
        zzaxd zzaxdVar = (zzaxd) zzc.get(zzbmxVar);
        if (zzaxdVar != null) {
            return zzaxdVar;
        }
        return zzaxd.zzc.zzg("Unknown http2 error code: " + zzbmxVar.zzs);
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzc("logId", this.zzp.zza());
        zzknVarZzb.zzd(PlaceTypes.ADDRESS, this.zze);
        return zzknVarZzb.toString();
    }

    final void zzP(int i, @Nullable zzaxd zzaxdVar, zzazj zzazjVar, boolean z, @Nullable zzbmx zzbmxVar, @Nullable zzavu zzavuVar) {
        synchronized (this.zzo) {
            zzbld zzbldVar = (zzbld) this.zzr.remove(Integer.valueOf(i));
            if (zzbldVar != null) {
                if (zzbmxVar != null) {
                    this.zzm.zzc(i, zzbmx.CANCEL);
                }
                if (zzaxdVar != null) {
                    zzblc zzblcVarZzD = zzbldVar.zzD();
                    if (zzavuVar == null) {
                        zzavuVar = new zzavu();
                    }
                    zzblcVarZzD.zzj(zzaxdVar, zzazjVar, z, zzavuVar);
                }
                if (!zzad()) {
                    zzac();
                    zzY(zzbldVar);
                }
            }
        }
    }

    final void zzQ(zzbld zzbldVar) {
        this.zzI.remove(zzbldVar);
        zzY(zzbldVar);
    }

    final void zzR(zzbld zzbldVar) {
        zzaxd zzaxdVar = this.zzz;
        if (zzaxdVar != null) {
            zzbldVar.zzD().zzj(zzaxdVar, zzazj.MISCARRIED, true, new zzavu());
        } else if (this.zzr.size() < this.zzH) {
            zzab(zzbldVar);
        } else {
            this.zzI.add(zzbldVar);
            zzZ(zzbldVar);
        }
    }

    final boolean zzT() {
        return this.zzF == null;
    }

    final boolean zzU(int i) {
        boolean z;
        synchronized (this.zzo) {
            z = false;
            if (i < this.zzq && (i & 1) == 1) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.places.internal.zzblw
    public final zzblv[] zzV() {
        zzblv[] zzblvVarArr;
        synchronized (this.zzo) {
            zzblvVarArr = new zzblv[this.zzr.size()];
            Iterator it2 = this.zzr.values().iterator();
            int i = 0;
            while (it2.hasNext()) {
                zzblvVarArr[i] = ((zzbld) it2.next()).zzD().zzH();
                i++;
            }
        }
        return zzblvVarArr;
    }

    @Override // com.google.android.libraries.places.internal.zzazl
    public final /* synthetic */ zzazi zza(zzawa zzawaVar, zzavu zzavuVar, zzasa zzasaVar, zzaso[] zzasoVarArr) throws Throwable {
        zzkt.zzc(zzawaVar, FirebaseAnalytics.Param.METHOD);
        zzbjt zzbjtVarZza = zzbjt.zza(zzasoVarArr, this.zzy, zzavuVar);
        synchronized (this.zzo) {
            try {
                try {
                    return new zzbld(zzawaVar, zzavuVar, this.zzm, this, this.zzn, this.zzo, this.zzv, this.zzj, this.zzf, this.zzg, zzbjtVarZza, this.zzN, zzasaVar, false);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbko
    public final void zzb(Throwable th) {
        zzaa(0, zzbmx.INTERNAL_ERROR, zzaxd.zzp.zzf(th));
    }

    @Override // com.google.android.libraries.places.internal.zzauk
    public final zzauf zzc() {
        return this.zzp;
    }

    @Override // com.google.android.libraries.places.internal.zzbgc
    public final void zzd(zzaxd zzaxdVar) {
        synchronized (this.zzo) {
            if (this.zzz != null) {
                return;
            }
            this.zzz = zzaxdVar;
            this.zzl.zzc(zzaxdVar);
            zzac();
        }
    }

    final int zzh() {
        URI uriZzf = zzbcu.zzf(this.zzf);
        return uriZzf.getPort() != -1 ? uriZzf.getPort() : this.zze.getPort();
    }

    @Override // com.google.android.libraries.places.internal.zzbgc
    public final Runnable zzj(zzbgb zzbgbVar) {
        this.zzl = zzbgbVar;
        zzbkn zzbknVarZzc = zzbkn.zzc(this.zzt, this, 10000);
        zzbkk zzbkkVar = new zzbkk(zzbknVarZzc, this.zzk.zzd(zzbpr.zza(zzbknVarZzc), true));
        synchronized (this.zzo) {
            zzbkp zzbkpVar = new zzbkp(this, zzbkkVar);
            this.zzm = zzbkpVar;
            this.zzn = new zzblz(this, zzbkpVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.zzt.execute(new zzblh(this, countDownLatch, zzbknVarZzc));
        try {
            synchronized (this.zzo) {
                this.zzm.zze();
                zzbnm zzbnmVar = new zzbnm();
                zzbnmVar.zze(7, 0, this.zzj);
                this.zzm.zzi(zzbnmVar);
            }
            countDownLatch.countDown();
            this.zzt.execute(new zzbli(this));
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    public final zzarv zzk() {
        return this.zzy;
    }

    final zzbld zzr(int i) {
        zzbld zzbldVar;
        synchronized (this.zzo) {
            zzbldVar = (zzbld) this.zzr.get(Integer.valueOf(i));
        }
        return zzbldVar;
    }

    final String zzy() {
        URI uriZzf = zzbcu.zzf(this.zzf);
        return uriZzf.getHost() != null ? uriZzf.getHost() : this.zzf;
    }
}
