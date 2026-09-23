package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzkt;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AuthorAttribution implements Parcelable {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static abstract class Builder {
        public AuthorAttribution build() {
            zzkt.zzf(!zzb().getName().isEmpty(), "Name must not be empty.");
            return zzb();
        }

        public abstract String getPhotoUri();

        public abstract String getUri();

        public abstract Builder setPhotoUri(String str);

        public abstract Builder setUri(String str);

        abstract AuthorAttribution zzb();
    }

    public static Builder builder(String str) {
        zzd zzdVar = new zzd();
        zzdVar.zza(str);
        return zzdVar;
    }

    public abstract String getName();

    public abstract String getPhotoUri();

    public abstract String getUri();
}
