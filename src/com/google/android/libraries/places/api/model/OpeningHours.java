package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.internal.zzlx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class OpeningHours implements Parcelable {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static abstract class Builder {
        public OpeningHours build() {
            OpeningHours openingHoursZza = zza();
            Iterator<String> it2 = openingHoursZza.getWeekdayText().iterator();
            while (it2.hasNext()) {
                zzkt.zzo(!TextUtils.isEmpty(it2.next()), "WeekdayText must not contain null or empty values.");
            }
            setPeriods(zzlx.zzj(openingHoursZza.getPeriods()));
            setWeekdayText(zzlx.zzj(openingHoursZza.getWeekdayText()));
            setSpecialDays(zzlx.zzj(openingHoursZza.getSpecialDays()));
            return zza();
        }

        public abstract HoursType getHoursType();

        public abstract List<Period> getPeriods();

        public abstract List<SpecialDay> getSpecialDays();

        public abstract List<String> getWeekdayText();

        public abstract Builder setHoursType(HoursType hoursType);

        public abstract Builder setPeriods(List<Period> list);

        public abstract Builder setSpecialDays(List<SpecialDay> list);

        public abstract Builder setWeekdayText(List<String> list);

        abstract OpeningHours zza();
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public enum HoursType implements Parcelable {
        ACCESS,
        BREAKFAST,
        BRUNCH,
        DELIVERY,
        DINNER,
        DRIVE_THROUGH,
        HAPPY_HOUR,
        KITCHEN,
        LUNCH,
        ONLINE_SERVICE_HOURS,
        PICKUP,
        SENIOR_HOURS,
        TAKEOUT;

        public static final Parcelable.Creator<HoursType> CREATOR = new zzcc();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name());
        }
    }

    public static Builder builder() {
        zzq zzqVar = new zzq();
        zzqVar.setPeriods(new ArrayList());
        zzqVar.setSpecialDays(new ArrayList());
        zzqVar.setWeekdayText(new ArrayList());
        return zzqVar;
    }

    public abstract HoursType getHoursType();

    public abstract List<Period> getPeriods();

    public abstract List<SpecialDay> getSpecialDays();

    public abstract List<String> getWeekdayText();
}
