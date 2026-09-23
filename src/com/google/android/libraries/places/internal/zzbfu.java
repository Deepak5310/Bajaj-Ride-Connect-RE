package com.google.android.libraries.places.internal;

import io.grpc.internal.GrpcUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfu extends zzavh {
    private static final Method zzp;
    final zzawq zzc;
    final zzawf zzd;
    final String zze;
    final String zzf;
    final zzatg zzg;
    final zzast zzh;
    final long zzi;
    final zzatx zzj;
    final zzbjs zzk;
    final zzbjs zzl;
    private final List zzq;
    private final zzbft zzr;
    private final zzbfs zzs;
    private static final Logger zzm = Logger.getLogger(zzbfu.class.getName());
    static final long zza = TimeUnit.MINUTES.toMillis(30);
    static final long zzb = TimeUnit.SECONDS.toMillis(1);
    private static final zzbjs zzt = zzbjs.zza(zzbcu.zzp);
    private static final zzatg zzn = zzatg.zzb();
    private static final zzast zzo = zzast.zza();

    static {
        Method declaredMethod = null;
        try {
            declaredMethod = Class.forName("com.google.android.libraries.places.internal.zzaxp").getDeclaredMethod("getClientInterceptor", Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE);
        } catch (ClassNotFoundException e) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e);
        } catch (NoSuchMethodException e2) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e2);
        }
        zzp = declaredMethod;
    }

    public zzbfu(String str, @Nullable zzasc zzascVar, @Nullable zzarw zzarwVar, zzbft zzbftVar, @Nullable zzbfs zzbfsVar) {
        zzbjs zzbjsVar = zzt;
        this.zzk = zzbjsVar;
        this.zzl = zzbjsVar;
        this.zzq = new ArrayList();
        zzawq zzawqVarZzb = zzawq.zzb();
        this.zzc = zzawqVarZzb;
        this.zzd = zzawqVarZzb.zza();
        this.zzf = GrpcUtil.DEFAULT_LB_POLICY;
        this.zzg = zzn;
        this.zzh = zzo;
        this.zzi = zza;
        this.zzj = zzatx.zza();
        zzkt.zzc(str, "target");
        this.zze = str;
        this.zzr = zzbftVar;
        this.zzs = zzbfsVar;
    }

    @Override // com.google.android.libraries.places.internal.zzavh
    public final zzavg zza() {
        zzasg zzasgVar;
        zzazn zzaznVarZza = this.zzr.zza();
        zzbca zzbcaVar = new zzbca();
        zzbjs zzbjsVarZza = zzbjs.zza(zzbcu.zzp);
        zzlc zzlcVar = zzbcu.zzr;
        ArrayList arrayList = new ArrayList(this.zzq);
        Method method = zzp;
        zzasg zzasgVar2 = null;
        if (method != null) {
            try {
                zzasgVar = (zzasg) method.invoke(null, true, true, false, true);
            } catch (IllegalAccessException e) {
                zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e);
                zzasgVar = null;
            } catch (InvocationTargetException e2) {
                zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e2);
                zzasgVar = null;
            }
        } else {
            zzasgVar = null;
        }
        if (zzasgVar != null) {
            arrayList.add(0, zzasgVar);
        }
        try {
            zzasgVar2 = (zzasg) Class.forName("com.google.android.libraries.places.internal.zzaxq").getDeclaredMethod("getClientInterceptor", null).invoke(null, null);
        } catch (ClassNotFoundException e3) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e3);
        } catch (IllegalAccessException e4) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e4);
        } catch (NoSuchMethodException e5) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e5);
        } catch (InvocationTargetException e6) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e6);
        }
        if (zzasgVar2 != null) {
            arrayList.add(0, zzasgVar2);
        }
        return new zzbfw(new zzbfr(this, zzaznVarZza, zzbcaVar, zzbjsVarZza, zzlcVar, arrayList, zzbjy.zza));
    }

    final int zzb() {
        this.zzs.zza();
        return GrpcUtil.DEFAULT_PORT_SSL;
    }
}
