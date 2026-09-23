package com.google.android.libraries.places.api.model;

import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SpecialDay implements Parcelable {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static abstract class Builder {
        public abstract SpecialDay build();

        public abstract LocalDate getDate();

        public abstract boolean isExceptional();

        public abstract Builder setDate(LocalDate localDate);

        public abstract Builder setExceptional(boolean z);
    }

    public static Builder builder(LocalDate localDate) {
        zzaf zzafVar = new zzaf();
        zzafVar.setDate(localDate);
        zzafVar.setExceptional(false);
        return zzafVar;
    }

    public abstract LocalDate getDate();

    public abstract boolean isExceptional();
}
