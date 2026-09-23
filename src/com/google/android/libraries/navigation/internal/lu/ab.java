package com.google.android.libraries.navigation.internal.lu;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.location.LocationCompat;
import com.google.android.libraries.navigation.internal.lh.az;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public final List b;
    static final List a = Collections.emptyList();
    public static final Parcelable.Creator<ab> CREATOR = new ac();

    public ab(List list) {
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        if (Build.VERSION.SDK_INT >= 31) {
            return this.b.equals(abVar.b);
        }
        if (this.b.size() != abVar.b.size()) {
            return false;
        }
        Iterator it2 = abVar.b.iterator();
        for (Location location : this.b) {
            Location location2 = (Location) it2.next();
            if (Double.compare(location.getLatitude(), location2.getLatitude()) != 0 || Double.compare(location.getLongitude(), location2.getLongitude()) != 0 || location.getTime() != location2.getTime() || location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos() || !az.a(location.getProvider(), location2.getProvider())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LocationResult");
        List<Location> list = this.b;
        sb.ensureCapacity(list.size() * 100);
        sb.append("[");
        boolean z = false;
        for (Location location : list) {
            sb.ensureCapacity(100);
            if (location == null) {
                sb.append((String) null);
            } else {
                sb.append("{");
                if (!TextUtils.isEmpty(location.getProvider())) {
                    sb.append(location.getProvider());
                    sb.append(", ");
                }
                if (LocationCompat.isMock(location)) {
                    sb.append("mock, ");
                }
                sb.append(ad.a.format(location.getLatitude()));
                sb.append(",");
                sb.append(ad.a.format(location.getLongitude()));
                if (location.hasAccuracy()) {
                    sb.append("±");
                    sb.append(ad.b.format(location.getAccuracy()));
                    sb.append("m");
                }
                if (location.hasAltitude()) {
                    sb.append(", alt=");
                    sb.append(ad.b.format(location.getAltitude()));
                    if (LocationCompat.hasVerticalAccuracy(location)) {
                        sb.append("±");
                        sb.append(ad.b.format(LocationCompat.getVerticalAccuracyMeters(location)));
                    }
                    sb.append("m");
                }
                if (location.hasSpeed()) {
                    sb.append(", spd=");
                    sb.append(ad.b.format(location.getSpeed()));
                    if (LocationCompat.hasSpeedAccuracy(location)) {
                        sb.append("±");
                        sb.append(ad.b.format(LocationCompat.getSpeedAccuracyMetersPerSecond(location)));
                    }
                    sb.append("m/s");
                }
                if (location.hasBearing()) {
                    sb.append(", brg=");
                    sb.append(ad.b.format(location.getBearing()));
                    if (LocationCompat.hasBearingAccuracy(location)) {
                        sb.append("±");
                        sb.append(ad.b.format(LocationCompat.getBearingAccuracyDegrees(location)));
                    }
                    sb.append("°");
                }
                Bundle extras = location.getExtras();
                String string = extras != null ? extras.getString("floorLabel") : null;
                if (string != null) {
                    sb.append(", fl=");
                    sb.append(string);
                }
                Bundle extras2 = location.getExtras();
                String string2 = extras2 != null ? extras2.getString("levelId") : null;
                if (string2 != null) {
                    sb.append(", lv=");
                    sb.append(string2);
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
                sb.append(", ert=");
                long elapsedRealtimeMillis = LocationCompat.getElapsedRealtimeMillis(location) + jCurrentTimeMillis;
                sb.append(elapsedRealtimeMillis >= 0 ? com.google.android.libraries.navigation.internal.lw.a.a.format(new Date(elapsedRealtimeMillis)) : Long.toString(elapsedRealtimeMillis));
                sb.append('}');
            }
            sb.append(", ");
            z = true;
        }
        if (z) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        List list = this.b;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.v(parcel, 1, list);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
