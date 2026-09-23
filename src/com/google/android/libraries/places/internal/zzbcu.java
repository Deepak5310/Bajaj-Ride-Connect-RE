package com.google.android.libraries.places.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.grpc.internal.GrpcUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbcu {
    public static final zzawt zzm;
    public static final zzawt zzn;
    public static final zzary zzo;
    public static final zzbjq zzp;
    public static final zzbjq zzq;
    public static final zzlc zzr;
    private static final zzaso zzu;
    private static final Logger zzs = Logger.getLogger(zzbcu.class.getName());
    private static final Set zzt = Collections.unmodifiableSet(EnumSet.of(zzawy.OK, zzawy.INVALID_ARGUMENT, zzawy.NOT_FOUND, zzawy.ALREADY_EXISTS, zzawy.FAILED_PRECONDITION, zzawy.ABORTED, zzawy.OUT_OF_RANGE, zzawy.DATA_LOSS));
    public static final Charset zza = Charset.forName(CharEncoding.US_ASCII);
    public static final zzavp zzb = zzavp.zzc(GrpcUtil.TIMEOUT, new zzbct());
    public static final zzavp zzc = zzavp.zzc(GrpcUtil.MESSAGE_ENCODING, zzavu.zzb);
    public static final zzavp zzd = zzauh.zzb(GrpcUtil.MESSAGE_ACCEPT_ENCODING, new zzbcr(null));
    public static final zzavp zze = zzavp.zzc(GrpcUtil.CONTENT_ENCODING, zzavu.zzb);
    public static final zzavp zzf = zzauh.zzb(GrpcUtil.CONTENT_ACCEPT_ENCODING, new zzbcr(null));
    static final zzavp zzg = zzavp.zzc("content-length", zzavu.zzb);
    public static final zzavp zzh = zzavp.zzc("content-type", zzavu.zzb);
    public static final zzavp zzi = zzavp.zzc("te", zzavu.zzb);
    public static final zzavp zzj = zzavp.zzc("user-agent", zzavu.zzb);
    public static final zzky zzk = zzky.zzb(zzkb.zzb(',')).zzc(zzkb.zzc());
    public static final long zzl = TimeUnit.SECONDS.toNanos(20);

    static {
        TimeUnit.HOURS.toNanos(2L);
        TimeUnit.SECONDS.toNanos(20L);
        zzm = new zzbha();
        zzn = new zzbcl();
        zzo = zzary.zza("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        zzu = new zzbcm();
        zzp = new zzbcn();
        zzq = new zzbco();
        zzr = new zzbcp();
    }

    private zzbcu() {
    }

    public static zzaxd zzb(zzaxd zzaxdVar) {
        if (!zzt.contains(zzaxdVar.zza())) {
            return zzaxdVar;
        }
        return zzaxd.zzo.zzg("Inappropriate status code from control plane: " + zzaxdVar.zza().toString() + StringUtils.SPACE + zzaxdVar.zzi()).zzf(zzaxdVar.zzj());
    }

    @Nullable
    static zzazl zzc(zzaut zzautVar, boolean z) {
        zzazl zzazlVarZzh;
        zzauy zzauyVarZze = zzautVar.zze();
        if (zzauyVarZze != null) {
            zzbfo zzbfoVar = (zzbfo) zzauyVarZze;
            zzkt.zzo(zzbfoVar.zzg, "Subchannel is not started");
            zzazlVarZzh = zzbfoVar.zzf.zzh();
        } else {
            zzazlVarZzh = null;
        }
        if (zzazlVarZzh != null) {
            return zzazlVarZzh;
        }
        if (!zzautVar.zzf().zzl()) {
            if (zzautVar.zzg()) {
                return new zzbcd(zzb(zzautVar.zzf()), zzazj.DROPPED);
            }
            if (!z) {
                return new zzbcd(zzb(zzautVar.zzf()), zzazj.PROCESSED);
            }
        }
        return null;
    }

    public static String zzd(String str, int i) {
        try {
            return new URI(null, null, "places.googleapis.com", GrpcUtil.DEFAULT_PORT_SSL, null, null, null).getAuthority();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid host or port: places.googleapis.com 443", e);
        }
    }

    public static String zze(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static URI zzf(String str) {
        zzkt.zzc(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid authority: ".concat(String.valueOf(str)), e);
        }
    }

    public static ThreadFactory zzg(String str, boolean z) {
        zzahr zzahrVar = new zzahr();
        zzahrVar.zza(true);
        zzahrVar.zzb(str);
        return zzahrVar.zzc();
    }

    static void zzh(zzbjv zzbjvVar) {
        while (true) {
            InputStream inputStreamZza = zzbjvVar.zza();
            if (inputStreamZza == null) {
                return;
            } else {
                zzi(inputStreamZza);
            }
        }
    }

    public static void zzi(@Nullable Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            zzs.logp(Level.WARNING, "io.grpc.internal.GrpcUtil", "closeQuietly", "exception caught in closeQuietly", (Throwable) e);
        }
    }

    public static zzaso[] zzj(zzasa zzasaVar, zzavu zzavuVar, int i, boolean z) {
        List listZzm = zzasaVar.zzm();
        int size = listZzm.size();
        zzaso[] zzasoVarArr = new zzaso[size + 1];
        zzasm zzasmVarZza = zzasn.zza();
        zzasmVarZza.zza(zzasaVar);
        zzasmVarZza.zzc(i);
        zzasmVarZza.zzb(z);
        zzasn zzasnVarZzd = zzasmVarZza.zzd();
        for (int i2 = 0; i2 < listZzm.size(); i2++) {
            zzasoVarArr[i2] = ((zzasl) listZzm.get(i2)).zza(zzasnVarZzd, zzavuVar);
        }
        zzasoVarArr[size] = zzu;
        return zzasoVarArr;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0029  */
    /* JADX WARN: Code duplicated, block: B:25:0x0035  */
    public static zzaxd zza(int i) {
        zzawy zzawyVar;
        if ((i >= 100 && i < 200) || i == 400) {
            zzawyVar = zzawy.INTERNAL;
        } else if (i == 401) {
            zzawyVar = zzawy.UNAUTHENTICATED;
        } else if (i == 403) {
            zzawyVar = zzawy.PERMISSION_DENIED;
        } else if (i == 404) {
            zzawyVar = zzawy.UNIMPLEMENTED;
        } else if (i == 429) {
            zzawyVar = zzawy.UNAVAILABLE;
        } else if (i != 431) {
            switch (i) {
                case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                    zzawyVar = zzawy.UNAVAILABLE;
                    break;
                default:
                    zzawyVar = zzawy.UNKNOWN;
                    break;
            }
        } else {
            zzawyVar = zzawy.INTERNAL;
        }
        return zzawyVar.zzb().zzg("HTTP status code " + i);
    }
}
