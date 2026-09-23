package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzku extends zzkx {
    final /* synthetic */ zzkv zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzku(zzkv zzkvVar, zzky zzkyVar, CharSequence charSequence) {
        super(zzkyVar, charSequence);
        this.zza = zzkvVar;
    }

    @Override // com.google.android.libraries.places.internal.zzkx
    final int zzc(int i) {
        return i + 1;
    }

    @Override // com.google.android.libraries.places.internal.zzkx
    final int zzd(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzkt.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            zzkv zzkvVar = this.zza;
            if (zzkvVar.zza.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
