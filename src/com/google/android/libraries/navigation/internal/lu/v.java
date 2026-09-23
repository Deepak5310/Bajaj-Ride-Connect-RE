package com.google.android.libraries.navigation.internal.lu;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public static final Parcelable.Creator<v> CREATOR = new w();
    final int a;

    @Deprecated
    public v(int i) {
        this.a = i;
    }

    public final boolean a() {
        return this.a < 1000;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof v) && this.a == ((v) obj).a;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "LocationAvailability[" + a() + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, this.a);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 6, a());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
