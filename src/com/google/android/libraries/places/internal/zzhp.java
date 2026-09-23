package com.google.android.libraries.places.internal;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhp implements zzht {
    private Context zza;
    private zzhw zzb;
    private zzid zzc;

    private zzhp() {
    }

    /* synthetic */ zzhp(zzho zzhoVar) {
    }

    @Override // com.google.android.libraries.places.internal.zzht
    public final /* synthetic */ zzht zza(zzhw zzhwVar) {
        this.zzb = zzhwVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzht
    public final /* synthetic */ zzht zzb(zzid zzidVar) {
        this.zzc = zzidVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzht
    public final /* synthetic */ zzht zzc(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzht
    public final zzhu zzd() {
        zzarp.zzb(this.zza, Context.class);
        zzarp.zzb(this.zzb, zzhw.class);
        zzarp.zzb(this.zzc, zzid.class);
        return new zzhr(this.zza, this.zzb, this.zzc, null);
    }
}
