package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfw {
    private Bitmap zza;

    public final zzfy zza() {
        zzkt.zzo(this.zza != null, "Photo must be set to non-null value.");
        return new zzfy(this.zza, null);
    }

    public final zzfw zzb(Bitmap bitmap) {
        this.zza = bitmap;
        return this;
    }
}
