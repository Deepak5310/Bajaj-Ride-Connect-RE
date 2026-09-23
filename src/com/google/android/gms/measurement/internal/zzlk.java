package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlk implements zzqe {
    final /* synthetic */ zzlw zza;

    zzlk(zzlw zzlwVar) {
        this.zza = zzlwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzqe
    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzO("auto", "_err", bundle);
        } else {
            this.zza.zzQ("auto", "_err", bundle, str);
        }
    }
}
