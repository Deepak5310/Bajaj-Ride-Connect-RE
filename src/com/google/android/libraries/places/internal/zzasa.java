package com.google.android.libraries.places.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
public final class zzasa {
    public static final zzasa zza;

    @Nullable
    private final zzatd zzb;

    @Nullable
    private final Executor zzc;
    private final Object[][] zzd;
    private final List zze;

    @Nullable
    private final Boolean zzf;

    @Nullable
    private final Integer zzg;

    @Nullable
    private final Integer zzh;

    static {
        zzarx zzarxVar = new zzarx();
        zzarxVar.zzc = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        zzarxVar.zzd = Collections.emptyList();
        zza = new zzasa(zzarxVar, null);
    }

    /* synthetic */ zzasa(zzarx zzarxVar, zzarz zzarzVar) {
        this.zzb = zzarxVar.zza;
        this.zzc = zzarxVar.zzb;
        this.zzd = zzarxVar.zzc;
        this.zze = zzarxVar.zzd;
        this.zzf = zzarxVar.zze;
        this.zzg = zzarxVar.zzf;
        this.zzh = zzarxVar.zzg;
    }

    private static zzarx zzp(zzasa zzasaVar) {
        zzarx zzarxVar = new zzarx();
        zzarxVar.zza = zzasaVar.zzb;
        zzarxVar.zzb = zzasaVar.zzc;
        zzarxVar.zzc = zzasaVar.zzd;
        zzarxVar.zzd = zzasaVar.zze;
        zzarxVar.zze = zzasaVar.zzf;
        zzarxVar.zzf = zzasaVar.zzg;
        zzarxVar.zzg = zzasaVar.zzh;
        return zzarxVar;
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("deadline", this.zzb);
        zzknVarZzb.zzd("authority", null);
        zzknVarZzb.zzd("callCredentials", null);
        Executor executor = this.zzc;
        zzknVarZzb.zzd("executor", executor != null ? executor.getClass() : null);
        zzknVarZzb.zzd("compressorName", null);
        zzknVarZzb.zzd("customOptions", Arrays.deepToString(this.zzd));
        zzknVarZzb.zze("waitForReady", zzo());
        zzknVarZzb.zzd("maxInboundMessageSize", this.zzg);
        zzknVarZzb.zzd("maxOutboundMessageSize", this.zzh);
        zzknVarZzb.zzd("streamTracerFactories", this.zze);
        return zzknVarZzb.toString();
    }

    public final zzasa zza(@Nullable zzatd zzatdVar) {
        zzarx zzarxVarZzp = zzp(this);
        zzarxVarZzp.zza = zzatdVar;
        return new zzasa(zzarxVarZzp, null);
    }

    public final zzasa zzb(@Nullable Executor executor) {
        zzarx zzarxVarZzp = zzp(this);
        zzarxVarZzp.zzb = executor;
        return new zzasa(zzarxVarZzp, null);
    }

    public final zzasa zzc(int i) {
        zzkt.zzh(i >= 0, "invalid maxsize %s", i);
        zzarx zzarxVarZzp = zzp(this);
        zzarxVarZzp.zzf = Integer.valueOf(i);
        return new zzasa(zzarxVarZzp, null);
    }

    public final zzasa zzd(int i) {
        zzkt.zzh(i >= 0, "invalid maxsize %s", i);
        zzarx zzarxVarZzp = zzp(this);
        zzarxVarZzp.zzg = Integer.valueOf(i);
        return new zzasa(zzarxVarZzp, null);
    }

    public final zzasa zze(zzary zzaryVar, Object obj) {
        zzkt.zzc(zzaryVar, "key");
        zzkt.zzc(obj, "value");
        zzarx zzarxVarZzp = zzp(this);
        int i = 0;
        while (true) {
            Object[][] objArr = this.zzd;
            if (i >= objArr.length) {
                i = -1;
                break;
            }
            if (zzaryVar.equals(objArr[i][0])) {
                break;
            }
            i++;
        }
        zzarxVarZzp.zzc = (Object[][]) Array.newInstance((Class<?>) Object.class, this.zzd.length + (i == -1 ? 1 : 0), 2);
        Object[][] objArr2 = this.zzd;
        System.arraycopy(objArr2, 0, zzarxVarZzp.zzc, 0, objArr2.length);
        if (i == -1) {
            zzarxVarZzp.zzc[this.zzd.length] = new Object[]{zzaryVar, obj};
        } else {
            zzarxVarZzp.zzc[i] = new Object[]{zzaryVar, obj};
        }
        return new zzasa(zzarxVarZzp, null);
    }

    public final zzasa zzf(zzasl zzaslVar) {
        ArrayList arrayList = new ArrayList(this.zze.size() + 1);
        arrayList.addAll(this.zze);
        arrayList.add(zzaslVar);
        zzarx zzarxVarZzp = zzp(this);
        zzarxVarZzp.zzd = Collections.unmodifiableList(arrayList);
        return new zzasa(zzarxVarZzp, null);
    }

    public final zzasa zzg() {
        zzarx zzarxVarZzp = zzp(this);
        zzarxVarZzp.zze = Boolean.TRUE;
        return new zzasa(zzarxVarZzp, null);
    }

    public final zzasa zzh() {
        zzarx zzarxVarZzp = zzp(this);
        zzarxVarZzp.zze = Boolean.FALSE;
        return new zzasa(zzarxVarZzp, null);
    }

    @Nullable
    public final zzatd zzi() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzj() {
        return this.zzg;
    }

    @Nullable
    public final Integer zzk() {
        return this.zzh;
    }

    public final Object zzl(zzary zzaryVar) {
        zzkt.zzc(zzaryVar, "key");
        int i = 0;
        while (true) {
            Object[][] objArr = this.zzd;
            if (i >= objArr.length) {
                zzary.zzb(zzaryVar);
                return null;
            }
            if (zzaryVar.equals(objArr[i][0])) {
                return this.zzd[i][1];
            }
            i++;
        }
    }

    public final List zzm() {
        return this.zze;
    }

    @Nullable
    public final Executor zzn() {
        return this.zzc;
    }

    public final boolean zzo() {
        return Boolean.TRUE.equals(this.zzf);
    }
}
