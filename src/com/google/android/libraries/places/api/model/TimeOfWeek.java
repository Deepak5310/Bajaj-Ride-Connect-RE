package com.google.android.libraries.places.api.model;

import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TimeOfWeek implements Parcelable {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static abstract class Builder {
        public abstract TimeOfWeek build();

        public abstract LocalDate getDate();

        public abstract DayOfWeek getDay();

        public abstract LocalTime getTime();

        public abstract boolean isTruncated();

        public abstract Builder setDate(LocalDate localDate);

        public abstract Builder setDay(DayOfWeek dayOfWeek);

        public abstract Builder setTime(LocalTime localTime);

        public abstract Builder setTruncated(boolean z);
    }

    public static Builder builder(DayOfWeek dayOfWeek, LocalTime localTime) {
        zzah zzahVar = new zzah();
        zzahVar.setDay(dayOfWeek);
        zzahVar.setTime(localTime);
        zzahVar.setTruncated(false);
        return zzahVar;
    }

    public static TimeOfWeek newInstance(DayOfWeek dayOfWeek, LocalTime localTime) {
        return builder(dayOfWeek, localTime).build();
    }

    public abstract LocalDate getDate();

    public abstract DayOfWeek getDay();

    public abstract LocalTime getTime();

    public abstract boolean isTruncated();
}
