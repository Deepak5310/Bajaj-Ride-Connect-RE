package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzkt;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class PhotoMetadata implements Parcelable {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static abstract class Builder {
        public PhotoMetadata build() {
            PhotoMetadata photoMetadataZzb = zzb();
            int width = photoMetadataZzb.getWidth();
            zzkt.zzp(width >= 0, "Width must not be < 0, but was: %s.", width);
            int height = photoMetadataZzb.getHeight();
            zzkt.zzp(height >= 0, "Height must not be < 0, but was: %s.", height);
            zzkt.zzo(!photoMetadataZzb.zza().isEmpty(), "PhotoReference must not be null or empty.");
            return photoMetadataZzb;
        }

        public abstract String getAttributions();

        public abstract AuthorAttributions getAuthorAttributions();

        public abstract int getHeight();

        public abstract int getWidth();

        public abstract Builder setAttributions(String str);

        public abstract Builder setAuthorAttributions(AuthorAttributions authorAttributions);

        public abstract Builder setHeight(int i);

        public abstract Builder setWidth(int i);

        abstract PhotoMetadata zzb();
    }

    public static Builder builder(String str) {
        zzu zzuVar = new zzu();
        zzuVar.zza(str);
        zzuVar.setWidth(0);
        zzuVar.setHeight(0);
        zzuVar.setAttributions("");
        return zzuVar;
    }

    public abstract String getAttributions();

    public abstract AuthorAttributions getAuthorAttributions();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String zza();
}
