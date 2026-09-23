package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class StreetViewSource extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new z();
    public static final StreetViewSource DEFAULT = new StreetViewSource(0);
    public static final StreetViewSource OUTDOOR = new StreetViewSource(1);
    public final int a;

    public StreetViewSource(int i) {
        this.a = i;
    }

    public static boolean a(int i) {
        return i == 0 || i == 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.a == ((StreetViewSource) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a)});
    }

    public String toString() {
        String str;
        int i = this.a;
        if (i != 0) {
            str = i != 1 ? String.format("UNKNOWN(%s)", Integer.valueOf(i)) : "OUTDOOR";
        } else {
            str = "DEFAULT";
        }
        return String.format("StreetViewSource:%s", str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, i2);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
