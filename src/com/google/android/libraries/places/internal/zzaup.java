package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaup {
    private final List zza;
    private final zzarv zzb;
    private final Object[][] zzc;

    /* synthetic */ zzaup(List list, zzarv zzarvVar, Object[][] objArr, zzauo zzauoVar) {
        zzkt.zzc(list, "addresses are not set");
        this.zza = list;
        zzkt.zzc(zzarvVar, "attrs");
        this.zzb = zzarvVar;
        this.zzc = objArr;
    }

    public static zzaun zza() {
        return new zzaun();
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("addrs", this.zza);
        zzknVarZzb.zzd("attrs", this.zzb);
        zzknVarZzb.zzd("customOptions", Arrays.deepToString(this.zzc));
        return zzknVarZzb.toString();
    }

    public final List zzb() {
        return this.zza;
    }
}
