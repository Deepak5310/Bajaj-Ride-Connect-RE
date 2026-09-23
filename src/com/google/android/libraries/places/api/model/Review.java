package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.internal.zzlb;
import com.google.android.libraries.places.internal.zzpz;
import com.google.android.libraries.places.internal.zzqa;
import com.google.android.libraries.places.internal.zzqb;
import com.google.android.libraries.places.internal.zzqc;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Review implements Parcelable {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static abstract class Builder {
        public Review build() {
            Double rating = zzd().getRating();
            boolean z = false;
            if (rating.doubleValue() >= 1.0d && rating.doubleValue() <= 5.0d) {
                z = true;
            }
            zzkt.zzj(z, "Rating must between 1.0 and 5.0 (inclusive), but was: %s.", rating);
            return zzd();
        }

        public abstract String getOriginalText();

        public abstract String getOriginalTextLanguageCode();

        public abstract String getPublishTime();

        public abstract String getRelativePublishTimeDescription();

        public abstract String getText();

        public abstract String getTextLanguageCode();

        public abstract Builder setOriginalText(String str);

        public abstract Builder setOriginalTextLanguageCode(String str);

        public abstract Builder setPublishTime(String str);

        public abstract Builder setRelativePublishTimeDescription(String str);

        public abstract Builder setText(String str);

        public abstract Builder setTextLanguageCode(String str);

        abstract Builder zza(String str);

        abstract Builder zzb(AuthorAttribution authorAttribution);

        abstract Review zzd();
    }

    public static Builder builder(Double d, AuthorAttribution authorAttribution) {
        String strZzc = zzlb.zzc(authorAttribution.getUri());
        if (strZzc.startsWith("//")) {
            strZzc = "https:".concat(strZzc);
        }
        zzqa zzqaVar = new zzqa("a");
        int i = zzqc.zza;
        zzqaVar.zzc(zzqc.zza(strZzc, zzqb.zza));
        zzqaVar.zzb(authorAttribution.getName());
        zzpz zzpzVarZza = zzqaVar.zza();
        zzad zzadVar = new zzad();
        zzadVar.zzc(d);
        zzadVar.zzb(authorAttribution);
        zzadVar.zza(zzpzVarZza.zza());
        return zzadVar;
    }

    public abstract String getAttribution();

    public abstract AuthorAttribution getAuthorAttribution();

    public abstract String getOriginalText();

    public abstract String getOriginalTextLanguageCode();

    public abstract String getPublishTime();

    public abstract Double getRating();

    public abstract String getRelativePublishTimeDescription();

    public abstract String getText();

    public abstract String getTextLanguageCode();
}
