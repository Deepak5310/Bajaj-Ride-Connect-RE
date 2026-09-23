package com.google.android.libraries.places.internal;

import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
public final class zzaxd {
    public static final zzaxd zza;
    public static final zzaxd zzb;
    public static final zzaxd zzc;
    public static final zzaxd zzd;
    public static final zzaxd zze;
    public static final zzaxd zzf;
    public static final zzaxd zzg;
    public static final zzaxd zzh;
    public static final zzaxd zzi;
    public static final zzaxd zzj;
    public static final zzaxd zzk;
    public static final zzaxd zzl;
    public static final zzaxd zzm;
    public static final zzaxd zzn;
    public static final zzaxd zzo;
    public static final zzaxd zzp;
    public static final zzaxd zzq;
    static final zzavp zzr;
    static final zzavp zzs;
    private static final List zzt;
    private static final zzavt zzu;
    private final zzawy zzv;
    private final String zzw;
    private final Throwable zzx;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Boolean.parseBoolean(System.getProperty("io.grpc.Status.failOnEqualsForTest", "false"));
        TreeMap treeMap = new TreeMap();
        zzawy[] zzawyVarArrValues = zzawy.values();
        int length = zzawyVarArrValues.length;
        boolean z = false;
        int i = 0;
        while (true) {
            zzawz zzawzVar = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if (i >= length) {
                zzt = Collections.unmodifiableList(new ArrayList(treeMap.values()));
                zza = zzawy.OK.zzb();
                zzb = zzawy.CANCELLED.zzb();
                zzc = zzawy.UNKNOWN.zzb();
                zzd = zzawy.INVALID_ARGUMENT.zzb();
                zze = zzawy.DEADLINE_EXCEEDED.zzb();
                zzf = zzawy.NOT_FOUND.zzb();
                zzg = zzawy.ALREADY_EXISTS.zzb();
                zzh = zzawy.PERMISSION_DENIED.zzb();
                zzi = zzawy.UNAUTHENTICATED.zzb();
                zzj = zzawy.RESOURCE_EXHAUSTED.zzb();
                zzk = zzawy.FAILED_PRECONDITION.zzb();
                zzl = zzawy.ABORTED.zzb();
                zzm = zzawy.OUT_OF_RANGE.zzb();
                zzn = zzawy.UNIMPLEMENTED.zzb();
                zzo = zzawy.INTERNAL.zzb();
                zzp = zzawy.UNAVAILABLE.zzb();
                zzq = zzawy.DATA_LOSS.zzb();
                zzr = new zzavs("grpc-status", z, new zzaxa(zzawzVar), objArr3 == true ? 1 : 0);
                zzaxc zzaxcVar = new zzaxc(objArr2 == true ? 1 : 0);
                zzu = zzaxcVar;
                zzs = new zzavs("grpc-message", z, zzaxcVar, objArr == true ? 1 : 0);
                return;
            }
            zzawy zzawyVar = zzawyVarArrValues[i];
            zzaxd zzaxdVar = (zzaxd) treeMap.put(Integer.valueOf(zzawyVar.zza()), new zzaxd(zzawyVar, null, null));
            if (zzaxdVar != null) {
                throw new IllegalStateException("Code value duplication between " + zzaxdVar.zzv.name() + " & " + zzawyVar.name());
            }
            i++;
        }
    }

    private zzaxd(zzawy zzawyVar, @Nullable String str, @Nullable Throwable th) {
        zzkt.zzc(zzawyVar, AccountsQueryParameters.CODE);
        this.zzv = zzawyVar;
        this.zzw = str;
        this.zzx = th;
    }

    static /* bridge */ /* synthetic */ zzaxd zzb(byte[] bArr) {
        int i;
        byte b;
        int length = bArr.length;
        char c = 0;
        if (length == 1) {
            if (bArr[0] == 48) {
                return zza;
            }
            length = 1;
        }
        if (length != 1) {
            if (length == 2 && (b = bArr[0]) >= 48 && b <= 57) {
                i = (b - 48) * 10;
                c = 1;
            }
            return zzc.zzg("Unknown code ".concat(new String(bArr, zzkc.zza)));
        }
        i = 0;
        byte b2 = bArr[c];
        if (b2 >= 48 && b2 <= 57) {
            int i2 = i + (b2 - 48);
            List list = zzt;
            if (i2 < list.size()) {
                return (zzaxd) list.get(i2);
            }
        }
        return zzc.zzg("Unknown code ".concat(new String(bArr, zzkc.zza)));
    }

    public static zzaxd zzd(int i) {
        if (i >= 0) {
            List list = zzt;
            if (i < list.size()) {
                return (zzaxd) list.get(i);
            }
        }
        return zzc.zzg("Unknown code " + i);
    }

    public static zzaxd zze(Throwable th) {
        zzkt.zzc(th, "t");
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof zzaxe) {
                return ((zzaxe) cause).zza();
            }
            if (cause instanceof zzaxf) {
                return ((zzaxf) cause).zza();
            }
        }
        return zzc.zzf(th);
    }

    static String zzh(zzaxd zzaxdVar) {
        String str = zzaxdVar.zzw;
        zzawy zzawyVar = zzaxdVar.zzv;
        if (str == null) {
            return zzawyVar.toString();
        }
        return zzawyVar.toString() + ": " + str;
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd(AccountsQueryParameters.CODE, this.zzv.name());
        zzknVarZzb.zzd(SavingTrackHelper.POINT_COL_DESCRIPTION, this.zzw);
        Throwable th = this.zzx;
        Object string = th;
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        }
        zzknVarZzb.zzd("cause", string);
        return zzknVarZzb.toString();
    }

    public final zzawy zza() {
        return this.zzv;
    }

    public final zzaxd zzc(String str) {
        String str2 = this.zzw;
        if (str2 == null) {
            return new zzaxd(this.zzv, str, this.zzx);
        }
        return new zzaxd(this.zzv, str2 + "\n" + str, this.zzx);
    }

    public final zzaxd zzf(Throwable th) {
        return zzkp.zza(this.zzx, th) ? this : new zzaxd(this.zzv, this.zzw, th);
    }

    public final zzaxd zzg(String str) {
        return zzkp.zza(this.zzw, str) ? this : new zzaxd(this.zzv, str, this.zzx);
    }

    @Nullable
    public final String zzi() {
        return this.zzw;
    }

    @Nullable
    public final Throwable zzj() {
        return this.zzx;
    }

    public final boolean zzl() {
        return zzawy.OK == this.zzv;
    }
}
